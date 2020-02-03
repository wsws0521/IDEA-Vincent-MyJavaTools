package com.vincent.mysql.util;

import java.sql.*;

public class MysqlJdbcUtil {
    private static String driver = "com.mysql.jdbc.Driver";//驱动
    //数据库
    private static String url = "jdbc:mysql://192.168.80.34:3306/centlec0118?useUnicode=true&characterEncoding=UTF-8";
    private static String user = "Ctlcuat1";//用户名
    private static String pwd = "Hex123@0";//密码
    private static Connection conn = null;//连接对象
    private static Statement stat = null;//执行语句对象

    //打开数据库连接
    public static void open() {
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //打开连接--实例化数据库连接对象
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //关闭数据库连接对象，释放内存
    public static void close() {
        try {
            //判断数据库是否处于连接中
            if (conn != null && conn.isClosed()) {
                conn.close();
            }
            if (stat != null) {
                stat.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /***
     * 查询所有数据
     */
    public static ResultSet executeQuery(String sql) {
        try {
            open();
            stat = conn.createStatement();
            return stat.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 条件查询、分页查询
     * @param sql 数据库执行语句
     * @param o 参数
     * @return 反回一个集合命令
     */
    public static ResultSet executeQuery(String sql,Object... o){
        try {
            open();
            PreparedStatement pst=conn.prepareStatement(sql);
            for(int i=0;i<o.length;i++)
                pst.setObject(i+1, o[i]);
            return pst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**执行增、删、改*/
    public static int executUpeate(String sql, Object... obj) {
        try {
            open();
            PreparedStatement pst = conn.prepareStatement(sql);
            for (int i = 0; i < obj.length; i++) {
                pst.setObject(i + 1, obj[i]);
            }
            stat = pst;
            return pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
