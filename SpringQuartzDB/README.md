## 同步工具使用说明

* 每天凌晨01:10开始执行同步
* 抓取sqlserver的数据：tmp_bj、tmp_yh、tmp_zw、[tmp_ljz]


### 访问路径

#### 1、quartz
> http://localhost:8000/quartz/hello
>> Quartz: Hello Centlec !

> http://localhost:8000/quartz/path/{id}
>> 手动调用同步  dbService.generalCall()

> http://localhost:8000/start
>> 启动一个测试定时任务

> http://localhost:8000/delete
>> 删除测试定时任务

#### 2、test
> http://localhost:8000/test/hello
>> Test: Hello Centlec !

> http://localhost:8000/test/dbsize
>> 返回 P_THIRD_PARTY 表的大小，以测试数据库连接

> http://localhost:8000/mysql/proc
>> 测试 mybatis 去新建 存储过程 （已失败）

> http://localhost:8000/path/{id}
>> 测试基本日志打印

#### 3、singlecall
> http://localhost:8000/singlecall/hello
>> Singal Call: Hello Centlec !

> http://localhost:8000/singlecall/cumu/mysql
>> 手动调用同步 singleCallService.callSynCumu2Mysql()

> http://localhost:8000/singlecall/ljz/sqlserver
>> 手动调用同步 singleCallService.callSynLjz2Sqlserver()