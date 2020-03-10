BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

	# 开启事务
	START TRANSACTION;

    # 1-因为UAP的sequence取的比较恶心，需要手动加一，所以临时创建一个sequence，然后使用AMI_GET_SEQUENCE()
    INSERT INTO sequence (NAME, current_value, increment) VALUES ('seq_uap_user_org_manage', 100000, 1);
    # 2-插入
    INSERT INTO `uap_user_org_manage` (`id`, `user_no`, `user_id`, `user_name`, `org_id`, `org_name`, `is_cascade`, `org_no`, `up_time`, `ORG_PATH_ID`)
    SELECT  AMI_GET_SEQUENCE('seq_uap_user_org_manage'), -- uap序列（临时替代）
            aa.userNo, -- uap_user.no
            aa.userId, -- uap_user.id
            aa.userName, -- uap_user.name
            bb.id, -- uap_organization.id
            bb.name, -- uap_organization.name
            0, -- is_cascade
            bb.no, -- uap_organization.no
            1579511310266, NULL
    FROM
    (select u.no "userNo", u.id "userId", u.name "userName", o.id "orgId", o.name "orgName", o.no "orgNo"
        from uap_user u
        left join uap_organization o on u.org_id = o.id
        where u.id not in ('1','2','10000')) aa
    LEFT JOIN uap_organization bb on bb.no like CONCAT(aa.orgNo,'%')
    ORDER BY aa.userId, bb.no;
    # 3-将uap_sequence.userOrgManageId更新为tmp_user_org的最大值（尽管现在UAP也不确定uap_sequence.userOrgManageId与uap_user_org_manage主键的关系）
    update uap_sequence set next_val = (select max(id) + 1 from uap_user_org_manage)
    where sequence_name = 'userOrgManageId';
    # 4-删除该临时序列
    DELETE FROM sequence WHERE name = 'seq_uap_user_org_manage';

    IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;

	SELECT t_error, msg;
END

-------------------------------------tmp_user_org  自动建表语句-----------------------------------------
-- CREATE TABLE `tmp_user_org` (
--   `mainkey` varchar(128) NOT NULL AUTO_INCREMENT,
--   `userNo` varchar(128) DEFAULT NULL,
--   `userId` varchar(128) DEFAULT NULL,
--   `userName` varchar(128) DEFAULT NULL,
--   `id` varchar(128) DEFAULT NULL,
--   `name` varchar(128) DEFAULT NULL,
--   `cascade` varchar(128) DEFAULT NULL,
--   `no` varchar(128) DEFAULT NULL,
--   `upTime` varchar(128) DEFAULT NULL,
--   PRIMARY KEY (`mainkey`)
-- ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
-- alter table `tmp_user_org` AUTO_INCREMENT=(select next_val + 1 from uap_sequence where sequence_name = 'userOrgManageId');