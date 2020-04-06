
未完待续

-----------------------------------------------------存储过程--------------------------------------------------------
IF NOT EXISTS(SELECT * FROM information_schema.statistics WHERE table_name='uap_user' AND index_name='INDEX_uap_user_no') THEN
    ALTER table uap_user ADD INDEX INDEX_uap_user_no(no);
end if;



------------------------------------sqlserver 数据源获取-------------------------------------------

select  t.ORDERSID,                                             -- 票据编号（主键）
        m.MT_COMM_ADDR,                                         -- 表号
        convert(varchar(19),t.OD_DATE,120) as OD_DATE,          -- 购电时间
        t.ISFREE,                                               -- 是否 FBE（0-正常 1-FBE）
        t.USER_ID as CUSTOMER_ID,                               -- 老用户 ID
        RIGHT('000000'+CAST(t.SGCID as varchar(10)),6) as SGC,  -- SGC
        t.TI,                                                   -- TI
        t.KEYVERSIONID,                                         -- krn
        t.KEYEXPIRY,                                            -- ken
        t.OCD_TOKEN,                                            -- Token
        t.OCD_ENERGY,                                           -- 资源量
        t.OCD_MONEY,                                            -- 资源金额
        t.PAYTYPE,                                              -- 支付方式（0现金1信用卡2支票3第三方）
        t.FP_VAL3,                                              -- 百分比税金额
        t.OCD_DEBT,                                             -- 还债金额
        t.DEBT_BLC,                                             -- 交易后剩余金额
        t.OCD_PAYMONEY,                                         -- 支付金额
        u.USER_ACCOUNT as operator,                             -- 售电员
        ltrim(rtrim(cdu.TE_NAME)) TE_NAME,                      -- 代理商名称
        t.DELFLAG                                               -- 是否撤单（0正常订单1已撤销订单）
from ORDER_TRN t                                            -- 【订单 表】
inner join IPARA_MTRPOINT m on t.METERID=m.MTRPOINT_ID      -- 【表计档案 表】
inner join IPARA_RESIDENT r on r.CUSTOMER_ID=t.USER_ID      -- 【用户档案 表】
left join IAUDIT_USER u on u.USER_ID=t.OPERATORID           -- 【售电员 表】
left join IPARA_CDUSTATION cdu on cdu.TERRITORYID=t.CDUID   -- 【CDU/代理商 表】

-------------------------------------tmp_jyjl  自动建表语句-----------------------------------------

CREATE TABLE `tmp_jyjl` (
  `ORDERSID` varchar(128) NOT NULL,
  `MT_COMM_ADDR` varchar(128) DEFAULT NULL,
  `OD_DATE` Date DEFAULT NULL,
  `ISFREE` varchar(128) DEFAULT NULL,
  `CUSTOMER_ID` varchar(128) DEFAULT NULL,
  `SGC` varchar(128) DEFAULT NULL,
  `TI` varchar(128) DEFAULT NULL,
  `KEYVERSIONID` varchar(128) DEFAULT NULL,
  `KEYEXPIRY` varchar(128) DEFAULT NULL,
  `OCD_TOKEN` varchar(128) DEFAULT NULL,
  `OCD_ENERGY` varchar(128) DEFAULT NULL,
  `OCD_MONEY` varchar(128) DEFAULT NULL,
  `PAYTYPE` varchar(128) DEFAULT NULL,
  `FP_VAL3` varchar(128) DEFAULT NULL,
  `OCD_DEBT` varchar(128) DEFAULT NULL,
  `DEBT_BLC` varchar(128) DEFAULT NULL,
  `OCD_PAYMONEY` varchar(128) DEFAULT NULL,
  `operator` varchar(128) DEFAULT NULL,
  `TE_NAME` varchar(128) DEFAULT NULL,
  `DELFLAG` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`ORDERSID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;