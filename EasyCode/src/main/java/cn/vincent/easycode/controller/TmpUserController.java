package cn.vincent.easycode.controller;

import cn.vincent.easycode.entity.TmpUser;
import cn.vincent.easycode.service.TmpUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (TmpUser)表控制层
 *
 * @author makejava
 * @since 2020-05-23 20:00:49
 */
@RestController
@RequestMapping("tmpUser")
public class TmpUserController {
    /**
     * 服务对象
     */
    @Resource
    private TmpUserService tmpUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public TmpUser selectOne(Integer id) {
        return this.tmpUserService.queryById(id);
    }

}