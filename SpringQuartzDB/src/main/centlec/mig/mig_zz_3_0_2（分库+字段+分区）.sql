DROP PROCEDURE IF EXISTS mig_zz_3_0_2;
delimiter $$
CREATE PROCEDURE mig_zz_3_0_2()

BEGIN
    DECLARE done INT DEFAULT 0; 			/* 结束标识 */
	DECLARE mainKey VARCHAR(64); 			/* 游标所取的字段值 */
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	DECLARE start_year int default 2016;    /* ++++++根据执行库的年份修改++++++ */
	DECLARE db_name VARCHAR(16);

	# 定义游标
	DECLARE noCur CURSOR FOR SELECT * FROM (
        select 'VD_A_PAY_FLOW'                    -- 1-收费明细
        union select 'VD_A_INV'                   -- 2-票据
        union select 'VD_A_CHARGE_INV_REL'        -- 3-收费票据关系
--         union select 'VD_P_THIRD_PARTY_SWAP_LOG'  -- 待定-第三方售电接口交互记录
        union select 'A_AGENT_PAY_FLOW'           -- 4-代理收费记录
--         union select 'VD_P_KEY_CHANGE_LOG'        -- 待定-密钥变更记录
        union select 'VD_P_TOKEN'                 -- 5-TOKEN信息
        union select 'VD_E_CALC_PP_PARM'          -- 6-预付费计费参数
        union select 'VD_A_RCVBL_FLOW'            -- 7-费用应收记录
        union select 'VD_A_RCVBL_AMT'             -- 8-应收电费明细
        union select 'VD_A_RCVBL_DEBT'            -- 9-应收债务明细
--         union select 'VD_A_RCVBL_DETAILS'            -- 待定-计费项应收明细
        union select 'VD_A_RCVED_FLOW'            -- 10-费用实收记录
        union select 'VD_A_RCVED_AMT'             -- 11-实收电费明细
        union select 'VD_A_RCVED_DEBT'            -- 12-债务实收明细
--         union select 'VD_A_RDVED_DETAILS'            -- 待定-计费项实收明细
        union select 'VD_S_CANCEL_APP'            -- 13-异常处理申请
	) tmp;
	# 定义循环结束done值改变逻辑
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

    SET db_name = (select CONCAT('centlec', start_year));
    # 准备关联字段（VD_A_PAY_FLOW）-DEBTID-ORDERID-ISFREE-OCD_MONEY-FP_VAL3-OCD_DEBT
--     if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_SCHEMA = db_name AND TABLE_NAME = 'VD_A_PAY_FLOW' AND COLUMN_NAME = 'DEBTID') = 0 then
--         CALL PR_MOD_COL('VD_A_PAY_FLOW','ADD','DEBTID','VARCHAR(64)','NULL','NULL','');
--     end if;
    if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_SCHEMA = db_name AND TABLE_NAME = 'VD_A_PAY_FLOW' AND COLUMN_NAME = 'ORDERID') = 0 then
        CALL PR_MOD_COL('VD_A_PAY_FLOW','ADD','ORDERID','VARCHAR(128)','NULL','NULL','');
    end if;

    if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_SCHEMA = db_name AND TABLE_NAME = 'VD_A_PAY_FLOW' AND COLUMN_NAME = 'ISFREE') = 0 then
        CALL PR_MOD_COL('VD_A_PAY_FLOW','ADD','ISFREE','TINYINT UNSIGNED','NULL','NULL','');
    end if;
    if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_SCHEMA = db_name AND TABLE_NAME = 'VD_A_PAY_FLOW' AND COLUMN_NAME = 'OCD_MONEY') = 0 then
        CALL PR_MOD_COL('VD_A_PAY_FLOW','ADD','OCD_MONEY','decimal(18,2)','NULL','NULL','');
    end if;
    if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_SCHEMA = db_name AND TABLE_NAME = 'VD_A_PAY_FLOW' AND COLUMN_NAME = 'FP_VAL3') = 0 then
        CALL PR_MOD_COL('VD_A_PAY_FLOW','ADD','FP_VAL3','decimal(18,2)','NULL','NULL','');
    end if;
    if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_SCHEMA = db_name AND TABLE_NAME = 'VD_A_PAY_FLOW' AND COLUMN_NAME = 'OCD_DEBT') = 0 then
        CALL PR_MOD_COL('VD_A_PAY_FLOW','ADD','OCD_DEBT','decimal(18,2)','NULL','NULL','');
    end if;
    # 准备关联字段（vd_a_inv）-CHARGEID
    if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_SCHEMA = db_name AND TABLE_NAME = 'vd_a_inv' AND COLUMN_NAME = 'CHARGEID') = 0 then
        CALL PR_MOD_COL('vd_a_inv','ADD','CHARGEID','decimal(16,0)','NULL','NULL','');
    end if;
    # 准备关联字段（vd_e_calc_pp_parm）-chargeid
    if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_SCHEMA = db_name AND TABLE_NAME = 'vd_e_calc_pp_parm' AND COLUMN_NAME = 'chargeid') = 0 then
        CALL PR_MOD_COL('vd_e_calc_pp_parm','ADD','chargeid','decimal(16,0)','NULL','NULL','');
    end if;
    # 准备关联字段（vd_a_rcvbl_flow）-ORDERID
