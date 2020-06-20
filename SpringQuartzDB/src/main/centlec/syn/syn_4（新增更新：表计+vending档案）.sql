DROP PROCEDURE IF EXISTS syn_4;
delimiter $$
CREATE PROCEDURE syn_4(OUT `error_code` integer, OUT `error_msg` text)

BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg TEXT;
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	BEGIN
		get diagnostics CONDITION 1 msg = message_text;
		SET t_error = 1;
	END;
	# 开启事务
	START TRANSACTION;

	# 1-插入表计档案
	INSERT INTO a_equip_meter
		(meter_id, org_no, devicetype_id, assetno, com_address, protocol, TYPE, meter_model, derection, rateself, installationdate, removaldate, longitude, latitude,
		STATUS, manufacturer, out_no, version_serial_no, meter_mode, meter_no, wiringmode, is_bluetooth, bluetooth_name, sim_no, m_position, tariff_type, access_type,
		m_meterbox, socket_server_model, is_solar, install_address, unit_id, ed_no, mgt_status)
	SELECT
		AMI_GET_SEQUENCE('S_AMI_FILE'),					-- 表计ID
		(SELECT NO FROM uap_organization WHERE CODE = CONCAT('ORG_',b.station_id)), -- 单位编号
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
		'01',                                   -- dbzt状态：离线表统一认为是01入库
	--	CASE
	--		WHEN b.customer_id = '' THEN '01'	-- 未绑用户，则认为‘状态’是01入库
	--		ELSE '02' 							-- 未绑用户，则认为‘状态’是02运行
	--		END, 								-- dbzt状态：01入库、02运行、03投运、04拆回
		(SELECT pc.value
			FROM p_sys_code pc
			LEFT JOIN p_sys_code_language pcl ON pc.name = pcl.text_ID
			WHERE cj.MANUFACTURER_DESC IS NOT NULL
			AND pc.code_type = 'dbcj' AND lang = 'en_US'
			AND pcl.text = cj.MANUFACTURER_DESC), 		-- dbcj电表厂家,PCODE 根据表型关联
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
	FROM tmp_bj b LEFT JOIN tmp_dbcj cj ON b.mt_model_desc = cj.MT_MODEL
	WHERE NOT EXISTS(SELECT meter.assetno FROM a_equip_meter meter WHERE b.mt_comm_addr = meter.assetno);

	# 2-插入表计预付费表
	INSERT INTO a_equip_meter_vending
		(meter_id, vk_id, ti, keyno)
	SELECT
		a.meter_id, c.vk_id, b.mus_ti, NULL
	FROM
		A_EQUIP_METER a
		INNER JOIN tmp_bj b ON a.assetno = b.mt_comm_addr
		INNER JOIN vd_p_vk c ON b.mus_sgcid = c.sgc
				AND b.mus_keyvision = c.krn
				AND b.mus_keyexpiry = c.ken
				AND c.ms = '02'
				AND c.base_time=1993
	WHERE a.meter_mode='02' AND NOT EXISTS(SELECT meterVk.METER_ID FROM a_equip_meter_vending meterVk WHERE meterVk.METER_ID=a.METER_ID);

    # 3-更新表计管理状态
    update a_equip_meter meter
    inner join (select bj.mt_comm_addr, pc.value
        from tmp_bj bj
        inner join tmp_bj1 bj1 on bj.mt_comm_addr = bj1.mt_comm_addr and bj.meterstatus != bj1.meterstatus
        LEFT JOIN p_sys_code_language pcl ON bj.meterstatus = pcl.text
		LEFT JOIN p_sys_code pc ON pcl.text_ID = pc.name AND pc.code_type = 'meter_mgt_status' AND lang = 'en_US') tb on meter.assetno = tb.mt_comm_addr
    set meter.mgt_status = tb.value;

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