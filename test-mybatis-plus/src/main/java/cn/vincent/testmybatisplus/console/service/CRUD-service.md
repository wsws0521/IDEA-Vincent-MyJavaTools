## Service CRUD 接口
另外一套CRUD是Service层的，
只需要编写一个接口，继承IService，并创建一个接口实现类，即可食用。

这个接口提供的CRUD方法，和Mapper接口提供的功能大同小异，

比较明显的区别在于IService支持了更多的**批量化操作**，
如saveBatch，saveOrUpdateBatch等方法。

### 强大的条件构造器
条件构造器主要涉及到3个类：
* AbstractWrapper = where
```
eq：equals，等于
allEq：all equals，全等于
ne：not equals，不等于
gt：greater than ，大于 >
ge：greater than or equals，大于等于≥
lt：less than，小于<
le：less than or equals，小于等于≤
between：相当于SQL中的BETWEEN
notBetween
like：模糊匹配。like("name","黄")，相当于SQL的name like '%黄%'
likeRight：模糊匹配右半边。likeRight("name","黄")，相当于SQL的name like '黄%'
likeLeft：模糊匹配左半边。likeLeft("name","黄")，相当于SQL的name like '%黄'
notLike：notLike("name","黄")，相当于SQL的name not like '%黄%'
isNull
isNotNull
in
and：SQL连接符AND
or：SQL连接符OR
apply：用于拼接SQL，该方法可用于数据库函数，并可以动态传参
.......
```
* QueryWrapper += select()
```

```
* UpdateWrapper += set()
