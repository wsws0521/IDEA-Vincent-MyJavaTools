package cn.vincent.service;


import cn.vincent.dao.master.MysqlDao;
import cn.vincent.dao.other.SqlserverDao;
import cn.vincent.pojo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class DbServiceImpl implements DbService {
    private static final Logger logger = LoggerFactory.getLogger(DbServiceImpl.class);
    private static final int LIMIT = 500;

    @Resource
    MysqlDao mysqlDao;
    @Resource
    SqlserverDao sqlserverDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void generalCall(){
        logger.info("000.0：归档-改表名");
        prepareTmp();
        logger.info("000.1：获取最新表计档案 tmp_bj");
        importTmpBj();
        logger.info("000.2：获取最新用户档案 tmp_yh");
        importTmpYh();
        logger.info("000.3：获取最新债务档案 tmp_zw");
        importTmpZw();
        logger.info("000.4：获取最新免费累计值档案 tmp_ljz");
        importTmpLjz();

        logger.info("001：执行<脚本1：运行时秘钥.txt>：费率方案、电压等级、管理单位");
        executeScript1();
        logger.info("002：执行<脚本2：表计秘钥.txt>：Vending表的vkId，ti");
        executeScript2();
        logger.info("003.1：执行<脚本3.1：用户.txt>：更新用户状态、插入新用户");
        executeScript3_1();
        logger.info("003.2：执行<脚本3.2：用户换表.txt>：更新表计状态、去除户表关联关系");
        executeScript3_2();
        logger.info("003.3：执行<脚本3.3：用户拆表.txt>：更新表计状态、去除户表关联关系");
        executeScript3_3();
        logger.info("004：执行<脚本4：表计.txt>：插入新表计、表计Vending表");
        executeScript4();
        logger.info("005.1：执行<脚本5.1：计量点.txt>：插入新计量点");
        executeScript5_1();
        logger.info("005.2：执行<脚本5.2：计量点设备与用户联系人.txt>：如题");
        executeScript5_2();
        logger.info("006：执行<脚本6：债务.txt>：更新债务，插入新债务、债务配置表");
        executeScript6();
        logger.info("007：执行<脚本7：累计值-数据融合.txt>：添加免费额度累计值");
        executeScript7();
        logger.info("008: to be continue");
//        void executeScript8();
    }



    @Override
    public void prepareTmp() {
        // 查询当天是否有未关闭的同步流程，若存在，则跳过归档直接抓取最新数据，否则表名+日期的归档规则冲突
        int todayUnfinished = mysqlDao.queryTodayUnfinished();
        if(todayUnfinished > 0){
            logger.info("今日存在未正常关闭的同步流程， 跳过归档直接获取最新数据进行同步");
        }else{
            ProcessParam processParam = new ProcessParam();
            logger.info("执行归档脚本0.1将 tmp_bj1, tmp_yh1, tmp_zw1, tmp_ljz1 的后缀1改为年月日");
            mysqlDao.prepareTmp1ToDate(processParam);
            if(processParam.getError_code() != 0)
                throw new RuntimeException(processParam.getError_msg());
            logger.info("执行归档脚本0.2将 tmp_bj, tmp_yh, tmp_zw, tmp_ljz 后缀全部+1，再重新创建这几个空表");
            mysqlDao.prepareTmpToTmp1(processParam);
            if(processParam.getError_code() != 0)
                throw new RuntimeException(processParam.getError_msg());
        }
    }

    @Override
    public void importTmpBj() {
        mysqlDao.deleteTmpData("tmp_bj");
        List<TmpBj> tmpbj = sqlserverDao.queryTmpBj();
        logger.info("取到最新的*表计档案*个数：" + tmpbj.size());
        int insNum = 0;
        int listSize = tmpbj.size();
        List<TmpBj> part = new ArrayList<TmpBj>(LIMIT);
        for (int i = 0; i < listSize; i++) {
            part.add(tmpbj.get(i));
            if(LIMIT == part.size() || i == listSize - 1){
                insNum  += mysqlDao.insertTmpBj(tmpbj);
                part.clear();
            }
        }
        logger.info("插入到tmp_bj记录数：" + insNum);
        if(insNum != listSize)
            throw new RuntimeException("表计档案：取到的与插入的不相等");
    }

    @Override
    public void importTmpYh() {
        mysqlDao.deleteTmpData("tmp_yh");
        List<TmpYh> tmpyh = sqlserverDao.queryTmpYh();
        logger.info("取到最新的*用户档案*个数：" + tmpyh.size());
        int insNum = 0;
        int listSize = tmpyh.size();
        List<TmpYh> part = new ArrayList<TmpYh>(LIMIT);
        for (int i = 0; i < listSize; i++) {
            part.add(tmpyh.get(i));
            if(LIMIT == part.size() || i == listSize - 1){
                insNum  += mysqlDao.insertTmpYh(tmpyh);
                part.clear();
            }
        }
        logger.info("插入到tmp_yh记录数：" + insNum);
        if(insNum != listSize)
            throw new RuntimeException("用户档案：取到的与插入的不相等");
    }

    @Override
    public void importTmpZw() {
        mysqlDao.deleteTmpData("tmp_zw");
        List<TmpZw> tmpzw = sqlserverDao.queryTmpZw();
        logger.info("取到最新的*用户债务*个数：" + tmpzw.size());
        int insNum = 0;
        int listSize = tmpzw.size();
        List<TmpZw> part = new ArrayList<TmpZw>(LIMIT);
        for (int i = 0; i < listSize; i++) {
            part.add(tmpzw.get(i));
            if(LIMIT == part.size() || i == listSize - 1){
                insNum  += mysqlDao.insertTmpZw(tmpzw);
                part.clear();
            }
        }
        logger.info("插入到tmp_zw记录数：" + insNum);
        if(insNum != listSize)
            throw new RuntimeException("债务记录：取到的与插入的不相等");
    }

    @Override
    public void importTmpLjz() {
        mysqlDao.deleteTmpData("tmp_ljz");
        String lastVendDate = sqlserverDao.queryMaxLastVendDate();
        logger.info("免费额度累计值截取开始时间：" + lastVendDate);
        List<TmpLjz> tmpljz = sqlserverDao.queryTmpLjz(lastVendDate);
        logger.info("取到最新的*免费额度*记录个数：" + tmpljz.size());
        int insNum = 0;
        int listSize = tmpljz.size();
        List<TmpLjz> part = new ArrayList<TmpLjz>(LIMIT);
        for (int i = 0; i < listSize; i++) {
            part.add(tmpljz.get(i));
            if(LIMIT == part.size() || i == listSize - 1){
                insNum  += mysqlDao.insertTmpLjz(tmpljz);
                part.clear();
            }
        }
        logger.info("插入到tmp_ljz记录数：" + insNum);
        if(insNum != listSize)
            throw new RuntimeException("免费累计值记录：取到的与插入的不相等");
    }

    /**
     * 执行<脚本1：运行时秘钥.txt>：费率方案、电压等级、管理单位
     */
    @Override
    public void executeScript1() {
        logger.info("执行<脚本1：运行时秘钥.txt>：费率方案、电压等级、管理单位");
        ProcessParam processParam = new ProcessParam();
        mysqlDao.executeScript1(processParam);
        if(processParam.getError_code() != 0)
            throw new RuntimeException(processParam.getError_msg());
    }

    /**
     * 执行<脚本2：表计秘钥.txt>：Vending表的vkId，ti
     */
    @Override
    public void executeScript2() {
        logger.info("执行<脚本2：表计秘钥.txt>：Vending表的vkId，ti");
        ProcessParam processParam = new ProcessParam();
        mysqlDao.executeScript2(processParam);
        if(processParam.getError_code() != 0)
            throw new RuntimeException(processParam.getError_msg());
    }

    /**
     * 执行<脚本3.1：用户.txt>：更新用户状态、插入新用户
     */
    @Override
    public void executeScript3_1() {
        logger.info("执行<脚本3.1：用户.txt>：更新用户状态、插入新用户");
        ProcessParam processParam = new ProcessParam();
        mysqlDao.executeScript3_1(processParam);
        if(processParam.getError_code() != 0)
            throw new RuntimeException(processParam.getError_msg());
    }

    /**
     * 执行<脚本3.2：用户换表.txt>：更新表计状态、去除户表关联关系
     */
    @Override
    public void executeScript3_2() {
        logger.info("执行<脚本3.2：用户换表.txt>：更新表计状态、去除户表关联关系");
        ProcessParam processParam = new ProcessParam();
        mysqlDao.executeScript3_2(processParam);
        if(processParam.getError_code() != 0)
            throw new RuntimeException(processParam.getError_msg());
    }

    /**
     * 执行<脚本3.3：用户拆表.txt>：更新表计状态、去除户表关联关系
     */
    @Override
    public void executeScript3_3() {
        logger.info("执行<脚本3.3：用户拆表.txt>：更新表计状态、去除户表关联关系");
        ProcessParam processParam = new ProcessParam();
        mysqlDao.executeScript3_3(processParam);
        if(processParam.getError_code() != 0)
            throw new RuntimeException(processParam.getError_msg());
    }

    /**
     * 执行<脚本4：表计.txt>：插入新表计、表计Vending表
     */
    @Override
    public void executeScript4() {
        logger.info("执行<脚本4：表计.txt>：插入新表计、表计Vending表");
        ProcessParam processParam = new ProcessParam();
        mysqlDao.executeScript4(processParam);
        if(processParam.getError_code() != 0)
            throw new RuntimeException(processParam.getError_msg());
    }

    /**
     * 执行<脚本5.1：计量点.txt>：插入新计量点
     */
    @Override
    public void executeScript5_1() {
        logger.info("执行<脚本5.1：计量点.txt>：插入新计量点");
        ProcessParam processParam = new ProcessParam();
        mysqlDao.executeScript5_1(processParam);
        if(processParam.getError_code() != 0)
            throw new RuntimeException(processParam.getError_msg());
    }

    /**
     * 执行<脚本5.2：计量点设备与用户联系人.txt>：如题
     */
    @Override
    public void executeScript5_2() {
        logger.info("执行<脚本5.2：计量点设备与用户联系人.txt>：如题");
        ProcessParam processParam = new ProcessParam();
        mysqlDao.executeScript5_2(processParam);
        if(processParam.getError_code() != 0)
            throw new RuntimeException(processParam.getError_msg());
    }

    /**
     * 执行<脚本6：债务.txt>：更新债务，插入新债务、债务配置表
     */
    @Override
    public void executeScript6() {
        logger.info("执行<脚本6：债务.txt>：更新债务，插入新债务、债务配置表");
        ProcessParam processParam = new ProcessParam();
        mysqlDao.executeScript6(processParam);
        if(processParam.getError_code() != 0)
            throw new RuntimeException(processParam.getError_msg());
    }

    /**
     * 执行<脚本7：累计值-数据融合.txt>：添加免费额度累计值
     */
    @Override
    public void executeScript7() {
        logger.info("执行<脚本7：累计值-数据融合.txt>：添加免费额度累计值");
        ProcessParam processParam = new ProcessParam();
        mysqlDao.executeScript7(processParam);
        if(processParam.getError_code() != 0)
            throw new RuntimeException(processParam.getError_msg());
    }

    /**
     * 执行<脚本8：step迁移>：方案待定
     */
    @Override
    public void executeScript8() {
        logger.info("执行<脚本8：step迁移>：方案待定");
//        ProcessParam processParam = new ProcessParam();
//        mysqlDao.executeScript8(processParam);
//        if(processParam.getError_code() != 0)
//            throw new RuntimeException(processParam.getError_msg());
    }
}
