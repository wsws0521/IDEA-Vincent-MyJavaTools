-------------------------------------tmp_dw  自动建表语句------------------------------------------
CREATE TABLE `tmp_dw` (
  `object_id` varchar(128) NOT NULL,
  `OBJECT_TYPE` varchar(128) DEFAULT NULL,
  `FatherId` varchar(128) DEFAULT NULL,
  `OBJECT_NAME` varchar(128) DEFAULT NULL,
  `SGC` varchar(128) DEFAULT NULL,
  `NEWID` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`object_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
-------------------------刷新导入【192.168.108.11,1433】，sqlserver数据源获取(85)----------------------
select  cast(o.OBJECT_ID as varchar) as 'object_id',
        o.OBJECT_TYPE,
        (case when o.REGION_ID=-1 then o.GRID_ID else o.REGION_ID end) as 'FatherId',
        rtrim(replace(o.OBJECT_NAME,',','-')) as 'OBJECT_NAME',
        RIGHT('000000'+CAST(o2.SGCID as varchar(10)),6) as SGC,
        '' as 'NEWID'
from IPARA_OBJECT o
left join (select on2.*,row_number() over (partition by on2.region_id order by modifydate desc) rn from IPARA_OBJECT on2 where on2.OBJECT_TYPE=2) o2
            on o2.REGION_ID=o.OBJECT_ID and rn=1
where o.OBJECT_TYPE in(1,2,0)
order by OBJECT_NAME,FatherId
-------------------------------------存储过程------------------------------------------

BEGIN
	DECLARE done INT DEFAULT 0; 			/* 结束标识 */
	DECLARE mainKey VARCHAR(64); 			/* 游标所取的字段值 */
	DECLARE var_orgId INT DEFAULT 20000;		/* UAP单位序列 */
	DECLARE var_typeFlag INT DEFAULT 0; 		/* 已存在标识 */
	DECLARE var_initNo1 INT DEFAULT 1; 			/* 一级单位起始编号 */
	DECLARE var_uapFatherId INT DEFAULT 0; 		/* uap中所属父单位的id */
	DECLARE var_uapFatherNo VARCHAR(32); 		/* uap中所属父单位的No */
	DECLARE var_existFlag INT DEFAULT 0; 		/* 已存在标识 */
	DECLARE var_dwNo VARCHAR(32); 				/* 子单位的No */
	DECLARE var_dwSgc VARCHAR(32); 				/* 单位绑定的SGC */
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	# 定义游标，注意按object_type由根到叶排序（最后添加的三个单位id为空，不参与遍历）
	DECLARE noCur CURSOR FOR SELECT object_id FROM tmp_dw WHERE object_id IS NOT NULL AND object_id <> '' order by object_type;
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
	# 清空单位相关数据
	UPDATE uap_sequence SET next_val = 20000 WHERE sequence_name = 'orgId';
	DELETE FROM vd_p_org_vk_rel; /* 清空单位与VK之间的绑定关系 */
	DELETE FROM UAP_USER_ORG_MANAGE WHERE org_id <> 10000; /* 清空操作员与单位之间的权限关系 */
	DELETE FROM UAP_ORGANIZATION WHERE code like 'ORG_%';
	# 更新根单位的名称为Centlec
	UPDATE uap_organization SET name = 'Centlec' WHERE id = 10000;
	UPDATE uap_user_org_manage SET org_name = 'Centlec' WHERE org_id = 10000;
	# 开始循环
	REPEAT
	FETCH noCur INTO mainKey;
	IF NOT done THEN
		# 取uap序列
		SET var_orgId = (SELECT next_val FROM uap_sequence WHERE sequence_name = 'orgId');
		UPDATE uap_sequence SET next_val = next_val + 1 WHERE sequence_name = 'orgId';

		SET var_typeFlag = (SELECT object_type FROM tmp_dw WHERE object_id = mainKey);
		CASE
			WHEN var_typeFlag = 0 THEN
				# 将一级单位插入
				INSERT INTO UAP_ORGANIZATION(ID,BASE_ORG_ID,CODE,IN_TIME,IS_LEAF,NAME,
														NO, PARENT_ID,RANK_ID,STATE,UP_TIME,TIME_ZONE,TYPE,ORG_PATH,ORG_PATH_ID,TENANT_ID)
				SELECT  var_orgId,NULL,CONCAT('ORG_',object_id),1551179068484,0,object_name,
								CONCAT('002',LPAD(var_initNo1,3,0)), 10000,1,'1',1551423273905,NULL,0,NULL,NULL,2 FROM tmp_dw where object_id = mainKey;
				SET var_initNo1 = var_initNo1 + 1;
			WHEN var_typeFlag = 1 THEN
				# 查询uap中所属父单位的id
				SET var_uapFatherId = (SELECT id FROM UAP_ORGANIZATION WHERE code = CONCAT('ORG_',(select fatherid from tmp_dw where object_id = mainKey)));
				# 查询uap中所属父单位的NO
				SET var_uapFatherNo = (SELECT NO FROM UAP_ORGANIZATION WHERE id = var_uapFatherId);
				# 拼接自己的单位NO
				SET var_existFlag = (SELECT COUNT(1) FROM UAP_ORGANIZATION WHERE no like CONCAT(var_uapFatherNo,'%') and LENGTH(no) = 9);
				IF(var_existFlag > 0) THEN
					SET var_dwNo = (SELECT LPAD(MAX(no) + 1,9,0) FROM UAP_ORGANIZATION where no like CONCAT(var_uapFatherNo,'%') and LENGTH(no) = 9);
				ELSE
					SET var_dwNo = (SELECT CONCAT(var_uapFatherNo,'001') FROM DUAL);
				END IF;
				# 将二级单位插入
				INSERT INTO UAP_ORGANIZATION(ID,BASE_ORG_ID,CODE,IN_TIME,IS_LEAF,NAME,
														NO, PARENT_ID,
														RANK_ID,STATE,UP_TIME,TIME_ZONE,TYPE,ORG_PATH,ORG_PATH_ID,TENANT_ID)
				SELECT  var_orgId,NULL,CONCAT('ORG_',object_id),1551179068484,0,object_name,
								var_dwNo, var_uapFatherId,
								1,'1',1551423273905,NULL,0,NULL,NULL,2 FROM tmp_dw where object_id = mainKey;
				# 将二级单位VK关系插入（注意需要先执行tmp_1_vk_p）
				SET var_dwSgc = (SELECT sgc FROM tmp_dw WHERE object_id = mainKey);
				IF(var_dwSgc IS NOT NULL AND var_dwSgc <> '') THEN
					insert into vd_p_org_vk_rel
						(lessee_id, rel_id, vk_id, org_id, status, start_time, end_time)
					select
						2, AMI_GET_SEQUENCE('seq_vd_p_org_vk_rel'),
						(select vk_id from vd_p_vk where sgc = var_dwSgc and base_time = 1993 and ms = '02'),
						(select id from UAP_ORGANIZATION where code = CONCAT('ORG_',mainKey)),
						'11', SYSDATE(), NULL from DUAL;
				END IF;
			WHEN var_typeFlag = 2 THEN
				# 查询uap中所属父单位的id
				SET var_uapFatherId = (SELECT id FROM UAP_ORGANIZATION WHERE code = CONCAT('ORG_',(select fatherid from tmp_dw where object_id = mainKey)));
				# 查询uap中所属父单位的NO
				SET var_uapFatherNo = (SELECT NO FROM UAP_ORGANIZATION WHERE id = var_uapFatherId);
				# 拼接自己的单位NO
				SET var_existFlag = (SELECT COUNT(1) FROM UAP_ORGANIZATION WHERE no like CONCAT(var_uapFatherNo,'%') and LENGTH(no) = 12);
				IF(var_existFlag > 0) THEN
					SET var_dwNo = (SELECT LPAD(MAX(no) + 1,12,0) FROM UAP_ORGANIZATION where no like CONCAT(var_uapFatherNo,'%') and LENGTH(no) = 12);
				ELSE
					SET var_dwNo = (SELECT CONCAT(var_uapFatherNo,'001') FROM DUAL);
				END IF;
				# 将三级单位插入
				INSERT INTO UAP_ORGANIZATION(ID,BASE_ORG_ID,CODE,IN_TIME,IS_LEAF,NAME,
														NO, PARENT_ID,
														RANK_ID,STATE,UP_TIME,TIME_ZONE,TYPE,ORG_PATH,ORG_PATH_ID,TENANT_ID)
				SELECT  var_orgId,NULL,CONCAT('ORG_',object_id),1551179068484,1,object_name,
								var_dwNo, var_uapFatherId,
								1,'1',1551423273905,NULL,0,NULL,NULL,2 FROM tmp_dw where object_id = mainKey;
		END CASE;
		# 将新ID更新至临时表
		UPDATE tmp_dw SET NEWID = (select id from UAP_ORGANIZATION where code = CONCAT('ORG_',mainKey)) where object_id = mainKey;
	END IF;
	UNTIL done END REPEAT;
	CLOSE noCur;

	# 插入3个代理商专属单位(1个一级单位+2个三级单位)
	# ---------------------------------------------------
	# 取uap序列
	SET var_orgId = (SELECT next_val FROM uap_sequence WHERE sequence_name = 'orgId');
	UPDATE uap_sequence SET next_val = next_val + 1 WHERE sequence_name = 'orgId';
	# 将一级单位插入
	INSERT INTO UAP_ORGANIZATION(ID,BASE_ORG_ID,CODE,IN_TIME,IS_LEAF,NAME, NO, PARENT_ID,RANK_ID,STATE,UP_TIME,TIME_ZONE,TYPE,ORG_PATH,ORG_PATH_ID,TENANT_ID)
	SELECT  var_orgId,NULL,CONCAT('ORG_agent_',var_orgId),1551179068484,1,'ThirdParty', CONCAT('002',LPAD(var_initNo1,3,0)), 10000,1,'1',1551423273905,NULL,0,NULL,NULL,2
	FROM DUAL;
	SET var_initNo1 = var_initNo1 + 1;
	# ---------------------------------------------------
	# 取uap序列
	SET var_orgId = (SELECT next_val FROM uap_sequence WHERE sequence_name = 'orgId');
	UPDATE uap_sequence SET next_val = next_val + 1 WHERE sequence_name = 'orgId';
	# 查询uap中所属父单位的id
	SET var_uapFatherId = (SELECT id FROM UAP_ORGANIZATION WHERE code = 'ORG_3');
	# 查询uap中所属父单位的NO
	SET var_uapFatherNo = (SELECT NO FROM UAP_ORGANIZATION WHERE id = var_uapFatherId);
	# 拼接自己的单位NO
	SET var_existFlag = (SELECT COUNT(1) FROM UAP_ORGANIZATION WHERE no like CONCAT(var_uapFatherNo,'%') and LENGTH(no) = 12);
	IF(var_existFlag > 0) THEN
		SET var_dwNo = (SELECT LPAD(MAX(no) + 1,12,0) FROM UAP_ORGANIZATION where no like CONCAT(var_uapFatherNo,'%') and LENGTH(no) = 12);
	ELSE
		SET var_dwNo = (SELECT CONCAT(var_uapFatherNo,'001') FROM DUAL);
	END IF;
	# 将三级单位插入
	INSERT INTO UAP_ORGANIZATION(ID,BASE_ORG_ID,CODE,IN_TIME,IS_LEAF,NAME, NO, PARENT_ID,RANK_ID,STATE,UP_TIME,TIME_ZONE,TYPE,ORG_PATH,ORG_PATH_ID,TENANT_ID)
	SELECT  var_orgId,NULL,CONCAT('ORG_agent_',var_orgId),1551179068484,1,'BLOEMFONTEIN', var_dwNo, var_uapFatherId,1,'1',1551423273905,NULL,0,NULL,NULL,2
	FROM DUAL;
	# ---------------------------------------------------
	# 取uap序列
	SET var_orgId = (SELECT next_val FROM uap_sequence WHERE sequence_name = 'orgId');
	UPDATE uap_sequence SET next_val = next_val + 1 WHERE sequence_name = 'orgId';
	# 查询uap中所属父单位的id
	SET var_uapFatherId = (SELECT id FROM UAP_ORGANIZATION WHERE code = 'ORG_3');
	# 查询uap中所属父单位的NO
	SET var_uapFatherNo = (SELECT NO FROM UAP_ORGANIZATION WHERE id = var_uapFatherId);
	# 拼接自己的单位NO
	SET var_existFlag = (SELECT COUNT(1) FROM UAP_ORGANIZATION WHERE no like CONCAT(var_uapFatherNo,'%') and LENGTH(no) = 12);
	IF(var_existFlag > 0) THEN
		SET var_dwNo = (SELECT LPAD(MAX(no) + 1,12,0) FROM UAP_ORGANIZATION where no like CONCAT(var_uapFatherNo,'%') and LENGTH(no) = 12);
	ELSE
		SET var_dwNo = (SELECT CONCAT(var_uapFatherNo,'001') FROM DUAL);
	END IF;
	# 将三级单位插入
	INSERT INTO UAP_ORGANIZATION(ID,BASE_ORG_ID,CODE,IN_TIME,IS_LEAF,NAME, NO, PARENT_ID,RANK_ID,STATE,UP_TIME,TIME_ZONE,TYPE,ORG_PATH,ORG_PATH_ID,TENANT_ID)
	SELECT  var_orgId,NULL,CONCAT('ORG_agent_',var_orgId),1551179068484,1,'BOTSHABELO', var_dwNo, var_uapFatherId,1,'1',1551423273905,NULL,0,NULL,NULL,2
	FROM DUAL;
	# ---------------------------------------------------
    # 为MDCAdmin赋予所有单位权限

	IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;
	SELECT t_error, msg;

END


