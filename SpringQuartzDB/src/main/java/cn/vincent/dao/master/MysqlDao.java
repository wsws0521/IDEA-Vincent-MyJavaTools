package cn.vincent.dao.master;

import cn.vincent.pojo.*;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MysqlDao {

    int queryTodayUnfinished();
    void deleteTmpData(@Param(value = "tmpTableName") String tmpTableName);

    // 执行脚本0.1将 tmp_bj1, tmp_yh1, tmp_zw1, tmp_ljz1 的后缀1改为年月日
    void prepareTmp1ToDate(ProcessParam processParam);
    // 执行脚本0.2将 tmp_bj, tmp_yh, tmp_zw, tmp_ljz 后缀全部+1，再重新创建这几个空表
    void prepareTmpToTmp1(ProcessParam processParam);

    // 批量插入最新表计档案数据
    int insertTmpBj(List<TmpBj> list);

    // 批量插入最新用户档案数据
    int insertTmpYh(List<TmpYh> list);

    // 批量插入最新用户债务数据
    int insertTmpZw(List<TmpZw> list);

    // 批量插入最新用户（免费额度）累计值数据
    int insertTmpLjz(List<TmpLjz> list);


    void executeScript1(ProcessParam processParam);

    void executeScript2(ProcessParam processParam);

    void executeScript3_1(ProcessParam processParam);

    void executeScript3_2(ProcessParam processParam);

    void executeScript3_3(ProcessParam processParam);

    void executeScript4(ProcessParam processParam);

    void executeScript5_1(ProcessParam processParam);

    void executeScript5_2(ProcessParam processParam);

    void executeScript6(ProcessParam processParam);

    void executeScript7(ProcessParam processParam);



//    void executeScript8();
}
