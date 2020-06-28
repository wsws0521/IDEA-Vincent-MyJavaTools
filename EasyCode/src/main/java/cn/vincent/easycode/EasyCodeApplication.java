package cn.vincent.easycode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("cn.vincent.easycode.dao")
public class EasyCodeApplication extends SpringBootServletInitializer {
    /**
     * Configure the application. Normally all you would need to do it add sources (e.g.
     * config classes) because other settings have sensible defaults. You might choose
     * (for instance) to add default command line arguments, or set an active Spring
     * profile.
     *
     * @param builder a builder for the application context
     * @return the application builder
     * @see SpringApplicationBuilder
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(EasyCodeApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(EasyCodeApplication.class);
    }
}
