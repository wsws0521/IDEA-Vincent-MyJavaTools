## 测试 mybatis-plus
* pom
* yml
* entity-User
```
DTO : Data Transfer Object 中间态
VO : view Object
DO : Domain Object
PO : Persistent Object
```
* mapper
* 启动类扫描 mapper
* 创建库表
````sql
DROP TABLE IF EXISTS public.user;  
   CREATE TABLE public.user (
   id bigint PRIMARY KEY NOT NULL,
   name VARCHAR(30) NULL,
   age INT NULL,
   email VARCHAR(50) NULL,
   manager_id BIGINT NULL,
   create_time timestamptz NULL
   );
comment on table public.user is '测试用户表';
comment on column public.user.id is '主键';
comment on column public.user.name is '姓名';
comment on column public.user.age is '年龄';
comment on column public.user.email is '邮箱';
comment on column public.user.manager_id is '直属上级id';
comment on column public.user.create_time is '创建时间';

select * from public.user;
     
INSERT INTO public.user (id, name, age ,email, manager_id, create_time) VALUES  
   (1, '大BOSS', 40, 'boss@baomidou.com', NULL, '2021-03-22 09:48:00'),  
   (2, '李经理', 40, 'boss@baomidou.com', 1, '2021-01-22 09:48:00'),  
   (3, '黄主管', 40, 'boss@baomidou.com', 2, '2021-01-22 09:48:00'),  
   (4, '吴组长', 40, 'boss@baomidou.com', 2, '2021-02-22 09:48:00'),  
   (5, '小菜', 40, 'boss@baomidou.com', 2, '2021-02-22 09:48:00');
````
* service


## 配置
配置
mybatis plus有许多可配置项，可在application.yml中进行配置，如上面的全局主键策略。下面列举部分配置项

基本配置
configLocation：若有单独的mybatis配置，用这个注解指定mybatis的配置文件（mybatis的全局配置文件）

mapperLocations：mybatis mapper所对应的xml文件的位置

typeAliasesPackage：mybatis的别名包扫描路径

.....

进阶配置
mapUnderscoreToCamelCase：是否开启自动驼峰命名规则映射。（默认开启）

dbTpe：数据库类型。一般不用配，会根据数据库连接url自动识别

fieldStrategy：（已过时）字段验证策略。该配置项在最新版的mp文档中已经找不到了，被细分成了insertStrategy，updateStrategy，selectStrategy。默认值是NOT_NULL，即对于实体对象中非空的字段，才会组装到最终的SQL语句中。

有如下几种可选配置

这个配置项，可在application.yml中进行全局配置，也可以在某一实体类中，对某一字段用@TableField注解进行局部配置

这个字段验证策略有什么用呢？在UPDATE操作中能够体现出来，若用一个User对象执行UPDATE操作，我们希望只对User对象中非空的属性，更新到数据库中，其他属性不做更新，则NOT_NULL可以满足需求。

而若updateStrategy配置为IGNORED，则不会进行非空判断，会将实体对象中的全部属性如实组装到SQL中，这样，执行UPDATE时，可能就将一些不想更新的字段，设置为了NULL。

IGNORED：忽略校验。即，不做校验。实体对象中的全部字段，无论值是什么，都如实地被组装到SQL语句中（为NULL的字段在SQL语句中就组装为NULL）。

NOT_NULL：非NULL校验。只会将非NULL的字段组装到SQL语句中

NOT_EMPTY：非空校验。当有字段是字符串类型时，只组装非空字符串；对其他类型的字段，等同于NOT_NULL

NEVER：不加入SQL。所有字段不加入到SQL语句

tablePrefix：添加表名前缀

## 代码生成器 生成Entity



## 高级功能
* 逻辑删除
@TableLogic(value = "0", delval = "1")  
private Integer deleted;
* 自动填充
@TableField(fill = FieldFill.INSERT) // 插入时自动填充  
    private LocalDateTime createTime;  
* 乐观锁插件
@Version  
    private Integer version; 
* 性能分析插件
<dependency>  
       <groupId>p6spy</groupId>  
       <artifactId>p6spy</artifactId>  
       <version>3.9.1</version>  
   </dependency>
* 多租户SQL拦截器
添加多租户拦截器配置。添加配置后，在执行CRUD的时候，会自动在SQL语句最后拼接租户id的条件
* 动态表名SQL解析器
当数据量特别大的时候，我们通常会采用分库分表。这时，可能就会有多张表，其表结构相同，但表名不同。例如order_1，order_2，order_3，查询时，我们可能需要动态设置要查的表名。mp提供了动态表名SQL解析器


