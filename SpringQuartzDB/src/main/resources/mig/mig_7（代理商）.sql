BEGIN
	DECLARE done INT DEFAULT 0; 					/* 结束标识 */
	DECLARE mainKey VARCHAR(64); 					/* 游标所取的字段值 */
	DECLARE var_cduArea VARCHAR(128);				/* 可能是thirdparty或其他 */
	DECLARE var_agentType VARCHAR(4);				/* thirdparty=01其他就是02 */
	DECLARE var_agentId INTEGER DEFAULT NULL; 		/* 代理商id序列 */
	DECLARE var_accountId INTEGER DEFAULT NULL; 	/* 代理商账户id序列 */
	DECLARE var_orgId INTEGER DEFAULT NULL; 		/* 单位id */
	-- DECLARE var_orgNo VARCHAR(64) DEFAULT ''; 		/* 单位No */
	-- DECLARE var_orgName VARCHAR(128) DEFAULT ''; 	/* 单位名称 */

	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;

	# 定义游标
	DECLARE noCur CURSOR FOR SELECT te_name FROM tmp_dls;
	# 定义循环结束done值改变逻辑
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

	# 开启事务【默认CDUArea都能在单位表找到对应1条记录，否则会报主键为空】
	START TRANSACTION;

	# 打开游标
	OPEN noCur;
	# 清空代理商相关数据
	DELETE FROM VD_AGT_AGENT_OPERATOR; -- 清除代理商下面的操作员
	DELETE FROM VD_AGT_CHARGE_LIMT; -- 清除代理商售电金额限制
	DELETE FROM VD_A_ACCOUNT WHERE ACCT_CATEGOTY IN ('02','03'); -- 清除代理商账户
	DELETE FROM VD_AGT_AGENT; -- 清除代理商档案
	# 遍历表
	REPEAT
	FETCH noCur INTO mainKey;
	IF NOT done THEN
		SET var_cduArea = (SELECT CDUArea FROM tmp_dls where te_name = mainKey);
		SET var_agentType = (SELECT IF(var_cduArea = 'ThirdParty', '01', '02'));

		SET var_agentId = (SELECT AMI_GET_SEQUENCE('SEQ_VD_AGT_AGENT') FROM DUAL);
		SET var_accountId = (SELECT AMI_GET_SEQUENCE('SEQ_VD_A_ACCOUNT') FROM DUAL);
		SET var_orgId = (SELECT ID FROM UAP_ORGANIZATION WHERE name like concat('%', var_cduArea) and tenant_id = 2 ORDER BY no LIMIT 1);
		-- SET var_orgNo = (SELECT NO FROM UAP_ORGANIZATION WHERE name like concat('%', var_cduArea) and tenant_id = 2);
		-- SET var_orgName = (SELECT NAME FROM UAP_ORGANIZATION WHERE name like concat('%', var_cduArea) and tenant_id = 2);


		-- 默认密码：CENT123456
		IF(var_agentType = '01') THEN
			# 新增第三方代理商 VD_AGT_AGENT
			INSERT INTO VD_AGT_AGENT
				(LESSEE_ID, AGENT_ID, AGENT_NO, AGENT_NAME, MIN_CREDIT_LIMIT, CLIENTID, CLIENTID_PWD, ORG_ID, RESU_TYPE, ADDR, STATUS, AGENT_TYPE)
			SELECT
				2, var_agentId, CONCAT('AG', LPAD(var_agentId, 6, '0')), te_name, -500000, LPAD(var_agentId, 13, '0'),'vCH7kRwjttcRWl2gl1hUaxGmTgJDw9gdUoiFAyDFWpk64m5yB+aijQ==', var_orgId, '01', TE_ADDRESS, '01', var_agentType
			FROM tmp_dls where te_name = mainKey;
			# 新增第三方代理商的账本 VD_A_ACCOUNT
			INSERT INTO VD_A_ACCOUNT
				(LESSEE_ID, ACCT_ID, ACCT_NO, CATEGOTY_ID, ACCT_CATEGOTY, ACCT_TYPE, PAY_SEQ, FREEZE_AMT, AVAILABLE_AMT, TOTAL_AMT, CREDIT_AMT, ORG_ID)
			SELECT
				2, var_accountId, CONCAT('AG', LPAD(var_agentId, 6, '0')), var_agentId, '02', '02', 1, 0, 0, 0, 0, var_orgId
			FROM DUAL;
		ELSE
			# 新增自营代理商 VD_AGT_AGENT
			INSERT INTO VD_AGT_AGENT
				(LESSEE_ID, AGENT_ID, AGENT_NO, AGENT_NAME, MIN_CREDIT_LIMIT, CLIENTID, CLIENTID_PWD, ORG_ID, RESU_TYPE, ADDR, STATUS, AGENT_TYPE)
			SELECT
				-- 2, var_agentId, var_orgNo, var_orgName, -500000, NULL,NULL, var_orgId, '01', TE_ADDRESS, '01', var_agentType
				2, var_agentId, CONCAT('AG', LPAD(var_agentId, 6, '0')), te_name, -500000, NULL,NULL, var_orgId, '01', TE_ADDRESS, '01', var_agentType
			FROM tmp_dls where te_name = mainKey;
			# 新增自营代理商的账本 VD_A_ACCOUNT
			INSERT INTO VD_A_ACCOUNT
				(LESSEE_ID, ACCT_ID, ACCT_NO, CATEGOTY_ID, ACCT_CATEGOTY, ACCT_TYPE, PAY_SEQ, FREEZE_AMT, AVAILABLE_AMT, TOTAL_AMT, CREDIT_AMT, ORG_ID)
			SELECT
				-- 2, var_accountId, var_orgNo, var_orgId, '03', '02', 1, 0, 0, 0, 0, var_orgId
				2, var_accountId, CONCAT('AG', LPAD(var_agentId, 6, '0')), var_agentId, '03', '02', 1, 0, 0, 0, 0, var_orgId
			FROM DUAL;
		END IF;
		# 新增代理商售电金额限制
		INSERT INTO VD_AGT_CHARGE_LIMT (LESSEE_ID, LIMT_ID, AGENT_ID, RESU_TYPE, MAX_CHARGE, MIN_CHARGE)
		SELECT 2, AMI_GET_SEQUENCE('SEQ_VD_AGT_CHARGE_LIMT'), var_agentId, '01', TE_MAXVAL, TE_MINVAL
		FROM tmp_dls where te_name = mainKey;
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


------------------------------------sqlserver数据源获取-------------------------------------------

select  ltrim(rtrim(c.TE_NAME)) TE_NAME,
        ltrim(rtrim(c.TE_ADDRESS)) TE_ADDRESS,
        c.TE_MINVAL,
        c.TE_MAXVAL,
        r.REGIONNAME as CDUArea,
        c.TE_CREDIT
from IPARA_CDUSTATION c
left join IPARA_CDUREGION r on c.REGIOINID=r.REGION_ID

-------------------------------------tmp_dls  自动建表语句-----------------------------------------

CREATE TABLE `tmp_dls` (
  `TE_NAME` varchar(128) NOT NULL,
  `TE_ADDRESS` varchar(128) DEFAULT NULL,
  `TE_MINVAL` varchar(128) DEFAULT NULL,
  `TE_MAXVAL` varchar(128) DEFAULT NULL,
  `CDUArea` varchar(128) DEFAULT NULL,
  `TE_CREDIT` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`TE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
