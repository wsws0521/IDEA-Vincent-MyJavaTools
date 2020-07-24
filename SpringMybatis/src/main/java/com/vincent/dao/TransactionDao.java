package com.vincent.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TransactionDao {
    int insertTest1(@Param(value = "name") String name, @Param(value = "status") int status);

    Integer queryTest1(@Param(value = "name") String name);
}
