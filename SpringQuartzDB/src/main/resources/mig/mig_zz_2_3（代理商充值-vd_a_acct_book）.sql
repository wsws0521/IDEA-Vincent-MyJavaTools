
DROP PROCEDURE IF EXISTS mig_zz_2_3;
delimiter $$
CREATE PROCEDURE mig_zz_2_3()

BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

    # 添加索引
    IF NOT EXISTS(SELECT * FROM information_schema.statistics WHERE table_name='vd_a_pay_flow' AND index_name='INDEX_vd_a_pay_flow_remark') THEN
        ALTER table vd_a_pay_flow ADD INDEX INDEX_vd_a_pay_flow_remark(charge_remark);
    end if;
    IF NOT EXISTS(SELECT * FROM information_schema.statistics WHERE table_name='vd_agt_agent' AND index_name='INDEX_vd_agt_agent_agentname') THEN
        ALTER table vd_agt_agent ADD INDEX INDEX_vd_agt_agent_agentname(AGENT_NAME);
    end if;

    # 开启事务
    START TRANSACTION;

    # ② 导入-账本表-VD_A_ACCT_BOOK
    INSERT INTO vd_a_acct_book
        (`LESSEE_ID`, `BOOK_ID`, `ACCT_ID`, `CHARGE_ID`, `BOOK_NAME`, `BOOK_SUBJECT`,
        `SUBJECT_AMT`, `BOOK_TIME`, `BOOK_DESC`, tv)
    SELECT
        2, AMI_GET_SEQUENCE('seq_vd_a_acct_book'), -- 账本ID
        c.ACCT_ID, -- 账户标识
        d.charge_id, -- 收费标识
        NULL, -- 账本名称
        '11', -- 账本科目 01账户支出02账户存入11代理商充值12代理商调账13代理商收费21单位充值22单位调账23单位收费
        a.CCL_CASH, -- 对应科目的金额
        a.createDate, -- 账本时间记录的时间
        'migratedata', -- 账本说明
        -- a.createDate, -- 解款日期（新版本删除）
        a.createDate -- 手动插入TV字段，应用于分区
    FROM tmp_dlsczjl a
    INNER JOIN vd_a_pay_flow d ON a.ID = d.charge_remark -- 只插tmp_dlsczjl.CCL_EVIDENCE不为空的记录，与vd_a_pay_flow一一对应
    LEFT JOIN vd_agt_agent b ON a.TE_NAME = b.AGENT_NAME
    LEFT JOIN VD_A_ACCOUNT c ON b.AGENT_NO = c.ACCT_NO;

--     # ③ 将[VD_A_ACCT_BOOK.BOOK_ID]更新至[vd_a_tof_flow.BOOK_ID]
--     UPDATE vd_a_tof_flow tof
--     INNER JOIN (
--         select a.ds_id, b.BOOK_ID
--         from vd_a_pay_flow a, vd_a_acct_book b
--         where a.charge_id = b.CHARGE_ID -- 因为3、4只插tmp_dlsczjl.CCL_EVIDENCE不为空的记录，所以tmp结果字段不会出现为空的情况
--     )tmp ON tof.DS_ID = tmp.ds_id
--     SET tof.BOOK_ID = tmp.BOOK_ID;

    IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;

    # 删除索引
    ALTER table vd_a_pay_flow DROP INDEX INDEX_vd_a_pay_flow_remark;
    ALTER table vd_agt_agent DROP INDEX INDEX_vd_agt_agent_agentname;

    SELECT t_error, msg;

END
$$
delimiter ;
