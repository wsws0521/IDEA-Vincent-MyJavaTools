package vincent.springmybatis.noxml.controller;

import org.springframework.web.bind.annotation.*;
import vincent.springmybatis.noxml.mapper.TmpUserMapper;
import vincent.springmybatis.noxml.pojo.TmpUser;

import javax.annotation.Resource;
import java.util.List;

/**
 * 官方文档：Mybatis3-中文手册
 *
 * http://www.mybatis.org/mybatis-3/zh/java-api.html
 * 专题阅读：《SpringBoot 布道系列》
 *
 * https://www.jianshu.com/p/964370d9374e
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    TmpUserMapper tmpUserMapper;

    @GetMapping("/{id}")
    public List<TmpUser> returnStringId(@PathVariable String id){
//        List<TmpUser> result = tmpUserMapper.list();
        TmpUser tmpUser = new TmpUser();
        tmpUser.setUsername("user" + id);
        tmpUser.setAge(32);
        int i = tmpUserMapper.insertTmpUser(tmpUser);
        System.out.println(i);

        List<TmpUser> result = tmpUserMapper.listWuShuai();
        for (TmpUser user : result){
            System.out.println(user.getUsername());
        }
        return result;
    }

//    @PostMapping("/tmpTestTariffDate")
//    public void insertTmpTestTariffDate(@RequestBody TmpTestTariffDate tmpTestTariffDate){
//        // 参照印象笔记Springboot下关于Date的笔记
//        testService.insertTmpTestTariffDate(tmpTestTariffDate);
//    }
}
