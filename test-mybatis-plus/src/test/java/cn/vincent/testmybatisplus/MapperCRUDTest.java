package cn.vincent.testmybatisplus;

import cn.vincent.testmybatisplus.console.entity.User;
import cn.vincent.testmybatisplus.console.entity.UserAR;
import cn.vincent.testmybatisplus.console.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.conditions.update.LambdaUpdateChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperCRUDTest {
    @Resource
    private UserMapper userMapper;
    @Test
    public void testSelect() {
        List<User> list = userMapper.selectList(null);
        assertEquals(5, list.size());
        list.forEach(System.out::println);
    }

    /**
     * 查询部分列
     */
    @Test
    public void selectMaps() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("id","name","email").likeRight("name","黄");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    /**
     * 数据统计
     */
    @Test
    public void selectMaps2Aggregate() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("manager_id", "avg(age) avg_age", "min(age) min_age", "max(age) max_age")
                .groupBy("manager_id")
                .having("sum(age) < {0}", 500);
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    /**
     * selectObjs 只会返回第一个字段（第一列）的值，其他字段会被舍弃
     */
    @Test
    public void selectObjs() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.select("id", "name").like("name", "黄");
        List<Object> objects = userMapper.selectObjs(wrapper);
        objects.forEach(System.out::println);
    }

    @Test
    public void selectCount() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        wrapper.select("id", "name"); 语法错误
