DROP PROCEDURE IF EXISTS syn_zz_3_1;
delimiter $$
CREATE PROCEDURE syn_zz_3_1()(OUT `error_code` integer, OUT `error_msg` text)

BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

    # 1-插入 收费明细(正常)
    INSERT INTO vd_a_pay_flow
        (lessee_id, charge_id, ds_id, obj_type, obj_id, obj_no, meter_id, meter_no,
        charge_ym, charge_date, acct_ym, type_code, rcv_amt, change_amt, rcvd_amt,
        charge_oper, settle_mode, settle_note_no, settle_bank_code, dept_id, rcv_org_id,
        charge_remark, relate_id, src, org_id, pay_bank_acc, rcv_bank, rcv_bank_acc,
        tv, channel, orderid, ISFREE, OCD_MONEY, FP_VAL3, OCD_DEBT)
    SELECT
        2, AMI_GET_SEQUENCE('SEQ_VD_A_PAY_FLOW'),
        daily.DS_ID, -- 日结标识
        '02', -- 对象类型:01客户、02用户03代理商04加密盒03表计厂商
        cons.cons_id, cons.cons_no, meter.meter_id, meter.assetno, -- 用户、表计信息
        DATE_FORMAT(sdjl.OD_DATE,'%Y%m'), sdjl.OD_DATE,  -- 收费年月、收费日期
        NULL, -- 记账年月
        CASE WHEN sdjl.ISFREE=1 THEN '15' ELSE '11' END, -- 收费类型[AMT_TYPE]：10还债收费11收电费12收业务费15FBE 50冲正
        CASE WHEN sdjl.ISFREE=1 THEN 0 ELSE ROUND(sdjl.OCD_PAYMONEY, 2) END, -- 收费金额+++a.DELFLAG=1需要再生成一行符号相反的记录
        0.00, -- 找零金额
        CASE WHEN sdjl.ISFREE=1 THEN 0 ELSE ROUND(sdjl.OCD_PAYMONEY, 2) END, -- 实收金额+++a.DELFLAG=1需要再生成一行符号相反的记录
        uapuser.id, -- 收此费用的操作员ID
        CASE    WHEN sdjl.PAYTYPE=0 THEN '01'
                WHEN sdjl.PAYTYPE=1 THEN '04'
                WHEN sdjl.PAYTYPE=2 THEN '02'
                ELSE '01' END, -- 结算方式：01现金、02支票、03转账、04信用卡 等
        NULL, NULL, -- 转账账号、银行
        agt.ORG_ID, agt.ORG_ID, -- 收款部门、单位
        'migrate normal', -- 备注（利用此字段标识该笔收费属于正常还是冲正）
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
    LEFT JOIN vd_a_daily_flow daily ON sdjl.BANKINGNO = daily.DS_NO AND sdjl.DELFLAG = 0 -- 撤单的日结标识为NULL
    LEFT JOIN a_consumer cons ON CONCAT('CN_', sdjl.CUSTOMER_ID) = cons.cons_no
    LEFT JOIN a_equip_meter meter ON sdjl.MT_COMM_ADDR = meter.assetno
    LEFT JOIN uap_user uapuser ON sdjl.operator = uapuser.no
    LEFT JOIN VD_AGT_AGENT agt ON sdjl.TE_NAME = agt.AGENT_NAME
    LEFT JOIN uap_organization consorg ON cons.org_no = consorg.no;

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

    SELECT t_error into error_code;
    SELECT msg into error_msg;
END
$$
delimiter ;


