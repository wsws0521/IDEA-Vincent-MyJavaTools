DROP PROCEDURE IF EXISTS syn_zz_3_9;
delimiter $$
CREATE PROCEDURE syn_zz_3_9()(OUT `error_code` integer, OUT `error_msg` text)

BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

    # 1-插入 应收债务明细（还债记录里面可能找不到sdjl里面的ordersid，一个ordersid有可能对应多种债务，所以记录数可能比应收债务数多，也可能少）
    INSERT INTO vd_a_rcvbl_debt
        (`LESSEE_ID`, `RCVBL_DEBT_ID`, `RCVBL_AMT_ID`, `DEBT_ID`, `DEBT_TYPE`, `AMOUNT`, `REMAIN_DEBT`, `DEBT_VALUE`,
        `EXPIRED_DATE`, `RCVED_AMT`, `ORG_ID`, `RCVBL_AMT`, `TV`)
    SELECT
        2, AMI_GET_SEQUENCE('SEQ_VD_A_RCVBL_DEBT'), -- RCVBL_DEBT_ID
        rcvblflow.RCVBL_AMT_ID, -- RCVBL_AMT_ID
        debt.DEBT_ID, -- DEBT_ID 债务ID FK
        debt.DEBT_TYPE, -- DEBT_TYPE 债务类型 zwsqlx债务收取类型: 01 按购电百分比 02 按截止日期 03一次性付清 04 债务百分比按次 05 债务百分比按月 06 固定金额按次 07固定金额按月 08 按总金额百分比（新增）
        debt.debt_amount, -- AMOUNT 债务总金额
        hzjl.payedBalance + hzjl.paymoney, -- 剩余债务：存此笔偿还之前的剩余
        debt.DEBT_VALUE, -- DEBT_VALUE 债务值/收取的值：购电百分比的值，固定金额的值等eg:30.00
        debt.EXPIRED_DATE, -- EXPIRED_DATE
        hzjl.paymoney, -- RCVED_AMT
        rcvblflow.ORG_ID, -- ORG_ID
        hzjl.paymoney, -- RCVBL_AMT
        hzjl.paydate -- 手动插入TV字段，应用于分区（该值不应为空）
    FROM tmp_sdjl sdjl
    INNER JOIN vd_a_rcvbl_flow rcvblflow ON sdjl.ORDERSID = rcvblflow.orderid and rcvblflow.amt_type = '11'
    INNER JOIN tmp_hzjl hzjl ON rcvblflow.orderid = hzjl.orderid -- 一个售电订单可能偿还2种债务
    LEFT JOIN vd_a_user_debt debt ON hzjl.DEBTID = debt.debt_from_obj_id;

    # vd_a_rcvbl_debt.RCVBL_AMT_ID
    IF NOT EXISTS(SELECT * FROM information_schema.statistics WHERE table_name='vd_a_rcvbl_debt' AND index_name='index_vd_a_rcvbl_debt_rcvblamtid') THEN
		ALTER table vd_a_rcvbl_debt ADD INDEX index_vd_a_rcvbl_debt_rcvblamtid(RCVBL_AMT_ID); -- 1s 插实收小弟的时候需要用到
	END IF;


    SELECT t_error into error_code;
    SELECT msg into error_msg;
END
$$
delimiter ;
