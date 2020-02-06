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

	# 1-插入计量点-设备关系
	INSERT INTO a_mp_equipment_rela
		(mp_id, equipmenttype, equipmentid, change_time, STATUS)
	SELECT a.mp_id, '02', b.meter_id, SYSDATE(), 'Y'
	FROM a_usagepoint a
	INNER JOIN a_equip_meter b ON SUBSTRING_INDEX(a.mp_no,'_',-1) = b.assetno AND  b.meter_mode='02'
	WHERE NOT EXISTS(SELECT rela.MP_ID FROM a_mp_equipment_rela rela WHERE rela.MP_ID = a.mp_id
				AND rela.equipmentid = b.meter_id AND rela.equipmenttype='02');

	# 2-保存用户联系方式
	INSERT INTO a_consumer_contacts
		(contactsid, contacts_name, contacts_type, phone_number, telephonenumber, email, cons_id, STATUS, is_recieve_mail)
	SELECT
		AMI_GET_SEQUENCE('S_AMI_FILE'), b.customer_name, '03',
		REPLACE(b.LINKMAN_PHONE, ' ', ''), REPLACE(b.LINKMAN_PHONE, ' ', ''), b.US_EMAIL, a.cons_id, 'Y', 'Y'
	FROM a_consumer a
	INNER JOIN tmp_yh b ON (b.LINKMAN_PHONE <> '' OR b.US_EMAIL <> '') AND a.cons_no = CONCAT('yh_', b.CUSTOMER_ID)
	WHERE NOT EXISTS(SELECT c.CUSTOMER_ID FROM tmp_yh1 c WHERE c.CUSTOMER_ID = b.CUSTOMER_ID);

	IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;

	SELECT t_error into error_code;
	SELECT msg into error_msg;
END;