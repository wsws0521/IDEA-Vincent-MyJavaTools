DROP PROCEDURE IF EXISTS mig_zz_3_12;
delimiter $$
CREATE PROCEDURE mig_zz_3_12()

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

    # 1-插入 债务实收明细
	INSERT INTO vd_a_rcved_debt_2015
		(`LESSEE_ID`, `RCVED_DEBT_ID`, `RCVBL_DEBT_ID`, `RCVED_AMT_ID`, `THIS_RCVED_AMT`, `REMARK`, `ORG_ID`, `TV`)
	SELECT
		2, AMI_GET_SEQUENCE('SEQ_VD_A_RCVED_DEBT'), -- RCVED_DEBT_ID PK
        rcvbldebt.RCVBL_DETAIL_ID, -- RCVBL_DETAIL_ID 正常/撤单都是定位到了正常应收/债务ID
        rcvedflow.RCVED_AMT_ID, -- RCVED_AMT_ID
        rcvbldebt.RCVED_AMT, -- THIS_RCVED_AMT 此处只包含债务
        'migrate OCD_DEBT', -- REMARK
        rcvedflow.ORG_ID, -- ORG_ID
        rcvedflow.tv -- 分区字段
	FROM vd_a_rcved_flow_2015 rcvedflow
	LEFT JOIN vd_a_rcvbl_debt_2015 rcvbldebt ON rcvedflow.RCVBL_AMT_ID = rcvbldebt.RCVBL_AMT_ID -- 一个售电订单可能偿还2种债务，从而有两个应收债务
	WHERE rcvedflow.AMT_TYPE = '11'; -- 可能确定不止一条rcvbldebt记录

    IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;

    SELECT t_error, msg;

END
$$
delimiter ;
