# 启动主站

## 页面为MDCAdmin赋予所有单位权限
MDCAdmin登录主站>>组织体系管理>>管理单位配置>>点根单位，
选择 MDCAdmin>>添加单位访问权限（UAP_USER_ORG_MANAGE）>>修改一页显示100个单位>>全选，添加全部单位；
> 不要管CENTAdmin !!!  mig_9会为它授权

## ① 手动创建：计费项（根单位, VAT, Regulation = 百分比, Value = 0.15, Base = 电量电费）
> 计费项
INDIGENT(VAT15%)
COMMON(VAT15%)
BUSINESS(VAT15%)
MANGAUNGNON PROFIT(VAT15%)


## ② 手动创建：费率方案、版本、审核，并添加对应的VAT
2020.7.1-2020.8.31 = 2021winter(本来应该是6.1发布的，迟了)
2020.9.1-2021.5.31 = 2021summer
**新建版本之后（如果不是第一个版本），最好手动生效+手动将TI置为1**
------------------------MANGAUNG & NALEDI-------------------------------
* 01 MANGAUNG-TG1(FBE)
> "0~50：1.13640         MANGAUNG-TG1(FBE)-summer
  50~350：1.20940
  350~无穷：1.65030"
> "0~50：1.44350         MANGAUNG-TG1(FBE)-winter
  50~350：1.54130
  350~无穷：1.82830"
> "0~50：1.2070         MANGAUNG-TG1(FBE)-2020-summer
   50~350：1.2846
   350~无穷：1.7529"
> "0~50：1.5332         MANGAUNG-TG1(FBE)-2020-winter
  50~350：1.6371
  350~无穷：1.9421"
>> INDIGENT(VAT15%)

* 02 MANGAUNG-TG1
"0~350：1.45730          MANGAUNG-TG1-summer
  350~无穷：1.68240"
"0~350：1.80170          MANGAUNG-TG1-winter
  350~无穷：2.18590"
"0~350：1.5479          MANGAUNG-TG1-2020-summer
  350~无穷：1.7871"
"0~350：1.9137          MANGAUNG-TG1-2020-winter
  350~无穷：2.3219"
>> COMMON(VAT15%)

* 11 MANGAUNG-TG1(BUS)
0~无穷：2.17240            MANGAUNG-TG1(BUS)-summer
0~无穷：2.27140            MANGAUNG-TG1(BUS)-winter
0~无穷：2.3075            MANGAUNG-TG1(BUS)-2020-summer
0~无穷：2.4126            MANGAUNG-TG1(BUS)-2020-winter
>> BUSINESS(VAT15%)

* 05 NALEDI-TG3(FBE)
>                       NALEDI-TG3(FBE)-2020-summer
>                       NALEDI-TG3(FBE)-2020-winter
>> INDIGENT(VAT15%)

* 06 NALEDI-TG3
                        NALEDI-TG3-2020-summer
                        NALEDI-TG3-2020-winter
>> COMMON(VAT15%)

* 13 NALEDI-TG3(BUS)
                          NALEDI-TG3(BUS)-2020-summer
                          NALEDI-TG3(BUS)-2020-winter
>> BUSINESS(VAT15%)

-----------------------KOPANONG-------------------------------
* 09 KOPANONG-TG5(FBE)
>   "0~50：1.13630       KOPANONG-TG5(FBE)-summer
    50~350：1.30480
    350~无穷：1.91540"
>   "0~50：1.58750       KOPANONG-TG5(FBE)-winter
    50~350：1.69490
    350~无穷：2.23090"
>   "0~50：1.2070       KOPANONG-TG5(FBE)-2020-summer
    50~350：1.3860
    350~无穷：2.0345"
>   "0~50：1.6862       KOPANONG-TG5(FBE)-2020-winter
    50~350：1.8003
    350~无穷：2.3696"
>> INDIGENT(VAT15%)

* 10 KOPANONG-TG5
"0~350：1.91990          KOPANONG-TG5-summer
350~无穷：1.91990"
"0~350：2.12910          KOPANONG-TG5-winter
350~无穷：2.12910"
"0~350：2.0082          KOPANONG-TG5-2020-summer
350~无穷：2.0082"
"0~350：2.2270          KOPANONG-TG5-2020-winter
350~无穷：2.2270"
>> COMMON(VAT15%)

* 15 KOPANONG-TG5(BUS)
0~无穷：2.31020            KOPANONG-TG5(BUS)-summer
0~无穷：2.37440            KOPANONG-TG5(BUS)-winter
0~无穷：2.4539            KOPANONG-TG5(BUS)-2020-summer
0~无穷：2.5220            KOPANONG-TG5(BUS)-2020-winter
>> BUSINESS(VAT15%)

---------------------------MOHOKARE---------------------------
* 07 MOHOKARE-TG4(FBE)
>   "0~50：1.13630       MOHOKARE-TG4(FBE)-summer
    50~350：1.30480
    350~无穷：1.91540"
>   "0~50：1.58750       MOHOKARE-TG4(FBE)-winter
    50~350：1.69490
    350~无穷：2.23090"
>   "0~50：1.2070       MOHOKARE-TG4(FBE)-2020-summer
    50~350：1.3860
    350~无穷：2.0345"
>   "0~50：1.6862       MOHOKARE-TG4(FBE)-2020-winter
    50~350：1.8003
    350~无穷：2.3696"
>> INDIGENT(VAT15%)

* 08 MOHOKARE-TG4
"0~350：1.91990          MOHOKARE-TG4-summer
350~无穷：1.91990"
"0~350：2.12910          MOHOKARE-TG4-winter
350~无穷：2.12910"
"0~350：2.0082          MOHOKARE-TG4-2020-summer
350~无穷：2.0082"
"0~350：2.2270          MOHOKARE-TG4-2020-winter
350~无穷：2.2270"
>> COMMON(VAT15%)

* 14 MOHOKARE-TG4(BUS)
0~无穷：2.31020            MOHOKARE-TG4(BUS)-summer
0~无穷：2.37440            MOHOKARE-TG4(BUS)-winter
0~无穷：2.4539            MOHOKARE-TG4(BUS)-2020-summer
0~无穷：2.5220            MOHOKARE-TG4(BUS)-2020-winter
>> BUSINESS(VAT15%)

---------------------------MANTSOPA---------------------------
* 03 MANTSOPA-TG2(FBE)
> "0~50：1.02570         MANTSOPA-TG2(FBE)-summer
  50~350：1.28140
  350~600：1.83580
  600~无穷：2.16280"
