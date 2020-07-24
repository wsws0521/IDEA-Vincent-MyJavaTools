package com.vincent.service;

import com.vincent.dao.TransactionDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(rollbackFor = Exception.class)
public class T2TransactionServiceImpl implements T2TransactionService {
    @Resource
    TransactionDao transactionDao;

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED) // 将此方法独立于事务之外
    public void insertNuwa() {
        transactionDao.insertTest1("nuwa", 35);
    }

    @Override
    public void queryTest1() throws Exception {
        transactionDao.insertTest1("fuckfuck", 100);
        Integer age = transactionDao.queryTest1("nuwa");
        System.out.println(age);
        throw new Exception("草拟吗"); // 只有抛出去，才会触发回滚，自己try catch了就不会触发回滚
    }
}
