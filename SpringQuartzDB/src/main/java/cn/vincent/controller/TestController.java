package cn.vincent.controller;

import cn.vincent.pojo.ProcessParam;
import cn.vincent.service.TestDbService;

import cn.vincent.utils.MyDateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    @Resource
    TestDbService testDbService;

    @GetMapping("/{id}")
    public String returnStringId(@PathVariable String id){
        System.out.println("sout:" + id);
        logger.info("当前时间是：" + MyDateUtils.getSysDateTime());
        logger.info("Request:" + id);
        logger.debug("当前时间是：" + MyDateUtils.getSysDateTime());
        logger.debug("Request:" + id);
        return "Request:" + id;
//                + "mysql.pthidparty" + testDbService.queryMysqlPthirdParty().size() + "\n"
//                + "sqlserver.tariffgroup" + testDbService.querySqlserverTariffGroup().size();
    }

    @GetMapping("/rollback")
    public void testRollback(){
        testDbService.insertRollback();
    }

    @GetMapping("/proc")
    public ProcessParam testProce(){
        return testDbService.executeProc();
    }

    @GetMapping("/batchInsert")
    public int testBatchInsert(){
        return testDbService.batchInsert();
    }

    @GetMapping("/batchQueryInsert")
    public int testBatchQueryInsert(){
        return testDbService.testBatchQueryInsert();
    }

}
