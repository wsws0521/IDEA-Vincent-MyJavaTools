package com.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.bean.*;
import com.dao.*;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONArray;

public class InfoOfJT extends ActionSupport{
	// ������Action�����ڷ�װ�û��������������(Bean)
		private List<JobDetailBean> listJob;
		private List<TriggerBean> listTrigger;
		private List<TriggerSimpleBean> listTriggerSimple;
		private List<MyJobsBean> listMy;
		private JSONArray listJobJson;
		private JSONArray listTriggerJson;
		private JSONArray listTriggerSimpleJson;
		public List<JobDetailBean> getListJob() {
			return listJob;
		}
		public void setList(List<JobDetailBean> list) {
			this.listJob = list;
		}
		public List<TriggerBean> getListTrigger() {
			return listTrigger;
		}
		public void setListT(List<TriggerBean> list) {
			this.listTrigger = list;
		}
		public List<TriggerSimpleBean> getListTriggerSimple() {
			return listTriggerSimple;
		}
		public void setListTriggerSimple(List<TriggerSimpleBean> listTriggerSimple) {
			this.listTriggerSimple = listTriggerSimple;
		}
		public List<MyJobsBean> getListMy() {
			return listMy;
		}
		public void setListMy(List<MyJobsBean> listMy) {
			this.listMy = listMy;
		}
		
		public JSONArray getListJobJson() {
			return listJobJson;
		}
		public void setListJson(JSONArray listJobJson) {
			this.listJobJson = listJobJson;
		}
		public JSONArray getListTriggerJson() {
			return listTriggerJson;
		}
		public void setListTriggerJson(JSONArray listTriggerJson) {
			this.listTriggerJson = listTriggerJson;
		}
		public JSONArray getListTriggerSimpleJson() {
			return listTriggerSimpleJson;
		}
		public void setListTriggerSimpleJson(JSONArray listTriggerSimpleJson) {
			this.listTriggerSimpleJson = listTriggerSimpleJson;
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
			listJob = new JobDetailDao().GetList(strWhere, "JOB_GROUP");
			listTrigger = new TriggerDao().GetList(strWhere, "TRIGGER_GROUP");
			listTriggerSimple = new TriggerSimpleDao().GetList(strWhere, "TRIGGER_GROUP");
			listMy = new MyJobsDao().GetList(strWhere, "MYJOBS_CLASSNAME");
			
			listJobJson=JSONArray.fromObject(listJob);
			listTriggerJson=JSONArray.fromObject(listTrigger);
			listTriggerSimpleJson=JSONArray.fromObject(listTriggerSimple);
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



