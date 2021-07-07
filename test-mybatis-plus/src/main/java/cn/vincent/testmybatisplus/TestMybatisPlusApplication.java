package cn.vincent.testmybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.vincent.testmybatisplus.console.mapper")
public class TestMybatisPlusApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestMybatisPlusApplication.class);
    }
}
