DROP PROCEDURE IF EXISTS syn_3_3;
delimiter $$
CREATE PROCEDURE syn_3_3(OUT `error_code` integer, OUT `error_msg` text)

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

	CREATE TEMPORARY TABLE temp_bj
	SELECT bj1.mt_comm_addr,bj1.meterstatus,bj1.customer_id,bj1.customer_id AS customer_idold
	FROM tmp_bj1 bj1
	WHERE NOT EXISTS(SELECT bj.mt_comm_addr FROM tmp_bj bj WHERE bj.mt_comm_addr = bj1.mt_comm_addr);

	/*1-更新表计旧系统状态*/
	/*1-更新表计状态：拆回04*/
	UPDATE a_equip_meter metermain
		INNER JOIN temp_bj tb ON tb.mt_comm_addr=metermain.assetno and metermain.meter_mode='02'
	SET metermain.mgt_status=(SELECT pc.value
		FROM p_sys_code pc
		LEFT JOIN p_sys_code_language pcl ON pc.name = pcl.text_ID
		WHERE pc.code_type = 'meter_mgt_status' AND lang = 'en_US'
		AND pcl.text = 'Meter Deleted')
		, metermain.STATUS='04';

	CREATE TEMPORARY TABLE temp_bj2 SELECT cons.CONS_ID, rela.EQUIPMENTID AS meter_id,rela.mp_id
		FROM a_consumer cons
		INNER JOIN a_usagepoint pointmain ON cons.cons_id = pointmain.cons_id
		INNER JOIN a_mp_equipment_rela rela ON rela.mp_id = pointmain.mp_id AND rela.EQUIPMENTTYPE='02'
		INNER JOIN temp_bj bj ON CONCAT('CN_',bj.customer_idold) = cons.CONS_NO;

	#2-更新计量点设备关联状态*/
	DELETE FROM a_mp_equipment_rela rela where exists(select tb.mp_id from temp_bj2 tb where tb.mp_id=rela.mp_id);

	/*3-删除计量点*/
	DELETE FROM a_usagepoint point where exists(select tb.mp_id from temp_bj2 tb where tb.mp_id=point.mp_id);

	DROP TEMPORARY TABLE IF EXISTS temp_bj;
	DROP TEMPORARY TABLE IF EXISTS temp_bj2;
	/*
	DELETE FROM a_usagepoint point
	WHERE EXISTS(
		SELECT * FROM temp_bj bj INNER JOIN a_equip_meter meter ON bj.mt_comm_addr=meter.assetno
			INNER JOIN a_mp_equipment_rela rela ON meter.METER_ID = rela.EQUIPMENTID AND rela.EQUIPMENTTYPE='02'
			INNER JOIN a_consumer cons ON CONCAT('CN_',bj.customer_idold) = cons.cons_no
			WHERE rela.mp_id=point.mp_id);*/


	IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;
	SELECT t_error into error_code;
	SELECT msg into error_msg;
END
$$
delimiter ;