DROP PROCEDURE IF EXISTS mig_3_3;
delimiter $$
CREATE PROCEDURE mig_3_3()

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


	# 4-插入批次，为本批表中每个表型新建一个基于表型的批次
	INSERT INTO a_meter_batch
		(lessee_id, batch_id, batch_no, remark, tokenparsing_version, encryption_method, recharge_limit, rec_second,
		tct, factory_id, token_version_id, creditmode, vk_id, ti, batch_type, range_type, end_range, preset_amount, start_range)
	SELECT
		2, AMI_GET_SEQUENCE('SEQ_METER_BATCH_ID'), NULL, 'Centlec data transfer',
		1, -- Token解析版本：标准
		'01', -- 加密方式
		NULL, -- 表计充值上限
		1,	-- 是否使用二次侧
		'01', -- 传输介质：键盘
		(select FACTORY_ID from VD_FAT_TOKEN_VERSION where sts_no = 'CentlecSTS1'), -- 厂商ID
		(select STS_ID from VD_FAT_TOKEN_VERSION where sts_no = 'CentlecSTS2'), -- STS标准(STS2！！！！！)
		'01', -- 费控类型：01量控 02费控
		(select vk_id from vd_p_vk where SGC = '008000' and krn = 1 and ken = 255 and ms = '02'), -- vkid
		1, -- ti
		2, -- 批次类型pclx：01表号02表型
		1, -- 范围类型VD_RANGE_TYPE：0-ALL 1-Single
		NULL, -- 结束类型
		NULL, -- 预置金额
		a.VALUE -- 起始值，表型对应的PCODE
	FROM p_sys_code a, p_sys_code_language b
	WHERE a.name = b.TEXT_ID AND a.CODE_TYPE = 'bjxh' AND b.LANG = 'en_US' and a.ISSHOW = 1
	    AND a.VALUE IN (
	    'Actaris Elec (1 Phase) Keypad (STS)',              -- 1
	    'Plessey Elec (1 Phase) Keypad (Sequence P, R)',    -- 2
	    'Plessey Elec (1 Phase) Keypad (Sequence T)',       -- 3
	    'Plessey Elec (1 Phase) Keypad (PTS)',              -- 4
	    'Plessey Elec (3 Phase) Keypad (PTS)',              -- 5
	    'INHEMETER (STS)',                                  -- 6
	    'L+G Elec (1 Phase) Keypad (EML Prop)',             -- 7
	    'Conlog Elec (1 Phase) Magnetic (Conlog Prop)',     -- 8
	    'Credit Electricity Meter',                         -- 9
	    'Credit Water Meter',                               -- 10
	    'Actaris Elec (1 Phase) Magnetic (STS)',            -- 11
	    'Conlog Elec (1 Phase) Magnetic (STS)',             -- 12
	    'Conlog Elec (1 Phase) Keypad (STS)',               -- 13
	    'L+G Elec (1 Phase) Keypad (STS)',                  -- 14
	    'Plessey Elec (1 Phase) Keypad (STS)',              -- 15
	    'CBI Elec (1 Phase) Keypad (STS)',                  -- 16
	    'Actaris Elec (3 Phase) Keypad (STS)',              -- 17
	    'Conlog Elec (3 Phase) Keypad (STS)',               -- 18
	    'Conlog Elec (3 Phase) Magnetic (STS)',             -- 19
	    'Conlog Elec (3 Phase) Magnetic (Conlog Prop)',     -- 20
	    'L+G Elec (3 Phase) Keypad (STS)',                  -- 21
	    'L+G Elec (3 Phase) Keypad (EML Prop)',             -- 22
	    'Plessey Elec (3 Phase) Keypad (STS)',              -- 23
	    'Plessey Elec (3 Phase) Keypad (Sequence P, R)',    -- 24
	    'Plessey Elec (3 Phase) Keypad (Sequence T)',       -- 25
	    'INHEMETER (3 PHASE) (STS)',                        -- 26
	    'HEXING34(3 PHASE)(STS)',                           -- 27
	    'HEXING12(1 PHASE)(STS)',                           -- 28
	    'Actaris Elec (1 Phase) Magnetic (AEG Prop)',       -- 29
	    'Actaris Elec (3 Phase) SL7000',                    -- 30
	    'Unique Mbane STS (1 Phase)',                       -- 71
	    'Unique Mbane STS (3 Phase)',                       -- 72
	    'SHANGHAI XIELIN(1 phase)',                         -- 74
	    'Actom STS (1 Phase)',                              -- 75
	    'Sanxing(1 Phase)'                                  -- 76
	    )
		-- AND VALUE IN('1','29','11','17','30','75','16','13','8','12','18','20','19','9','10','28','27','26','6','7','14','22','21','4','2','3','15','5','24','25','23','76','74','71','72')
	ORDER BY a.VALUE;

	/*
	select MT_MODEL_DESC, count(1) from tmp_bj GROUP BY MT_MODEL_DESC;
	select * from a_meter_batch;
	select a.*, b.TEXT
	from p_sys_code a, p_sys_code_language b
	where CODE_TYPE = 'bjxh' and a.name = b.TEXT_ID and b.LANG = 'en_US' and ISSHOW = 1
	and VALUE IN('1','29','11','17','30','75','16','13','8','12','18','20','19','9','10','28','27','26','6','7','14','22','21','4','2','3','15','5','24','25','23','76','74','71','72')
	ORDER BY a.`VALUE`;
	*/


	IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;
	SELECT t_error, msg;
END

$$
delimiter ;

CALL mig_3_3();