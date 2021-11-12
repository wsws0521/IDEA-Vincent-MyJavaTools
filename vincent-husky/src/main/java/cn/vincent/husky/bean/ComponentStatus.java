package cn.vincent.husky.bean;

import java.util.Date;

public class ComponentStatus {
    private MyComponent myComponent;

    private boolean isAlive;

    private boolean isNeedBackToLive;

    private Date stopTime;

    private Integer backToLiveMinute;

    public ComponentStatus(MyComponent myComponent) {
        this.myComponent = myComponent;
        this.isAlive = false;
        this.isNeedBackToLive = true;
    }

    public boolean isReAliveNow() {
        if (this.isAlive)
            return false;
        if (!isNeedBackToLive())
            return false;
        Integer diffMin = getBackToLiveMinute();
        Date stopTime = getStopTime();
        if (stopTime == null || diffMin == null)
            return true;
        boolean isCanRelive = (System.currentTimeMillis() - stopTime.getTime() >= (diffMin.intValue() * 60 * 1000));
        return isCanRelive;
    }

    public MyComponent getMyComponent() {
        return this.myComponent;
    }

    public void setMyComponent(MyComponent myComponent) {
        this.myComponent = myComponent;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public void setAlive(boolean alive) {
        this.isAlive = alive;
    }

    public Date getStopTime() {
        return this.stopTime;
    }

    public void setStopTime(Date stopTime) {
        this.stopTime = stopTime;
    }

    public Integer getBackToLiveMinute() {
        return this.backToLiveMinute;
    }

    public void setBackToLiveMinute(Integer backToLiveMinute) {
        this.backToLiveMinute = backToLiveMinute;
    }

    public boolean isNeedBackToLive() {
        return this.isNeedBackToLive;
    }

    public void setNeedBackToLive(boolean needBackToLive) {
        this.isNeedBackToLive = needBackToLive;
    }

    public String toString() {
        return "ComponentStatus{myComponent=" + this.myComponent + ", isAlive=" + this.isAlive + ", isNeedBackToLive=" + this.isNeedBackToLive + ", stopTime=" + this.stopTime + ", backToLiveMinute=" + this.backToLiveMinute + '}';
    }
}
