package cn.vincent.husky;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ServiceMonitorPoolConfig {
    @Value("${ServiceMonitorPool.corePoolSize:3}")
    private int corePoolSize;

    @Value("${ServiceMonitorPool.maxPoolSize:10}")
    private int maxPoolSize;

    @Value("${ServiceMonitorPool.queueCapacity:20}")
    private int queueCapacity;

    @Bean
    public Executor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(this.corePoolSize);
        executor.setMaxPoolSize(this.maxPoolSize);
        executor.setQueueCapacity(this.queueCapacity);
        executor.setRejectedExecutionHandler((r, executor1) -> {

        });
        executor.initialize();
        return (Executor)executor;
    }
}
