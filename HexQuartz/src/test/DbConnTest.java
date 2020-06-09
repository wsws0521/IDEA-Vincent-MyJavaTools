package test;

import java.sql.*;

public class DbConnTest {	
	private String dbUrl="jdbc:sqlserver://localhost:1433;DatabaseName=quartzdb";
	private String dbUser="sa";
	private String dbPassword="0521wsws";
	private String jdbcName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//"com.mysql.jdbc.Driver";
	
	//�������ݿ�
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
			
			String sql = "select * from QRTZ_TRIGGERS";//��ѯ��������
			statement = conn.prepareStatement(sql);
			res = statement.executeQuery();
			while(res.next()){
				String title = res.getString("trigger_name");//��ȡtest_name�е�Ԫ��                                                                                                                                                    ;
				System.out.println("���������ƣ�"+title);
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
	
//    ����
	public static void main(String[] args)
	{
		System.out.println(new DbConnTest().getConn());		
	}
	
}

