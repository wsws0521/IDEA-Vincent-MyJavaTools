package vincent.springmybatis.noxml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"vincent.springmybatis.noxml.*"})
public class SpringMybatisNoXmlApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringMybatisNoXmlApplication.class);
    }
}
