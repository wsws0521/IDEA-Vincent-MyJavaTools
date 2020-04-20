DROP PROCEDURE IF EXISTS mig_zz_3_10;
delimiter $$
CREATE PROCEDURE mig_zz_3_10()

BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

    # 开启事务
    START TRANSACTION;

    # 一条【正常收费】记录可能分为：{电价电费应收}+{计费项应收}+{债务应收}，一条【FBE收费】记录必须分为{+OCD_MONEY}和{-OCD_MONEY}两条应收。
    # 【撤单冲正】在此体现，即再额外生成符号相反的冲正记录

    # 1-插入 实收
	INSERT INTO vd_a_rcved_flow_2015
		(`LESSEE_ID`, `RCVED_AMT_ID`, `CHARGE_ID`, `RCVBL_AMT_ID`, `CONS_NO`, `METER_ID`, `ASSET_NO`, `RCVED_DATE`, `RCVBL_YM`,
        `THIS_RCVED_AMT`, `THIS_PENALTY`, `AMT_TYPE`, `OWE_AMT`, `ORG_ID`, `TV`, orderid)
	SELECT
		2, AMI_GET_SEQUENCE('SEQ_VD_A_RCVED_FLOW'), -- RCVED_AMT_ID PK
		flow.charge_id, -- CHARGE_ID
        rcvblflow.RCVBL_AMT_ID, -- RCVBL_AMT_ID 应收表的主键
        rcvblflow.OBJ_NO, -- CONS_NO 用户编号
        rcvblflow.METER_ID, -- METER_ID 表计标识
        rcvblflow.METER_NO, -- ASSET_NO 表号
		DATE_FORMAT(flow.charge_date,'%Y%m%d'), -- RCVED_DATE 注意此处格式：20200122
		rcvblflow.RCVBL_YM, -- RCVBL_YM
		rcvblflow.RCVED_AMT, -- THIS_RCVED_AMT 实收金额（电价电费/计费项/债务）
		NULL, -- THIS_PENALTY 实收违约金
		rcvblflow.AMT_TYPE, -- AMT_TYPE 按产生应收的来源分类，包括01 电费 02免费电费 11 债务 21 佣金 31 费率费用 32免费费率费用 41 业务费
		NULL, -- OWE_AMT 销账前实收金额
		rcvblflow.ORG_ID, -- ORG_ID 用户所属单位
		rcvblflow.tv, -- 分区字段
		rcvblflow.orderid -- orderid 临时存储
	FROM vd_a_pay_flow_2015 flow
	LEFT JOIN vd_a_rcvbl_flow_2015 rcvblflow ON flow.orderid = rcvblflow.orderid
	WHERE flow.charge_remark = 'migrate normal' -- 【非撤单】-完全拷贝应收

	UNION ALL

    SELECT
		2, AMI_GET_SEQUENCE('SEQ_VD_A_RCVED_FLOW'), -- RCVED_AMT_ID PK
		flow.charge_id, -- CHARGE_ID
        rcvblflow.RCVBL_AMT_ID, -- RCVBL_AMT_ID 应收表的主键 共用【非撤单】那笔的应收
        flow.obj_no, -- CONS_NO 用户编号
        flow.meter_id, -- METER_ID 表计标识
        flow.meter_no, -- ASSET_NO 表号
		DATE_FORMAT(flow.charge_date,'%Y%m%d'), -- RCVED_DATE 注意此处格式：20200122
		flow.charge_ym, -- RCVBL_YM
		(-1)*ROUND(sdjl.OCD_MONEY, 2), -- THIS_RCVED_AMT 实收金额（电价电费）
		NULL, -- THIS_PENALTY 实收违约金
		'01', -- AMT_TYPE 按产生应收的来源分类，包括01 电费 02免费电费 11 债务 21 佣金 31 费率费用 32免费费率费用 41 业务费
		NULL, -- OWE_AMT 销账前实收金额
		flow.org_id, -- ORG_ID 用户所属单位
		flow.tv, -- 分区字段
		flow.orderid -- orderid 临时存储
	FROM vd_a_pay_flow_2015 flow
	LEFT JOIN tmp_sdjl_2015 sdjl ON flow.orderid = sdjl.ORDERSID
	LEFT JOIN vd_a_rcvbl_flow_2015 rcvblflow ON flow.orderid = rcvblflow.orderid AND flow.charge_remark = 'migrate normal' -- 理应能查到唯一的一笔【非撤单】应收
	WHERE flow.charge_remark = 'migrate reversal' AND sdjl.ISFREE= 0 AND sdjl.OCD_MONEY > 0 -- 【撤单1】-电价电费

	UNION ALL

    SELECT
		2, AMI_GET_SEQUENCE('SEQ_VD_A_RCVED_FLOW'), -- RCVED_AMT_ID PK
		flow.charge_id, -- CHARGE_ID
        rcvblflow.RCVBL_AMT_ID, -- RCVBL_AMT_ID 应收表的主键 共用【非撤单】那笔的应收
        flow.obj_no, -- CONS_NO 用户编号
        flow.meter_id, -- METER_ID 表计标识
        flow.meter_no, -- ASSET_NO 表号
		DATE_FORMAT(flow.charge_date,'%Y%m%d'), -- RCVED_DATE 注意此处格式：20200122
		flow.charge_ym, -- RCVBL_YM
		(-1)*ROUND(sdjl.FP_VAL3, 2), -- THIS_RCVED_AMT 实收金额（计费项）
		NULL, -- THIS_PENALTY 实收违约金
		'31', -- AMT_TYPE 按产生应收的来源分类，包括01 电费 02免费电费 11 债务 21 佣金 31 费率费用 32免费费率费用 41 业务费
		NULL, -- OWE_AMT 销账前实收金额
		flow.org_id, -- ORG_ID 用户所属单位
		flow.tv, -- 分区字段
		flow.orderid -- orderid 临时存储
	FROM vd_a_pay_flow_2015 flow
	LEFT JOIN tmp_sdjl_2015 sdjl ON flow.orderid = sdjl.ORDERSID
	LEFT JOIN vd_a_rcvbl_flow_2015 rcvblflow ON flow.orderid = rcvblflow.orderid AND flow.charge_remark = 'migrate normal' -- 理应能查到唯一的一笔【非撤单】应收
	WHERE flow.charge_remark = 'migrate reversal' AND sdjl.ISFREE= 0 AND sdjl.FP_VAL3 > 0 -- 【撤单2】-计费项

	UNION ALL

    SELECT
		2, AMI_GET_SEQUENCE('SEQ_VD_A_RCVED_FLOW'), -- RCVED_AMT_ID PK
		flow.charge_id, -- CHARGE_ID
        rcvblflow.RCVBL_AMT_ID, -- RCVBL_AMT_ID 应收表的主键 共用【非撤单】那笔的应收
        flow.obj_no, -- CONS_NO 用户编号
        flow.meter_id, -- METER_ID 表计标识
        flow.meter_no, -- ASSET_NO 表号
		DATE_FORMAT(flow.charge_date,'%Y%m%d'), -- RCVED_DATE 注意此处格式：20200122
		flow.charge_ym, -- RCVBL_YM
		(-1)*ROUND(sdjl.OCD_DEBT, 2), -- THIS_RCVED_AMT 实收金额（债务）
		NULL, -- THIS_PENALTY 实收违约金
		'11', -- AMT_TYPE 按产生应收的来源分类，包括01 电费 02免费电费 11 债务 21 佣金 31 费率费用 32免费费率费用 41 业务费
		NULL, -- OWE_AMT 销账前实收金额
		flow.org_id, -- ORG_ID 用户所属单位
		flow.tv, -- 分区字段
		flow.orderid -- orderid 临时存储
	FROM vd_a_pay_flow_2015 flow
	LEFT JOIN tmp_sdjl_2015 sdjl ON flow.orderid = sdjl.ORDERSID
	LEFT JOIN vd_a_rcvbl_flow_2015 rcvblflow ON flow.orderid = rcvblflow.orderid AND flow.charge_remark = 'migrate normal' -- 理应能查到唯一的一笔【非撤单】应收
	WHERE flow.charge_remark = 'migrate reversal' AND sdjl.ISFREE= 0 AND sdjl.OCD_DEBT > 0 -- 【撤单3】-债务

	UNION ALL

    SELECT
		2, AMI_GET_SEQUENCE('SEQ_VD_A_RCVED_FLOW'), -- RCVED_AMT_ID PK
		flow.charge_id, -- CHARGE_ID
        rcvblflow.RCVBL_AMT_ID, -- RCVBL_AMT_ID 应收表的主键 共用【非撤单】那笔的应收
        flow.obj_no, -- CONS_NO 用户编号
        flow.meter_id, -- METER_ID 表计标识
        flow.meter_no, -- ASSET_NO 表号
		DATE_FORMAT(flow.charge_date,'%Y%m%d'), -- RCVED_DATE 注意此处格式：20200122
		flow.charge_ym, -- RCVBL_YM
		(-1)*ROUND(sdjl.OCD_MONEY, 2), -- THIS_RCVED_AMT 实收金额（FBE）
		NULL, -- THIS_PENALTY 实收违约金
		'02', -- AMT_TYPE 按产生应收的来源分类，包括01 电费 02免费电费 11 债务 21 佣金 31 费率费用 32免费费率费用 41 业务费
		NULL, -- OWE_AMT 销账前实收金额
		flow.org_id, -- ORG_ID 用户所属单位
		flow.tv, -- 分区字段
		flow.orderid -- orderid 临时存储
	FROM vd_a_pay_flow_2015 flow
	LEFT JOIN tmp_sdjl_2015 sdjl ON flow.orderid = sdjl.ORDERSID
	LEFT JOIN vd_a_rcvbl_flow_2015 rcvblflow ON flow.orderid = rcvblflow.orderid AND flow.charge_remark = 'migrate normal' AND rcvblflow.RCVBL_AMT > 0 -- 理应能查到唯一的一笔【非撤单】应收
	WHERE flow.charge_remark = 'migrate reversal' AND sdjl.ISFREE= 1 AND sdjl.OCD_MONEY > 0 -- 【撤单4】-FBE{-OCD_MONEY}

	UNION ALL

    SELECT
		2, AMI_GET_SEQUENCE('SEQ_VD_A_RCVED_FLOW'), -- RCVED_AMT_ID PK
		flow.charge_id, -- CHARGE_ID
        rcvblflow.RCVBL_AMT_ID, -- RCVBL_AMT_ID 应收表的主键 共用【非撤单】那笔的应收
        flow.obj_no, -- CONS_NO 用户编号
        flow.meter_id, -- METER_ID 表计标识
        flow.meter_no, -- ASSET_NO 表号
		DATE_FORMAT(flow.charge_date,'%Y%m%d'), -- RCVED_DATE 注意此处格式：20200122
		flow.charge_ym, -- RCVBL_YM
		ROUND(sdjl.OCD_MONEY, 2), -- THIS_RCVED_AMT 实收金额（FBE）
		NULL, -- THIS_PENALTY 实收违约金
		'02', -- AMT_TYPE 按产生应收的来源分类，包括01 电费 02免费电费 11 债务 21 佣金 31 费率费用 32免费费率费用 41 业务费
		NULL, -- OWE_AMT 销账前实收金额
		flow.org_id, -- ORG_ID 用户所属单位
		flow.tv, -- 分区字段
		flow.orderid -- orderid 临时存储
	FROM vd_a_pay_flow_2015 flow
	LEFT JOIN tmp_sdjl_2015 sdjl ON flow.orderid = sdjl.ORDERSID
	LEFT JOIN vd_a_rcvbl_flow_2015 rcvblflow ON flow.orderid = rcvblflow.orderid AND flow.charge_remark = 'migrate normal' AND rcvblflow.RCVBL_AMT < 0 -- 理应能查到唯一的一笔【非撤单】应收
	WHERE flow.charge_remark = 'migrate reversal' AND sdjl.ISFREE= 1 AND sdjl.OCD_MONEY > 0; -- 【撤单5】-FBE{+OCD_MONEY}


    IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;

    SELECT t_error, msg;

END
$$
delimiter ;
