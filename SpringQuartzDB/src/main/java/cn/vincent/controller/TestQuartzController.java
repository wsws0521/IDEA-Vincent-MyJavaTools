package cn.vincent.controller;

import cn.vincent.quartz.job.TestJob;
import cn.vincent.quartz.manager.SchedulerManager;
import cn.vincent.service.DbService;
import cn.vincent.utils.MyUtils;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prod")
public class TestQuartzController {
    private static final Logger logger = LoggerFactory.getLogger(TestQuartzController.class);
    @Autowired
    public SchedulerManager myScheduler;
    @Autowired
    DbService dbService;

    @GetMapping("/{id}")
    public String returnStringId(@PathVariable String id){
        System.out.println("sout:" + id);
        logger.info("当前时间是：" + MyUtils.getSysDateTime());
        logger.info("Request:" + id);
        logger.debug("当前时间是：" + MyUtils.getSysDateTime());
        logger.debug("Request:" + id);
        dbService.generalCall();
        return "Request:" + id;
//                + "mysql.pthidparty" + testDbService.queryMysqlPthirdParty().size() + "\n"
//                + "sqlserver.tariffgroup" + testDbService.querySqlserverTariffGroup().size();
    }




    @RequestMapping(value = "/start",method = RequestMethod.GET)
    public String startTestJob(){
        try {
            myScheduler.startJob("0/15 * * * * ?","jobtest","grouptest", TestJob.class);//每五秒执行一次
            //0 0/5 14 * * ?在每天下午2点到下午2:55期间的每5分钟触发
            //0 30 02 * * ?在每天凌晨2点30分5秒执行一次
//            myScheduler.startJob("5 50 14 * * ?","job2","group2", ScheduledJob.class);
            return "启动定时器成功";
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return "启动定时器失败";
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public String deleteTestJob() {
        try {
            myScheduler.deleteJob("jobtest","grouptest");
            return "删除定时器成功";
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return "删除定时器失败";
    }
}
