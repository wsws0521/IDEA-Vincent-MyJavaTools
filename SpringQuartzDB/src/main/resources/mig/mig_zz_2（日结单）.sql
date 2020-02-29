------------------------------------------------存储过程-------------------------------------------------
IF NOT EXISTS(SELECT * FROM information_schema.statistics WHERE table_name='uap_user' AND index_name='INDEX_uap_user_no') THEN
    ALTER table uap_user ADD INDEX INDEX_uap_user_no(no);
end if;
IF NOT EXISTS(SELECT * FROM information_schema.statistics WHERE table_name='tmp_dlsczjl' AND index_name='INDEX_tmp_dlsczjl_bankingno') THEN
    ALTER table tmp_dlsczjl ADD INDEX INDEX_tmp_dlsczjl_bankingno(CCL_EVIDENCE);
end if;

# ① 导入-日结记录表-vd_a_daily_flow
INSERT INTO `vd_a_daily_flow`
    (`LESSEE_ID`, `DS_ID`, `TOF_ID`, `DS_NO`, `DS_OBJ`, `DS_OPER`, `CHARGE_MODE`, `DS_AMT`, `DS_DATE`, `NOTE_NO`,
    `BANK_CODE`, `DS_STATUS`, `CONFIRM_OPER`, `CONFIRM_DATE`, `ORG_ID`, `DS_START_DATE`, `DS_END_DATE`,
    `DS_COUNT`, `ENG_TOT`, `ENG_AMT_TOT`, `ITEM_AMT_TOT`, `DEBT_AMT_TOT`, `SF_AMT_TOT`, `ORD_AMT_TOT`, `FREE_ENG_TOT`,
    `FREE_ENG_AMT_TOT`, `ENG_CL_TOT`, `ENG_AMT_CL_TOT`, `ITEM_AMT_CL_TOT`, `DEBT_AMT_CL_TOT`, `SF_AMT_CL_TOT`,
    `ORD_AMT_CL_TOT`, `DS_COUNT_FREE`, `DA_COUNT_CL`, `AGENT_ID`, tv)
SELECT
    2, AMI_GET_SEQUENCE('SEQ_VD_A_DAILY_FLOW'),
    NULL, -- TOF_ID（等后面更新）
    a.BANKINGNO, -- DS_NO日结编号，迁移数据用老banking编号
    IF(b.agent_type='01','02','01'), -- DS_OBJ 日结对象 01直营代理商的操作员/未绑代理商的操作员 02第三方代理商的操作员
    b.agent_id, -- DS_OPER 日结对象标识 操作员ID/代理商ID
    '01', -- CHARGE_MODE 收费方式 01现金
    a.TOTAL_AMOUNT, -- DS_AMT 日结金额
    a.ENDTIME, -- DS_DATE 日结datetime
    NULL, -- NOTE_NO 单据号码
    NULL, -- BANK_CODE 银行代码
    '02', -- DS_STATUS 日结状态：01在途02到账
    c.id, -- CONFIRM_OPER 日结确认人员（操作员）
    a.ENDTIME, -- CONFIRM_DATE 日结确认的具体datetime
    b.org_id, -- ORG_ID 供电单位
    a.STARTTIME, -- DS_START_DATE 日结开始datetime
    a.ENDTIME, -- DS_END_DATE 日结结束datetime
    a.Transaction_Count, -- DS_COUNT 日结订单笔数
    a.UNITS, -- ENG_TOT 日结资源量
    a.RESOURES_AMOUNT, -- ENG_AMT_TOT 日结资源金额
    a.VAT + a.FIXED, -- ITEM_AMT_TOT 日结计费项金额
    a.DEBT, -- DEBT_AMT_TOT 日结还债金额
    0.00, -- SF_AMT_TOT 日结业务费金额
    a.TOTAL_AMOUNT, -- ORD_AMT_TOT 日结订单总金额
    a.FBE_UNITS, -- FREE_ENG_TOT 日结免费额度
    a.FBE_AMOUNT, -- FREE_ENG_AMT_TOT 日结免费金额
    a.R_UNITS, -- ENG_CL_TOT 日结撤销资源量
    a.R_RESOURES_AMOUNT, -- ENG_AMT_CL_TOT 日结撤销资源金额
    a.R_VAT + a.R_FIXED, -- ITEM_AMT_CL_TOT 日结撤销计费项
    a.R_DEBT, -- DEBT_AMT_CL_TOT 日结撤销还债金
    NULL, -- SF_AMT_CL_TOT 日结撤销业务费
    NULL, -- ORD_AMT_CL_TOT 日结撤销订单总
    NULL, -- DS_COUNT_FREE 免费订单笔数
    NULL, -- DA_COUNT_CL 撤销订单笔数
    b.agent_id, -- AGENT_ID 代理商标识
    a.ENDTIME -- 手动插入TV字段，应用于分区
FROM tmp_rjd a
LEFT JOIN vd_agt_agent b ON a.TE_NAME = b.AGENT_NAME
LEFT JOIN uap_user c ON a.operator = c.no;

# ② 解款记录表-vd_a_tof_flow
INSERT INTO `vd_a_tof_flow` (`LESSEE_ID`, `TOF_ID`, `TOF_NO`, `TOF_OPER`, `TOF_AMT`, `TOF_DATE`, `TOF_BANK_CODE`,
    `TOF_BANK_NO`, `CONFIRM_OPER`, `CONFIRM_DATE`, `ARRIVE_STATUS`, `ARRIVE_DATE`, `ARRIVE_NO`, `ORG_ID`, `RCV_ORG_NO`,
    BOOK_ID, DS_ID, tv)
