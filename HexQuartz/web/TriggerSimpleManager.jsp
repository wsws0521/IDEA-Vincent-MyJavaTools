<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>任务调度管理系统</title>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<center>
		<table style="width: 100%;" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td height="60" bgcolor="#E6F5FF"
					style="color: #06F; font-size: 19px; font-weight: bolder; padding-left: 50px;">任务调度管理系统</td>
			</tr>
			<tr>
				<td height="30" background="Images/MenuBg.jpg">&nbsp;</td>
			</tr>
			<tr>
				<td height="500" align="center" valign="top">
				<table style="width: 100%;"
						border="0" cellspacing="0" cellpadding="0">
						<tr>
							<td width="200" height="500" align="center" valign="top"
								background="Images/leftbg.jpg"><%@ include file="Left.jsp"%>
							</td>
							<td align="center" valign="top" bgcolor="#F6F9FE">
								<table style="width: 100%;" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="30" background="Images/mainMenuBg.jpg" style="padding-left: 25px;">
										<a href=TriggerSimpleManager.action><strong>Simple触发器管理>></strong></a></td>
									</tr>
									<tr>
										<td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form
												name="form1" method="post" action="TriggerSimpleManager.action">
												<table width="100%%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td width="28%" height="30" style="padding-left: 20px;">
															功能导航： <a href="TriggerSimpleAdd.action">添加 Simple 触发器/任务</a>
														</td>
														<td width="72%">查询： <select name="SearchRow"
															id="SearchRow">
																<option value="SCHED_NAME">调度名称</option>
																<option value="TRIGGER_NAME">触发器名称</option>
																<option value="JOB_NAME">任务名称</option>
														</select> <input name="SearchKey" type="text" class="text1"
															id="SearchKey"> <input type="submit"
															name="button" id="button" value="点击查询"></td>
													</tr>
												</table>
											</form>
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr align="center" class="t1">
													<td height="25" bgcolor="#D5E4F4"><strong>调度名称</strong></td>
													<td bgcolor="#D5E4F4"><strong>触发器名称</strong></td>
													<td bgcolor="#D5E4F4"><strong>触发器组</strong></td>
													<td bgcolor="#D5E4F4"><strong>重复次数</strong></td>
													<td bgcolor="#D5E4F4"><strong>重复间隔</strong></td>													
													<td bgcolor="#D5E4F4"><strong>触发次数</strong></td>
													
													<td bgcolor="#D5E4F4"><strong>操作</strong></td>
												</tr>
												<s:iterator id="aa" value="list">
													<tr align="center">
														<td height="25" align="center">${SCHED_NAME}</td>
														<td align="center">${TRIGGER_NAME}</td>
														<td align="center">${TRIGGER_GROUP}</td>
														<td align="center">${REPEAT_COUNT}</td>
														<td align="center">${REPEAT_INTERVAL}</td>														
														<td align="center">${TIMES_TRIGGERED}</td>
														
														<td align="center">
															<a href="TriggerSimpleUpdate.action?SCHED_NAME=${SCHED_NAME}&TRIGGER_NAME=${TRIGGER_NAME}&TRIGGER_GROUP=${TRIGGER_GROUP}">修改</a>
															<a href="TriggerSimpleDel.action?SCHED_NAME=${SCHED_NAME}&TRIGGER_NAME=${TRIGGER_NAME}&TRIGGER_GROUP=${TRIGGER_GROUP}" onClick="return confirm('确定要停止该触发器吗？')">删除</a>
														</td>
													</tr>
												</s:iterator>
											</table></td>
									</tr>
								</table>
							</td>
						</tr>
					</table></td>
			</tr>
			<tr>
				<td height="35" background="Images/bootBg.jpg">&nbsp;</td>
			</tr>
		</table>

	</center>
</body>
</html>
