package com.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class GoIndex extends ActionSupport {

	
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
				return INPUT;
			}
			else
				return SUCCESS;
			
		}
}
