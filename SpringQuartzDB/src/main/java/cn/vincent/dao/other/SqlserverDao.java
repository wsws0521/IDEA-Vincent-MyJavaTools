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

    List<TmpLjz> queryTmpLjzByDateStr(@Param(value = "cumuDate") String cumuDate);

    void deleteTmpData(@Param(value = "tmpTableName") String tmpTableName);

    int insertTmpLjz(List<TmpLjz> part);

    int updateIparaMtrPoint0();
    int updateTmpLjz0();
    int updateIparaMtrPoint1();
    int updateTmpLjz1();

    /**
     * 查询 (startdate, enddate] 之间的订单
     * @param startDate
     * @param endDate
     * @return
     */
    List<TmpSdjl> queryTmpSdjlByDateStr(@Param(value = "startDate") String startDate, @Param(value = "endDate") String endDate);
}
