package cn.vincent.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface SingleCallService {
    /**
     * 当天非第一次同步累计值至mysql
     * @return 0 代表未执行，当天第一次同步调此接口是非法的 1 代表已成功执行
     */
    int callSynCumu2Mysql();

    /**
     * 手动同步当天累计值至sqlserver
     * @return 同步的记录数
     */
    int callSynLjz2Sqlserver();

    /**
     * 调用售电记录同步动作，从 sqlserver DB2 至 mysql
     * sqlserver DB2 每隔4h从生产库获取一次销售数据
     * @return 已同步记录数
     */
    int callSynSdjl2Mysql();

    /**
     * 通过[表号]单独同步1个档案（当天老系统新开，新系统售电）
     * @param meterNo 表号
     */
    String callSynSingleMeter(String meterNo);

    /**
     * 通过[用户ID]单独同步1个档案（当天老系统新开，新系统售电）
     * @param customerId 表号
     */
    String callSynSingleCustomer(String customerId);
}
