package cn.vincent.dao.master;

import cn.vincent.pojo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MysqlDao {

    int queryTmpCentlec(@Param(value = "sysDateString") String sysDateString);
    String queryCurStaus(@Param(value = "sysDateString") String sysDateString);
    int insertTmpCentlec(@Param(value = "sysDateString") String sysDateString, @Param(value = "result") String result);
    int updateTmpCentlec(@Param(value = "sysDateString") String sysDateString, @Param(value = "result") String result);

    void deleteTmpData(@Param(value = "tmpTableName") String tmpTableName);


    // 执行脚本0.1将 tmp_bj1, tmp_yh1, tmp_zw1, tmp_ljz1 的后缀1改为年月日
    ProcessParam prepareTmp1ToDate(ProcessParam processParam);
    // 执行脚本0.2将 tmp_bj, tmp_yh, tmp_zw, tmp_ljz 后缀全部+1，再重新创建这几个空表
    ProcessParam prepareTmpToTmp1(ProcessParam processParam);


    // 批量插入最新表计档案数据
    int insertTmpBj(List<TmpBj> list);

    // 批量插入最新用户档案数据
    int insertTmpYh(List<TmpYh> list);

    // 批量插入最新用户债务数据
    int insertTmpZw(List<TmpZw> list);

    // 查询上次同步数据中的最后售电日期
    String queryMaxLastVendDate();
    // 批量插入最新用户（免费额度）累计值数据
    int insertTmpLjz(List<TmpLjz> list);

    int queryTiChangedNum();
    List<TmpYhChangedTariff> queryYhWithTariffChanged();
    List<TmpYhChangedDw> queryYhWithDwChanged();
    ProcessParam executeScript1(ProcessParam processParam);
    int queryDwNullNum();
    int queryDwNullNumForMeter();

    List<TmpBjChangedVk> queryBjWithVkChanged();
    List<TmpBjChangedTi> queryBjWithTiChanged();
    ProcessParam executeScript2(ProcessParam processParam);

    List<TmpYhChangedStatus> queryYhWithStatusChanged();
    List<TmpYh> queryNewYh();
    ProcessParam executeScript3_1(ProcessParam processParam);

    List<TmpBjChangedCustid> queryBjWithCustidChanged();
    ProcessParam executeScript3_2(ProcessParam processParam);

    List<TmpBj> queryBjDeleted();
    ProcessParam executeScript3_3(ProcessParam processParam);

    ProcessParam executeScript4(ProcessParam processParam);

    ProcessParam executeScript5_1(ProcessParam processParam);

    ProcessParam executeScript5_2(ProcessParam processParam);

    ProcessParam executeScript5_3(ProcessParam processParam);

    ProcessParam executeScript6(ProcessParam processParam);

    ProcessParam executeScript7(ProcessParam processParam);

    int updateTmpWithNewIds();
    int updateTmpWithOldTmp();
    int updateEnergyByOldRows();
    // 插入阶梯累计
    int updateUsedInsertStep();
    int insertStepBatch();
    // 更新阶梯累计
    int updateUsedUpdateStep();
    int updateStepBatch();
    // 插入免费额度累计
    int updateUsedInsertFbe();
    int insertFbeBatch();
    // 更新免费额度累计(应该无数据)
    int updateUsedUpdateFbe();
    int updateFbeBatch();


//    int queryExistCumu(
//            @Param(value = "cumuObj") String cumuObj,
//            @Param(value = "cumuObjId") String cumuObjId,
//            @Param(value = "cumuDate") String cumuDate);
//    int insertFbeVdCcumuValue(
//            @Param(value = "consId") String consId,
//            @Param(value = "cumuValue") BigDecimal cumuValue,
//            @Param(value = "cumuDate") String cumuDate);
//    int insertStepVdCcumuValue(
//            @Param(value = "meterId") String meterId,
//            @Param(value = "cumuValue") BigDecimal cumuValue,
//            @Param(value = "cumuDate") String cumuDate);
//    int updateFbeVdCcumuValue(
//            @Param(value = "consId") String consId,
//            @Param(value = "cumuValue") BigDecimal cumuValue,
//            @Param(value = "cumuDate") String cumuDate);
//    int updateStepVdCcumuValue(
//            @Param(value = "meterId") String meterId,
//            @Param(value = "cumuValueOffset") BigDecimal cumuValueOffset,
//            @Param(value = "cumuDate") String cumuDate);
//
    List<TmpLjz> queryVdPtokenAsLjz(@Param(value = "cumuDate") String cumuDate);

    void insertTmpSdjl(List<TmpSdjl> part);

    ProcessParam executeScript_zz_3_1(ProcessParam processParam);
    ProcessParam executeScript_zz_3_2(ProcessParam processParam);
    ProcessParam executeScript_zz_3_3(ProcessParam processParam);
    ProcessParam executeScript_zz_3_4(ProcessParam processParam);
    ProcessParam executeScript_zz_3_5(ProcessParam processParam);
    ProcessParam executeScript_zz_3_6(ProcessParam processParam);
    ProcessParam executeScript_zz_3_7(ProcessParam processParam);
    ProcessParam executeScript_zz_3_8(ProcessParam processParam);
    ProcessParam executeScript_zz_3_9(ProcessParam processParam);
    ProcessParam executeScript_zz_3_10(ProcessParam processParam);
    ProcessParam executeScript_zz_3_11(ProcessParam processParam);
    ProcessParam executeScript_zz_3_12(ProcessParam processParam);
    ProcessParam executeScript_zz_3_13(ProcessParam processParam);

    int queryCumuAmt(@Param(value = "startDate") String startDate, @Param(value = "cumuItem") String cumuItem);

    int insertAconsumerSingle(@Param(value = "customerId") String customerId);

    int insertAconsumerContactsSingle(@Param(value = "customerId") String customerId);

    int insertAequipMeterSingle(@Param(value = "meterNo") String meterNo);

    int insertAequipMeterVendingSingle(@Param(value = "meterNo") String meterNo);

    int insertAusagePointSingle(@Param(value = "meterNo") String meterNo);

    int insertMpRelSingle(@Param(value = "meterNo") String meterNo);

    int insertCatalogSingle(@Param(value = "meterNo") String meterNo);
}
