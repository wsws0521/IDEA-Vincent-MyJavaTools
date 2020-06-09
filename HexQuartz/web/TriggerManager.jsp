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
<script src="js/jquery-1.7.1.min.js" language="javascript" type="text/javascript"></script>
</head>
<script type="text/javascript">
$(function(){
	debugger;
	var listJson=eval('${listTriggerJson}');
	var s = document.getElementById("SchedulerName_SELECT");
	if(listJson.length>0){
		var option=new Option(listJson[0].SCHED_NAME);
		s.options.add(option);
	}
	if(listJson.length>1){	
		for(var i=1;i<listJson.length;i++){
			for(var j=1;j<s.length;j++){
				if(listJson[i].SCHED_NAME!=s.options[j].value&&listJson[i].SCHED_NAME!=s.options[j].text){
					var option=new Option(listJson[i].SCHED_NAME);
					s.options.add(option);
				}
			}
		}
	}
})
</script>
<script type="text/javascript">
function SchedulerStart(){
	debugger;
	form1.State.value="start";
	form1.action="SchedulerState.action";
}
function SchedulerStop(){
	form1.State.value="stop";
	form1.action="SchedulerState.action";
}
function isNull(str){
	if ( str == "" ) return true;
	var regu = "^[ ]+$";
	var re = new RegExp(regu);
	return re.test(str);
}  
</script>
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
										<a href="TriggerManager.action"><strong>触发器管理>></strong></a></td>
									</tr>
									<tr>
										<td height="470" align="center" valign="top" bgcolor="#F6F9FE">
											<form name="form1" method="post" action="TriggerManager.action" >
												<table width="100%%" border="0" cellspacing="0" cellpadding="0">
													<tr>
														<td width="20%" height="30" style="padding-left: 20px;">
															功能导航： <a href="TriggerAdd.jsp">添加触发器</a>
														</td>
														<td width="40%">查询：
															<select name="SearchRow" id="SearchRow">
																<option value="SCHED_NAME">调度名称</option>
																<option value="TRIGGER_NAME">触发器名称</option>
																<option value="JOB_NAME">任务名称</option>
															</select> 
															<input name="SearchKey" type="text" class="text1" id="SearchKey"> 
															<input type="submit" name="button" id="button" value="点击查询">
														</td>
														<td width="40%">按调度器名称启停：
															<select name="SchedulerName_SELECT" id="SchedulerName_SELECT" >
																<option value="">请选择</option>
															</select> 
															<input name="State" id="State" type="hidden" value="">
															<input type="submit" name="button2" id="button2" value="启动" onclick="SchedulerStart()">
															<input type="submit" name="button3" id="button3" value="停止" onclick="SchedulerStop()">
														</td>
													</tr>
												</table>
											</form>
											
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
												<tr align="center" class="t1">
													<td height="25" bgcolor="#D5E4F4"><strong>调度名称</strong></td>
													<td bgcolor="#D5E4F4"><strong>触发器名称</strong></td>
													<td bgcolor="#D5E4F4"><strong>触发器组</strong></td>
													<td bgcolor="#D5E4F4"><strong>任务名称</strong></td>
													<td bgcolor="#D5E4F4"><strong>任务组</strong></td>													
													<td bgcolor="#D5E4F4"><strong>描述</strong></td>
													<td bgcolor="#D5E4F4"><strong>下次启动时间</strong></td>
													<td bgcolor="#D5E4F4"><strong>上次启动时间</strong></td>
													<td bgcolor="#D5E4F4"><strong>优先级</strong></td>
													<td bgcolor="#D5E4F4"><strong>状态</strong></td>
													<td bgcolor="#D5E4F4"><strong>类型</strong></td>
													<td bgcolor="#D5E4F4"><strong>开始时间</strong></td>
													<td bgcolor="#D5E4F4"><strong>结束时间</strong></td>
													
													<td bgcolor="#D5E4F4"><strong>操作</strong></td>
												</tr>
												<s:iterator id="aa" value="list">
													<tr align="center">
														<td height="25" align="center">${SCHED_NAME}</td>
														<td align="center">${TRIGGER_NAME}</td>
														<td align="center">${TRIGGER_GROUP}</td>
														<td align="center">${JOB_NAME}</td>
														<td align="center">${JOB_GROUP}</td>														
														<td align="center">${DESCRIPTION}</td>
														<td align="center">${NEXT_FIRE_TIME}</td>
														<td align="center">${PREV_FIRE_TIME}</td>
														<td align="center">${PRIORITY}</td>
														<td align="center">${TRIGGER_STATE}</td>
														<td align="center">${TRIGGER_TYPE}</td>
														<td align="center">${START_TIME}</td>
														<td align="center">${END_TIME}</td>
														
														<td align="center">
														<a href="TriggerUpdate.action?TRIGGER_NAME=${TRIGGER_NAME}">修改</a>
														<a href="TriggerDel.action?SCHED_NAME=${SCHED_NAME}&TRIGGER_NAME=${TRIGGER_NAME}&TRIGGER_GROUP=${TRIGGER_GROUP}"
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
