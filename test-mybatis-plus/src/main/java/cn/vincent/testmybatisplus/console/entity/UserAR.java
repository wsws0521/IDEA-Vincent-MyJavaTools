package cn.vincent.testmybatisplus.console.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
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
    // 注意：这种方式插 date，是用的java8的localDateTime，如果多机部署/多Docker间没NTP，时间差，会导致bug，最好老老实实取数据库时间吧···
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
}
