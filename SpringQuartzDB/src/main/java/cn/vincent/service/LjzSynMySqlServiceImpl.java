package cn.vincent.service;

import cn.vincent.dao.master.MysqlDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class LjzSynMySqlServiceImpl implements LjzSynMySqlService {
    private static final Logger logger = LoggerFactory.getLogger(LjzSynMySqlServiceImpl.class);
    @Resource
    MysqlDao mysqlDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void synLjzIntoVdCcumuValue(){
        // 不考虑tmp_ljz1中的未使用记录
        int updateIdsRows = mysqlDao.updateTmpWithNewIds();
        logger.info(updateIdsRows + "条累计值获得了新系统表计ID、用户ID");
        int updateOldRows = mysqlDao.updateTmpWithOldTmp();
        logger.info(updateOldRows + "条累计值关联到老的tmp_ljz1");
        int updateEnergyByOldRows = mysqlDao.updateEnergyByOldRows();
        logger.info(updateEnergyByOldRows + "条累计值与老的tmp_ljz1未使用记录合并");

        // 购电阶梯·批量更新·累计值（必须先更新再插入，否则二者干扰）
        int updateUsedUpdateStep = mysqlDao.updateUsedUpdateStep();
        logger.info("[Step批量-更新]-[tmp_ljz]-置为已使用记录数：" + updateUsedUpdateStep);
        int updateStepBatch = mysqlDao.updateStepBatch();
        logger.info("[Step批量-更新]-[vd_c_cumu_value]-记录数：" + updateStepBatch);
        // 购电阶梯·批量插入·累计值
        int updateUsedInsertStep = mysqlDao.updateUsedInsertStep();
        logger.info("[Step批量-插入]-[tmp_ljz]-置为已使用记录数：" + updateUsedInsertStep);
        int insertStepBatch = mysqlDao.insertStepBatch();
        logger.info("[Step批量-插入]-[vd_c_cumu_value]-记录数：" + insertStepBatch);

        // 免费额度·批量更新·累计值（必须先更新再插入，否则二者干扰）
        int updateUsedUpdateFbe = mysqlDao.updateUsedUpdateFbe();
        logger.info("[FBE批量-更新]-[tmp_ljz]-置为已使用记录数：" + updateUsedUpdateFbe);
        int updateFbeBatch = mysqlDao.updateFbeBatch();
        logger.info("[FBE批量-更新]-[vd_c_cumu_value]-记录数：（理应为0）：" + updateFbeBatch);
        // 免费额度·批量插入·累计值
        int updateUsedInsertFbe = mysqlDao.updateUsedInsertFbe();
        logger.info("[FBE批量-插入]-[tmp_ljz]-置为已使用记录数：" + updateUsedInsertFbe);
        int insertFbeBatch = mysqlDao.insertFbeBatch();
        logger.info("[FBE批量-插入]-[vd_c_cumu_value]-记录数：" + insertFbeBatch);



//        List<TmpLjzWithIdOld> insertStep = mysqlDao.queryInsertStep();
//        logger.info("插入-阶梯累计值-数量：" + insertStep.size());
//        List<TmpLjzWithIdOld> updateStep = mysqlDao.queryUpdateStep();
//        logger.info("更新-阶梯累计值-数量：" + updateStep.size());
//        List<TmpLjzWithIdOld> insertFbe = mysqlDao.queryInsertFbe();
//        logger.info("插入-免费额度-数量：" + insertFbe.size());
//        List<TmpLjzWithIdOld> updateFbe = mysqlDao.queryUpdateFbe();
//        logger.info("更新-免费额度-数量：" + updateFbe.size());

//        for(TmpLjzWithIdOld tmpLjz : tmpLjzList){
//            int mm = 0;
//            if(tmpLjz.getISFREE() == 1){
//                // FBE
//                mm = modifyVdCcumuValue(
//                        tmpLjz.getISFREE(),
//                        tmpLjz.getConsId(),
//                        new BigDecimal("50.00"),
//                        MyDateUtils.getDateFromString(tmpLjz.getLASTVENDDATE()));
//            }else if(tmpLjz.getISFREE() == 0){
//                // Step
//                if(tmpLjz.getMT_COMM_ADDR_old() != null){
//                    // 同一天，执行2次同步，/ljz与ljz1属于同一天的数据
//                    if(tmpLjz.getISUSED_old() == 1 && !tmpLjz.getEnergy().equals(tmpLjz.getEnergy_old())){
//                        // 老的用了，与新的对比当天售电量不一致
//                        BigDecimal newCumu = new BigDecimal(tmpLjz.getEnergy());
//                        BigDecimal oldCumu = new BigDecimal(tmpLjz.getEnergy_old());
//                        mm = modifyVdCcumuValue(
//                                tmpLjz.getISFREE(),
//                                tmpLjz.getMeterId(),
//                                newCumu.subtract(oldCumu),
//                                MyDateUtils.getDateFromString(tmpLjz.getLASTVENDDATE()));
//                    }else if(tmpLjz.getISUSED_old() == 1 && tmpLjz.getEnergy().equals(tmpLjz.getEnergy_old())){
//                        // 老的用了，与新的对比当天售电量一致，等于是已经同步了
//                        mm = 1;
//                    }else if(tmpLjz.getISUSED_old() == 0){
//                        // 老的没有用进去，所以无视老的，直接累加最新的
//                        mm = modifyVdCcumuValue(
//                                tmpLjz.getISFREE(),
//                                tmpLjz.getMeterId(),
//                                new BigDecimal(tmpLjz.getEnergy()),
//                                MyDateUtils.getDateFromString(tmpLjz.getLASTVENDDATE()));
//                    }
//                }else{
//                    // 只需要考虑tmp_ljz中的最新数据即可
//                    mm = modifyVdCcumuValue(
//                            tmpLjz.getISFREE(),
//                            tmpLjz.getMeterId(),
//                            new BigDecimal(tmpLjz.getEnergy()),
//                            MyDateUtils.getDateFromString(tmpLjz.getLASTVENDDATE()));
//                }
//            }
//        }


    }

    private int modifyVdCcumuValue(int isFree, String cumuObjId, BigDecimal cumuValue, String cumuDate) {
//        if(isFree == 1){
//            int existNum = mysqlDao.queryExistCumu("01", cumuObjId, cumuDate);
//            if(existNum == 1)
//                return mysqlDao.updateFbeVdCcumuValue(cumuObjId, cumuValue, cumuDate);
//            else if(existNum == 0)
//                return mysqlDao.insertFbeVdCcumuValue(cumuObjId, cumuValue, cumuDate);
//            else
//                return 0;
//        }else if(isFree == 0){
//            int existNum = mysqlDao.queryExistCumu("03", cumuObjId, cumuDate);
//            if(existNum == 1)
//                return mysqlDao.updateStepVdCcumuValue(cumuObjId, cumuValue, cumuDate);
//            else if(existNum == 0)
//                return mysqlDao.insertStepVdCcumuValue(cumuObjId, cumuValue, cumuDate);
//            else
//                return 0;
//        }else {
//            return 0;
//        }
        return 0;
    }
}
