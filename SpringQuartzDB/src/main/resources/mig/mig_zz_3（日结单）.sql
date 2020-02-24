------------------------------------<queryBalanceDetail>-------------------------------------------


------------------------------------sqlserver数据源获取-------------------------------------------

select  b.BANKINGNO, -- 日结编号
        convert(varchar(19),b.STARTTIME,120) STARTTIME, -- 日结开始
        convert(varchar(19),isnull(b.ENDTIME,DATEADD(ss, -1,DATEADD(day,1,DATEDIFF(day,0,b.STARTTIME)))),120) ENDTIME, -- 日结结束
        u.USER_ACCOUNT as operator, -- 操作员account，有可能为空那是因为操作员被删除了
        cdu.TE_NAME, -- 代理商名称
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




 ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;