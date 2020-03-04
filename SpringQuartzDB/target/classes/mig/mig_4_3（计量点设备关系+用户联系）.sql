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

	# 4-插入计量点-设备关系
	INSERT INTO a_mp_equipment_rela
		(mp_id, equipmenttype, equipmentid, change_time, STATUS)
	SELECT
		a.mp_id, '02', b.meter_id, SYSDATE(), 'Y'
	FROM a_usagepoint a, a_equip_meter b
	WHERE SUBSTRING_INDEX(a.mp_no,'_',-1) = b.assetno;

	# 5-保存用户联系方式(后期添加性别字段！！！)
	INSERT INTO a_consumer_contacts
		(contactsid, contacts_name, contacts_type, phone_number, telephonenumber, email, cons_id, status, is_recieve_mail)
	SELECT
		AMI_GET_SEQUENCE('S_AMI_FILE'), b.customer_name, '03',
		replace(b.LINKMAN_PHONE, ' ', ''), replace(b.LINKMAN_PHONE, ' ', ''), b.US_EMAIL,
		a.cons_id, 'Y', 'Y'
	FROM a_consumer a, tmp_yh b
	WHERE a.cons_no = CONCAT('yh_', b.CUSTOMER_ID) AND (b.LINKMAN_PHONE <> '' OR b.US_EMAIL <> '');

	IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;
	SELECT t_error, msg;
END