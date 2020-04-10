package cn.vincent.service;

public interface ToolService {
    /**
     * 根据表名查询，表是否存在，不存在代表第一次运行同步程序，返回true
     * @param tableName 表名
     * @return
     */
    boolean ifTableNotExist(String tableName);
    boolean ifTableExist(String tableName);

    /**
     * 创建tmp_centlec用于并轨期间数据同步，并轨结束需要手动删除改表
     */
    void createTmpCentlec();

    /**
     * 同步过程中，时间后缀的tmp表越来越多，定期清除
     */
    void truncateTmpTables();

    /**
     * 0.2同步脚本出错时，手动执行回滚操作
     */
    void resetTmpFromTmp1();

    /**
     * 获取tmp_ljz1日期后缀的新表名（日期为表内lastvenddate）
     * @return
     */
    String getTmpLjz1DateName();

    /**
     * 创建同步存储过程 syn**.proc
     */
//    void createSynProcess();
}
