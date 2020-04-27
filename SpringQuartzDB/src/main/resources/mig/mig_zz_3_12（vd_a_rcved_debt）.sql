DROP PROCEDURE IF EXISTS mig_zz_3_12;
delimiter $$
CREATE PROCEDURE mig_zz_3_12()

BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
-- 	DECLARE start_line int default 0;
-- 	DECLARE offset int default 200000; -- 一次最多插35W，否则就报3100，所以只能分页插，20W耗时59s
-- 	DECLARE total int default 60000000; -- 必须是offset的倍数（待定）
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

    # 1-插入 债务实收明细 10019 = 10018（债务应收） + 0（债务撤单）（还债记录里面可能找不到sdjl里面的ordersid，一个ordersid有可能对应多种债务，所以记录数可能比应收债务数多，也可能少）
    INSERT INTO vd_a_rcved_debt_2015
        (`LESSEE_ID`, `RCVED_DEBT_ID`, `RCVBL_DEBT_ID`, `RCVED_AMT_ID`, `THIS_RCVED_AMT`, `REMARK`, `ORG_ID`, `TV`)
    SELECT
        2, AMI_GET_SEQUENCE('SEQ_VD_A_RCVED_DEBT'), -- RCVED_DEBT_ID PK
        rcvbldebt.RCVBL_DEBT_ID, -- RCVBL_DETAIL_ID 正常/撤单都是定位到了正常应收债务主键
        rcvedflow.RCVED_AMT_ID, -- RCVED_AMT_ID 实收主键
        rcvbldebt.RCVED_AMT, -- THIS_RCVED_AMT 此处只包含债务
        'migrate OCD_DEBT', -- REMARK
        rcvedflow.ORG_ID, -- ORG_ID
        rcvedflow.tv -- 分区字段
    FROM vd_a_rcved_flow_2015 rcvedflow
    LEFT JOIN vd_a_rcvbl_debt_2015 rcvbldebt ON rcvedflow.RCVBL_AMT_ID = rcvbldebt.RCVBL_AMT_ID -- 一个售电订单可能偿还2种债务，从而有两个应收债务
    WHERE rcvedflow.AMT_TYPE = '11'; -- 可能确定不止一条rcvbldebt记录

--     while start_line < total do
-- 	    -- 【非撤单】-完全拷贝应收
--         SET @strsql = CONCAT('INSERT INTO vd_a_rcved_debt_2015
--                                     (`LESSEE_ID`, `RCVED_DEBT_ID`, `RCVBL_DEBT_ID`, `RCVED_AMT_ID`, `THIS_RCVED_AMT`, `REMARK`, `ORG_ID`, `TV`)
--                                 SELECT
--                                     2, AMI_GET_SEQUENCE(''SEQ_VD_A_RCVED_DEBT''), -- RCVED_DEBT_ID PK
--                                     rcvbldebt.RCVBL_DETAIL_ID, -- RCVBL_DETAIL_ID 正常/撤单都是定位到了正常应收/债务ID
--                                     rcvedflow.RCVED_AMT_ID, -- RCVED_AMT_ID
--                                     rcvbldebt.RCVED_AMT, -- THIS_RCVED_AMT 此处只包含债务
--                                     ''migrate OCD_DEBT'', -- REMARK
--                                     rcvedflow.ORG_ID, -- ORG_ID
--                                     rcvedflow.tv -- 分区字段
--                                 FROM vd_a_rcved_flow_2015 rcvedflow INNER JOIN (select RCVED_AMT_ID from vd_a_rcved_flow_2015 limit ', start_line, ',', offset, ') tmprcvedflow ON rcvedflow.RCVED_AMT_ID = tmprcvedflow.RCVED_AMT_ID
--                                 LEFT JOIN vd_a_rcvbl_debt_2015 rcvbldebt ON rcvedflow.RCVBL_AMT_ID = rcvbldebt.RCVBL_AMT_ID -- 一个售电订单可能偿还2种债务，从而有两个应收债务
--                                 WHERE rcvedflow.AMT_TYPE = ''11''; -- 可能确定不止一条rcvbldebt记录');
--         PREPARE stmt FROM @strsql;
--         EXECUTE stmt;
--         DEALLOCATE PREPARE stmt; -- 释放
--         -- 翻页
--         set start_line = start_line + offset;
--     end while;


    SELECT t_error, msg;
END
$$
delimiter ;

CALL mig_zz_3_12();