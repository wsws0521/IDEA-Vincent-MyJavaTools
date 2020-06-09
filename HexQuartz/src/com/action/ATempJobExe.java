package com.action;

import static org.quartz.DateBuilder.evenMinuteDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.TriggerBuilder.newTrigger;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.quartz.DateBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jobs.HelloJob01;
import com.opensymphony.xwork2.ActionSupport;

public class ATempJobExe extends ActionSupport{
	//下面是Action内用于封装用户请求参数的属性
		private String JOB_GROUP ;
	    private String JOB_NAME ;
	    private String TRIGGER_GROUP ;
	    private String TRIGGER_NAME ;
	    private int Delay_Sec ;
	    private String MYJOBS_CLASSNAME ;
		public String getJOB_GROUP() {
			return JOB_GROUP;
		}
		public void setJOB_GROUP(String cookJOB_GROUP) {
			JOB_GROUP = cookJOB_GROUP;
		}
		public String getJOB_NAME() {
			return JOB_NAME;
		}
		public void setJOB_NAME(String cookJOB_NAME) {
			JOB_NAME = cookJOB_NAME;
		}
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
			Logger log = LoggerFactory.getLogger(ATempJobExe.class);
		    log.info("------- Initializing ----------------------");
		    SchedulerFactory sf = new StdSchedulerFactory();
		    Scheduler sched = sf.getScheduler();
		    log.info("------- Initialization Complete -----------");
		    Date runTime = evenMinuteDate(new Date());//从下一分钟开始
		    //Date startTime = DateBuilder.nextGivenSecondDate(null, Delay_Sec);
		    log.info("------- Scheduling Job  -------------------");
		    JobDetail job = newJob(HelloJob01.class).withIdentity(JOB_NAME, JOB_GROUP).build();
		    Trigger trigger = newTrigger().withIdentity(TRIGGER_NAME, TRIGGER_GROUP).startAt(runTime).build();
		    sched.scheduleJob(job, trigger);
		    log.info(job.getKey() + " will run at: " + runTime);
		    sched.start();
		    log.info("------- Started Scheduler -----------------");
		    log.info("------- Waiting 65 seconds... -------------");
		    try {
		      Thread.sleep(65L * 1000L);
		    } catch (Exception e) { }
		    log.info("------- Shutting Down ---------------------");
		    sched.shutdown(true);
		    log.info("------- Shutdown Complete -----------------");
			
			//跳转
			out.print("<script language='javascript'>alert('任务执行完成！');window.location='ATempJob.action';</script>");
			out.flush();out.close();return null;
		}
		
		
}
