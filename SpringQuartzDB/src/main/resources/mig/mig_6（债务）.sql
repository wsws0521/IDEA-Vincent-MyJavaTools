BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;

	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

	# 增大debt_amount、remain_debt小数位
	CALL PR_MOD_COL('vd_a_user_debt','MODIFY','debt_amount','decimal(20,6)','','','');
	CALL PR_MOD_COL('vd_a_user_debt','MODIFY','remain_debt','decimal(20,6)','','','');

	# 开启事务
	START TRANSACTION;

	# 1-删除已有数据
	DELETE FROM VD_A_USER_DEBT;
	DELETE FROM VD_A_USER_DEBT_SET;
	# 2-插入用户债务表
	INSERT INTO vd_a_user_debt
		(lessee_id, debt_id, cons_id, debt_amount, debt_type, debt_name,
		debt_value, STATUS, remain_debt, debt_num, repay_date, debt_desc,
		create_date, expired_date, debt_lx, debt_from_obj, debt_from_obj_id)
	SELECT
		2, AMI_GET_SEQUENCE('seq_vd_a_user_debt'), b.cons_id,
		a.debt_total,	-- 债务金额
		CASE WHEN a.dtype = 1 THEN '08'
			WHEN a.dtype = 2 THEN '06'
			WHEN a.dtype = 3 THEN '04'
			WHEN a.dtype = 4 THEN '03'
			ELSE NULL
		END,			-- zwsqlx债务收取类型: 01 按购电百分比 02 按截止日期 03一次性付清 04 债务百分比按次 05 债务百分比按月 06 固定金额按次 07固定金额按月 08 按总金额百分比（新增）
		a.debtnm,		-- 债务名称
		CASE WHEN a.dtype = 1 THEN a.pmoneypct
			WHEN a.dtype = 2 THEN a.minpay
			WHEN a.dtype = 3 THEN a.amountpct
			ELSE NULL
		END,			-- 收取的值：购电百分比的值，固定金额的值等
		CASE WHEN a.DebtStatus = 0 THEN '01'
			WHEN a.DebtStatus = 1 THEN '02'
			WHEN a.DebtStatus = 2 THEN '02'
			ELSE NULL
		END,					-- 债务状态:01 未还清 02 还清
		a.balance,				-- 剩余债务
		a.PAYCTS,				-- 还债次数
		CASE WHEN a.lastdate = '' OR a.lastdate IS NULL THEN NULL
			ELSE a.lastdate
		END,					-- 最近还债日期
		a.AGREE_ID,				-- 债务说明(临时存放迁移数据中的合同编号)
		a.create_date,			-- 创建时间
		NULL,					-- 截止时间
		CASE WHEN a.DebtType = 1 THEN '02'
			WHEN a.DebtType = 2 THEN '04'
			WHEN a.DebtType = 3 THEN '03'
			ELSE NULL
		END,			-- debtType债务类型：01历史陈欠电费、02电表初装费preload、03市政服务、04窃电篡改tamper
		NULL, a.debtid		-- 债务来源（暂存债务ID）
	FROM tmp_zw a, a_consumer b
	WHERE CONCAT('CN_',a.customer_id) = b.CONS_NO;
	# 3-插入用户债务配置表
	INSERT INTO vd_a_user_debt_set
		(lessee_id, set_id, cons_id, expired_date, pay_type)
	SELECT
		2, AMI_GET_SEQUENCE('seq_vd_a_user_debt_set'), b.cons_id, -- 用户id
		NULL, -- 限制日期
		'01' -- 偿还方式:01正常还债 02延期还债 03强制还债
	FROM tmp_zw a, a_consumer b
	WHERE CONCAT('CN_',a.customer_id) = b.CONS_NO;

	IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;
	SELECT t_error, msg;
END


------------------------------------sqlserver数据源获取 4569-------------------------------------------
 select d.DEBTID,
        d.CUSTOMER_ID,
        DEBTNM,
        AMOUNT Debt_total,
        Isnull(CURENTBLC,0) Balance,
        DTYPE,MINPAY,
        PMONEYPCT,AMOUNTPCT,
        DEBT_DATE CREATE_DATE,
        case when isnull(d.LASTDATE,'')='' then ''
            else isnull(CONVERT(VARCHAR(19), d.LASTDATE, 120),'')
            end LASTDATE,
        (case when DEBTNM in ('Preloaded Credit','preload debt') then 1
            when DEBTNM in ('Tamer','Tamper','tampering') then 2
            else 3 end) as DebtType,
        isnull(d.PAYCTS,0) PAYCTS, ISNULL(d.AGREE_ID,'') as AGREE_ID,
        0 AS DebtStatus
from IPARA_DEBT d
where isnull(d.OKFLAG,0)=0 and 0<>CURENTBLC
union all
select  d.DEBTID,
        d.CUSTOMER_ID,
        DEBTNM,
        AMOUNT Debt_total,
        0 Balance,
        DTYPE,
        MINPAY,
        PMONEYPCT,
        AMOUNTPCT,
        DEBT_DATE CREATE_DATE,
        case when isnull(d.LASTDATE,'')='' then ''
            else isnull(CONVERT(VARCHAR(19), d.LASTDATE, 120),'')
            end LASTDATE,
        (case when DEBTNM in ('Preloaded Credit','preload debt') then 1
            when DEBTNM in ('Tamer','Tamper','tampering') then 2
            else 3 end) as DebtType,
        (isnull(d.PAYCTS,0)+(case when CURENTBLC=0 then 0 else 1 end)) PAYCTS,
        ISNULL(d.AGREE_ID,'') as AGREE_ID,
        (case when CURENTBLC=0 then 1 else 2 end) AS DebtStatus
from IPARA_DEBT d
where isnull(d.OKFLAG,0)>0
-------------------------------------tmp_zw  自动建表语句-----------------------------------------
CREATE TABLE `tmp_zw` (
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




