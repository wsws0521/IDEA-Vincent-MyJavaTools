DROP PROCEDURE IF EXISTS mig_zz_3_11;
delimiter $$
CREATE PROCEDURE mig_zz_3_11()

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

    # 1-插入 电费实收明细
	INSERT INTO vd_a_rcved_amt_2015
		(`LESSEE_ID`, `RCVED_DETAIL_ID`, `RCVED_AMT_ID`, `RCVBL_DETAIL_ID`, `ORG_ID`, `REMARK`, `THIS_RCVED_AMT`, `TV`)
	SELECT
		2, AMI_GET_SEQUENCE('SEQ_VD_A_RCVED_AMT'), -- RCVED_DETAIL_ID PK
		rcvedflow.RCVED_AMT_ID, -- RCVED_AMT_ID
        rcvblamt.RCVBL_DETAIL_ID, -- RCVBL_DETAIL_ID 撤单是找不到该ID的吧？+++++++++++++++++++++++++++++++++++++++++++++++
        rcvedflow.ORG_ID, -- ORG_ID
        'migrate OCD_MONEY', -- REMARK
        rcvedflow.THIS_RCVED_AMT, -- THIS_RCVED_AMT 此处只包含电价电费
        rcvedflow.tv -- 分区字段
	FROM vd_a_rcved_flow_2015 rcvedflow
	LEFT JOIN vd_a_rcvbl_amt_2015 rcvblamt ON rcvedflow.RCVBL_AMT_ID = rcvblamt.RCVBL_AMT_ID
	WHERE rcvedflow.AMT_TYPE = '01'; -- 理应可以确定唯一的rcvblamt记录

    IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;

    SELECT t_error, msg;

END
$$
delimiter ;
