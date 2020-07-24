package com.vincent.service;

import com.vincent.dao.TransactionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional(rollbackFor = Exception.class, isolation = Isolation.REPEATABLE_READ) // 支持重复读，避免了幻读，其他人插了提交了，我在他前后读到的结果是一致的
public class T1TransactionServiceImpl implements T1TransactionService {
    @Resource
    TransactionDao transactionDao;
    @Autowired
    T2TransactionService t2TransactionService;

    @Override
    public void vend() throws Exception {
        transactionDao.insertTest1("vincent", 30);
        transactionDao.insertTest1("simon", 28);
        System.out.println(transactionDao.queryTest1("simon")); // 一旦读操作，就会对整张表快照，后面·本事务之外·进行插操作，也只读到快照数据。
        t2TransactionService.insertNuwa();
        System.out.println(transactionDao.queryTest1("nuwa"));
        t2TransactionService.queryTest1();
    }
}
