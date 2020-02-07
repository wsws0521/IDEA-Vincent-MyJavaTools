package cn.vincent.service;

import cn.vincent.dao.master.MysqlDao;
import cn.vincent.pojo.TmpLjzWithIdOld;
import cn.vincent.utils.MyDateUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;
@Service
public class SynCumuServiceImpl implements SynCumuService {
    @Resource
    MysqlDao mysqlDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void synLjzIntoVdCcumuValue(List<TmpLjzWithIdOld> tmpLjzList){
        for(TmpLjzWithIdOld tmpLjz : tmpLjzList){
            int mm = 0;
            if(tmpLjz.getISFREE() == 1){
                // FBE
                mm = modifyVdCcumuValue(
                        tmpLjz.getISFREE(),
                        tmpLjz.getConsId(),
                        new BigDecimal("50.00"),
                        MyDateUtils.getDateFromString(tmpLjz.getLASTVENDDATE()));
            }else if(tmpLjz.getISFREE() == 0){
                // Step
                if(tmpLjz.getMT_COMM_ADDR_old() != null){
                    // 同一天，执行2次同步，/ljz与ljz1属于同一天的数据
                    if(tmpLjz.getISUSED_old() == 1 && !tmpLjz.getEnergy().equals(tmpLjz.getEnergy_old())){
                        // 老的用了，与新的对比当天售电量不一致
                        BigDecimal newCumu = new BigDecimal(tmpLjz.getEnergy());
                        BigDecimal oldCumu = new BigDecimal(tmpLjz.getEnergy_old());
                        mm = modifyVdCcumuValue(
                                tmpLjz.getISFREE(),
                                tmpLjz.getMeterId(),
                                newCumu.subtract(oldCumu),
                                MyDateUtils.getDateFromString(tmpLjz.getLASTVENDDATE()));
                    }else if(tmpLjz.getISUSED_old() == 1 && tmpLjz.getEnergy().equals(tmpLjz.getEnergy_old())){
                        // 老的用了，与新的对比当天售电量一致，等于是已经同步了
                        mm = 1;
                    }else if(tmpLjz.getISUSED_old() == 0){
                        // 老的没有用进去，所以无视老的，直接累加最新的
                        mm = modifyVdCcumuValue(
                                tmpLjz.getISFREE(),
                                tmpLjz.getMeterId(),
                                new BigDecimal(tmpLjz.getEnergy()),
                                MyDateUtils.getDateFromString(tmpLjz.getLASTVENDDATE()));
                    }
                }else{
                    // 只需要考虑tmp_ljz中的最新数据即可
                    mm = modifyVdCcumuValue(
                            tmpLjz.getISFREE(),
                            tmpLjz.getMeterId(),
                            new BigDecimal(tmpLjz.getEnergy()),
                            MyDateUtils.getDateFromString(tmpLjz.getLASTVENDDATE()));
                }
            }
        }
    }

    private int modifyVdCcumuValue(int isFree, String cumuObjId, BigDecimal cumuValue, String cumuDate) {
        if(isFree == 1){
            int existNum = mysqlDao.queryExistCumu("01", cumuObjId, cumuDate);
            if(existNum == 1)
                return mysqlDao.updateFbeVdCcumuValue(cumuObjId, cumuValue, cumuDate);
            else if(existNum == 0)
                return mysqlDao.insertFbeVdCcumuValue(cumuObjId, cumuValue, cumuDate);
            else
                return 0;
        }else if(isFree == 0){
            int existNum = mysqlDao.queryExistCumu("03", cumuObjId, cumuDate);
            if(existNum == 1)
                return mysqlDao.updateStepVdCcumuValue(cumuObjId, cumuValue, cumuDate);
            else if(existNum == 0)
                return mysqlDao.insertStepVdCcumuValue(cumuObjId, cumuValue, cumuDate);
            else
                return 0;
        }else {
            return 0;
        }
    }
}
