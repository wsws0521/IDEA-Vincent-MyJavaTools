package cn.vincent.testmybatisplus.console.mapper;

import cn.vincent.testmybatisplus.console.entity.User;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    /**
     * 原生 mybatis
     * 注解方式
     * @return
     */
    @Select("select * from user")
    List<User> selectRaw();
    /**
     * 原生 mybatis
     * xml方式：注意 xml方式需要配置  mybatis-plus:mapper-locations: /mappers/*  和 build 相关的东西
     * @return
     */
    List<User> selectRawXml();

    /**
     * 也可以使用mp提供的Wrapper条件构造器，来自定义SQL
     * 注解方式
     * @param wrapper
     * @return
     */
    // SQL中不写WHERE关键字，且固定使用${ew.customSqlSegment}
    @Select("select * from user ${ew.customSqlSegment}")
    List<User> findAll(@Param(Constants.WRAPPER) Wrapper<User> wrapper);

    /**
     * 也可以使用mp提供的Wrapper条件构造器，来自定义SQL
     * xml方式
     * @param wrapper
     * @return
     */
    // SQL中不写WHERE关键字，且固定使用${ew.customSqlSegment}
    List<User> findAllXml(Wrapper<User> wrapper);

    // 这里采用纯注解方式。当然，若SQL比较复杂，建议还是采用XML的方式
    @Select("SELECT * FROM public.user ${ew.customSqlSegment}")
    Page<User> selectUserPage(Page<User> page, @Param(Constants.WRAPPER) Wrapper<User> wrapper);
}
