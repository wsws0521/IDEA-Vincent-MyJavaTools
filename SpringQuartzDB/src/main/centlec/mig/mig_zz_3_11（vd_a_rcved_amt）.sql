DROP PROCEDURE IF EXISTS mig_zz_3_11;
delimiter $$
CREATE PROCEDURE mig_zz_3_11()

BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	DECLARE start_line int default 0;
	DECLARE offset int default 200000; -- 一次最多插35W，否则就报3100，所以只能分页插，20W耗时59s
	DECLARE total int default 0;
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;


    # 1-插入 电费实收明细 1h22min 12527534 = 12058724（电价电费应收） + 234392*2（FBE应收*2） + 26（电价电费撤单） + 0 （FBE撤单）
    set total = (select count(RCVED_AMT_ID) from vd_a_rcved_flow where amt_type IN ('01','02'));
    while start_line < total do
	    -- 【非撤单】-完全拷贝应收
        SET @strsql = CONCAT('INSERT INTO vd_a_rcved_amt
                (`LESSEE_ID`, `RCVED_DETAIL_ID`, `RCVED_AMT_ID`, `RCVBL_DETAIL_ID`, `ORG_ID`, `REMARK`, `THIS_RCVED_AMT`, `TV`)
            SELECT
                2, AMI_GET_SEQUENCE(''SEQ_VD_A_RCVED_AMT''), -- RCVED_DETAIL_ID PK
                rcvedflow.RCVED_AMT_ID, -- RCVED_AMT_ID
                rcvblamt.RCVBL_DETAIL_ID, -- RCVBL_DETAIL_ID 正常/撤单都是定位到了正常应收/明细ID
                rcvedflow.ORG_ID, -- ORG_ID
                ''migrate OCD_MONEY'', -- REMARK
                rcvedflow.THIS_RCVED_AMT, -- THIS_RCVED_AMT 此处只包含电价电费
                rcvedflow.tv -- 分区字段
            FROM vd_a_rcved_flow rcvedflow INNER JOIN (select RCVED_AMT_ID from vd_a_rcved_flow where AMT_TYPE IN (''01'',''02'') limit ', start_line, ',', offset, ') tmprcvedflow ON rcvedflow.RCVED_AMT_ID = tmprcvedflow.RCVED_AMT_ID
            LEFT JOIN vd_a_rcvbl_amt rcvblamt ON rcvedflow.RCVBL_AMT_ID = rcvblamt.RCVBL_AMT_ID; -- -- 包括01 电费 02免费电费，包括撤单，理应可以确定唯一的rcvblamt记录');
        PREPARE stmt FROM @strsql;
        EXECUTE stmt;
        DEALLOCATE PREPARE stmt; -- 释放
        -- 翻页
        set start_line = start_line + offset;
    end while;

    SELECT t_error, msg;
END
$$
delimiter ;


CALL mig_zz_3_11();