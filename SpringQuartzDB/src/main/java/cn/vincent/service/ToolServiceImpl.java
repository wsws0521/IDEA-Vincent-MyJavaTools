package cn.vincent.service;

import cn.vincent.dao.master.ToolDao;
import cn.vincent.utils.MyDateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ToolServiceImpl implements ToolService {
    private static final Logger logger = LoggerFactory.getLogger(ToolServiceImpl.class);
    @Resource
    ToolDao toolDao;

    @Override
    public boolean ifTableNotExist(String tableName) {
        return toolDao.queryTableExist(tableName) == 0;
    }

    @Override
    public boolean ifTableExist(String tableName) {
        return toolDao.queryTableExist(tableName) > 0;
    }

    @Override
    public void createTmpCentlec() {
        toolDao.updateCreateTmpCentlec();
    }

    @Override
    public void truncateTmpTables() {
        List<String> tmpBjList = toolDao.queryTableNameList("tmp_bj");
        dropByRemainNum(tmpBjList, 1);
        List<String> tmpYhList = toolDao.queryTableNameList("tmp_yh");
        dropByRemainNum(tmpYhList, 1);
        List<String> tmpZwList = toolDao.queryTableNameList("tmp_zw");
        dropByRemainNum(tmpZwList, 1);
        List<String> tmpLjzList = toolDao.queryTableNameList("tmp_ljz");
        dropByRemainNum(tmpLjzList, 1);

    }

    private void dropByRemainNum(List<String> tmpNameList, int remainNum){
        if(tmpNameList.size() > remainNum){
            for (int i = 0; i < tmpNameList.size() - remainNum; i++) {
                toolDao.updateDropTableByName(tmpNameList.get(i));
                logger.info(tmpNameList.get(i) + "被删除了...");
            }
        }
    }


    /**
     * 0.2同步脚本出错时，手动执行回滚操作
     */
    @Override
    public void resetTmpFromTmp1() {
        doResetTmpFromTmp1("tmp_yh");
        doResetTmpFromTmp1("tmp_bj");
        doResetTmpFromTmp1("tmp_zw");
        doResetTmpFromTmp1("tmp_ljz");
    }


    private void doResetTmpFromTmp1(String baseTableName){
        if(ifTableExist(baseTableName) && toolDao.queryTableSize(baseTableName) == 0){
            toolDao.updateDropTableByName(baseTableName);
            toolDao.updateAlterTableByName(baseTableName + "1", baseTableName);
        }
    }

    /**
     * 获取tmp_ljz1日期后缀的新表名（日期为表内lastvenddate）
     *
     * @return
     */
    @Override
    public String getTmpLjz1DateName() {
        if(ifTableExist("tmp_ljz1")){
            String maxLastVendDate = toolDao.queryMaxLastVendDateFromLjz1();
            if(maxLastVendDate == null || "".equals(maxLastVendDate))
                return null;
            else
                return MyDateUtils.getShortDateFromString(maxLastVendDate);
        }else{
            return null;
        }
    }
}
