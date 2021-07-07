package cn.vincent.testmybatisplus.console.service;

import cn.vincent.testmybatisplus.console.entity.User;
import cn.vincent.testmybatisplus.console.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
