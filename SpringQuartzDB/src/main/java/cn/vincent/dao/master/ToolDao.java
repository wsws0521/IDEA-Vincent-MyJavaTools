package cn.vincent.dao.master;

import cn.vincent.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ToolDao {
    int queryTableExist(@Param(value = "tableName") String tableName);
    void updateCreateTmpCentlec();
    List<String> queryTableNameList(@Param(value = "tableBaseName") String tableBaseName);
    void updateDropTableByName(@Param(value = "tableName") String tableName);
}
