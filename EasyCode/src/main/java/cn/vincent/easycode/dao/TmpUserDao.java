package cn.vincent.easycode.dao;

import cn.vincent.easycode.entity.TmpUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (TmpUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-05-23 20:00:47
 */
@Mapper
public interface TmpUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TmpUser queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<TmpUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tmpUser 实例对象
     * @return 对象列表
     */
    List<TmpUser> queryAll(TmpUser tmpUser);

    /**
     * 新增数据
     *
     * @param tmpUser 实例对象
     * @return 影响行数
     */
    int insert(TmpUser tmpUser);

    /**
     * 修改数据
     *
     * @param tmpUser 实例对象
     * @return 影响行数
     */
    int update(TmpUser tmpUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}