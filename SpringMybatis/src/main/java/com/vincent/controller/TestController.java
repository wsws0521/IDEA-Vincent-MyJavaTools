package com.vincent.controller;

import com.vincent.service.MysqlCumuService;
import com.vincent.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
