------------------------------------------------存储过程-------------------------------------------------
DROP PROCEDURE IF EXISTS mig_zz_2_1;
delimiter $$
CREATE PROCEDURE mig_zz_2_1()

BEGIN
	DECLARE t_error INTEGER DEFAULT 0;
	DECLARE msg text;
	# 定义SQL异常时将t_error置为1
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
	begin
		get diagnostics condition 1 msg = message_text;
		set t_error = 1;
	end;

    IF NOT EXISTS(SELECT * FROM information_schema.statistics WHERE table_name='tmp_dlsczjl' AND index_name='INDEX_tmp_dlsczjl_bankingno') THEN
        ALTER table tmp_dlsczjl ADD INDEX INDEX_tmp_dlsczjl_bankingno(CCL_EVIDENCE);
    end if;

    # 开启事务
    START TRANSACTION;

    # ① 导入-日结记录表-vd_a_daily_flow
    INSERT INTO `vd_a_daily_flow`
        (`LESSEE_ID`, `DS_ID`, `DS_NO`, `DS_OPER`, `CHARGE_MODE`, `DS_AMT`, `DS_DATE`, `NOTE_NO`,
        `BANK_CODE`, `DS_STATUS`, `CONFIRM_OPER`, `CONFIRM_DATE`, `ORG_ID`, `DS_START_DATE`, `DS_END_DATE`,
        `DS_COUNT`, `ENG_TOT`, `ENG_AMT_TOT`, `ITEM_AMT_TOT`, `DEBT_AMT_TOT`, `SF_AMT_TOT`, `ORD_AMT_TOT`, `FREE_ENG_TOT`,
        `FREE_ENG_AMT_TOT`, `ENG_CL_TOT`, `ENG_AMT_CL_TOT`, `ITEM_AMT_CL_TOT`, `DEBT_AMT_CL_TOT`, `SF_AMT_CL_TOT`,
        `ORD_AMT_CL_TOT`, `DS_OBJ`, `DS_COUNT_FREE`, `DA_COUNT_CL`, `AGENT_ID`, tv
        )
    SELECT
        2, AMI_GET_SEQUENCE('SEQ_VD_A_DAILY_FLOW'),
        -- NULL, -- TOF_ID（等后面更新）（新版本被删了）
        a.BANKINGNO, -- DS_NO日结编号，迁移数据用老banking编号
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
        IF(b.agent_type='01','02','01'), -- DS_OBJ 日结对象 01直营代理商的操作员/未绑代理商的操作员 02第三方代理商的操作员
        NULL, -- DS_COUNT_FREE 免费订单笔数
        NULL, -- DA_COUNT_CL 撤销订单笔数
        b.agent_id, -- AGENT_ID 代理商标识
        a.ENDTIME -- 手动插入TV字段，应用于分区
    FROM tmp_rjd a
    LEFT JOIN vd_agt_agent b ON a.TE_NAME = b.AGENT_NAME
    LEFT JOIN uap_user c ON a.operator = c.no;

    IF t_error = 1 THEN
		ROLLBACK;
	ELSE
		COMMIT;
	END IF;

    SELECT t_error, msg;

END
$$
delimiter ;

------------------------------------sqlserver数据源获取, 【tmp_rjd】124703条-------------------------------------------

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

-------------------------------------tmp_rjd  自动建表语句-----------------------------------------
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


------------------------------------sqlserver数据源获取, 【tmp_dlsczjl】122545条----------------------------

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

-------------------------------------tmp_dlsczjl  自动建表语句-----------------------------------------

CREATE TABLE `tmp_dlsczjl` (
  `ID` varchar(128) NOT NULL,
  `TE_NAME` varchar(128) DEFAULT NULL,
  `CCL_EVIDENCE` varchar(128) DEFAULT NULL,
  `CCL_CASH` varchar(128) DEFAULT NULL,
  `createDate` varchar(128) DEFAULT NULL,
  `operator` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;