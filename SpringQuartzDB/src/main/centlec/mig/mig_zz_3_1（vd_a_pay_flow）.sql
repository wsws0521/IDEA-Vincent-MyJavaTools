DROP PROCEDURE IF EXISTS mig_zz_3_1;
DELIMITER $$
CREATE PROCEDURE mig_zz_3_1()

BEGIN
    DECLARE start_year int default 2016;    /* ++++++根据执行库的年份修改，脚本必须在指定库上执行++++++ */
    DECLARE db_name VARCHAR(16);
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg TEXT;
	DECLARE start_line INT DEFAULT 0;
	DECLARE OFFSET INT DEFAULT 200000; -- 一次最多插35W，否则就报3100，所以只能分页插，20W耗时59s
	DECLARE total INT DEFAULT 0;
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	BEGIN
		get diagnostics CONDITION 1 msg = message_text;
		SET t_error = 1;
	END;

	# 删除被插表索引
	SET db_name = (select CONCAT('centlec', start_year));
	IF EXISTS(SELECT * FROM information_schema.statistics WHERE TABLE_SCHEMA = db_name AND table_name='vd_a_pay_flow' AND index_name='IDX_PAY_FLOW_METER_ID') THEN
		ALTER TABLE vd_a_pay_flow DROP INDEX IDX_PAY_FLOW_METER_ID;
	END IF;
	IF EXISTS(SELECT * FROM information_schema.statistics WHERE TABLE_SCHEMA = db_name AND table_name='vd_a_pay_flow' AND index_name='IDX_PAY_FLOW_DS_ID') THEN
		ALTER TABLE vd_a_pay_flow DROP INDEX IDX_PAY_FLOW_DS_ID;
	END IF;
	IF EXISTS(SELECT * FROM information_schema.statistics WHERE TABLE_SCHEMA = db_name AND table_name='vd_a_pay_flow' AND index_name='IDX_PAY_FLOW_ORG_ID') THEN
		ALTER TABLE vd_a_pay_flow DROP INDEX IDX_PAY_FLOW_ORG_ID;
	END IF;
	IF EXISTS(SELECT * FROM information_schema.statistics WHERE TABLE_SCHEMA = db_name AND table_name='vd_a_pay_flow' AND index_name='IDX_PAY_FLOW_OBJ_ID') THEN
		ALTER TABLE vd_a_pay_flow DROP INDEX IDX_PAY_FLOW_OBJ_ID;
	END IF;
	IF EXISTS(SELECT * FROM information_schema.statistics WHERE TABLE_SCHEMA = db_name AND table_name='vd_a_pay_flow' AND index_name='IDX_PAY_FLOW_ORDERID') THEN
		ALTER TABLE vd_a_pay_flow DROP INDEX IDX_PAY_FLOW_ORDERID;
	END IF;
	IF EXISTS(SELECT * FROM information_schema.statistics WHERE TABLE_SCHEMA = db_name AND table_name='vd_a_pay_flow' AND index_name='IDX_PAY_FLOW_1234') THEN
		ALTER TABLE vd_a_pay_flow DROP INDEX IDX_PAY_FLOW_1234;
	END IF;

	# 1-循环插入 收费明细(正常) 1h40min
	SET total = (SELECT COUNT(ordersid) FROM tmp_sdjl);
	WHILE start_line < total DO
        SET @strsql = CONCAT('INSERT INTO vd_a_pay_flow
                                    (lessee_id, charge_id, ds_id, obj_type, obj_id, obj_no, meter_id, meter_no,
                                    charge_ym, charge_date, acct_ym, type_code, rcv_amt, change_amt, rcvd_amt,
                                    charge_oper, settle_mode, settle_note_no, settle_bank_code, dept_id, rcv_org_id,
                                    charge_remark, relate_id, src, org_id, pay_bank_acc, rcv_bank, rcv_bank_acc,
                                    tv, channel, orderid, ISFREE, OCD_MONEY, FP_VAL3, OCD_DEBT)
                                SELECT
                                    2, AMI_GET_SEQUENCE(''SEQ_VD_A_PAY_FLOW''),
                                    daily.DS_ID, -- 日结标识
                                    ''02'', -- 对象类型:01客户、02用户03代理商04加密盒03表计厂商
                                    cons.cons_id, cons.cons_no, meter.meter_id, meter.assetno, -- 用户、表计信息
                                    DATE_FORMAT(sdjl.OD_DATE,''%Y%m''), sdjl.OD_DATE,  -- 收费年月、收费日期
                                    NULL, -- 记账年月
                                    CASE WHEN sdjl.ISFREE=1 THEN ''15'' ELSE ''11'' END, -- 收费类型[AMT_TYPE]：10还债收费11收电费12收业务费15FBE 50冲正
                                    CASE WHEN sdjl.ISFREE=1 THEN 0 ELSE ROUND(sdjl.OCD_PAYMONEY, 2) END, -- 收费金额+++a.DELFLAG=1需要再生成一行符号相反的记录
                                    0.00, -- 找零金额
                                    CASE WHEN sdjl.ISFREE=1 THEN 0 ELSE ROUND(sdjl.OCD_PAYMONEY, 2) END, -- 实收金额+++a.DELFLAG=1需要再生成一行符号相反的记录
                                    uapuser.id, -- 收此费用的操作员ID
                                    CASE    WHEN sdjl.PAYTYPE=0 THEN ''01''
                                            WHEN sdjl.PAYTYPE=1 THEN ''04''
                                            WHEN sdjl.PAYTYPE=2 THEN ''02''
                                            ELSE ''01'' END, -- 结算方式：01现金、02支票、03转账、04信用卡 等
                                    NULL, NULL, -- 转账账号、银行
                                    agt.ORG_ID, agt.ORG_ID, -- 收款部门、单位
                                    ''migrate normal'', -- 备注（利用此字段标识该笔收费属于正常还是冲正）
                                    NULL, -- 关联标识
                                    ''02'', -- 源：02Vending
                                    consorg.id, -- 供电单位
                                    NULL, -- 付款账号
                                    NULL, -- 付款银行
                                    NULL, -- 收款账号
                                    sdjl.OD_DATE, -- 手动插入TV字段，应用于分区（该值不应为空）
                                    NULL, -- 渠道
                                    sdjl.ORDERSID, -- 临时存储该次偿还在老系统的订单编号（可能存在一个order对应多个debt）
                                    sdjl.ISFREE, sdjl.OCD_MONEY, sdjl.FP_VAL3, sdjl.OCD_DEBT -- 临时存储，用来 提升应收/实收 关联查询效率
                                FROM tmp_sdjl sdjl
                                INNER JOIN (select ORDERSID from tmp_sdjl limit ', start_line, ',', OFFSET, ') tmpsdjl ON sdjl.ORDERSID = tmpsdjl.ORDERSID
                                LEFT JOIN vd_a_daily_flow daily ON sdjl.BANKINGNO = daily.DS_NO AND sdjl.DELFLAG = 0 -- 撤单的日结标识为NULL
                                LEFT JOIN a_consumer cons ON CONCAT(''CN_'', sdjl.CUSTOMER_ID) = cons.cons_no
                                LEFT JOIN a_equip_meter meter ON sdjl.MT_COMM_ADDR = meter.assetno
                                LEFT JOIN uap_user uapuser ON sdjl.operator = uapuser.no
                                LEFT JOIN VD_AGT_AGENT agt ON sdjl.TE_NAME = agt.AGENT_NAME
                                LEFT JOIN uap_organization consorg ON cons.org_no = consorg.no;');
        PREPARE stmt FROM @strsql;
        EXECUTE stmt;
        DEALLOCATE PREPARE stmt; -- 释放
        -- 翻页
        SET start_line = start_line + OFFSET;
    END WHILE;

    # 2-插入 收费明细(撤单)
    INSERT INTO vd_a_pay_flow
        (lessee_id, charge_id, ds_id, obj_type, obj_id, obj_no, meter_id, meter_no,
        charge_ym, charge_date, acct_ym, type_code, rcv_amt, change_amt, rcvd_amt,
        charge_oper, settle_mode, settle_note_no, settle_bank_code, dept_id, rcv_org_id,
        charge_remark, relate_id, src, org_id, pay_bank_acc, rcv_bank, rcv_bank_acc,
        tv, channel, orderid, ISFREE, OCD_MONEY, FP_VAL3, OCD_DEBT)
    SELECT
        2, AMI_GET_SEQUENCE('SEQ_VD_A_PAY_FLOW'),
        NULL, -- 撤单的日结标识为NULL
        '02', -- 对象类型:01客户、02用户03代理商04加密盒03表计厂商
        cons.cons_id, cons.cons_no, meter.meter_id, meter.assetno, -- 用户、表计信息
        DATE_FORMAT(sdjl.OD_DATE,'%Y%m'), sdjl.OD_DATE,  -- 收费年月、收费日期
        NULL, -- 记账年月
        '50', -- 收费类型[AMT_TYPE]：10还债收费11收电费12收业务费15FBE 50冲正
        CASE WHEN sdjl.ISFREE=1 THEN 0 ELSE (-1)*ROUND(sdjl.OCD_PAYMONEY, 2) END, -- 收费金额+++a.DELFLAG=1需要再生成一行符号相反的记录
        0.00, -- 找零金额
        CASE WHEN sdjl.ISFREE=1 THEN 0 ELSE (-1)*ROUND(sdjl.OCD_PAYMONEY, 2) END, -- 实收金额+++a.DELFLAG=1需要再生成一行符号相反的记录
        uapuser.id, -- 收此费用的操作员ID
        CASE    WHEN sdjl.PAYTYPE=0 THEN '01'
                WHEN sdjl.PAYTYPE=1 THEN '04'
                WHEN sdjl.PAYTYPE=2 THEN '02'
                ELSE '01' END, -- 结算方式：01现金、02支票、03转账、04信用卡 等
        NULL, NULL, -- 转账账号、银行
        agt.ORG_ID, agt.ORG_ID, -- 收款部门、单位
        'migrate reversal', -- 备注（利用此字段标识该笔收费属于正常还是冲正）
        NULL, -- 关联标识
        '02', -- 源：02Vending
        consorg.id, -- 供电单位
        NULL, -- 付款账号
        NULL, -- 付款银行
        NULL, -- 收款账号
        sdjl.OD_DATE, -- 手动插入TV字段，应用于分区（该值不应为空）
        NULL, -- 渠道
        sdjl.ORDERSID, -- 临时存储该次偿还在老系统的订单编号（可能存在一个order对应多个debt）
        sdjl.ISFREE, sdjl.OCD_MONEY, sdjl.FP_VAL3, sdjl.OCD_DEBT -- 临时存储，用来 提升应收/实收 关联查询效率
    FROM tmp_sdjl sdjl
    LEFT JOIN a_consumer cons ON CONCAT('CN_', sdjl.CUSTOMER_ID) = cons.cons_no
    LEFT JOIN a_equip_meter meter ON sdjl.MT_COMM_ADDR = meter.assetno
    LEFT JOIN uap_user uapuser ON sdjl.operator = uapuser.no
    LEFT JOIN VD_AGT_AGENT agt ON sdjl.TE_NAME = agt.AGENT_NAME
    LEFT JOIN uap_organization consorg ON cons.org_no = consorg.no
    WHERE sdjl.DELFLAG = 1; -- 正常订单 和 FBE 是分开的2条，FBE 撤单也会负数冲正，只不过 +0-0 看上去一样

    # 重建索引  导入所有年份再建索引
    ALTER TABLE vd_a_pay_flow ADD INDEX IDX_PAY_FLOW_METER_ID(METER_ID); -- 2min
    ALTER TABLE vd_a_pay_flow ADD INDEX IDX_PAY_FLOW_DS_ID(DS_ID); -- 75s
    ALTER TABLE vd_a_pay_flow ADD INDEX IDX_PAY_FLOW_ORG_ID(ORG_ID); -- 82s
    ALTER TABLE vd_a_pay_flow ADD INDEX IDX_PAY_FLOW_OBJ_ID(OBJ_ID); -- 2min
    ALTER TABLE vd_a_pay_flow ADD INDEX IDX_PAY_FLOW_ORDERID(orderid); -- 2min
    -- ALTER table vd_a_pay_flow ADD INDEX IDX_PAY_FLOW_REMARK(charge_remark); -- 148s 没啥效果
    ALTER TABLE vd_a_pay_flow ADD INDEX IDX_PAY_FLOW_1234(charge_remark,isfree,OCD_MONEY,FP_VAL3,OCD_DEBT); -- 244s提升 应收实收查询效率 70s至30s

    SELECT t_error, msg;
END
$$
DELIMITER ;

CALL mig_zz_3_1();
