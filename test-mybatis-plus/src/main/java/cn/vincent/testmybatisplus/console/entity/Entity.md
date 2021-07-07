## 主键策略
在定义实体类时，用@TableId指定主键，而其type属性，可以指定主键策略。

mp支持多种主键策略，默认的策略是基于雪花算法的自增id。全部主键策略定义在了枚举类IdType中，IdType有如下的取值

AUTO

数据库ID自增，依赖于数据库。在插入操作生成SQL语句时，不会插入主键这一列

NONE

未设置主键类型。若在代码中没有手动设置主键，则会根据主键的全局策略自动生成（默认的主键全局策略是基于雪花算法的自增ID）

INPUT

需要手动设置主键，若不设置。插入操作生成SQL语句时，主键这一列的值会是null。oracle的序列主键需要使用这种方式

ASSIGN_ID

当没有手动设置主键，即实体类中的主键属性为空时，才会自动填充，使用雪花算法

ASSIGN_UUID

当实体类的主键属性为空时，才会自动填充，使用UUID

....（还有几种是已过时的，就不再列举）

可以针对每个实体类，使用@TableId注解指定该实体类的主键策略，这可以理解为局部策略。若希望对所有的实体类，都采用同一种主键策略，挨个在每个实体类上进行配置，则太麻烦了，此时可以用主键的全局策略。只需要在application.yml进行配置即可。比如，配置了全局采用自增主键策略
```config
# application.yml  
mybatis-plus:  
  global-config:  
    db-config:  
      id-type: auto
```

    @TableId(type = IdType.AUTO)  
   private Long id;  
   代码中没有设置主键ID，发出的SQL语句中也没有设置主键ID，并且插入结束后，主键ID会被写回到实体对象。
   
   @TableId(type = IdType.NONE)  
   默认策略，取全局策略
   
   ASSIGN_ID采用雪花算法，ASSIGN_UUID采用UUID