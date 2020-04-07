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
