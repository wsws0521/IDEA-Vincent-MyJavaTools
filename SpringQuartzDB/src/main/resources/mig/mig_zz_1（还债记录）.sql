DROP PROCEDURE IF EXISTS mig_zz_1;
delimiter $$
CREATE PROCEDURE mig_zz_1()

BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

	if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_NAME = 'VD_A_RCVBL_FLOW' AND COLUMN_NAME = 'DEBTID') = 0 then
        CALL PR_MOD_COL('VD_A_RCVBL_FLOW','ADD','DEBTID','VARCHAR(64)','NULL','NULL','');
    end if;
    if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_NAME = 'VD_A_RCVBL_FLOW' AND COLUMN_NAME = 'ORDERID') = 0 then
        CALL PR_MOD_COL('VD_A_RCVBL_FLOW','ADD','ORDERID','VARCHAR(128)','NULL','NULL','');
    end if;
    if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_NAME = 'VD_A_PAY_FLOW' AND COLUMN_NAME = 'DEBTID') = 0 then
        CALL PR_MOD_COL('VD_A_PAY_FLOW','ADD','DEBTID','VARCHAR(64)','NULL','NULL','');
    end if;
    if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_NAME = 'VD_A_PAY_FLOW' AND COLUMN_NAME = 'ORDERID') = 0 then
        CALL PR_MOD_COL('VD_A_PAY_FLOW','ADD','ORDERID','VARCHAR(128)','NULL','NULL','');
    end if;
    if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_NAME = 'VD_A_RCVED_FLOW' AND COLUMN_NAME = 'DEBTID') = 0 then
        CALL PR_MOD_COL('VD_A_RCVED_FLOW','ADD','DEBTID','VARCHAR(64)','NULL','NULL','');
    end if;
    if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_NAME = 'VD_A_RCVED_FLOW' AND COLUMN_NAME = 'ORDERID') = 0 then
        CALL PR_MOD_COL('VD_A_RCVED_FLOW','ADD','ORDERID','VARCHAR(128)','NULL','NULL','');
    end if;

    IF NOT EXISTS(SELECT * FROM information_schema.statistics WHERE table_name='vd_a_user_debt' AND index_name='INDEX_vd_a_user_debt_OBJID') THEN
		# 为2插入 应收表（债务）【做准备】
        ALTER table vd_a_user_debt ADD INDEX INDEX_vd_a_user_debt_OBJID(DEBT_FROM_OBJ_ID);
	END IF;
    IF NOT EXISTS(SELECT * FROM information_schema.statistics WHERE table_name='vd_a_pay_flow' AND index_name='INDEX_vd_a_pay_flow_OBJID') THEN
		# 为4插入 实收表【做准备】
        ALTER table vd_a_pay_flow ADD INDEX INDEX_vd_a_pay_flow_OBJID(DEBTID, ORDERID);
	END IF;
    IF NOT EXISTS(SELECT * FROM information_schema.statistics WHERE table_name='vd_a_rcvbl_flow' AND index_name='INDEX_vd_a_rcvbl_flow_OBJID') THEN
		# 为5插入 实收表（债务）【做准备】
        ALTER table vd_a_rcvbl_flow ADD INDEX INDEX_vd_a_rcvbl_flow_OBJID(DEBTID, ORDERID);
	END IF;


	# 开启事务
	START TRANSACTION;


	# 清除还债记录数据(并轨结束后才迁移该记录，实收应收表已存在业务记录，不能删除)
