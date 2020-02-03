package com.vincent.service;

import com.vincent.pojo.PthirdParty;
import com.vincent.dao.MysqlCumuDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MysqlCumuServiceImpl implements MysqlCumuService {
    @Resource
    MysqlCumuDao mysqlCumuDao;
    @Override
    public List<PthirdParty> queryMysqlCumu() {
        return mysqlCumuDao.queryMysqlCumu();
    }
}
