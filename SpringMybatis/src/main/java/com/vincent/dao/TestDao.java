package com.vincent.dao;

import com.vincent.pojo.ProcParam;
import com.vincent.pojo.TmpTestTariffDate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TestDao {
    int insertTest1(@Param(value = "name") String name, @Param(value = "status") int status);

    ProcParam exeProc2(ProcParam pp);

    int queryTableSize(@Param(value = "tableName") String tableName);

    int insertTmpTestTariffDate(TmpTestTariffDate tmpTestTariffDate);
}
