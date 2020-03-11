
DROP PROCEDURE IF EXISTS mig_zz_2_2;
delimiter $$
CREATE PROCEDURE mig_zz_2_2()

BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

    IF NOT EXISTS(SELECT * FROM information_schema.statistics WHERE table_name='vd_a_daily_flow' AND index_name='INDEX_vd_a_daily_flow_dsno') THEN
        ALTER table vd_a_daily_flow ADD INDEX INDEX_vd_a_daily_flow_dsno(DS_NO);
    end if;

    # 开启事务
    START TRANSACTION;

    # ② 解款记录表-vd_a_tof_flow
    INSERT INTO `vd_a_tof_flow`
        (`LESSEE_ID`, `TOF_ID`, `TOF_NO`, `TOF_OPER`, `TOF_AMT`, `TOF_DATE`, `TOF_BANK_CODE`,
        `TOF_BANK_NO`, `CONFIRM_OPER`, `CONFIRM_DATE`, `ARRIVE_STATUS`, `ARRIVE_DATE`, `ARRIVE_NO`, `ORG_ID`, `RCV_ORG_NO`,
        BOOK_ID, DS_ID, tv)
    SELECT
        2, AMI_GET_SEQUENCE('SEQ_VD_A_TOF_FLOW'), -- 解款标识
        a.BANKINGNO, -- TOF_NO 解款编号，使用老的banking no，可能为空啊？
        d.id, -- TOF_OPER 解款人员（操作员）
        aa.CCL_CASH, -- TOF_AMT 解款金额
        aa.createDate, -- TOF_DATE 解款日期
        NULL, -- TOF_BANK_CODE 解款银行
        NULL, -- TOF_BANK_NO 银行账号
        d.id, -- CONFIRM_OPER 确认人员（操作员）
        a.ENDTIME, -- CONFIRM_DATE 确认日期
        CASE WHEN aa.CCL_EVIDENCE IS NULL THEN '01' ELSE '02' END, -- ARRIVE_STATUS 解款状态（01在途，02到账）
        DATE_FORMAT(aa.createDate, '%Y-%m-%d'), -- ARRIVE_DATE 银行到账日期
        NULL, -- ARRIVE_NO 银行存款回执
        d.org_id, -- ORG_ID 供电单位
        d.org_id, -- RCV_ORG_NO 收款单位
        NULL, -- BOOK_ID（等插入充值记录，再更新此字段）
        b.DS_ID, -- DS_ID
        IF(a.ENDTIME is null or a.ENDTIME = '', sysdate(), a.ENDTIME) -- 手动插入TV字段，应用于分区
    FROM tmp_dlsczjl aa
    LEFT JOIN tmp_rjd a ON aa.CCL_EVIDENCE = a.BANKINGNO
    LEFT JOIN vd_a_daily_flow b ON a.BANKINGNO = b.DS_NO
    LEFT JOIN uap_user d ON aa.operator = d.`no`;


    # ③ 将[vd_a_tof_flow.TOF_ID]更新至[vd_a_daily_flow.TOF_ID]（新版本删除该字段）
    -- UPDATE vd_a_daily_flow daliy INNER JOIN vd_a_tof_flow tof ON daliy.DS_NO = tof.TOF_NO
    -- SET daliy.TOF_ID = tof.TOF_ID;

    IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;

    SELECT t_error, msg;

END
$$
delimiter ;
