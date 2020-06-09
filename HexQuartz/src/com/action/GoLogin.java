package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

import com.dao.AdminDao;
import com.opensymphony.xwork2.ActionSupport;

public class GoLogin extends ActionSupport {
	
	// 下面是Action内用于封装用户请求参数的属性	
	private String Username;
	private String Password;
	private String Msg;

	
	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getMsg() {
		return Msg;
	}

	public void setMsg(String msg) {
		Msg = msg;
	}

	// 处理用户请求的execute方法
	public String execute() throws Exception {
		// 创建session
		HttpSession session = ServletActionContext.getRequest().getSession();
		ArrayList<String> info=new AdminDao().CheckLogin(Username, Password);
		String role=info.get(0);
		String id=info.get(1);
		if (role == null) {
			Msg = "身份/用户名/密码有问题";
			return INPUT;
		} else if (role.equals("系统管理员") ){		
			session.setAttribute("type", "1");
			session.setAttribute("id", id);
			return SUCCESS;
		}else if (role.equals("普通用户")){
			session.setAttribute("type", "2");
			session.setAttribute("id", id);
			return SUCCESS;
		}else{
			Msg = "暂未开启该角色";
			return INPUT;
		}
	}
}
