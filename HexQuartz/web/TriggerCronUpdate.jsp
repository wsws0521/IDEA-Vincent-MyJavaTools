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

<script language="JavaScript">
function mycheck(){
	debugger;
   if(isNull(form1.SCHED_NAME.value)){  
   alert("请输入调度名称！"); 
   return false;
   }
   if(isNull(form1.JOB_NAME.value)){
   alert("请输入任务名称！");
   return false;
   }
   if(isNull(form1.JOB_GROUP.value)){
   alert("请输入任务组别！");
   return false;
   }   
   if(isNull(form1.MYJOBS_CLASSNAME.value)){
   alert("请选择要更换的任务操作类！");
   return false;
   }   
//    debugger;
//    var listJson=eval('${listJobJson}');
//    var jobgroup=form1.JOB_GROUP.value;
//    var jobname=form1.JOB_NAME.value;
//    for(var i=0;i<listJson.length;i++){
// 	   if(listJson[i].JOB_GROUP==jobgroup){
// 		   if(listJson[i].JOB_NAME==jobname){
// 			   alert("该任务组别内已存在该任务名称，请更换任务名称或组别！"); 
// 			   return false;
// 		   }
// 	   }
//    }
}

function isNull(str){
if ( str == "" ) return true;
var regu = "^[ ]+$";
var re = new RegExp(regu);
return re.test(str);
}  
function buttonInfClick(){
	$("#REPEAT_COUNT").val('-1');
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
				<table style="width: 100%;"	border="0" cellspacing="0" cellpadding="0">
					<tr>
          				<td width="200" height="500" align="center" valign="top" background="Images/leftbg.jpg">
          					<%@ include file="Left.jsp"%>
          				</td>
          				          				
          				<td align="center" valign="top" bgcolor="#F6F9FE">
          				<table style="width: 100%;" border="0" cellspacing="0" cellpadding="0">
            				<tr>
              					<td colspan="3" height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">
              					<a href="TriggerCronManager.action"><strong>Cron触发器管理>></strong></a>修改Cron触发器>></td>
            				</tr>
            				<tr>
            					            					
              					<td width="100%" height="470" align="center" valign="top" bgcolor="#F6F9FE">
              					
<form name="form1" method="post" action="TriggerCronUpdateSave.action" onSubmit="return mycheck()" >
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="30%" height="30" align="right">&nbsp;</td>
		<td width="70%">&nbsp;</td>
	</tr>
	<tr>
    	<td height="30" align="right"><span style="color:blue;">*</span>调度名称：</td>
        <td><input name="SCHED_NAME" type="text" class="text2" id="SCHED_NAME" value="<s:property value='cnbean.SCHED_NAME'/>" readonly></td>
    </tr>
    <tr>
        <td height="30" align="right"><span style="color:blue;">*</span>触发器名称：</td>
        <td><input name="TRIGGER_NAME" type="text" class="text2" id="TRIGGER_NAME" value="<s:property value='cnbean.TRIGGER_NAME'/>" readonly></td>
    </tr>
    <tr>
    	<td height="30" align="right"><span style="color:blue;">*</span>触发器组别：</td>
        <td><input name="TRIGGER_GROUP" type="text" class="text2" id="TRIGGER_GROUP" value="<s:property value='cnbean.TRIGGER_GROUP'/>" readonly></td>
    </tr>
    <tr>
        <td height="30" align="right"><span style="color:red;">*</span>Cron 表达式：</td>
        <td><input name="Cron" type="text" class="text2" id="Cron" value="<s:property value='cnbean.CRON_EXPRESSION'/>" >
        <span style="color:blue;">注意格式正确</span></td>
    </tr>
    

    
    <tr> 
    	<td>
    	</td>       
        <td height="70">
        	<input type="submit" name="button" id="button" value="保存此触发器的修改！">
        </td>
    </tr>
    <tr> 
    	<td>
    	</td>       
        <td height="30">
        	<input type="button" name="button2" id="button2" value="----返回上页----" onClick="javascript:history.back(-1);">
        </td>
    </tr>
</table>
</form>
              				</td>
              					
              					
            				</tr>
          				</table>
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
