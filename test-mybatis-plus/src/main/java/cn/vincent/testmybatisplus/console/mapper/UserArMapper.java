package cn.vincent.testmybatisplus.console.mapper;

import cn.vincent.testmybatisplus.console.entity.UserAR;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * Entity 必须要有对应的 mapper
 * 否则报 Not Found TableInfoCache
 */
public interface UserArMapper extends BaseMapper<UserAR> {

}
