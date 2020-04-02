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

    # 增大email字段长度（后期由王良柏修改ddl脚本）
	-- CALL PR_MOD_COL('UAP_USER','MODIFY','EMAIL','VARCHAR(64)','','','');

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
		# 插入UAP_USER_ROLE（UAP重启才生效）
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
			2, AMI_GET_SEQUENCE('S_AMI_FILE'), b.AGENT_ID, var_userId, '11', SYSDATE(), NULL
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

-----------------sqlserver数据源获取（注意处理USER_ACCOUNT相同的记录，必须Unique！！！！）341---------------------------------
-----------------如果uap_user里已经出现了重复no，，建议把610-nthabiseng后缀+1，目测610是离职人员-------------------------------

/*select  cu.USER_ID,
        cu.USER_ACCOUNT,
        cu.USER_NAME,
        cu.user_type,
        cu.TELEPHONE,
        cu.MOBILE_TELEPHONE,
        cu.EMAIL,
        cu.address,
        cu.note,
        cu.CREATE_TIME,
        cu.CREATE_END,
        ltrim(rtrim((case when cu.CDUArea IS null then isnull(mr.REGIONNAME,'') else isnull(cu.CDUArea,'') end))) as CDUArea,
        ltrim(rtrim((case when cu.CDUName IS null then isnull(mc.TE_NAME,'') else isnull(cu.CDUName,'') end))) as CDUName,
        (case when len(cu.roleName)=0 and cu.user_type=2 and mc.MANAGER IS not null then 'Cashier' else cu.roleName end) roleName,
        cu.roles
from (
    select u.CREATER, u.USER_ID,USER_ACCOUNT,USER_NAME,cr.REGIONNAME as CDUArea,c.TE_NAME as CDUName,
    (CASE when USER_TYPE=1 AND c.MANAGER IS null THEN 3 else USER_TYPE END) user_type
    ,TELEPHONE,MOBILE_TELEPHONE,EMAIL,
    replace(ADDRESS,',','.') as [address],replace(u.note,',','.') as [note],CREATE_TIME,CREATE_END
     ,(case when USER_TYPE=1 AND c.MANAGER>0 THEN 'CDU' else isnull(stuff((select '|'+ltrim(rtrim(r.ROLE_NAME))
     from IAUDIT_USER_ROLE ur left join IAUDIT_ROLE r on ur.ROLE_ID=r.ROLE_ID where ur.USER_ID=u.USER_ID and r.ROLE_TYPE=0 for xml path('')),1,1,''),'') end) as roleName
    ,isnull(stuff((select '|'+r.ROLE_NAME+':'+cast(r.ROLE_TYPE as varchar)
     from IAUDIT_USER_ROLE ur left join IAUDIT_ROLE r on ur.ROLE_ID=r.ROLE_ID where ur.USER_ID=u.USER_ID for xml path('')),1,1,''),'') as roles
     from IAUDIT_USER u
     LEFT JOIN IPARA_CDUSTATION c on c.MANAGER=u.USER_ID --and u.USER_TYPE=1
     LEFT JOIN IPARA_CDUREGION cr on cr.REGION_ID=c.REGIOINID
     where u.USER_ID not in (0,42,140)
     --and create_end>=DATEADD(month,-3,getdate())
     ) cu
LEFT JOIN IAUDIT_USER mu on cu.CREATER=mu.USER_ID
LEFT JOIN IPARA_CDUSTATION mc on mc.MANAGER=mu.USER_ID
LEFT JOIN IPARA_CDUREGION mr on mr.REGION_ID=mc.REGIOINID
order by cu.create_TIME desc*/
select cu.USER_ID, cu.USER_ACCOUNT, cu.USER_NAME, cu.user_type, cu.TELEPHONE, cu.MOBILE_TELEPHONE,
cu.EMAIL,cu.address,cu.note,cu.CREATE_TIME,cu.CREATE_END,
ltrim(rtrim((case when cu.CDUArea IS NOT null then isnull(cu.CDUArea,'') WHEN mr.REGIONNAME IS NOT NULL THEN isnull(mr.REGIONNAME,'') else mr2.REGIONNAME end))) as CDUArea,
ltrim(rtrim((case when cu.CDUName IS NOT null then isnull(cu.CDUName,'') WHEN mc.TE_NAME IS NOT NULL THEN isnull(mc.TE_NAME,'') else mc2.TE_NAME end))) as CDUName,
(case when len(cu.roleName)=0 and cu.user_type=2 and mc.MANAGER IS not null then 'Cashier' when LEN(cu.roleName)=0 and len(mc2.TE_NAME)>0 then 'Cashier' else cu.roleName end) roleName
,cu.roles
 from (
select u.CREATER, u.USER_ID,USER_ACCOUNT,USER_NAME,cr.REGIONNAME as CDUArea,c.TE_NAME as CDUName,
(CASE when USER_TYPE=1 AND c.MANAGER IS null THEN 3 else USER_TYPE END) user_type
,TELEPHONE,MOBILE_TELEPHONE,EMAIL,
replace(ADDRESS,',','.') as [address],replace(u.note,',','.') as [note],CREATE_TIME,CREATE_END
 ,(case when USER_TYPE=1 AND c.MANAGER>0 THEN 'CDU' else isnull(stuff((select '|'+ltrim(rtrim(r.ROLE_NAME))
 from IAUDIT_USER_ROLE ur left join IAUDIT_ROLE r on ur.ROLE_ID=r.ROLE_ID where ur.USER_ID=u.USER_ID and r.ROLE_TYPE=0 for xml path('')),1,1,''),'') end) as roleName
,isnull(stuff((select '|'+r.ROLE_NAME+':'+cast(r.ROLE_TYPE as varchar)
 from IAUDIT_USER_ROLE ur left join IAUDIT_ROLE r on ur.ROLE_ID=r.ROLE_ID where ur.USER_ID=u.USER_ID for xml path('')),1,1,''),'') as roles
 from IAUDIT_USER u
 LEFT JOIN IPARA_CDUSTATION c on c.MANAGER=u.USER_ID --and u.USER_TYPE=1
 LEFT JOIN IPARA_CDUREGION cr on cr.REGION_ID=c.REGIOINID
 where u.USER_ID not in (0,42,140)
 --and create_end>=DATEADD(month,-3,getdate())
 ) cu LEFT JOIN IAUDIT_USER mu on cu.CREATER=mu.USER_ID
 LEFT JOIN IPARA_CDUSTATION mc on mc.MANAGER=mu.USER_ID
 LEFT JOIN IPARA_CDUREGION mr on mr.REGION_ID=mc.REGIOINID
 LEFT JOIN (SELECT b.OPERATORID,b.CDUID,ROW_NUMBER() over(PARTITION by b.operatorid order by b.starttime desc) rowid from ORDER_BANKING b) ob
  on ob.rowid=1 and ob.OPERATORID=cu.USER_ID
 LEFT JOIN IPARA_CDUSTATION mc2 on mc2.TERRITORYID=OB.CDUID
 LEFT JOIN IPARA_CDUREGION mr2 on mr2.REGION_ID=mc2.REGIOINID
order by cu.create_TIME desc

-------------------------------------tmp_czy  自动建表语句-----------------------------------------
CREATE TABLE `tmp_czy` (
  `USER_ID` varchar(128) NOT NULL,
  `USER_ACCOUNT` varchar(128) DEFAULT NULL,
  `USER_NAME` varchar(128) DEFAULT NULL,
  `user_type` varchar(128) DEFAULT NULL,
  `TELEPHONE` varchar(128) DEFAULT NULL,
  `MOBILE_TELEPHONE` varchar(128) DEFAULT NULL,
  `EMAIL` varchar(128) DEFAULT NULL,
  `address` varchar(128) DEFAULT NULL,
  `note` varchar(128) DEFAULT NULL,
  `CREATE_TIME` datetime DEFAULT NULL,
  `CREATE_END` datetime DEFAULT NULL,
  `CDUArea` varchar(128) DEFAULT NULL,
  `CDUName` varchar(128) DEFAULT NULL,
  `roleName` varchar(128) DEFAULT NULL,
  `roles` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
