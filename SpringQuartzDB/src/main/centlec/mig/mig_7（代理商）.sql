DROP PROCEDURE IF EXISTS mig_7;
delimiter $$
CREATE PROCEDURE mig_7()

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
	DECLARE noCur CURSOR FOR
	SELECT te_name FROM tmp_dls where CDUArea = 'ThirdParty'
	union all
	SELECT te_name FROM tmp_dls where TE_NAME in (
                                              'SL06 Geyser Supermarket',
                                              'SL09 Reahola',
                                              'SL20 R & B Motors',
                                              'SL124 Inspan Reddersburg (Pty) Ltd',
                                              'CS01 Civic Centre',
                                              'SL106 Loopys Cafe',
                                              'SL108 Batloung Supermarket',
                                              'SL11 Bighi Investments',
                                              'SL113 Vista Park Supermarket',
                                              'SL112 Regional Office',
                                              'SL114 Thaba-Nchu Municipality',
                                              'SL118 HEIDEDAL',
                                              'SL120 Simunye Motors',
                                              'SL121 Poloko Trading',
                                              'SL13 Bargain Box',
                                              'SL17 Curie Park',
                                              'SL 127 Capital Ship Trading',
                                              'SL19 No Jokes Cash Store',
                                              'SL51 K K General Dealer',
                                              'SL27 Hi-Way Electricity',
                                              'SL78 SOVS Motors',
                                              'POWS Power Station',
                                              'SL98 Hostel 1',
                                              'SL02 Naledi Municipality Dewetsdorp',
                                              'SL03 Naledi Municipality VSRUS',
                                              'CS10 Central Park'
                                             ); -- 后面4个是Ogezwa遗漏，但是出现在CDU-操作员.xlsx里面的
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
	delete from sequence where NAME = 'SEQ_VD_AGT_AGENT';
	delete from sequence where NAME = 'SEQ_VD_A_ACCOUNT';
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
				2, var_agentId, CONCAT('AG', LPAD(var_agentId, 6, '0')), te_name, 1000, LPAD(var_agentId, 13, '0'),'vCH7kRwjttcRWl2gl1hUaxGmTgJDw9gdUoiFAyDFWpk64m5yB+aijQ==', var_orgId, '01', TE_ADDRESS, '02', var_agentType
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
				2, var_agentId, CONCAT('AG', LPAD(var_agentId, 6, '0')), te_name, 1000, NULL,NULL, var_orgId, '01', TE_ADDRESS, '02', var_agentType
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

$$
delimiter ;

CALL mig_7();