DROP PROCEDURE IF EXISTS mig_zz_3_6;
delimiter $$
CREATE PROCEDURE mig_zz_3_6()

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

    # 1-插入 预付费计费参数
	INSERT INTO vd_e_calc_pp_parm_2015
		(`LESSEE_ID`, `CALC_ID`, `RECHARGE_TYPE`, `AMOUNT`, `TV`, ORDERID)
	SELECT
		2,
		AMI_GET_SEQUENCE('SEQ_VD_E_CALC_PP_PARM'), -- PK 计算标识
        '01', -- RECHARGE_TYPE 充值方式 01-金额
        flow.rcvd_amt, -- 数量
        flow.tv, -- 分区字段
        flow.orderid -- 临时造的关联字段
	FROM vd_a_pay_flow_2015 flow; -- 与收费明细一对一

    IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;

    SELECT t_error, msg;

END
$$
delimiter ;
