package cn.vincent.service;

public interface ToolService {
    /**
     * 根据表名查询，表是否存在，不存在代表第一次运行同步程序，返回true
     * @param tableName 表名
     * @return
     */
    boolean ifTableNotExist(String tableName);

    /**
     * 创建tmp_centlec用于并轨期间数据同步，并轨结束需要手动删除改表
     */
    void createTmpCentlec();

    /**
     * 同步过程中，时间后缀的tmp表越来越多，定期清除
     */
    void truncateTmpTables();
}
