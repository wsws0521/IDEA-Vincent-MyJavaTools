BEGIN

	DECLARE var_consid VARCHAR(64); 			/* 对应用户id */
	DECLARE var_hasfree INT DEFAULT 0; 			/* 用户是否有免费额度 */
	DECLARE var_iffreeamt INT DEFAULT 0; 		/* 本月是否已经使用免费额度 */

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

	# 1-删除已有数据
	DELETE FROM VD_C_CUMU_VALUE;

	# 2-插入累计值
	INSERT INTO VD_C_CUMU_VALUE
	 (LESSEE_ID,
		CUMU_ID,
		RULE_ID,
		CUMU_OBJ,
		CUMU_OBJ_ID,
		CUMU_ITEM,
		START_TIME,
		END_TIME,
		CUMU_VALUE,
		VALUE_UNIT)
	SELECT
		2,
		AMI_GET_SEQUENCE('SEQ_VD_C_CUMU_VALUE'),
		NULL,
		'03', -- 累计值所属对象：01用户02计量点03电表
		b.meter_id,
		'0301', -- 累计数据项 0101免费额度0301累计充值量(资源/钱)0302累计充值金额(实收)
		DATE_ADD(CURDATE(), INTERVAL -DAY(CURDATE()) + 1 DAY), -- 累计开始时间
		LAST_DAY(CURDATE()), -- 累计结束时间
		-- DATE_ADD(DATE_ADD(CURDATE(), INTERVAL -DAY(CURDATE())+1 DAY), INTERVAL 1 MONTH),
		a.energy,
		'KWH'
	FROM tmp_ljz a, A_EQUIP_METER b
    WHERE a.mt_comm_addr  = b.assetno and a.ISFREE = 0 and a.ISUSED = 0;

    # 更新状态为已使用
    update tmp_ljz a INNER JOIN A_EQUIP_METER b on a.mt_comm_addr  = b.assetno and a.ISFREE = 0 and a.ISUSED = 0
    set a.ISUSED = 1;

	# 3-表计本月已享受免费购电，添加到绑定用户的累计值
	INSERT INTO vd_c_cumu_value
		(lessee_id, cumu_id, rule_id, cumu_obj, cumu_obj_id, cumu_item, start_time, end_time, cumu_value, value_unit)
	SELECT
		2, AMI_GET_SEQUENCE('SEQ_VD_C_CUMU_VALUE'), NULL, '01', d.CONS_ID, '0101',
		DATE_ADD(CURDATE(), INTERVAL -DAY(CURDATE()) + 1 DAY), -- 累计开始时间
		LAST_DAY(CURDATE()), -- 累计结束时间
		-- DATE_ADD(DATE_ADD(CURDATE(), INTERVAL -DAY(CURDATE())+1 DAY), INTERVAL 1 MONTH),
		50, -- 免费额度使用50kwh，默认ljz里面的此类energy都是50
		'KWH'
    from tmp_ljz a
    INNER JOIN A_EQUIP_METER b on a.mt_comm_addr  = b.assetno
    INNER JOIN a_mp_equipment_rela c on b.METER_ID = c.EQUIPMENTID and c.EQUIPMENTTYPE = '02'
    INNER JOIN a_usagepoint d on c.MP_ID = d.MP_ID
    where a.ISFREE = 1 and a.ISUSED = 0;
    -- a_consumer.elec_type_code = '201' 乡村居民用电（默认ljz里面的FBE表都属于此类用户）

    # 更新状态为已使用
    update tmp_ljz a
    INNER JOIN (select b.assetno from A_EQUIP_METER b
                INNER JOIN a_mp_equipment_rela c on b.METER_ID = c.EQUIPMENTID and c.EQUIPMENTTYPE = '02'
                INNER JOIN a_usagepoint d on c.MP_ID = d.MP_ID) tt
    on a.mt_comm_addr  = tt.assetno and a.ISFREE = 1 and a.ISUSED = 0
    set a.ISUSED = 1;


	IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;
	SELECT t_error, msg;

END


------------------------------------sqlserver数据源获取-------------------------------------------
SELECT SUM(OCD_ENERGY) energy,
        m.MT_COMM_ADDR,
        convert(varchar(19),max(o.OD_DATE),120) as LASTVENDDATE,
        o.ISFREE,
        '0' as ISUSED
FROM ORDER_trn o
inner join IPARA_MTRPOINT m on o.METERID=m.MTRPOINT_ID
inner join IPARA_RESIDENT r on r.CUSTOMER_ID=m.ACTUAL_CUSTOMER_ID
where   m.ACTUAL_CUSTOMER_ID is not null
        and isnull(o.DELFLAG,0)=0
        and DATEDIFF(MONTH,o.OD_DATE,GETDATE())=0
group by m.MT_COMM_ADDR,o.ISFREE

-------------------------------------tmp_ljz  自动建表语句-----------------------------------------
CREATE TABLE `tmp_ljz` (
  `energy` varchar(128) DEFAULT NULL,
  `MT_COMM_ADDR` varchar(128) NOT NULL,
  `LASTVENDDATE` varchar(128) NOT NULL,
  `ISFREE` varchar(128) NOT NULL,
  `ISUSED` varchar(128) NOT NULL,
  `meterId` varchar(128) DEFAULT NULL COMMENT 'NULL',
  `consId` varchar(128) DEFAULT NULL COMMENT 'NULL',
  `energy_old` varchar(128) DEFAULT NULL COMMENT 'NULL',
  `MT_COMM_ADDR_old` varchar(128) DEFAULT NULL COMMENT 'NULL',
  `LASTVENDDATE_old` varchar(128) DEFAULT NULL COMMENT 'NULL',
  `ISFREE_old` varchar(128) DEFAULT NULL COMMENT 'NULL',
  `ISUSED_old` varchar(128) DEFAULT NULL COMMENT 'NULL',
  PRIMARY KEY (`MT_COMM_ADDR`,`LASTVENDDATE`,`ISFREE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;



