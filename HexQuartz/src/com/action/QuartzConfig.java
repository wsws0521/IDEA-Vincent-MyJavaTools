package com.action;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.db.PropHelper;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;

public class QuartzConfig extends ActionSupport {
	
	private Map<String, String> quartzMap;
	public Map<String, String> getQuartzMap() {
		return quartzMap;
	}
	public void setQuartzMap(Map<String, String> quartzMap) {
		this.quartzMap = quartzMap;
	}
	
	
	public String execute() throws Exception {
		// 设置页面输出格式，防止乱码
		HttpServletResponse response = null;
		response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		// 创建session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		// 验证是否正常登录
		if (session.getAttribute("type") == null) {
			out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
			out.flush();
			out.close();
			return null;
		}
		Properties props=new PropHelper().getProp();
				
		quartzMap = new HashMap<String, String>();
		quartzMap.put("dbPassword", props.getProperty("org.quartz.dataSource.sampDS.password"));
		quartzMap.put("dbUser", props.getProperty("org.quartz.dataSource.sampDS.user"));
		quartzMap.put("dbUrl", props.getProperty("org.quartz.dataSource.sampDS.URL"));
		quartzMap.put("jdbcName", props.getProperty("org.quartz.dataSource.sampDS.driver"));
		quartzMap.put("dataSource", props.getProperty("org.quartz.jobStore.dataSource"));
		
		quartzMap.put("driverDelegateClass", props.getProperty("org.quartz.jobStore.driverDelegateClass"));
		quartzMap.put("tablePrefix", props.getProperty("org.quartz.jobStore.tablePrefix"));
		quartzMap.put("jobStoreclass", props.getProperty("org.quartz.jobStore.class"));
		quartzMap.put("threadCount", props.getProperty("org.quartz.threadPool.threadCount"));
		quartzMap.put("threadPoolclass", props.getProperty("org.quartz.threadPool.class"));
		quartzMap.put("instanceName", props.getProperty("org.quartz.scheduler.instanceName"));
		return SUCCESS;
	}

}
