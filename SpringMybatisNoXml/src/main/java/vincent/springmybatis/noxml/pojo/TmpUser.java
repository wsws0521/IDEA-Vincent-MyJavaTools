package vincent.springmybatis.noxml.pojo;

import java.math.BigInteger;
import java.sql.Date;

public class TmpUser {
    BigInteger id;
    Date tv;
    String username;
    Integer age;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
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