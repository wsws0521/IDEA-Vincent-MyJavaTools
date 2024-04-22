package cn.vincent;

import org.junit.Test;

import java.util.Optional;

/**
 * 优雅的规避 NPE 异常
 */
public class AvoidNPE {
    // Optional(T value)    一个私有构造，被下面仨小弟 调用
    // empty()              返回默认空对象
    // of(T value)          还是会报 NPE， 用于特殊场合：如单元测试
    // ofNullable(T value)  就算value为空也不报异常，返回 empty()
    // ------------------------------------------------------------上面一顿操作，还是个Optional对象。。下面就不一定了
    // orElse(method)       无论是否为空，都调 method
    // orElseGet(method)    仅当空，调 method
    // orElseThrow()        空了抛异常
    @Test
    public void test1() {
        User user = null;
        user = Optional.ofNullable(user).orElse(createUser());
        user = Optional.ofNullable(user).orElseGet(() -> createUser());
    }
    public User createUser(){
        User user = new User();
        user.setName("Vincent");
        Long[] childrenIdList = {};
        user.setChildrenIdList(childrenIdList);
        return user;
    }
    // map                  将属性值映射出来：取属性值的时候有差异（普通）
    // flatMap              将属性值映射出来：取属性值的时候有差异（Optional）
    @Test
    public void test2() {
        User user = createUser();
        String name = Optional.ofNullable(user).map(u -> u.getName()).get();
        System.out.println(name);
        String optionalName = Optional.ofNullable(user).flatMap(u -> u.getOptionalName()).get();
        System.out.println(optionalName);
    }
    // isPresent            判断是否为空
    // ifPresent            不为空就做点啥吧
    @Test
    public void test3() {
        User user = createUser();
        Optional.ofNullable(user).ifPresent(u -> {
            System.out.println("对象是存在的");
        });
    }
    // filter 过滤
    @Test
    public void test4() {
        User user = createUser();
        Optional<User> ou = Optional.ofNullable(user).filter(u -> u.getName().length() < 6);
        ou.ifPresent(u -> {
            System.out.println("对象是存在的");
        });
    }




    @Test
    public void testA() throws Exception {
        // 嵌套属性判空：以前先判断 user 对象是否存在，再判断 address 对象是否存在，然后打印 city 信息
        User user = createUser();
        String city = Optional.ofNullable(user).map(u -> u.getAddress()).map(a -> a.getCity()).orElseThrow(()->new Exception("取城市错误"));
        System.out.println(city);
    }
    @Test
    public void testB(){
        // 常见判空：不为空就咋样咋样
        User user = createUser();
        Optional.ofNullable(user).ifPresent(u -> {
            System.out.println(u.getName());
        });
        // 空数组
        Optional.ofNullable(user.getChildrenIdList()).ifPresent(u -> {
            System.out.println("holy fuck!");
        });
    }
    @Test
    public void testC(){
        // 判空 + 筛选 + 不存在就新建
        User user = createUser();
        user = Optional.ofNullable(user).filter(u -> "wushuai".equals(u.getName())).orElseGet(() -> {
            User u1 = new User();
            u1.setName("wushuai");
            return u1;
        });
        System.out.println(user.getName());
    }

}
