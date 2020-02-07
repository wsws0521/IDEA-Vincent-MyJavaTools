package cn.vincent.service;


import cn.vincent.dao.master.MysqlDao;
import cn.vincent.dao.other.SqlserverDao;
import cn.vincent.pojo.*;
import cn.vincent.utils.MyDateUtils;
import cn.vincent.utils.StepConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class DbServiceImpl implements DbService {
    private static final Logger logger = LoggerFactory.getLogger(DbServiceImpl.class);
//    show VARIABLES LIKE '%max_allowed_packet%'
    private static final int LIMIT = 300;
    private static String SYS_DATE_STR = "";
    private static String CUR_STEP = "";

    @Resource
    MysqlDao mysqlDao;
    @Resource
    SqlserverDao sqlserverDao;
    @Autowired
    SynCumuService synCumuService;
    @Autowired
    SynLjzService synLjzService;

    @Override
    public void generalCall(){
        CUR_STEP = getCurStep();
        if(StepConstant.STEP_000_0.equals(CUR_STEP)){
            startFromPrepareTmp();
        }else if(StepConstant.STEP_000_1.equals(CUR_STEP)){
            startFromImportTmpBj();
        }else if(StepConstant.STEP_000_2.equals(CUR_STEP)){
            startFromImportTmpYh();
        }else if(StepConstant.STEP_000_3.equals(CUR_STEP)){
            startFromImportTmpZw();
        }else if(StepConstant.STEP_000_4.equals(CUR_STEP)){
            startFromImportTmpLjz();
        }else if(StepConstant.STEP_001.equals(CUR_STEP)){
            startFromScript1();
        }else if(StepConstant.STEP_002.equals(CUR_STEP)){
            startFromScript2();
        }else if(StepConstant.STEP_003_1.equals(CUR_STEP)){
            startFromScript3_1();
        }else if(StepConstant.STEP_003_2.equals(CUR_STEP)){
            startFromScript3_2();
        }else if(StepConstant.STEP_003_3.equals(CUR_STEP)){
            startFromScript3_3();
        }else if(StepConstant.STEP_004.equals(CUR_STEP)){
            startFromScript4();
        }else if(StepConstant.STEP_005_1.equals(CUR_STEP)){
            startFromScript5_1();
        }else if(StepConstant.STEP_005_2.equals(CUR_STEP)){
            startFromScript5_2();
        }else if(StepConstant.STEP_006.equals(CUR_STEP)){
            startFromScript6();
        }else if(StepConstant.STEP_007.equals(CUR_STEP)){
            startFromScript7();
        }else if(StepConstant.STEP_008.equals(CUR_STEP)){
            startFromScript8();
        }else if(StepConstant.STEP_009.equals(CUR_STEP)){
            terminalSyn();
        }else{

        }
    }
    private String getCurStep(){
        SYS_DATE_STR = MyDateUtils.getSysDate();
        int existNum = mysqlDao.queryTmpCentlec(SYS_DATE_STR);
        if(existNum == 1){
            String result = mysqlDao.queryCurStaus(SYS_DATE_STR);
            if(StringUtils.isEmpty(result))
                throw new RuntimeException("tmp_centlec表当天状态为空");
            else
                return result;
        }else if(existNum == 0){
            mysqlDao.insertTmpCentlec(SYS_DATE_STR, StepConstant.STEP_000_0);
            return StepConstant.STEP_000_0;
        }else{
            throw new RuntimeException("tmp_centlec表当天状态多条");
        }
    }

    @Override
    public void startFromPrepareTmp() {
        logger.info("000.0：归档-改表名");
        int updateNum = mysqlDao.updateTmpCentlec(SYS_DATE_STR, StepConstant.STEP_000_0);
        if(updateNum == 1){
            ProcessParam processParam = new ProcessParam();
            logger.info("执行归档脚本0.1将 tmp_bj1, tmp_yh1, tmp_zw1, tmp_ljz1 的后缀1改为年月日");
            mysqlDao.prepareTmp1ToDate(processParam);
            if(processParam.getError_code() != 0)
                throw new RuntimeException(processParam.getError_msg());
            logger.info("执行归档脚本0.2将 tmp_bj, tmp_yh, tmp_zw, tmp_ljz 后缀全部+1，再重新创建这几个空表");
            mysqlDao.prepareTmpToTmp1(processParam);
            if(processParam.getError_code() != 0)
                throw new RuntimeException(processParam.getError_msg());
        }else{
            throw new RuntimeException(SYS_DATE_STR + "状态记录数不正确");
        }
        startFromImportTmpBj();
    }

    @Override
    public void startFromImportTmpBj() {
        logger.info("000.1：获取最新表计档案 tmp_bj");
        int updateNum = mysqlDao.updateTmpCentlec(SYS_DATE_STR, StepConstant.STEP_000_1);
        if(updateNum == 1){
            mysqlDao.deleteTmpData("tmp_bj");
            List<TmpBj> tmpbj = sqlserverDao.queryTmpBj();
            logger.info("取到老系统最新[表计档案]个数：" + tmpbj.size());
            int insNum = 0;
            int listSize = tmpbj.size();
            List<TmpBj> part = new ArrayList<TmpBj>(LIMIT);
            for (int i = 0; i < listSize; i++) {
                part.add(tmpbj.get(i));
                if(LIMIT == part.size() || i == listSize - 1){
                    insNum  += mysqlDao.insertTmpBj(part);
                    part.clear();
                }
            }
            logger.info("插入到[tmp_bj]记录数：" + insNum);
            if(insNum != listSize)
                throw new RuntimeException("表计档案：取到的与插入的不相等");
            int bj1size = mysqlDao.queryTableSize("tmp_bj1");
            logger.info("上次同步的[表计档案]个数（tmp_bj1）：" + bj1size);
            int differ = tmpbj.size() - bj1size;
            logger.info("理论上本次将新增[表计档案]个数：" + differ);
            tmpbj.clear();
        }else{
            throw new RuntimeException(SYS_DATE_STR + "状态记录数不正确");
        }
        startFromImportTmpYh();
    }

    @Override
    public void startFromImportTmpYh() {
        logger.info("000.2：获取最新用户档案 tmp_yh");
        int updateNum = mysqlDao.updateTmpCentlec(SYS_DATE_STR, StepConstant.STEP_000_2);
        if(updateNum == 1){
            mysqlDao.deleteTmpData("tmp_yh");
            List<TmpYh> tmpyh = sqlserverDao.queryTmpYh();
            logger.info("取到最新的[用户档案]个数：" + tmpyh.size());
            int insNum = 0;
            int listSize = tmpyh.size();
            List<TmpYh> part = new ArrayList<TmpYh>(LIMIT);
            for (int i = 0; i < listSize; i++) {
                part.add(tmpyh.get(i));
                if(LIMIT == part.size() || i == listSize - 1){
                    insNum  += mysqlDao.insertTmpYh(part);
                    part.clear();
                }
            }
            logger.info("插入到[tmp_yh]记录数：" + insNum);
            if(insNum != listSize)
                throw new RuntimeException("用户档案：取到的与插入的不相等");
            int yh1size = mysqlDao.queryTableSize("tmp_yh1");
            logger.info("上次同步的[用户档案]个数（tmp_yh1）：" + yh1size);
            int differ = tmpyh.size() - yh1size;
            logger.info("理论上本次将新增[用户档案]个数：" + differ);
            tmpyh.clear();
        }else{
            throw new RuntimeException(SYS_DATE_STR + "状态记录数不正确");
        }
        startFromImportTmpZw();
    }

    @Override
    public void startFromImportTmpZw() {
        logger.info("000.3：获取最新债务档案 tmp_zw");
        int updateNum = mysqlDao.updateTmpCentlec(SYS_DATE_STR, StepConstant.STEP_000_3);
        if(updateNum == 1){
            mysqlDao.deleteTmpData("tmp_zw");
            List<TmpZw> tmpzw = sqlserverDao.queryTmpZw();
            logger.info("取到最新的[用户债务]个数：" + tmpzw.size());
            int insNum = 0;
            int listSize = tmpzw.size();
            List<TmpZw> part = new ArrayList<TmpZw>(LIMIT);
            for (int i = 0; i < listSize; i++) {
                part.add(tmpzw.get(i));
                if(LIMIT == part.size() || i == listSize - 1){
                    insNum  += mysqlDao.insertTmpZw(part);
                    part.clear();
                }
            }
            logger.info("插入到[tmp_zw]记录数：" + insNum);
            if(insNum != listSize)
                throw new RuntimeException("债务记录：取到的与插入的不相等");
            int zw1size = mysqlDao.queryTableSize("tmp_zw1");
            logger.info("上次同步的[债务个数（tmp_zw1）]：" + zw1size);
            int differ = tmpzw.size() - zw1size;
            logger.info("理论上本次将新增[债务]个数（债务主要是更新余额）：" + differ);
            tmpzw.clear();
        }else{
            throw new RuntimeException(SYS_DATE_STR + "状态记录数不正确");
        }
        startFromImportTmpLjz();
    }

    @Override
    public void startFromImportTmpLjz() {
        logger.info("000.4：获取最新免费累计值档案 tmp_ljz");
        int updateNum = mysqlDao.updateTmpCentlec(SYS_DATE_STR, StepConstant.STEP_000_4);
        if(updateNum == 1){
            mysqlDao.deleteTmpData("tmp_ljz");
            String cumuDate = MyDateUtils.getSysDateYestoday();
            logger.info("取" + cumuDate + "当天的累计值");
            List<TmpLjz> tmpljz = sqlserverDao.queryTmpLjzYestoday(cumuDate);
            logger.info("取到老库指定日期的[累计值]记录个数：" + tmpljz.size());
            int insNum = 0;
            int listSize = tmpljz.size();
            List<TmpLjz> part = new ArrayList<TmpLjz>(LIMIT);
            for (int i = 0; i < listSize; i++) {
                part.add(tmpljz.get(i));
                if(LIMIT == part.size() || i == listSize - 1){
                    insNum  += mysqlDao.insertTmpLjz(part);
                    part.clear();
                }
            }
            logger.info("插入到[tmp_ljz]记录数：" + insNum);
            if(insNum != listSize)
                throw new RuntimeException("免费累计值记录：取到的与插入的不相等");
            int ljz1size = mysqlDao.queryTableSize("tmp_ljz1");
            logger.info("上次同步的[累计值]个数（tmp_ljz1）：" + ljz1size);
            logger.info("理论上本次将新增[用户免费累计值]个数：" + tmpljz.size());
            tmpljz.clear();
        }else{
            throw new RuntimeException(SYS_DATE_STR + "状态记录数不正确");
        }
        startFromScript1();
    }

    /**
     * 执行<脚本1：运行时秘钥.txt>：费率方案、电压等级、管理单位
     */
    @Override
    public void startFromScript1() {
        logger.info("001：执行<脚本1：运行时秘钥.txt>：费率方案、电压等级、管理单位");
        int updateNum = mysqlDao.updateTmpCentlec(SYS_DATE_STR, StepConstant.STEP_001);
        if(updateNum == 1){
            // --------------------用户ti
            int tiChangedNum = mysqlDao.queryTiChangedNum();
            logger.info("用户ti变更记录数：" + tiChangedNum);
            if(tiChangedNum > 0)
                throw new RuntimeException("用户ti存在变更，需要特殊处理");
            // --------------------费率、电压
            List<TmpYhChangedTariff> yhWithTariffChanged = mysqlDao.queryYhWithTariffChanged();
            for(TmpYhChangedTariff yht : yhWithTariffChanged){
                logger.info(yht.getCUSTOMER_ID() + "的费率方案准备从" + yht.getTariffnameold() + "变为" + yht.getTARIFFNAME());
            }
            // --------------------单位
            List<TmpYhChangedDw> yhWithDwChanged = mysqlDao.queryYhWithDwChanged();
            for(TmpYhChangedDw yhd : yhWithDwChanged){
                logger.info(yhd.getCUSTOMER_ID() + "的单位准备从" + yhd.getStation_idold() + "变为" + yhd.getStation_id());
            }
            // --------------------同步
            ProcessParam processParam = new ProcessParam();
            mysqlDao.executeScript1(processParam);
            if(processParam.getError_code() != 0)
                throw new RuntimeException(processParam.getError_msg());
            if(mysqlDao.queryDwNullNum() > 0)
                logger.warn("注意：存在用户单位为空！");
            logger.info("--------------------------------------------" + StepConstant.STEP_001 + "同步完成");
        }else{
            throw new RuntimeException(SYS_DATE_STR + "状态记录数不正确");
        }
        startFromScript2();
    }

    /**
     * 执行<脚本2：表计秘钥.txt>：Vending表的vkId，ti
     */
    @Override
    public void startFromScript2() {
        logger.info("002：执行<脚本2：表计秘钥.txt>：Vending表的vkId，ti");
        int updateNum = mysqlDao.updateTmpCentlec(SYS_DATE_STR, StepConstant.STEP_002);
        if(updateNum == 1){
            // --------------------表计vk
            List<TmpBjChangedVk> bjWithVkChanged = mysqlDao.queryBjWithVkChanged();
            for(TmpBjChangedVk bjVk : bjWithVkChanged){
                logger.info(bjVk.getMT_COMM_ADDR() + "的sgc准备从" + bjVk.getMus_sgcidold() + "变为" + bjVk.getMUS_SGCID());
            }
            // --------------------表计ti
            List<TmpBjChangedTi> bjWithTiChanged = mysqlDao.queryBjWithTiChanged();
            for(TmpBjChangedTi bjTi : bjWithTiChanged){
                logger.info(bjTi.getMT_COMM_ADDR() + "的ti准备从" + bjTi.getMus_tiold() + "变为" + bjTi.getMUS_TI());
            }
            // --------------------同步
            ProcessParam processParam = new ProcessParam();
            mysqlDao.executeScript2(processParam);
            if(processParam.getError_code() != 0)
                throw new RuntimeException(processParam.getError_msg());
            logger.info("--------------------------------------------" + StepConstant.STEP_002 + "同步完成");
        }else{
            throw new RuntimeException(SYS_DATE_STR + "状态记录数不正确");
        }
        startFromScript3_1();
    }

    /**
     * 执行<脚本3.1：用户.txt>：更新用户状态、插入新用户
     */
    @Override
    public void startFromScript3_1() {
        logger.info("003.1：执行<脚本3.1：用户.txt>：更新用户状态、插入新用户");
        int updateNum = mysqlDao.updateTmpCentlec(SYS_DATE_STR, StepConstant.STEP_003_1);
        if(updateNum == 1){
            // --------------------用户状态
            List<TmpYhChangedStatus> yhWithStatusChanged = mysqlDao.queryYhWithStatusChanged();
            logger.info("以下用户变更了状态：" + yhWithStatusChanged);
            for(TmpYhChangedStatus yhs : yhWithStatusChanged){
                logger.info(yhs.getCUSTOMER_ID() + "的状态准备从" + yhs.getStatusold() + "变为" + yhs.getSTATUS());
            }
            // --------------------新用户
            List<TmpYh> newYh = mysqlDao.queryNewYh();
            for(TmpYh yh : newYh){
                logger.info("准备新开用户id-name：" + yh.getCUSTOMER_ID() + "-" + yh.getCustomer_name());
            }
            // --------------------当前a_consumer数量
            logger.info("同步前用户数：" + mysqlDao.queryTableSize("a_consumer"));
            // --------------------同步
            ProcessParam processParam = new ProcessParam();
            mysqlDao.executeScript3_1(processParam);
            if(processParam.getError_code() != 0)
                throw new RuntimeException(processParam.getError_msg());
            // --------------------同步后a_consumer数量
            logger.info("同步后用户数：" + mysqlDao.queryTableSize("a_consumer"));
            logger.info("--------------------------------------------" + StepConstant.STEP_003_1 + "同步完成");
        }else{
            throw new RuntimeException(SYS_DATE_STR + "状态记录数不正确");
        }
        startFromScript3_2();
    }

    /**
     * 执行<脚本3.2：用户换表.txt>：更新表计状态、去除户表关联关系
     */
    @Override
    public void startFromScript3_2() {
        logger.info("003.2：执行<脚本3.2：用户换表.txt>：更新表计状态、去除户表关联关系");
        int updateNum = mysqlDao.updateTmpCentlec(SYS_DATE_STR, StepConstant.STEP_003_2);
        if(updateNum == 1){
            // --------------------表计变更了所属用户
            List<TmpBjChangedCustid> bjWithCustidChanged = mysqlDao.queryBjWithCustidChanged();
            for(TmpBjChangedCustid bjYh : bjWithCustidChanged){
                logger.info("表计：" + bjYh.getMT_COMM_ADDR() + "准备变更用户从" + bjYh.getCustomer_idold() + "到" + bjYh.getCUSTOMER_ID());
            }
            // --------------------同步
            ProcessParam processParam = new ProcessParam();
            mysqlDao.executeScript3_2(processParam);
            if(processParam.getError_code() != 0)
                throw new RuntimeException(processParam.getError_msg());
            logger.info("--------------------------------------------" + StepConstant.STEP_003_2 + "同步完成");
        }else{
            throw new RuntimeException(SYS_DATE_STR + "状态记录数不正确");
        }
        startFromScript3_3();
    }

    /**
     * 执行<脚本3.3：用户拆表.txt>：更新表计状态、去除户表关联关系
     */
    @Override
    public void startFromScript3_3() {
        logger.info("003.3：执行<脚本3.3：用户拆表.txt>：更新表计状态、去除户表关联关系");
        int updateNum = mysqlDao.updateTmpCentlec(SYS_DATE_STR, StepConstant.STEP_003_3);
        if(updateNum == 1){
            // --------------------被强制删除的表计（乔磊的工具）
            List<TmpBj> bjDeleted = mysqlDao.queryBjDeleted();
            for(TmpBj bj : bjDeleted){
                logger.info("被强制删除的表计（乔磊的工具）：" + bj.getMT_COMM_ADDR());
            }
            // --------------------同步
            ProcessParam processParam = new ProcessParam();
            mysqlDao.executeScript3_3(processParam);
            if(processParam.getError_code() != 0)
                throw new RuntimeException(processParam.getError_msg());
            logger.info("--------------------------------------------" + StepConstant.STEP_003_3 + "同步完成");
        }else{
            throw new RuntimeException(SYS_DATE_STR + "状态记录数不正确");
        }
        startFromScript4();
    }

    /**
     * 执行<脚本4：表计.txt>：插入新表计、表计Vending表
     */
    @Override
    public void startFromScript4() {
        logger.info("004：执行<脚本4：表计.txt>：插入新表计、表计Vending表");
        int updateNum = mysqlDao.updateTmpCentlec(SYS_DATE_STR, StepConstant.STEP_004);
        if(updateNum == 1){
            // --------------------当前a_equip_meter数量
            logger.info("同步前a_equip_meter数量：" + mysqlDao.queryTableSize("a_equip_meter"));
            // --------------------同步
            ProcessParam processParam = new ProcessParam();
            mysqlDao.executeScript4(processParam);
            if(processParam.getError_code() != 0)
                throw new RuntimeException(processParam.getError_msg());
            // --------------------同步后a_equip_meter数量
            logger.info("同步后a_equip_meter数量：" + mysqlDao.queryTableSize("a_equip_meter"));
            logger.info("--------------------------------------------" + StepConstant.STEP_004 + "同步完成");
        }else{
            throw new RuntimeException(SYS_DATE_STR + "状态记录数不正确");
        }
        startFromScript5_1();
    }

    /**
     * 执行<脚本5.1：计量点.txt>：插入新计量点
     */
    @Override
    public void startFromScript5_1() {
        logger.info("005.1：执行<脚本5.1：计量点.txt>：插入新计量点");
        int updateNum = mysqlDao.updateTmpCentlec(SYS_DATE_STR, StepConstant.STEP_005_1);
        if(updateNum == 1){
            // --------------------当前a_usagepoint数量
            logger.info("当前a_usagepoint数量：" + mysqlDao.queryTableSize("a_usagepoint"));
            // --------------------同步
            ProcessParam processParam = new ProcessParam();
            mysqlDao.executeScript5_1(processParam);
            if(processParam.getError_code() != 0)
                throw new RuntimeException(processParam.getError_msg());
            // --------------------同步后a_usagepoint数量
            logger.info("同步后a_usagepoint数量：" + mysqlDao.queryTableSize("a_usagepoint"));
            logger.info("--------------------------------------------" + StepConstant.STEP_005_1 + "同步完成");
        }else{
            throw new RuntimeException(SYS_DATE_STR + "状态记录数不正确");
        }
        startFromScript5_2();
    }

    /**
     * 执行<脚本5.2：计量点设备与用户联系人.txt>：如题
     */
    @Override
    public void startFromScript5_2() {
        logger.info("005.2：执行<脚本5.2：计量点设备与用户联系人.txt>：如题");
        int updateNum = mysqlDao.updateTmpCentlec(SYS_DATE_STR, StepConstant.STEP_005_2);
        if(updateNum == 1){
            // --------------------当前a_mp_equipment_rela数量
            logger.info("当前a_mp_equipment_rela数量：" + mysqlDao.queryTableSize("a_mp_equipment_rela"));
            // --------------------同步
            ProcessParam processParam = new ProcessParam();
            mysqlDao.executeScript5_2(processParam);
            if(processParam.getError_code() != 0)
                throw new RuntimeException(processParam.getError_msg());
            // --------------------同步后a_mp_equipment_rela数量
            logger.info("同步后a_mp_equipment_rela数量：" + mysqlDao.queryTableSize("a_mp_equipment_rela"));
            logger.info("--------------------------------------------" + StepConstant.STEP_005_2 + "同步完成");
        }else{
            throw new RuntimeException(SYS_DATE_STR + "状态记录数不正确");
        }
        startFromScript6();
    }

    /**
     * 执行<脚本6：债务.txt>：更新债务，插入新债务、债务配置表
     */
    @Override
    public void startFromScript6() {
        logger.info("006：执行<脚本6：债务.txt>：更新债务，插入新债务、债务配置表");
        int updateNum = mysqlDao.updateTmpCentlec(SYS_DATE_STR, StepConstant.STEP_006);
        if(updateNum == 1){
            // --------------------同步
            ProcessParam processParam = new ProcessParam();
            mysqlDao.executeScript6(processParam);
            if(processParam.getError_code() != 0)
                throw new RuntimeException(processParam.getError_msg());
            logger.info("同步债务结束");
            logger.info("--------------------------------------------" + StepConstant.STEP_006 + "同步完成");
        }else{
            throw new RuntimeException(SYS_DATE_STR + "状态记录数不正确");
        }
        startFromScript7();
    }

    /**
     * 执行<程序7：累计值-往新库融合.txt>：往新库
     */
    @Override
    public void startFromScript7() {
        logger.info("007：执行<程序7：累计值-往新库融合.txt>：往新库");
        int updateNum = mysqlDao.updateTmpCentlec(SYS_DATE_STR, StepConstant.STEP_007);
        if(updateNum == 1){
            // --------------------同步
            List<TmpLjzWithIdOld> tmpLjzList = mysqlDao.queryTmpLjzWithIdOld();
            synCumuService.synLjzIntoVdCcumuValue(tmpLjzList);
            logger.info("--------------------------------------------" + StepConstant.STEP_007 + "同步完成");
        }else{
            throw new RuntimeException(SYS_DATE_STR + "状态记录数不正确");
        }
        startFromScript8();
    }

    /**
     * 执行<程序8：累计值-往老库融合.txt>：往老库
     */
    @Override
    public void startFromScript8() {
        logger.info("008: 执行<程序8：累计值-往老库融合.txt>：往老库");
        int updateNum = mysqlDao.updateTmpCentlec(SYS_DATE_STR, StepConstant.STEP_008);
        if(updateNum == 1){
            String cumuDate = MyDateUtils.getSysDateYestoday();
            logger.info("取" + cumuDate + "当天的累计值");
            List<TmpLjz> tmpljzList = mysqlDao.queryTmpLjzYestoday(cumuDate);
            logger.info("取到新库指定日期的[累计值]记录个数：" + tmpljzList.size());
            synLjzService.synVdCcumuValueIntoLjz(tmpljzList);
            logger.info("--------------------------------------------" + StepConstant.STEP_008 + "同步完成");
        }else{
            throw new RuntimeException(SYS_DATE_STR + "状态记录数不正确");
        }
        terminalSyn();
    }

    @Override
    public void terminalSyn() {
        logger.info("009: 正常结束");
        int updateNum = mysqlDao.updateTmpCentlec(SYS_DATE_STR, StepConstant.STEP_009);
        if(updateNum == 1){
            int terminatNum =  mysqlDao.updateTmpCentlec(SYS_DATE_STR, StepConstant.STEP_999);
            logger.info("本次同步过程正常结束，将tmp_centlec表的执行状态置为999，共更新：" + terminatNum);
        }else{
            throw new RuntimeException(SYS_DATE_STR + "状态记录数不正确");
        }
    }
}
