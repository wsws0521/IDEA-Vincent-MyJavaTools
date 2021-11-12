package cn.vincent.husky.init;

import cn.vincent.husky.cron.ServiceMonitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class HuskyInit implements ApplicationListener<ApplicationReadyEvent> {
    private static final Logger log = LoggerFactory.getLogger(cn.vincent.husky.init.HuskyInit.class);

    @Autowired
    private ServiceMonitor serviceMonitor;

    public void onApplicationEvent(ApplicationReadyEvent applicationEvent) {
        log.info("executor huskyInit method");
        this.serviceMonitor.checkServiceHealthByPsCommand();
    }
}
