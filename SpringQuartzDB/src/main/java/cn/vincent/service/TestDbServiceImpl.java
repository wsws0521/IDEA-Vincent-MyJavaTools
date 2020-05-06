package cn.vincent.service;

import cn.vincent.dao.master.TestMysqlDao;
import cn.vincent.dao.other.TestSqlserverDao;
import cn.vincent.pojo.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class TestDbServiceImpl implements TestDbService {
    @Resource
    TestMysqlDao testMysqlDao;
    @Resource
    TestSqlserverDao testSqlserverDao;

    @Override
    public List<PthirdParty> queryMysqlPthirdParty() {
        return testMysqlDao.queryMysqlPthirdParty();
    }

    @Override
    public List<TariffGroup> querySqlserverTariffGroup() {
        return testSqlserverDao.queryTariffGroup();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertRollback() {
        int i = testMysqlDao.insertTmpInsert();
        int j = testMysqlDao.insertVincent();
        return i+j;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ProcessParam executeProc() {
        ProcessParam processParam = new ProcessParam();
        testMysqlDao.executeProc(processParam);
        if(processParam.getError_code() != 0)
            throw new RuntimeException(processParam.getError_msg());
        return processParam;
    }

    @Override
    public int batchInsert() {
        List<TmpInsert> tmpinsert = testSqlserverDao.queryTmpTest();
        Integer i = testMysqlDao.insertTempInsert(tmpinsert);
        return i;
    }

    @Override
    public int testBatchQueryInsert() {
        List<TmpBj> bjList = testSqlserverDao.queryTmpBj();
        int insNum = 0;
        int limit = 500;
        int listSize = bjList.size();
        List<TmpBj> part = new ArrayList<TmpBj>(limit);
        for (int i = 0; i < listSize; i++) {
            part.add(bjList.get(i));
            if(limit == part.size() || i == listSize - 1){
                insNum  += testMysqlDao.insertTmpBjCopy(part);
                part.clear();
            }
        }
        return insNum;
    }

    @Override
    public void mysqlDropProc() {
        testMysqlDao.dropProc();
    }

    @Override
    public int queryDwAmt(String orgNo) {
        return testMysqlDao.queryDwAmt(orgNo);
    }
//
//    @Override
//    public void mysqlCreateProc() {
//        testMysqlDao.createProc();
//    }
}
