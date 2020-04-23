DROP PROCEDURE IF EXISTS mig_zz_3_7;
delimiter $$
CREATE PROCEDURE mig_zz_3_7()

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

    # 删除被插表索引
	IF EXISTS(SELECT * FROM information_schema.statistics WHERE table_name='vd_a_rcvbl_flow_2015' AND index_name='IDX_RCVBL_FLOW_OBJ_ID') THEN
		ALTER table vd_a_rcvbl_flow_2015 DROP INDEX IDX_RCVBL_FLOW_OBJ_ID;
	END IF;

    # 一条【正常收费】记录可能分为：{电价电费应收}+{计费项应收}+{债务应收}，一条【FBE收费】记录必须分为{+OCD_MONEY}和{-OCD_MONEY}两条应收。
    # 撤单冲正不在应收体现，在实收再额外生成符号相反的冲正记录

    # 1-插入应收
    while start_line < total do
	    -- 1-【正常收费】{电价电费应收}
        SET @strsql = CONCAT('INSERT INTO vd_a_rcvbl_flow_2015
                                    (`LESSEE_ID`, `RCVBL_AMT_ID`, `CALC_ID`, `AMT_TYPE`, `RCVBL_YM`, `OBJ_TYPE`, `OBJ_ID`, `OBJ_NO`,
                                    `METER_ID`, `METER_NO`, `RCVBL_AMT`, `RCVED_AMT`, `RCVBL_PENALTY`, `RCVED_PENALTY`, `STATUS_CODE`,
                                    `SETTLE_FLAG`, `PENALTY_BGN_DATE`, `RELEASE_DATE`, `RELATE_ID`, `RELATE_FLAG`, `SRC`, `RES_QUAN`, `ORG_ID`,
                                    `BUS_FROM_OBJ`, `BUS_FROM_OBJ_ID`, `TV`, orderid)
                                SELECT
                                    2,
                                    AMI_GET_SEQUENCE(''SEQ_VD_A_RCVBL_FLOW''), -- RCVBL_AMT_ID
                                    pp.CALC_ID, -- CALC_ID  电费计算标识FK
                                    ''01'', -- AMT_TYPE 费用类型:产生应收的来源分类，包括01 电费 02免费电费 11 债务 21 佣金 31 费率费用 32免费费率费用 41 业务费
                                    flow.charge_ym, -- RCVBL_YM 应收年月
                                    flow.obj_type, -- OBJ_TYPE 对象类型:01客户、02用户03代理商04加密盒03表计厂商
                                    flow.obj_id, -- OBJ_ID 对象标识/用户ID
                                    flow.obj_no, -- OBJ_NO 对象编号/用户NO
                                    flow.meter_id -- METER_ID
                                    flow.meter_no, -- METER_NO
                                    sdjl.OCD_MONEY, -- RCVBL_AMT  应收金额（电价电费）
                                    sdjl.OCD_MONEY, -- RCVED_AMT  实收金额（电价电费）
                                    NULL, -- RCVBL_PENALTY 应收违约金
                                    NULL, -- RCVED_PENALTY 实收违约金
                                    NULL, -- STATUS_CODE 收取过程的状态，包括非锁定、锁定(代扣在途)、锁定(走收在途)、锁定(托收在途)。
                                    IF(sdjl.DELFLAG=0,''03'',''05''), -- SETTLE_FLAG 结清状态：单笔售电+还债记录认为结清 未撤单就是03结清，否则就是05作废
                                    NULL, -- PENALTY_BGN_DATE 违约金起算日期
                                    NULL, -- RELEASE_DATE 发行日期
                                    NULL, -- RELATE_ID 关联标识
                                    NULL, -- RELATE_FLAG 关联标志
                                    ''02'', -- SRC 源：02Vending
                                    ROUND(sdjl.OCD_ENERGY, 2), -- RES_QUAN 资源量
                                    flow.org_id, -- ORG_ID 用户的单位id
                                    NULL, -- BUS_FROM_OBJ 业务来源对象
                                    NULL, -- BUS_FROM_OBJ_ID 业务来源标识
                                    sdjl.OD_DATE, -- TV 分区字段
                                    flow.orderid -- 临时造的关联字段
                                FROM vd_a_pay_flow_2015 flow INNER JOIN (select charge_id from vd_a_pay_flow_2015 limit ', start_line, ',', offset, ') tmpflow ON flow.charge_id = tmpflow.charge_id
                                LEFT JOIN tmp_sdjl_2015 sdjl ON flow.orderid = sdjl.ORDERSID
                                LEFT JOIN vd_e_calc_pp_parm_2015 pp ON flow.orderid = pp.ORDERID
                                WHERE flow.charge_remark = ''migrate normal'' AND sdjl.ISFREE= 0 AND sdjl.OCD_MONEY > 0;');
        PREPARE stmt FROM @strsql;
        EXECUTE stmt;
        DEALLOCATE PREPARE stmt; -- 释放
        -- 2-【正常收费】{计费项应收}
        SET @strsql = CONCAT('INSERT INTO vd_a_rcvbl_flow_2015
                                    (`LESSEE_ID`, `RCVBL_AMT_ID`, `CALC_ID`, `AMT_TYPE`, `RCVBL_YM`, `OBJ_TYPE`, `OBJ_ID`, `OBJ_NO`,
                                    `METER_ID`, `METER_NO`, `RCVBL_AMT`, `RCVED_AMT`, `RCVBL_PENALTY`, `RCVED_PENALTY`, `STATUS_CODE`,
                                    `SETTLE_FLAG`, `PENALTY_BGN_DATE`, `RELEASE_DATE`, `RELATE_ID`, `RELATE_FLAG`, `SRC`, `RES_QUAN`, `ORG_ID`,
                                    `BUS_FROM_OBJ`, `BUS_FROM_OBJ_ID`, `TV`, orderid)
                                SELECT
                                    2,
                                    AMI_GET_SEQUENCE(''SEQ_VD_A_RCVBL_FLOW''), -- RCVBL_AMT_ID
                                    pp.CALC_ID, -- CALC_ID  电费计算标识FK
                                    ''31'', -- AMT_TYPE 费用类型:产生应收的来源分类，包括01 电费 02免费电费 11 债务 21 佣金 31 费率费用 32免费费率费用 41 业务费
                                    flow.charge_ym, -- RCVBL_YM 应收年月
                                    flow.obj_type, -- OBJ_TYPE 对象类型:01客户、02用户03代理商04加密盒03表计厂商
                                    flow.obj_id, -- OBJ_ID 对象标识/用户ID
                                    flow.obj_no, -- OBJ_NO 对象编号/用户NO
                                    flow.meter_id -- METER_ID
                                    flow.meter_no, -- METER_NO
                                    sdjl.FP_VAL3, -- RCVBL_AMT   应收金额（计费项）
                                    sdjl.FP_VAL3, -- RCVED_AMT   实收金额（计费项）
                                    NULL, -- RCVBL_PENALTY 应收违约金
                                    NULL, -- RCVED_PENALTY 实收违约金
                                    NULL, -- STATUS_CODE 收取过程的状态，包括非锁定、锁定(代扣在途)、锁定(走收在途)、锁定(托收在途)。
                                    IF(sdjl.DELFLAG=0,''03'',''05''), -- SETTLE_FLAG 结清状态：单笔售电+还债记录认为结清 未撤单就是03结清，否则就是05作废
                                    NULL, -- PENALTY_BGN_DATE 违约金起算日期
                                    NULL, -- RELEASE_DATE 发行日期
                                    NULL, -- RELATE_ID 关联标识
                                    NULL, -- RELATE_FLAG 关联标志
                                    ''02'', -- SRC 源：02Vending
                                    NULL, -- RES_QUAN 资源量
                                    flow.org_id, -- ORG_ID 用户的单位id
                                    NULL, -- BUS_FROM_OBJ 业务来源对象
                                    NULL, -- BUS_FROM_OBJ_ID 业务来源标识
                                    sdjl.OD_DATE, -- TV 分区字段
                                    flow.orderid -- 临时造的关联字段
                                FROM vd_a_pay_flow_2015 flow INNER JOIN (select charge_id from vd_a_pay_flow_2015 limit ', start_line, ',', offset, ') tmpflow ON flow.charge_id = tmpflow.charge_id
                                LEFT JOIN tmp_sdjl_2015 sdjl ON flow.orderid = sdjl.ORDERSID
                                LEFT JOIN vd_e_calc_pp_parm_2015 pp ON flow.orderid = pp.ORDERID
                                WHERE flow.charge_remark = ''migrate normal'' AND sdjl.ISFREE= 0 AND sdjl.FP_VAL3 > 0;');
        PREPARE stmt FROM @strsql;
        EXECUTE stmt;
        DEALLOCATE PREPARE stmt; -- 释放
        -- 3-【正常收费】{债务应收}
        SET @strsql = CONCAT('INSERT INTO vd_a_rcvbl_flow_2015
                                    (`LESSEE_ID`, `RCVBL_AMT_ID`, `CALC_ID`, `AMT_TYPE`, `RCVBL_YM`, `OBJ_TYPE`, `OBJ_ID`, `OBJ_NO`,
                                    `METER_ID`, `METER_NO`, `RCVBL_AMT`, `RCVED_AMT`, `RCVBL_PENALTY`, `RCVED_PENALTY`, `STATUS_CODE`,
                                    `SETTLE_FLAG`, `PENALTY_BGN_DATE`, `RELEASE_DATE`, `RELATE_ID`, `RELATE_FLAG`, `SRC`, `RES_QUAN`, `ORG_ID`,
                                    `BUS_FROM_OBJ`, `BUS_FROM_OBJ_ID`, `TV`, orderid)
                                SELECT
                                    2,
                                    AMI_GET_SEQUENCE(''SEQ_VD_A_RCVBL_FLOW''), -- RCVBL_AMT_ID
                                    pp.CALC_ID, -- CALC_ID  电费计算标识FK
                                    ''11'', -- AMT_TYPE 费用类型:产生应收的来源分类，包括01 电费 02免费电费 11 债务 21 佣金 31 费率费用 32免费费率费用 41 业务费
                                    flow.charge_ym, -- RCVBL_YM 应收年月
                                    flow.obj_type, -- OBJ_TYPE 对象类型:01客户、02用户03代理商04加密盒03表计厂商
                                    flow.obj_id, -- OBJ_ID 对象标识/用户ID
                                    flow.obj_no, -- OBJ_NO 对象编号/用户NO
                                    flow.meter_id -- METER_ID
                                    flow.meter_no, -- METER_NO
                                    sdjl.OCD_DEBT, -- RCVBL_AMT   应收金额（债务）
                                    sdjl.OCD_DEBT, -- RCVED_AMT   实收金额（债务）
                                    NULL, -- RCVBL_PENALTY 应收违约金
                                    NULL, -- RCVED_PENALTY 实收违约金
                                    NULL, -- STATUS_CODE 收取过程的状态，包括非锁定、锁定(代扣在途)、锁定(走收在途)、锁定(托收在途)。
                                    IF(sdjl.DELFLAG=0,''03'',''05''), -- SETTLE_FLAG 结清状态：单笔售电+还债记录认为结清 未撤单就是03结清，否则就是05作废
                                    NULL, -- PENALTY_BGN_DATE 违约金起算日期
                                    NULL, -- RELEASE_DATE 发行日期
                                    NULL, -- RELATE_ID 关联标识
                                    NULL, -- RELATE_FLAG 关联标志
                                    ''02'', -- SRC 源：02Vending
                                    NULL, -- RES_QUAN 资源量
                                    flow.org_id, -- ORG_ID 用户的单位id
                                    NULL, -- BUS_FROM_OBJ 业务来源对象
                                    NULL, -- BUS_FROM_OBJ_ID 业务来源标识
                                    sdjl.OD_DATE, -- TV 分区字段
                                    flow.orderid -- 临时造的关联字段
                                FROM vd_a_pay_flow_2015 flow INNER JOIN (select charge_id from vd_a_pay_flow_2015 limit ', start_line, ',', offset, ') tmpflow ON flow.charge_id = tmpflow.charge_id
                                LEFT JOIN tmp_sdjl_2015 sdjl ON flow.orderid = sdjl.ORDERSID
                                LEFT JOIN vd_e_calc_pp_parm_2015 pp ON flow.orderid = pp.ORDERID
                                WHERE flow.charge_remark = ''migrate normal'' AND sdjl.ISFREE= 0 AND sdjl.OCD_DEBT > 0;');
        PREPARE stmt FROM @strsql;
        EXECUTE stmt;
        DEALLOCATE PREPARE stmt; -- 释放
        -- 4-【FBE收费】{+OCD_MONEY}
        SET @strsql = CONCAT('INSERT INTO vd_a_rcvbl_flow_2015
                                    (`LESSEE_ID`, `RCVBL_AMT_ID`, `CALC_ID`, `AMT_TYPE`, `RCVBL_YM`, `OBJ_TYPE`, `OBJ_ID`, `OBJ_NO`,
                                    `METER_ID`, `METER_NO`, `RCVBL_AMT`, `RCVED_AMT`, `RCVBL_PENALTY`, `RCVED_PENALTY`, `STATUS_CODE`,
                                    `SETTLE_FLAG`, `PENALTY_BGN_DATE`, `RELEASE_DATE`, `RELATE_ID`, `RELATE_FLAG`, `SRC`, `RES_QUAN`, `ORG_ID`,
                                    `BUS_FROM_OBJ`, `BUS_FROM_OBJ_ID`, `TV`, orderid)
                                SELECT
                                    2,
                                    AMI_GET_SEQUENCE(''SEQ_VD_A_RCVBL_FLOW''), -- RCVBL_AMT_ID
                                    pp.CALC_ID, -- CALC_ID  电费计算标识FK
                                    ''02'', -- AMT_TYPE 费用类型:产生应收的来源分类，包括01 电费 02免费电费 11 债务 21 佣金 31 费率费用 32免费费率费用 41 业务费
                                    flow.charge_ym, -- RCVBL_YM 应收年月
                                    flow.obj_type, -- OBJ_TYPE 对象类型:01客户、02用户03代理商04加密盒03表计厂商
                                    flow.obj_id, -- OBJ_ID 对象标识/用户ID
                                    flow.obj_no, -- OBJ_NO 对象编号/用户NO
                                    flow.meter_id -- METER_ID
                                    flow.meter_no, -- METER_NO
                                    sdjl.OCD_MONEY, -- RCVBL_AMT   应收金额（+FBE.OCD_MONEY）
                                    sdjl.OCD_MONEY, -- RCVED_AMT   实收金额（+FBE.OCD_MONEY）
                                    NULL, -- RCVBL_PENALTY 应收违约金
                                    NULL, -- RCVED_PENALTY 实收违约金
                                    NULL, -- STATUS_CODE 收取过程的状态，包括非锁定、锁定(代扣在途)、锁定(走收在途)、锁定(托收在途)。
                                    IF(sdjl.DELFLAG=0,''03'',''05''), -- SETTLE_FLAG 结清状态：单笔售电+还债记录认为结清 未撤单就是03结清，否则就是05作废
                                    NULL, -- PENALTY_BGN_DATE 违约金起算日期
                                    NULL, -- RELEASE_DATE 发行日期
                                    NULL, -- RELATE_ID 关联标识
                                    NULL, -- RELATE_FLAG 关联标志
                                    ''02'', -- SRC 源：02Vending
                                    sdjl.OCD_ENERGY, -- RES_QUAN 资源量
                                    flow.org_id, -- ORG_ID 用户的单位id
                                    NULL, -- BUS_FROM_OBJ 业务来源对象
                                    NULL, -- BUS_FROM_OBJ_ID 业务来源标识
                                    sdjl.OD_DATE, -- TV 分区字段
                                    flow.orderid -- 临时造的关联字段
                                FROM vd_a_pay_flow_2015 flow INNER JOIN (select charge_id from vd_a_pay_flow_2015 limit ', start_line, ',', offset, ') tmpflow ON flow.charge_id = tmpflow.charge_id
                                LEFT JOIN tmp_sdjl_2015 sdjl ON flow.orderid = sdjl.ORDERSID
                                LEFT JOIN vd_e_calc_pp_parm_2015 pp ON flow.orderid = pp.ORDERID
                                WHERE flow.charge_remark = ''migrate normal'' AND sdjl.ISFREE= 1 AND sdjl.OCD_MONEY > 0;');
        PREPARE stmt FROM @strsql;
        EXECUTE stmt;
        DEALLOCATE PREPARE stmt; -- 释放
        -- 5-【FBE收费】{-OCD_MONEY}
        SET @strsql = CONCAT('INSERT INTO vd_a_rcvbl_flow_2015
                                    (`LESSEE_ID`, `RCVBL_AMT_ID`, `CALC_ID`, `AMT_TYPE`, `RCVBL_YM`, `OBJ_TYPE`, `OBJ_ID`, `OBJ_NO`,
                                    `METER_ID`, `METER_NO`, `RCVBL_AMT`, `RCVED_AMT`, `RCVBL_PENALTY`, `RCVED_PENALTY`, `STATUS_CODE`,
                                    `SETTLE_FLAG`, `PENALTY_BGN_DATE`, `RELEASE_DATE`, `RELATE_ID`, `RELATE_FLAG`, `SRC`, `RES_QUAN`, `ORG_ID`,
                                    `BUS_FROM_OBJ`, `BUS_FROM_OBJ_ID`, `TV`, orderid)
                                SELECT
                                    2,
                                    AMI_GET_SEQUENCE(''SEQ_VD_A_RCVBL_FLOW''), -- RCVBL_AMT_ID
                                    pp.CALC_ID, -- CALC_ID  电费计算标识FK
                                    ''02'', -- AMT_TYPE 费用类型:产生应收的来源分类，包括01 电费 02免费电费 11 债务 21 佣金 31 费率费用 32免费费率费用 41 业务费
                                    flow.charge_ym, -- RCVBL_YM 应收年月
                                    flow.obj_type, -- OBJ_TYPE 对象类型:01客户、02用户03代理商04加密盒03表计厂商
                                    flow.obj_id, -- OBJ_ID 对象标识/用户ID
                                    flow.obj_no, -- OBJ_NO 对象编号/用户NO
                                    flow.meter_id -- METER_ID
                                    flow.meter_no, -- METER_NO
                                    (-1)*sdjl.OCD_MONEY, -- RCVBL_AMT   应收金额（-FBE.OCD_MONEY）
                                    (-1)*sdjl.OCD_MONEY, -- RCVED_AMT   实收金额（-FBE.OCD_MONEY）
                                    NULL, -- RCVBL_PENALTY 应收违约金
                                    NULL, -- RCVED_PENALTY 实收违约金
                                    NULL, -- STATUS_CODE 收取过程的状态，包括非锁定、锁定(代扣在途)、锁定(走收在途)、锁定(托收在途)。
                                    IF(sdjl.DELFLAG=0,''03'',''05''), -- SETTLE_FLAG 结清状态：单笔售电+还债记录认为结清 未撤单就是03结清，否则就是05作废
                                    NULL, -- PENALTY_BGN_DATE 违约金起算日期
                                    NULL, -- RELEASE_DATE 发行日期
                                    NULL, -- RELATE_ID 关联标识
                                    NULL, -- RELATE_FLAG 关联标志
                                    ''02'', -- SRC 源：02Vending
                                    sdjl.OCD_ENERGY, -- RES_QUAN 资源量
                                    flow.org_id, -- ORG_ID 用户的单位id
                                    NULL, -- BUS_FROM_OBJ 业务来源对象
                                    NULL, -- BUS_FROM_OBJ_ID 业务来源标识
                                    sdjl.OD_DATE, -- TV 分区字段
                                    flow.orderid -- 临时造的关联字段
                                FROM vd_a_pay_flow_2015 flow INNER JOIN (select charge_id from vd_a_pay_flow_2015 limit ', start_line, ',', offset, ') tmpflow ON flow.charge_id = tmpflow.charge_id
                                LEFT JOIN tmp_sdjl_2015 sdjl ON flow.orderid = sdjl.ORDERSID
                                LEFT JOIN vd_e_calc_pp_parm_2015 pp ON flow.orderid = pp.ORDERID
                                WHERE flow.charge_remark = ''migrate normal'' AND sdjl.ISFREE= 1 AND sdjl.OCD_MONEY > 0;');
        PREPARE stmt FROM @strsql;
        EXECUTE stmt;
        DEALLOCATE PREPARE stmt; -- 释放
        -- 翻页
        set start_line = start_line + offset;
    end while;

    # 重建索引
    ALTER table vd_a_rcvbl_flow_2015 ADD IDX_RCVBL_FLOW_OBJ_ID(OBJ_ID, METER_ID, SETTLE_FLAG); -- 5min

    SELECT t_error, msg;
END
$$
delimiter ;

CALL mig_zz_3_7();
