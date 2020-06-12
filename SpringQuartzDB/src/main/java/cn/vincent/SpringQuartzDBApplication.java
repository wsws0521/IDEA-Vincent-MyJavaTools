package cn.vincent;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties
@EnableScheduling
//@MapperScan({"cn.vincent.dao.master","cn.vincent.dao.other"})
public class SpringQuartzDBApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringQuartzDBApplication.class);
    }
}
