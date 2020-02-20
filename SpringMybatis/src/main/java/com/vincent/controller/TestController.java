package com.vincent.controller;

import com.vincent.pojo.TmpTestTariffDate;
import com.vincent.service.MysqlCumuService;
import com.vincent.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/test")
public class TestController {
    @Resource
    MysqlCumuService mysqlCumuService;
    @Autowired
    TestService testService;

    @GetMapping("/{id}")
    public String returnStringId(@PathVariable String id){
        testService.gggCall();
        return id + "Request:" + mysqlCumuService.queryMysqlCumu().size();
    }

    @PostMapping("/tmpTestTariffDate")
    public void insertTmpTestTariffDate(@RequestBody TmpTestTariffDate tmpTestTariffDate){
        // 参照印象笔记Springboot下关于Date的笔记
        testService.insertTmpTestTariffDate(tmpTestTariffDate);
    }
}
