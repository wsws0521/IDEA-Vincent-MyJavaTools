package cn.vincent.quartz.config;

/**
 * SchedulerConfig类通过 @Configuration 自动装载配置。这里它配置了两种Bean工厂，一个是JobFactory ，另一个是SchedulerFactoryBean。JobFactory就是上面我们所说的AutowiringSpringBeanJobFactory，而SchedulerFactoryBean是Quartz为我们提供的一个生成Scheduler实例Bean的工厂类。
 *
 * 而在这个SchedulerConfig类中还提供了simpleJobTrigger()【表达式任务触发器工厂】和quartzProperties()【Properties属性基本配置参数】
 *
 * CronTriggerFactoryBean为我们提供了执行任务的触发器，这里是通过静态方式配置了一个调度任务。
 * quartzProperties配置参数可以自由配置Quartz的一些基本参数属性，比如配置调度线程数，调度线程池类型等，这里只配置了一个基本使用参数，如果需要更多请查阅官网。
 */

import cn.vincent.quartz.job.ScheduledJob;
import cn.vincent.quartz.jobfactory.AutowiringSpringBeanJobFactory;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.spi.JobFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.util.Properties;

/**
 * 定时配置（可以配置静态定时任务）
 */
@Configuration
public class SchedulerConfig {
    @Bean
    public JobFactory jobFactory(ApplicationContext applicationContext) {
        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }

    //SchedulerFactoryBean
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(JobFactory jobFactory, Trigger simpleJobTrigger)
            throws IOException {
        SchedulerFactoryBean factory = new SchedulerFactoryBean();

        factory.setJobFactory(jobFactory);
        factory.setQuartzProperties(quartzProperties());
        factory.setTriggers(simpleJobTrigger);

        return factory;
    }

    /**
     * 静态方式配置定时任务
     * @param jobDetail
     * @return
     */
    @Bean
    public CronTriggerFactoryBean simpleJobTrigger(@Qualifier("simpleJobDetail") JobDetail jobDetail) {
        CronTriggerFactoryBean  factoryBean = new CronTriggerFactoryBean ();

        factoryBean.setJobDetail(jobDetail);
        factoryBean.setStartDelay(1000L);
        factoryBean.setName("trigger1");
        factoryBean.setGroup("group1");
        // 周1至周5，每天上午8点至下午18点，每分钟执行一次
//        factoryBean.setCronExpression("0 0/1 8-20 ? * *");
        // 每天凌晨一点10分执行一次
        factoryBean.setCronExpression("0 10 1 ? * *");

        return factoryBean;
    }

    @Bean
    public JobDetailFactoryBean simpleJobDetail() {
        JobDetailFactoryBean factoryBean = new JobDetailFactoryBean();

        factoryBean.setJobClass(ScheduledJob.class);
        factoryBean.setGroup("group1");
        factoryBean.setName("job1");

        return factoryBean;
    }


    @Bean
    public Properties quartzProperties() throws IOException {
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("/quartz.properties"));
        propertiesFactoryBean.afterPropertiesSet();
        return propertiesFactoryBean.getObject();
    }
}
