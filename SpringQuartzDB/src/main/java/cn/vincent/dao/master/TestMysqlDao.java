package cn.vincent.dao.master;

import cn.vincent.pojo.ProcessParam;
import cn.vincent.pojo.PthirdParty;
import cn.vincent.pojo.TmpBj;
import cn.vincent.pojo.TmpInsert;

import java.util.List;

public interface TestMysqlDao {
    //    @Select("select * from p_third_party")
//    @Results({
//            @Result(property = "id",  column = "THIRD_PARTY_ID"),
//            @Result(property = "name", column = "THIRD_PARTY_NAME"),
//            @Result(property = "url", column = "INTERFACE_URL")
//    })
//    List<PthirdParty> queryMysqlCumu();
    List<PthirdParty> queryMysqlPthirdParty();


    int insertTmpInsert();

    int insertVincent();

    ProcessParam executeProc(ProcessParam processParam);

    Integer insertTempInsert(List<TmpInsert> tmpinsert);

    int insertTmpBjCopy(List<TmpBj> bjlist);
}
