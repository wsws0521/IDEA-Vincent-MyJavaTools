package cn.vincent.husky.bean;

public class MyComponent {
    private String name;

    private String restartShellPath;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRestartShellPath() {
        return this.restartShellPath;
    }

    public void setRestartShellPath(String restartShellPath) {
        this.restartShellPath = restartShellPath;
    }

    public String toString() {
        return "MyComponent{name='" + this.name + '\'' + ", restartShellPath='" + this.restartShellPath + '\'' + '}';
    }
}
