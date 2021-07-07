package cn.vincent.testmybatisplus;

import cn.vincent.testmybatisplus.console.entity.User;
import cn.vincent.testmybatisplus.console.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceCRUDTest {
    @Autowired
    private UserService userService;
    @Test
    public void testGetOne() {
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
        wrapper.gt(User::getAge, 28);
        User one = userService.getOne(wrapper, false); // 第二参数指定为false,使得在查到了多行记录时,不抛出异常,而返回第一条记录
        System.out.println(one);
    }
    /**
     * 支持链式调用（查询 & 更新）
     */
    @Test
    public void testChain() {
        List<User> list = userService.lambdaQuery()
                .gt(User::getAge, 39)
                .likeRight(User::getName, "王")
                .list();
        list.forEach(System.out::println);
        // 更新
        userService.lambdaUpdate()
                .gt(User::getAge, 39)
                .likeRight(User::getName, "王")
                .set(User::getEmail, "w39@baomidou.com")
                .update();
        // 删除
        userService.lambdaUpdate()
                .like(User::getName, "青蛙")
                .remove();
    }



}
