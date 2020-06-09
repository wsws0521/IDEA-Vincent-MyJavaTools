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
	// ������Action�����ڷ�װ�û��������������(Bean)
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
	// ������Action�����ڷ�װ�û�����search����
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

	// �����û������execute����
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
		// ��ѯ����
		String strWhere = "1=1";//row��keyΪ�յ�ʱ���ѯ*
		if (!(isInvalid(SearchKey))) {
			strWhere += " and " + SearchRow + "='" + SearchKey + "'";
		}
		// ��ѯ����
		list = new TriggerDao().GetList(strWhere, "Trigger_GROUP");
		listTriggerJson=JSONArray.fromObject(list);
		
		return SUCCESS;
	}

	// �ж��Ƿ��ֵ
	private boolean isInvalid(String value) {
		return (value == null || value.length() == 0);
	}

	// ����
	public static void main(String[] args) {
		System.out.println();
	}
	

}
