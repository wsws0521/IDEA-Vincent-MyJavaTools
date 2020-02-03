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

	# 0-索引
	ALTER table tmp_bj ADD INDEX index_tmp_bj_cusid(customer_id);
	ALTER table tmp_bj ADD INDEX index_tmp_bj_meterno(MT_COMM_ADDR);
	# 1-删除已有数据
	DELETE FROM A_MP_EQUIPMENT_RELA;
	DELETE FROM A_EQUIP_METER_VENDING;
	DELETE FROM A_EQUIP_METER;
	DELETE FROM a_meter_batch;
	# 2-插入表计档案
	INSERT INTO a_equip_meter
		(meter_id, org_no, devicetype_id, assetno, com_address, protocol, TYPE, meter_model, derection, rateself, installationdate, removaldate, longitude, latitude,
		STATUS, manufacturer, out_no, version_serial_no, meter_mode, meter_no, wiringmode, is_bluetooth, bluetooth_name, sim_no, m_position, tariff_type, access_type,
		m_meterbox, socket_server_model, is_solar, install_address, unit_id, ed_no, mgt_status)
	SELECT
		AMI_GET_SEQUENCE('S_AMI_FILE'),					-- 表计ID
		(SELECT NO FROM uap_organization WHERE CODE = CONCAT('dw_',b.station_id)), -- 单位编号
		'meter', 										-- 设备类型标识
		b.mt_comm_addr, 								-- 资产编号
		NULL, 											-- 通讯地址
		'03',											-- DLMS规约
		'20', 											-- 离线表
		(SELECT pc.value
			FROM p_sys_code pc
			LEFT JOIN p_sys_code_language pcl ON pc.name = pcl.text_ID
			WHERE pc.code_type = 'bjxh' AND lang = 'en_US'
			AND pcl.text = b.mt_model_desc),			-- bjxh表计型号（PCODE）
		NULL,											-- 安装方向
		NULL,											-- 自身倍率
		CASE
		WHEN b.customer_id = '' THEN NULL																	-- 未绑用户，则认为‘装表日期’是‘null’
		WHEN b.customer_id != '' AND b.lastvenddate = '' THEN CURDATE()										-- 绑了用户，最后购电为null，则认为‘装表日期’是‘当前时间’
		WHEN b.customer_id != '' AND b.lastvenddate != '' AND DATE_FORMAT(b.lastvenddate, '%Y-%m') < DATE_FORMAT(CURDATE(), '%Y-%m')
			THEN DATE_ADD(DATE_ADD(b.lastvenddate, INTERVAL -DAY(b.lastvenddate)+1 DAY), INTERVAL 1 MONTH)	-- 绑了用户，最后购电为当前月以前，则认为‘装表日期’是‘最后购电时间的下月1号’
		ELSE b.lastvenddate																					-- 绑了用户，最后购电为当前月，则认为‘装表日期’是‘最后购电时间’
		END, 											-- 装表日期
		NULL, 											-- 拆除日期
		NULL, 											-- 经度
		NULL, 											-- 纬度
		CASE
			WHEN b.customer_id = '' THEN '01'	-- 未绑用户，则认为‘状态’是01入库
			ELSE '02' 							-- 未绑用户，则认为‘状态’是02运行
			END, 								-- 状态：01入库、02运行、03投运、04拆回
		NULL, 											-- 电表厂家
		NULL, 											-- 外部标识
		NULL, 											-- 功能版本流水号
		'02', 											-- bjms表计模式：01正常模式、02预付费模式
		b.mt_comm_addr, 								-- 表号，同资产编号
		NULL, -- 接线方式
		NULL, -- 是否蓝牙表
		NULL, -- 蓝牙设备名称
		NULL, -- SIM卡号
		NULL, -- v_m_position
		NULL, -- v_tariff_type
		NULL, -- v_access_type
		NULL, -- v_m_meterbox
		NULL, -- v_socket_server_model
		NULL, -- v_is_solar
		NULL, -- v_install_address 安装地址
		NULL, -- v_unit_id
		NULL, -- v_ed_no
		(SELECT pc.value
		FROM p_sys_code pc
		LEFT JOIN p_sys_code_language pcl ON pc.name = pcl.text_ID
		WHERE pc.code_type = 'meter_mgt_status' AND lang = 'en_US'
		AND pcl.text = b.meterstatus) 					-- v_mgt_status 管理状态
	FROM tmp_bj b;


	IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;
	SELECT t_error, msg;
END