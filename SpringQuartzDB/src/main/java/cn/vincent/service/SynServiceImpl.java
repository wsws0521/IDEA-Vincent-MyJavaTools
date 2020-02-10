package cn.vincent.service;

import cn.vincent.dao.master.MysqlSynDao;
import cn.vincent.pojo.TmpYhChangedDw;
import cn.vincent.pojo.TmpYhChangedTariff;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 将存储过程转移至Service，使得过程更容易追踪
 */
@Service
public class SynServiceImpl implements SynService {
    private static final Logger logger = LoggerFactory.getLogger(SynServiceImpl.class);
    @Resource
    MysqlSynDao mysqlSynDao;

    @Override
    public void addIndexWithCheck(String tableName, String indexName, String column) {
        // ----------------索引
        int indexNum = mysqlSynDao.queryExistsIndex(tableName, indexName);
        logger.info(tableName + "存在" + indexNum + "条名为：" + indexName + "的索引");
        if(indexNum == 0){
            logger.info("为" + tableName + "插入索引" + indexName);
            mysqlSynDao.addIndex(tableName, indexName, column);
        }
    }

    @Override
    public void addIndex(String tableName, String indexName, String column) {
        logger.info("为" + tableName + "插入索引" + indexName);
        mysqlSynDao.addIndex(tableName, indexName, column);
    }

    @Override
    public void deleteIndex(String tableName, String indexName) {
        logger.info("为" + tableName + "删除索引" + indexName);
        mysqlSynDao.deleteIndex(tableName, indexName);
    }

    /**
     * 执行<同步1：运行时秘钥.txt>：费率方案、电压等级、管理单位
     */
    @Override
    public void executeSyn1(List<TmpYhChangedTariff> yhTariff, List<TmpYhChangedDw> yhDw) {

    }

}
