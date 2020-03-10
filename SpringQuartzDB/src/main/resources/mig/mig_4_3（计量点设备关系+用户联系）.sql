BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

    IF NOT EXISTS(SELECT * FROM information_schema.statistics WHERE table_name='a_equip_meter' AND index_name='index_a_equip_meter_assetno') THEN
		ALTER table a_equip_meter ADD INDEX index_a_equip_meter_assetno(assetno);
	END IF;


	# 开启事务
	START TRANSACTION;

	# 4-插入计量点-设备关系
	INSERT INTO a_mp_equipment_rela
		(mp_id, equipmenttype, equipmentid, change_time, STATUS)
	SELECT
		a.mp_id, '02', b.meter_id, SYSDATE(), 'Y'
	FROM a_usagepoint a, a_equip_meter b
	WHERE SUBSTRING_INDEX(a.mp_no,'_',-1) = b.assetno;

	# 5-保存用户联系方式
	INSERT INTO a_consumer_contacts
		(contactsid, contacts_name, contacts_type, phone_number, telephonenumber, email, cons_id, status, is_recieve_mail, gender)
	SELECT
		AMI_GET_SEQUENCE('S_AMI_FILE'), b.customer_name, '03',
		replace(b.LINKMAN_PHONE, ' ', ''), replace(b.LINKMAN_PHONE, ' ', ''), b.US_EMAIL,
		a.cons_id, 'Y', 'Y', IF(b.us_sex = 0,'01','02')
	FROM a_consumer a, tmp_yh b
	WHERE a.cons_no = CONCAT('CN_', b.CUSTOMER_ID) AND (b.LINKMAN_PHONE <> '' OR b.US_EMAIL <> '');

	IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;

	-- ALTER table a_equip_meter DROP INDEX index_a_equip_meter_assetno;

	SELECT t_error, msg;
END