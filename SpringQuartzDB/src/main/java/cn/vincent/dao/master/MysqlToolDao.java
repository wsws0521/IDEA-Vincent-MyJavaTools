package cn.vincent.dao.master;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MysqlToolDao {
    int queryTableExist(@Param(value = "tableName") String tableName);
    int queryTableSize(@Param(value = "tableName") String tableName);
    void updateCreateTmpCentlec();
    List<String> queryTableNameList(@Param(value = "tableBaseName") String tableBaseName);
    void updateDropTableByName(@Param(value = "tableName") String tableName);

    void updateAlterTableByName(@Param(value = "oldName") String oldName, @Param(value = "newName") String newName);
    void updateCreateTmpLjz();

    String queryMaxLastVendDateFromLjz1();

    int queryTmpLjzIsToday();

    String queryMaxSynTvFromPayFlow();

    void updateCreateTmpSdjl();
}
