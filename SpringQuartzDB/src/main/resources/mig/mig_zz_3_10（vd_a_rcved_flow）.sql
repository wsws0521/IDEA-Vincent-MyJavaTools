DROP PROCEDURE IF EXISTS mig_zz_3_10;
delimiter $$
CREATE PROCEDURE mig_zz_3_10()

BEGIN
    DECLARE start_year int default 2016;    /* ++++++根据执行库的年份修改，脚本必须在指定库上执行++++++ */
    DECLARE db_name VARCHAR(16);
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	DECLARE start_line int default 0;
	DECLARE offset int default 50000; -- 一次最多插35W，否则就报3100，所以只能分页插，20W耗时59s  分4个库同时差20/4
	DECLARE total int default 0;
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

    # 删除被插表索引
    SET db_name = (select CONCAT('centlec', start_year));
	IF EXISTS(SELECT * FROM information_schema.statistics WHERE TABLE_SCHEMA = db_name AND table_name='vd_a_rcved_flow' AND index_name='IDX_RCVED_FLOW_CHARGE_ID') THEN
		ALTER table vd_a_rcved_flow DROP INDEX IDX_RCVED_FLOW_CHARGE_ID;
	END IF;
	IF EXISTS(SELECT * FROM information_schema.statistics WHERE TABLE_SCHEMA = db_name AND table_name='vd_a_rcved_flow' AND index_name='IDX_RCVED_FLOW_AMTTYPE') THEN
		ALTER table vd_a_rcved_flow DROP INDEX IDX_RCVED_FLOW_AMTTYPE;
	END IF;

    # 一条【正常收费】记录可能分为：{电价电费应收}+{计费项应收}+{债务应收}，一条【FBE收费】记录必须分为{+OCD_MONEY}和{-OCD_MONEY}两条应收。
    # 【撤单冲正】在此体现，即再额外生成符号相反的冲正记录

    # 1-插入 实收 3h12min 24596265 （2019-5h）
    set total = (select count(RCVBL_AMT_ID) from vd_a_rcvbl_flow);
    while start_line < total do
	    -- 【非撤单】-完全拷贝应收 24596213
        SET @strsql = CONCAT('INSERT INTO vd_a_rcved_flow
                (`LESSEE_ID`, `RCVED_AMT_ID`, `CHARGE_ID`, `RCVBL_AMT_ID`, `CONS_NO`, `METER_ID`, `ASSET_NO`, `RCVED_DATE`, `RCVBL_YM`,
                `THIS_RCVED_AMT`, `THIS_PENALTY`, `AMT_TYPE`, `OWE_AMT`, `ORG_ID`, `TV`)
            SELECT
                2, AMI_GET_SEQUENCE(''SEQ_VD_A_RCVED_FLOW''), -- RCVED_AMT_ID PK
                flow.charge_id, -- CHARGE_ID
                rcvblflow.RCVBL_AMT_ID, -- RCVBL_AMT_ID 应收表的主键
                rcvblflow.OBJ_NO, -- CONS_NO 用户编号
                rcvblflow.METER_ID, -- METER_ID 表计标识
                rcvblflow.METER_NO, -- ASSET_NO 表号
                DATE_FORMAT(flow.charge_date,''%Y%m%d''), -- RCVED_DATE 注意此处格式：20200122
                rcvblflow.RCVBL_YM, -- RCVBL_YM
                rcvblflow.RCVED_AMT, -- THIS_RCVED_AMT 实收金额（电价电费/计费项/债务）
                NULL, -- THIS_PENALTY 实收违约金
                rcvblflow.AMT_TYPE, -- AMT_TYPE 按产生应收的来源分类，包括01 电费 02免费电费 11 债务 21 佣金 31 费率费用 32免费费率费用 41 业务费
                NULL, -- OWE_AMT 销账前实收金额
                rcvblflow.ORG_ID, -- ORG_ID 用户所属单位
                rcvblflow.tv -- 分区字段
            FROM vd_a_rcvbl_flow rcvblflow INNER JOIN (select RCVBL_AMT_ID from vd_a_rcvbl_flow limit ', start_line, ',', offset, ') tmprcvblflow ON rcvblflow.RCVBL_AMT_ID = tmprcvblflow.RCVBL_AMT_ID
            LEFT JOIN vd_a_pay_flow flow ON rcvblflow.orderid = flow.orderid AND flow.charge_remark = ''migrate normal'';');
        PREPARE stmt FROM @strsql;
        EXECUTE stmt;
        DEALLOCATE PREPARE stmt; -- 释放
        -- 翻页
        set start_line = start_line + offset;
    end while;

    -- 【撤单1】-电价电费 26
    INSERT INTO vd_a_rcved_flow
        (`LESSEE_ID`, `RCVED_AMT_ID`, `CHARGE_ID`, `RCVBL_AMT_ID`, `CONS_NO`, `METER_ID`, `ASSET_NO`, `RCVED_DATE`, `RCVBL_YM`,
        `THIS_RCVED_AMT`, `THIS_PENALTY`, `AMT_TYPE`, `OWE_AMT`, `ORG_ID`, `TV`)
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
        flow.tv -- 分区字段
    FROM vd_a_pay_flow flow
    LEFT JOIN tmp_sdjl sdjl ON flow.orderid = sdjl.ORDERSID
    LEFT JOIN vd_a_rcvbl_flow rcvblflow ON flow.orderid = rcvblflow.orderid AND rcvblflow.AMT_TYPE = '01' -- 理应能查到唯一的一笔【电费】应收
    WHERE flow.charge_remark = 'migrate reversal' AND sdjl.ISFREE= 0 AND sdjl.OCD_MONEY > 0;
    -- 【撤单2】-计费项 26
    INSERT INTO vd_a_rcved_flow
		(`LESSEE_ID`, `RCVED_AMT_ID`, `CHARGE_ID`, `RCVBL_AMT_ID`, `CONS_NO`, `METER_ID`, `ASSET_NO`, `RCVED_DATE`, `RCVBL_YM`,
        `THIS_RCVED_AMT`, `THIS_PENALTY`, `AMT_TYPE`, `OWE_AMT`, `ORG_ID`, `TV`)
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
		flow.tv -- 分区字段
	FROM vd_a_pay_flow flow
	LEFT JOIN tmp_sdjl sdjl ON flow.orderid = sdjl.ORDERSID
	LEFT JOIN vd_a_rcvbl_flow rcvblflow ON flow.orderid = rcvblflow.orderid AND rcvblflow.AMT_TYPE = '31' -- 理应能查到唯一的一笔【计费项】应收
	WHERE flow.charge_remark = 'migrate reversal' AND sdjl.ISFREE= 0 AND sdjl.FP_VAL3 > 0;
    -- 【撤单3】-债务 0
    INSERT INTO vd_a_rcved_flow
		(`LESSEE_ID`, `RCVED_AMT_ID`, `CHARGE_ID`, `RCVBL_AMT_ID`, `CONS_NO`, `METER_ID`, `ASSET_NO`, `RCVED_DATE`, `RCVBL_YM`,
        `THIS_RCVED_AMT`, `THIS_PENALTY`, `AMT_TYPE`, `OWE_AMT`, `ORG_ID`, `TV`)
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
		flow.tv -- 分区字段
	FROM vd_a_pay_flow flow
	LEFT JOIN tmp_sdjl sdjl ON flow.orderid = sdjl.ORDERSID
	LEFT JOIN vd_a_rcvbl_flow rcvblflow ON flow.orderid = rcvblflow.orderid AND rcvblflow.AMT_TYPE = '11' -- 理应能查到唯一的一笔【债务】应收
	WHERE flow.charge_remark = 'migrate reversal' AND sdjl.ISFREE= 0 AND sdjl.OCD_DEBT > 0;
    -- 【撤单4】-FBE{-OCD_MONEY} 0
    INSERT INTO vd_a_rcved_flow
		(`LESSEE_ID`, `RCVED_AMT_ID`, `CHARGE_ID`, `RCVBL_AMT_ID`, `CONS_NO`, `METER_ID`, `ASSET_NO`, `RCVED_DATE`, `RCVBL_YM`,
        `THIS_RCVED_AMT`, `THIS_PENALTY`, `AMT_TYPE`, `OWE_AMT`, `ORG_ID`, `TV`)
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
		flow.tv -- 分区字段
	FROM vd_a_pay_flow flow
	LEFT JOIN tmp_sdjl sdjl ON flow.orderid = sdjl.ORDERSID
	LEFT JOIN vd_a_rcvbl_flow rcvblflow ON flow.orderid = rcvblflow.orderid AND rcvblflow.AMT_TYPE = '02' AND rcvblflow.RCVBL_AMT > 0 -- 理应能查到唯一的一笔【非撤单】应收
	WHERE flow.charge_remark = 'migrate reversal' AND sdjl.ISFREE= 1 AND sdjl.OCD_MONEY > 0;
    -- 【撤单5】-FBE{+OCD_MONEY} 0
	INSERT INTO vd_a_rcved_flow
		(`LESSEE_ID`, `RCVED_AMT_ID`, `CHARGE_ID`, `RCVBL_AMT_ID`, `CONS_NO`, `METER_ID`, `ASSET_NO`, `RCVED_DATE`, `RCVBL_YM`,
        `THIS_RCVED_AMT`, `THIS_PENALTY`, `AMT_TYPE`, `OWE_AMT`, `ORG_ID`, `TV`)
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
		flow.tv -- 分区字段
	FROM vd_a_pay_flow flow
	LEFT JOIN tmp_sdjl sdjl ON flow.orderid = sdjl.ORDERSID
	LEFT JOIN vd_a_rcvbl_flow rcvblflow ON flow.orderid = rcvblflow.orderid AND rcvblflow.AMT_TYPE = '02' AND rcvblflow.RCVBL_AMT < 0 -- 理应能查到唯一的一笔【非撤单】应收
	WHERE flow.charge_remark = 'migrate reversal' AND sdjl.ISFREE= 1 AND sdjl.OCD_MONEY > 0;

    # 重建索引
    ALTER table vd_a_rcved_flow ADD INDEX IDX_RCVED_FLOW_CHARGE_ID(CHARGE_ID);
    ALTER table vd_a_rcved_flow ADD INDEX IDX_RCVED_FLOW_AMTTYPE(AMT_TYPE); -- 147s 为了插实收小弟

    SELECT t_error, msg;
END
$$
delimiter ;

CALL mig_zz_3_10();
