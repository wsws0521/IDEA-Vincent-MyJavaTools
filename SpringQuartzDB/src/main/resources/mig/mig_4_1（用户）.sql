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

	# 0-索引
	ALTER table tmp_yh ADD INDEX index_tmp_yh_cusid(CUSTOMER_ID);
	# 1-删除已有数据
	DELETE FROM VD_A_USER_DEBT;
	DELETE FROM VD_A_USER_DEBT_SET;

	DELETE FROM a_consumer_contacts;

	DELETE FROM A_MP_EQUIPMENT_RELA;
	DELETE FROM a_consumer;
	DELETE FROM a_usagepoint;
	# 2-插入用户档案
	INSERT INTO a_consumer
		(cons_id, cons_no, cons_name, cons_sort_code, org_no, reg_no, elec_addr, trade_code, elec_type_code, contract_cap, build_date, cancel_date,
		STATUS, jfh, zjfbz, single_limit, free_charge, free_tax, premises_no, arrears, account_balance, mdc_id, id_no, erf_stand)
	SELECT
		AMI_GET_SEQUENCE('S_AMI_FILE'),
		CONCAT('CN_',a.customer_id), a.customer_name,
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
			WHEN a.status = 1 AND b.MT_COMM_ADDR IS NOT NULL AND b.MT_COMM_ADDR <> '' THEN '02' -- 已投运
			WHEN a.status IN (1, 2, 5, 6, 8) AND (b.MT_COMM_ADDR IS NULL OR b.MT_COMM_ADDR = '') THEN '01' -- 新开户
			WHEN a.status IN (2, 5, 6, 8) AND b.MT_COMM_ADDR IS NOT NULL AND b.MT_COMM_ADDR <> '' THEN '04' -- 已装表
			ELSE '03'
		END), -- 用户状态，依赖于于表计临时表
		NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL,
		a.US_IDNUM, -- 身份证号（新增）
		a.StandNumber -- 地址资产编号（新增）
	FROM tmp_yh a
	LEFT JOIN tmp_bj b ON a.customer_id = b.customer_id
	LEFT JOIN uap_organization c ON CONCAT('ORG_',a.station_id) = c.CODE;


	IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;
	SELECT t_error, msg;
END


------------------------------------sqlserver数据源获取-------------------------------------------

select  CUSTOMER_ID,
        RTRIM(LTRIM(replace(CUSTOMER_NAME,',','.'))) customer_name,
        r.STATUS,
        OPENACCOUNT_DATE,
        RTRIM(LTRIM(isnull(REPLACE(ADDRESS,',','.'),''))) ADDRESS,
        RTRIM(LTRIM(isnull(REPLACE(LINKMAN,',','.'),''))) StandNumber,
        RTRIM(LTRIM(isnull(REPLACE(LINKMAN_PHONE,',','.'),''))) LINKMAN_PHONE,
        r.POWER_SUPPLYER as Station_id,
        US_TI,RTRIM(LTRIM(isnull(REPLACE(US_IDNUM,',','.'),''))) US_IDNUM,
        RTRIM(LTRIM(isnull(REPLACE(US_EMAIL,',','.'),''))) US_EMAIL,
        RTRIM(LTRIM(isnull(REPLACE(US_ZIP,',','.'),''))) US_ZIP,US_SEX,
        RTRIM(LTRIM(isnull(REPLACE(BANKACCOUNT,',','.'),''))) BANKACCOUNT,
        ISNULL(BUSINESS_REGISTRATION_NUMBER,'') as BUSINESS_REGISTRATION_NUMBER,
        isnull(tg.TG_NAME,'') as TARIFFNAME
from IPARA_RESIDENT r
left join IPARA_OBJECT ot on ot.OBJECT_ID=r.POWER_SUPPLYER
left join TARIFF_GROUP tg on tg.TARIFFGROUPID=ot.TARIFFGROUPID

-------------------------------------tmp_yh  自动建表语句-----------------------------------------

CREATE TABLE `tmp_yh` (
  `CUSTOMER_ID` varchar(128) NOT NULL,
  `customer_name` varchar(128) DEFAULT NULL,
  `STATUS` varchar(128) DEFAULT NULL,
  `OPENACCOUNT_DATE` varchar(128) DEFAULT NULL,
  `ADDRESS` varchar(128) DEFAULT NULL,
  `StandNumber` varchar(128) DEFAULT NULL,
  `LINKMAN_PHONE` varchar(128) DEFAULT NULL,
  `Station_id` varchar(128) DEFAULT NULL,
  `US_TI` varchar(128) DEFAULT NULL,
  `US_IDNUM` varchar(128) DEFAULT NULL,
  `US_EMAIL` varchar(128) DEFAULT NULL,
  `US_ZIP` varchar(128) DEFAULT NULL,
  `US_SEX` varchar(128) DEFAULT NULL,
  `BANKACCOUNT` varchar(128) DEFAULT NULL,
  `BUSINESS_REGISTRATION_NUMBER` varchar(128) DEFAULT NULL,
  `TARIFFNAME` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`CUSTOMER_ID`),
  KEY `index_yh_tariffname` (`TARIFFNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




