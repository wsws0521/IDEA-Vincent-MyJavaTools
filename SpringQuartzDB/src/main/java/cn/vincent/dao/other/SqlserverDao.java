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

    String queryMaxLastVendDate();

    List<TmpLjz> queryTmpLjz(@Param(value = "lastVendDate") String lastVendDate);
}
