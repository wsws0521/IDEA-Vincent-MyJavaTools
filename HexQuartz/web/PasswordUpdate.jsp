<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>任务调度管理系统</title>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<center>
  <table style="width: 100%;" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="60" bgcolor="#E6F5FF" style="color:#06F; font-size:19px; font-weight:bolder; padding-left:50px;">任务调度管理系统</td>
    </tr>
    <tr>
      <td height="30" background="Images/MenuBg.jpg">&nbsp;</td>
    </tr>
    <tr>
      <td height="500" align="center" valign="top">
      <table style="width: 100%;" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="200" height="500" align="center" valign="top" background="Images/leftbg.jpg">
          <%@ include file="Left.jsp"%>
          </td>
          <td align="center" valign="middle" bgcolor="#F6F9FE">
			<form name="form1" method="post" action="PasswordUpdateSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%">&nbsp;</td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>请输入原密码：</td>
                    <td><input name="Password" type="password" class="text2" id="Password">
                      <%if(request.getAttribute("Msg")!=null){%>
                      <span style="color:red;"><%=request.getAttribute("Msg")%></span>
                      <%}%></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>请输入新密码：</td>
                    <td><input name="Password2" type="password" class="text2" id="Password2"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>请重复新密码：</td>
                    <td><input name="Password3" type="password" class="text2" id="Password3"></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="修改密码"></td>
                  </tr>
                </table>
              </form>
          </td>
        </tr>
      </table>
      </td>
    </tr>
    <tr>
      <td height="35" background="Images/bootBg.jpg">&nbsp;</td>
    </tr>
  </table>

</center>
</body>
</html>