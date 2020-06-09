<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<link href="Style/Style.css" rel="stylesheet" type="text/css" />


<table width="155" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td height="31" align="center" background="Images/left1.jpg"><strong>系统选项</strong></td>
	</tr>
	<tr>
		<td height="50" align="center" valign="top"><table width="150"
				border="0" cellspacing="0" cellpadding="0">
				<tr>
					<td height="5" align="center"><img src="Images/ic.gif"
						width="1" height="1"></td>
				</tr>
				<tr>
					<td height="30" align="center" background="Images/left2.jpg"
						style="text-align: left; padding-left: 40px;"><a
						href="Index.action">后台首页</a></td>
				</tr>
				<tr>
					<td height="5" align="center"><img src="Images/ic.gif"
						width="1" height="1"></td>
				</tr>
				<%
					if (session.getAttribute("type").toString().equals("1")) {
				%>
				<tr>
					<td height="30" align="center" background="Images/left2.jpg"
						style="text-align: left; padding-left: 40px;"><a
						href="ATempJob.action">一个临时任务</a></td>
				</tr>
				<tr>
					<td height="5" align="center"><img src="Images/ic.gif"
						width="1" height="1"></td>
				</tr>
				<tr>
					<td height="30" align="center" background="Images/left2.jpg"
						style="text-align: left; padding-left: 40px;">
						<a href="TriggerManager.action"><strong>触发器管理</strong></a></td>
				</tr>
				<tr>
					<td height="5" align="center"><img src="Images/ic.gif"
						width="1" height="1"></td>
				</tr>
				<tr>
					<td height="30" align="center" background="Images/left2.jpg"
						style="text-align: left; padding-left: 40px;"><a
						href="TriggerSimpleManager.action">Simple 触发器</a></td>
				</tr>
				<tr>
					<td height="5" align="center"><img src="Images/ic.gif"
						width="1" height="1"></td>
				</tr>
				<tr>
					<td height="30" align="center" background="Images/left2.jpg"
						style="text-align: left; padding-left: 40px;"><a
						href="TriggerCronManager.action">Cron 触发器</a></td>
				</tr>
				<tr>
					<td height="5" align="center"><img src="Images/ic.gif"
						width="1" height="1"></td>
				</tr>
				<tr>
					<td height="30" align="center" background="Images/left2.jpg"
						style="text-align: left; padding-left: 40px;"><a
						href="TriggerFiredManager.action">Fired 触发器</a></td>
				</tr>
				<tr>
					<td height="5" align="center"><img src="Images/ic.gif"
						width="1" height="1"></td>
				</tr>
				
				<tr>
					<td height="30" align="center" background="Images/left2.jpg"
						style="text-align: left; padding-left: 40px;"><a
						href="JobDetailManager.action">任务细节</a></td>
				</tr>
				<tr>
					<td height="5" align="center"><img src="Images/ic.gif"
						width="1" height="1"></td>
				</tr>
				
				<%
					}
				%>
				<%
					if (session.getAttribute("type").toString().equals("2")) {
				%>
				<tr>
					<td height="30" align="center" background="Images/left2.jpg"
						style="text-align: left; padding-left: 40px;"><a
						href="MyStudent.action">--</a></td>
				</tr>
				<tr>
					<td height="5" align="center"><img src="Images/ic.gif"
						width="1" height="1"></td>
				</tr>
				<tr>
					<td height="30" align="center" background="Images/left2.jpg"
						style="text-align: left; padding-left: 40px;"><a
						href="MyLog.action">--</a></td>
				</tr>
				<tr>
					<td height="5" align="center"><img src="Images/ic.gif"
						width="1" height="1"></td>
				</tr>
				<%
					}
				%>
				<%
					if (session.getAttribute("type").toString().equals("1")) {
				%>
				<tr>
					<td height="30" align="center" background="Images/left2.jpg"
						style="text-align: left; padding-left: 40px;"><a
						href="QuartzConfig.action">Quartz参数配置</a></td>
				</tr>
				<tr>
					<td height="5" align="center"><img src="Images/ic.gif"
						width="1" height="1"></td>
				</tr>
				<%
					}
				%>
				<tr>
					<td height="30" align="center" background="Images/left2.jpg"
						style="text-align: left; padding-left: 40px;"><a
						href="PasswordUpdate.jsp">修改密码</a></td>
				</tr>
				<tr>
					<td height="5" align="center"><img src="Images/ic.gif"
						width="1" height="1"></td>
				</tr>
				<tr>
					<td height="30" align="center" background="Images/left2.jpg"
						style="text-align: left; padding-left: 40px;"><a
						href="Quit.action" onclick="return confirm('确定要退出系统吗？')">退出系统</a></td>
				</tr>
			</table></td>
	</tr>
</table>