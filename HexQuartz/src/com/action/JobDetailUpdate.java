package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class JobDetailUpdate extends ActionSupport {

	//������Action�����ڷ�װ�û��������������
	private JobDetailBean cnbean;
	private List<MyJobsBean> listMy;
	public JobDetailBean getCnbean() {
		return cnbean;
	}
	public void setCnbean(JobDetailBean cnbean) {
		this.cnbean = cnbean;
	}
	public List<MyJobsBean> getListMy() {
		return listMy;
	}
	public void setListMy(List<MyJobsBean> listMy) {
		this.listMy = listMy;
	}
	
	private String SCHED_NAME;
	private String JOB_NAME;
	private String JOB_GROUP;
	public String getSCHED_NAME() {
		return SCHED_NAME;
	}
	public void setSCHED_NAME(String sCHED_NAME) {
		SCHED_NAME = sCHED_NAME;
	}
	public String getJOB_NAME() {
		return JOB_NAME;
	}
	public void setJOB_NAME(String jOB_NAME) {
		JOB_NAME = jOB_NAME;
	}
	public String getJOB_GROUP() {
		return JOB_GROUP;
	}
	public void setJOB_GROUP(String jOB_GROUP) {
		JOB_GROUP = jOB_GROUP;
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
		
		//��ѯ
		setCnbean(new JobDetailDao().GetBean(SCHED_NAME,JOB_NAME,JOB_GROUP));
		listMy = new MyJobsDao().GetList("1=1", "MYJOBS_CLASSNAME");
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