> "0~50：1.03540         MANTSOPA-TG2(FBE)-winter
  50~350：1.28760
  350~600：1.88830
  600~无穷：2.22370"
> "0~50：1.0895         MANTSOPA-TG2(FBE)-2020-summer
  50~350：1.3611
  350~600：1.9500
  600~无穷：2.2973"
> "0~50：1.0998         MANTSOPA-TG2(FBE)-2020-winter
  50~350：1.3677
  350~600：2.0057
  600~无穷：2.3621"
>> INDIGENT(VAT15%)

* 04 MANTSOPA-TG2
"0~350：1.31680          MANTSOPA-TG2-summer
350~600：1.85320
600~无穷：2.16280"
"0~350：1.36660          MANTSOPA-TG2-winter
350~600：1.92330
600~无穷：2.22370"
"0~350：1.3987          MANTSOPA-TG2-2020-summer
350~600：1.9685
600~无穷：2.2973"
"0~350：1.4516          MANTSOPA-TG2-2020-winter
350~600：2.0430
600~无穷：2.3631"
>> COMMON(VAT15%)

* 12 MANTSOPA-TG2(BUS)
0~无穷：2.17440            MANTSOPA-TG2(BUS)-summer
0~无穷：2.23550            MANTSOPA-TG2(BUS)-winter
0~无穷：2.3097            MANTSOPA-TG2(BUS)-2020-summer
0~无穷：2.3746            MANTSOPA-TG2(BUS)-2020-winter
>> BUSINESS(VAT15%)

---------------------------Unguess说这块不迁，没有表绑定这种费率-------------------------------
* 16 MANGAUNG-NON PROFIT
"0~350：1.50000          MANGAUNG-NON PROFIT
350~无穷：1.55000"
>> MANGAUNGNON PROFIT(VAT15%)

* 17 NALEDI-NON PROFIT
"0~350：1.50000          NALEDI-NON PROFIT
350~无穷：1.55000"
>> MANGAUNGNON PROFIT(VAT15%)

>>> 注意：
0、所有费率方案均可挂在根单位下，
暂时统一选居民=低压居民，商业=非居民
1、版本-单次充值上限500，不做限制，代理商那边有限制
2、对于2个阶梯单价相同的，无需合并成一个阶梯
3、不存在特殊阶梯

## ③ 将所有费率版本ti更新为1（前提是确认老系统的费率ti都是1）
老系统确认：
```sql
Select ti from TARIFF_INDEX group by ti;
Select ti from TARIFF_TABLE group by ti;
```
新系统执行：
```sql
Update vd_e_bill_pkg_ver set ti = 1; -- 15个winter被更新
```

## ④ 注意配置定时任务，如果着急版本生效
新系统执行：
```sql
Update vd_e_bill_pkg_ver set STATUS = '05' where STATUS = '03';  -- 15个summer+2个非盈利=17个被更新
```

