BEGIN
	DECLARE done INT DEFAULT 0; 			/* 结束标识 */
	DECLARE mainKey VARCHAR(64); 			/* 游标所取的字段值 */
	DECLARE var_userId INT DEFAULT 20001; 		/* 操作员id序列 */
	DECLARE var_userRoleId INT DEFAULT 20003; 	/* 操作员权限关系id序列 */
	DECLARE var_opRoleId INTEGER DEFAULT NULL; 	/* 操作员的角色名对应ID */
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;

	# 定义游标，按用户类型排序
	# -1超级管理员，0：系统管理员，1：代理商管理员，2：售电员，3：备用代理商管理员
	# 角色为空的先不导！
	DECLARE noCur CURSOR FOR SELECT user_id FROM tmp_czy WHERE roleName IS NOT NULL AND roleName <> '' order by user_type;
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
	DELETE FROM uap_user_role WHERE user_id not in (1, 2, 10000);
	UPDATE uap_sequence SET next_val = 20003 WHERE sequence_name = 'userRoleId';
	-- DELETE FROM uap_user_favorite_menu WHERE user_id not in (1, 2, 10000); -- 如果用新操作员登陆过系统，需要清除此处外键
	DELETE FROM uap_user WHERE id not in (1, 2, 10000);
	UPDATE uap_sequence SET next_val = 20001 WHERE sequence_name = 'userId';
	# 开始循环
	REPEAT
	FETCH noCur INTO mainKey;
	IF NOT done THEN
		# 插入UAP_USER
		# 取uap序列
		SET var_userId = (SELECT next_val FROM uap_sequence WHERE sequence_name = 'userId');
		UPDATE uap_sequence SET next_val = next_val + 1 WHERE sequence_name = 'userId';
		INSERT INTO uap_user
		  (id, bind_ip, effective_time_end, effective_time_start, email, insert_time, login_time_end, login_time_start, name,
		  no, password, phone, photo_id, pwd_expiry_time, salt, state, update_time, tenant_id, org_id)
		SELECT
		  var_userId, NULL, AMI_WEB_DATE2NUMBER(CREATE_END), AMI_WEB_DATE2NUMBER(CREATE_TIME), EMAIL, AMI_WEB_DATE2NUMBER(AMI_WEB_GET_SYSDATE()), NULL, NULL, USER_NAME,
		  USER_ACCOUNT, 'CENTLEC123456', TELEPHONE, NULL, NULL, NULL, 3, -- 第一次登陆强制修改密码
		  AMI_WEB_DATE2NUMBER(AMI_WEB_GET_SYSDATE()), 2,
		  IF(CDUArea IS NULL OR CDUArea = '',10000,(SELECT id FROM uap_organization where name = CDUArea)) -- 关联单位id
		FROM tmp_czy WHERE user_id = mainKey;
		# 插入UAP_USER_ROLE
		SET var_opRoleId = (select a.id from uap_role a, tmp_czy b where a.name = b.roleName and b.user_id = mainKey);
		IF(var_opRoleId IS NOT NULL AND var_opRoleId <> '') THEN
			# 取uap序列
			SET var_userRoleId = (SELECT next_val FROM uap_sequence WHERE sequence_name = 'userRoleId');
			UPDATE uap_sequence SET next_val = next_val + 1 WHERE sequence_name = 'userRoleId';
			INSERT INTO uap_user_role
			  (id, role_id, user_id)
			SELECT
			  var_userRoleId, var_opRoleId, var_userId
			FROM DUAL;
		END IF;
		# 插入代理商下操作员
		INSERT INTO vd_agt_agent_operator
			(lessee_id, rel_id, agent_id, opt_id, status, bind_time, unbind_time)
		SELECT
			2, AMI_GET_SEQUENCE('S_AMI_FILE'), b.AGENT_ID, var_userId, '11',
			'2013-08-01 00:00:00', -- 很多业务要求绑定时间必须早于某些业务时间，这里先统一设置成最早时间
			NULL
		FROM tmp_czy a, VD_AGT_AGENT b
		WHERE a.user_id = mainKey AND a.CDUName = b.AGENT_NAME;
	END IF;
	UNTIL done END REPEAT;
	CLOSE noCur;

	# 所有操作员密码统一设置成：CENTLEC123456
	UPDATE UAP_USER SET password = 'CENTLEC123456';

	IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;
	SELECT t_error, msg;
END