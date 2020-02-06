BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

	CREATE TABLE IF NOT EXISTS `tmp_centlec` (
		`id` int(11) NOT NULL AUTO_INCREMENT,
		`syn_date` varchar(8) NOT NULL,
		`cur_dead_step` varchar(8) NOT NULL,
		`remark` varchar(64) DEFAULT NULL,
		`tv` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
		PRIMARY KEY (`id`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

	#1-修改tmp为tmp1
	ALTER TABLE tmp_yh RENAME TO tmp_yh1;
	ALTER TABLE tmp_bj RENAME TO tmp_bj1;
	ALTER TABLE tmp_zw RENAME TO tmp_zw1;
	ALTER TABLE tmp_ljz RENAME TO tmp_ljz1;


	CREATE TABLE IF NOT EXISTS `tmp_bj` (
	  `MT_MODEL_DESC` varchar(128) DEFAULT NULL,
	  `MT_COMM_ADDR` varchar(128) NOT NULL,
	  `station_id` varchar(128) DEFAULT NULL,
	  `LINE_ID` varchar(128) DEFAULT NULL,
	  `SUBURB_ID` varchar(128) DEFAULT NULL,
	  `MUS_TI` varchar(128) DEFAULT NULL,
	  `MUS_SGCID` varchar(128) DEFAULT NULL,
	  `MUS_KEYVISION` varchar(128) DEFAULT NULL,
	  `MUS_KEYEXPIRY` varchar(128) DEFAULT NULL,
	  `LASTVENDDATE` varchar(128) DEFAULT NULL,
	  `LASTVENDFREEDATE` varchar(128) DEFAULT NULL,
	  `TARIFFNAME` varchar(128) DEFAULT NULL,
	  `CUSTOMER_ID` varchar(128) DEFAULT NULL,
	  `MeterStatus` varchar(128) DEFAULT NULL,
	  PRIMARY KEY (`MT_COMM_ADDR`),
	  KEY `index_bj_customerid` (`CUSTOMER_ID`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


	CREATE TABLE IF NOT EXISTS `tmp_yh` (
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
	) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


	CREATE TABLE IF NOT EXISTS `tmp_zw` (
	  `DEBTID` varchar(128) NOT NULL,
	  `CUSTOMER_ID` varchar(128) DEFAULT NULL,
	  `DEBTNM` varchar(128) DEFAULT NULL,
	  `Debt_total` varchar(128) DEFAULT NULL,
	  `Balance` varchar(128) DEFAULT NULL,
	  `DTYPE` varchar(128) DEFAULT NULL,
	  `MINPAY` varchar(128) DEFAULT NULL,
	  `PMONEYPCT` varchar(128) DEFAULT NULL,
	  `AMOUNTPCT` varchar(128) DEFAULT NULL,
	  `CREATE_DATE` datetime DEFAULT NULL,
	  `LASTDATE` varchar(128) DEFAULT NULL,
	  `DebtType` varchar(128) DEFAULT NULL,
	  `PAYCTS` varchar(128) DEFAULT NULL,
	  `AGREE_ID` varchar(128) DEFAULT NULL,
	  `DebtStatus` varchar(128) DEFAULT NULL,
	  PRIMARY KEY (`DEBTID`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


	CREATE TABLE IF NOT EXISTS `tmp_ljz` (
	  `energy` varchar(128) DEFAULT NULL,
	  `MT_COMM_ADDR` varchar(128) NOT NULL,
	  `LASTVENDDATE` varchar(128) NOT NULL,
	  `ISFREE` varchar(128) NOT NULL,
	  `ISUSED` varchar(128) NOT NULL,
	  PRIMARY KEY (`MT_COMM_ADDR`,`LASTVENDDATE`,`ISFREE`)
	) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

	SELECT t_error into error_code;
	SELECT msg into error_msg;
END