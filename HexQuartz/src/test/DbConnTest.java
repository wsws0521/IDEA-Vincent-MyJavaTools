package test;

import java.sql.*;

public class DbConnTest {	
	private String dbUrl="jdbc:sqlserver://localhost:1433;DatabaseName=quartzdb";
	private String dbUser="sa";
	private String dbPassword="0521wsws";
	private String jdbcName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//"com.mysql.jdbc.Driver";
	
	//连接数据库
	public Connection getConn(){
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet res = null;
		try{
			Class.forName(jdbcName);
		}
		catch(Exception e){}
		try{
			conn=DriverManager.getConnection(dbUrl,dbUser,dbPassword);
			
			String sql = "select * from QRTZ_TRIGGERS";//查询触发器表
			statement = conn.prepareStatement(sql);
			res = statement.executeQuery();
			while(res.next()){
				String title = res.getString("trigger_name");//获取test_name列的元素                                                                                                                                                    ;
				System.out.println("触发器名称："+title);
			}
		}
		catch(SQLException ex){}
		finally{
			try {
				if(res != null) res.close();
				if(statement != null) statement.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {e2.printStackTrace();}
		}
		return conn;		
	}
	
//    测试
	public static void main(String[] args)
	{
		System.out.println(new DbConnTest().getConn());		
	}
	
}

