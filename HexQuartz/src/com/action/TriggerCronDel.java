package com.action;

import static org.quartz.TriggerKey.triggerKey;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

import com.db.PropHelper;
import com.opensymphony.xwork2.ActionSupport;

public class TriggerCronDel extends ActionSupport{
	//下面是Action内用于封装用户请求参数的属性
	private String SCHED_NAME ;
	private String TRIGGER_NAME ;
	private String TRIGGER_GROUP ;
	public String getSCHED_NAME() {
		return SCHED_NAME;
	}
	public void setSCHED_NAME(String sCHED_NAME) {
		SCHED_NAME = sCHED_NAME;
	}
	public String getTRIGGER_NAME() {
		return TRIGGER_NAME;
	}
	public void setTRIGGER_NAME(String tRIGGER_NAME) {
		TRIGGER_NAME = tRIGGER_NAME;
	}
	public String getTRIGGER_GROUP() {
		return TRIGGER_GROUP;
	}
	public void setTRIGGER_GROUP(String tRIGGER_GROUP) {
		TRIGGER_GROUP = tRIGGER_GROUP;
	}
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
		
		
		//【任务删除】应从调度器中删除...
		//由于调度器一旦被停止（不论任何原因），SCHED_NAME将被从SchedulerRepository中删除
		//sf.getScheduler(SCHED_NAME)返回null，找不到调度器
		//但是，以SCHED_NAME之名再次启动Scheduler，之前该名称下残留的任务将重新复活
		//所以，需要重新构造该名称的调度器（无需启动），再逆操作unscheduleJob。
		StdSchedulerFactory sf = new StdSchedulerFactory();
		Properties props = new PropHelper().getProp();
		props.put("org.quartz.scheduler.instanceName", SCHED_NAME);
		//props.put("org.quartz.threadPool.threadCount", "10");//亦可更改
		sf.initialize(props);
	    Scheduler sched = sf.getScheduler();
	    //Trigger.TriggerState st=sched.getTriggerState(triggerKey(TRIGGER_NAME,TRIGGER_GROUP));
	    boolean result=sched.unscheduleJob(triggerKey(TRIGGER_NAME,TRIGGER_GROUP));
		//int result=new JobDetailDao().Delete("SCHED_NAME='"+SCHED_NAME+"' and JOB_NAME='"+JOB_NAME+"' and JOB_GROUP='"+JOB_GROUP+"'");
		
		if(result){out.print("<script language='javascript'>alert('删除成功！');window.location='TriggerCronManager.action';</script>");
		out.flush();out.close();return null;}
		return SUCCESS;		
	}
	
	//判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//测试
	public static void main(String[] args) {
		System.out.println();
	}

}
