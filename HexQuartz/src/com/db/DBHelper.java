package com.db;

import java.sql.*;
import java.util.*;

public class DBHelper {	
	//连接数据库
	public Connection getConn()  {
//		Connection con = null;
//		StdSchedulerFactory SSF=new StdSchedulerFactory();
//		String DSname=SSF.
//		Scheduler Sch=SSF.getScheduler();
//		DBConnectionManager dbMgr=null;
		
//		Properties prop=new Properties();
//		try{
//			InputStream in =new BufferedInputStream(new FileInputStream("src/quartz.properties"));
//			prop.load(in);
//		}catch(Exception e){}
//		
//		
//		return con;
		Connection conn = null;
//		PropertiesParser cfg;
		
		Properties props=new PropHelper().getProp();
		
		String jdbcName=props.getProperty("org.quartz.dataSource.sampDS.driver");
		String dbUrl=props.getProperty("org.quartz.dataSource.sampDS.URL");
		String dbUser=props.getProperty("org.quartz.dataSource.sampDS.user");
		String dbPassword=props.getProperty("org.quartz.dataSource.sampDS.password");
		try {
			Class.forName(jdbcName);
			conn=DriverManager.getConnection(dbUrl,dbUser,dbPassword);
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return conn;
		
		
		
		
		
		
		
		
//		Connection conn = null;
//		Properties prop=new Properties();
//		try{
//			InputStream in =new BufferedInputStream(new FileInputStream("src/quartz.properties"));
//			prop.load(in);
//			String jdbcName=prop.getProperty("org.quartz.dataSource.sampDS.driver");
//			String dbUrl=prop.getProperty("org.quartz.dataSource.sampDS.URL");
//			String dbUser=prop.getProperty("org.quartz.dataSource.sampDS.user");
//			String dbPassword=prop.getProperty("org.quartz.dataSource.sampDS.password");
//			Class.forName(jdbcName);
//			conn=DriverManager.getConnection(dbUrl,dbUser,dbPassword);
//			in.close();
//		}catch(Exception e){}
//		return conn;				
	}
	
//    测试
	public static void main(String[] args) 
	{		
		System.out.println(new DBHelper().getConn());		
	}
	
}
