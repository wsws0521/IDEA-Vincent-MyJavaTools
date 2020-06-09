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
<style type="text/css">
	.text2
	{
		width:400px;
	}
	#button,#button2
	{
		width:300px;
	}	
</style>
 
<script language="JavaScript">
function mycheck(){
	debugger;
   if(isNull(form1.instanceName.value)){  
   alert("请输入默认调度器名称！"); 
   return false;
   }  
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
              					<a href="QuartzConfig.action"><strong>Quartz参数配置>></strong></a></td>
            				</tr>
            				<tr>
            					            					
              					<td width="100%" height="470" align="center" valign="top" bgcolor="#F6F9FE">
	
<form name="form1" method="post" action="QuartzConfigSave.action" onSubmit="return mycheck()" >
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="30%" height="30" align="right">&nbsp;</td>
		<td width="70%">&nbsp;</td>
	</tr>
	<tr>
    	<td height="30" align="right"><span style="color:blue;">*</span>默认调度器名称：</td>
        <td><input name="instanceName" type="text" class="text2" id="instanceName" value="<s:property value='quartzMap.instanceName'/>"></td>
    </tr>
    <tr>
        <td height="30" align="right"><span style="color:blue;">*</span>线程池类名：</td>
        <td><input name="threadPoolclass" type="text" class="text2" id="threadPoolclass" value="<s:property value='quartzMap.threadPoolclass'/>" readonly></td>
    </tr>
    <tr>
    	<td height="30" align="right"><span style="color:blue;">*</span>触发器组别：</td>
        <td><input name="threadCount" type="text" class="text2" id="threadCount" value="<s:property value='quartzMap.threadCount'/>" readonly></td>
    </tr>
    <tr>
        <td height="30" align="right"><span style="color:red;">*</span>Job 存储类：</td>
        <td><input name="jobStoreclass" type="text" class="text2" id="jobStoreclass" value="<s:property value='quartzMap.jobStoreclass'/>" readonly></td>
    </tr>
    <tr>
        <td height="30" align="right"><span style="color:red;">*</span>表名前缀：</td>
        <td><input name="tablePrefix" type="text" class="text2" id="tablePrefix" value="<s:property value='quartzMap.tablePrefix'/>" readonly></td>
    </tr>
    <tr>
        <td height="30" align="right"><span style="color:red;">*</span>驱动代理类：</td>
        <td><input name="driverDelegateClass" type="text" class="text2" id="driverDelegateClass" value="<s:property value='quartzMap.driverDelegateClass'/>" readonly></td>
    </tr>
    <tr>
        <td height="30" align="right"><span style="color:red;">*</span>数据源名称：</td>
        <td><input name="dataSource" type="text" class="text2" id="dataSource" value="<s:property value='quartzMap.dataSource'/>" readonly></td>
    </tr>
    <tr>
        <td height="30" align="right"><span style="color:red;">*</span>数据库驱动类：</td>
        <td><input name="jdbcName" type="text" class="text2" id="jdbcName" value="<s:property value='quartzMap.jdbcName'/>" readonly></td>
    </tr>
    <tr>
        <td height="30" align="right"><span style="color:red;">*</span>数据库URL：</td>
        <td><input name="dbUrl" type="text" class="text2" id="dbUrl" value="<s:property value='quartzMap.dbUrl'/>" readonly></td>
    </tr>
    <tr>
        <td height="30" align="right"><span style="color:red;">*</span>数据库用户名：</td>
        <td><input name="dbUser" type="text" class="text2" id="dbUser" value="<s:property value='quartzMap.dbUser'/>" readonly></td>
    </tr>
    <tr>
        <td height="30" align="right"><span style="color:red;">*</span>数据库密码：</td>
        <td><input name="dbPassword" type="text" class="text2" id="dbPassword" value="<s:property value='quartzMap.dbPassword'/>" readonly></td>
    </tr>
       
    <tr> 
    	<td>
    	</td>       
        <td height="70">
        	<input type="submit" name="button" id="button" value="保存quartz配置文件的修改！">
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
