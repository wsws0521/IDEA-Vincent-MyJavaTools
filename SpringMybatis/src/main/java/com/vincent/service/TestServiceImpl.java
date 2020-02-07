package com.vincent.service;

import com.vincent.dao.TestDao;
import com.vincent.pojo.ProcParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * 测试Service层与存储过程的事务嵌套，结论参照印象笔记
 * Java>>SpringBoot>>98 事务嵌套与管理
 */
@Service
public class TestServiceImpl implements TestService {
    @Resource
    TestDao testDao;
    @Autowired
    Test2Service test2Service;
    @Override
//    @Transactional(rollbackFor = Exception.class)
    public void gggCall() {
        System.out.println("开始第一步");
        insertTest1Eclipse();
        System.out.println("开始第二步");
        exeProc();
        System.out.println("开始第三步");
//        insertTest1Idea();
        test2Service.insertTest1Idea();
    }

    @Override
    public int insertTest1Eclipse() {
        System.out.println("tmp_test 插入前记录数：" + testDao.queryTableSize("tmp_test1"));
        int i = testDao.insertTest1("eclipse", 1);
        System.out.println("tmp_test 插入后记录数：" + testDao.queryTableSize("tmp_test1"));
        return i;
    }

    @Override
    public void exeProc() {
        System.out.println("存储过程执行前记录数：" + testDao.queryTableSize("tmp_test1"));
//        ProcParam pp = new ProcParam();
//        testDao.exeProc2(pp);
//        if(pp.getError_code() != 0){
//            throw new RuntimeException("Fuuuuuck");
//        }
        System.out.println("存储过程执行后记录数：" + testDao.queryTableSize("tmp_test1"));
    }

    @Override
    public int insertTest1Idea() {
        System.out.println("tmp_test 插入前记录数：" + testDao.queryTableSize("tmp_test1"));
        int i = testDao.insertTest1("Idea", 2);
        String ss = null;
        BigDecimal bd = new BigDecimal(ss);
        System.out.println("tmp_test 插入后记录数：" + testDao.queryTableSize("tmp_test1"));
        return i;
    }
}
/*      《测试表》
    CREATE TABLE IF NOT EXISTS `tmp_test1` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `name` varchar(64),
        `status` int(11),
        PRIMARY KEY (`id`)
    ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;*/

   /*     《测试用存储过程：tmp_test2》
        BEGIN
        DECLARE t_error INTEGER DEFAULT 0;
        DECLARE msg text;
        # 定义SQL异常时将t_error置为1
        DECLARE CONTINUE HANDLER FOR SQLEXCEPTION
        begin
        get diagnostics condition 1 msg = message_text;
        set t_error = 1;
        end;
        -- 测试加索引是不是影响回滚
        # 0-索引
	    ALTER table tmp_test1 ADD INDEX index_tmp_test1_name(name);
        # 开启事务
        START TRANSACTION;
        savepoint tmp_test2;

        -- 【慎重】set autocommit = 0;

        -- 测试临时表是不是影响回滚
        CREATE TEMPORARY TABLE temp_bj SELECT 1, 2, 3 FROM dual;

        insert tmp_test1(name, status) values ('fuck', 0);
        -- select 1 from tmptmptmptmp;

        DROP TEMPORARY TABLE IF EXISTS temp_bj;

        IF t_error = 1 THEN
            ROLLBACK to savepoint tmp_test2;
        ELSE
            COMMIT;
        END IF;
        # 删除索引
	    ALTER table tmp_test1 DROP INDEX index_tmp_test1_name;

        SELECT t_error into error_code;
        SELECT msg into error_msg;

        END

        OUT `error_code` integer,OUT `error_msg` text
        */