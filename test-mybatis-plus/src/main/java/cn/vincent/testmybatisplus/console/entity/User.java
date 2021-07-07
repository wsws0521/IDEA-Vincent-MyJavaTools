package cn.vincent.testmybatisplus.console.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName("public.user") // user是系统表，这里指定下
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Long managerId;
    private Date createTime;
}
