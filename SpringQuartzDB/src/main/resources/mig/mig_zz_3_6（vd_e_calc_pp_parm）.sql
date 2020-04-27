DROP PROCEDURE IF EXISTS mig_zz_3_6;
delimiter $$
CREATE PROCEDURE mig_zz_3_6()

BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	DECLARE start_line int default 0;
	DECLARE offset int default 200000; -- 一次最多插35W，否则就报3100，所以只能分页插，20W耗时59s
	DECLARE total int default 14000000; -- 必须是offset的倍数
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;


    # 1-循环插入 预付费计费参数(与收费明细一对一)（1h8min）
	while start_line < total do
        SET @strsql = CONCAT('INSERT INTO vd_e_calc_pp_parm_2015
                                    (`LESSEE_ID`, `CALC_ID`, `RECHARGE_TYPE`, `AMOUNT`, `TV`, chargeid)
                                SELECT
                                    2,
                                    AMI_GET_SEQUENCE(''SEQ_VD_E_CALC_PP_PARM''), -- PK 计算标识
                                    ''01'', -- RECHARGE_TYPE 充值方式 01-金额
                                    flow.rcvd_amt, -- 数量
                                    flow.tv, -- 分区字段
                                    flow.charge_id -- 临时造的关联字段
                                FROM vd_a_pay_flow_2015 flow
                                INNER JOIN (select charge_id from vd_a_pay_flow_2015 limit ', start_line, ',', offset, ') tmpflow ON flow.charge_id = tmpflow.charge_id;');
        PREPARE stmt FROM @strsql;
        EXECUTE stmt;
        DEALLOCATE PREPARE stmt; -- 释放
        -- 翻页
        set start_line = start_line + offset;
    end while;

    # 重建索引
    ALTER table vd_e_calc_pp_parm_2015 ADD INDEX idx_vd_e_calc_pp_parm_chargeid(chargeid); -- 5min

    SELECT t_error, msg;
END
$$
delimiter ;

CALL mig_zz_3_6();