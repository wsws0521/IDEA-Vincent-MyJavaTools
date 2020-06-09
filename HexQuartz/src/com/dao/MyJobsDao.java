package com.dao;

import java.sql.*;
import java.util.*;

import com.bean.*;
import com.db.DBHelper;

public class MyJobsDao {
	// 获取列表
	public List<MyJobsBean> GetList(String strwhere, String strorder) {
		String sql = "select * from MYJOBS";
		if (!(isInvalid(strwhere))) {
			sql += " where " + strwhere;
		}
		if (!(isInvalid(strorder))) {
			sql += " order by " + strorder;
		}
		Statement stat = null;
		ResultSet rs = null;
		Connection conn = new DBHelper().getConn();
		List<MyJobsBean> list = new ArrayList<MyJobsBean>();
		try {
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			while (rs.next()) {
				MyJobsBean cnbean = new MyJobsBean();
				String jobsFullName=rs.getString("MYJOBS_CLASSNAME");
				String jobsName=jobsFullName.substring(jobsFullName.lastIndexOf('.')+1);
				cnbean.setMYJOBS_CLASSNAME(jobsName);
				cnbean.setMYJOBS_DESCRIPTION(rs.getString("MYJOBS_DESCRIPTION"));
				
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

	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	// 测试
	public static void main(String[] args) {
		System.out.println("");
	}
}
