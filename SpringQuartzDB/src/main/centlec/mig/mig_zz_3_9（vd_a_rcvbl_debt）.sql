DROP PROCEDURE IF EXISTS mig_zz_3_9;
delimiter $$
CREATE PROCEDURE mig_zz_3_9()

BEGIN
    DECLARE start_year int default 2016;    /* ++++++根据执行库的年份修改，脚本必须在指定库上执行++++++ */
    DECLARE db_name VARCHAR(16);
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
-- 	DECLARE start_line int default 0;
-- 	DECLARE offset int default 200000; -- 一次最多插35W，否则就报3100，所以只能分页插，20W耗时59s
-- 	DECLARE total int default 60000000; -- 必须是offset的倍数（待定）
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

    # 添加辅助索引
    SET db_name = (select CONCAT('centlec', start_year));
    IF NOT EXISTS(SELECT * FROM information_schema.statistics WHERE TABLE_SCHEMA = db_name AND table_name='vd_a_user_debt' AND index_name='index_vd_a_user_debt_objid') THEN
		ALTER table vd_a_user_debt ADD INDEX index_vd_a_user_debt_objid(debt_from_obj_id);
	END IF;

    # 1-插入 应收债务明细（还债记录里面可能找不到sdjl里面的ordersid，一个ordersid有可能对应多种债务，所以记录数可能比应收债务数多，也可能少）（10s）
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
    FROM vd_a_rcvbl_flow rcvblflow
    INNER JOIN tmp_hzjl hzjl ON rcvblflow.orderid = hzjl.orderid -- 一个售电订单可能偿还2种债务
    LEFT JOIN vd_a_user_debt debt ON hzjl.DEBTID = debt.debt_from_obj_id
    WHERE rcvblflow.amt_type = '11';

    # vd_a_rcvbl_debt.RCVBL_AMT_ID
    SET db_name = (select CONCAT('centlec', start_year));
    IF NOT EXISTS(SELECT * FROM information_schema.statistics WHERE TABLE_SCHEMA = db_name AND table_name='vd_a_rcvbl_debt' AND index_name='index_vd_a_rcvbl_debt_rcvblamtid') THEN
		ALTER table vd_a_rcvbl_debt ADD INDEX index_vd_a_rcvbl_debt_rcvblamtid(RCVBL_AMT_ID); -- 1s 插实收小弟的时候需要用到
	END IF;
	# 删除辅助索引
	ALTER table vd_a_user_debt DROP INDEX index_vd_a_user_debt_objid;


    SELECT t_error, msg;
END
$$
delimiter ;


CALL mig_zz_3_9();