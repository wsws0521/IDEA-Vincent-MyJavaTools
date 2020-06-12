DROP PROCEDURE IF EXISTS syn_zz_3_12;
delimiter $$
CREATE PROCEDURE syn_zz_3_12()(OUT `error_code` integer, OUT `error_msg` text)

BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

    # 1-插入 债务实收明细 10019 = 10018（债务应收） + 0（债务撤单）（还债记录里面可能找不到sdjl里面的ordersid，一个ordersid有可能对应多种债务，所以记录数可能比应收债务数多，也可能少）
    INSERT INTO vd_a_rcved_debt
        (`LESSEE_ID`, `RCVED_DEBT_ID`, `RCVBL_DEBT_ID`, `RCVED_AMT_ID`, `THIS_RCVED_AMT`, `REMARK`, `ORG_ID`, `TV`)
    SELECT
        2, AMI_GET_SEQUENCE('SEQ_VD_A_RCVED_DEBT'), -- RCVED_DEBT_ID PK
        rcvbldebt.RCVBL_DEBT_ID, -- RCVBL_DETAIL_ID 正常/撤单都是定位到了正常应收债务主键
        rcvedflow.RCVED_AMT_ID, -- RCVED_AMT_ID 实收主键
        rcvbldebt.RCVED_AMT, -- THIS_RCVED_AMT 此处只包含债务
        'migrate OCD_DEBT', -- REMARK
        rcvedflow.ORG_ID, -- ORG_ID
        rcvedflow.tv -- 分区字段
    FROM tmp_sdjl sdjl
    INNER JOIN vd_a_rcved_flow rcvedflow ON sdjl.ORDERSID = rcvedflow.orderid and rcvedflow.amt_type = '11' -- 可能确定不止一条rcvbldebt记录
    LEFT JOIN vd_a_rcvbl_debt rcvbldebt ON rcvedflow.RCVBL_AMT_ID = rcvbldebt.RCVBL_AMT_ID; -- 一个售电订单可能偿还2种债务，从而有两个应收债务


    SELECT t_error into error_code;
    SELECT msg into error_msg;
END
$$
delimiter ;
