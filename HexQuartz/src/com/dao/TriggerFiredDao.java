package com.dao;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import com.bean.*;
import com.db.DBHelper;

public class TriggerFiredDao {
	public List<TriggerFiredBean> GetList(String strwhere,String strorder) throws SQLException{
		String sql="select * from QRTZ_FIRED_TRIGGERS";
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
		List<TriggerFiredBean> list=new ArrayList<TriggerFiredBean>();
		SimpleDateFormat format =  new SimpleDateFormat("yyyyMMdd HH:mm:ss.SSS");			
		try{
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);				
			while(rs.next()){
				TriggerFiredBean cnbean=new TriggerFiredBean();
				cnbean.setSCHED_NAME(rs.getString("SCHED_NAME"));
				cnbean.setENTRY_ID(rs.getString("ENTRY_ID"));
				cnbean.setTRIGGER_NAME(rs.getString("TRIGGER_NAME"));
				cnbean.setTRIGGER_GROUP(rs.getString("TRIGGER_GROUP"));
				cnbean.setINSTANCE_NAME(rs.getString("INSTANCE_NAME"));
				String FIRED_TIME=format.format(rs.getLong("FIRED_TIME"));
				cnbean.setFIRED_TIME(FIRED_TIME);
				String SCHED_TIME=format.format(rs.getLong("SCHED_TIME"));
				cnbean.setSCHED_TIME(SCHED_TIME);
				cnbean.setPRIORITY(rs.getInt("PRIORITY"));
				cnbean.setSTATE(rs.getString("STATE"));
				cnbean.setJOB_NAME(rs.getString("JOB_NAME"));
				cnbean.setJOB_GROUP(rs.getString("JOB_GROUP"));
				cnbean.setIS_NONCONCURRENT(rs.getString("IS_NONCONCURRENT"));
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
	
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//≤‚ ‘
	public static void main(String[] args) {
		System.out.println("");
	}
}
