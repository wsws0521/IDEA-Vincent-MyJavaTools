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

	CREATE TEMPORARY TABLE temp_bj SELECT bj.*,bj1.mus_sgcid as mus_sgcidold,bj1.mus_keyvision as mus_keyvisionold,bj1.mus_keyexpiry as mus_keyexpiryold
			FROM tmp_bj bj INNER JOIN tmp_bj1 bj1 ON bj.mt_comm_addr=bj1.mt_comm_addr AND (bj1.mus_sgcid!=bj.mus_sgcid or bj1.mus_keyvision!= bj.mus_keyvision
			or bj1.mus_keyexpiry!= bj.mus_keyexpiry);

	# 0-更新表计vk_id
	UPDATE a_equip_meter_vending meterVK INNER JOIN (
		SELECT vkNew.VK_ID,meter.meter_id,vkOld.vk_id AS vk_idold
		FROM temp_bj bj
		INNER JOIN a_equip_meter meter ON bj.mt_comm_addr = meter.ASSETNO
		LEFT JOIN vd_p_vk vkOld ON bj.mus_sgcidold = vkOld.sgc AND vkOld.ms = '02' AND vkOld.BASE_TIME=1993
			AND bj.mus_keyvisionold = vkOld.krn AND bj.mus_keyexpiryold = vkOld.ken
		LEFT JOIN vd_p_vk vkNew ON bj.mus_sgcid = vkNew.sgc AND vkNew.ms = '02' AND vkNew.BASE_TIME=1993
			AND bj.mus_keyvision = vkNew.krn AND bj.mus_keyexpiry = vkNew.ken) tb ON
		meterVK.meter_id = tb.meter_id AND tb.vk_idold=meterVK.VK_ID
	SET meterVK.VK_ID=tb.VK_ID;

	DROP TEMPORARY TABLE IF EXISTS temp_bj;
	CREATE TEMPORARY TABLE temp_bj SELECT bj.*,bj1.mus_ti AS mus_tiold
			FROM tmp_bj bj INNER JOIN tmp_bj1 bj1 ON bj.mt_comm_addr=bj1.mt_comm_addr AND bj1.mus_ti!=bj.mus_ti;

	#1-更新表计ti
	UPDATE a_equip_meter_vending meterVK INNER JOIN (SELECT bj.mus_ti,bj.mus_tiold,meter.meter_id
		FROM temp_bj bj
		INNER JOIN a_equip_meter meter ON bj.mt_comm_addr = meter.ASSETNO) tb
		ON meterVK.ti=tb.mus_tiold AND meterVK.meter_id = tb.meter_id
	SET meterVK.ti=tb.mus_ti;

	DROP TEMPORARY TABLE IF EXISTS temp_bj;

	IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;
	SELECT t_error, msg;
END