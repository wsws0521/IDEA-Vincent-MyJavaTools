package com.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class GoIndex extends ActionSupport {

	
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
				return INPUT;
			}
			else
				return SUCCESS;
			
		}
}
