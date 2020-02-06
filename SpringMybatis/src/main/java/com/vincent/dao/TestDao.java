package com.vincent.dao;

import com.vincent.pojo.ProcParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TestDao {
    int insertTest1(@Param(value = "name") String name, @Param(value = "status") int status);

    void exeProc2(ProcParam pp);

    int queryTableSize(@Param(value = "tableName") String tableName);
}
