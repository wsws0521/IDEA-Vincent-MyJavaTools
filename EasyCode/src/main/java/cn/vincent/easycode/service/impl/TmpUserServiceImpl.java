package cn.vincent.easycode.service.impl;

import cn.vincent.easycode.entity.TmpUser;
import cn.vincent.easycode.dao.TmpUserDao;
import cn.vincent.easycode.service.TmpUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (TmpUser)表服务实现类
 *
 * @author makejava
 * @since 2020-05-23 20:00:49
 */
@Service("tmpUserService")
public class TmpUserServiceImpl implements TmpUserService {
    @Resource
    private TmpUserDao tmpUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public TmpUser queryById(Integer id) {
        return this.tmpUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<TmpUser> queryAllByLimit(int offset, int limit) {
        return this.tmpUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param tmpUser 实例对象
     * @return 实例对象
     */
    @Override
    public TmpUser insert(TmpUser tmpUser) {
        this.tmpUserDao.insert(tmpUser);
        return tmpUser;
    }

    /**
     * 修改数据
     *
     * @param tmpUser 实例对象
     * @return 实例对象
     */
    @Override
    public TmpUser update(TmpUser tmpUser) {
        this.tmpUserDao.update(tmpUser);
        return this.queryById(tmpUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.tmpUserDao.deleteById(id) > 0;
    }
}