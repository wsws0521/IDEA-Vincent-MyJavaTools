package com.action;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.TriggerBuilder.newTrigger;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.quartz.DateBuilder;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import org.quartz.Trigger;
import org.quartz.examples.example02.SimpleTriggerExample;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jobs.*;
import com.opensymphony.xwork2.ActionSupport;

public class TriggerSimpleAddExe extends ActionSupport{
	//下面是Action内用于封装用户请求参数的属性
			
    private String TRIGGER_GROUP ;
    private String TRIGGER_NAME ;
    private int Delay_Sec ;
    private String MYJOBS_CLASSNAME ;
    private String REPEAT_COUNT;
    private String REPEAT_INTERVAL;
    private String JOB_GROUP;
    private String JOB_NAME;
	
	public String getTRIGGER_GROUP() {
		return TRIGGER_GROUP;
	}
	public void setTRIGGER_GROUP(String cookTRIGGER_GROUP) {
		TRIGGER_GROUP = cookTRIGGER_GROUP;
	}
	public String getTRIGGER_NAME() {
		return TRIGGER_NAME;
	}
	public void setTRIGGER_NAME(String cookTRIGGER_NAME) {
		TRIGGER_NAME = cookTRIGGER_NAME;
	}
	public int getDelay_Sec() {
		return Delay_Sec;
	}
	public void setDelay_Sec(int cookDelay_Sec) {
		Delay_Sec = cookDelay_Sec;
	}
	public String getMYJOBS_CLASSNAME() {
		return MYJOBS_CLASSNAME;
	}
	public void setMYJOBS_CLASSNAME(String cookMYJOBS_CLASSNAME) {
		MYJOBS_CLASSNAME = cookMYJOBS_CLASSNAME;
	}
	public String getREPEAT_COUNT() {
		return REPEAT_COUNT;
	}
	public void setREPEAT_COUNT(String rEPEAT_COUNT) {
		REPEAT_COUNT = rEPEAT_COUNT;
	}
	public String getREPEAT_INTERVAL() {
		return REPEAT_INTERVAL;
	}
	public void setREPEAT_INTERVAL(String rEPEAT_INTERVAL) {
		REPEAT_INTERVAL = rEPEAT_INTERVAL;
	}
	public String getJOB_GROUP() {
		return JOB_GROUP;
	}
	public void setJOB_GROUP(String jOB_GROUP) {
		JOB_GROUP = jOB_GROUP;
	}
	public String getJOB_NAME() {
		return JOB_NAME;
	}
	public void setJOB_NAME(String jOB_NAME) {
		JOB_NAME = jOB_NAME;
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
		
		Logger log = LoggerFactory.getLogger(SimpleTriggerExample.class);
	    log.info("------- Initializing -------------------");
	    SchedulerFactory sf = new StdSchedulerFactory();
	    //创建新的调度器名称
//		Properties props = new Properties();
//		props.put("org.quartz.scheduler.instanceName", "你定义的名字");
//		props.put("org.quartz.threadPool.threadCount", "10");#必填
//		sf.initialize(props);
	    Scheduler sched = sf.getScheduler();
	    log.info("------- Initialization Complete --------");

	    log.info("------- Scheduling Jobs ----------------");
	    Date startTime = DateBuilder.nextGivenSecondDate(null, Delay_Sec);			    
	    
	    SimpleTrigger trigger = (SimpleTrigger) newTrigger().withIdentity(TRIGGER_NAME, TRIGGER_GROUP).startAt(startTime)
	    		.withSchedule(simpleSchedule().withIntervalInSeconds(Integer.parseInt(REPEAT_INTERVAL)).withRepeatCount(Integer.parseInt(REPEAT_COUNT))).forJob(JOB_NAME, JOB_GROUP).build();

	    // schedule it to run!
	    Date ft = sched.scheduleJob(trigger);
	    log.info(JOB_GROUP+"."+JOB_NAME+ " will run at: " + ft + " and repeat: " + trigger.getRepeatCount() + " times, every " + trigger.getRepeatInterval() / 1000 + " seconds");
	    sched.start();
	    
	    //sched.shutdown(true);
		
		
		
		//跳转
		out.print("<script language='javascript'>alert('任务启动成功！');window.location='TriggerSimpleManager.action';</script>");
		out.flush();out.close();return null;
	}
			
			
}
