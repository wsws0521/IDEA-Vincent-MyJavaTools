package cn.vincent.service;

import cn.vincent.pojo.ProcessParam;
import cn.vincent.pojo.PthirdParty;
import cn.vincent.pojo.TariffGroup;

import java.util.List;

public interface TestDbService {
    // 测试用
    List<PthirdParty> queryMysqlPthirdParty();
    List<TariffGroup> querySqlserverTariffGroup();

    int insertRollback();

    // 测试存储过程：改名字
    ProcessParam executeProc();


    int batchInsert();

    int testBatchQueryInsert();
}
