package com.action;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;

import com.dao.AdminDao;
import com.opensymphony.xwork2.ActionSupport;

public class GoLogin extends ActionSupport {
	
	// ������Action�����ڷ�װ�û��������������	
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

	// �����û������execute����
	public String execute() throws Exception {
		// ����session
		HttpSession session = ServletActionContext.getRequest().getSession();
		ArrayList<String> info=new AdminDao().CheckLogin(Username, Password);
		String role=info.get(0);
		String id=info.get(1);
		if (role == null) {
			Msg = "���/�û���/����������";
			return INPUT;
		} else if (role.equals("ϵͳ����Ա") ){		
			session.setAttribute("type", "1");
			session.setAttribute("id", id);
			return SUCCESS;
		}else if (role.equals("��ͨ�û�")){
			session.setAttribute("type", "2");
			session.setAttribute("id", id);
			return SUCCESS;
		}else{
			Msg = "��δ�����ý�ɫ";
			return INPUT;
		}
	}
}
