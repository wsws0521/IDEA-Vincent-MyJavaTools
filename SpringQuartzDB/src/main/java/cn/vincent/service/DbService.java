package cn.vincent.service;

import cn.vincent.pojo.PthirdParty;
import cn.vincent.pojo.TariffGroup;

import java.util.List;

public interface DbService {
    /**
     * 外立面接口
     */
    void generalCall();

    // 执行脚本0.1将 tmp_bj1, tmp_yh1, tmp_zw1, tmp_ljz1 的后缀1改为年月日
    // 执行脚本0.2将 tmp_bj, tmp_yh, tmp_zw, tmp_ljz 后缀全部+1，再重新创建这几个空表
    void prepareTmp();
    // 依次将最新数据导入 tmp_bj, tmp_yh, tmp_zw, tmp_ljz
    void importTmpBj();
    void importTmpYh();
    void importTmpZw();
    void importTmpLjz();

    /**
     * 执行<脚本1：运行时秘钥.txt>：费率方案、电压等级、管理单位
     */
    void executeScript1();
    /**
     * 执行<脚本2：表计秘钥.txt>：Vending表的vkId，ti
     */
    void executeScript2();
    /**
     * 执行<脚本3.1：用户.txt>：更新用户状态、插入新用户
     */
    void executeScript3_1();
    /**
     * 执行<脚本3.2：用户换表.txt>：更新表计状态、去除户表关联关系
     */
    void executeScript3_2();
    /**
     * 执行<脚本3.3：用户拆表.txt>：更新表计状态、去除户表关联关系
     */
    void executeScript3_3();
    /**
     * 执行<脚本4：表计.txt>：插入新表计、表计Vending表
     */
    void executeScript4();
    /**
     * 执行<脚本5.1：计量点.txt>：插入新计量点
     */
    void executeScript5_1();
    /**
     * 执行<脚本5.2：计量点设备与用户联系人.txt>：如题
     */
    void executeScript5_2();
    /**
     * 执行<脚本6：债务.txt>：更新债务，插入新债务、债务配置表
     */
    void executeScript6();
    /**
     * 执行<脚本7：累计值-数据融合.txt>：添加免费额度累计值
     */
    void executeScript7();
    /**
     * 执行<脚本8：step迁移>：方案待定
     */
    void executeScript8();
}
