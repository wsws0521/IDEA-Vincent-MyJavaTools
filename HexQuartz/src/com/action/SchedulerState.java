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
		// ����ҳ�������ʽ����ֹ����
		HttpServletResponse response = null;
		response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		// ����session����
		HttpSession session = ServletActionContext.getRequest().getSession();
		// ��֤�Ƿ�������¼
		if (session.getAttribute("type") == null) {
			out.print("<script language='javascript'>alert('�����µ�¼��');window.location='Login.jsp';</script>");
			out.flush();
			out.close();
			return null;
		}
		
		if (!(isInvalid(SchedulerName_SELECT))){
			StdSchedulerFactory sf = new StdSchedulerFactory();
			Properties props = new PropHelper().getProp();
			props.put("org.quartz.scheduler.instanceName", SchedulerName_SELECT);
			//props.put("org.quartz.threadPool.threadCount", "10");//��ɸ���
			sf.initialize(props);
		    Scheduler sched = sf.getScheduler();
		    String ss=State;
		    if(ss=="start"){
		    	sched.start();
		    	out.print("<script language='javascript'>alert('�õ����������ɹ���');window.location='TriggerManager.action';</script>");
			}
		    else if(State=="stop"){
		    	sched.shutdown();
		    	out.print("<script language='javascript'>alert('�õ�������ֹͣ��');window.location='TriggerManager.action';</script>");
			}else{
				out.print("<script language='javascript'>alert('State����δ��ֵ��');window.location='TriggerManager.action';</script>");				
			}
		}else{out.print("<script language='javascript'>alert('��ѡ����Ӧ��������');window.location='TriggerManager.action';</script>");}
		out.flush();out.close();
		return null;
	}
	// �ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	
}
