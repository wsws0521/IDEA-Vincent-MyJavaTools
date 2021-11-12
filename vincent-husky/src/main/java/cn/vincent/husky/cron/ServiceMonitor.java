package cn.vincent.husky.cron;

import cn.vincent.husky.bean.ComponentStatus;
import cn.vincent.husky.cache.ComponentConfigCache;
import cn.vincent.husky.cache.ComponentRunningCache;
import cn.vincent.husky.service.ComponentManager;
import java.util.Date;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class ServiceMonitor {
    private static final Logger log = LoggerFactory.getLogger(cn.vincent.husky.cron.ServiceMonitor.class);

    @Autowired
    private ComponentManager componentManager;

    @Autowired
    private ComponentConfigCache componentConfigCache;

    @Autowired
    private ComponentRunningCache componentRunningCache;

    @Scheduled(cron = "${serviceMonitor.reAliveCheck.cron:0/15 * * * * ?}")
    public void reAliveCheck() {
        Map<String, ComponentStatus> componentStatusMap = this.componentRunningCache.getAllComponentNameMap();
        for (Map.Entry<String, ComponentStatus> stringComponentStatusEntry : componentStatusMap.entrySet()) {
            ComponentStatus status = stringComponentStatusEntry.getValue();
            if (null == status)
                break;
            if (status.isAlive())
                break;
            if (status.isReAliveNow()) {
                Integer diffMin = status.getBackToLiveMinute();
                Date stopTime = status.getStopTime();
                String componentName = stringComponentStatusEntry.getKey();
                if (stopTime == null || diffMin == null) {
                    log.info("ServiceMonitor reAliveCheck reAlive [{}],the stopTime and diffMin is null", componentName);
                    this.componentManager.restartComponent(componentName);
                }
                if (stopTime != null && diffMin != null) {
                    boolean isCanRelive = (System.currentTimeMillis() - stopTime.getTime() >= (diffMin.intValue() * 60 * 1000));
                    if (isCanRelive) {
                        log.info("ServiceMonitor reAliveCheck reAlive [{}],the stopTime is[] ,the diffMin is[]minute ", new Object[] { componentName, stopTime, diffMin });
                        this.componentManager.restartComponent(componentName);
                    }
                }
            }
        }
    }

    @Scheduled(cron = "${serviceMonitor.checkServiceHealth.cron:0 0/5 * * * ?}")
    public void checkServiceHealthByPsCommand() {
        Map<String, ComponentStatus> stringProcessMap = this.componentRunningCache.getAllComponentNameMap();
        for (Map.Entry<String, ComponentStatus> stringComponentEntry : stringProcessMap.entrySet()) {
            String serviceName = stringComponentEntry.getKey();
            boolean isAlive = this.componentManager.checkComponentAlive(serviceName);
            if (!isAlive && (
                    (ComponentStatus)stringComponentEntry.getValue()).isReAliveNow())
                this.componentManager.restartComponent(serviceName);
        }
    }
}
