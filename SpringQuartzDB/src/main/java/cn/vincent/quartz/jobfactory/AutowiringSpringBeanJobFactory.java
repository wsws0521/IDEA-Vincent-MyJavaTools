package cn.vincent.quartz.jobfactory;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

/**
 * SpringBoot集成Quartz依然沿用了Spring的典型方式，使用工厂Bean生成Bean的方式。在Quartz中，需要被调度的任务叫做Job，而负责调度任务则是Scheduler。
 * 我们首先需要配置工厂Bean：JobFactory接口，自定义一个AutowiringSpringBeanJobFactory类继承SpringBeanJobFactory(实现了JobFactory接口)
 *
 * AutowiringSpringBeanJobFactory工厂类将负责生成实现了Job接口的类的实例对象Bean
 */
public class AutowiringSpringBeanJobFactory extends SpringBeanJobFactory implements ApplicationContextAware {
    private transient AutowireCapableBeanFactory beanFactory;
    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException {
        beanFactory = applicationContext.getAutowireCapableBeanFactory();
    }
    @Override
    protected Object createJobInstance(final TriggerFiredBundle bundle) throws Exception {
        final Object job = super.createJobInstance(bundle);
        beanFactory.autowireBean(job);
        return job;
    }
}
