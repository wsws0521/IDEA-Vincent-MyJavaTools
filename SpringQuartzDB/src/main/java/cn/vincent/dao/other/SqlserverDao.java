package cn.vincent.dao.other;

import cn.vincent.pojo.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SqlserverDao {

    List<TmpBj> queryTmpBj();

    List<TmpYh> queryTmpYh();

    List<TmpZw> queryTmpZw();

    List<TmpLjz> queryTmpLjzYestoday(@Param(value = "cumuDate") String cumuDate);

    void deleteTmpData(@Param(value = "tmpTableName") String tmpTableName);

    int insertTmpLjz(List<TmpLjz> part);

    int updateIparaMtrPoint0();
    int updateTmpLjz0();
    int updateIparaMtrPoint1();
    int updateTmpLjz1();
}
