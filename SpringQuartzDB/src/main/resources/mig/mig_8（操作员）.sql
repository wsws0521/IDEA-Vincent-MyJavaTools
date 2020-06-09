-- -----------------------------重复的操作员账号：nthabiseng-----------------------------------------
DROP PROCEDURE IF EXISTS mig_8;
delimiter $$
CREATE PROCEDURE mig_8()

BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;

	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

    # 增大email字段长度（后期由王良柏修改ddl脚本）（后来发现又他妈变成32了，而且明明是字段长度溢出，存储过程居然报：）新版本已扩容至512
    # (`centlec`.`uap_user_role`, CONSTRAINT `FK23h1n90aop6lve4n7wyxnrupx` FOREIGN KEY (`user_id`) REFERENCES `uap_user` (`id`))
	CALL PR_MOD_COL('UAP_USER','MODIFY','EMAIL','VARCHAR(512)','','','');

	# 开启事务
	START TRANSACTION;

    -- DELETE FROM uap_user_role WHERE user_id not in (1, 2, 10000, 100001);
	-- DELETE FROM uap_user_favorite_menu WHERE user_id not in (1, 2, 10000); -- 如果用新操作员登陆过系统，需要清除此处外键
	-- DELETE FROM uap_user WHERE id not in (1, 2, 10000);
	# 0-因为UAP的sequence取的比较恶心，需要手动加一，所以临时创建一个sequence，然后使用AMI_GET_SEQUENCE()
	INSERT INTO sequence (NAME, current_value, increment) VALUES ('seq_uap_user', 200000, 1);
	INSERT INTO sequence (NAME, current_value, increment) VALUES ('seq_uap_user_role', 200000, 1);

	# 1-插入UAP_USER
	INSERT INTO uap_user
      (id, bind_ip, effective_time_end, effective_time_start, email, insert_time, login_time_end, login_time_start, name,
      no, password, phone, photo_id, pwd_expiry_time, salt, state, update_time, tenant_id, org_id)
    SELECT
      AMI_GET_SEQUENCE('seq_uap_user'), -- id
      NULL, -- bind_ip
      AMI_WEB_DATE2NUMBER(CREATE_END), -- effective_time_end
      AMI_WEB_DATE2NUMBER(CREATE_TIME), -- effective_time_start
      EMAIL, -- email
      AMI_WEB_DATE2NUMBER(AMI_WEB_GET_SYSDATE()), -- insert_time
      NULL, -- login_time_end
      NULL, -- login_time_start
      USER_NAME, -- name
      USER_ACCOUNT, -- no
      'CENTLEC123456', -- password
      TELEPHONE, -- phone
      NULL, -- photo_id
      NULL, -- pwd_expiry_time
      NULL, -- salt
      3, -- state 第一次登陆强制修改密码
      AMI_WEB_DATE2NUMBER(AMI_WEB_GET_SYSDATE()), -- update_time
      2, -- tenant_id
      IF(CDUArea IS NULL OR CDUArea = '',10000,(SELECT id FROM uap_organization where name = CDUArea)) -- org_id 关联单位id
    FROM tmp_czy
    WHERE roleName IS NOT NULL AND roleName <> '' order by user_type; -- 无视角色为空的czy

	# 2-插入UAP_USER_ROLE（UAP重启才生效）
	INSERT INTO uap_user_role
      (id, role_id, user_id)
    SELECT
      AMI_GET_SEQUENCE('seq_uap_user_role'), -- id
      role.id,
      uu.id
    FROM tmp_czy cc
    INNER JOIN uap_user uu ON uu.no = cc.USER_ACCOUNT -- 无视角色为空的czy
    INNER JOIN uap_role role ON cc.roleName = role.name; -- 角色名称必须能匹配上才绑定！

    # 3-插入代理商下操作员
    INSERT INTO vd_agt_agent_operator
        (lessee_id, rel_id, agent_id, opt_id, status, bind_time, unbind_time)
    SELECT
        2, AMI_GET_SEQUENCE('S_AMI_FILE'), agent.AGENT_ID, uu.id, '11', SYSDATE(), NULL
    FROM tmp_czy cc
    INNER JOIN uap_user uu ON uu.no = cc.USER_ACCOUNT -- 无视角色为空的czy
    INNER JOIN VD_AGT_AGENT agent ON cc.CDUName = agent.AGENT_NAME; -- 确定唯一一个代理商

	# 4-所有操作员密码统一设置成：CENTLEC123456
	UPDATE UAP_USER SET password = 'CENTLEC123456';

	# 5-删除该临时序列
	UPDATE uap_sequence SET next_val = (select current_value + 1 FROM sequence WHERE name = 'seq_uap_user')      WHERE sequence_name = 'userRoleId';
	UPDATE uap_sequence SET next_val = (select current_value + 1 FROM sequence WHERE name = 'seq_uap_user_role') WHERE sequence_name = 'userId';
    DELETE FROM sequence WHERE name = 'seq_uap_user';
    DELETE FROM sequence WHERE name = 'seq_uap_user_role';

	IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;
	SELECT t_error, msg;
END

$$
delimiter ;

CALL mig_8();