SELECT
    2, AMI_GET_SEQUENCE('SEQ_VD_A_TOF_FLOW'), -- 解款标识
    a.BANKINGNO, -- TOF_NO 解款编号，使用老的banking no
    d.id, -- TOF_OPER 解款人员（操作员）
    a.TOTAL_AMOUNT, -- TOF_AMT 解款金额
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
    a.ENDTIME -- 手动插入TV字段，应用于分区
FROM tmp_rjd a
LEFT JOIN tmp_dlsczjl aa ON a.BANKINGNO = aa.CCL_EVIDENCE -- tmp_rjd & tmp_dlsczjl的bankingno对应交集，才能算到账解款记录
LEFT JOIN vd_a_daily_flow b ON a.TOF_NO = b.DS_NO
LEFT JOIN uap_user d ON aa.operator = d.`no`;

# ③ 将[vd_a_tof_flow.TOF_ID]更新至[vd_a_daily_flow.TOF_ID]
UPDATE vd_a_daily_flow daliy INNER JOIN vd_a_tof_flow tof ON daliy.DS_NO = tof.TOF_NO
SET daliy.TOF_ID = tof.TOF_ID;

# 删除索引
ALTER table uap_user DROP INDEX INDEX_uap_user_no;

------------------------------------sqlserver数据源获取-------------------------------------------

select  b.BANKINGNO, -- 日结编号
        convert(varchar(19),b.STARTTIME,120) STARTTIME, -- 日结开始
        convert(varchar(19),isnull(b.ENDTIME,DATEADD(ss, -1,DATEADD(day,1,DATEDIFF(day,0,b.STARTTIME)))),120) ENDTIME, -- 日结结束
        u.USER_ACCOUNT as operator, -- 操作员account，有可能为空那是因为操作员被删除了
        ltrim(rtrim(cdu.TE_NAME)) TE_NAME, -- 代理商名称
        isnull(bs.Transaction_Count,0) Transaction_Count, -- 交易笔数
        isnull(bs.TOTAL_AMOUNT,0) TOTAL_AMOUNT, -- 交易金额
        isnull(bs.CASH,0) CASH, -- 现金收费
        isnull(bs.CREDIT,0) CREDIT, -- 信用卡收费
        isnull(bs.CHEQUE,0) CHEQUE, -- 支票收费
        isnull(bs.RESOURES_AMOUNT,0) RESOURES_AMOUNT, -- 资源金额
        isnull(bs.UNITS,0) UNITS, -- 资源量
        isnull(bs.VAT,0) VAT, -- 税费VAT
        isnull(bs.FIXED,0) FIXED, -- 税费固定
        isnull(bs.DEBT,0) DEBT, -- 还债金额
        isnull(bs.FBE_UNITS,0) FBE_UNITS, -- 免费资源量
        isnull(bs.FBE_AMOUNT,0) FBE_AMOUNT, -- 免费资源金额
        isnull(bs.R_RESOURES_AMOUNT,0) R_RESOURES_AMOUNT, -- 撤单资源金额
        isnull(bs.R_UNITS,0) R_UNITS, -- 撤单资源量
        isnull(bs.R_VAT,0) R_VAT, -- 撤单税费VAT
        isnull(bs.R_FIXED,0) R_FIXED, -- 撤单税费固定
        isnull(bs.R_DEBT,0) R_DEBT -- 撤单债务金额
from ORDER_BANKING b
left join ORDER_BANKING_SUMMARY bs on bs.BatchTRNNO=b.BANKINGNO and bs.BatchType=0
left join IAUDIT_USER u on u.USER_ID=b.OPERATORID
left join IPARA_CDUSTATION cdu on cdu.TERRITORYID=b.CDUID
where b.BATCHNO=0

-------------------------------------tmp_hzjl  自动建表语句-----------------------------------------
CREATE TABLE `tmp_rjd` (
  `BANKINGNO` varchar(128) NOT NULL,
  `STARTTIME` varchar(128) DEFAULT NULL,
  `ENDTIME` varchar(128) DEFAULT NULL,
  `operator` varchar(128) DEFAULT NULL,
  `TE_NAME` varchar(128) DEFAULT NULL,
  `Transaction_Count` varchar(128) DEFAULT NULL,
  `TOTAL_AMOUNT` varchar(128) DEFAULT NULL,
  `CASH` varchar(128) DEFAULT NULL,
  `CREDIT` varchar(128) DEFAULT NULL,
  `CHEQUE` varchar(128) DEFAULT NULL,
  `RESOURES_AMOUNT` varchar(128) DEFAULT NULL,
  `UNITS` varchar(128) DEFAULT NULL,
  `VAT` varchar(128) DEFAULT NULL,
  `FIXED` varchar(128) DEFAULT NULL,
  `DEBT` varchar(128) DEFAULT NULL,
  `FBE_UNITS` varchar(128) DEFAULT NULL,
  `FBE_AMOUNT` varchar(128) DEFAULT NULL,
  `R_RESOURES_AMOUNT` varchar(128) DEFAULT NULL,
  `R_UNITS` varchar(128) DEFAULT NULL,
  `R_VAT` varchar(128) DEFAULT NULL,
  `R_FIXED` varchar(128) DEFAULT NULL,
  `R_DEBT` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`BANKINGNO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;