package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class TriggerSimpleUpdateSave extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private String SCHED_NAME;
	private String TRIGGER_NAME;
	private String TRIGGER_GROUP;
	private String REPEAT_COUNT;
	private String REPEAT_INTERVAL;
	
	
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
		
		//��ѯ�����¼�Ƿ���Ȼ����
		List<TriggerSimpleBean> list=new TriggerSimpleDao().GetList("SCHED_NAME='"+SCHED_NAME+"' and TRIGGER_NAME='"+TRIGGER_NAME+"' and TRIGGER_GROUP='"+TRIGGER_GROUP+"'", "");
		if(list.size()==0)
		{
			out.print("<script language='javascript'>alert('��Ҫ�޸ĵļ�¼�Ѳ����ڣ�����ԭ��������ִ�н�����');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		//�޸�
		
		TriggerSimpleBean cnbean=new TriggerSimpleBean();
		cnbean=new TriggerSimpleDao().GetBean(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP);
		cnbean.setREPEAT_COUNT(Long.parseLong(REPEAT_COUNT));
		cnbean.setREPEAT_INTERVAL(Long.parseLong(REPEAT_INTERVAL));
		
		new TriggerSimpleDao().Update(cnbean);
		    
		//��ת
		out.print("<script language='javascript'>alert('�޸ĳɹ���');window.location='JobDetailManager.action';</script>");
		out.flush();out.close();return null;
		
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
