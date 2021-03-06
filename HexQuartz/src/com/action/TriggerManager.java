package com.action;

import java.io.PrintWriter;
import java.util.List;
import java.util.Properties;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

import com.bean.*;
import com.dao.*;
import com.db.PropHelper;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;

public class TriggerManager extends ActionSupport {
	// 下面是Action内用于封装用户请求参数的属性(Bean)
	private List<TriggerBean> list;
	private JSONArray listTriggerJson;

	public List<TriggerBean> getList() {
		return list;
	}
	public void setList(List<TriggerBean> list) {
		this.list = list;
	}
	public JSONArray getListTriggerJson() {
		return listTriggerJson;
	}
	public void setListTriggerJson(JSONArray listTriggerJson) {
		this.listTriggerJson = listTriggerJson;
	}
	// 下面是Action内用于封装用户请求search条件
	private String SearchRow;
	private String SearchKey;

	public String getSearchRow() {
		return SearchRow;
	}
	public void setSearchRow(String searchRow) {
		SearchRow = searchRow;
	}
	public String getSearchKey() {
		return SearchKey;
	}
	public void setSearchKey(String searchKey) {
		SearchKey = searchKey;
	}	

	// 处理用户请求的execute方法
	public String execute() throws Exception {
		// 设置页面输出格式，防止乱码
		HttpServletResponse response = null;
		response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();

		// 创建session对象
		HttpSession session = ServletActionContext.getRequest().getSession();
		// 验证是否正常登录
		if (session.getAttribute("type") == null) {
			out.print("<script language='javascript'>alert('请重新登录！');window.location='Login.jsp';</script>");
			out.flush();
			out.close();
			return null;
		}
		// 查询条件
		String strWhere = "1=1";//row与key为空的时候查询*
		if (!(isInvalid(SearchKey))) {
			strWhere += " and " + SearchRow + "='" + SearchKey + "'";
		}
		// 查询所有
		list = new TriggerDao().GetList(strWhere, "Trigger_GROUP");
		listTriggerJson=JSONArray.fromObject(list);
		
		return SUCCESS;
	}

	// 判断是否空值
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	// 测试
	public static void main(String[] args) {
		System.out.println();
	}
	

}
