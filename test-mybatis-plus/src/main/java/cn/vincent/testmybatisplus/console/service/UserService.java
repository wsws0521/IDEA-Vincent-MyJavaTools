package cn.vincent.testmybatisplus.console.service;

import cn.vincent.testmybatisplus.console.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<User> {
    Integer createUser(User user);
}
