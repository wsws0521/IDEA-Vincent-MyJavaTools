
	DECLARE done INT DEFAULT 0; 			/* 结束标识 */
	DECLARE mainKey VARCHAR(64); 			/* 游标所取的字段值 */
	DECLARE vccid INT DEFAULT 0; 			/* vd_c_contact的主键 */
	DECLARE certid INT DEFAULT 0; 			/* VD_C_CERT的主键 */
	DECLARE noCur CURSOR FOR SELECT customer_id FROM tmp_yh;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;






	# 5-保存用户银行账号
	INSERT INTO vd_bank_acc
		(lessee_id, acc_id, obj_type, obj_id, bank_id, acc_num, remark)
	SELECT
		2, AMI_GET_SEQUENCE('seq_vd_bank_acc'), '02', -- 对象标识：02用户03代理商
		a.cons_id, NULL, b.bankaccount, '迁移账号'
	FROM a_consumer a, tmp_yh b WHERE a.cons_no = CONCAT('yh_',b.customer_id);



	# 6-保存联系人相关信息
	OPEN noCur;
	REPEAT
	FETCH noCur INTO mainKey;
	IF NOT done THEN
		SELECT AMI_GET_SEQUENCE('seq_vd_c_contact') INTO vccid;
		INSERT INTO vd_c_contact
			(lessee_id, contact_id, contact_name, gender, contact_source)
		SELECT
			2, vccid, customer_name,
			CASE WHEN us_sex = 0 THEN '01'
			ELSE '02'
			END,
			'03' -- 01 合同约定、02 95598、03 客户关系
		FROM tmp_yh WHERE customer_id = mainKey;
		INSERT INTO vd_c_obj_contact_rel
			(lessee_id, rel_id, contact_id, obj_type, obj_id, rel_type, is_no_disturb, no_disturb_time, priority, org_id, remark)
		SELECT
			2, AMI_GET_SEQUENCE('seq_vd_c_obj_contact_rel'), vccid, '02', cons_id,
			'03', -- 关系类型？03
			'1', -- 是否免打扰
			NULL, -- 免打扰时段
			1, -- 优先级
			org_no,
			'迁移数据'
		FROM a_consumer WHERE cons_no = CONCAT('yh_',mainKey);
		INSERT INTO vd_c_contact_info
			(lessee_id, contactinfo_id, contact_id, contact_type, sub_type, addr_no, contact_no, is_default, seq)
		SELECT
			2, AMI_GET_SEQUENCE('seq_vd_c_contact_info'), vccid,
			'02', -- 联系方式:01电话02电子邮件03地址04关系人
			'01', -- 联系子类
			NULL, -- 地址编号
			us_email, '1', 1 -- 排序
		FROM tmp_yh WHERE customer_id = mainKey;
		INSERT INTO vd_c_contact_info
			(lessee_id, contactinfo_id, contact_id, contact_type, sub_type, addr_no, contact_no, is_default, seq)
		SELECT
			2, AMI_GET_SEQUENCE('seq_vd_c_contact_info'), vccid,
			'01', -- 联系方式:01电话02电子邮件03地址04关系人
			'01', -- 联系子类
			NULL, -- 地址编号
			linkman_phone, '1', 2 -- 排序
		FROM tmp_yh WHERE customer_id = mainKey;

		SELECT AMI_GET_SEQUENCE('seq_vd_c_cert') INTO certid;
		INSERT INTO vd_c_cert
			(lessee_id, cert_id, cert_type, cert_name, cert_no, cert_effect_date, cert_expire_date, org_id, UUID)
		SELECT
			2, certid, '01', -- 证件类型01身份证？
			'US_IDNUM', -- 证件名称
			US_IDNUM,
			NULL, -- 生效日期
			NULL, -- 截止日期
			10000, -- 单位统一写根单位，有需求再变更
			NULL -- 文件唯一ID
		FROM tmp_yh WHERE customer_id = mainKey;
		INSERT INTO vd_c_obj_cert_rel
			(lessee_id, rel_id, cert_id, obj_type, obj_id, rel_type, org_id)
		SELECT
			2, AMI_GET_SEQUENCE('seq_vd_c_obj_cert_rel'), certid,
			'02', -- 对象类型:01客户、02用户03代理商04加密盒03表计厂商
			cons_id, NULL, -- 关系类型
			10000
		FROM A_CONSUMER WHERE cons_no = CONCAT('yh_',mainKey);
	END IF;
	UNTIL done END REPEAT;
	CLOSE noCur;






	-- ---------------------------------------------------------------------------------------------------------------------
	DECLARE done INT DEFAULT 0; 			/* 结束标识 */
	DECLARE mainKey VARCHAR(64); 			/* 游标所取的字段值 */

	DECLARE noCur CURSOR FOR SELECT mt_comm_addr FROM tmp_bj;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

	OPEN noCur;
	REPEAT
	FETCH noCur INTO mainKey;
	IF NOT done THEN
		# 查询表计所绑定的用户ID
		SELECT cons_id INTO var_consid
		FROM a_consumer a, tmp_bj b
		WHERE a.cons_no = CONCAT('yh_',b.customer_id)
		AND b.mt_comm_addr = mainKey;
		# 且用户有免费额度（费率）
		SELECT COUNT(1) INTO var_hasfree
		FROM A_CONSUMER a, VD_OFFER_SET_DETAIL b, VD_OFFER_SET c
		WHERE a.cons_id = b.conf_obj_id AND b.conf_id = c.conf_id
			AND c.conf_type = '01' AND c.status = '01' AND c.CONF_OBJECT = '01'
			AND a.cons_id = var_consid;
		# 且表计绑定了用户，且这个时间是当月/空
		SELECT COUNT(1) INTO var_iffreeamt
		FROM tmp_bj
		WHERE mt_comm_addr = mainKey
			AND (lastvendfreedate >= DATE_ADD(CURDATE(), INTERVAL -DAY(CURDATE())+1 DAY) OR lastvendfreedate = '')
			AND customer_id <> '';
		# 那么需要在累计值表中增加一条基于免费类型的累计记录，免费额度使用50kwh。
		IF var_hasfree > 0 AND var_iffreeamt > 0 THEN
			IF (SELECT COUNT(1) FROM vd_c_cumu_value WHERE cumu_obj = '01' AND cumu_obj_id = var_consid) > 0 THEN
				UPDATE vd_c_cumu_value SET cumu_value = cumu_value + 50 WHERE cumu_obj = '01' AND cumu_obj_id = var_consid;
			ELSE
				INSERT INTO vd_c_cumu_value
				(lessee_id, cumu_id, rule_id, cumu_obj, cumu_obj_id, cumu_item, start_time, end_time, cumu_value, value_unit)
				SELECT
				2, AMI_GET_SEQUENCE('SEQ_VD_C_CUMU_VALUE'), NULL, '01', var_consid, '0101',
				DATE_ADD(CURDATE(), INTERVAL -DAY(CURDATE()) + 1 DAY), -- 累计开始时间
				LAST_DAY(CURDATE()), -- 累计结束时间
				50, -- 免费额度使用50kwh
				'KWH'
				FROM DUAL;
			END IF;
		END IF;
	END IF;
	UNTIL done END REPEAT;
	CLOSE noCur;
