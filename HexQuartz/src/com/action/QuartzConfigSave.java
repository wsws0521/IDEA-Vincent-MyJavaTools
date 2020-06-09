package com.action;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.db.PropHelper;
import com.opensymphony.xwork2.ActionSupport;

public class QuartzConfigSave extends ActionSupport{
	private String instanceName;
	private String threadPoolclass;
	private String threadCount;
	private String jobStoreclass;
	private String tablePrefix;
	private String driverDelegateClass;
	private String dataSource;
	private String jdbcName;
	private String dbUrl;
	private String dbUser;
	private String dbPassword;
	//处理用户请求的execute方法
	public String execute() throws Exception {
		
		//解决乱码，用于页面输出
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		//创建session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		//验证是否正常登录
		if(session.getAttribute("type")==null){
			out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		new PropHelper().setProps(instanceName, threadPoolclass, threadCount, jobStoreclass, tablePrefix, driverDelegateClass, dataSource, jdbcName, dbUrl, dbUser, dbPassword);
		
	    //跳转
  		out.print("<script language='javascript'>alert('修改成功！');window.location='QuartzConfig.action';</script>");
  		out.flush();out.close();return null;
	}
	public String getInstanceName() {
		return instanceName;
	}
	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}
	public String getThreadPoolclass() {
		return threadPoolclass;
	}
	public void setThreadPoolclass(String threadPoolclass) {
		this.threadPoolclass = threadPoolclass;
	}
	public String getThreadCount() {
		return threadCount;
	}
	public void setThreadCount(String threadCount) {
		this.threadCount = threadCount;
	}
	public String getJobStoreclass() {
		return jobStoreclass;
	}
	public void setJobStoreclass(String jobStoreclass) {
		this.jobStoreclass = jobStoreclass;
	}
	public String getTablePrefix() {
		return tablePrefix;
	}
	public void setTablePrefix(String tablePrefix) {
		this.tablePrefix = tablePrefix;
	}
	public String getDriverDelegateClass() {
		return driverDelegateClass;
	}
	public void setDriverDelegateClass(String driverDelegateClass) {
		this.driverDelegateClass = driverDelegateClass;
	}
	public String getDataSource() {
		return dataSource;
	}
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	public String getJdbcName() {
		return jdbcName;
	}
	public void setJdbcName(String jdbcName) {
		this.jdbcName = jdbcName;
	}
	public String getDbUrl() {
		return dbUrl;
	}
	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}
	public String getDbUser() {
		return dbUser;
	}
	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}
	public String getDbPassword() {
		return dbPassword;
	}
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}	
}
