package cn.vincent.service;

import cn.vincent.pojo.TmpYhChangedDw;
import cn.vincent.pojo.TmpYhChangedTariff;

import java.util.List;

public interface IndexService {
    void addIndexWithCheck(String tableName, String indexName, String column);
    void addIndex(String tableName, String indexName, String column);
    void deleteIndexWithCheck(String tableName, String indexName);
    void deleteIndex(String tableName, String indexName);
    /**
     * 执行<同步1：运行时秘钥.txt>：费率方案、电压等级、管理单位
     */
    void executeSyn1(List<TmpYhChangedTariff> yhTariff, List<TmpYhChangedDw> yhDw);


}
