DROP PROCEDURE IF EXISTS syn_zz_3_2;
delimiter $$
CREATE PROCEDURE syn_zz_3_2()(OUT `error_code` integer, OUT `error_msg` text)

BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

    # 1-插入 票据
    INSERT INTO vd_a_inv
        (`LESSEE_ID`, `NOTE_ID`, `VER_ID`, `NOTE_NO`, `NOTE_TYPE_CODE`, `NOTE_STATUS_CODE`,
        `STORE_DEPT_NO`, `KEEPER_NO`, `ORG_ID`, `TV`, CHARGEID)
    SELECT
        2, AMI_GET_SEQUENCE('SEQ_VD_A_INV'), -- NOTE_ID 票据标识PK
        0, -- VER_ID 票据版本标识FK
        NULL, -- NOTE_NO 票据号码 下面统一更新
        '02', -- NOTE_TYPE_CODE 票据类型
        IF(flow.charge_remark='migrate normal' AND sdjl.DELFLAG=1, '04', '02'), -- NOTE_STATUS_CODE 票据状态 正常订单/撤单对应的冲正订单=02正常 仅撤单当条=04撤单
        flow.dept_id, -- STORE_DEPT_NO 保管部门=代理商所属单位
        flow.charge_oper, -- KEEPER_NO 保管人员=操作员
        flow.org_id, -- ORG_ID 供电单位
        flow.tv, -- 手动插入TV字段，应用于分区（该值不应为空）
        flow.charge_id -- 临时造的字段，用于关联查询
    FROM tmp_sdjl sdjl
    INNER JOIN vd_a_pay_flow flow ON sdjl.ORDERSID = flow.orderid; -- 不管是收费还是冲正，都会有对应票据
    # 2-更新 NOTE_NO
    Update vd_a_inv set NOTE_NO = LPAD(NOTE_ID,16,'0') where NOTE_NO is null;

    # vd_a_inv.CHARGEID
    IF NOT EXISTS(SELECT * FROM information_schema.statistics WHERE table_name='vd_a_inv' AND index_name='index_vd_a_inv_chargeid') THEN
		ALTER table vd_a_inv ADD INDEX index_vd_a_inv_chargeid(CHARGEID); -- 71s 插异常申请表时需要用到
	END IF;

    SELECT t_error into error_code;
    SELECT msg into error_msg;
END
$$
delimiter ;
