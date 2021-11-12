package cn.vincent.husky.service;


import cn.vincent.husky.bean.ComponentStatus;
import cn.vincent.husky.cache.ComponentRunningCache;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ComponentManager {
    private static final Logger log = LoggerFactory.getLogger(cn.vincent.husky.service.ComponentManager.class);

    @Autowired
    private ComponentRunningCache componentRunningCache;

    private String PS_SHELL_PATH = getJarHomePath() + "/ps.sh";

    private String STOP_SHELL_PATH = getJarHomePath() + "/stop.sh";

    public synchronized boolean restartComponent(String name) {
        ComponentStatus componentStatus = this.componentRunningCache.getComponentStatusByName(name);
        if (componentStatus == null)
            return false;
        String shellPath = componentStatus.getMyComponent().getRestartShellPath();
        if (StringUtils.isEmpty(shellPath))
            return false;
        String[] commands = { "/bin/sh", shellPath };
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(commands);
            int status = process.waitFor();
            log.debug("restartComponent command is:{},process.waitFor status:{}", commands, Integer.valueOf(status));
            if (status != 0)
                return false;
        } catch (IOException e) {
            log.error("restartComponent component:{} , error:{}", componentStatus, e);
            return false;
        } catch (InterruptedException e) {
            log.error("restartComponent component:{} , error:{}", componentStatus, e);
            return false;
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null)
                sb.append(line).append("\n");
            log.info("restart component:{} success", componentStatus);
            if (log.isDebugEnabled())
                log.info("restart component:{} success ,shell msg is:{}", componentStatus, sb.toString());
            componentStatus.setAlive(true);
            return true;
        } catch (IOException e) {
            log.error("restartComponent component:{} , error:{}", componentStatus, e);
            return false;
        }
    }

    public synchronized boolean stopComponent(String name, boolean isNeedRestart, Integer backToLiveMinute) {
        ComponentStatus componentStatus = this.componentRunningCache.getComponentStatusByName(name);
        componentStatus.setNeedBackToLive(isNeedRestart);
        componentStatus.setBackToLiveMinute(backToLiveMinute);
        componentStatus.setStopTime(new Date());
        String[] commands = { "/bin/sh", this.STOP_SHELL_PATH, name };
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(commands);
            int status = process.waitFor();
            log.debug("stopComponent command is:{},process.waitFor status:{}", commands, Integer.valueOf(status));
            if (status != 0)
                return false;
        } catch (IOException e) {
            log.error("stopComponent component:{} , error:{}", name, e);
            return false;
        } catch (InterruptedException e) {
            log.error("stopComponent component:{} , error:{}", name, e);
            return false;
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null)
                sb.append(line).append("\n");
            log.info("stopComponent component:{},shell msg is:{}", name, sb.toString());
            componentStatus.setAlive(false);
            return true;
        } catch (IOException e) {
            log.error("stopComponent component:{} , error:{}", name, e);
            return false;
        }
    }

    public synchronized boolean checkComponentAlive(String name) {
        ComponentStatus componentStatus = this.componentRunningCache.getComponentStatusByName(name);
        StringBuilder nameSb = new StringBuilder(name);
        nameSb.insert(1, "]");
        nameSb.insert(0, "[");
        String newName = nameSb.toString();
        Process process = null;
        try {
            String[] commands = { "/bin/sh", this.PS_SHELL_PATH, newName };
            process = Runtime.getRuntime().exec(commands);
            int status = process.waitFor();
            log.debug("checkComponentAlive command is:{},process.waitFor status:{}", commands, Integer.valueOf(status));
            if (status != 0) {
                componentStatus.setAlive(false);
                return false;
            }
        } catch (IOException e) {
            log.error("checkComponentAlive component:{} , error:{}", name, e);
            return false;
        } catch (InterruptedException e) {
            log.error("checkComponentAlive component:{} , error:{}", name, e);
            return false;
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null)
                sb.append(line).append("\n");
            String returnStr = sb.toString();
            log.info("checkComponentAlive component:{},shell msg is:{}", name, returnStr);
            if (StringUtils.isEmpty(returnStr)) {
                componentStatus.setAlive(false);
                return false;
            }
            componentStatus.setAlive(true);
            return true;
        } catch (IOException e) {
            log.error("checkComponentAlive component:{} , error:{}", name, e);
            return false;
        }
    }

    public String getJarHomePath() {
        ApplicationHome home = new ApplicationHome(getClass());
        return home.getDir().getAbsolutePath();
    }
}

