## [手动]
### ① 清空 vd_pre_model；
### ② 手动跑 V2_0_104__VD_PRE_MODEL_DATA.sql 脚本；


## [如果工具不识别脚本中的特殊字符，可以尝试自动执行]
### ① 清空 vd_pre_model；
### ② 删除flyway脚本执行记录；
DELETE FROM BIZ_SYS_SCHEMA_VERSION WHERE SCRIPT = ‘V2_0_104__ VD_PRE_MODEL_DATA.sql’;
### ③ 重启Tomcat会自动执行；
