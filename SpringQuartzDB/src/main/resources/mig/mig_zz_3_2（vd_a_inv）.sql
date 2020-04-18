DROP PROCEDURE IF EXISTS mig_zz_3_2;
delimiter $$
CREATE PROCEDURE mig_zz_3_2()

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

    # 1-插入 票据
	INSERT INTO vd_a_inv_2015
		(`LESSEE_ID`, `NOTE_ID`, `VER_ID`, `NOTE_NO`, `NOTE_TYPE_CODE`, `NOTE_STATUS_CODE`,
		`STORE_DEPT_NO`, `KEEPER_NO`, `ORG_ID`, `TV`, CHARGEID)
	SELECT
		2, AMI_GET_SEQUENCE('SEQ_VD_A_INV'), -- NOTE_ID 票据标识PK
		0, -- VER_ID 票据版本标识FK
		NULL, -- NOTE_NO 票据号码 下面统一更新
        '02', -- NOTE_TYPE_CODE 票据类型
        IF(sdjl.DELFLAG=0 OR payflow.charge_remark='migrate reversal', '02', '04'), -- NOTE_STATUS_CODE 票据状态 正常订单/撤单对应的冲正订单=02正常 仅撤单当条=04撤单
        payflow.dept_id, -- STORE_DEPT_NO 保管部门=代理商所属单位
        payflow.charge_oper, -- KEEPER_NO 保管人员=操作员
        payflow.org_id, -- ORG_ID 供电单位
        payflow.tv, -- 手动插入TV字段，应用于分区（该值不应为空）
        payflow.charge_id -- 临时造的字段，用于关联查询
	FROM vd_a_pay_flow_2015 payflow -- 不管是收费还是冲正，都会有对应票据
	LEFT JOIN tmp_sdjl sdjl ON payflow.orderid = sdjl.ORDERSID;

	Update vd_a_inv_2015 set NOTE_NO = LPAD(NOTE_ID,16,'0') where NOTE_NO is null;

    IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;

    SELECT t_error, msg;

END
$$
delimiter ;
