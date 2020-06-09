package com.dao;

import java.sql.*;
import java.util.*;

import com.bean.*;
import com.db.DBHelper;

public class JobDetailDao {
	// 获取列表
	public List<JobDetailBean> GetList(String strwhere, String strorder) {
		String sql = "select * from QRTZ_JOB_DETAILS";
		if (!(isInvalid(strwhere))) {
			sql += " where " + strwhere;
		}
		if (!(isInvalid(strorder))) {
			sql += " order by " + strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<JobDetailBean> list = new ArrayList<JobDetailBean>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				JobDetailBean cnbean = new JobDetailBean();
				cnbean.setSCHED_NAME(rs.getString("SCHED_NAME"));
				cnbean.setJOB_NAME(rs.getString("JOB_NAME"));
				cnbean.setJOB_GROUP(rs.getString("JOB_GROUP"));
				cnbean.setDESCRIPTION(rs.getString("DESCRIPTION"));
				cnbean.setJOB_CLASS_NAME(rs.getString("JOB_CLASS_NAME"));
				cnbean.setIS_DURABLE(rs.getString("IS_DURABLE"));
				cnbean.setIS_NONCONCURRENT(rs.getString("IS_NONCONCURRENT"));
				cnbean.setIS_UPDATE_DATA(rs.getString("IS_UPDATE_DATA"));
				cnbean.setREQUESTS_RECOVERY(rs.getString("REQUESTS_RECOVERY"));				
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
	
	//获取指定任务名称&组名的实体Bean
	public JobDetailBean GetBean(String SCHED,String name,String group){
		String sql="select * from QRTZ_JOB_DETAILS where SCHED_NAME='"+SCHED+"' and JOB_NAME='"+name+"' and JOB_GROUP='"+group+"'";
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		JobDetailBean cnbean=new JobDetailBean();
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				cnbean.setSCHED_NAME(rs.getString("SCHED_NAME"));
				cnbean.setJOB_NAME(rs.getString("JOB_NAME"));
				cnbean.setJOB_GROUP(rs.getString("JOB_GROUP"));
				cnbean.setDESCRIPTION(rs.getString("DESCRIPTION"));
				cnbean.setJOB_CLASS_NAME(rs.getString("JOB_CLASS_NAME"));
				cnbean.setIS_DURABLE(rs.getString("IS_DURABLE"));
				cnbean.setIS_NONCONCURRENT(rs.getString("IS_NONCONCURRENT"));
				cnbean.setIS_UPDATE_DATA(rs.getString("IS_UPDATE_DATA"));
				cnbean.setREQUESTS_RECOVERY(rs.getString("REQUESTS_RECOVERY"));
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
	public void Update(JobDetailBean cnbean){
		String sql="update QRTZ_JOB_DETAILS set ";
		sql+="DESCRIPTION='"+cnbean.getDESCRIPTION()+"',";
		sql+="JOB_CLASS_NAME='"+cnbean.getJOB_CLASS_NAME()+"',";
		sql+="IS_DURABLE='"+cnbean.getIS_DURABLE()+"',";
		sql+="IS_NONCONCURRENT='"+cnbean.getIS_NONCONCURRENT()+"',";
		sql+="IS_UPDATE_DATA='"+cnbean.getIS_UPDATE_DATA()+"',";
		sql+="REQUESTS_RECOVERY='"+cnbean.getREQUESTS_RECOVERY()+"'";
		sql+=" where SCHED_NAME='"+cnbean.getSCHED_NAME()+"' and JOB_NAME='"+cnbean.getJOB_NAME()+"' and JOB_GROUP='"+cnbean.getJOB_GROUP()+"'";
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
	public int Delete(String strwhere){
		int result=0;
		String sql="delete from QRTZ_JOB_DETAILS where ";
		sql+=strwhere;
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		try{
			stat = conn.createStatement();
			result=stat.executeUpdate(sql);				
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
		return result;
	}

	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	// 测试
	public static void main(String[] args) {
		System.out.println("");
	}
}
