BEGIN
	DECLARE done INT DEFAULT 0; 			/* 结束标识 */
	DECLARE mainKey VARCHAR(64); 			/* 游标所取的字段值 */
	DECLARE var_typeFlag INT DEFAULT 0; 	/* 站？线？变？ */
	DECLARE var_zxbFatherId INT DEFAULT 0; 	/* 站线变所属父id */
	DECLARE var_zxbOrgNo VARCHAR(64); 		/* 站线变关联单位 */
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	# 定义游标，注意按object_type由根到叶排序
	DECLARE noCur CURSOR FOR SELECT object_id FROM TMP_ZXB order by object_type;
	# 定义循环结束done值改变逻辑
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;
	# 开启事务
	START TRANSACTION;

	# 打开游标
	OPEN noCur;
	# 删除已有数据
	DELETE FROM a_grid_line_tf;
	DELETE FROM a_grid_subs_line_rela;
	DELETE FROM a_grid_transformer WHERE tf_no like 'SLT_%';
	DELETE FROM a_grid_line WHERE line_no like 'SLT_%';
	DELETE FROM a_grid_subs WHERE subs_no like 'SLT_%';
	# 开始循环
	REPEAT
	FETCH noCur INTO mainKey;
	IF NOT done THEN
		SET var_typeFlag = (SELECT object_type FROM TMP_ZXB WHERE object_id = mainKey);
		CASE
			WHEN var_typeFlag = 2 THEN
				# 变电站
				SET var_zxbOrgNo = (SELECT NO FROM UAP_ORGANIZATION WHERE CODE = CONCAT('ORG_',mainKey));
				INSERT INTO a_grid_subs
					(subs_id, subs_name, subs_no, volt_code, tf_sum, tf_capacity, subs_addr, org_no, run_status_code, chg_date, out_no, sjxl1id, sjxl2id, sjxl3id, sjxl4id, sjxl5id)
				SELECT
					(select AMI_GET_SEQUENCE('S_AMI_FILE') from dual), object_name, CONCAT('SLT_',object_id), NULL, NULL, NULL, NULL,
					var_zxbOrgNo, '01', SYSDATE(), NULL, NULL, NULL, NULL, NULL, NULL
				FROM tmp_zxb WHERE object_id = mainKey;
				# 将新ID更新至临时表
				UPDATE tmp_zxb SET NEWID = (select subs_id from a_grid_subs where subs_no = CONCAT('SLT_',mainKey)) where object_id = mainKey;
			WHEN var_typeFlag = 3 THEN
				# 线路
				SET var_zxbFatherId = (SELECT FatherId FROM tmp_zxb WHERE object_id = mainKey);
				SET var_zxbOrgNo = (SELECT NO FROM UAP_ORGANIZATION WHERE CODE = CONCAT('ORG_',var_zxbFatherId));
				INSERT INTO a_grid_line
					(line_id, org_no, line_no, line_name, wire_spec_code, wire_len, v_grade, is_branch, modify_date,
					ll_calc_mode, ap_ll_value, rp_ll_value, unit_resi, unit_reac, run_status, out_no, line_type, parent_line, parent_subs)
				SELECT
					(select AMI_GET_SEQUENCE('S_AMI_FILE') from dual), var_zxbOrgNo,
					CONCAT('SLT_',object_id), object_name, NULL, NULL, 'AC00101', '02', SYSDATE(),
					NULL, NULL, NULL, NULL, NULL, '01', NULL, NULL, NULL, NULL
				FROM tmp_zxb WHERE object_id = mainKey;
				# 线路-变电站
				INSERT INTO a_grid_subs_line_rela
					(line_id, subs_id, change_date, rela_flag)
				SELECT
					(select line_id from a_grid_line where line_no = CONCAT('SLT_',mainKey)),
					(select subs_id from a_grid_subs where subs_no = CONCAT('SLT_',var_zxbFatherId)), SYSDATE(), 0
				FROM DUAL;
				# 将新ID更新至临时表
				UPDATE tmp_zxb SET NEWID = (select line_id from a_grid_line where line_no = CONCAT('SLT_',mainKey)) where object_id = mainKey;
			WHEN var_typeFlag = 4 THEN
				# 变压器
				SET var_zxbFatherId = (SELECT FatherId FROM tmp_zxb WHERE object_id = mainKey);
				SET var_zxbOrgNo = (SELECT NO FROM UAP_ORGANIZATION WHERE CODE = CONCAT('ORG_',(SELECT fatherId FROM tmp_zxb WHERE object_id = var_zxbFatherId)));
				INSERT INTO a_grid_transformer
					(tf_id, org_no, tfarea_id, tf_no, tf_name, address, ins_date, run_date, tf_model, longitude, latitude, capacity, rated_current, main_standby, ps_flag, run_status,
					OWNER, factory_name, made_no, wire_code, frstside_volt_code, sndside_volt_code, cool_mode, made_date, noload_loss, fullload_loss, duty_person, phone_number, out_no, container_type, equipmentcontainer)
				SELECT
					(select AMI_GET_SEQUENCE('S_AMI_FILE') from dual), var_zxbOrgNo,
					NULL, CONCAT('SLT_',object_id), object_name, NULL, SYSDATE(), NULL, NULL, NULL, NULL, NULL, NULL, NULL, '02', '01',
					NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL
				FROM tmp_zxb WHERE object_id = mainKey;
				# 线路-变压器
				INSERT INTO a_grid_line_tf
					(line_id, tf_id, change_date, is_valid)
				SELECT
					(select line_id from a_grid_line where line_no = CONCAT('SLT_',var_zxbFatherId)),
					(select tf_id from a_grid_transformer where tf_no = CONCAT('SLT_',mainKey)), SYSDATE(), 0
				FROM DUAL;
				# 将新ID更新至临时表
				UPDATE tmp_zxb SET NEWID = (select tf_id from a_grid_transformer where tf_no = CONCAT('SLT_',mainKey)) where object_id = mainKey;
		END CASE;
	END IF;
	UNTIL done END REPEAT;
	CLOSE noCur;

	IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;
	SELECT t_error, msg;
END


------------------------------------sqlserver数据源获取(613)-------------------------------------------

select  cast(OBJECT_ID as varchar) as 'object_id',
        OBJECT_TYPE,
        (case when o.LINE_ID>-1 then o.LINE_ID when o.POWER_SUPPLYER>-1 then o.POWER_SUPPLYER
            when o.REGION_ID>-1 then o.REGION_ID else o.GRID_ID end) as 'FatherId',
        rtrim(replace(OBJECT_NAME,',','-')) as 'OBJECT_NAME',
        '' as 'NEWID'
 from IPARA_OBJECT o
where OBJECT_TYPE > 1 order by OBJECT_NAME,FatherId

-------------------------------------tmp_zxb  自动建表语句-----------------------------------------
CREATE TABLE `tmp_zxb` (
  `object_id` varchar(128) NOT NULL,
  `OBJECT_TYPE` varchar(128) DEFAULT NULL,
  `FatherId` varchar(128) DEFAULT NULL,
  `OBJECT_NAME` varchar(128) DEFAULT NULL,
  `NEWID` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`object_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;






