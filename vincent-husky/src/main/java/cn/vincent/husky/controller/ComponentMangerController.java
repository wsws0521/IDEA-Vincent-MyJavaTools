package cn.vincent.husky.controller;

import cn.vincent.husky.bean.ComponentStatus;
import cn.vincent.husky.cache.ComponentRunningCache;
import cn.vincent.husky.constant.ResultCode;
import cn.vincent.husky.controller.BaseResult;
import cn.vincent.husky.service.ComponentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/componet"})
public class ComponentMangerController {
    @Autowired
    private ComponentManager componentManager;

    @Autowired
    private ComponentRunningCache componentRunningCache;

    @RequestMapping({"/get/{component}"})
    public BaseResult getConfig(@PathVariable("component") String component) {
        return BaseResult.getSuccessResult(this.componentRunningCache.getComponentStatusByName(component));
    }

    @RequestMapping({"/all"})
    public BaseResult getAllComponentStatus() {
        return BaseResult.getSuccessResult(this.componentRunningCache.getAllComponentNameMap());
    }

    @RequestMapping({"/restart/{component}"})
    public BaseResult restart(@PathVariable("component") String component) {
        boolean restartResult = this.componentManager.restartComponent(component);
        if (restartResult)
            return BaseResult.getSuccessResult(Boolean.valueOf(restartResult));
        return BaseResult.getFailResult(ResultCode.RESTART_COMPONENT_FAIL);
    }

    @RequestMapping({"/stop"})
    public BaseResult stop(@RequestParam String component, @RequestParam(defaultValue = "true") boolean isReAlive, @RequestParam(defaultValue = "30") Integer reAliveMinute) {
        ComponentStatus componentStatus = this.componentRunningCache.getComponentStatusByName(component);
        if (null == componentStatus)
            return BaseResult.getFailResult(ResultCode.COMPONENT_IS_NOT_EXIST);
        boolean ret = this.componentManager.stopComponent(component, isReAlive, reAliveMinute);
        if (ret)
            return BaseResult.getSuccessResult(null);
        return BaseResult.getFailResult(ResultCode.STOP_COMPONENT_FAIL);
    }
}

