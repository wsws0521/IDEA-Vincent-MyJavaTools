package com.vincent.controller;

import com.vincent.service.MysqlCumuService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestController {
    @Resource
    MysqlCumuService mysqlCumuService;
    @GetMapping("/{id}")
    public String returnStringId(@PathVariable String id){
        return "Request:" + id + mysqlCumuService.queryMysqlCumu().size();
    }

}
