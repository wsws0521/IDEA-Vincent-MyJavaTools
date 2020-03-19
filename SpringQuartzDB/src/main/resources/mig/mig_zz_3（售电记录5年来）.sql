





未完待续




























# 代理商balanceDetail菜单》》点击查询：
# ① 先【VD_A_ACCT_BOOK】JOIN【vd_a_pay_flow(11、14、31、40类型)】4种summary
# ② 再查【VD_A_ACCT_BOOK】JOIN【vd_a_pay_flow(类型不限)】LEFT JOIN【VD_POS_AGENT】LEFT JOIN【VD_POS_ASSETS】LEFT JOIN【VD_A_TOF_FLOW】LEFT JOIN【VD_A_DAILY_FLOW】
-----------------------------------------------------存储过程--------------------------------------------------------
IF NOT EXISTS(SELECT * FROM information_schema.statistics WHERE table_name='uap_user' AND index_name='INDEX_uap_user_no') THEN
    ALTER table uap_user ADD INDEX INDEX_uap_user_no(no);
end if;

# ① 收费明细
INSERT INTO vd_a_pay_flow
    (lessee_id, charge_id, ds_id, obj_type, obj_id, obj_no, meter_id, meter_no,
    charge_ym, charge_date, acct_ym, type_code, rcv_amt, change_amt, rcvd_amt,
    charge_oper, settle_mode, settle_note_no, settle_bank_code, dept_id, rcv_org_id,
    charge_remark, relate_id, src, org_id, pay_bank_acc, rcv_bank, rcv_bank_acc, channel, tv)
SELECT
    2, AMI_GET_SEQUENCE('SEQ_VD_A_PAY_FLOW'), c.DS_ID, -- 日结标识
    '03', -- 对象类型:01客户、02用户03代理商04加密盒03表计厂商
    b.AGENT_ID, b.AGENT_NO, NULL, NULL, -- 用户、表计信息
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
    a.CCL_EVIDENCE, -- charge_remark 备注（暂时存放bankingno）
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

# ② 导入-账本表-VD_A_ACCT_BOOK
INSERT INTO vd_a_acct_book
    (`LESSEE_ID`, `BOOK_ID`, `ACCT_ID`, `CHARGE_ID`, `BOOK_NAME`, `BOOK_SUBJECT`,
    `SUBJECT_AMT`, `BOOK_TIME`, `BOOK_DESC`, `SETTLEDATE`, tv)
SELECT
    2, AMI_GET_SEQUENCE('seq_vd_a_acct_book'), -- 账本ID
    c.ACCT_ID, -- 账户标识
    d.charge_id, -- 收费标识
    NULL, -- 账本名称
    '11', -- 账本科目 01账户支出02账户存入11代理商充值12代理商调账13代理商收费21单位充值22单位调账23单位收费
    a.CCL_CASH, -- 对应科目的金额
    a.createDate, -- 账本时间记录的时间
    'migratedata', -- 账本说明
    a.createDate, -- 解款日期
    a.createDate -- 手动插入TV字段，应用于分区
FROM tmp_dlsczjl a
LEFT JOIN vd_agt_agent b ON a.TE_NAME = b.AGENT_NAME
LEFT JOIN VD_A_ACCOUNT c ON b.AGENT_NO = c.ACCT_NO
LEFT JOIN vd_a_pay_flow d ON a.CCL_EVIDENCE = d.charge_remark;

# ③ 将[VD_A_ACCT_BOOK.BOOK_ID]更新至[vd_a_tof_flow.BOOK_ID]
UPDATE vd_a_tof_flow tof INNER JOIN (
    select a.ds_id, b.BOOK_ID from vd_a_pay_flow a, vd_a_acct_book b
    where a.charge_id = b.CHARGE_ID
)tmp ON tof.DS_ID = tmp.ds_id
SET tof.BOOK_ID = tmp.BOOK_ID;

# 删除索引
ALTER table uap_user DROP INDEX INDEX_uap_user_no;
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

------------------------------------sqlserver数据源获取-------------------------------------------

select  cc.CDUCLOGID as ID, -- 主键
        ltrim(rtrim(c.TE_NAME)) TE_NAME, -- 代理商名称
        cc.CCL_EVIDENCE, -- 日结单编号/bankingno，是一个描述字段，有可能找不到日结单记录
        cc.CCL_CASH, -- 充值金额，有可能为负数，和正数处理方式一致
        convert(varchar(19),cc.NEWDATE,120) as createDate, -- 充值时间
        u.USER_ACCOUNT as operator -- Administrator和admin是超级管理员,这2个用户没有迁移，直接使用8.0里的管理员就行
from IPARA_CDUSTATION_CREDITLOG cc
inner join IPARA_CDUSTATION c on cc.TERRITORYID=c.TERRITORYID
left join IAUDIT_USER u on cc.NEWOPERATOR=u.USER_ID
order by cc.NEWDATE

-------------------------------------tmp_hzjl  自动建表语句-----------------------------------------

CREATE TABLE `tmp_dlsczjl` (
  `ID` varchar(128) NOT NULL,
  `TE_NAME` varchar(128) DEFAULT NULL,
  `CCL_EVIDENCE` varchar(128) DEFAULT NULL,
  `CCL_CASH` varchar(128) DEFAULT NULL,
  `createDate` varchar(128) DEFAULT NULL,
  `operator` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;