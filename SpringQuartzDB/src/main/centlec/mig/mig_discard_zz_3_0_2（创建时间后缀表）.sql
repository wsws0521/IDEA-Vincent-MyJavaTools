DROP PROCEDURE IF EXISTS mig_zz_3_0_2;
delimiter $$
CREATE PROCEDURE mig_zz_3_0_2()

BEGIN
    DECLARE done INT DEFAULT 0; 			/* 结束标识 */
	DECLARE mainKey VARCHAR(64); 			/* 游标所取的字段值 */
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	DECLARE start_year int default 2015;

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

    # 准备关联字段（VD_A_PAY_FLOW）-DEBTID-ORDERID-ISFREE-OCD_MONEY-FP_VAL3-OCD_DEBT
--     if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_NAME = 'VD_A_PAY_FLOW' AND COLUMN_NAME = 'DEBTID') = 0 then
--         CALL PR_MOD_COL('VD_A_PAY_FLOW','ADD','DEBTID','VARCHAR(64)','NULL','NULL','');
--     end if;
    if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_NAME = 'VD_A_PAY_FLOW' AND COLUMN_NAME = 'ORDERID') = 0 then
        CALL PR_MOD_COL('VD_A_PAY_FLOW','ADD','ORDERID','VARCHAR(128)','NULL','NULL','');
    end if;

    if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_NAME = 'VD_A_PAY_FLOW' AND COLUMN_NAME = 'ISFREE') = 0 then
        CALL PR_MOD_COL('VD_A_PAY_FLOW','ADD','ISFREE','TINYINT UNSIGNED','NULL','NULL','');
    end if;
    if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_NAME = 'VD_A_PAY_FLOW' AND COLUMN_NAME = 'OCD_MONEY') = 0 then
        CALL PR_MOD_COL('VD_A_PAY_FLOW','ADD','OCD_MONEY','decimal(18,2)','NULL','NULL','');
    end if;
    if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_NAME = 'VD_A_PAY_FLOW' AND COLUMN_NAME = 'FP_VAL3') = 0 then
        CALL PR_MOD_COL('VD_A_PAY_FLOW','ADD','FP_VAL3','decimal(18,2)','NULL','NULL','');
    end if;
    if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_NAME = 'VD_A_PAY_FLOW' AND COLUMN_NAME = 'OCD_DEBT') = 0 then
        CALL PR_MOD_COL('VD_A_PAY_FLOW','ADD','OCD_DEBT','decimal(18,2)','NULL','NULL','');
    end if;
    # 准备关联字段（vd_a_inv）-CHARGEID
    if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_NAME = 'vd_a_inv' AND COLUMN_NAME = 'CHARGEID') = 0 then
        CALL PR_MOD_COL('vd_a_inv','ADD','CHARGEID','decimal(16,0)','NULL','NULL','');
    end if;
    # 准备关联字段（vd_e_calc_pp_parm）-chargeid
    if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_NAME = 'vd_e_calc_pp_parm' AND COLUMN_NAME = 'chargeid') = 0 then
        CALL PR_MOD_COL('vd_e_calc_pp_parm','ADD','chargeid','decimal(16,0)','NULL','NULL','');
    end if;
    # 准备关联字段（vd_a_rcvbl_flow）-ORDERID
--     if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_NAME = 'VD_A_RCVBL_FLOW' AND COLUMN_NAME = 'DEBTID') = 0 then
--         CALL PR_MOD_COL('VD_A_RCVBL_FLOW','ADD','DEBTID','VARCHAR(64)','NULL','NULL','');
--     end if;
    if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_NAME = 'VD_A_RCVBL_FLOW' AND COLUMN_NAME = 'ORDERID') = 0 then
        CALL PR_MOD_COL('VD_A_RCVBL_FLOW','ADD','ORDERID','VARCHAR(128)','NULL','NULL','');
    end if;
    # 准备关联字段（vd_a_rcved_flow）-ORDERID
