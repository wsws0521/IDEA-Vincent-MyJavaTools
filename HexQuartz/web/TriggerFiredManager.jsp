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
										<a href="TriggerFiredManager.action"><strong>触发中触发器查询>></strong></a></td>
									</tr>
									<tr>
										<td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form
												name="form1" method="post" action="TriggerManager.action">
												<table width="100%%" border="0" cellspacing="0"
													cellpadding="0">
													<tr>
														<td width="28%" height="30" style="padding-left: 20px;">
															无法添加此类触发器
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
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
												<tr align="center" class="t1">
													<td height="25" bgcolor="#D5E4F4"><strong>调度名称</strong></td>
													<td bgcolor="#D5E4F4"><strong>登记ID</strong></td>
													<td bgcolor="#D5E4F4"><strong>触发器名称</strong></td>
													<td bgcolor="#D5E4F4"><strong>触发器组</strong></td>
													<td bgcolor="#D5E4F4"><strong>实例名称</strong></td>
													<td bgcolor="#D5E4F4"><strong>触发时间</strong></td>
													<td bgcolor="#D5E4F4"><strong>调度时间</strong></td>
													<td bgcolor="#D5E4F4"><strong>优先级</strong></td>
													<td bgcolor="#D5E4F4"><strong>状态</strong></td>													
													<td bgcolor="#D5E4F4"><strong>任务名称</strong></td>
													<td bgcolor="#D5E4F4"><strong>任务组</strong></td>																										
													<td bgcolor="#D5E4F4"><strong>非共点</strong></td>
													<td bgcolor="#D5E4F4"><strong>请求恢复</strong></td>
													
													<td bgcolor="#D5E4F4"><strong>操作</strong></td>
												</tr>
												<s:iterator id="aa" value="list">
													<tr align="center">
														<td height="25" align="center">${SCHED_NAME}</td>
														<td align="center">${ENTRY_ID}</td>
														<td align="center">${TRIGGER_NAME}</td>
														<td align="center">${TRIGGER_GROUP}</td>
														<td align="center">${INSTANCE_NAME}</td>
														<td align="center">${FIRED_TIME}</td>
														<td align="center">${SCHED_TIME}</td>
														<td align="center">${PRIORITY}</td>
														<td align="center">${STATE}</td>														
														<td align="center">${JOB_NAME}</td>
														<td align="center">${JOB_GROUP}</td>																												
														<td align="center">${IS_NONCONCURRENT}</td>
														<td align="center">${REQUESTS_RECOVERY}</td>
																												
														<td align="center"><a
															href="TriggerUpdate.action?TRIGGER_NAME=${TRIGGER_NAME}">修改</a>
															<a href="TriggerDel.action?TRIGGER_NAME=${TRIGGER_NAME}"
															onClick="return confirm('确定要删除该触发器吗？')">删除</a></td>
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
