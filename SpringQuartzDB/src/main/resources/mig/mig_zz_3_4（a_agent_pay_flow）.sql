DROP PROCEDURE IF EXISTS mig_zz_3_4;
delimiter $$
CREATE PROCEDURE mig_zz_3_4()

BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	DECLARE start_line int default 0;
	DECLARE offset int default 200000; -- 一次最多插35W，否则就报3100，所以只能分页插，20W耗时59s
	DECLARE total int default 14000000; -- 一次最多插35W，否则就报3100，所以只能分页插，20W耗时59s

	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

    # 删除被插表索引
	IF EXISTS(SELECT * FROM information_schema.statistics WHERE table_name='a_agent_pay_flow_2015' AND index_name='IDX_AGT_PAY_FLOW_LOGID') THEN
		ALTER table a_agent_pay_flow_2015 DROP INDEX IDX_AGT_PAY_FLOW_LOGID;
	END IF;

    # 1-循环插入 代理商收费记录 -- 与 vd_a_pay_flow 一一对应 (2h32min)
	while start_line < total do
        SET @strsql = CONCAT('INSERT INTO a_agent_pay_flow_2015
                                    (`LESSEE_ID`, `AGENT_CHARGE_ID`, `LOG_ID`, `CHARGE_ID`, `CONS_ID`, `TV`)
                                SELECT
                                    2,
                                    AMI_GET_SEQUENCE(''SEQ_A_AGENT_PAY_FLOW''), -- PK
                                    NULL, -- LOG_ID 交互标识FK
                                    flow.charge_id, -- CHARGE_ID 收费标识
                                    agt.AGENT_ID, -- CONS_ID 用户/代理商标识
                                    flow.tv -- 手动插入TV字段，应用于分区（该值不应为空）
                                FROM vd_a_pay_flow_2015 flow
                                INNER JOIN (SELECT charge_id FROM vd_a_pay_flow_2015 LIMIT ', start_line, ',', offset, ') tmpflow ON flow.charge_id = tmpflow.charge_id
                                LEFT JOIN tmp_sdjl_2015 sdjl ON flow.orderid = sdjl.ORDERSID
                                LEFT JOIN VD_AGT_AGENT agt ON sdjl.TE_NAME = agt.AGENT_NAME;');
        PREPARE stmt FROM @strsql;
        EXECUTE stmt;
        DEALLOCATE PREPARE stmt;
        -- 翻页
        set start_line = start_line + offset;
    end while;

    # 重建索引
    ALTER table a_agent_pay_flow_2015 ADD INDEX IDX_AGT_PAY_FLOW_LOGID(LOG_ID); -- 2min

    SELECT t_error, msg;
END
$$
delimiter ;

CALL mig_zz_3_4();