## ⑤ 准备电表厂家
mysql先建临时表 tmp_dbcj：
```sql
CREATE TABLE `tmp_dbcj` (
  `MT_MODEL` varchar(255) NOT NULL,
  `MANUFACTURER_DESC` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`MT_MODEL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```
> 刷新导入【192.168.108.11,1433】：33个
```sql
select isnull(m.MT_MODEL_DESC,'') MT_MODEL, f.MANUFACTURER_DESC
from IKERNEL_MANUFACTURER f
left join IKERNEL_MT_TYPE m on f.MANUFACTURER_ID=m.MANUFACTURER_ID
where m.MT_MODEL_DESC is not null
```

## ⑥ 档案快速获取
-------------------------------------tmp_bj  自动建表语句-----------------------------------------
```sql
CREATE TABLE `tmp_bj` (
  `MT_MODEL_DESC` varchar(128) DEFAULT NULL,
  `MT_COMM_ADDR` varchar(128) NOT NULL,
  `station_id` varchar(128) DEFAULT NULL,
  `LINE_ID` varchar(128) DEFAULT NULL,
  `SUBURB_ID` varchar(128) DEFAULT NULL,
  `MUS_TI` varchar(128) DEFAULT NULL,
  `MUS_SGCID` varchar(128) DEFAULT NULL,
  `MUS_KEYVISION` varchar(128) DEFAULT NULL,
  `MUS_KEYEXPIRY` varchar(128) DEFAULT NULL,
  `LASTVENDDATE` varchar(128) DEFAULT NULL,
  `LASTVENDFREEDATE` varchar(128) DEFAULT NULL,
  `TARIFFNAME` varchar(128) DEFAULT NULL,
  `CUSTOMER_ID` varchar(128) DEFAULT NULL,
  `MeterStatus` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`MT_COMM_ADDR`),
  KEY `index_bj_customerid` (`CUSTOMER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```
------sqlserver数据源获取(建议马上同时取得用户档案tmp_yh ！！！防止迁移过程中用户档案继续建立的问题)----------------
> 刷新导入【192.168.108.11,1433】
```sql
select  mt.MT_MODEL_DESC,
        ltrim(rtrim(MT_COMM_ADDR)) MT_COMM_ADDR,
        isnull((case when r.CUSTOMER_ID IS null then m.POWER_SUPPLYER else r.POWER_SUPPLYER end),-1) as station_id,
        isnull((case when r.CUSTOMER_ID IS null then ol.OBJECT_ID else ol2.OBJECT_ID end),-1) as LINE_ID,
        isnull((case when r.CUSTOMER_ID IS null then os.OBJECT_ID else os2.OBJECT_ID end),-1) as SUBURB_ID,
        isnull(MUS_TI,0)as MUS_TI,
        RIGHT('000000'+CAST(MUS_SGCID as varchar(10)),6)as MUS_SGCID,
        isnull(MUS_KEYVISION,0)as MUS_KEYVISION,
        isnull(MUS_KEYEXPIRY,0)as MUS_KEYEXPIRY,
        isnull(CONVERT(VARCHAR(19), LASTVENDDATE, 120),'') as LASTVENDDATE,
        isnull(CONVERT(VARCHAR(19), LASTVENDFREEDATE, 120),'') as LASTVENDFREEDATE,
        isnull(tg.TG_NAME,'') as TARIFFNAME,
        isnull(cast(r.CUSTOMER_ID as varchar),'') as CUSTOMER_ID,
        isnull(kms.NAME,'') as MeterStatus
from IPARA_MTRPOINT m
left join IKERNEL_MT_TYPE mt on mt.MT_MODEL_ID=m.MT_MODEL_ID
left join IPARA_RESIDENT r on m.ACTUAL_CUSTOMER_ID=r.CUSTOMER_ID
left join IPARA_MTRSTATUS ms on ms.MTRPOINT_ID=m.MTRPOINT_ID
left join IKERNEL_MTRSTATUS kms on kms.ID=ms.STATUS_ID
left join IPARA_OBJECT ot on ot.OBJECT_ID=r.POWER_SUPPLYER
left join TARIFF_GROUP tg on tg.TARIFFGROUPID=ot.TARIFFGROUPID
left join IPARA_OBJECT ol on ol.OBJECT_ID=m.LINE_ID and ol.POWER_SUPPLYER=m.POWER_SUPPLYER
left join IPARA_OBJECT ol2 on ol2.OBJECT_ID=r.LINE_ID and ol2.POWER_SUPPLYER=r.POWER_SUPPLYER
left join IPARA_OBJECT os on os.OBJECT_ID=m.SUBURB_ID and os.POWER_SUPPLYER=m.POWER_SUPPLYER
left join IPARA_OBJECT os2 on os2.OBJECT_ID=r.SUBURB_ID and os2.POWER_SUPPLYER=r.POWER_SUPPLYER
where m.MTRPOINT_ID<>269586
```


-------------------------------------tmp_yh  自动建表语句-----------------------------------------
```sql
CREATE TABLE `tmp_yh` (
  `CUSTOMER_ID` varchar(128) NOT NULL,
  `customer_name` varchar(128) DEFAULT NULL,
  `STATUS` varchar(128) DEFAULT NULL,
  `OPENACCOUNT_DATE` varchar(128) DEFAULT NULL,
  `ADDRESS` varchar(128) DEFAULT NULL,
  `StandNumber` varchar(128) DEFAULT NULL,
  `LINKMAN_PHONE` varchar(128) DEFAULT NULL,
  `Station_id` varchar(128) DEFAULT NULL,
  `US_TI` varchar(128) DEFAULT NULL,
  `US_IDNUM` varchar(128) DEFAULT NULL,
  `US_EMAIL` varchar(128) DEFAULT NULL,
  `US_ZIP` varchar(128) DEFAULT NULL,
  `US_SEX` varchar(128) DEFAULT NULL,
  `BANKACCOUNT` varchar(128) DEFAULT NULL,
  `BUSINESS_REGISTRATION_NUMBER` varchar(128) DEFAULT NULL,
  `TARIFFNAME` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`CUSTOMER_ID`),
  KEY `index_yh_tariffname` (`TARIFFNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```
------------------------------------sqlserver数据源获取-------------------------------------------
> 刷新导入【192.168.108.11,1433】
```sql
select  CUSTOMER_ID,
        RTRIM(LTRIM(replace(CUSTOMER_NAME,',','.'))) customer_name,
        r.STATUS,
        OPENACCOUNT_DATE,
        RTRIM(LTRIM(isnull(REPLACE(REPLACE(ADDRESS,';',' '),',','.'),''))) ADDRESS,
        RTRIM(LTRIM(isnull(REPLACE(LINKMAN,',','.'),''))) StandNumber,
        RTRIM(LTRIM(isnull(REPLACE(LINKMAN_PHONE,',','.'),''))) LINKMAN_PHONE,
        r.POWER_SUPPLYER as Station_id,
        US_TI,RTRIM(LTRIM(isnull(REPLACE(US_IDNUM,',','.'),''))) US_IDNUM,
        RTRIM(LTRIM(isnull(REPLACE(US_EMAIL,',','.'),''))) US_EMAIL,
        RTRIM(LTRIM(isnull(REPLACE(US_ZIP,',','.'),''))) US_ZIP,US_SEX,
        RTRIM(LTRIM(isnull(REPLACE(BANKACCOUNT,',','.'),''))) BANKACCOUNT,
        ISNULL(BUSINESS_REGISTRATION_NUMBER,'') as BUSINESS_REGISTRATION_NUMBER,
        isnull(tg.TG_NAME,'') as TARIFFNAME
from IPARA_RESIDENT r
left join IPARA_OBJECT ot on ot.OBJECT_ID=r.POWER_SUPPLYER
left join TARIFF_GROUP tg on tg.TARIFFGROUPID=ot.TARIFFGROUPID
```

-------------------------------------tmp_ljz  自动建表语句-----------------------------------------
```sql
CREATE TABLE `tmp_ljz` (
  `energy` varchar(128) DEFAULT NULL,
  `MT_COMM_ADDR` varchar(128) NOT NULL,
  `LASTVENDDATE` varchar(128) NOT NULL,
  `ISFREE` varchar(128) NOT NULL,
  `ISUSED` varchar(128) NOT NULL,
  `meterId` varchar(128) DEFAULT NULL COMMENT '新系统对应-表计ID',
  `consId` varchar(128) DEFAULT NULL COMMENT '新系统对应-用户ID',
  `energy_old` varchar(128) DEFAULT NULL COMMENT 'NULL',
  `MT_COMM_ADDR_old` varchar(128) DEFAULT NULL COMMENT 'NULL',
  `LASTVENDDATE_old` varchar(128) DEFAULT NULL COMMENT 'NULL',
  `ISFREE_old` varchar(128) DEFAULT NULL COMMENT 'NULL',
  `ISUSED_old` varchar(128) DEFAULT NULL COMMENT 'NULL',
  PRIMARY KEY (`MT_COMM_ADDR`,`LASTVENDDATE`,`ISFREE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```
-----------------------------sqlserver数据源获取(最好也是半夜执行，后面不会再单独同步本日的累计值)-------------------------
> 刷新导入【192.168.108.11,1433】
```sql
SELECT SUM(OCD_ENERGY) energy,
        m.MT_COMM_ADDR,
        convert(varchar(19),max(o.OD_DATE),120) as LASTVENDDATE,
        o.ISFREE,
        '0' as ISUSED
FROM ORDER_trn o
inner join IPARA_MTRPOINT m on o.METERID=m.MTRPOINT_ID
inner join IPARA_RESIDENT r on r.CUSTOMER_ID=m.ACTUAL_CUSTOMER_ID
where   m.ACTUAL_CUSTOMER_ID is not null
        and isnull(o.DELFLAG,0)=0
        and DATEDIFF(MONTH,o.OD_DATE,GETDATE())=0
group by m.MT_COMM_ADDR,o.ISFREE
```


-------------------------------------tmp_zw  自动建表语句-----------------------------------------
```sql
CREATE TABLE `tmp_zw` (
  `DEBTID` varchar(128) NOT NULL,
  `CUSTOMER_ID` varchar(128) DEFAULT NULL,
  `DEBTNM` varchar(128) DEFAULT NULL,
  `Debt_total` varchar(128) DEFAULT NULL,
  `Balance` varchar(128) DEFAULT NULL,
  `DTYPE` varchar(128) DEFAULT NULL,
  `MINPAY` varchar(128) DEFAULT NULL,
  `PMONEYPCT` varchar(128) DEFAULT NULL,
  `AMOUNTPCT` varchar(128) DEFAULT NULL,
  `CREATE_DATE` datetime DEFAULT NULL,
  `LASTDATE` varchar(128) DEFAULT NULL,
  `DebtType` varchar(128) DEFAULT NULL,
  `PAYCTS` varchar(128) DEFAULT NULL,
  `AGREE_ID` varchar(128) DEFAULT NULL,
  `DebtStatus` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`DEBTID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
```
------------------------------------sqlserver数据源获取 4569--4573-------------------------------------------
> 刷新导入【192.168.108.11,1433】
 ```sql
select d.DEBTID,
        d.CUSTOMER_ID,
        DEBTNM,
        AMOUNT Debt_total,
        Isnull(CURENTBLC,0) Balance,
        DTYPE,MINPAY,
        PMONEYPCT,AMOUNTPCT,
        DEBT_DATE CREATE_DATE,
        case when isnull(d.LASTDATE,'')='' then ''
            else isnull(CONVERT(VARCHAR(19), d.LASTDATE, 120),'')
            end LASTDATE,
        (case when DEBTNM in ('Preloaded Credit','preload debt') then 1
            when DEBTNM in ('Tamer','Tamper','tampering') then 2
            else 3 end) as DebtType,
        isnull(d.PAYCTS,0) PAYCTS, ISNULL(d.AGREE_ID,'') as AGREE_ID,
        0 AS DebtStatus
from IPARA_DEBT d
where isnull(d.OKFLAG,0)=0 and 0<>CURENTBLC
union all
select  d.DEBTID,
        d.CUSTOMER_ID,
        DEBTNM,
        AMOUNT Debt_total,
        0 Balance,
        DTYPE,
        MINPAY,
        PMONEYPCT,
        AMOUNTPCT,
        DEBT_DATE CREATE_DATE,
        case when isnull(d.LASTDATE,'')='' then ''
            else isnull(CONVERT(VARCHAR(19), d.LASTDATE, 120),'')
            end LASTDATE,
        (case when DEBTNM in ('Preloaded Credit','preload debt') then 1
            when DEBTNM in ('Tamer','Tamper','tampering') then 2
            else 3 end) as DebtType,
        (isnull(d.PAYCTS,0)+(case when CURENTBLC=0 then 0 else 1 end)) PAYCTS,
        ISNULL(d.AGREE_ID,'') as AGREE_ID,
        (case when CURENTBLC=0 then 1 else 2 end) AS DebtStatus
from IPARA_DEBT d
where isnull(d.OKFLAG,0)>0
```

-------------------------------------tmp_dls  自动建表语句-----------------------------------------
```sql
CREATE TABLE `tmp_dls` (
  `TE_NAME` varchar(128) NOT NULL,
  `TE_ADDRESS` varchar(128) DEFAULT NULL,
  `TE_MINVAL` varchar(128) DEFAULT NULL,
  `TE_MAXVAL` varchar(128) DEFAULT NULL,
  `CDUArea` varchar(128) DEFAULT NULL,
  `TE_CREDIT` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`TE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```
------------------------------------sqlserver数据源获取  66-------------------------------------------
> 刷新导入【192.168.108.11,1433】
```sql
select  ltrim(rtrim(c.TE_NAME)) TE_NAME,
        ltrim(rtrim(c.TE_ADDRESS)) TE_ADDRESS,
        c.TE_MINVAL,
        c.TE_MAXVAL,
        r.REGIONNAME as CDUArea,
        c.TE_CREDIT
from IPARA_CDUSTATION c
left join IPARA_CDUREGION r on c.REGIOINID=r.REGION_ID
```














## 关闭主站，先检查表型，再进行一次Navicat备份（mig_3_0.psc）（带tmp表）







-------------------------------------------------尝试脚本，但是风险太大，后台逻辑逻辑改得看不懂
> 计费项
```sql
DELETE FROM `vd_e_bill_item`;
INSERT INTO `vd_e_bill_item` (`LESSEE_ID`, `ITEM_ID`, `ITEM_NAME`, `APP_SCENE`, `BILL_TYPE`, `BILL_METHOD`, `BILL_PERIOD`, `BILL_VALUE`, `REMARK`, `BAK_PARA`, `BILL_PARA`, `ORG_ID`, `ITEM_STATUS`) VALUES ('2', '1', 'INDIGENT(VAT15%)', '02', '0502', '02', '01', '0.1500', '', NULL, NULL, '10000', '01');
INSERT INTO `vd_e_bill_item` (`LESSEE_ID`, `ITEM_ID`, `ITEM_NAME`, `APP_SCENE`, `BILL_TYPE`, `BILL_METHOD`, `BILL_PERIOD`, `BILL_VALUE`, `REMARK`, `BAK_PARA`, `BILL_PARA`, `ORG_ID`, `ITEM_STATUS`) VALUES ('2', '2', 'COMMON(VAT15%)', '02', '0502', '02', '01', '0.1500', '', NULL, NULL, '10000', '01');
INSERT INTO `vd_e_bill_item` (`LESSEE_ID`, `ITEM_ID`, `ITEM_NAME`, `APP_SCENE`, `BILL_TYPE`, `BILL_METHOD`, `BILL_PERIOD`, `BILL_VALUE`, `REMARK`, `BAK_PARA`, `BILL_PARA`, `ORG_ID`, `ITEM_STATUS`) VALUES ('2', '3', 'BUSINESS(VAT15%)', '02', '0502', '02', '01', '0.1500', '', NULL, NULL, '10000', '01');
INSERT INTO `vd_e_bill_item` (`LESSEE_ID`, `ITEM_ID`, `ITEM_NAME`, `APP_SCENE`, `BILL_TYPE`, `BILL_METHOD`, `BILL_PERIOD`, `BILL_VALUE`, `REMARK`, `BAK_PARA`, `BILL_PARA`, `ORG_ID`, `ITEM_STATUS`) VALUES ('2', '4', 'MANGAUNGNON PROFIT(VAT15%)', '02', '0502', '02', '01', '0.1500', '', NULL, NULL, '10000', '01');
UPDATE sequence SET current_value = 4 WHERE name = 'SEQ_VD_E_BILL_ITEM';
```
> 关联计费量：电量电费
```sql
DELETE FROM `vd_e_item_rel`;
INSERT INTO `vd_e_item_rel` (`LESSEE_ID`, `REL_ID`, `ITEM_ID`, `REL_ITEM_ID`, `CUMU_ITEM`, `BILL_SEQ`) VALUES ('2', '1', '1', NULL, '99', NULL);
INSERT INTO `vd_e_item_rel` (`LESSEE_ID`, `REL_ID`, `ITEM_ID`, `REL_ITEM_ID`, `CUMU_ITEM`, `BILL_SEQ`) VALUES ('2', '2', '2', NULL, '99', NULL);
INSERT INTO `vd_e_item_rel` (`LESSEE_ID`, `REL_ID`, `ITEM_ID`, `REL_ITEM_ID`, `CUMU_ITEM`, `BILL_SEQ`) VALUES ('2', '3', '3', NULL, '99', NULL);
INSERT INTO `vd_e_item_rel` (`LESSEE_ID`, `REL_ID`, `ITEM_ID`, `REL_ITEM_ID`, `CUMU_ITEM`, `BILL_SEQ`) VALUES ('2', '4', '4', NULL, '99', NULL);
UPDATE sequence SET current_value = 4 WHERE name = 'SEQ_VD_E_ITEM_REL';
```
> 费率方案
```sql
DELETE FROM `vd_e_bill_package`;
INSERT INTO `vd_e_bill_package` (`LESSEE_ID`, `PKG_ID`, `PKG_NO`, `PKG_NAME`, `APP_SCENE`, `PKG_CATEGORY`, `PKG_TYPE`, `PKG_STATUS`, `REMARK`, `OPERATOR_ID`, `OPERAROR_TIME`, `ORG_ID`) VALUES ('2', '1', 'TV00000000000001', 'MANGAUNG-TG1(FBE)', '02', '01', '03', '01', NULL, '10000', '2020-03-09 18:10:02', '10000');
INSERT INTO `vd_e_bill_package` (`LESSEE_ID`, `PKG_ID`, `PKG_NO`, `PKG_NAME`, `APP_SCENE`, `PKG_CATEGORY`, `PKG_TYPE`, `PKG_STATUS`, `REMARK`, `OPERATOR_ID`, `OPERAROR_TIME`, `ORG_ID`) VALUES ('2', '2', 'TV00000000000002', 'MANGAUNG-TG1', '02', '01', '03', '01', NULL, '10000', '2020-03-09 18:26:29', '10000');
INSERT INTO `vd_e_bill_package` (`LESSEE_ID`, `PKG_ID`, `PKG_NO`, `PKG_NAME`, `APP_SCENE`, `PKG_CATEGORY`, `PKG_TYPE`, `PKG_STATUS`, `REMARK`, `OPERATOR_ID`, `OPERAROR_TIME`, `ORG_ID`) VALUES ('2', '3', 'TV00000000000003', 'MANTSOPA-TG2(FBE)', '02', '01', '03', '01', NULL, '10000', '2020-03-09 18:30:11', '10000');
INSERT INTO `vd_e_bill_package` (`LESSEE_ID`, `PKG_ID`, `PKG_NO`, `PKG_NAME`, `APP_SCENE`, `PKG_CATEGORY`, `PKG_TYPE`, `PKG_STATUS`, `REMARK`, `OPERATOR_ID`, `OPERAROR_TIME`, `ORG_ID`) VALUES ('2', '4', 'TV00000000000004', 'MANTSOPA-TG2', '02', '01', '03', '01', NULL, '10000', '2020-03-09 18:33:51', '10000');
INSERT INTO `vd_e_bill_package` (`LESSEE_ID`, `PKG_ID`, `PKG_NO`, `PKG_NAME`, `APP_SCENE`, `PKG_CATEGORY`, `PKG_TYPE`, `PKG_STATUS`, `REMARK`, `OPERATOR_ID`, `OPERAROR_TIME`, `ORG_ID`) VALUES ('2', '5', 'TV00000000000005', 'NALEDI-TG3(FBE)', '02', '01', '03', '01', NULL, '10000', '2020-03-09 18:37:16', '10000');
INSERT INTO `vd_e_bill_package` (`LESSEE_ID`, `PKG_ID`, `PKG_NO`, `PKG_NAME`, `APP_SCENE`, `PKG_CATEGORY`, `PKG_TYPE`, `PKG_STATUS`, `REMARK`, `OPERATOR_ID`, `OPERAROR_TIME`, `ORG_ID`) VALUES ('2', '6', 'TV00000000000006', 'NALEDI-TG3', '02', '01', '03', '01', NULL, '10000', '2020-03-09 18:40:09', '10000');
INSERT INTO `vd_e_bill_package` (`LESSEE_ID`, `PKG_ID`, `PKG_NO`, `PKG_NAME`, `APP_SCENE`, `PKG_CATEGORY`, `PKG_TYPE`, `PKG_STATUS`, `REMARK`, `OPERATOR_ID`, `OPERAROR_TIME`, `ORG_ID`) VALUES ('2', '7', 'TV00000000000007', 'MOHOKARE-TG4(FBE)', '02', '01', '03', '01', NULL, '10000', '2020-03-09 18:42:39', '10000');
INSERT INTO `vd_e_bill_package` (`LESSEE_ID`, `PKG_ID`, `PKG_NO`, `PKG_NAME`, `APP_SCENE`, `PKG_CATEGORY`, `PKG_TYPE`, `PKG_STATUS`, `REMARK`, `OPERATOR_ID`, `OPERAROR_TIME`, `ORG_ID`) VALUES ('2', '8', 'TV00000000000008', 'MOHOKARE-TG4', '02', '01', '03', '01', NULL, '10000', '2020-03-09 18:45:24', '10000');
INSERT INTO `vd_e_bill_package` (`LESSEE_ID`, `PKG_ID`, `PKG_NO`, `PKG_NAME`, `APP_SCENE`, `PKG_CATEGORY`, `PKG_TYPE`, `PKG_STATUS`, `REMARK`, `OPERATOR_ID`, `OPERAROR_TIME`, `ORG_ID`) VALUES ('2', '9', 'TV00000000000009', 'KOPANONG-TG5(FBE)', '02', '01', '03', '01', NULL, '10000', '2020-03-09 18:47:14', '10000');
INSERT INTO `vd_e_bill_package` (`LESSEE_ID`, `PKG_ID`, `PKG_NO`, `PKG_NAME`, `APP_SCENE`, `PKG_CATEGORY`, `PKG_TYPE`, `PKG_STATUS`, `REMARK`, `OPERATOR_ID`, `OPERAROR_TIME`, `ORG_ID`) VALUES ('2', '10', 'TV00000000000010', 'KOPANONG-TG5', '02', '01', '03', '01', NULL, '10000', '2020-03-09 18:50:07', '10000');
INSERT INTO `vd_e_bill_package` (`LESSEE_ID`, `PKG_ID`, `PKG_NO`, `PKG_NAME`, `APP_SCENE`, `PKG_CATEGORY`, `PKG_TYPE`, `PKG_STATUS`, `REMARK`, `OPERATOR_ID`, `OPERAROR_TIME`, `ORG_ID`) VALUES ('2', '11', 'TV00000000000011', 'MANGAUNG-TG1(BUS)', '02', '01', '02', '01', NULL, '10000', '2020-03-09 18:52:02', '10000');
INSERT INTO `vd_e_bill_package` (`LESSEE_ID`, `PKG_ID`, `PKG_NO`, `PKG_NAME`, `APP_SCENE`, `PKG_CATEGORY`, `PKG_TYPE`, `PKG_STATUS`, `REMARK`, `OPERATOR_ID`, `OPERAROR_TIME`, `ORG_ID`) VALUES ('2', '12', 'TV00000000000012', 'MANTSOPA-TG2(BUS)', '02', '01', '02', '01', NULL, '10000', '2020-03-09 18:53:44', '10000');
INSERT INTO `vd_e_bill_package` (`LESSEE_ID`, `PKG_ID`, `PKG_NO`, `PKG_NAME`, `APP_SCENE`, `PKG_CATEGORY`, `PKG_TYPE`, `PKG_STATUS`, `REMARK`, `OPERATOR_ID`, `OPERAROR_TIME`, `ORG_ID`) VALUES ('2', '13', 'TV00000000000013', 'NALEDI-TG3(BUS)', '02', '01', '02', '01', NULL, '10000', '2020-03-09 18:55:15', '10000');
INSERT INTO `vd_e_bill_package` (`LESSEE_ID`, `PKG_ID`, `PKG_NO`, `PKG_NAME`, `APP_SCENE`, `PKG_CATEGORY`, `PKG_TYPE`, `PKG_STATUS`, `REMARK`, `OPERATOR_ID`, `OPERAROR_TIME`, `ORG_ID`) VALUES ('2', '14', 'TV00000000000014', 'MOHOKARE-TG4(BUS)', '02', '01', '02', '01', NULL, '10000', '2020-03-09 18:55:15', '10000');
INSERT INTO `vd_e_bill_package` (`LESSEE_ID`, `PKG_ID`, `PKG_NO`, `PKG_NAME`, `APP_SCENE`, `PKG_CATEGORY`, `PKG_TYPE`, `PKG_STATUS`, `REMARK`, `OPERATOR_ID`, `OPERAROR_TIME`, `ORG_ID`) VALUES ('2', '15', 'TV00000000000015', 'KOPANONG-TG5(BUS)', '02', '01', '02', '01', NULL, '10000', '2020-03-09 18:58:07', '10000');
INSERT INTO `vd_e_bill_package` (`LESSEE_ID`, `PKG_ID`, `PKG_NO`, `PKG_NAME`, `APP_SCENE`, `PKG_CATEGORY`, `PKG_TYPE`, `PKG_STATUS`, `REMARK`, `OPERATOR_ID`, `OPERAROR_TIME`, `ORG_ID`) VALUES ('2', '16', 'TV00000000000016', 'MANGAUNG-NON PROFIT', '02', '01', '02', '01', NULL, '10000', '2020-03-09 18:59:46', '10000');
INSERT INTO `vd_e_bill_package` (`LESSEE_ID`, `PKG_ID`, `PKG_NO`, `PKG_NAME`, `APP_SCENE`, `PKG_CATEGORY`, `PKG_TYPE`, `PKG_STATUS`, `REMARK`, `OPERATOR_ID`, `OPERAROR_TIME`, `ORG_ID`) VALUES ('2', '17', 'TV00000000000017', 'NALEDI-NON PROFIT', '02', '01', '02', '01', NULL, '10000', '2020-03-09 19:01:27', '10000');
UPDATE sequence SET current_value = 17 WHERE name = 'SEQ_VD_E_BILL_PKG';
```
> 版本（每个版本还需要插入 1条vd_s_tariff_apply，1条 vd_s_bill_package_snap，1条 VD_S_BILL_PKG_VER_SNAP）
```sql
DELETE FROM `vd_e_bill_pkg_ver`;
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '1', '1', 'TP00000000000001', 'MANGAUNG-TG1(FBE)-summer', NULL, NULL, NULL, '01', CURRENT_DATE(), NULL, NULL, '10000', CURRENT_DATE(), '1', CURRENT_DATE());
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '2', '1', 'TP00000000000002', 'MANGAUNG-TG1(FBE)-winter', NULL, NULL, NULL, '01', '2020-06-01', NULL, NULL, '10000', CURRENT_DATE(), '1', '2020-06-01');
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '3', '2', 'TP00000000000003', 'MANGAUNG-TG1-summer', NULL, NULL, NULL, '01', CURRENT_DATE(), NULL, NULL, '10000', CURRENT_DATE(), '1', CURRENT_DATE());
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '4', '2', 'TP00000000000004', 'MANGAUNG-TG1-winter', NULL, NULL, NULL, '01', '2020-06-01', NULL, NULL, '10000', CURRENT_DATE(), '1', '2020-06-01');
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '5', '3', 'TP00000000000005', 'MANTSOPA-TG2(FBE)-summer', NULL, NULL, NULL, '01', CURRENT_DATE(), NULL, NULL, '10000', CURRENT_DATE(), '1', CURRENT_DATE());
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '6', '3', 'TP00000000000006', 'MANTSOPA-TG2(FBE)-winter', NULL, NULL, NULL, '01', '2020-06-01', NULL, NULL, '10000', CURRENT_DATE(), '1', '2020-06-01');
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '7', '4', 'TP00000000000007', 'MANTSOPA-TG2-summer', NULL, NULL, NULL, '01', CURRENT_DATE(), NULL, NULL, '10000', CURRENT_DATE(), '1', CURRENT_DATE());
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '8', '4', 'TP00000000000008', 'MANTSOPA-TG2-winter', NULL, NULL, NULL, '01', '2020-06-01', NULL, NULL, '10000', CURRENT_DATE(), '1', '2020-06-01');
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '9', '5', 'TP00000000000009', 'NALEDI-TG3(FBE)-summer', NULL, NULL, NULL, '01', CURRENT_DATE(), NULL, NULL, '10000', CURRENT_DATE(), '1', CURRENT_DATE());
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '10', '5', 'TP00000000000010', 'NALEDI-TG3(FBE)-winter', NULL, NULL, NULL, '01', '2020-06-01', NULL, NULL, '10000', CURRENT_DATE(), '1', '2020-06-01');
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '11', '6', 'TP00000000000011', 'NALEDI-TG3-summer', NULL, NULL, NULL, '01', CURRENT_DATE(), NULL, NULL, '10000', CURRENT_DATE(), '1', CURRENT_DATE());
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '12', '6', 'TP00000000000012', 'NALEDI-TG3-winter', NULL, NULL, NULL, '01', '2020-06-01', NULL, NULL, '10000', CURRENT_DATE(), '1', '2020-06-01');
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '13', '7', 'TP00000000000013', 'MOHOKARE-TG4(FBE)-summer', NULL, NULL, NULL, '01', CURRENT_DATE(), NULL, NULL, '10000', CURRENT_DATE(), '1', CURRENT_DATE());
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '14', '7', 'TP00000000000014', 'MOHOKARE-TG4(FBE)-winter', NULL, NULL, NULL, '01', '2020-06-01', NULL, NULL, '10000', CURRENT_DATE(), '1', '2020-06-01');
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '15', '8', 'TP00000000000015', 'MOHOKARE-TG4-summer', NULL, NULL, NULL, '01', CURRENT_DATE(), NULL, NULL, '10000', CURRENT_DATE(), '1', CURRENT_DATE());
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '16', '8', 'TP00000000000016', 'MOHOKARE-TG4-winter', NULL, NULL, NULL, '01', '2020-06-01', NULL, NULL, '10000', CURRENT_DATE(), '1', '2020-06-01');
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '17', '9', 'TP00000000000017', 'KOPANONG-TG5(FBE)-summer', NULL, NULL, NULL, '01', CURRENT_DATE(), NULL, NULL, '10000', CURRENT_DATE(), '1', CURRENT_DATE());
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '18', '9', 'TP00000000000018', 'KOPANONG-TG5(FBE)-winter', NULL, NULL, NULL, '01', '2020-06-01', NULL, NULL, '10000', CURRENT_DATE(), '1', '2020-06-01');
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '19', '10', 'TP00000000000019', 'KOPANONG-TG5-summer', NULL, NULL, NULL, '01', CURRENT_DATE(), NULL, NULL, '10000', CURRENT_DATE(), '1', CURRENT_DATE());
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '20', '10', 'TP00000000000020', 'KOPANONG-TG5-winter', NULL, NULL, NULL, '01', '2020-06-01', NULL, NULL, '10000', CURRENT_DATE(), '1', '2020-06-01');
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '21', '11', 'TP00000000000021', 'MANGAUNG-TG1(BUS)-summer', NULL, NULL, NULL, '01', CURRENT_DATE(), NULL, NULL, '10000', CURRENT_DATE(), '1', CURRENT_DATE());
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '22', '11', 'TP00000000000022', 'MANGAUNG-TG1(BUS)-winter', NULL, NULL, NULL, '01', '2020-06-01', NULL, NULL, '10000', CURRENT_DATE(), '1', '2020-06-01');
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '23', '12', 'TP00000000000023', 'MANTSOPA-TG2(BUS)-summer', NULL, NULL, NULL, '01', CURRENT_DATE(), NULL, NULL, '10000', CURRENT_DATE(), '1', CURRENT_DATE());
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '24', '12', 'TP00000000000024', 'MANTSOPA-TG2(BUS)-winter', NULL, NULL, NULL, '01', '2020-06-01', NULL, NULL, '10000', CURRENT_DATE(), '1', '2020-06-01');
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '25', '13', 'TP00000000000025', 'NALEDI-TG3(BUS)-summer', NULL, NULL, NULL, '01', CURRENT_DATE(), NULL, NULL, '10000', CURRENT_DATE(), '1', CURRENT_DATE());
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '26', '13', 'TP00000000000026', 'NALEDI-TG3(BUS)-winter', NULL, NULL, NULL, '01', '2020-06-01', NULL, NULL, '10000', CURRENT_DATE(), '1', '2020-06-01');
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '27', '14', 'TP00000000000027', 'MOHOKARE-TG4(BUS)-summer', NULL, NULL, NULL, '01', CURRENT_DATE(), NULL, NULL, '10000', CURRENT_DATE(), '1', CURRENT_DATE());
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '28', '14', 'TP00000000000028', 'MOHOKARE-TG4(BUS)-winter', NULL, NULL, NULL, '01', '2020-06-01', NULL, NULL, '10000', CURRENT_DATE(), '1', '2020-06-01');
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '29', '15', 'TP00000000000029', 'KOPANONG-TG5(BUS)-summer', NULL, NULL, NULL, '01', CURRENT_DATE(), NULL, NULL, '10000', CURRENT_DATE(), '1', CURRENT_DATE());
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '30', '15', 'TP00000000000030', 'KOPANONG-TG5(BUS)-winter', NULL, NULL, NULL, '01', '2020-06-01', NULL, NULL, '10000', CURRENT_DATE(), '1', '2020-06-01');
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '31', '16', 'TP00000000000031', 'MANGAUNG-NON PROFIT', NULL, NULL, NULL, '01', CURRENT_DATE(), NULL, NULL, '10000', CURRENT_DATE(), '1', CURRENT_DATE());
INSERT INTO `vd_e_bill_pkg_ver` (`LESSEE_ID`, `VER_ID`, `PKG_ID`, `VER_NO`, `VER_NAME`, `CHARGE_ONCE_LIMIT`, `CHARGE_CNT_LIMIT`, `REMARK`, `STATUS`, `ACTIVE_SINCE`, `ACTIVE_UNTIL`, `ISSUE_DATE`, `OPERATOR_ID`, `OPERAROR_TIME`, `TI`, `LAUNCH_DATE`) VALUES ('2', '32', '17', 'TP00000000000032', 'NALEDI-NON PROFIT', NULL, NULL, NULL, '01', CURRENT_DATE(), NULL, NULL, '10000', CURRENT_DATE(), '1', CURRENT_DATE());
UPDATE sequence SET current_value = 32 WHERE name = 'SEQ_VD_E_BILL_PKG_VER';
```
> 阶梯明细
```sql
DELETE FROM `vd_e_bill_pkg_ver_detail`;
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '1', '1', '0.00', '50.00', '1.136400', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '2', '1', '50.00', '100.00', '1.209400', '01', '1');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '3', '1', '100.00', NULL, '1.650300', '01', '2');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '7', '2', '0.00', '50.00', '1.443500', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '8', '2', '50.00', '350.00', '1.541300', '01', '1');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '9', '2', '350.00', NULL, '1.828300', '01', '2');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '13', '3', '0.00', '350.00', '1.457300', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '14', '3', '350.00', NULL, '1.682400', '01', '1');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '17', '4', '0.00', '350.00', '1.801700', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '18', '4', '350.00', NULL, '2.185900', '01', '1');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '21', '5', '0.00', '50.00', '1.025700', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '22', '5', '50.00', '350.00', '1.281400', '01', '1');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '23', '5', '350.00', '600.00', '1.835800', '01', '2');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '24', '5', '600.00', NULL, '2.162800', '01', '3');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '29', '6', '0.00', '50.00', '1.035400', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '30', '6', '50.00', '350.00', '1.287600', '01', '1');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '31', '6', '350.00', '600.00', '1.888300', '01', '2');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '32', '6', '600.00', NULL, '2.223700', '01', '3');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '37', '7', '0.00', '350.00', '1.316800', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '38', '7', '350.00', '600.00', '1.853200', '01', '1');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '39', '7', '600.00', NULL, '2.162800', '01', '2');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '43', '8', '0.00', '350.00', '1.366600', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '44', '8', '350.00', '600.00', '1.923300', '01', '1');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '45', '8', '600.00', NULL, '2.223700', '01', '2');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '49', '9', '0.00', '50.00', '1.136400', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '50', '9', '50.00', '350.00', '1.209400', '01', '1');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '51', '9', '350.00', NULL, '1.650300', '01', '2');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '55', '10', '0.00', '50.00', '1.443500', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '56', '10', '50.00', '350.00', '1.541300', '01', '1');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '57', '10', '350.00', NULL, '1.828300', '01', '2');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '61', '11', '0.00', '350.00', '1.457300', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '62', '11', '350.00', NULL, '1.682400', '01', '1');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '65', '12', '0.00', '350.00', '1.801700', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '66', '12', '350.00', NULL, '2.185900', '01', '1');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '69', '13', '0.00', '50.00', '1.136300', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '70', '13', '50.00', '350.00', '1.304800', '01', '1');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '71', '13', '350.00', NULL, '1.915400', '01', '2');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '75', '14', '0.00', '50.00', '1.587500', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '76', '14', '50.00', '350.00', '1.694900', '01', '1');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '77', '14', '350.00', NULL, '2.230900', '01', '2');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '81', '15', '0.00', '350.00', '1.919900', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '82', '15', '350.00', NULL, '1.919900', '01', '1');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '85', '16', '0.00', '350.00', '2.129100', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '86', '16', '350.00', NULL, '2.129100', '01', '1');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '89', '17', '0.00', '50.00', '1.136300', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '90', '17', '50.00', '350.00', '1.304800', '01', '1');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '91', '17', '350.00', NULL, '1.915400', '01', '2');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '95', '18', '0.00', '50.00', '1.587500', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '96', '18', '50.00', '350.00', '1.694900', '01', '1');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '97', '18', '350.00', NULL, '2.230900', '01', '2');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '101', '19', '0.00', '350.00', '1.919900', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '102', '19', '350.00', NULL, '1.919900', '01', '1');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '105', '20', '0.00', '350.00', '2.129100', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '106', '20', '350.00', NULL, '2.129100', '01', '1');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '109', '21', '0.00', NULL, '2.172400', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '111', '22', '0.00', NULL, '2.271400', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '113', '23', '0.00', NULL, '2.174400', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '115', '24', '0.00', NULL, '2.235500', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '117', '25', '0.00', NULL, '2.172400', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '119', '26', '0.00', NULL, '2.271400', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '121', '27', '0.00', NULL, '2.310200', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '123', '28', '0.00', NULL, '2.374400', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '125', '29', '0.00', NULL, '2.310200', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '127', '30', '0.00', NULL, '2.374400', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '129', '31', '0.00', '350.00', '1.500000', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '130', '31', '350.00', NULL, '1.550000', '01', '1');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '133', '32', '0.00', '350.00', '1.500000', '01', '0');
INSERT INTO `vd_e_bill_pkg_ver_detail` (`LESSEE_ID`, `PRICE_ID`, `VER_ID`, `STEPB`, `STEPE`, `UNIT_PRICE`, `STEP_TYPE`, `SEQ`) VALUES ('2', '134', '32', '350.00', NULL, '1.550000', '01', '1');
UPDATE sequence SET current_value = 136 WHERE name = 'SEQ_VD_E_BILL_PKG_VER_DETAIL';
```
> 关联计费项
```sql
DELETE FROM `vd_e_bill_item_rel`;
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '1', '10', '1', '1', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '3', '10', '2', '1', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '5', '10', '3', '2', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '7', '10', '4', '2', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '9', '10', '5', '1', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '11', '10', '6', '1', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '13', '10', '7', '2', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '15', '10', '8', '2', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '17', '10', '9', '1', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '19', '10', '10', '1', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '21', '10', '11', '2', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '23', '10', '12', '2', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '25', '10', '13', '1', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '27', '10', '14', '1', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '29', '10', '15', '2', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '31', '10', '16', '2', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '33', '10', '17', '1', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '35', '10', '18', '1', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '37', '10', '19', '2', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '39', '10', '20', '2', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '41', '10', '21', '3', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '43', '10', '22', '3', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '45', '10', '23', '3', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '47', '10', '24', '3', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '49', '10', '25', '3', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '51', '10', '26', '3', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '53', '10', '27', '3', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '55', '10', '28', '3', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '57', '10', '29', '3', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '59', '10', '30', '3', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '61', '10', '31', '4', '1');
INSERT INTO `vd_e_bill_item_rel` (`LESSEE_ID`, `REL_ID`, `OBJ_TYPE`, `OBJ_ID`, `ITEM_ID`, `BILL_SEQ`) VALUES ('2', '63', '10', '32', '4', '1');
UPDATE sequence SET current_value = 64 WHERE name = 'SEQ_VD_E_BILL_ITEM_REL';
```