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
   if(isNull(form1.JOB_GROUP.value)){  
   alert("请输入任务组别！"); 
   return false;
   }
   if(isNull(form1.JOB_NAME.value)){
   alert("请输入任务名称！");
   return false;
   }
   if(isNull(form1.TRIGGER_GROUP.value)){
   alert("请输入触发器组别！");
   return false;
   }
   if(isNull(form1.TRIGGER_NAME.value)){
	alert("请输入触发器名称！");
	return false;
	}
   
//    if (document.form1.Teacher_Password.value != document.form1.Teacher_Password2.value) { 
//    alert("您两次输入的新密码不一致！请重新输入！"); 
//    return false; 
//    } 
   
   if(isNull(form1.MYJOBS_CLASSNAME.value)){
   alert("请选择要执行的任务！");
   return false;
   }
   
   debugger;
   var listJson=eval('${listJobJson}');
   var jobgroup=form1.JOB_GROUP.value;
   var jobname=form1.JOB_NAME.value;
   for(var i=0;i<listJson.length;i++){
	   if(listJson[i].JOB_GROUP==jobgroup){
		   if(listJson[i].JOB_NAME==jobname){
			   alert("该任务组别内已存在该任务名称，请更换任务名称或组别！"); 
			   return false;
		   }
	   }
   }
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
              					<strong>一个临时任务>>（信息不存档）</strong></td>
            				</tr>
            				<tr>
            					<td width="30%" style="vertical-align:top;background-color:white">
            					<table width="100%" border="0" cellspacing="0" cellpadding="0">
            						<tr align="center" class="t1">
										<td height="25" bgcolor="#D5E4F4"><strong>正在执行任务组别</strong></td>
										<td bgcolor="#D5E4F4"><strong>正在执行任务名称</strong></td>
									</tr>
									<s:iterator id="jj" value="listJob">
									<tr align="center">
										<td height="25" align="center">${JOB_GROUP}</td>
										<td align="center">${JOB_NAME}</td>
									</tr>
									</s:iterator>
            					</table>
            					</td>
            					
              					<td width="40%" height="470" align="center" valign="top" bgcolor="#F6F9FE">
              					
<form name="form1" method="post" action="ATempJobExe.action" onSubmit="return mycheck()" >
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="30%" height="30" align="right">&nbsp;</td>
		<td width="70%">&nbsp;</td>
	</tr>
    <tr>
    	<td height="30" align="right"><span style="color:red;">*</span>任务组别：</td>
        <td><input name="JOB_GROUP" type="text" class="text2" id="JOB_GROUP"></td>
    </tr>
    <tr>
        <td height="30" align="right"><span style="color:red;">*</span>任务名称：<span id="warn" style="color:red;"></span></td>
        <td><input name="JOB_NAME" type="text" class="text2" id="JOB_NAME">
        <span style="color:blue;">同组下，名称不可重复</span></td>
    </tr>
    <tr>
    	<td height="30" align="right"><span style="color:red;">*</span>触发器组别：</td>
        <td><input name="TRIGGER_GROUP" type="text" class="text2" id="TRIGGER_GROUP"></td>
    </tr>
    <tr>
        <td height="30" align="right"><span style="color:red;">*</span>触发器名称：</td>
        <td><input name="TRIGGER_NAME" type="text" class="text2" id="TRIGGER_NAME">
        <span style="color:blue;">同组下，名称不可重复</span></td>
    </tr>
    
    <tr>
        <td height="30" align="right"><span style="color:red;">*</span>延迟秒数：</td>
        <td><input name="Delay_Sec" type="text" class="text2" id="Delay_Sec">
        <span style="color:blue;">暂时无效，下分钟开始</span></td>        
    </tr>
    
   
    <tr>
        <td height="30" align="right"><span style="color:red;">*</span>选择任务：</td>
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
    	<td>
    	</td>       
        <td height="70">
        	<input type="submit" name="button" id="button" value="立即启动此任务！">
        </td>
    </tr>
    <tr> 
    	<td>
    	</td>       
        <td height="30">
        	<input type="button" name="button2" id="button2" value="------返回上页------" onClick="javascript:history.back(-1);">
        </td>
    </tr>
</table>
</form>
              </td>
              					
              					<td width="30%" style="vertical-align:top;background-color:white">
              					<table width="100%" border="0" cellspacing="0" cellpadding="0">
            						<tr align="center" class="t1">
										<td height="25" bgcolor="#D5E4F4"><strong>正在执行触发器组别</strong></td>
										<td bgcolor="#D5E4F4"><strong>正在执行触发器名称</strong></td>
									</tr>
									<s:iterator id="tt" value="listTrigger">
									<tr align="center">
										<td height="25" align="center">${TRIGGER_GROUP}</td>
										<td align="center">${TRIGGER_NAME}</td>
									</tr>
									</s:iterator>
            					</table>
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
