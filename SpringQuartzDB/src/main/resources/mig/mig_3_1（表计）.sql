--------------------------先检查PCODE表型脚本，乱减空格的问题是否已修复！！！！！！表型名称必须严格对应，否则必须执行TODO List里面的update脚本-------------------------
BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

	# 0-索引
	IF NOT EXISTS(SELECT * FROM information_schema.statistics WHERE table_name='tmp_bj' AND index_name='index_tmp_bj_cusid') THEN
		ALTER table tmp_bj ADD INDEX index_tmp_bj_cusid(customer_id);
	END IF;
	IF NOT EXISTS(SELECT * FROM information_schema.statistics WHERE table_name='tmp_bj' AND index_name='index_tmp_bj_meterno') THEN
		ALTER table tmp_bj ADD INDEX index_tmp_bj_meterno(MT_COMM_ADDR);
	END IF;

	# 开启事务
	START TRANSACTION;

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
		CASE
			WHEN b.customer_id = '' THEN '01'	-- 未绑用户，则认为‘状态’是01入库
			ELSE '02' 							-- 绑了用户，则认为‘状态’是02运行
			END, 								-- 'dbzt'电表状态：01入库Warehouse、02运行/装出Installed、03投运Running、04拆回Uninstalled
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

------sqlserver数据源获取(建议马上同时取得用户档案tmp_yh ！！！防止迁移过程中用户档案继续建立的问题)----------------

select  mt.MT_MODEL_DESC,
        ltrim(rtrim(MT_COMM_ADDR)) MT_COMM_ADDR,
        isnull((case when r.CUSTOMER_ID IS null then m.POWER_SUPPLYER else r.POWER_SUPPLYER end),-1) as station_id,
        isnull((case when r.CUSTOMER_ID IS null then ol.OBJECT_ID else ol2.OBJECT_ID end),-1) as LINE_ID,
        isnull((case when r.CUSTOMER_ID IS null then os.OBJECT_ID else os2.OBJECT_ID end),-1) as SUBURB_ID,
        isnull(MUS_TI,0)as MUS_TI,
        RIGHT('000000'+CAST(MUS_SGCID as varchar(10)),6)as MUS_SGCID,
        isnull(MUS_KEYVISION,0)as MUS_KEYVISION,
        isnull(MUS_KEYEXPIRY,0)as MUS_KEYEXPIRY,
        isnull(CONVERT(VARCHAR(19), LASTVENDDATE, 120),'') as LASTVENDDATE,
        isnull(CONVERT(VARCHAR(19), LASTVENDFREEDATE, 120),'') as LASTVENDFREEDATE,
        isnull(tg.TG_NAME,'') as TARIFFNAME,
        isnull(cast(r.CUSTOMER_ID as varchar),'') as CUSTOMER_ID,
        isnull(kms.NAME,'') as MeterStatus
from IPARA_MTRPOINT m
left join IKERNEL_MT_TYPE mt on mt.MT_MODEL_ID=m.MT_MODEL_ID
left join IPARA_RESIDENT r on m.ACTUAL_CUSTOMER_ID=r.CUSTOMER_ID
left join IPARA_MTRSTATUS ms on ms.MTRPOINT_ID=m.MTRPOINT_ID
left join IKERNEL_MTRSTATUS kms on kms.ID=ms.STATUS_ID
left join IPARA_OBJECT ot on ot.OBJECT_ID=r.POWER_SUPPLYER
left join TARIFF_GROUP tg on tg.TARIFFGROUPID=ot.TARIFFGROUPID
left join IPARA_OBJECT ol on ol.OBJECT_ID=m.LINE_ID and ol.POWER_SUPPLYER=m.POWER_SUPPLYER
left join IPARA_OBJECT ol2 on ol2.OBJECT_ID=r.LINE_ID and ol2.POWER_SUPPLYER=r.POWER_SUPPLYER
left join IPARA_OBJECT os on os.OBJECT_ID=m.SUBURB_ID and os.POWER_SUPPLYER=m.POWER_SUPPLYER
left join IPARA_OBJECT os2 on os2.OBJECT_ID=r.SUBURB_ID and os2.POWER_SUPPLYER=r.POWER_SUPPLYER
where m.MTRPOINT_ID<>269586

-------------------------------------tmp_zxb  自动建表语句-----------------------------------------

CREATE TABLE `tmp_bj` (
  `MT_MODEL_DESC` varchar(128) DEFAULT NULL,
  `MT_COMM_ADDR` varchar(128) NOT NULL,
  `station_id` varchar(128) DEFAULT NULL,
  `LINE_ID` varchar(128) DEFAULT NULL,
  `SUBURB_ID` varchar(128) DEFAULT NULL,
  `MUS_TI` varchar(128) DEFAULT NULL,
  `MUS_SGCID` varchar(128) DEFAULT NULL,
  `MUS_KEYVISION` varchar(128) DEFAULT NULL,
  `MUS_KEYEXPIRY` varchar(128) DEFAULT NULL,
  `LASTVENDDATE` varchar(128) DEFAULT NULL,
  `LASTVENDFREEDATE` varchar(128) DEFAULT NULL,
  `TARIFFNAME` varchar(128) DEFAULT NULL,
  `CUSTOMER_ID` varchar(128) DEFAULT NULL,
  `MeterStatus` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`MT_COMM_ADDR`),
  KEY `index_bj_customerid` (`CUSTOMER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




