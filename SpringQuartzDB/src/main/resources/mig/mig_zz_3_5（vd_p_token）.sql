DROP PROCEDURE IF EXISTS mig_zz_3_5;
delimiter $$
CREATE PROCEDURE mig_zz_3_5()

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

    # 1-插入 Token表
	INSERT INTO vd_p_token_2015
		(`LESSEE_ID`, `TOKEN_ID`, `KEY_CHG_ID`, `LOGOFFCHANGE_ID`, `BUSINESS_TYPE`, `APP_ID`,
		`ACCOUNT_NO`, `ACCOUNT_ID`, `METER_ID`, `METER_NO`, `TOKEN_TYPE`, `TOKEN`, `RTN_TOKEN`,
		`SORT`, `EXECUTE_STATUS`, `RECHARGE_AMOUNT`, `TOKEN_AMOUNT`, `CREATE_TIME`, `ORG_ID`,
		`TOKEN_DATEIL_ID`, `STS_VERSION_ID`, `TI`, `SEQ`, `KEYNO`, `TID`, `CARD_WF`, `TV`, `VER_ID`, `BARL`)
	SELECT
		2,
		AMI_GET_SEQUENCE('SEQ_VD_P_TOKEN'), -- PK
		NULL, -- KEY_CHG_ID 换秘钥，一年7条，不属于销售订单不知道为何检索出来++++++++++++++++++++++++++++++++++++++++++++++
		NULL, -- LOGOFFCHANGE_ID 注销/换表标识
		CASE sdjl.DELFLAG=1 THEN '06' ELSE '00' END, -- BUSINESS_TYPE 业务类型
		flow.charge_id, -- APP_ID 申请标识/收费标识
		flow.obj_no, -- ACCOUNT_NO 用户编号
		flow.obj_id, -- ACCOUNT_ID 用户标识
		flow.meter_id, -- METER_ID
		flow.meter_no, -- METER_NO
		'0203', -- TOKEN_TYPE
		CONCAT(sdjl.KEYTOKEN1, ',', sdjl.KEYTOKEN2), -- TOKEN 改秘钥
		NULL, -- RTN_TOKEN 注销返回码
		1, -- SORT 排序码
		IF(sdjl.DELFLAG=1, '01', '02'), -- EXECUTE_STATUS 执行状态 01-未知 02-执行成功
		ROUND(sdjl.OCD_ENERGY, 2), -- RECHARGE_AMOUNT 一次侧充值量
		ROUND(sdjl.OCD_ENERGY, 2), -- TOKEN_AMOUNT 二次侧充值量
		sdjl.OD_DATE, -- CREATE_TIME 生成时间
		flow.org_id, -- ORG_ID 供电单位 用户所属单位
		NULL, -- TOKEN_DATEIL_ID TOKEN方案明细标识
		NULL, -- STS_VERSION_ID 密钥版本标识 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		sdjl.TI, -- TI
		NULL, -- SEQ
		NULL, -- KEYNO
		NULL, -- TID
		NULL, -- CARD_WF 写卡标识
		sdjl.OD_DATE, -- TV  分区字段
		NULL, -- VER_ID 费率版本ID
		NULL -- BARL
	FROM vd_a_pay_flow_2015 flow
	LEFT JOIN tmp_sdjl_2015 sdjl ON flow.orderid = sdjl.ORDERSID
	WHERE flow.charge_remark = 'migrate normal' and sdjl.KEYTOKEN1 <> '00' -- 冲正记录没必要再插一遍对应Token，有改秘钥则先插入

    UNION ALL

	SELECT
		2,
		AMI_GET_SEQUENCE('SEQ_VD_P_TOKEN'), -- PK
		NULL, -- KEY_CHG_ID 换秘钥，一年7条，不属于销售订单不知道为何检索出来++++++++++++++++++++++++++++++++++++++++++++++
		NULL, -- LOGOFFCHANGE_ID 注销/换表标识
		CASE sdjl.DELFLAG=1 THEN '06' ELSE '00' END, -- BUSINESS_TYPE 业务类型
		flow.charge_id, -- APP_ID 申请标识/收费标识
		flow.obj_no, -- ACCOUNT_NO 用户编号
		flow.obj_id, -- ACCOUNT_ID 用户标识
		flow.meter_id, -- METER_ID
		flow.meter_no, -- METER_NO
		CASE WHEN sdjl.ISFREE=1 THEN '0103' ELSE '0101' END, -- TOKEN_TYPE
		sdjl.OCD_TOKEN, -- TOKEN
		NULL, -- RTN_TOKEN 注销返回码
		IF(sdjl.KEYTOKEN1='00', 1, 2), -- SORT 排序码
		IF(sdjl.DELFLAG=1, '01', '02'), -- EXECUTE_STATUS 执行状态 01-未知 02-执行成功
		ROUND(sdjl.OCD_ENERGY, 2), -- RECHARGE_AMOUNT 一次侧充值量
		ROUND(sdjl.OCD_ENERGY, 2), -- TOKEN_AMOUNT 二次侧充值量
		sdjl.OD_DATE, -- CREATE_TIME 生成时间
		flow.org_id, -- ORG_ID 供电单位 用户所属单位
		NULL, -- TOKEN_DATEIL_ID TOKEN方案明细标识
		NULL, -- STS_VERSION_ID 密钥版本标识 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
		sdjl.TI, -- TI
		NULL, -- SEQ
		NULL, -- KEYNO
		NULL, -- TID
		NULL, -- CARD_WF 写卡标识
		sdjl.OD_DATE, -- TV  分区字段
		NULL, -- VER_ID 费率版本ID
		NULL -- BARL
	FROM vd_a_pay_flow_2015 flow
	LEFT JOIN tmp_sdjl sdjl ON flow.orderid = sdjl.ORDERSID
	WHERE flow.charge_remark = 'migrate normal'; -- 冲正记录没必要再插一遍对应Token

    IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;

    SELECT t_error, msg;

END
$$
delimiter ;
