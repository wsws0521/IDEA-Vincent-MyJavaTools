-- ----sqlyog执行了53s-------------------------
DROP PROCEDURE IF EXISTS mig_3_2;
delimiter $$
CREATE PROCEDURE mig_3_2()

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

	# 3-插入表计预付费表
	INSERT INTO a_equip_meter_vending
		(meter_id, vk_id, ti, keyno)
	SELECT
		a.meter_id, c.vk_id, b.mus_ti, NULL
	FROM
		A_EQUIP_METER a, tmp_bj b, vd_p_vk c
	WHERE a.assetno = b.mt_comm_addr
		AND b.mus_sgcid = c.sgc
		AND b.mus_keyvision = c.krn
		AND b.mus_keyexpiry = c.ken
		AND c.base_time = 1993
		AND c.ms = '02';

	IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;
	SELECT t_error, msg;
END

$$
delimiter ;

CALL mig_3_2();