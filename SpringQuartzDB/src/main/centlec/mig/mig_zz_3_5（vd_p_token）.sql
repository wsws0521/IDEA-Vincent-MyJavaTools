DROP PROCEDURE IF EXISTS mig_zz_3_5;
delimiter $$
CREATE PROCEDURE mig_zz_3_5()

BEGIN
    DECLARE start_year int default 2016;    /* ++++++根据执行库的年份修改，脚本必须在指定库上执行++++++ */
    DECLARE db_name VARCHAR(16);
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	DECLARE start_line int default 0;
	DECLARE offset int default 200000; -- 一次最多插35W，否则就报3100，所以只能分页插，20W耗时59s
	DECLARE total int default 14000000;
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

    # 删除被插表索引
    SET db_name = (select CONCAT('centlec', start_year));
	IF EXISTS(SELECT * FROM information_schema.statistics WHERE TABLE_SCHEMA = db_name AND table_name='vd_p_token' AND index_name='VD_TOKEN_APPID') THEN
		ALTER table vd_p_token DROP INDEX VD_TOKEN_APPID;
	END IF;

    # 1-循环插入 Token表 （2h）
    -- 先插0203 改秘钥Token（一年也就7条）
    INSERT INTO vd_p_token
        (`LESSEE_ID`, `TOKEN_ID`, `KEY_CHG_ID`, `LOGOFFCHANGE_ID`, `BUSINESS_TYPE`, `APP_ID`,
        `ACCOUNT_NO`, `ACCOUNT_ID`, `METER_ID`, `METER_NO`, `TOKEN_TYPE`, `TOKEN`, `RTN_TOKEN`,
        `SORT`, `EXECUTE_STATUS`, `RECHARGE_AMOUNT`, `TOKEN_AMOUNT`, `CREATE_TIME`, `ORG_ID`,
        `TOKEN_DATEIL_ID`, `STS_VERSION_ID`, `TI`, `SEQ`, `KEYNO`, `TID`, `CARD_WF`, `TV`, `VER_ID`, `BARL`)
    SELECT
        2,
        AMI_GET_SEQUENCE('SEQ_VD_P_TOKEN'), -- PK
        NULL, -- KEY_CHG_ID 换秘钥，一年7条，不属于销售订单不知道为何检索出来++++++++++++++++++++++++++++++++++++++++++++++
        NULL, -- LOGOFFCHANGE_ID 注销/换表标识
        CASE WHEN sdjl.DELFLAG=1 THEN '06' ELSE '00' END, -- BUSINESS_TYPE 业务类型
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
        NULL, -- RECHARGE_AMOUNT 一次侧充值量
        NULL, -- TOKEN_AMOUNT 二次侧充值量
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
    FROM tmp_sdjl sdjl
    LEFT JOIN vd_a_pay_flow flow ON sdjl.ORDERSID = flow.orderid AND flow.charge_remark = 'migrate normal' -- 确定唯一一条收费记录（LEFT冲正记录没必要再插一遍对应Token）
    WHERE sdjl.KEYTOKEN1 <> '00'; -- ，有改秘钥则先插入

    -- 再插0101 充值Token
    set total = (select count(ordersid) from tmp_sdjl);
	while start_line < total do
        SET @strsql = CONCAT('INSERT INTO vd_p_token
                                    (`LESSEE_ID`, `TOKEN_ID`, `KEY_CHG_ID`, `LOGOFFCHANGE_ID`, `BUSINESS_TYPE`, `APP_ID`,
                                    `ACCOUNT_NO`, `ACCOUNT_ID`, `METER_ID`, `METER_NO`, `TOKEN_TYPE`, `TOKEN`, `RTN_TOKEN`,
                                    `SORT`, `EXECUTE_STATUS`, `RECHARGE_AMOUNT`, `TOKEN_AMOUNT`, `CREATE_TIME`, `ORG_ID`,
                                    `TOKEN_DATEIL_ID`, `STS_VERSION_ID`, `TI`, `SEQ`, `KEYNO`, `TID`, `CARD_WF`, `TV`, `VER_ID`, `BARL`)
                                SELECT
                                    2,
                                    AMI_GET_SEQUENCE(''SEQ_VD_P_TOKEN''), -- PK
                                    NULL, -- KEY_CHG_ID 换秘钥，一年7条，不属于销售订单不知道为何检索出来++++++++++++++++++++++++++++++++++++++++++++++
                                    NULL, -- LOGOFFCHANGE_ID 注销/换表标识
                                    CASE WHEN sdjl.DELFLAG=1 THEN ''06'' ELSE ''00'' END, -- BUSINESS_TYPE 业务类型
                                    flow.charge_id, -- APP_ID 申请标识/收费标识
                                    flow.obj_no, -- ACCOUNT_NO 用户编号
                                    flow.obj_id, -- ACCOUNT_ID 用户标识
                                    flow.meter_id, -- METER_ID
                                    flow.meter_no, -- METER_NO
                                    CASE WHEN sdjl.ISFREE=1 THEN ''0103'' ELSE ''0101'' END, -- TOKEN_TYPE
                                    sdjl.OCD_TOKEN, -- TOKEN
                                    NULL, -- RTN_TOKEN 注销返回码
                                    IF(sdjl.KEYTOKEN1=''00'', 1, 2), -- SORT 排序码
                                    IF(sdjl.DELFLAG=1, ''01'', ''02''), -- EXECUTE_STATUS 执行状态 01-未知 02-执行成功
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
                                FROM tmp_sdjl sdjl
                                INNER JOIN (select ordersid from tmp_sdjl limit ', start_line, ',', offset, ') tmpsdjl ON sdjl.ordersid = tmpsdjl.ordersid
                                LEFT JOIN vd_a_pay_flow flow ON sdjl.ORDERSID = flow.orderid AND flow.charge_remark = ''migrate normal''; -- 冲正记录没必要再插一遍对应Token');
        PREPARE stmt FROM @strsql;
        EXECUTE stmt;
        DEALLOCATE PREPARE stmt; -- 释放
        -- 翻页
        set start_line = start_line + offset;
    end while;

    # 重建索引
    ALTER table vd_p_token ADD INDEX VD_TOKEN_APPID(APP_ID); -- 2min

    SELECT t_error, msg;
END
$$
delimiter ;


CALL mig_zz_3_5();