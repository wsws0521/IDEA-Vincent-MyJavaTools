package cn.vincent.builder;

import java.util.Date;

/**
 * 优雅的构建多属性对象
 *
 * 1）在 Bean 类里面新建一个静态内部类：XxxBuilder；
 * 2）把 Bean 类所有参数复制到 XxxBuilder，然后在 XxxBuilder 新建必须参数的构造器，其他参数使用变量名作为方法然后返回自身（this）以便形成链式调用；
 * 3）在 Bean 类里面新建一个接收 XxxBuilder 参数的私有构造器，避免使用 new 创建对象；
 * 4）在 XxxBuilder 类新建一个 build 方法开始构建 Bean 类，也是作为链式调用的结束；
 */
public class BuildObject {
    private long id;
    private String name;
    private String content;
    private int type;
    private int status;
    private Date finishDate;

    private BuildObject(ObjectBuilder objectBuilder) {
        this.id = objectBuilder.id;
        this.name = objectBuilder.name;
        this.content = objectBuilder.content;
        this.type = objectBuilder.type;
        this.status = objectBuilder.status;
        this.finishDate = objectBuilder.finishDate;
    }

    /**
     * 静态类
     */
    public static class ObjectBuilder {
        private long id;
        private String name;
        private String content;
        private int type;
        private int status;
        private Date finishDate;
        public ObjectBuilder(long id, String name) {
            // 关键属性 可以在构造器里面赋值
            this.id = id;
            this.name = name;
        }
        public ObjectBuilder content(String content) {
            this.content = content;
            return this;
        }
        public ObjectBuilder type(int type) {
            this.type = type;
            return this;
        }
        public ObjectBuilder status(int status) {
            this.status = status;
            return this;
        }
        public ObjectBuilder finishDate(Date finishDate) {
            this.finishDate = finishDate;
            return this;
        }
        public BuildObject build(){
            return new BuildObject(this);
        }
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getContent() {
        return content;
    }
    public int getType() {
        return type;
    }
    public int getStatus() {
        return status;
    }
    public Date getFinishDate() {
        return finishDate;
    }

    @Override
    public String toString() {
        return "Object{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", type=" + type +
                ", status=" + status +
                ", finishDate=" + finishDate +
                '}';
    }
}

