package cn.vincent.husky.cache;

import cn.vincent.husky.bean.ComponentStatus;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class ComponentRunningCache {
    private Map<String, ComponentStatus> componentNameMap = new ConcurrentHashMap<>();

    public ComponentStatus putComponentNameProcess(String name, ComponentStatus componentStatus) {
        if (StringUtils.isEmpty(name))
            return null;
        return this.componentNameMap.put(name, componentStatus);
    }

    public ComponentStatus getComponentStatusByName(String name) {
        if (StringUtils.isEmpty(name))
            return null;
        return this.componentNameMap.get(name);
    }

    public Map<String, ComponentStatus> getAllComponentNameMap() {
        return Collections.unmodifiableMap(this.componentNameMap);
    }

    public boolean isAliveByComponentName(String name) {
        if (StringUtils.isEmpty(name))
            return false;
        ComponentStatus componentStatus = this.componentNameMap.get(name);
        if (componentStatus == null)
            return false;
        return componentStatus.isAlive();
    }
}
