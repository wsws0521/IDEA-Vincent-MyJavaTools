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

    @GetMapping("/cumu/{cumuDate}")
    public String returnStringId(@PathVariable String cumuDate){
        singleCallService.callSynCumu();
        return cumuDate;
    }

}
