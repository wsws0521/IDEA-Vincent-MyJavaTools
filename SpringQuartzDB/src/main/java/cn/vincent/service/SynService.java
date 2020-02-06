package cn.vincent.service;

import cn.vincent.pojo.TmpYhChangedDw;
import cn.vincent.pojo.TmpYhChangedTariff;

import java.util.List;

public interface SynService {

    /**
     * 执行<同步1：运行时秘钥.txt>：费率方案、电压等级、管理单位
     */
    void executeSyn1(List<TmpYhChangedTariff> yhTariff, List<TmpYhChangedDw> yhDw);
    /**
     * 执行<同步2：表计秘钥.txt>：Vending表的vkId，ti
     */
    void executeSyn2();
    /**
     * 执行<同步3.1：用户.txt>：更新用户状态、插入新用户
     */
    void executeSyn3_1();
    /**
     * 执行<同步3.2：用户换表.txt>：更新表计状态、去除户表关联关系
     */
    void executeSyn3_2();
    /**
     * 执行<同步3.3：用户拆表.txt>：更新表计状态、去除户表关联关系
     */
    void executeSyn3_3();
    /**
     * 执行<同步4：表计.txt>：插入新表计、表计Vending表
     */
    void executeSyn4();
    /**
     * 执行<同步5.1：计量点.txt>：插入新计量点
     */
    void executeSyn5_1();
    /**
     * 执行<同步5.2：计量点设备与用户联系人.txt>：如题
     */
    void executeSyn5_2();
    /**
     * 执行<同步6：债务.txt>：更新债务，插入新债务、债务配置表
     */
    void executeSyn6();
    /**
     * 执行<同步7：累计值-数据融合.txt>：添加免费额度累计值
     */
    void executeSyn7();
    /**
     * 执行<同步8：step迁移>：方案待定
     */
    void executeSyn8();

}
