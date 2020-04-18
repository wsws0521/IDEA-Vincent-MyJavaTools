DROP PROCEDURE IF EXISTS mig_zz_3_2;
delimiter $$
CREATE PROCEDURE mig_zz_3_2()

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

    # 1-插入 票据关系
	INSERT INTO vd_a_charge_inv_rel_2015
		(`LESSEE_ID`, `REL_ID`, `NOTE_ID`, `CHARGE_ID`, `TV`)
	SELECT
		2,
		AMI_GET_SEQUENCE('SEQ_VD_A_CHARGE_INV_REL'), -- REL_ID
		inv.NOTE_ID, -- NOTE_ID 票据标识PK
		inv.CHARGEID, -- CHARGE_ID 收费标识
        inv.tv -- 手动插入TV字段，应用于分区（该值不应为空）
	FROM vd_a_inv_2015 inv;

    IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;

    SELECT t_error, msg;

END
$$
delimiter ;
