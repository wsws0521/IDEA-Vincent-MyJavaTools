package com.action;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.quartz.CronExpression;
import org.quartz.CronTrigger;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;

public class Cron5 extends ActionSupport{
	private String cron ;
	public String getCron() {
		return cron;
	}
	public void setCron(String cron) {
		this.cron = cron;
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
		
		String timeSchedule="";
		if(!CronExpression.isValidExpression(cron)){
			timeSchedule = "Cron is invalid...";
		}
		try{
			//CronTrigger trigger = newTrigger().withIdentity("Caclulate Date").withSchedule(cronSchedule(cron)).build();
		    // schedule it to run!
			CronTrigger trigger=newTrigger().withIdentity("Caclulate Date").withSchedule(cronSchedule(cron)).build();
			Date time0=trigger.getStartTime();
			Date time1=trigger.getFireTimeAfter(time0);
			Date time2=trigger.getFireTimeAfter(time1);
			Date time3=trigger.getFireTimeAfter(time2);
			Date time4=trigger.getFireTimeAfter(time3);
			Date time5=trigger.getFireTimeAfter(time4);
			SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			StringBuilder timeBuilder=new StringBuilder();
			timeBuilder
			.append(format.format(time1))
			.append("\n")
			.append(format.format(time2))
			.append("\n")
			.append(format.format(time3))
			.append("\n")
			.append(format.format(time4))
			.append("\n")
			.append(format.format(time5));
			timeSchedule=timeBuilder.toString();
		}
		catch(Exception e){
			timeSchedule="unknow time";
		}	

		List<String> list = new ArrayList<String>();
		list.add(timeSchedule);
		out.write(JSONArray.fromObject(list).toString());		
		
		out.flush();
		out.close();
		return null;
	}
}
