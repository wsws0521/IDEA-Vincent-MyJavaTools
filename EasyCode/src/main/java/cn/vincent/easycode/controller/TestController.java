package cn.vincent.easycode.controller;

import cn.vincent.easycode.entity.TmpUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping("vincent")
    public String showSomething() {
        return "vincent";
    }
}
