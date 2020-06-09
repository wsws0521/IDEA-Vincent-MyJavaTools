package com.dao;

import java.sql.*;
import java.util.*;

import com.bean.*;
import com.db.DBHelper;

public class TriggerSimpleDao {
	// 获取列表
	public List<TriggerSimpleBean> GetList(String strwhere, String strorder) {
		String sql = "select * from QRTZ_SIMPLE_TRIGGERS";
		if (!(isInvalid(strwhere))) {
			sql += " where " + strwhere;
		}
		if (!(isInvalid(strorder))) {
			sql += " order by " + strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<TriggerSimpleBean> list = new ArrayList<TriggerSimpleBean>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				TriggerSimpleBean cnbean = new TriggerSimpleBean();
				cnbean.setSCHED_NAME(rs.getString("SCHED_NAME"));
				cnbean.setTRIGGER_NAME(rs.getString("TRIGGER_NAME"));
				cnbean.setTRIGGER_GROUP(rs.getString("TRIGGER_GROUP"));
				
				cnbean.setREPEAT_COUNT(rs.getLong("REPEAT_COUNT"));
				cnbean.setREPEAT_INTERVAL(rs.getLong("REPEAT_INTERVAL"));
				cnbean.setTIMES_TRIGGERED(rs.getLong("TIMES_TRIGGERED"));
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
	public TriggerSimpleBean GetBean(String SCHED,String name,String group){
		String sql="select * from QRTZ_SIMPLE_TRIGGERS where SCHED_NAME='"+SCHED+"' and TRIGGER_NAME='"+name+"' and TRIGGER_GROUP='"+group+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		TriggerSimpleBean cnbean=new TriggerSimpleBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);							
			while(rs.next()){
				cnbean.setSCHED_NAME(rs.getString("SCHED_NAME"));
				cnbean.setTRIGGER_NAME(rs.getString("TRIGGER_NAME"));
				cnbean.setTRIGGER_GROUP(rs.getString("TRIGGER_GROUP"));
				cnbean.setREPEAT_COUNT(rs.getLong("REPEAT_COUNT"));
				cnbean.setREPEAT_INTERVAL(rs.getLong("REPEAT_INTERVAL"));
				cnbean.setTIMES_TRIGGERED(rs.getLong("TIMES_TRIGGERED"));
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
	
	//修改
	public void Update(TriggerSimpleBean cnbean){
		String sql="update QRTZ_SIMPLE_TRIGGERS set ";
		sql+="REPEAT_COUNT='"+cnbean.getREPEAT_COUNT()+"',";
		sql+="REPEAT_INTERVAL='"+cnbean.getREPEAT_INTERVAL()+"'";		
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
	

	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	// 测试
	public static void main(String[] args) {
		System.out.println("");
	}
}
