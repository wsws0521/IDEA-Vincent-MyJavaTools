package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class JobDetailUpdateSave extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private String SCHED_NAME;
	private String JOB_NAME;
	private String JOB_GROUP;
	private String DESCRIPTION;
	private String JOB_CLASS_NAME;
	private String IS_DURABLE;
	private String IS_NONCONCURRENT;
	private String IS_UPDATE_DATA;
	private String REQUESTS_RECOVERY;
	private String MYJOBS_CLASSNAME;
	public String getREQUESTS_RECOVERY() {
		return REQUESTS_RECOVERY;
	}
	public void setREQUESTS_RECOVERY(String rEQUESTS_RECOVERY) {
		REQUESTS_RECOVERY = rEQUESTS_RECOVERY;
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
	public String getSCHED_NAME() {
		return SCHED_NAME;
	}
	public void setSCHED_NAME(String sCHED_NAME) {
		SCHED_NAME = sCHED_NAME;
	}
	public String getDESCRIPTION() {
		return DESCRIPTION;
	}
	public void setDESCRIPTION(String dESCRIPTION) {
		DESCRIPTION = dESCRIPTION;
	}
	public String getJOB_CLASS_NAME() {
		return JOB_CLASS_NAME;
	}
	public void setJOB_CLASS_NAME(String jOB_CLASS_NAME) {
		JOB_CLASS_NAME = jOB_CLASS_NAME;
	}
	public String getIS_DURABLE() {
		return IS_DURABLE;
	}
	public void setIS_DURABLE(String iS_DURABLE) {
		IS_DURABLE = iS_DURABLE;
	}
	public String getIS_NONCONCURRENT() {
		return IS_NONCONCURRENT;
	}
	public void setIS_NONCONCURRENT(String iS_NONCONCURRENT) {
		IS_NONCONCURRENT = iS_NONCONCURRENT;
	}
	public String getIS_UPDATE_DATA() {
		return IS_UPDATE_DATA;
	}
	public void setIS_UPDATE_DATA(String iS_UPDATE_DATA) {
		IS_UPDATE_DATA = iS_UPDATE_DATA;
	}
	public String getMYJOBS_CLASSNAME() {
		return MYJOBS_CLASSNAME;
	}
	public void setMYJOBS_CLASSNAME(String mYJOBS_CLASSNAME) {
		MYJOBS_CLASSNAME = mYJOBS_CLASSNAME;
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
		
		//查询任务记录是否任然存在
		List<JobDetailBean> list=new JobDetailDao().GetList("SCHED_NAME='"+SCHED_NAME+"' and JOB_NAME='"+JOB_NAME+"' and JOB_GROUP='"+JOB_GROUP+"'", "");
		if(list.size()==0)
		{
			out.print("<script language='javascript'>alert('您要修改的记录已不存在！可能原因：任务已执行结束！');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		//修改
		
		JobDetailBean cnbean=new JobDetailBean();
		cnbean=new JobDetailDao().GetBean(SCHED_NAME,JOB_NAME,JOB_GROUP);
		cnbean.setDESCRIPTION(DESCRIPTION);
		cnbean.setJOB_CLASS_NAME("com.jobs."+MYJOBS_CLASSNAME);
		cnbean.setIS_DURABLE(IS_DURABLE);
		cnbean.setIS_NONCONCURRENT(IS_NONCONCURRENT);
		cnbean.setIS_UPDATE_DATA(IS_UPDATE_DATA);
		cnbean.setREQUESTS_RECOVERY(REQUESTS_RECOVERY);
		
		new JobDetailDao().Update(cnbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('修改成功！');window.location='JobDetailManager.action';</script>");
		out.flush();out.close();return null;
		
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
