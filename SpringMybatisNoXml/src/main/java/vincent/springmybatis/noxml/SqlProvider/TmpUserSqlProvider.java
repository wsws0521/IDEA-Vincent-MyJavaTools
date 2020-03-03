package vincent.springmybatis.noxml.SqlProvider;

import org.apache.ibatis.jdbc.SQL;
import vincent.springmybatis.noxml.pojo.TmpUser;

public class TmpUserSqlProvider {
    public String listWuShuai(){
        return "select * from tmp_user where username = '吴帅'";
    }

    public String insertTmpUser(String name, int age){
        return "INSERT INTO `vending20200303`.`tmp_user` (`username`, `age`) VALUES ('"
         + name + "', " + age + ")";
    }

    public String insertTmpUserByObject(final TmpUser tmpUser){
        return new SQL(){
            {
                INSERT_INTO("tmp_user");
                if(tmpUser.getUsername() != null){
                    VALUES("username", "#{username}");
                }
                if(tmpUser.getAge() != null){
                    VALUES("age", "#{age}");
                }
            }
        }.toString();
    }
}
