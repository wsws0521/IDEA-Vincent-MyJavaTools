DROP PROCEDURE IF EXISTS syn_7;
delimiter $$
CREATE PROCEDURE syn_7(OUT `error_code` integer, OUT `error_msg` text)

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
    # 预插 0301
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
        TV,CUMU_VER,CUMU_TIME)
    SELECT
        2,
        AMI_GET_SEQUENCE('SEQ_VD_C_CUMU_VALUE'),
        NULL,
        '03', -- 累计值所属对象：01用户02计量点03电表
        happy.meter_id,
        '0301', -- 累计数据项 0101免费额度0301累计充值量(资源/钱)0302累计充值金额(实收)
        STR_TO_DATE('2020-07-01',"%Y-%m-%d"), -- 累计开始时间
        LAST_DAY(CURDATE()), -- 累计结束时间
        0,
        'KWH',
        SYSDATE(),0,NULL
    FROM A_EQUIP_METER happy
    INNER JOIN a_mp_equipment_rela rela ON happy.METER_ID = rela.EQUIPMENTID AND rela.EQUIPMENTTYPE = '02'
    INNER JOIN a_usagepoint POINT ON rela.mp_id = point.mp_id
    INNER JOIN a_consumer cons ON cons.cons_id = point.cons_id
    WHERE NOT EXISTS(
        SELECT * FROM VD_C_CUMU_VALUE WHERE CUMU_OBJ='03' AND CUMU_OBJ_ID=happy.meter_id
        AND CUMU_ITEM='0301' AND DATE_FORMAT(start_time,'%Y-%m-%d')='2020-07-01');

    # 预插 0101
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
        TV,CUMU_VER,CUMU_TIME)
    SELECT
        2,
        AMI_GET_SEQUENCE('SEQ_VD_C_CUMU_VALUE'),
        NULL,
        '01', -- 累计值所属对象：01用户02计量点03电表
        cons.cons_id,
        '0101', -- 累计数据项 0101免费额度0301累计充值量(资源/钱)0302累计充值金额(实收)
        STR_TO_DATE('2020-07-01',"%Y-%m-%d"), -- 累计开始时间
        LAST_DAY(CURDATE()), -- 累计结束时间
        0,
        NULL,
        SYSDATE(),0,NULL
    FROM A_EQUIP_METER happy
    INNER JOIN a_mp_equipment_rela rela ON happy.METER_ID = rela.EQUIPMENTID AND rela.EQUIPMENTTYPE = '02'
    INNER JOIN a_usagepoint POINT ON rela.mp_id = point.mp_id
    INNER JOIN a_consumer cons ON cons.cons_id = point.cons_id
    WHERE NOT EXISTS(
        SELECT * FROM VD_C_CUMU_VALUE WHERE CUMU_OBJ='01' AND CUMU_OBJ_ID=cons.cons_id
        AND CUMU_ITEM='0101' AND DATE_FORMAT(start_time,'%Y-%m-%d')='2020-07-01');

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