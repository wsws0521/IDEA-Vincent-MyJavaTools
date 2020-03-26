# 注意事项：

## 一、Navicat还原数据库，
① 出现Duplicate entry 'SEQ_TRIGGER_REGISTRY_ID' for key 'PRIMARY'（可能外键约束，可能 定时任务在跑）
② 出现函数不存在，ROLLBACK其实并未回滚所有
最好删除整个库/sqlyog里面empty库！！！停掉所有定时任务，最好是所有Tomcat，先还原函数，再还原其他！
Navicat这个产品还是不够成熟吧
## 二、UAP_sequence天坑
roleId
roleMenuId
userOrgManageId
userRoleId
可能还有
都要乘以10！！！！！！！！！！！！！！！！！！

## 三、MDC Role权限 + Centlec角色
MDCAdmin/MDCAdmin2019-登录vending8.0，系统设置>>权限管理>>角色管理：
① MDC Role开启所有菜单权限
② 手动新增Centlec角色。15个!!!!
