package com.action;

import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

import com.db.PropHelper;
import com.opensymphony.xwork2.ActionSupport;

public class SchedulerState extends ActionSupport {
	private String State;
	private String SchedulerName_SELECT;
	public String getSchedulerName_SELECT() {
		return SchedulerName_SELECT;
	}
	public void setSchedulerName_SELECT(String schedulerName_SELECT) {
		SchedulerName_SELECT = schedulerName_SELECT;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
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
		
		if (!(isInvalid(SchedulerName_SELECT))){
			StdSchedulerFactory sf = new StdSchedulerFactory();
			Properties props = new PropHelper().getProp();
			props.put("org.quartz.scheduler.instanceName", SchedulerName_SELECT);
			//props.put("org.quartz.threadPool.threadCount", "10");//亦可更改
			sf.initialize(props);
		    Scheduler sched = sf.getScheduler();
		    String ss=State;
		    if(ss=="start"){
		    	sched.start();
		    	out.print("<script language='javascript'>alert('该调度器启动成功！');window.location='TriggerManager.action';</script>");
			}
		    else if(State=="stop"){
		    	sched.shutdown();
		    	out.print("<script language='javascript'>alert('该调度器已停止！');window.location='TriggerManager.action';</script>");
			}else{
				out.print("<script language='javascript'>alert('State变量未赋值！');window.location='TriggerManager.action';</script>");				
			}
		}else{out.print("<script language='javascript'>alert('请选择相应调度器！');window.location='TriggerManager.action';</script>");}
		out.flush();out.close();
		return null;
	}
	// 判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	
}
