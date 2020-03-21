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

    # 迁移插入 a_data_catalogue（同步*换绑脚本在syn_3_2 | 同步*新增脚本在syn_5_3）
    INSERT INTO `a_data_catalogue`
        (`DATA_ID`, `ORG_NO`, `CONS_ID`, `CONS_NO`, `CONS_NAME`, `CONS_SORT_TYPE`, `ED_ID`,
        `DEVICE_C`, `ED_ASSET_NO`, `LOGICAL_ADDRESS`, `METER_ID`, `METER_ASSET_NO`, `MP_ID`, `MP_NO`, `MP_NAME`,
        `TYPE_CODE`, `RATE`, `PT`, `CT`, `TF_ID`, `TF_NO`, `TF_NAME`, `LINE_ID`, `LINE_NO`, `LINE_NAME`,
        `EFFECT_TIME`, `DISCARD_TIME`, `STATUS`, `MDC_ID`)
    SELECT
        AMI_GET_SEQUENCE('S_AMI_FILE'), -- DATA_ID 数据主表id自增，序列用的是S_AMI_FILE
        u.org_no, -- ORG_NO
        c.cons_id, -- CONS_ID
        c.CONS_NO, -- CONS_NO
        c.CONS_NAME, -- CONS_NAME
        c.CONS_SORT_CODE, -- CONS_SORT_TYPE
        NULL, -- ED_ID 终端ID
        NULL, -- DEVICE_C
        NULL, -- ED_ASSET_NO 终端号
        NULL, -- LOGICAL_ADDRESS 终端逻辑地址对应A_EQUIP_ENDDEVICE的logical_address字段
        m.METER_ID, -- METER_ID
        m.ASSETNO, -- METER_ASSET_NO
        u.MP_ID, -- MP_ID
        u.MP_NO, -- MP_NO
        u.MP_NAME, -- MP_NAME
        u.TYPE_CODE, -- TYPE_CODE jldfl计量点分类：02线路关口03配变04用电客户05虚拟计量点
        '1.00000', -- RATE，默认是1
        u.PT, -- PT
        u.CT, -- CT
        tf.TF_ID, -- TF_ID
        tf.TF_NO, -- TF_NO
        tf.TF_NAME, -- TF_NAME
        line.LINE_ID, -- LINE_ID
        line.LINE_NO, -- LINE_NO
        line.LINE_NAME, -- LINE_NAME
        m.INSTALLATIONDATE, -- EFFECT_TIME 生效时间,就按电表的安装时间(系统实际生成的会迟2min)
        NULL, -- DISCARD_TIME 对应下面状态为0时的废弃时间
        '1', -- STATUS 状态：1是有效，0是无效，即废弃
        '2' -- MDC_ID
    FROM a_usagepoint u
    LEFT JOIN a_consumer c ON u.CONS_ID = c.CONS_ID
    LEFT JOIN a_mp_equipment_rela r ON u.MP_ID = r.MP_ID AND r.EQUIPMENTTYPE = '02' AND r.STATUS = 'Y'
    LEFT JOIN a_equip_meter m ON r.EQUIPMENTID = m.METER_ID
    LEFT JOIN a_grid_transformer tf ON u.TF_ID = tf.TF_ID
    LEFT JOIN a_grid_line line ON u.LINE_ID = line.LINE_ID
    WHERE m.METER_ID IS NOT NULL -- 对于已经解绑计量点-表计的就不再插入了
        AND NOT EXISTS
        (select 1 from a_data_catalogue cata
        where cata.METER_ID is not null and m.METER_ID = cata.METER_ID -- 以 METER_ID 为基准
            and cata.STATUS = '1');

	IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;

	SELECT t_error, msg;
END