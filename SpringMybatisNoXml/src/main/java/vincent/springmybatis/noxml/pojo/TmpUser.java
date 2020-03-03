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
