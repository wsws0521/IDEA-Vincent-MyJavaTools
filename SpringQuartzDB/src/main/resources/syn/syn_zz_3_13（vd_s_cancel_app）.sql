DROP PROCEDURE IF EXISTS syn_zz_3_13;
delimiter $$
CREATE PROCEDURE syn_zz_3_13()(OUT `error_code` integer, OUT `error_msg` text)

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

    # 1-插入 异常处理申请 26
	INSERT INTO vd_s_cancel_app
		(`APP_ID`, `LESSEE_ID`, `PROPOSER`, `APP_DATE`, `APP_ORG_ID`, `APP_METHOD`, `APP_REASON`, `REMARK`, `RCVD_AMT_R`,
        `STATUS`, `NOTE_ID`, `NEW_NOTE_ID`, `CORRECT_NOTE_ID`)
	SELECT
		AMI_GET_SEQUENCE('SEQ_VD_S_CANCEL_APP'), -- APP_ID
		'2', -- LESSEE_ID
		uapuser.id, -- PROPOSER 申请人
		sdjl.cancelDate, -- APP_DATE 申请时间
		uapuser.org_id, -- APP_ORG_ID 申请部门-申请人所属管理单位
		'01', -- APP_METHOD 处理类型 01-撤销
		sdjl.cancelReason, -- APP_REASON 处理原因
		'migrate reversal application', -- REMARK
		NULL, -- RCVD_AMT_R 正确实收金额
		'40', -- STATUS 状态
		invnormal.NOTE_ID, -- NOTE_ID 申请票据标识 （正数那笔）
		NULL, -- NEW_NOTE_ID 纠正票据标识
		invreversal.NOTE_ID -- CORRECT_NOTE_ID 冲正票据标识 （负数那笔）
	FROM tmp_sdjl sdjl
    LEFT JOIN uap_user uapuser ON sdjl.canceler = uapuser.no
    LEFT JOIN vd_a_pay_flow flownormal ON sdjl.ORDERSID = flownormal.orderid AND flownormal.CHARGE_REMARK = 'migrate normal'
    LEFT JOIN vd_a_inv invnormal ON flownormal.charge_id = invnormal.chargeid
    LEFT JOIN vd_a_pay_flow flowreversal ON sdjl.ORDERSID = flowreversal.orderid AND flowreversal.CHARGE_REMARK = 'migrate reversal'
    LEFT JOIN vd_a_inv invreversal ON flowreversal.charge_id = invreversal.chargeid
    WHERE sdjl.DELFLAG = 1; -- 为了查询效率

    IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;

    SELECT t_error into error_code;
    SELECT msg into error_msg;

END
$$
delimiter ;
