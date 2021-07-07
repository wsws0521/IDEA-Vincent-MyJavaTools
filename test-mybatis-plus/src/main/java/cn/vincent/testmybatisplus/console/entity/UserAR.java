package cn.vincent.testmybatisplus.console.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@EqualsAndHashCode(callSuper = false) // AR
@TableName("public.userar") // AR
@Data
public class UserAR extends Model<UserAR> {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Long managerId;
    private Date createTime;
}
