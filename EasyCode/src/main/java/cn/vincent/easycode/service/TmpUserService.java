package cn.vincent.easycode.service;

import cn.vincent.easycode.entity.TmpUser;
import java.util.List;

/**
 * (TmpUser)表服务接口
 *
 * @author makejava
 * @since 2020-05-23 20:00:48
 */
public interface TmpUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TmpUser queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TmpUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param tmpUser 实例对象
     * @return 实例对象
     */
    TmpUser insert(TmpUser tmpUser);

    /**
     * 修改数据
     *
     * @param tmpUser 实例对象
     * @return 实例对象
     */
    TmpUser update(TmpUser tmpUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}