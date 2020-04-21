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

    # 准备关联字段（VD_A_PAY_FLOW）-DEBTID-ORDERID
--     if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_NAME = 'VD_A_PAY_FLOW' AND COLUMN_NAME = 'DEBTID') = 0 then
--         CALL PR_MOD_COL('VD_A_PAY_FLOW','ADD','DEBTID','VARCHAR(64)','NULL','NULL','');
--     end if;
    if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_NAME = 'VD_A_PAY_FLOW' AND COLUMN_NAME = 'ORDERID') = 0 then
        CALL PR_MOD_COL('VD_A_PAY_FLOW','ADD','ORDERID','VARCHAR(128)','NULL','NULL','');
    end if;
    # 准备关联字段（vd_a_inv）-CHARGEID
    if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_NAME = 'vd_a_inv' AND COLUMN_NAME = 'CHARGEID') = 0 then
        CALL PR_MOD_COL('vd_a_inv','ADD','CHARGEID','decimal(16,0)','NULL','NULL','');
    end if;
    # 准备关联字段（vd_e_calc_pp_parm）-ORDERID
    if (select COUNT(1) from information_schema.COLUMNS WHERE TABLE_NAME = 'vd_e_calc_pp_parm' AND COLUMN_NAME = 'ORDERID') = 0 then
        CALL PR_MOD_COL('vd_e_calc_pp_parm','ADD','ORDERID','VARCHAR(128)','NULL','NULL','');
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
	    SET start_year = 2015;
        while start_year<2020 do
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
