DROP PROCEDURE IF EXISTS syn_zz_3_3;
delimiter $$
CREATE PROCEDURE syn_zz_3_3()(OUT `error_code` integer, OUT `error_msg` text)

BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

    # 1-循环插入 票据关系 (1h36min)
    INSERT INTO vd_a_charge_inv_rel
        (`LESSEE_ID`, `REL_ID`, `NOTE_ID`, `CHARGE_ID`, `TV`)
    SELECT
        2,
        AMI_GET_SEQUENCE('SEQ_VD_A_CHARGE_INV_REL'), -- REL_ID
        inv.NOTE_ID, -- NOTE_ID 票据标识PK
        inv.CHARGEID, -- CHARGE_ID 收费标识
        inv.tv -- 手动插入TV字段，应用于分区（该值不应为空）
    FROM tmp_sdjl sdjl
    INNER JOIN vd_a_pay_flow flow ON sdjl.ORDERSID = flow.orderid
    INNER JOIN vd_a_inv inv ON flow.charge_id = inv.CHARGEID;

    SELECT t_error into error_code;
    SELECT msg into error_msg;
END
$$
delimiter ;

