package cn.vincent.testmybatisplus.console.service;

import cn.vincent.testmybatisplus.console.entity.User;
import cn.vincent.testmybatisplus.console.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Resource
    UserMapper userMapper;
    @Autowired
    IdGenerator idGenerator;
    @Value("${userService.canModify}")
    private Boolean canModify;

    @Override
    public Integer createUser(User user) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        List<User> users = userMapper.selectList(wrapper);

        Optional<User> max = users.stream().max(Comparator.comparingLong(User::getId));
        Long newId = idGenerator.next(max.get().getId());
        user.setId(newId);

        Optional<User> first = users.stream().filter(x -> x.getName().equals(user.getName())).findFirst();
        if(first.get() == null){
            // insert
            int insert = userMapper.insert(user);
            return insert;
        }else {
            if(canModify){
                // update
                int update = userMapper.updateById(user);
                return update;
            }else {
                throw new RuntimeException("不支持修改");
            }
        }
    }
}
