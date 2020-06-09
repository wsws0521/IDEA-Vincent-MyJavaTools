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
	// 下面是Action内用于封装用户请求参数的属性(Bean)
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
			listJob = new JobDetailDao().GetList(strWhere, "JOB_GROUP");
			listTrigger = new TriggerDao().GetList(strWhere, "TRIGGER_GROUP");
			listTriggerSimple = new TriggerSimpleDao().GetList(strWhere, "TRIGGER_GROUP");
			listMy = new MyJobsDao().GetList(strWhere, "MYJOBS_CLASSNAME");
			
			listJobJson=JSONArray.fromObject(listJob);
			listTriggerJson=JSONArray.fromObject(listTrigger);
			listTriggerSimpleJson=JSONArray.fromObject(listTriggerSimple);
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



