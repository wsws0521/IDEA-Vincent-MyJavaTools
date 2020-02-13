package cn.vincent.dao.master;

import org.apache.ibatis.annotations.Param;

public interface MysqlSynDao {

    int queryExistsIndex(@Param(value = "tableName") String tableName, @Param(value = "indexName") String indexName);

    void addIndex(@Param(value = "tableName") String tableName, @Param(value = "indexName") String indexName, @Param(value = "columnName") String columnName);

    void deleteIndex(@Param(value = "tableName") String tableName, @Param(value = "indexName") String indexName);
}
