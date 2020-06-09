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
              					<a href="JobDetailManager.action"><strong>任务细节>></strong></a>修改Quartz任务>></td>
            				</tr>
            				<tr>
            					            					
              					<td width="100%" height="470" align="center" valign="top" bgcolor="#F6F9FE">
              					
<form name="form1" method="post" action="JobDetailUpdateSave.action" onSubmit="return mycheck()" >
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
        <td height="30" align="right"><span style="color:blue;">*</span>任务名称：</td>
        <td><input name="JOB_NAME" type="text" class="text2" id="JOB_NAME" value="<s:property value='cnbean.JOB_NAME'/>" readonly></td>
    </tr>
    <tr>
    	<td height="30" align="right"><span style="color:blue;">*</span>任务组别：</td>
        <td><input name="JOB_GROUP" type="text" class="text2" id="JOB_GROUP" value="<s:property value='cnbean.JOB_GROUP'/>" readonly></td>
    </tr>
    <tr>
    	<td height="30" align="right">任务描述：</td>
        <td><input name="DESCRIPTION" type="text" class="text2" id="DESCRIPTION" value="<s:property value='cnbean.DESCRIPTION'/>"></td>
    </tr>
    <tr>
    	<td height="30" align="right">当前任务操作类：</td>
        <td><input style="width:300px" name="JOB_CLASS_NAME" type="text" class="text2" id="JOB_CLASS_NAME" value="<s:property value='cnbean.JOB_CLASS_NAME'/>" readonly></td>
    </tr>
    <tr>
        <td height="30" align="right"><span style="color:red;">*</span>变更任务操作类：</td>
        <td>
        <select name="MYJOBS_CLASSNAME" id="MYJOBS_CLASSNAME">
            <option value="">请选择</option>
            <s:iterator id="bb" value="listMy">
            <option value="${MYJOBS_CLASSNAME}">${MYJOBS_CLASSNAME}</option>
            </s:iterator>
        </select>
        </td>
    </tr>
    <tr>
    	<td height="30" align="right">持久化：</td>
        <td><input name="IS_DURABLE" type="text" class="text2" id="IS_DURABLE" value="<s:property value='cnbean.IS_DURABLE'/>"></td>
    </tr>
    <tr>
    	<td height="30" align="right">非共点：</td>
        <td><input name="IS_NONCONCURRENT" type="text" class="text2" id="IS_NONCONCURRENT" value="<s:property value='cnbean.IS_NONCONCURRENT'/>"></td>
    </tr>
    <tr>
    	<td height="30" align="right">更新数据：</td>
        <td><input name="IS_UPDATE_DATA" type="text" class="text2" id="IS_UPDATE_DATA" value="<s:property value='cnbean.IS_UPDATE_DATA'/>"></td>
    </tr>
    <tr>
    	<td height="30" align="right">请求恢复：</td>
        <td><input name="REQUESTS_RECOVERY" type="text" class="text2" id="REQUESTS_RECOVERY" value="<s:property value='cnbean.REQUESTS_RECOVERY'/>"></td>
    </tr>
    
    <tr> 
    	<td>
    	</td>       
        <td height="70">
        	<input type="submit" name="button" id="button" value="保存对此任务的修改！">
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