-- 	DELETE FROM VD_A_RCVED_DEBT;
-- 	DELETE FROM VD_A_RCVED_FLOW WHERE DEBTID IS NOT NULL OR ORDERID IS NOT NULL;
--
-- 	DELETE FROM VD_A_PAY_FLOW WHERE DEBTID IS NOT NULL OR ORDERID IS NOT NULL;
--
-- 	DELETE FROM VD_A_RCVBL_DEBT;
-- 	DELETE FROM VD_A_RCVBL_FLOW WHERE DEBTID IS NOT NULL OR ORDERID IS NOT NULL;

	# 1-插入 应收表
	INSERT INTO vd_a_rcvbl_flow
		(lessee_id, rcvbl_amt_id, calc_id, amt_type, rcvbl_ym, obj_type, obj_id, obj_no, meter_id, meter_no,
		rcvbl_amt, rcved_amt, rcvbl_penalty, rcved_penalty, status_code, settle_flag, penalty_bgn_date, release_date, relate_id,
		relate_flag, src, res_quan, org_id, bus_from_obj, bus_from_obj_id, tv, debtid, orderid)
	SELECT
		2, AMI_GET_SEQUENCE('SEQ_VD_A_RCVBL_FLOW'), NULL,
		'11', -- 费用类型:产生应收的来源分类，包括01 电费 02免费电费 11 债务 21 佣金 31 费率费用 32免费费率费用 41 业务费
		DATE_FORMAT(a.paydate,'%Y%m'), -- 应收年月
		'02', -- 对象类型:01客户、02用户03代理商04加密盒03表计厂商
		b.CONS_ID, b.CONS_NO,
		c.METER_ID, c.ASSETNO,
		ROUND(a.paymoney, 2), ROUND(a.paymoney, 2), -- 应收实收
		NULL, NULL, -- 应收实收违约金
		NULL, -- 收取过程的状态，包括非锁定、锁定(代扣在途)、锁定(走收在途)、锁定(托收在途)。
		'03', -- 结清状态：单笔还债记录认为结清
		NULL, -- 违约金起算日期
		NULL, -- 发行日期
		NULL, -- 关联标识
		NULL, -- 关联标志
		'02', -- 源：02Vending
		NULL, -- 资源量
		d.id, -- 单位id
		NULL, -- 业务来源对象
		NULL, -- 业务来源标识
		a.paydate, -- 手动插入TV字段，应用于分区（该值不应为空）
		a.debtid, -- 临时存储所属老表债务ID
		a.orderid -- 临时存储该次偿还在老系统的订单编号（可能存在一个order对应多个debt）
	FROM tmp_hzjl a
	INNER JOIN a_consumer b on CONCAT('CN_',a.CUSTOMER_ID) = b.CONS_NO
    INNER JOIN a_equip_meter c on a.MT_COMM_ADDR = c.ASSETNO
    LEFT JOIN uap_organization d on b.ORG_NO = d.no;

	# 2-插入 应收表（债务）
	INSERT INTO vd_a_rcvbl_debt
		(lessee_id, rcvbl_debt_id, rcvbl_amt_id, debt_id, debt_type, amount,
		remain_debt, debt_value, expired_date, rcved_amt, org_id, rcvbl_amt, tv)
	SELECT
		2, AMI_GET_SEQUENCE('SEQ_VD_A_RCVBL_DEBT'), b.RCVBL_AMT_ID, c.DEBT_ID, c.DEBT_TYPE, c.debt_amount, -- 债务金额，取总金额
		a.payedBalance + a.paymoney, -- 剩余债务：目前是存的此笔偿还之前的剩余！！！
		c.DEBT_VALUE, c.EXPIRED_DATE, a.paymoney, b.ORG_ID, a.paymoney,
		a.paydate -- 手动插入TV字段，应用于分区（该值不应为空）
	FROM tmp_hzjl a, vd_a_rcvbl_flow b, vd_a_user_debt c
	WHERE a.DEBTID = b.DEBTID AND a.orderid = b.ORDERID AND a.DEBTID = c.DEBT_FROM_OBJ_ID;

	# 3-插入 收费明细
	INSERT INTO vd_a_pay_flow
		(lessee_id, charge_id, ds_id, obj_type, obj_id, obj_no, meter_id, meter_no,
		charge_ym, charge_date, acct_ym, type_code, rcv_amt, change_amt, rcvd_amt,
		charge_oper, settle_mode, settle_note_no, settle_bank_code, dept_id, rcv_org_id,
		charge_remark, relate_id, src, org_id, pay_bank_acc, rcv_bank, rcv_bank_acc,
		tv, channel, debtid, orderid)
	SELECT
		2, AMI_GET_SEQUENCE('SEQ_VD_A_PAY_FLOW'), NULL, -- 日结标识
		'02', -- 对象类型:01客户、02用户03代理商04加密盒03表计厂商
		b.OBJ_ID, b.OBJ_NO, b.METER_ID, b.METER_NO, -- 用户、表计信息
		DATE_FORMAT(a.paydate,'%Y%m'), a.paydate,  -- 收费年月、收费日期
		NULL, -- 记账年月
		'10', -- 收费类型：10还债收费11收电费12收业务费
		ROUND(a.paymoney, 2), -- 收费金额
		0.00, -- 找零金额
		ROUND(a.paymoney, 2), -- 实收金额
		(select id from uap_user c where c.no = a.operator), -- 收此费用的操作员ID
		'01', -- 结算方式：01现金02转账、支票刷卡等
		NULL, NULL, -- 转账账号、银行
		b.org_id, b.org_id, -- 收款部门、单位
		'Centlec debt record', -- 备注
		NULL, -- 关联标识
		'02', -- 源：02Vending
		b.org_id, -- 供电单位
		NULL, -- 付款账号
		NULL, -- 付款银行
		NULL, -- 收款账号
		a.paydate, -- 手动插入TV字段，应用于分区（该值不应为空）
		NULL, -- 渠道
		a.debtid, -- 临时存储所属老表债务ID
		a.orderid -- 临时存储该次偿还在老系统的订单编号（可能存在一个order对应多个debt）
	FROM tmp_hzjl a, vd_a_rcvbl_flow b
	WHERE a.DEBTID = b.DEBTID AND a.orderid = b.ORDERID;

	# 4-插入 实收表
	INSERT INTO vd_a_rcved_flow
		(lessee_id, rcved_amt_id, charge_id, rcvbl_amt_id, cons_no, meter_id, asset_no, rcved_date, rcvbl_ym,
		this_rcved_amt, this_penalty, amt_type, owe_amt, org_id, tv, debtid, orderid)
	SELECT
		2, AMI_GET_SEQUENCE('SEQ_VD_A_RCVED_FLOW'),
		c.CHARGE_ID, b.RCVBL_AMT_ID, b.OBJ_NO, b.METER_ID, b.METER_NO,
		DATE_FORMAT(a.paydate,'%Y%m%d'), DATE_FORMAT(a.paydate,'%Y%m'),
		ROUND(a.paymoney, 2), NULL,
		'11', -- 按产生应收的来源分类，包括01 电费 02免费电费 11 债务 21 佣金 31 费率费用 32免费费率费用 41 业务费
		NULL, b.ORG_ID,
		a.paydate, -- 手动插入TV字段，应用于分区（该值不应为空）
		a.debtid, -- 临时存储所属老表债务ID
		a.orderid -- 临时存储该次偿还在老系统的订单编号（可能存在一个order对应多个debt）
	FROM tmp_hzjl a, vd_a_rcvbl_flow b, vd_a_pay_flow c
	WHERE a.DEBTID = b.DEBTID AND a.orderid = b.ORDERID
	AND a.DEBTID = c.DEBTID AND a.orderid = c.ORDERID;

	# 5-插入 实收表（债务）
	INSERT INTO vd_a_rcved_debt
		(lessee_id, rcved_debt_id, rcvbl_debt_id, rcved_amt_id, this_rcved_amt, remark, org_id, tv)
	SELECT
		2, AMI_GET_SEQUENCE('SEQ_VD_A_RCVED_DEBT'), b.RCVBL_AMT_ID, c.RCVED_AMT_ID, a.paymoney, 'Centlec debt record', b.ORG_ID,
		a.paydate -- 手动插入TV字段，应用于分区（该值不应为空）
	FROM tmp_hzjl a, vd_a_rcvbl_flow b, vd_a_rcved_flow c
	WHERE a.DEBTID = b.DEBTID AND a.orderid = b.ORDERID
	AND a.DEBTID = c.DEBTID AND a.orderid = c.ORDERID;


	IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;

    # 删除索引
    ALTER table vd_a_user_debt DROP INDEX INDEX_vd_a_user_debt_OBJID;
    ALTER table vd_a_pay_flow DROP INDEX INDEX_vd_a_pay_flow_OBJID;
    ALTER table vd_a_rcvbl_flow DROP INDEX INDEX_vd_a_rcvbl_flow_OBJID;

	SELECT t_error, msg;

	/*
	SELECT 	rdb.rcved_amt "rcvedAmt",
				CASE WHEN rdb.remain_debt < rdb.rcved_amt THEN 0 ELSE rdb.remain_debt - rdb.rcved_amt END "remain",
				DATE_FORMAT(pf.charge_date, '%Y-%m-%d %T') "rcvedDate",
				rf.rcvbl_amt_id
	FROM VD_A_RCVBL_FLOW rf, VD_A_RCVBL_DEBT rdb, VD_A_RCVED_FLOW rdf, VD_A_PAY_FLOW pf
	WHERE rf.rcvbl_amt_id = rdb.rcvbl_amt_id AND rdf.rcvbl_amt_id = rf.rcvbl_amt_id
			AND rdf.charge_id = pf.charge_id
			AND rdb.debt_id = 6
			AND rdb.lessee_id = 2
			AND rdf.lessee_id = 2
			AND rf.lessee_id = 2
			AND rf.SETTLE_FLAG != '05'
	*/

