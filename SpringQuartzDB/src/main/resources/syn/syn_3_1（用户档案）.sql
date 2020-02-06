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

	# 临时表
	CREATE TEMPORARY TABLE temp_yh SELECT yh.customer_id,yh.status,yh1.status AS statusold,
		(SELECT MT_COMM_ADDR FROM tmp_bj bj WHERE bj.customer_id=yh.customer_id) MT_COMM_ADDR,
		(SELECT MT_COMM_ADDR FROM tmp_bj bj1 WHERE bj1.customer_id=yh1.customer_id) MT_COMM_ADDRold
			FROM tmp_yh yh INNER JOIN tmp_yh1 yh1 ON yh.customer_id = yh1.customer_id AND yh1.status!=yh.status;

	/*1-更新用户状态*/
	/*01-新开户;02-已投运；03-已销户*/
	UPDATE a_consumer cons INNER JOIN temp_yh yh ON CONCAT('yh_',yh.customer_id) = cons.CONS_NO
						AND cons.STATUS = (CASE
							WHEN yh.statusold = 0 THEN '03' -- 已销户
							WHEN yh.statusold = 1 AND yh.MT_COMM_ADDRold IS NOT NULL AND yh.MT_COMM_ADDRold <> '' THEN '02' -- 已投运
							WHEN yh.statusold IN (1, 2, 5, 6, 8) AND (yh.MT_COMM_ADDRold IS NULL OR yh.MT_COMM_ADDRold = '') THEN '01' -- 新开户
							WHEN yh.statusold IN (2, 5, 6, 8) AND yh.MT_COMM_ADDRold IS NOT NULL AND yh.MT_COMM_ADDRold <> '' THEN '04' -- 已装表
							ELSE '03'
						END)
	SET cons.STATUS = (CASE
							WHEN yh.status = 0 THEN '03' -- 已销户
							WHEN yh.status = 1 AND yh.MT_COMM_ADDR IS NOT NULL AND yh.MT_COMM_ADDR <> '' THEN '02' -- 已投运
							WHEN yh.status IN (1, 2, 5, 6, 8) AND (yh.MT_COMM_ADDR IS NULL OR yh.MT_COMM_ADDR = '') THEN '01' -- 新开户
							WHEN yh.status IN (2, 5, 6, 8) AND yh.MT_COMM_ADDR IS NOT NULL AND yh.MT_COMM_ADDR <> '' THEN '04' -- 已装表
							ELSE '03'
						END);

	DROP TEMPORARY TABLE IF EXISTS temp_yh;

	# 2-插入用户档案
	INSERT INTO a_consumer
		(cons_id, cons_no, cons_name, cons_sort_code, org_no, reg_no, elec_addr, trade_code, elec_type_code, contract_cap, build_date, cancel_date,
		STATUS, jfh, zjfbz, single_limit, free_charge, free_tax, premises_no, arrears, account_balance, mdc_id, id_no, erf_stand)
	SELECT
		AMI_GET_SEQUENCE('S_AMI_FILE'),
		CONCAT('yh_',a.customer_id), a.customer_name,
		(CASE
			WHEN a.tariffname LIKE '%(BUS)' THEN '02' -- 工商业用户
			ELSE '04' -- 低压居民
		END),
		c.NO,
		a.BUSINESS_REGISTRATION_NUMBER, -- 商业注册号（新增）
		a.address, NULL,
		IF(a.tariffname IN ('MANGAUNG-TG1(FBE)','MANTSOPA-TG2(FBE)', 'NALEDI-TG3(FBE)','MOHOKARE-TG4(FBE)', 'KOPANONG-TG5(FBE)'), '201', NULL), -- 201-乡村居民生活用电  代表可以享受免费额度50kwh
		NULL, a.openaccount_date, NULL,
		(CASE
			WHEN a.status = 0 THEN '03' -- 已销户
			WHEN a.status = 1 AND (SELECT COUNT(MT_COMM_ADDR) FROM tmp_bj bj WHERE bj.customer_id=a.customer_id)>0 THEN '02' -- 已投运
			WHEN a.status IN (1, 2, 5, 6, 8) AND (SELECT COUNT(MT_COMM_ADDR) FROM tmp_bj bj WHERE bj.customer_id=a.customer_id)=0 THEN '01' -- 新开户
			WHEN a.status IN (2, 5, 6, 8) AND (SELECT COUNT(MT_COMM_ADDR) FROM tmp_bj bj WHERE bj.customer_id=a.customer_id)>0 THEN '04' -- 已装表
			ELSE '03'
		END), -- 用户状态，依赖于于表计临时表
		NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
		a.US_IDNUM, -- 身份证号（新增）
		a.StandNumber -- 地址资产编号（新增）
	FROM tmp_yh a
	LEFT JOIN uap_organization c ON CONCAT('dw_',a.station_id) = c.CODE
	WHERE NOT EXISTS(SELECT cons.CONS_NO FROM a_consumer cons WHERE CONCAT('yh_',a.customer_id) = cons.CONS_NO);

	IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;
	SELECT t_error into error_code;
	SELECT msg into error_msg;
END