/**
 * 添加了两个   power mockito  依赖 导致：
 *
 * Mockito cannot mock this class: interface com.hikvision.iSecureComMgr.service.ComponentService.
 *
 * Mockito can only mock non-private & non-final classes.
 */
package cn.vincent.testmybatisplus;

import cn.vincent.testmybatisplus.console.entity.User;
import cn.vincent.testmybatisplus.console.mapper.UserMapper;
import cn.vincent.testmybatisplus.console.service.IdGenerator;
import cn.vincent.testmybatisplus.console.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

@RunWith(PowerMockRunner.class)
public class MockitoTest {
    /** 模拟依赖对象 */
    @Mock
    UserMapper userMapper;
    /** 标识生成器 */
    @Mock
    IdGenerator idGenerator;
    /** 定义被测对象 */
    @InjectMocks
    UserService userService;
    /**
     * 在测试之前
     */
//    @Before
//    public void beforeTest() {
//        // 注入依赖对象
//        Whitebox.setInternalState(userService, "canModify", Boolean.TRUE);
//    }


    /**
     * 测试: 创建用户-新
     */
    @Test
    public void testCreateUserWithNew() {
        // 模拟 userDAO.getIdByName 死活就是返回null
        Mockito.doReturn(null).when(userMapper).selectList(new QueryWrapper<>());
        // 模拟 idGenerator.next 死活就是返回1
        Long userId = 1L;
        Mockito.doReturn(userId).when(idGenerator).next(Mockito.anyLong());

//        // 调用被测方法(从json对象创建User对象)
//        String text = ResourceHelper.getResourceAsString(getClass(), "userCreateVO.json");
////        User userCreate = JSON.parseObject(text, User.class);
//        User userCreate = new User();
//        Assert.assertEquals("用户标识不一致", userId, userService.createUser(userCreate));

        // 验证依赖方法
        // 验证依赖方法: userDAO.getByName
//        Mockito.verify(userDAO).getIdByName(userCreate.getName());
        // 验证依赖方法: idGenerator.next
//        Mockito.verify(idGenerator).next();
        // 验证依赖方法: userMapper.create
//        ArgumentCaptor<UserDO> userCreateCaptor = ArgumentCaptor.forClass(UserDO.class);
//        Mockito.verify(userMapper).create(userCreateCaptor.capture());
//        text = ResourceHelper.getResourceAsString(getClass(), "userCreateDO.json");
//        Assert.assertEquals("用户创建不一致", text, JSON.toJSONString(userCreateCaptor.getValue()));
//
//        // 验证依赖对象
//        Mockito.verifyNoMoreInteractions(idGenerator, userMapper);
    }

    /**
     * 测试: 创建用户-异常
     */
//    @Test
//    public void testCreateUserWithException() {
//        // 注入依赖对象
//        Whitebox.setInternalState(userService, "canModify", Boolean.FALSE);
//
//        // 模拟依赖方法
//        // 模拟依赖方法: userDAO.getByName
//        Long userId = 1L;
//        Mockito.doReturn(userId).when(userMapper).getIdByName(Mockito.anyString());
//
//        // 调用被测方法
//        String text = ResourceHelper.getResourceAsString(getClass(), "userCreateVO.json");
//        UserVO userCreate = JSON.parseObject(text, UserVO.class);
//        UnsupportedOperationException exception = Assert.assertThrows("返回异常不一致",
//                UnsupportedOperationException.class, () -> userService.createUser(userCreate));
//        Assert.assertEquals("异常消息不一致", "不支持修改", exception.getMessage());
//    }
}
