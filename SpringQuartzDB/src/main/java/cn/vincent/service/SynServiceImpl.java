package cn.vincent.service;

import cn.vincent.dao.master.MysqlSynDao;
import cn.vincent.pojo.TmpYhChangedDw;
import cn.vincent.pojo.TmpYhChangedTariff;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 将存储过程转移至Service，使得过程更容易追踪
 */
@Service
public class SynServiceImpl implements SynService {
    @Resource
    MysqlSynDao mysqlSynDao;
    /**
     * 执行<同步1：运行时秘钥.txt>：费率方案、电压等级、管理单位
     */
    @Override
    public void executeSyn1(List<TmpYhChangedTariff> yhTariff, List<TmpYhChangedDw> yhDw) {
        // ----------------索引
        mysqlSynDao.addIndex("vd_e_bill_package", "index_vd_e_bill_package_pkgname", "pkg_name");
        int indexYhTariff = mysqlSynDao.queryExistsIndex("tmp_yh", "index_yh_tariffname");
        if(indexYhTariff == 0){
            mysqlSynDao.addIndex("tmp_yh", "index_yh_tariffname", "tariffname");
        }
        int indexYh1Tariff = mysqlSynDao.queryExistsIndex("tmp_yh1", "index_yh_tariffname");
        if(indexYh1Tariff == 0){
            mysqlSynDao.addIndex("tmp_yh1", "index_yh_tariffname", "tariffname");
        }
    }

    /**
     * 执行<同步2：表计秘钥.txt>：Vending表的vkId，ti
     */
    @Override
    public void executeSyn2() {

    }

    /**
     * 执行<同步3.1：用户.txt>：更新用户状态、插入新用户
     */
    @Override
    public void executeSyn3_1() {

    }

    /**
     * 执行<同步3.2：用户换表.txt>：更新表计状态、去除户表关联关系
     */
    @Override
    public void executeSyn3_2() {

    }

    /**
     * 执行<同步3.3：用户拆表.txt>：更新表计状态、去除户表关联关系
     */
    @Override
    public void executeSyn3_3() {

    }

    /**
     * 执行<同步4：表计.txt>：插入新表计、表计Vending表
     */
    @Override
    public void executeSyn4() {

    }

    /**
     * 执行<同步5.1：计量点.txt>：插入新计量点
     */
    @Override
    public void executeSyn5_1() {

    }

    /**
     * 执行<同步5.2：计量点设备与用户联系人.txt>：如题
     */
    @Override
    public void executeSyn5_2() {

    }

    /**
     * 执行<同步6：债务.txt>：更新债务，插入新债务、债务配置表
     */
    @Override
    public void executeSyn6() {

    }

    /**
     * 执行<同步7：累计值-数据融合.txt>：添加免费额度累计值
     */
    @Override
    public void executeSyn7() {

    }

    /**
     * 执行<同步8：step迁移>：方案待定
     */
    @Override
    public void executeSyn8() {

    }
}
