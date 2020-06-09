package com.action;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;

import com.bean.*;
import com.dao.*;


public class TriggerCronUpdateSave extends ActionSupport {

	//下面是Action内用于封装用户请求参数的属性
	private String SCHED_NAME;
	private String TRIGGER_NAME;
	private String TRIGGER_GROUP;
	private String CRON_EXPRESSION;
	
	
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
	public String getCRON_EXPRESSION() {
		return CRON_EXPRESSION;
	}
	public void setCRON_EXPRESSION(String cRON_EXPRESSION) {
		CRON_EXPRESSION = cRON_EXPRESSION;
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
		List<TriggerCronBean> list=new TriggerCronDao().GetList("SCHED_NAME='"+SCHED_NAME+"' and TRIGGER_NAME='"+TRIGGER_NAME+"' and TRIGGER_GROUP='"+TRIGGER_GROUP+"'", "");
		if(list.size()==0)
		{
			out.print("<script language='javascript'>alert('您要修改的记录已不存在！可能原因：任务已执行结束！');history.back(-1);</script>");
			out.flush();out.close();return null;
		}
		//修改
		
		TriggerCronBean cnbean=new TriggerCronBean();
		cnbean=new TriggerCronDao().GetBean(SCHED_NAME,TRIGGER_NAME,TRIGGER_GROUP);
		cnbean.setCRON_EXPRESSION(CRON_EXPRESSION);
		
		new TriggerCronDao().Update(cnbean);
		    
		//跳转
		out.print("<script language='javascript'>alert('修改成功！');window.location='TriggerCronManager.action';</script>");
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
