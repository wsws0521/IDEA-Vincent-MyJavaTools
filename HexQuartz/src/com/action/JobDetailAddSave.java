package com.action;

import static org.quartz.JobBuilder.newJob;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;
import com.opensymphony.xwork2.ActionSupport;

public class JobDetailAddSave extends ActionSupport{
	//������Action�����ڷ�װ�û��������������
		private String JOB_GROUP ;
	    private String JOB_NAME ;	    
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
		public String getMYJOBS_CLASSNAME() {
			return MYJOBS_CLASSNAME;
		}
		public void setMYJOBS_CLASSNAME(String cookMYJOBS_CLASSNAME) {
			MYJOBS_CLASSNAME = cookMYJOBS_CLASSNAME;
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
			try {
				SchedulerFactory sf = new StdSchedulerFactory();
			    Scheduler sched = sf.getScheduler();
				Class my=Class.forName("com.jobs."+MYJOBS_CLASSNAME);
				JobDetail job = newJob(my).withIdentity(JOB_NAME, JOB_GROUP).storeDurably().build();
			    sched.addJob(job, true);
			  //��ת
				out.print("<script language='javascript'>alert('���������ɣ�');window.location='JobDetailManager.action';</script>");
				out.flush();out.close();return null;
			} catch (ClassNotFoundException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
				out.print("<script language='javascript'>alert('�������ʧ�ܣ�');window.location='JobDetailManager.action';</script>");
				out.flush();out.close();return null;
			}
			
			
		}
		
		
}