--     if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_NAME = 'VD_A_RCVED_FLOW' AND COLUMN_NAME = 'DEBTID') = 0 then
--         CALL PR_MOD_COL('VD_A_RCVED_FLOW','ADD','DEBTID','VARCHAR(64)','NULL','NULL','');
--     end if;
--     if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_NAME = 'VD_A_RCVED_FLOW' AND COLUMN_NAME = 'ORDERID') = 0 then
--         CALL PR_MOD_COL('VD_A_RCVED_FLOW','ADD','ORDERID','VARCHAR(128)','NULL','NULL','');
--     end if;


    # 打开游标
	OPEN noCur;
	# 开始循环
	REPEAT
	FETCH noCur INTO mainKey;
	IF NOT done THEN
	    SET start_year = 2013;
        while start_year < 2020 do
            -- 先清除
            SET @strsql = CONCAT('DROP TABLE IF EXISTS ', mainKey, '_', start_year);
            PREPARE stmt FROM @strsql;
            EXECUTE stmt;
            DEALLOCATE PREPARE stmt;
            -- 再创建（注释该步，即可清理）
            SET @strsql = CONCAT('CREATE TABLE ', mainKey, '_', start_year, ' LIKE ', mainKey);
            PREPARE stmt FROM @strsql;
            EXECUTE stmt;
            DEALLOCATE PREPARE stmt;
            -- 先排除非分区表，再修改分区
            IF mainKey <> 'VD_S_CANCEL_APP' THEN
                IF start_year = 2013 THEN
                    SET @strsql = CONCAT('Alter table ', mainKey, '_', start_year, ' PARTITION BY RANGE (TO_DAYS(TV))(
                            PARTITION P201301 VALUES LESS THAN (TO_DAYS(''2013-02-01'')) ENGINE = InnoDB,
                            PARTITION P201302 VALUES LESS THAN (TO_DAYS(''2013-03-01'')) ENGINE = InnoDB,
                            PARTITION P201303 VALUES LESS THAN (TO_DAYS(''2013-04-01'')) ENGINE = InnoDB,
                            PARTITION P201304 VALUES LESS THAN (TO_DAYS(''2013-05-01'')) ENGINE = InnoDB,
                            PARTITION P201305 VALUES LESS THAN (TO_DAYS(''2013-06-01'')) ENGINE = InnoDB,
                            PARTITION P201306 VALUES LESS THAN (TO_DAYS(''2013-07-01'')) ENGINE = InnoDB,
                            PARTITION P201307 VALUES LESS THAN (TO_DAYS(''2013-08-01'')) ENGINE = InnoDB,
                            PARTITION P201308 VALUES LESS THAN (TO_DAYS(''2013-09-01'')) ENGINE = InnoDB,
                            PARTITION P201309 VALUES LESS THAN (TO_DAYS(''2013-10-01'')) ENGINE = InnoDB,
                            PARTITION P201310 VALUES LESS THAN (TO_DAYS(''2013-11-01'')) ENGINE = InnoDB,
                            PARTITION P201311 VALUES LESS THAN (TO_DAYS(''2013-12-01'')) ENGINE = InnoDB,
                            PARTITION P201312 VALUES LESS THAN (TO_DAYS(''2014-01-01'')) ENGINE = InnoDB,
                            PARTITION PMAX VALUES LESS THAN (MAXVALUE)
                        );');
                    PREPARE stmt FROM @strsql;
                    EXECUTE stmt;
                    DEALLOCATE PREPARE stmt;
                ELSEIF start_year = 2014 THEN
                    SET @strsql = CONCAT('Alter table ', mainKey, '_', start_year, ' PARTITION BY RANGE (TO_DAYS(TV))(
                            PARTITION P201401 VALUES LESS THAN (TO_DAYS(''2014-02-01'')) ENGINE = InnoDB,
                            PARTITION P201402 VALUES LESS THAN (TO_DAYS(''2014-03-01'')) ENGINE = InnoDB,
                            PARTITION P201403 VALUES LESS THAN (TO_DAYS(''2014-04-01'')) ENGINE = InnoDB,
                            PARTITION P201404 VALUES LESS THAN (TO_DAYS(''2014-05-01'')) ENGINE = InnoDB,
                            PARTITION P201405 VALUES LESS THAN (TO_DAYS(''2014-06-01'')) ENGINE = InnoDB,
                            PARTITION P201406 VALUES LESS THAN (TO_DAYS(''2014-07-01'')) ENGINE = InnoDB,
                            PARTITION P201407 VALUES LESS THAN (TO_DAYS(''2014-08-01'')) ENGINE = InnoDB,
                            PARTITION P201408 VALUES LESS THAN (TO_DAYS(''2014-09-01'')) ENGINE = InnoDB,
                            PARTITION P201409 VALUES LESS THAN (TO_DAYS(''2014-10-01'')) ENGINE = InnoDB,
                            PARTITION P201410 VALUES LESS THAN (TO_DAYS(''2014-11-01'')) ENGINE = InnoDB,
                            PARTITION P201411 VALUES LESS THAN (TO_DAYS(''2014-12-01'')) ENGINE = InnoDB,
                            PARTITION P201412 VALUES LESS THAN (TO_DAYS(''2015-01-01'')) ENGINE = InnoDB,
                            PARTITION PMAX VALUES LESS THAN (MAXVALUE)
                        );');
                    PREPARE stmt FROM @strsql;
                    EXECUTE stmt;
                    DEALLOCATE PREPARE stmt;
                ELSEIF start_year = 2015 THEN
                    SET @strsql = CONCAT('Alter table ', mainKey, '_', start_year, ' PARTITION BY RANGE (TO_DAYS(TV))(
                            PARTITION P201501 VALUES LESS THAN (TO_DAYS(''2015-02-01'')) ENGINE = InnoDB,
                            PARTITION P201502 VALUES LESS THAN (TO_DAYS(''2015-03-01'')) ENGINE = InnoDB,
                            PARTITION P201503 VALUES LESS THAN (TO_DAYS(''2015-04-01'')) ENGINE = InnoDB,
                            PARTITION P201504 VALUES LESS THAN (TO_DAYS(''2015-05-01'')) ENGINE = InnoDB,
                            PARTITION P201505 VALUES LESS THAN (TO_DAYS(''2015-06-01'')) ENGINE = InnoDB,
                            PARTITION P201506 VALUES LESS THAN (TO_DAYS(''2015-07-01'')) ENGINE = InnoDB,
                            PARTITION P201507 VALUES LESS THAN (TO_DAYS(''2015-08-01'')) ENGINE = InnoDB,
                            PARTITION P201508 VALUES LESS THAN (TO_DAYS(''2015-09-01'')) ENGINE = InnoDB,
                            PARTITION P201509 VALUES LESS THAN (TO_DAYS(''2015-10-01'')) ENGINE = InnoDB,
                            PARTITION P201510 VALUES LESS THAN (TO_DAYS(''2015-11-01'')) ENGINE = InnoDB,
                            PARTITION P201511 VALUES LESS THAN (TO_DAYS(''2015-12-01'')) ENGINE = InnoDB,
                            PARTITION P201512 VALUES LESS THAN (TO_DAYS(''2016-01-01'')) ENGINE = InnoDB,
                            PARTITION PMAX VALUES LESS THAN (MAXVALUE)
                        );');
                    PREPARE stmt FROM @strsql;
                    EXECUTE stmt;
                    DEALLOCATE PREPARE stmt;
                ELSEIF start_year = 2016 THEN
                    SET @strsql = CONCAT('Alter table ', mainKey, '_', start_year, ' PARTITION BY RANGE (TO_DAYS(TV))(
                            PARTITION P201601 VALUES LESS THAN (TO_DAYS(''2016-02-01'')) ENGINE = InnoDB,
                            PARTITION P201602 VALUES LESS THAN (TO_DAYS(''2016-03-01'')) ENGINE = InnoDB,
                            PARTITION P201603 VALUES LESS THAN (TO_DAYS(''2016-04-01'')) ENGINE = InnoDB,
                            PARTITION P201604 VALUES LESS THAN (TO_DAYS(''2016-05-01'')) ENGINE = InnoDB,
                            PARTITION P201605 VALUES LESS THAN (TO_DAYS(''2016-06-01'')) ENGINE = InnoDB,
                            PARTITION P201606 VALUES LESS THAN (TO_DAYS(''2016-07-01'')) ENGINE = InnoDB,
                            PARTITION P201607 VALUES LESS THAN (TO_DAYS(''2016-08-01'')) ENGINE = InnoDB,
                            PARTITION P201608 VALUES LESS THAN (TO_DAYS(''2016-09-01'')) ENGINE = InnoDB,
                            PARTITION P201609 VALUES LESS THAN (TO_DAYS(''2016-10-01'')) ENGINE = InnoDB,
                            PARTITION P201610 VALUES LESS THAN (TO_DAYS(''2016-11-01'')) ENGINE = InnoDB,
                            PARTITION P201611 VALUES LESS THAN (TO_DAYS(''2016-12-01'')) ENGINE = InnoDB,
                            PARTITION P201612 VALUES LESS THAN (TO_DAYS(''2017-01-01'')) ENGINE = InnoDB,
                            PARTITION PMAX VALUES LESS THAN (MAXVALUE)
                        );');
                    PREPARE stmt FROM @strsql;
                    EXECUTE stmt;
                    DEALLOCATE PREPARE stmt;
                ELSEIF start_year = 2017 THEN
                    SET @strsql = CONCAT('Alter table ', mainKey, '_', start_year, ' PARTITION BY RANGE (TO_DAYS(TV))(
                            PARTITION P201701 VALUES LESS THAN (TO_DAYS(''2017-02-01'')) ENGINE = InnoDB,
                            PARTITION P201702 VALUES LESS THAN (TO_DAYS(''2017-03-01'')) ENGINE = InnoDB,
                            PARTITION P201703 VALUES LESS THAN (TO_DAYS(''2017-04-01'')) ENGINE = InnoDB,
                            PARTITION P201704 VALUES LESS THAN (TO_DAYS(''2017-05-01'')) ENGINE = InnoDB,
                            PARTITION P201705 VALUES LESS THAN (TO_DAYS(''2017-06-01'')) ENGINE = InnoDB,
                            PARTITION P201706 VALUES LESS THAN (TO_DAYS(''2017-07-01'')) ENGINE = InnoDB,
                            PARTITION P201707 VALUES LESS THAN (TO_DAYS(''2017-08-01'')) ENGINE = InnoDB,
                            PARTITION P201708 VALUES LESS THAN (TO_DAYS(''2017-09-01'')) ENGINE = InnoDB,
                            PARTITION P201709 VALUES LESS THAN (TO_DAYS(''2017-10-01'')) ENGINE = InnoDB,
                            PARTITION P201710 VALUES LESS THAN (TO_DAYS(''2017-11-01'')) ENGINE = InnoDB,
                            PARTITION P201711 VALUES LESS THAN (TO_DAYS(''2017-12-01'')) ENGINE = InnoDB,
                            PARTITION P201712 VALUES LESS THAN (TO_DAYS(''2018-01-01'')) ENGINE = InnoDB,
                            PARTITION PMAX VALUES LESS THAN (MAXVALUE)
                        );');
                    PREPARE stmt FROM @strsql;
                    EXECUTE stmt;
                    DEALLOCATE PREPARE stmt;
                ELSEIF start_year = 2018 THEN
                    SET @strsql = CONCAT('Alter table ', mainKey, '_', start_year, ' PARTITION BY RANGE (TO_DAYS(TV))(
                            PARTITION P201801 VALUES LESS THAN (TO_DAYS(''2018-02-01'')) ENGINE = InnoDB,
                            PARTITION P201802 VALUES LESS THAN (TO_DAYS(''2018-03-01'')) ENGINE = InnoDB,
                            PARTITION P201803 VALUES LESS THAN (TO_DAYS(''2018-04-01'')) ENGINE = InnoDB,
                            PARTITION P201804 VALUES LESS THAN (TO_DAYS(''2018-05-01'')) ENGINE = InnoDB,
                            PARTITION P201805 VALUES LESS THAN (TO_DAYS(''2018-06-01'')) ENGINE = InnoDB,
                            PARTITION P201806 VALUES LESS THAN (TO_DAYS(''2018-07-01'')) ENGINE = InnoDB,
                            PARTITION P201807 VALUES LESS THAN (TO_DAYS(''2018-08-01'')) ENGINE = InnoDB,
                            PARTITION P201808 VALUES LESS THAN (TO_DAYS(''2018-09-01'')) ENGINE = InnoDB,
                            PARTITION P201809 VALUES LESS THAN (TO_DAYS(''2018-10-01'')) ENGINE = InnoDB,
                            PARTITION P201810 VALUES LESS THAN (TO_DAYS(''2018-11-01'')) ENGINE = InnoDB,
                            PARTITION P201811 VALUES LESS THAN (TO_DAYS(''2018-12-01'')) ENGINE = InnoDB,
                            PARTITION P201812 VALUES LESS THAN (TO_DAYS(''2019-01-01'')) ENGINE = InnoDB,
                            PARTITION PMAX VALUES LESS THAN (MAXVALUE)
                        );');
                    PREPARE stmt FROM @strsql;
                    EXECUTE stmt;
                    DEALLOCATE PREPARE stmt;
                ELSEIF start_year = 2019 THEN
                    SET @strsql = CONCAT('Alter table ', mainKey, '_', start_year, ' PARTITION BY RANGE (TO_DAYS(TV))(
                            PARTITION P201901 VALUES LESS THAN (TO_DAYS(''2019-02-01'')) ENGINE = InnoDB,
                            PARTITION P201902 VALUES LESS THAN (TO_DAYS(''2019-03-01'')) ENGINE = InnoDB,
                            PARTITION P201903 VALUES LESS THAN (TO_DAYS(''2019-04-01'')) ENGINE = InnoDB,
                            PARTITION P201904 VALUES LESS THAN (TO_DAYS(''2019-05-01'')) ENGINE = InnoDB,
                            PARTITION P201905 VALUES LESS THAN (TO_DAYS(''2019-06-01'')) ENGINE = InnoDB,
                            PARTITION P201906 VALUES LESS THAN (TO_DAYS(''2019-07-01'')) ENGINE = InnoDB,
                            PARTITION P201907 VALUES LESS THAN (TO_DAYS(''2019-08-01'')) ENGINE = InnoDB,
                            PARTITION P201908 VALUES LESS THAN (TO_DAYS(''2019-09-01'')) ENGINE = InnoDB,
                            PARTITION P201909 VALUES LESS THAN (TO_DAYS(''2019-10-01'')) ENGINE = InnoDB,
                            PARTITION P201910 VALUES LESS THAN (TO_DAYS(''2019-11-01'')) ENGINE = InnoDB,
                            PARTITION P201911 VALUES LESS THAN (TO_DAYS(''2019-12-01'')) ENGINE = InnoDB,
                            PARTITION P201912 VALUES LESS THAN (TO_DAYS(''2020-01-01'')) ENGINE = InnoDB,
                            PARTITION PMAX VALUES LESS THAN (MAXVALUE)
                        );');
                    PREPARE stmt FROM @strsql;
                    EXECUTE stmt;
                    DEALLOCATE PREPARE stmt;
                END IF;
            END IF;
            -- 再+1
            set start_year = start_year + 1;
        end while;
    END IF;
	UNTIL done END REPEAT;
	CLOSE noCur;

    SELECT t_error, msg;

END
$$
delimiter ;

CALL mig_zz_3_0_2();