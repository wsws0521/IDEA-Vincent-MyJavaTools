# EasyCode
> 插件，可直接对数据的表生成 entity、controller、service、dao、Mapper
## 1-安装EasyCode插件
> 最好配合Lombok插件
## 2-准备库表

## 3-连接DB
> IDEA 右侧 Database + DataSource >> mysql
>> 注意General标签>> Database可以不填，在schema标签下选择对应数据库
>> 注意mysql8（mysql-jdbc驱动）会强校验时区，可能需要在URL后面追加?serverTimezone=GMT%2B2保持时区一致

## 4-easycode生成代码
> 右侧 schemas >> 库名 >> 表名 右键 >> EasyCode >> generate code >> 选择目标package >> 勾选要生成的文件(前6个) >> 同意创建对应文件夹
>> 把 Entity 路径拷贝到 application.yml 里面

## 5-启动前的额外准备
> dao 加上 @Mapper注解
> 启动类加上 @MapperScan("dao路径")
>> 访问 http://localhost:8080/tmpUser/selectOne?id=4

## 另外需要注意
mysql-connector-java 版本大于6，就需要对应使用   com.mysql.cj.jdbc.Driver  驱动（带时区不带SSL）
mysql-connector-java 版本小于6，就需要对应使用   com.mysql.jdbc.Driver  驱动（带SSL不带时区）
否则阿里连接池就是会报：java.sql.SQLException: validateConnection false