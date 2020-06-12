DROP PROCEDURE IF EXISTS syn_zz_3_11;
delimiter $$
CREATE PROCEDURE syn_zz_3_11()(OUT `error_code` integer, OUT `error_msg` text)

BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

    # 1-插入 电费实收明细 1h22min 12527534 = 12058724（电价电费应收） + 234392*2（FBE应收*2） + 26（电价电费撤单） + 0 （FBE撤单）
    INSERT INTO vd_a_rcved_amt
        (`LESSEE_ID`, `RCVED_DETAIL_ID`, `RCVED_AMT_ID`, `RCVBL_DETAIL_ID`, `ORG_ID`, `REMARK`, `THIS_RCVED_AMT`, `TV`)
    SELECT
        2, AMI_GET_SEQUENCE('SEQ_VD_A_RCVED_AMT'), -- RCVED_DETAIL_ID PK
        rcvedflow.RCVED_AMT_ID, -- RCVED_AMT_ID
        rcvblamt.RCVBL_DETAIL_ID, -- RCVBL_DETAIL_ID 正常/撤单都是定位到了正常应收/明细ID
        rcvedflow.ORG_ID, -- ORG_ID
        'migrate OCD_MONEY', -- REMARK
        rcvedflow.THIS_RCVED_AMT, -- THIS_RCVED_AMT 此处只包含电价电费
        rcvedflow.tv -- 分区字段
    FROM tmp_sdjl sdjl
    INNER JOIN vd_a_rcved_flow rcvedflow ON sdjl.ORDERSID = rcvedflow.orderid and rcvedflow.amt_type IN ('01','02')
    LEFT JOIN vd_a_rcvbl_amt rcvblamt ON rcvedflow.RCVBL_AMT_ID = rcvblamt.RCVBL_AMT_ID; -- -- 包括01 电费 02免费电费，包括撤单，理应可以确定唯一的rcvblamt记录


    SELECT t_error into error_code;
    SELECT msg into error_msg;
END
$$
delimiter ;