END
$$
delimiter ;
------------------------------------sqlserver数据源获取, 72319条-------------------------------------------
-- 作废，将还债记录与售电记录一起迁移
-- select * from (
-- select cast(od.ORDERSID as varchar) orderid,od.DEBTID, od.USER_ID as CUSTOMER_ID,m.MT_COMM_ADDR,
-- od.DE_AMOUNT paymoney,od.DE_BANLANCE as payedBalance,od.DE_DATE paydate,u.USER_ACCOUNT as operator
-- , 0 payType
-- from ORDER_DEBTS od
-- LEFT JOIN IPARA_MTRPOINT m on od.METERID=m.MTRPOINT_ID
-- LEFT JOIN ORDER_TRN o on o.ORDERSID=od.ORDERSID
-- LEFT JOIN IAUDIT_USER u on u.USER_ID=o.OPERATORID
-- where o.DELFLAG = 0 --order by od.USER_ID,od.METERID,od.DE_DATE
-- and exists(select * from ipara_debt d where d.debtid=od.debtid)
-- union all
-- select '' as orderid, d.DEBTID, d.CUSTOMER_ID,m.MT_COMM_ADDR as MT_COMM_ADDR,
-- d.CURENTBLC paymoney, 0 payedBalance,d.OPERATE_DATE paydate, u.USER_ACCOUNT as operator
-- , 1 payType
--  from IPARA_DEBT d
--  LEFT JOIN IPARA_MTRPOINT m on d.CUSTOMER_ID=m.ACTUAL_CUSTOMER_ID
--  LEFT JOIN IAUDIT_USER u on u.USER_ID = d.OPERATOR_ID
--  where d.OKFLAG<>0 and d.CURENTBLC<>0
-- ) t
-- order by t.CUSTOMER_ID,t.paydate

