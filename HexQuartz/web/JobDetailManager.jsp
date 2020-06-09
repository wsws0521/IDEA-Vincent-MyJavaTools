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
										<a href="JobDetailManager.action"><strong>任务细节>></strong></a></td>
									</tr>
									<tr>
										<td height="470" align="center" valign="top" bgcolor="#F6F9FE">
										<form name="form1" method="post" action="JobDetailManager.action">
												<table width="100%%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td width="28%" height="30" style="padding-left: 20px;">
															功能导航： <a href="JobDetailAdd.action">添加持久化任务>></a>
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
													<td bgcolor="#D5E4F4"><strong>任务名称</strong></td>
													<td bgcolor="#D5E4F4"><strong>任务组</strong></td>													
													<td bgcolor="#D5E4F4"><strong>描述</strong></td>
													<td bgcolor="#D5E4F4"><strong>任务类</strong></td>
													<td bgcolor="#D5E4F4"><strong>持久化</strong></td>
													<td bgcolor="#D5E4F4"><strong>非共点</strong></td>
													<td bgcolor="#D5E4F4"><strong>更新数据</strong></td>
													<td bgcolor="#D5E4F4"><strong>恢复请求</strong></td>
													
													<td bgcolor="#D5E4F4"><strong>操作</strong></td>
												</tr>
												<s:iterator id="aa" value="list">
													<tr align="center">
														<td height="25" align="center">${SCHED_NAME}</td>
														<td align="center">${JOB_NAME}</td>
														<td align="center">${JOB_GROUP}</td>														
														<td align="center">${DESCRIPTION}</td>
														<td align="center">${JOB_CLASS_NAME}</td>
														<td align="center">${IS_DURABLE}</td>
														<td align="center">${IS_NONCONCURRENT}</td>
														<td align="center">${IS_UPDATE_DATA}</td>
														<td align="center">${REQUESTS_RECOVERY}</td>
														
														<td align="center">
														<a href="JobDetailUpdate.action?SCHED_NAME=${SCHED_NAME}&JOB_NAME=${JOB_NAME}&JOB_GROUP=${JOB_GROUP}">修改</a>
														<a href="JobDetailDel.action?SCHED_NAME=${SCHED_NAME}&JOB_NAME=${JOB_NAME}&JOB_GROUP=${JOB_GROUP}"
															onClick="return confirm('确定要删除该执行中的任务吗？')">删除</a></td>
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
