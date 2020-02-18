package cn.vincent.service;

import cn.vincent.dao.master.MysqlDao;
import cn.vincent.dao.master.MysqlToolDao;
import cn.vincent.dao.other.SqlserverDao;
import cn.vincent.pojo.TmpLjz;
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
        if(tmpljzList.size() > 0)
            logger.info("执行往新库同步..............暂时不动");
//                ljzSynSqlServerService.synVdCcumuValueIntoLjz(tmpljzList);
        logger.info("手动同步当天累计值至sqlserver完成----------");
        return tmpljzList.size();
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
