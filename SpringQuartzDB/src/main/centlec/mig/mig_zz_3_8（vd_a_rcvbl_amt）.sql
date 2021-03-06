DROP PROCEDURE IF EXISTS mig_zz_3_8;
delimiter $$
CREATE PROCEDURE mig_zz_3_8()

BEGIN
    DECLARE start_year int default 2016;    /* ++++++根据执行库的年份修改，脚本必须在指定库上执行++++++ */
    DECLARE db_name VARCHAR(16);
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	DECLARE start_line int default 0;
	DECLARE offset int default 100000; -- 一次最多插35W，否则就报3100，所以只能分页插，修改系统参数，每200W查询需要100s，多实例并行插
	DECLARE total int default 0;
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

    # 1-插入 应收电费明细（其实是sdjl数量再加一遍相反符号FBE数量）（2h10min）
    set total = (select count(RCVBL_AMT_ID) from vd_a_rcvbl_flow where amt_type IN ('01','02'));
    while start_line < total do
	    -- 1-【正常收费】{电价电费应收}
        SET @strsql = CONCAT('INSERT INTO vd_a_rcvbl_amt
                                    (`LESSEE_ID`, `RCVBL_DETAIL_ID`, `RCVBL_AMT_ID`, `PRICE_ID`, `ENERGY`, `AMT`, `RCVED_AMT`, `ORG_ID`, `CALC_AMT_ID`, `TV`)
                                SELECT
                                    2,
                                    AMI_GET_SEQUENCE(''SEQ_VD_A_RCVBL_AMT''), -- RCVBL_DETAIL_ID
                                    rcvblflow.RCVBL_AMT_ID, -- RCVBL_AMT_ID 应收费用标识FK
                                    NULL, -- PRICE_ID 电价标识++++++++++++++++++++++++++++VD_E_CALC_AMT+++++++++++++++++++++++++++++++++++
                                    rcvblflow.RES_QUAN, -- ENERGY 电量
                                    rcvblflow.RCVBL_AMT, -- AMT 资源量金额/电价电费
                                    rcvblflow.RCVED_AMT, -- RCVED_AMT 实收资源量金额/电价电费
                                    rcvblflow.ORG_ID, -- ORG_ID 用户所在单位
                                    NULL, -- CALC_AMT_ID 电费计算明细标识+++++++++++++++++++VD_E_BILL_PKG_VER_DETAIL+++++++++++++++++++++++++++
                                    rcvblflow.tv -- TV 分区字段
                                FROM vd_a_rcvbl_flow rcvblflow INNER JOIN (select RCVBL_AMT_ID from vd_a_rcvbl_flow where amt_type IN (''01'',''02'') limit ', start_line, ',', offset, ') tmprcvblflow ON rcvblflow.RCVBL_AMT_ID = tmprcvblflow.RCVBL_AMT_ID; -- 包括01 电费 02免费电费');
        PREPARE stmt FROM @strsql;
        EXECUTE stmt;
        DEALLOCATE PREPARE stmt; -- 释放
        -- 翻页
        set start_line = start_line + offset;
    end while;

    # vd_a_rcvbl_amt.RCVBL_AMT_ID
    SET db_name = (select CONCAT('centlec', start_year));
    IF NOT EXISTS(SELECT * FROM information_schema.statistics WHERE TABLE_SCHEMA = db_name AND table_name='vd_a_rcvbl_amt' AND index_name='index_vd_a_rcvbl_amt_rcvblamtid') THEN
		ALTER table vd_a_rcvbl_amt ADD INDEX index_vd_a_rcvbl_amt_rcvblamtid(RCVBL_AMT_ID); -- 53s 插实收小弟的时候需要用到
	END IF;

    SELECT t_error, msg;
END
$$
delimiter ;

CALL mig_zz_3_8();