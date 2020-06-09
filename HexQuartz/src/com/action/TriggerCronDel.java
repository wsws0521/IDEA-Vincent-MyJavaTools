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
	//������Action�����ڷ�װ�û��������������
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
	//�����û������execute����
	public String execute() throws Exception {
		
		//������룬����ҳ�����
		HttpServletResponse response=null;
		response=ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();		
		//����session����
		HttpSession session = ServletActionContext.getRequest().getSession();
		//��֤�Ƿ�������¼
		if(session.getAttribute("type")==null){
			out.print("<script language='javascript'>alert('�����µ�¼��');window.location='Login.jsp';</script>");
			out.flush();out.close();return null;
		}
		
		
		//������ɾ����Ӧ�ӵ�������ɾ��...
		//���ڵ�����һ����ֹͣ�������κ�ԭ�򣩣�SCHED_NAME������SchedulerRepository��ɾ��
		//sf.getScheduler(SCHED_NAME)����null���Ҳ���������
		//���ǣ���SCHED_NAME֮���ٴ�����Scheduler��֮ǰ�������²������������¸���
		//���ԣ���Ҫ���¹�������Ƶĵ��������������������������unscheduleJob��
		StdSchedulerFactory sf = new StdSchedulerFactory();
		Properties props = new PropHelper().getProp();
		props.put("org.quartz.scheduler.instanceName", SCHED_NAME);
		//props.put("org.quartz.threadPool.threadCount", "10");//��ɸ���
		sf.initialize(props);
	    Scheduler sched = sf.getScheduler();
	    //Trigger.TriggerState st=sched.getTriggerState(triggerKey(TRIGGER_NAME,TRIGGER_GROUP));
	    boolean result=sched.unscheduleJob(triggerKey(TRIGGER_NAME,TRIGGER_GROUP));
		//int result=new JobDetailDao().Delete("SCHED_NAME='"+SCHED_NAME+"' and JOB_NAME='"+JOB_NAME+"' and JOB_GROUP='"+JOB_GROUP+"'");
		
		if(result){out.print("<script language='javascript'>alert('ɾ���ɹ���');window.location='TriggerCronManager.action';</script>");
		out.flush();out.close();return null;}
		return SUCCESS;		
	}
	
	//�ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}
	
	//����
	public static void main(String[] args) {
		System.out.println();
	}

}
