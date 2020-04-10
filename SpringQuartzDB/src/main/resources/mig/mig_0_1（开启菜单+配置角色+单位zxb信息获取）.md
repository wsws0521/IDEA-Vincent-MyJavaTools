# 注意事项：

## 零、Navicat备份（before-mig.psc）
关闭定时任务等...

## 一、出现任何问题，Navicat还原数据库
还原时
* ① 出现Duplicate entry 'SEQ_TRIGGER_REGISTRY_ID' for key 'PRIMARY'（可能外键约束，可能 定时任务在跑）
* ② 出现函数不存在，ROLLBACK其实并未回滚所有
> 最好删除整个库/sqlyog里面empty库！！！（还原不会删除临时表，只会覆盖原有表）停掉所有定时任务，最好是所有Tomcat，先还原函数，再还原其他！
Navicat这个产品还是不够成熟吧

## 二、UAP_sequence天坑
roleId
roleMenuId
userOrgManageId
userRoleId
可能还有
都要乘以10！！！！！！！！！！！！！！！！！！
```sql
update uap_sequence set next_val = next_val * 10
where sequence_name in ('roleId','roleMenuId','userOrgManageId','userRoleId');
```

## 三、启动主站，MDC Role权限 + Centlec角色
MDCAdmin/MDCAdmin2019-登录vending8.0，系统设置 Setup>>权限管理 Authentication>>角色管理 Roles：
① MDC Role开启所有菜单权限
② 手动新增Centlec角色。15个!!!!
> 角色类型：都是管理角色？
[创建 00-CENTLEC_Admin 角色 + CENTLECAdmin操作员（并赋予该角色）]
以 CENTLECAdmin/CENTLECAdmin2020- 操作员 身份登录并创建以下 15个角色
* 01-Call_Centre
* 02-Customer_Care
* 03-Finance_Admin
* 04-Finance_Credit
* 05-Finance_Report
* 06-IT
* 07-Meter_Assistant
* 08-Meter_Preload
* 09-Meter_Room
* 10-Tariff Approve
* 11-Tariff_maintenance
* 12-Maintenance
* 13-Cashier
* 14-CDU
* 15-CDU_Admin_Role

## 四、关闭主站，再进行一次Navicat备份（mig_0_1.psc）
关闭定时任务等...

## 五、ODBC导入单位数据
```sql
CREATE TABLE `tmp_dw` (
  `object_id` varchar(128) NOT NULL,
  `OBJECT_TYPE` varchar(128) DEFAULT NULL,
  `FatherId` varchar(128) DEFAULT NULL,
  `OBJECT_NAME` varchar(128) DEFAULT NULL,
  `SGC` varchar(128) DEFAULT NULL,
  `NEWID` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`object_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```
> 刷新导入【192.168.108.11,1433】，sqlserver数据源获取(85)
```sql
select  cast(o.OBJECT_ID as varchar) as 'object_id',
        o.OBJECT_TYPE,
        (case when o.REGION_ID=-1 then o.GRID_ID else o.REGION_ID end) as 'FatherId',
        rtrim(replace(o.OBJECT_NAME,',','-')) as 'OBJECT_NAME',
        RIGHT('000000'+CAST(o2.SGCID as varchar(10)),6) as SGC,
        '' as 'NEWID'
from IPARA_OBJECT o
left join (select on2.*,row_number() over (partition by on2.region_id order by modifydate desc) rn from IPARA_OBJECT on2 where on2.OBJECT_TYPE=2) o2
            on o2.REGION_ID=o.OBJECT_ID and rn=1
where o.OBJECT_TYPE in(1,2,0)
order by OBJECT_NAME,FatherId
```
## 六、ODBC导入站线变zxb数据
```sql
CREATE TABLE `tmp_zxb` (
  `object_id` varchar(128) NOT NULL,
  `OBJECT_TYPE` varchar(128) DEFAULT NULL,
  `FatherId` varchar(128) DEFAULT NULL,
  `OBJECT_NAME` varchar(128) DEFAULT NULL,
  `NEWID` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`object_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
```
> 刷新导入【192.168.108.11,1433】，sqlserver数据源获取(613)
```sql
select  cast(OBJECT_ID as varchar) as 'object_id',
        OBJECT_TYPE,
        (case when o.LINE_ID>-1 then o.LINE_ID when o.POWER_SUPPLYER>-1 then o.POWER_SUPPLYER
            when o.REGION_ID>-1 then o.REGION_ID else o.GRID_ID end) as 'FatherId',
        rtrim(replace(OBJECT_NAME,',','-')) as 'OBJECT_NAME',
        '' as 'NEWID'
 from IPARA_OBJECT o
where OBJECT_TYPE > 1 order by OBJECT_NAME,FatherId
```