//        wrapper.select("id"); 规范是不添加   默认count(1)
        wrapper.like("name", "黄");
        Integer count = userMapper.selectCount(wrapper);
        System.out.println(count);
    }


    /**
     * Wrapper进阶   强大的Wrapper构造器
     */
    @Test
    public void constructWrapper(){
        // 案例先展示需要完成的SQL语句，后展示Wrapper的写法

        // 1. 名字中包含佳，且年龄小于25
        // SELECT * FROM user WHERE name like '%佳%' AND age < 25
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("name", "佳").lt("age", 25);
        List<User> users = userMapper.selectList(wrapper);


        // 下面展示SQL时，仅展示WHERE条件；展示代码时, 仅展示Wrapper构建部分

        // 2. 姓名为黄姓，且年龄大于等于20，小于等于40，且email字段不为空
        // name like '黄%' AND age BETWEEN 20 AND 40 AND email is not null
        wrapper.likeRight("name","黄").between("age", 20, 40).isNotNull("email");

        // 3. 姓名为黄姓，或者年龄大于等于40，按照年龄降序排列，年龄相同则按照id升序排列
        // name like '黄%' OR age >= 40 order by age desc, id asc
        wrapper.likeRight("name","黄").or().ge("age",40).orderByDesc("age").orderByAsc("id");

        // 4.创建日期为2021年3月22日，并且直属上级的名字为李姓
        // date_format(create_time,'%Y-%m-%d') = '2021-03-22' AND manager_id IN (SELECT id FROM user WHERE name like '李%')
        wrapper.apply("date_format(create_time, '%Y-%m-%d') = {0}", "2021-03-22") // 建议采用{index}这种方式动态传参, 可防止SQL注入
                .inSql("manager_id", "SELECT id FROM user WHERE name like '李%'");
        // 上面的apply, 也可以直接使用下面这种方式做字符串拼接，但当这个日期是一个外部参数时，这种方式有SQL注入的风险
        wrapper.apply("date_format(create_time, '%Y-%m-%d') = '2021-03-22'");

        // 5. 名字为王姓，并且（年龄小于40，或者邮箱不为空）
        // name like '王%' AND (age < 40 OR email is not null)
        wrapper.likeRight("name", "王").and(q -> q.lt("age", 40).or().isNotNull("email"));

        // 6. 名字为王姓，或者（年龄小于40并且年龄大于20并且邮箱不为空）
        // name like '王%' OR (age < 40 AND age > 20 AND email is not null)
        wrapper.likeRight("name", "王").or(
                q -> q.lt("age",40)
                        .gt("age",20)
                        .isNotNull("email")
        );

        // 7. (年龄小于40或者邮箱不为空) 并且名字为王姓
        // (age < 40 OR email is not null) AND name like '王%'
        wrapper.nested(q -> q.lt("age", 40).or().isNotNull("email"))
                .likeRight("name", "王");

        // 8. 年龄为30，31，34，35
        // age IN (30,31,34,35)
        wrapper.in("age", Arrays.asList(30,31,34,35));
        // 或
        wrapper.inSql("age","30,31,34,35");

        // 9. 年龄为30，31，34，35, 返回满足条件的第一条记录
        // age IN (30,31,34,35) LIMIT 1
        wrapper.in("age", Arrays.asList(30,31,34,35)).last("LIMIT 1");

        // 10. 只选出id, name 列 (QueryWrapper 特有)
        // SELECT id, name FROM user;
        wrapper.select("id", "name");

        // 11. 选出id, name, age, email, 等同于排除 manager_id 和 create_time
        // 当列特别多, 而只需要排除个别列时, 采用上面的方式可能需要写很多个列, 可以采用重载的select方法，指定需要排除的列
        wrapper.select(User.class, info -> {
            String columnName = info.getColumn();
            return !"create_time".equals(columnName) && !"manager_id".equals(columnName);
        });


        // wrapper都可以放一个Boolean参数进去！！！   作为  condition
        String name = "黄"; // 假设name变量是一个外部传入的参数
        wrapper.like(StringUtils.hasText(name), "name", name);
        // 仅当 StringUtils.hasText(name) 为 true 时, 会拼接这个like语句到WHERE中
        // 其实就是对下面代码的简化
//        if (StringUtils.hasText(name)) {
//            wrapper.like("name", name);
//        }
    }

    /**
     * 实体对象  作为  参数，就是非空字段全等值匹配
     * 如果某个字段 不想等值匹配，POJO字段上可加：
     *  @TableField(condition = SqlCondition.LIKE) // 配置该字段使用like进行拼接
     *  枚举类 SqlCondition 就是个sql串而已，种类有限，可自定义：
     *  @TableField(condition = "%s &gt; #{%s}") // 这里相当于大于, 其中 &gt; 是字符实体
     */
    @Test
    public void equalPojo() {
        User user = new User();
        user.setName("黄主管");
        user.setAge(28);
        QueryWrapper<User> wrapper = new QueryWrapper<>(user);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    /**
     * map
     * 当allEq方法传入的Map中有value为null的元素时，默认会设置为is null
     * 若想忽略null
     * wrapper.allEq(param, false);
     * 若想过滤掉某几个字段
     * wrapper.allEq((k,v) -> !"name".equals(k), param); // 过滤掉map中key为name的元素
     */
    @Test
    public void allEqual() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        Map<String, Object> param = new HashMap<>();
        param.put("age", 40);
        param.put("name", "黄飞飞");
        wrapper.allEq(param);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    /**
     * lambdaQueryWrapper
     * 可以不必像普通条件构造器一样，以字符串形式指定列名，它可以直接以实体类的方法引用来指定列，防止手残？
     */
    @Test
    public void lambdaQueryWrapper() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(User::getName, "黄").lt(User::getAge, 30);
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);


        // 链式
        LambdaQueryChainWrapper<User> chainWrapper = new LambdaQueryChainWrapper<>(userMapper);
        List<User> users2 = chainWrapper.like(User::getName, "黄").gt(User::getAge, 30).list();
        users2.forEach(System.out::println);
    }


    /**
     * entity中非空的属性，会被更新到数据库
     */
    @Test
    public void update() {
        // 根据ID更新
        User user = new User();
        user.setId(2L);
        user.setAge(18);
        userMapper.updateById(user); // （适用于 很多字段需要更新）

        // 根据条件更新
        user.setName("王三蛋");
        LambdaUpdateWrapper<User> wrapper = new LambdaUpdateWrapper<>();
        wrapper.between(User::getAge, 26,31).likeRight(User::getName,"吴");
        userMapper.update(user, wrapper); // （适用于 很多字段需要更新） 如果仅更新 极少字段，wrapper 可以代劳，无需 user 对象，参考如下：
        wrapper.likeRight(User::getEmail, "share").set(User::getManagerId, 9L);
        userMapper.update(null, wrapper);

        // 把实体对象传入 whereWrapper 再更新
        User whereUser = new User();
        whereUser.setAge(40);
        whereUser.setName("王");
        LambdaUpdateWrapper<User> wrapper2 = new LambdaUpdateWrapper<>(whereUser);
        User user2 = new User();
        user2.setEmail("share@baomidou.com");
        user2.setManagerId(10L);
        userMapper.update(user2, wrapper);
    }
    @Test
    public void delete() {
        // BaseMapper 提供了 ：
//        deleteById  根据主键id进行删除
//        deleteBatchIds  根据主键id进行批量删除
//        deleteByMap  根据Map进行删除（Map中的key为列名，value为值，根据列和值进行等值匹配）
//        delete(Wrapper<T> wrapper)  根据条件构造器Wrapper进行删除
    }

    @Test
    public void constructChainLambdaWrapper() {
        LambdaUpdateChainWrapper<User> wrapper = new LambdaUpdateChainWrapper<>(userMapper);
        wrapper.likeRight(User::getEmail, "share")
                .like(User::getName, "飞飞")
                .set(User::getEmail, "ff@baomidou.com")
                .update();
    }

    /**
     * 原生mybatis
     */
    @Test
    public void mybatis() {
        List<User> users = userMapper.selectRaw();
        users.forEach(System.out::println);
    }

    /**
     * 分页  需要配置Bean
     * 执行了两次 sql
     */
    @Test
    public void testPage() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.ge(User::getAge, 28);
        // 设置分页信息, 查第3页, 每页2条数据
        Page<User> page = new Page<>(3, 2);
        // 执行分页查询
        Page<User> userPage = userMapper.selectPage(page, wrapper);
        System.out.println("总记录数 = " + userPage.getTotal());
        System.out.println("总页数 = " + userPage.getPages());
        System.out.println("当前页码 = " + userPage.getCurrent());
        // 获取分页查询结果
        List<User> records = userPage.getRecords();
        records.forEach(System.out::println);
    }

    /**
     * 稍微复杂点的查询（注解查询/带wrapper条件） -> 分页
     * 再复杂了就用 xml 吧
     */
    @Test
    public void testPage2() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.ge(User::getAge, 28).likeRight(User::getName, "王");
        Page<User> page = new Page<>(3,2);
        Page<User> userPage = userMapper.selectUserPage(page, wrapper);
        System.out.println("总记录数 = " + userPage.getTotal());
        System.out.println("总页数 = " + userPage.getPages());
        userPage.getRecords().forEach(System.out::println);
    }

    /**
     * 继承自 Active Record 对象
     */
    @Test
    public void insertAr() {
        UserAR user = new UserAR();
        user.setId(15L);
        user.setName("我是AR猪");
        user.setAge(1);
        user.setEmail("ar@baomidou.com");
        user.setManagerId(1L);
        boolean success = user.insert(); // 插入
        System.out.println(success);
    }
    // 查询
    @Test
    public void selectAr() {
        UserAR user = new UserAR();
        user.setId(15L);
        UserAR result = user.selectById();
        System.out.println(result);
    }
    // 更新
    @Test
    public void updateAr() {
        UserAR user = new UserAR();
        user.setId(15L);
        user.setName("王全蛋");
        user.updateById();
    }
    //删除
    @Test
    public void deleteAr() {
        UserAR user = new UserAR();
        user.setId(15L);
        user.deleteById();
    }
}
