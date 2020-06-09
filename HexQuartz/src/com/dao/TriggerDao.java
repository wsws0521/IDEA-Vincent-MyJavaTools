package com.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import com.bean.*;
import com.db.DBHelper;

public class TriggerDao {
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
		public List<TriggerBean> GetList(String strwhere,String strorder) throws SQLException{
			String sql="select * from QRTZ_TRIGGERS";
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
			List<TriggerBean> list=new ArrayList<TriggerBean>();
			SimpleDateFormat format =  new SimpleDateFormat("yyyyMMdd HH:mm:ss.SSS");			
			try{
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);				
				while(rs.next()){
					TriggerBean cnbean=new TriggerBean();
					cnbean.setSCHED_NAME(rs.getString("SCHED_NAME"));
					cnbean.setTRIGGER_NAME(rs.getString("TRIGGER_NAME"));
					cnbean.setTRIGGER_GROUP(rs.getString("TRIGGER_GROUP"));
					cnbean.setJOB_NAME(rs.getString("JOB_NAME"));
					cnbean.setJOB_GROUP(rs.getString("JOB_GROUP"));
					cnbean.setDESCRIPTION(rs.getString("DESCRIPTION"));
					String NEXT_FIRE_TIME=format.format(rs.getLong("NEXT_FIRE_TIME"));
					cnbean.setNEXT_FIRE_TIME(NEXT_FIRE_TIME);
					String PREV_FIRE_TIME=format.format(rs.getLong("PREV_FIRE_TIME"));
					cnbean.setPREV_FIRE_TIME(PREV_FIRE_TIME);
					cnbean.setPRIORITY(rs.getInt("PRIORITY"));
					cnbean.setTRIGGER_STATE(rs.getString("TRIGGER_STATE"));
					cnbean.setTRIGGER_TYPE(rs.getString("TRIGGER_TYPE"));
					String START_TIME=format.format(rs.getLong("START_TIME"));
					cnbean.setSTART_TIME(START_TIME);
					String END_TIME=format.format(rs.getLong("END_TIME"));
					cnbean.setEND_TIME(END_TIME);
					cnbean.setCALENDAR_NAME(rs.getString("CALENDAR_NAME"));
					cnbean.setMISFIRE_INSTR(rs.getShort("MISFIRE_INSTR"));
					cnbean.setJOB_DATA(rs.getString("JOB_DATA"));
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
		public TriggerBean GetBean(String name,String group){
			String sql="select * from QRTZ_TRIGGERS where TRIGGER_NAME='"+name+"' and TRIGGER_GROUP='"+group+"'";
			Statement stat = null;
			ResultSet rs = null;
			Connection conn = new DBHelper().getConn();
			TriggerBean cnbean=new TriggerBean();
			SimpleDateFormat format =  new SimpleDateFormat("yyyyMMdd HH:mm:ss.SSS");
			try{
				stat = conn.createStatement();
				rs = stat.executeQuery(sql);							
				while(rs.next()){
					cnbean.setSCHED_NAME(rs.getString("SCHED_NAME"));
					cnbean.setTRIGGER_NAME(rs.getString("TRIGGER_NAME"));
					cnbean.setTRIGGER_GROUP(rs.getString("TRIGGER_GROUP"));
					cnbean.setJOB_NAME(rs.getString("JOB_NAME"));
					cnbean.setJOB_GROUP(rs.getString("JOB_GROUP"));
					cnbean.setDESCRIPTION(rs.getString("DESCRIPTION"));
					String NEXT_FIRE_TIME=format.format(rs.getLong("NEXT_FIRE_TIME"));
					cnbean.setNEXT_FIRE_TIME(NEXT_FIRE_TIME);
					String PREV_FIRE_TIME=format.format(rs.getLong("PREV_FIRE_TIME"));
					cnbean.setPREV_FIRE_TIME(PREV_FIRE_TIME);
					cnbean.setPRIORITY(rs.getInt("PRIORITY"));
					cnbean.setTRIGGER_STATE(rs.getString("TRIGGER_STATE"));
					cnbean.setTRIGGER_TYPE(rs.getString("TRIGGER_TYPE"));
					String START_TIME=format.format(rs.getLong("START_TIME"));
					cnbean.setSTART_TIME(START_TIME);
					String END_TIME=format.format(rs.getLong("END_TIME"));
					cnbean.setEND_TIME(END_TIME);
					cnbean.setCALENDAR_NAME(rs.getString("CALENDAR_NAME"));
					cnbean.setMISFIRE_INSTR(rs.getShort("MISFIRE_INSTR"));
					cnbean.setJOB_DATA(rs.getString("JOB_DATA"));
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
//		//修改
//		public void Update(TriggerBean cnbean){
//			String sql="update QRTZ_TRIGGERS set ";
//			sql+="Teacher_Username='"+cnbean.getTeacher_Username()+"',";
//			sql+="Teacher_Password='"+cnbean.getTeacher_Password()+"',";
//			sql+="Teacher_Name='"+cnbean.getTeacher_Name()+"',";
//			sql+="Teacher_Sex='"+cnbean.getTeacher_Sex()+"',";
//			sql+="Teacher_Tel='"+cnbean.getTeacher_Tel()+"'";
//			
//			sql+=" where Teacher_ID='"+cnbean.getTeacher_ID()+"'";
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
		//删除
		public void Delete(String strwhere){
			String sql="delete from QRTZ_TRIGGERS where ";
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
