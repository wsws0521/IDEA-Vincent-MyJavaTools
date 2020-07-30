package cn.vincent.service;

import cn.vincent.dao.master.MysqlDao;
import cn.vincent.dao.master.MysqlToolDao;
import cn.vincent.dao.other.SqlserverDao;
import cn.vincent.pojo.*;
import cn.vincent.utils.MyDateUtils;
import cn.vincent.utils.StepConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SingleCallServiceImpl implements SingleCallService {
    private static final Logger logger = LoggerFactory.getLogger(SingleCallServiceImpl.class);
    private static final int LIMIT = 300;

    @Resource
    MysqlDao mysqlDao;
    @Resource
    MysqlToolDao mysqlToolDao;
    @Resource
    SqlserverDao sqlserverDao;
    @Autowired
    LjzSynMySqlService ljzSynMySqlService;
    @Autowired
    ToolService toolService;
    @Autowired
    IndexService indexService;

    @Override
    public String callSynSinleArchive(String meterNo) {
        int checkExistNum = mysqlToolDao.queryInTmpBj(meterNo);
        if(checkExistNum == 0){
            logger.info("最新tmp_bj中不存在该表，开始同步：" + meterNo);

            logger.info("1-查询该表信息");
            List<TmpBj> singleTmpBj = sqlserverDao.queryTmpBjByMeterNo(meterNo);
            if(singleTmpBj.size() == 1){
                logger.info("2-将该表插入最新的tmp_bj:" + mysqlDao.insertTmpBj(singleTmpBj));

                logger.info("3-查询该表对应用户信息");
                List<TmpYh> singleTmpYh = sqlserverDao.queryTmpYhByCustId(singleTmpBj.get(0).getCUSTOMER_ID());
                if(singleTmpYh.size() == 1){
                    logger.info("4-将用户插入最新的tmp_yh:" + mysqlDao.insertTmpYh(singleTmpYh));

                    logger.info("5-建立单个用户-档案：" + mysqlDao.insertAconsumerSingle(singleTmpYh.get(0).getCUSTOMER_ID()));
                    logger.info("6-建立单个用户-联系方式：" + mysqlDao.insertAconsumerContactsSingle(singleTmpYh.get(0).getCUSTOMER_ID()));
                    logger.info("7-建立单个表计-档案：" + mysqlDao.insertAequipMeterSingle(singleTmpBj.get(0).getMT_COMM_ADDR()));
                    logger.info("8-建立单个表计-Vending：" + mysqlDao.insertAequipMeterVendingSingle(meterNo));
                    logger.info("9-建立单个计量点：" + mysqlDao.insertAusagePointSingle(meterNo));
                    logger.info("10-建立单个计量点-设备关联：" + mysqlDao.insertMpRelSingle(meterNo));
                    logger.info("11-建立单个用户catalog：" + mysqlDao.insertCatalogSingle(meterNo));
                    return meterNo + " 插入完成....";
                }else{
                    return "！！！老库该表绑定用户异常：" + singleTmpYh.size();
                }
            }else{
                return "！！！老库中查到该表号不唯一：" + singleTmpBj.size();
            }
        }else{
            return "！！！最新tmp_bj中已存在该表:" + meterNo;
        }
    }

    @Override
    public int callSynCumu2Mysql() {
        logger.info("此处约束：必须当天凌晨同步过当天数据，才允许手动同步今天。" +
                "以防隔了好几天未自动同步直接手动同步今天造成tmp_ljz1数据遗漏");
        int isToday = mysqlToolDao.queryTmpLjzIsToday();
        if(isToday == 1){
            logger.info("开始单独手动同步...");
            // 将现有的tmp_ljz1归档为日期后缀（日期为表内lastvenddate）
            String nameWithDate = toolService.getTmpLjz1DateName();
            if(nameWithDate != null)
                mysqlToolDao.updateAlterTableByName("tmp_ljz1", "tmp_ljz" + nameWithDate);
            // 将现有的tmp_ljz改名为tmp_ljz1
            mysqlToolDao.updateAlterTableByName("tmp_ljz", "tmp_ljz1");
            // 重新创建新的tmp_ljz
            mysqlToolDao.updateCreateTmpLjz();
            indexService.addIndexWithCheck("tmp_ljz","index_ljz_meterId","meterId");
            indexService.addIndexWithCheck("tmp_ljz","index_ljz_consId","consId");
            // 导入tmp_ljz
            importTmpLjzByDateStr(MyDateUtils.getSysDateCumu());
            // --------------------同步
            ljzSynMySqlService.synLjzIntoVdCcumuValue();
            indexService.deleteIndexWithCheck("vd_c_cumu_value","index_vd_c_cumu_value_cumuobjid");
            logger.info("手动同步当天累计值至mysql完成----------");
        }
        return isToday;
    }

    @Override
    public int callSynLjz2Sqlserver() {
        String cumuDate = MyDateUtils.getSysDateCumu();
        logger.info("取" + cumuDate + "当天的累计值");
        List<TmpLjz> tmpljzList = mysqlDao.queryVdPtokenAsLjz(cumuDate);
        logger.info("取到新库指定日期的[累计值]记录个数：" + tmpljzList.size());
        if(tmpljzList.size() > 0){
            logger.info("执行往新库同步..............暂时不动");
//                ljzSynSqlServerService.synVdCcumuValueIntoLjz(tmpljzList);
        }
        logger.info("手动同步当天累计值至sqlserver完成----------");
        return tmpljzList.size();
    }


    @Override
    public int callSynSdjl2Mysql() {
        if(toolService.ifTableNotExist("tmp_sdjl")){
            logger.info("创建临时售电记录表 tmp_sdjl");
            toolService.createTmpSdjl();
        }
        logger.info("调用售电记录同步动作，从 sqlserver 至 mysql-------------------");
        String maxSynedTv = mysqlToolDao.queryMaxSynTvFromPayFlow();
        logger.info("售电记录上次同步至：" + maxSynedTv);
        List<String> odDatePoints = MyDateUtils.getDateTimeStringListForSdjl(maxSynedTv);
        logger.info("售电记录即将同步天数：" + odDatePoints.size());
        if(odDatePoints.size() >= 2){
            for (int i = 1; i < odDatePoints.size(); i++) {
                logger.info("售电记录即将同步至：" + odDatePoints.get(i));
                List<TmpSdjl> tmpSdjlList = sqlserverDao.queryTmpSdjlByDateStr(odDatePoints.get(i - 1), odDatePoints.get(i));
                importSdjlIntoMysql(tmpSdjlList);
                logger.info("售电记录已同步至：" + odDatePoints.get(i) + "，共计" + tmpSdjlList.size() + "笔");
            }
        }

        return 0;
    }



    private void importSdjlIntoMysql(List<TmpSdjl> tmpSdjlList) {
        logger.info("清除并导入 tmp_sdjl 表");
        mysqlDao.deleteTmpData("tmp_sdjl");
        int listSize = tmpSdjlList.size();
        List<TmpSdjl> part = new ArrayList<TmpSdjl>(LIMIT);
        for (int i = 0; i < listSize; i++) {
            part.add(tmpSdjlList.get(i));
            if(LIMIT == part.size() || i == listSize - 1){
                mysqlDao.insertTmpSdjl(part);
                part.clear();
            }
        }
        ProcessParam processParam = new ProcessParam();
        logger.info("导入 vd_a_pay_flow");
        mysqlDao.executeScript_zz_3_1(processParam);
        if(processParam.getError_code() != 0)
            throw new RuntimeException(processParam.getError_msg());
        logger.info("导入 vd_a_inv");
        mysqlDao.executeScript_zz_3_2(processParam);
        if(processParam.getError_code() != 0)
            throw new RuntimeException(processParam.getError_msg());
        logger.info("导入 vd_a_charge_inv_rel");
        mysqlDao.executeScript_zz_3_3(processParam);
        if(processParam.getError_code() != 0)
            throw new RuntimeException(processParam.getError_msg());
        logger.info("导入 a_agent_pay_flow");
        mysqlDao.executeScript_zz_3_4(processParam);
        if(processParam.getError_code() != 0)
            throw new RuntimeException(processParam.getError_msg());
        logger.info("导入 vd_p_token");
        mysqlDao.executeScript_zz_3_5(processParam);
        if(processParam.getError_code() != 0)
            throw new RuntimeException(processParam.getError_msg());
        logger.info("导入 vd_e_calc_pp_parm");
        mysqlDao.executeScript_zz_3_6(processParam);
        if(processParam.getError_code() != 0)
            throw new RuntimeException(processParam.getError_msg());
        logger.info("导入 vd_a_rcvbl_flow");
        mysqlDao.executeScript_zz_3_7(processParam);
        if(processParam.getError_code() != 0)
            throw new RuntimeException(processParam.getError_msg());
        logger.info("导入 vd_a_rcvbl_amt");
        mysqlDao.executeScript_zz_3_8(processParam);
        if(processParam.getError_code() != 0)
            throw new RuntimeException(processParam.getError_msg());
        logger.info("导入 vd_a_rcvbl_debt");
        mysqlDao.executeScript_zz_3_9(processParam);
        if(processParam.getError_code() != 0)
            throw new RuntimeException(processParam.getError_msg());
        logger.info("导入 vd_a_rcved_flow");
        mysqlDao.executeScript_zz_3_10(processParam);
        if(processParam.getError_code() != 0)
            throw new RuntimeException(processParam.getError_msg());
        logger.info("导入 vd_a_rcved_amt");
        mysqlDao.executeScript_zz_3_11(processParam);
        if(processParam.getError_code() != 0)
            throw new RuntimeException(processParam.getError_msg());
        logger.info("导入 vd_a_rcved_debt");
        mysqlDao.executeScript_zz_3_12(processParam);
        if(processParam.getError_code() != 0)
            throw new RuntimeException(processParam.getError_msg());
        logger.info("导入 vd_s_cancel_app");
        mysqlDao.executeScript_zz_3_3(processParam);
        if(processParam.getError_code() != 0)
            throw new RuntimeException(processParam.getError_msg());
    }

    private void importTmpLjzByDateStr(String cumuDateStr) {
        logger.info("清空tmp_ljz");
        mysqlDao.deleteTmpData("tmp_ljz");
        logger.info("取[" + cumuDateStr + "]当天的累计值");
        List<TmpLjz> tmpljz = sqlserverDao.queryTmpLjzByDateStr(cumuDateStr);
        logger.info("取到老库[" + cumuDateStr + "]的[累计值]记录数：" + tmpljz.size());
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
//        int ljz1size = mysqlToolDao.queryTableSize("tmp_ljz1");
//        logger.info("上次同步的[累计值]个数（tmp_ljz1）：" + ljz1size);
        logger.info("本次同步的[累计值]个数（tmp_ljz）：" + tmpljz.size());
        tmpljz.clear();
    }
}
