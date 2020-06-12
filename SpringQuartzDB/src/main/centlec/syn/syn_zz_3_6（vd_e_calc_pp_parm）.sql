DROP PROCEDURE IF EXISTS syn_zz_3_6;
delimiter $$
CREATE PROCEDURE syn_zz_3_6()(OUT `error_code` integer, OUT `error_msg` text)

BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

    # 1-循环插入 预付费计费参数(与收费明细一对一)（1h8min）
    INSERT INTO vd_e_calc_pp_parm
        (`LESSEE_ID`, `CALC_ID`, `RECHARGE_TYPE`, `AMOUNT`, `TV`, chargeid)
    SELECT
        2,
        AMI_GET_SEQUENCE('SEQ_VD_E_CALC_PP_PARM'), -- PK 计算标识
        '01', -- RECHARGE_TYPE 充值方式 01-金额
        flow.rcvd_amt, -- 数量
        flow.tv, -- 分区字段
        flow.charge_id -- 临时造的关联字段
    FROM tmp_sdjl sdjl
    INNER JOIN vd_a_pay_flow flow ON sdjl.ORDERSID = flow.orderid;

    SELECT t_error into error_code;
    SELECT msg into error_msg;
END
$$
delimiter ;
