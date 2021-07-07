## Mapper CRUD接口
> 只需定义好实体类，然后创建一个接口，继承mp提供的BaseMapper，即可食用。mp会在mybatis启动时，自动解析实体类和表的映射关系，并注入带有通用CRUD方法的mapper。BaseMapper里提供的方法，部分列举如下：

insert(T entity)  插入一条记录

deleteById(Serializable id)  根据主键id删除一条记录

delete(Wrapper<T> wrapper) 根据条件构造器wrapper进行删除

selectById(Serializable id) 根据主键id进行查找

selectBatchIds(Collection idList) 根据主键id进行批量查找

selectByMap(Map<String,Object> map) 根据map中指定的列名和列值进行等值匹配查找

* selectMaps(Wrapper<T> wrapper)  根据 wrapper 条件，查询记录，将查询结果封装为一个Map，Map的key为结果的列，value为值
* selectObjs 只会返回第一个字段（第一列）的值，其他字段会被舍弃
* selectCount 注意，使用这个方法，不能调用QueryWrapper的select方法设置要查询的列了。这个方法会自动添加select count(1)

selectList(Wrapper<T> wrapper) 根据条件构造器wrapper进行查询

update(T entity, Wrapper<T> wrapper) 根据条件构造器wrapper进行更新

updateById(T entity)

...

## 分页查询  MybatisPlusConfig
BaseMapper中提供了2个方法进行分页查询，
分别是
* selectPage    会将查询的结果封装成Java实体对象
* selectMapsPage，会封装成Map<String,Object>


