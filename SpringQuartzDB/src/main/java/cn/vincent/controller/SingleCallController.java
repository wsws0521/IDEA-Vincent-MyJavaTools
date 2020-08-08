package cn.vincent.controller;

import cn.vincent.service.SingleCallService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/singlecall")
public class SingleCallController {
    private static final Logger logger = LoggerFactory.getLogger(SingleCallController.class);
    @Autowired
    SingleCallService singleCallService;

    @GetMapping("/hello")
    public String hello(){
        return "Singal Call: Hello Centlec !";
    }

    @GetMapping("/cumu/mysql")
    public String cumuMysql(){
        int isToday = singleCallService.callSynCumu2Mysql();
        return "is today : " + isToday;
    }

    @GetMapping("/ljz/sqlserver")
    public String ljzSqlServer(){
        int num = singleCallService.callSynLjz2Sqlserver();
        return num + "OK";
    }

    /**
     * 电力局忽然又说 有当天老系统开户，新系统售电的情况
     * 这里单纯同步单个表计/用户档案信息
     * @param meterNo   要同步的表号
     * @return
     */
    @GetMapping("/meter/{meterNo}")
    public String returnStringId(@PathVariable String meterNo){
        System.out.println("单独添加表计-用户档案，表号为:" + meterNo);
        logger.info("单独添加表计-用户档案，表号为:" + meterNo);
        return singleCallService.callSynSingleMeter(meterNo);
    }
    @GetMapping("/customer/{customerId}")
    public String syncByCustomerId(@PathVariable String customerId){
        System.out.println("单独添加表计-用户档案，用户ID为:" + customerId);
        logger.info("单独添加表计-用户档案，用户ID为:" + customerId);
        return singleCallService.callSynSingleCustomer(customerId);
    }
}
