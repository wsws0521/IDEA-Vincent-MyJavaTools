BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	DECLARE zwId VARCHAR(32); -- tmp_zw债务ID
	DECLARE zwBalanceLast VARCHAR(32); -- tmp_zw1债务余额
	DECLARE zwBalance DECIMAL(20,4); -- tmp_zw债务余额
	DECLARE accountAdd DECIMAL(20,4) DEFAULT 0.00; -- 账户存入金额
	DECLARE debtRamin DECIMAL(20,4) DEFAULT 0.00; -- 新系统债务剩余金额
	DECLARE consumerId VARCHAR(32); -- 用户Id
	DECLARE consumerNo VARCHAR(32); -- 用户no
	DECLARE debtBalance DECIMAL(20,4); -- 计算后剩余债务金额
	DECLARE debtStatus VARCHAR(32); -- 债务状态
	DECLARE consAccount int DEFAULT 0; -- 用户账本数量
	DECLARE done int DEFAULT 0;

	# 定义游标
	DECLARE debt_new_list CURSOR FOR SELECT zw.debtid as zwId,zw1.balance as zwBalanceLast, zw.balance as zwBalance,
																					debt.REMAIN_DEBT as debtRamin,debt.CONS_ID as consumerId
																		 from tmp_zw zw inner join vd_a_user_debt debt on debt.debt_from_obj_id = zw.debtid
																			inner join tmp_zw1 zw1 on zw.debtid = zw1.debtid
																		where zw.balance!=zw1.balance;
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

	# 1-更新用户债务
	OPEN debt_new_list;
	REPEAT
		FETCH debt_new_list into zwId,zwBalanceLast,zwBalance,debtRamin,consumerId;
		IF NOT done THEN

			if (debtRamin-zwBalanceLast+zwBalance) < 0 THEN
				SET accountAdd = zwBalanceLast-zwBalance-debtRamin;
				SET debtBalance = 0;
				SET debtStatus = '02';
				select count(1) into consAccount from VD_A_ACCOUNT account where account.ACCT_CATEGOTY='01' and account.CATEGOTY_ID=consumerId and account.ACCT_TYPE='01';
				if consAccount>0 then
					update VD_A_ACCOUNT account
					set account.AVAILABLE_AMT = ifnull(account.AVAILABLE_AMT,0)+accountAdd,account.TOTAL_AMT = ifnull(account.TOTAL_AMT,0)+accountAdd
					where account.ACCT_CATEGOTY='01' and account.CATEGOTY_ID=consumerId and account.ACCT_TYPE='01';
				ELSE
					select cons.cons_no into consumerNo from a_consumer cons where cons.CONS_ID=consumerId;

					insert into VD_A_ACCOUNT(LESSEE_ID,ACCT_ID,ACCT_CATEGOTY,ACCT_NO,CATEGOTY_ID,ACCT_TYPE,FREEZE_AMT,AVAILABLE_AMT,TOTAL_AMT)
					values(2,AMI_GET_SEQUENCE('SEQ_VD_A_ACCOUNT'),'01',consumerNo,consumerId,'01',0,accountAdd,accountAdd);
				end if;
			ELSE
				SET accountAdd = 0.00;
				SET consAccount=0;
				SET debtBalance = debtRamin - (zwBalanceLast-zwBalance);
				if debtBalance = 0 THEN
					SET debtStatus = '02';
				else
					SET debtStatus = '01';
				end if;
			end if;

			update vd_a_user_debt debt
			set debt.REMAIN_DEBT=debtBalance,debt.STATUS=debtStatus
			where debt.debt_from_obj_id = zwId;
		END IF;
	UNTIL done END REPEAT;
	CLOSE debt_new_list;


	# 2-插入用户债务表
	INSERT INTO vd_a_user_debt
		(lessee_id, debt_id, cons_id, debt_amount, debt_type, debt_name,
		debt_value, STATUS, remain_debt, debt_num, repay_date, debt_desc,
		create_date, expired_date, debt_lx, debt_from_obj, debt_from_obj_id)
	SELECT
		2, AMI_GET_SEQUENCE('seq_vd_a_user_debt'), b.cons_id,
		a.debt_total,	-- 债务金额
		CASE WHEN a.dtype = 1 THEN '01'
			WHEN a.dtype = 2 THEN '06'
			WHEN a.dtype = 3 THEN '04'
			WHEN a.dtype = 4 THEN '03'
			ELSE NULL
		END,			-- zwsqlx债务收取类型: 01 按购电百分比 02 按截止日期 03一次性付清 04 债务百分比按次 05 债务百分比按月 06 固定金额按次 07固定金额按月
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
	FROM tmp_zw a
	inner join a_consumer b on CONCAT('yh_',a.customer_id) = b.CONS_NO
	WHERE NOT EXISTS(SELECT debt.debt_from_obj_id FROM vd_a_user_debt debt WHERE debt.debt_from_obj_id = a.debtid);

	# 3-插入用户债务配置表
	INSERT INTO vd_a_user_debt_set
		(lessee_id, set_id, cons_id, expired_date, pay_type)
	SELECT
		2, AMI_GET_SEQUENCE('seq_vd_a_user_debt_set'), b.cons_id, -- 用户id
		NULL, -- 限制日期
		'01' -- 偿还方式:01正常还债 02延期还债 03强制还债
	FROM tmp_zw a
	inner join a_consumer b on CONCAT('yh_',a.customer_id) = b.CONS_NO
	WHERE NOT EXISTS(SELECT debt.CONS_ID FROM vd_a_user_debt_set debt WHERE debt.CONS_ID = b.CONS_ID);

	IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;

	SELECT t_error into error_code;
	SELECT msg into error_msg;
END