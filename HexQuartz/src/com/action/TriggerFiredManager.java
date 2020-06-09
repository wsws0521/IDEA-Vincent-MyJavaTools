package com.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.*;
import com.dao.*;
import com.opensymphony.xwork2.ActionSupport;

public class TriggerFiredManager extends ActionSupport {
	// ������Action�����ڷ�װ�û��������������(Bean)
	private List<TriggerFiredBean> list;

	public List<TriggerFiredBean> getList() {
		return list;
	}

	public void setList(List<TriggerFiredBean> list) {
		this.list = list;
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
		list = new TriggerFiredDao().GetList(strWhere, "SCHED_NAME");

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
