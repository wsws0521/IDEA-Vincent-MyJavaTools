package cn.vincent.dao.other;

import cn.vincent.pojo.TariffGroup;
import cn.vincent.pojo.TmpBj;
import cn.vincent.pojo.TmpInsert;

import java.util.List;

public interface TestSqlserverDao {
    List<TariffGroup> queryTariffGroup();

    List<TmpInsert> queryTmpTest();

    List<TmpBj> queryTmpBj();
}