-- 需要重新整理 订单号1-n还债记录 关系
select  cast(od.ORDERSID as varchar) orderid, -- 订单号
        od.DEBTID, -- 老债务ID
        od.USER_ID as CUSTOMER_ID, -- 老用户号
        m.MT_COMM_ADDR, -- 表号
        cast(ROUND(od.DE_AMOUNT,2) as numeric(18,2)) paymoney, -- 还债金额
        cast(ROUND(od.DE_BANLANCE,2)as numeric(18,2)) as payedBalance, -- 还债之后剩余债务
        od.DE_DATE paydate -- 还债日期
from ORDER_DEBTS od
LEFT JOIN IPARA_MTRPOINT m on od.METERID=m.MTRPOINT_ID
where exists(select * from ipara_debt d where d.debtid=od.debtid)
order by od.USER_ID,od.DE_DATE

-------------------------------------tmp_hzjl  自动建表语句-----------------------------------------
CREATE TABLE `tmp_hzjl` (
  `orderid` varchar(128) NOT NULL,
  `DEBTID` varchar(128) NOT NULL,
  `CUSTOMER_ID` varchar(128) DEFAULT NULL,
  `MT_COMM_ADDR` varchar(128) DEFAULT NULL,
  `paymoney` decimal(18, 2) DEFAULT NULL,
  `payedBalance` decimal(18, 2) DEFAULT NULL,
  `paydate` DATETIME DEFAULT NULL,
--   `operator` varchar(128) DEFAULT NULL,
--   `payType` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`orderid`,`DEBTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;