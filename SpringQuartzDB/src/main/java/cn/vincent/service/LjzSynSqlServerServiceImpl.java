package cn.vincent.service;

import cn.vincent.dao.other.SqlserverDao;
import cn.vincent.pojo.TmpLjz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class LjzSynSqlServerServiceImpl implements LjzSynSqlServerService {
    private static final Logger logger = LoggerFactory.getLogger(LjzSynSqlServerServiceImpl.class);
    private static final int LIMIT = 300;

    @Resource
    SqlserverDao sqlserverDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void synVdCcumuValueIntoLjz(List<TmpLjz> tmpljzList) {
        // 默认tmp_ljz表已建好
        // 老库的tmp_ljz数据无需清空，一直保持增长
//        sqlserverDao.deleteTmpData("tmp_ljz");
        int insNum = 0;
        int listSize = tmpljzList.size();
        List<TmpLjz> part = new ArrayList<TmpLjz>(LIMIT);
        for (int i = 0; i < listSize; i++) {
            part.add(tmpljzList.get(i));
            if(LIMIT == part.size() || i == listSize - 1){
                insNum  += sqlserverDao.insertTmpLjz(part);
                part.clear();
            }
        }
        logger.info("插入到老库[tmp_ljz]记录数：" + insNum);
        if(insNum != listSize)
            throw new RuntimeException("免费累计值记录：取到的与插入的不相等");
        int p0 = sqlserverDao.updateIparaMtrPoint0();
        logger.info("开始执行同步更新:updateIparaMtrPoint0:" + p0);
        int t0 = sqlserverDao.updateTmpLjz0();
        logger.info("开始执行同步更新:updateTmpLjz0:" + t0);
        int p1 = sqlserverDao.updateIparaMtrPoint1();
        logger.info("开始执行同步更新:updateIparaMtrPoint1:" + p1);
        int t1 = sqlserverDao.updateTmpLjz1();
        logger.info("开始执行同步更新:updateTmpLjz1:" + t1);
    }
}
