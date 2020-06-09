package cn.vincent.easycode.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (TmpUser)实体类
 *
 * @author makejava
 * @since 2020-05-23 20:00:40
 */
public class TmpUser implements Serializable {
    private static final long serialVersionUID = -81325808350001753L;
    
    private Integer id;
    
    private Date tv;
    /**
    * 用户名
    */
    private String username;
    /**
    * 年龄
    */
    private Integer age;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTv() {
        return tv;
    }

    public void setTv(Date tv) {
        this.tv = tv;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

}