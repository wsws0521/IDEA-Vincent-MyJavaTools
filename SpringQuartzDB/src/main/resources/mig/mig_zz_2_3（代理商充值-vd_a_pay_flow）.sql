# 代理商balanceDetail菜单》》点击查询：
# ① 先【VD_A_ACCT_BOOK】JOIN【vd_a_pay_flow(11、14、31、40类型)】4种summary
# ② 再查【VD_A_ACCT_BOOK】JOIN【vd_a_pay_flow(类型不限)】LEFT JOIN【VD_POS_AGENT】LEFT JOIN【VD_POS_ASSETS】LEFT JOIN【VD_A_TOF_FLOW】LEFT JOIN【VD_A_DAILY_FLOW】
-----------------------------------------------------存储过程--------------------------------------------------------
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
    IF NOT EXISTS(SELECT * FROM information_schema.statistics WHERE table_name='vd_agt_agent' AND index_name='INDEX_vd_agt_agent_agentname') THEN
        ALTER table vd_agt_agent ADD INDEX INDEX_vd_agt_agent_agentname(AGENT_NAME);
    end if;

    # 开启事务
    START TRANSACTION;

    # ① 收费明细
    INSERT INTO vd_a_pay_flow
        (lessee_id, charge_id, ds_id, obj_type, obj_id, obj_no, meter_id, meter_no,
        charge_ym, charge_date, acct_ym, type_code, rcv_amt, change_amt, rcvd_amt,
        charge_oper, settle_mode, settle_note_no, settle_bank_code, dept_id, rcv_org_id,
        charge_remark, relate_id, src, org_id, pay_bank_acc, rcv_bank, rcv_bank_acc, channel, tv)
    SELECT
        2, AMI_GET_SEQUENCE('SEQ_VD_A_PAY_FLOW'),
        c.DS_ID, -- ds_id 日结标识
        '03', -- obj_type 对象类型:01客户、02用户03代理商04加密盒03表计厂商
        b.AGENT_ID, -- obj_id
        b.AGENT_NO, -- obj_no
        NULL, NULL, -- 表计信息
        DATE_FORMAT(a.createDate,'%Y%m'), a.createDate,  -- 收费年月、收费日期
        DATE_FORMAT(a.createDate,'%Y%m'), -- 记账年月
        '14', -- 收费类型：10还债收费11收电费(代理商销售金额)12收业务费14(代理商充值金额)31(佣金结转)40(调账)
        ROUND(a.CCL_CASH, 2), -- 收费金额
        0.00, -- 找零金额
        ROUND(a.CCL_CASH, 2), -- 实收金额
        d.id, -- 收此费用的操作员ID
        '03', -- 结算方式：PCODE'rechargeMethod'下：01支票02转账03现金（BOOK_SUBJECT是13、23收费时取'rechargeMethod'写死03，TYPE_CODE是10、11时取'settleType'，其他情况取'rechargeMethod'的PCODE）
        NULL, NULL, -- 转账账号、银行
        b.org_id, b.org_id, -- dept_id rcv_org_id 收款部门、单位
        a.ID, -- charge_remark 备注（暂时存放tmp_dlsczjl.ID。不存放bankingno因为并非唯一，后面插账本会出现重复*重复的情况）
        NULL, -- relate_id 关联标识
        '02', -- src 源：02Vending
        b.org_id, -- org_id 供电单位
        NULL, -- pay_bank_acc 付款账号
        NULL, -- rcv_bank 付款银行
        NULL, -- rcv_bank_acc 收款账号
        NULL, -- channel 渠道
        a.createDate -- 手动插入TV字段，应用于分区
    FROM tmp_dlsczjl a
    LEFT JOIN vd_agt_agent b ON a.TE_NAME = b.AGENT_NAME
    LEFT JOIN vd_a_daily_flow c ON a.CCL_EVIDENCE = c.DS_NO
    LEFT JOIN uap_user d ON a.operator = d.no;

    IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;

    # 删除索引
    ALTER table vd_agt_agent DROP INDEX INDEX_vd_agt_agent_agentname;

    SELECT t_error, msg;

END
$$
delimiter ;



------------------------------------<queryBalanceDetail>-------------------------------------------
/*SELECT 	CASE WHEN TYPE_CODE='10' AND BOOK_SUBJECT IN ('13','23') THEN AMI_WEB_GET_P_CODE_VALUE('11','agentChargeType', 'zh_CN')
					ELSE AMI_WEB_GET_P_CODE_VALUE(TYPE_CODE,'agentChargeType', 'zh_CN')
					END AS "type",
        DATE_FORMAT(BOOK_TIME,"%Y-%m-%d %H:%i:%s") AS "time",
        CAST(CASE WHEN BOOK_SUBJECT IN ('13','23') THEN -SUBJECT_AMT ELSE SUBJECT_AMT END
            AS CHAR) AS "amount",
        CASE WHEN BOOK_SUBJECT IN ('13','23') THEN AMI_WEB_GET_P_CODE_VALUE('03','rechargeMethod', 'zh_CN')
                    WHEN TYPE_CODE IN ('11','10') AND (BOOK_SUBJECT <> '13' OR BOOK_SUBJECT <> '23') THEN AMI_WEB_GET_P_CODE_VALUE(SETTLE_MODE,'settleType', 'zh_CN')
                    ELSE AMI_WEB_GET_P_CODE_VALUE(SETTLE_MODE,'rechargeMethod', 'zh_CN')
                    END AS "paymentMethod",
        CASE WHEN BOOK_SUBJECT = '13' THEN NULL ELSE SETTLE_NOTE_NO END AS "paymentNumber",
        CHARGE_REMARK AS "remark",
        (SELECT NAME FROM UAP_USER WHERE ID = CHARGE_OPER) AS "oprator",
        PAS.IMEI, PAS.POS_SCENE, B.CHARGE_ID, TYPE_CODE "agentChargeType"
FROM VD_A_ACCT_BOOK B JOIN vd_a_pay_flow P ON B.CHARGE_ID = P.CHARGE_ID AND B.LESSEE_ID = P.LESSEE_ID
LEFT JOIN VD_POS_AGENT PAG ON P.OBJ_ID = PAG.AGENT_ID AND P.LESSEE_ID = PAG.LESSEE_ID
LEFT JOIN vd_pos_assets PAS ON PAG.IMEI = PAS.IMEI AND PAG.LESSEE_ID = PAS.LESSEE_ID
WHERE B.LESSEE_ID = 2
			AND ACCT_ID = (SELECT ACCT_ID FROM vd_a_account AC, vd_agt_agent AG WHERE AC.ACCT_NO = AG.AGENT_NO AND AG.AGENT_NO = #{})
			AND BOOK_TIME BETWEEN #{} AND #{}
			AND TYPE_CODE IN #{};*/

