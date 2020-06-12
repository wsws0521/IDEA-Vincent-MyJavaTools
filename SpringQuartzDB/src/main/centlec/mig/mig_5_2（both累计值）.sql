DROP PROCEDURE IF EXISTS mig_5_2;
delimiter $$
CREATE PROCEDURE mig_5_2()

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
		VALUE_UNIT,
		tv)
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
		'KWH',
		a.LASTVENDDATE
	FROM tmp_ljz a, A_EQUIP_METER b
    WHERE a.mt_comm_addr  = b.assetno and a.ISFREE = 0 and a.ISUSED = 0;

    # 更新状态为已使用
    update tmp_ljz a INNER JOIN A_EQUIP_METER b on a.mt_comm_addr  = b.assetno and a.ISFREE = 0 and a.ISUSED = 0
    set a.ISUSED = 1;

	# 3-表计本月已享受免费购电，添加到绑定用户的累计值
	INSERT INTO vd_c_cumu_value
		(lessee_id, cumu_id, rule_id, cumu_obj, cumu_obj_id, cumu_item, start_time, end_time, cumu_value, value_unit, tv)
	SELECT
		2, AMI_GET_SEQUENCE('SEQ_VD_C_CUMU_VALUE'), NULL, '01', d.CONS_ID, '0101',
		DATE_ADD(CURDATE(), INTERVAL -DAY(CURDATE()) + 1 DAY), -- 累计开始时间
		LAST_DAY(CURDATE()), -- 累计结束时间
		-- DATE_ADD(DATE_ADD(CURDATE(), INTERVAL -DAY(CURDATE())+1 DAY), INTERVAL 1 MONTH),
		50, -- 免费额度使用50kwh，默认ljz里面的此类energy都是50
		'KWH',
		a.LASTVENDDATE
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

$$
delimiter ;


CALL mig_5_2();
