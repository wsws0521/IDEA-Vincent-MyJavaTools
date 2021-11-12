package cn.vincent.husky.cache;

import cn.vincent.husky.bean.MyComponent;
import cn.vincent.husky.bean.ComponentStatus;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@ConfigurationProperties(prefix = "dog.watch")
@Component
public class ComponentConfigCache implements InitializingBean {
    private List<MyComponent> myComponents;

    private Map<String, MyComponent> componentNameMap = null;

    @Autowired
    private ComponentRunningCache componentRunningCache;

    public void afterPropertiesSet() throws Exception {
        if (CollectionUtils.isEmpty(this.myComponents))
            return;
        int size = (new Double(this.myComponents.size() / 0.75D)).intValue() + 1;
        this.componentNameMap = new HashMap<>(size);
        for (MyComponent myComponent : this.myComponents) {
            this.componentNameMap.put(myComponent.getName(), myComponent);
            this.componentRunningCache.putComponentNameProcess(myComponent.getName(), new ComponentStatus(myComponent));
        }
    }

    public MyComponent getByName(String name) {
        if (this.componentNameMap == null)
            return null;
        return this.componentNameMap.get(name);
    }

    public Map<String, MyComponent> getAllComponentMap() {
        return Collections.unmodifiableMap(this.componentNameMap);
    }

    public List<MyComponent> getMyComponents() {
        return this.myComponents;
    }

    public void setMyComponents(List<MyComponent> myComponents) {
        this.myComponents = myComponents;
    }
}

