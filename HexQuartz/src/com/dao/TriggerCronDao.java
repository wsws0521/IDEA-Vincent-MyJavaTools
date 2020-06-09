package com.dao;

import java.sql.*;
import java.util.*;

import com.bean.*;
import com.db.DBHelper;

public class TriggerCronDao {
//	//验证登录
//		public String CheckLogin(String username, String password){
//			String id = null;
//			String sql="select * from Teacher where Teacher_Username='"+username+"' and Teacher_Password='"+password+"'";
//			Statement stat = null;
//			ResultSet rs = null;
//			Connection conn = new DBHelper().getConn();
//			try{
//				stat = conn.createStatement();
//				rs = stat.executeQuery(sql);
//				while (rs.next()) {
//					id = rs.getString("Teacher_ID");
//				}
//			}
//			catch(SQLException ex){}
//			return id;
//		}
//		//验证密码
//		public boolean CheckPassword(String id, String password){
//			boolean ps = false;
//			String sql="select * from QRTZ_TRIGGERS where Teacher_ID='"+id+"' and Teacher_Password='"+password+"'";
//			Statement stat = null;
//			ResultSet rs = null;
//			Connection conn = new DBHelper().getConn();
//			try{
//				stat = conn.createStatement();
//				rs = stat.executeQuery(sql);
//				while (rs.next()) {
//					ps=true;
//				}
//			}
//			catch(SQLException ex){}
//			return ps;
//		}
		//获取列表
		public List<TriggerCronBean> GetList(String strwhere,String strorder) throws SQLException{
			String sql="select * from QRTZ_CRON_TRIGGERS";
			if(!(isInvalid(strwhere)))
			{
				sql+=" where "+strwhere;
			}
			if(!(isInvalid(strorder)))
			{
				sql+=" order by "+strorder;
			}
			Statement stat = null;
			ResultSet rs = null;
			Connection conn = new DBHelper().getConn();
			List<TriggerCronBean> list=new ArrayList<TriggerCronBean>();			
			try{
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);				
				while(rs.next()){
					TriggerCronBean cnbean=new TriggerCronBean();
					cnbean.setSCHED_NAME(rs.getString("SCHED_NAME"));
					cnbean.setTRIGGER_NAME(rs.getString("TRIGGER_NAME"));
					cnbean.setTRIGGER_GROUP(rs.getString("TRIGGER_GROUP"));
					cnbean.setCRON_EXPRESSION(rs.getString("CRON_EXPRESSION"));
					cnbean.setTIME_ZONE_ID(rs.getString("TIME_ZONE_ID"));
					list.add(cnbean);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null)
						conn.close();
					if (stat != null)
						stat.close();
					if (rs != null)
						rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return list;
		}
		
		//获取指定触发器名称&组名的实体Bean
		public TriggerCronBean GetBean(String SCHED,String name,String group){
			String sql="select * from QRTZ_CRON_TRIGGERS where SCHED_NAME='"+SCHED+"' and TRIGGER_NAME='"+name+"' and TRIGGER_GROUP='"+group+"'";
			Statement stat = null;
			ResultSet rs = null;
			Connection conn = new DBHelper().getConn();
			TriggerCronBean cnbean=new TriggerCronBean();
			try{
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);							
				while(rs.next()){
					cnbean.setSCHED_NAME(rs.getString("SCHED_NAME"));
					cnbean.setTRIGGER_NAME(rs.getString("TRIGGER_NAME"));
					cnbean.setTRIGGER_GROUP(rs.getString("TRIGGER_GROUP"));
					cnbean.setCRON_EXPRESSION(rs.getString("CRON_EXPRESSION"));
					cnbean.setTIME_ZONE_ID(rs.getString("TIME_ZONE_ID"));					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null)
						conn.close();
					if (stat != null)
						stat.close();
					if (rs != null)
						rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return cnbean;
		}
		
//		//添加
//		public void Add(TriggerBean cnbean){
//			String sql="insert into QRTZ_TRIGGERS (";
//			sql+="TRIGGER_NAME,TRIGGER_GROUP,Teacher_Name,Teacher_Sex,Teacher_Tel";
//			sql+=") values(";
//			sql+="'"+cnbean.getTeacher_Username()+"','"+cnbean.getTeacher_Password()+"','"+cnbean.getTeacher_Name()+"','"+cnbean.getTeacher_Sex()+"','"+cnbean.getTeacher_Tel()+"'";
//			sql+=")";
//			Statement stat = null;
//			ResultSet rs = null;
//			Connection conn = new DBHelper().getConn();
//			try{
//				stat = conn.createStatement();
//				stat.executeUpdate(sql);
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				try {
//					if (conn != null)
//						conn.close();
//					if (stat != null)
//						stat.close();
//					if (rs != null)
//						rs.close();
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//			}
//		}
		//修改
		public void Update(TriggerCronBean cnbean){
			String sql="update QRTZ_CRON_TRIGGERS set ";
			sql+="CRON_EXPRESSION='"+cnbean.getCRON_EXPRESSION()+"',";
			sql+=" where SCHED_NAME='"+cnbean.getSCHED_NAME()+"' and TRIGGER_NAME='"+cnbean.getTRIGGER_NAME()+"' and TRIGGER_GROUP='"+cnbean.getTRIGGER_GROUP()+"'";
			Statement stat = null;
			ResultSet rs = null;
			Connection conn = new DBHelper().getConn();
			try{
				stat = conn.createStatement();
				stat.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null)
						conn.close();
					if (stat != null)
						stat.close();
					if (rs != null)
						rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		//删除
		public void Delete(String strwhere){
			String sql="delete from QRTZ_CRON_TRIGGERS where ";
			sql+=strwhere;
			Statement stat = null;
			ResultSet rs = null;
			Connection conn = new DBHelper().getConn();
			try{
				stat = conn.createStatement();
				stat.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (conn != null)
						conn.close();
					if (stat != null)
						stat.close();
					if (rs != null)
						rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		
		//判断是否空值
		private boolean isInvalid(String value) {
			return (value == null || value.length() == 0);
		}
		
		//测试
		public static void main(String[] args) {
			System.out.println("");
		}
}
