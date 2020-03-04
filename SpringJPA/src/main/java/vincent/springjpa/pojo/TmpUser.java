package vincent.springjpa.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 会自动映射成tmp_user的表名...
 */
@Entity
public class TmpUser {
    long id;
    Date tv;
    String username;
    Integer age;
    public TmpUser(){} // findAll的时候需要有默认构造函数
    public TmpUser(String username, Integer age) {
        this.tv = new Date(); // 否则不会不插，而是会硬插NULL
        this.username = username;
        this.age = age;
    }

    @Id
    @GeneratedValue
    public long getId() {
        return id;
    }

    public void setId(long id) {
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


/*
CREATE TABLE `tmp_user` (
    `id` int(11) NOT NULL AUTO_INCREMENT,
    `tv` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `username` varchar(2000) DEFAULT NULL COMMENT '用户名',
    `age` int(6) DEFAULT NULL COMMENT '年龄',
    PRIMARY KEY (`id`,`tv`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
*/