--     if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_SCHEMA = db_name AND TABLE_NAME = 'VD_A_RCVBL_FLOW' AND COLUMN_NAME = 'DEBTID') = 0 then
--         CALL PR_MOD_COL('VD_A_RCVBL_FLOW','ADD','DEBTID','VARCHAR(64)','NULL','NULL','');
--     end if;
    if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_SCHEMA = db_name AND TABLE_NAME = 'VD_A_RCVBL_FLOW' AND COLUMN_NAME = 'ORDERID') = 0 then
        CALL PR_MOD_COL('VD_A_RCVBL_FLOW','ADD','ORDERID','VARCHAR(128)','NULL','NULL','');
    end if;
    # 准备关联字段（vd_a_rcved_flow）-ORDERID
--     if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_SCHEMA = db_name AND TABLE_NAME = 'VD_A_RCVED_FLOW' AND COLUMN_NAME = 'DEBTID') = 0 then
--         CALL PR_MOD_COL('VD_A_RCVED_FLOW','ADD','DEBTID','VARCHAR(64)','NULL','NULL','');
--     end if;
--     if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_SCHEMA = db_name AND TABLE_NAME = 'VD_A_RCVED_FLOW' AND COLUMN_NAME = 'ORDERID') = 0 then
--         CALL PR_MOD_COL('VD_A_RCVED_FLOW','ADD','ORDERID','VARCHAR(128)','NULL','NULL','');
--     end if;


    # 打开游标
	OPEN noCur;
	# 开始循环
	REPEAT
	FETCH noCur INTO mainKey;
	IF NOT done THEN
-- 	    select * from information_schema.partitions
--      where table_schema = 'centlec2016' and table_name='表名';
	    -- 先排除非分区表，再重建分区
        IF mainKey <> 'VD_S_CANCEL_APP' THEN
            SET @strsql = CONCAT('ALTER TABLE ', mainKey, ' partition by range(TO_DAYS(TV))(',
            'PARTITION P', start_year, '01 VALUES LESS THAN (TO_DAYS(''', start_year, '-02-01'')) ENGINE = InnoDB,',
            'PARTITION P', start_year, '02 VALUES LESS THAN (TO_DAYS(''', start_year, '-03-01'')) ENGINE = InnoDB,',
            'PARTITION P', start_year, '03 VALUES LESS THAN (TO_DAYS(''', start_year, '-04-01'')) ENGINE = InnoDB,',
            'PARTITION P', start_year, '04 VALUES LESS THAN (TO_DAYS(''', start_year, '-05-01'')) ENGINE = InnoDB,',
            'PARTITION P', start_year, '05 VALUES LESS THAN (TO_DAYS(''', start_year, '-06-01'')) ENGINE = InnoDB,',
            'PARTITION P', start_year, '06 VALUES LESS THAN (TO_DAYS(''', start_year, '-07-01'')) ENGINE = InnoDB,',
            'PARTITION P', start_year, '07 VALUES LESS THAN (TO_DAYS(''', start_year, '-08-01'')) ENGINE = InnoDB,',
            'PARTITION P', start_year, '08 VALUES LESS THAN (TO_DAYS(''', start_year, '-09-01'')) ENGINE = InnoDB,',
            'PARTITION P', start_year, '09 VALUES LESS THAN (TO_DAYS(''', start_year, '-10-01'')) ENGINE = InnoDB,',
            'PARTITION P', start_year, '10 VALUES LESS THAN (TO_DAYS(''', start_year, '-11-01'')) ENGINE = InnoDB,',
            'PARTITION P', start_year, '11 VALUES LESS THAN (TO_DAYS(''', start_year, '-12-01'')) ENGINE = InnoDB,',
            'PARTITION P', start_year, '12 VALUES LESS THAN (TO_DAYS(''', start_year + 1, '-01-01'')) ENGINE = InnoDB,',
            'PARTITION PMAX VALUES LESS THAN (MAXVALUE));'
            );
            PREPARE stmt FROM @strsql;
            EXECUTE stmt;
            DEALLOCATE PREPARE stmt;
        END IF;
    END IF;
	UNTIL done END REPEAT;
	CLOSE noCur;

    IF EXISTS(SELECT * FROM information_schema.`TABLES` WHERE table_schema = 'centlec2016' AND table_name = 'tmp_sdjl_2016') THEN
		ALTER table centlec2016.tmp_sdjl_2016 RENAME TO centlec2016.tmp_sdjl;
	END IF;
	IF EXISTS(SELECT * FROM information_schema.`TABLES` WHERE table_schema = 'centlec2017' AND table_name = 'tmp_sdjl_2017') THEN
		ALTER table centlec2017.tmp_sdjl_2017 RENAME TO centlec2017.tmp_sdjl;
	END IF;
	IF EXISTS(SELECT * FROM information_schema.`TABLES` WHERE table_schema = 'centlec2018' AND table_name = 'tmp_sdjl_2018') THEN
		ALTER table centlec2018.tmp_sdjl_2018 RENAME TO centlec2018.tmp_sdjl;
	END IF;
	IF EXISTS(SELECT * FROM information_schema.`TABLES` WHERE table_schema = 'centlec2019' AND table_name = 'tmp_sdjl_2019') THEN
		ALTER table centlec2019.tmp_sdjl_2019 RENAME TO centlec2019.tmp_sdjl;
	END IF;

    SELECT t_error, msg;

END
$$
delimiter ;

CALL mig_zz_3_0_2();