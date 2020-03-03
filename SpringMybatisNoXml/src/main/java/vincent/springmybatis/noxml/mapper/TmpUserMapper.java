package vincent.springmybatis.noxml.mapper;

import org.apache.ibatis.annotations.*;
import vincent.springmybatis.noxml.SqlProvider.TmpUserSqlProvider;
import vincent.springmybatis.noxml.pojo.TmpUser;

import java.util.List;

@Mapper
public interface TmpUserMapper {
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "tv", column = "TV"),
            @Result(property = "username", column = "USERNAME"),
            @Result(property = "age", column = "AGE")
    })
    @Select("select * from tmp_user")
    List<TmpUser> list();

    @SelectProvider(type = TmpUserSqlProvider.class, method = "listWuShuai")
    List<TmpUser> listWuShuai();

    @InsertProvider(type = TmpUserSqlProvider.class, method = "insertTmpUserByObject")
    // @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertTmpUser(TmpUser tmpUser);
}
