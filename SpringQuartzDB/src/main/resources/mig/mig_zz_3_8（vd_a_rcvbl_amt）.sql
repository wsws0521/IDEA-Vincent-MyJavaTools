DROP PROCEDURE IF EXISTS mig_zz_3_8;
delimiter $$
CREATE PROCEDURE mig_zz_3_8()

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

    # 1-插入 应收电费明细
	INSERT INTO vd_a_rcvbl_amt_2015
		(`LESSEE_ID`, `RCVBL_DETAIL_ID`, `RCVBL_AMT_ID`, `PRICE_ID`, `ENERGY`, `AMT`, `RCVED_AMT`, `ORG_ID`, `CALC_AMT_ID`, `TV`)
	SELECT
		2,
		AMI_GET_SEQUENCE('SEQ_VD_A_RCVBL_AMT'), -- RCVBL_DETAIL_ID
		rcvblflow.RCVBL_AMT_ID, -- RCVBL_AMT_ID 应收费用标识FK
		NULL, -- PRICE_ID 电价标识++++++++++++++++++++++++++++VD_E_CALC_AMT+++++++++++++++++++++++++++++++++++
		rcvblflow.RES_QUAN, -- ENERGY 电量
        rcvblflow.RCVED_AMT, -- AMT 资源量金额/电价电费
        rcvblflow.ORG_ID, -- ORG_ID 用户所在单位
        NULL, -- CALC_AMT_ID 电费计算明细标识+++++++++++++++++++VD_E_BILL_PKG_VER_DETAIL+++++++++++++++++++++++++++
        rcvblflow.tv -- TV 分区字段
	FROM vd_a_rcvbl_flow_2015 rcvblflow
	WHERE rcvblflow.AMT_TYPE IN ('01','02'); -- 包括01 电费 02免费电费

    IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;

    SELECT t_error, msg;

END
$$
delimiter ;
