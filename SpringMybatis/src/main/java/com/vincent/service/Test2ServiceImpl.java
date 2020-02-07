package com.vincent.service;

import com.vincent.dao.TestDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * 测试Service层与存储过程的事务嵌套，结论参照印象笔记
 * Java>>SpringBoot>>98 事务嵌套与管理
 */
@Service
public class Test2ServiceImpl implements Test2Service {
    @Resource
    TestDao testDao;



    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertTest1Idea() {
        System.out.println("tmp_test 插入前记录数：" + testDao.queryTableSize("tmp_test1"));
        int i = testDao.insertTest1("Idea", 2);
        String ss = null;
        BigDecimal bd = new BigDecimal(ss);
        System.out.println("tmp_test 插入后记录数：" + testDao.queryTableSize("tmp_test1"));
        return i;
    }
}
