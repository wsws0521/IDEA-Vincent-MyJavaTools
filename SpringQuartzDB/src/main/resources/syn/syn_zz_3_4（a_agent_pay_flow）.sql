DROP PROCEDURE IF EXISTS syn_zz_3_4;
delimiter $$
CREATE PROCEDURE syn_zz_3_4()(OUT `error_code` integer, OUT `error_msg` text)

BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;

	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

    # 1-循环插入 代理商收费记录 -- 与 vd_a_pay_flow 一一对应
    INSERT INTO a_agent_pay_flow
        (`LESSEE_ID`, `AGENT_CHARGE_ID`, `LOG_ID`, `CHARGE_ID`, `CONS_ID`, `TV`)
    SELECT
        2,
        AMI_GET_SEQUENCE('SEQ_A_AGENT_PAY_FLOW'), -- PK
        NULL, -- LOG_ID 交互标识FK
        flow.charge_id, -- CHARGE_ID 收费标识
        agt.AGENT_ID, -- CONS_ID 用户/代理商标识
        flow.tv -- 手动插入TV字段，应用于分区（该值不应为空）
    FROM tmp_sdjl sdjl
    INNER JOIN vd_a_pay_flow flow ON sdjl.ORDERSID = flow.orderid
    LEFT JOIN VD_AGT_AGENT agt ON sdjl.TE_NAME = agt.AGENT_NAME;

    SELECT t_error into error_code;
    SELECT msg into error_msg;
END
$$
delimiter ;
