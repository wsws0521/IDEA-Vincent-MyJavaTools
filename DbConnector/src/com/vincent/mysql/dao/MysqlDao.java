package com.vincent.mysql.dao;

import com.vincent.mysql.util.MysqlJdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MysqlDao {

    /**查询所有的学生选课表的信息*/
    public List<String> getAll(){
        List<String> meterNos = new ArrayList<>();
        String sql = "SELECT `tmp_meterno`.meterno FROM `tmp_meterno`";
        ResultSet rs = MysqlJdbcUtil.executeQuery(sql);
        try{
            while (rs.next()){
                String meterNo = rs.getString("meterno");
                meterNos.add(meterNo);
            }
            return meterNos;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            MysqlJdbcUtil.close();
        }
        return null;
    }
//
//    /**
//     * 分页查询
//     * @param state
//     * @param end
//     * @return
//     */
//    public List<StudentCourse> getPageStudentCourse(int state, int end){
//        List<StudentCourse> list = new ArrayList<>();
//        String sql = "SELECT `StudentCourse`.id, `Course`.Cname, `Student`.Sname FROM `StudentCourse`";
//        sql +=" LEFT JOIN `Course` ON `StudentCourse`.Cno = `Course`.Cno ";
//        sql +=" LEFT JOIN `Student` ON `StudentCourse`.Sno = `Student`.Sno LIMIT ?,?";
//        ResultSet rs = MysqlJdbcUtil.executeQuery(sql,state,end);
//        try{
//            while (rs.next()){
//                StudentCourse stucou = new StudentCourse(
//                        rs.getInt("id"),rs.getString("Cname"),
//                        rs.getString("Sname")
//                );
//                list.add(stucou);
//            }
//            return list;
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            MysqlJdbcUtil.close();
//        }
//        return null;
//    }
//
//    //修改
//    public int updateSc(int id ,String Cno){
//        String sql ="update StudentCourse set Cno = ? where id=? ";
//        int i = MysqlJdbcUtil.executUpeate(sql,Cno,id);
//        return i;
//    }
//
//    /**
//     * 添加
//     * @return 大于一添加成功
//     */
//    public int addSc(String sno, String con){
//        String sql ="insert into StudentCourse(Sno,Cno) VALUES(?,?);";
//        int i = MysqlJdbcUtil.executUpeate(sql,sno,con);
//        return i;
//    }
//
//    /**
//     * 删除
//     * @param id
//     * @return 大于1执行成功
//     */
//    public int delSc(int id){
//        String sql ="delete from StudentCourse where id=?;";
//        int i = MysqlJdbcUtil.executUpeate(sql,id);
//        return i;
//    }

}
