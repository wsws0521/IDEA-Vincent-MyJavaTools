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
	var t = document.getElementById("TRIGGER_GROUP_SELECT");
	if(listJson.length>0){
		var option=new Option(listJson[0].TRIGGER_GROUP);
		t.options.add(option);
	}
	if(listJson.length>1){	
		for(var i=1;i<listJson.length;i++){
			for(var j=1;j<t.length;j++){
				if(listJson[i].TRIGGER_GROUP!=t.options[j].value&&listJson[i].TRIGGER_GROUP!=t.options[j].text){
					var option=new Option(listJson[i].TRIGGER_GROUP);
					t.options.add(option);
				}
			}
		}
	}
	
	var listJson=eval('${listJobJson}');
	var j = document.getElementById("JOB_GROUP");
	if(listJson.length>0){
		var option=new Option(listJson[0].JOB_GROUP);
		j.options.add(option);
	}
	if(listJson.length>1){	
		for(var i=1;i<listJson.length;i++){
			for(var j=1;j<j.length;j++){
				if(listJson[i].JOB_GROUP!=s.options[j].value&&listJson[i].JOB_GROUP!=s.options[j].text){
					var option=new Option(listJson[i].JOB_NAME);
					j.options.add(option);
				}
			}
		}
	}
	
})
</script>

<script language="JavaScript">
function mycheck(){
	debugger;
   
   if(isNull(form1.TRIGGER_GROUP.value)){
   alert("请输入触发器组别！");
   return false;
   }
   if(isNull(form1.TRIGGER_NAME.value)){
	alert("请输入触发器名称！");
	return false;
	}
   if(isNull(form1.Delay_Sec.value)){ 
	   form1.Delay_Sec.value=1;
	}
   if(isNull(form1.REPEAT_COUNT.value)){
	   form1.REPEAT_COUNT.value=1;
  }
   if(isNull(form1.REPEAT_INTERVAL.value)){
	   form1.REPEAT_INTERVAL.value=5;
  }
   if(isNull(form1.JOB_GROUP.value)||isNull(form1.JOB_NAME.value)){
	   alert("请指定任务！");
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
function tChange(){
	var group=$('#TRIGGER_GROUP_SELECT option:selected').text();
	$("#TRIGGER_GROUP").val(group);
}
function groupChange(){
	debugger;
	$('#JOB_NAME').empty();
	$("#JOB_NAME").prepend("<option value='0'>请选择</option>");
	var listJson=eval('${listJobJson}');
	var group=$('#JOB_GROUP option:selected').text();
	for(var i=0;i<listJson.length;i++){
		if(group==listJson[i].JOB_GROUP){
			var option=new Option(listJson[i].JOB_NAME);
			document.getElementById("JOB_NAME").options.add(option);
		}		
	}
}
function nameChange(){
	debugger;
	var listJson=eval('${listJobJson}');
	var group=$('#JOB_GROUP option:selected').text();
	var name=$('#JOB_NAME option:selected').text();
	for(var i=0;i<listJson.length;i++){
		if(group==listJson[i].JOB_GROUP&&name==listJson[i].JOB_NAME){
			var JCN=listJson[i].JOB_CLASS_NAME;
			var subJCN=JCN.substring(JCN.lastIndexOf('.')+1);
			$('#TASK_NAME').val(subJCN);
		}
	}
	if(group=="请选择"||name=="请选择"){
		$('#TASK_NAME').val('');
	}
}
function buttonInfClick(){
	$("#REPEAT_COUNT").val('-1');
}
function overShow() {
	  var showDiv = document.getElementById('showDiv');
	  showDiv.style.left = event.clientX;
	  showDiv.style.top = event.clientY;
	  showDiv.style.display = 'block';
	  showDiv.innerHTML = '说明：<br>5：每分钟的5、10、15、20...<br>15：每分钟的15、30、45、60';
	 }
	 
function outHide() {
	 var showDiv = document.getElementById('showDiv');
	 showDiv.style.display = 'none';
	 showDiv.innerHTML = '';
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
              					<a href=TriggerSimpleManager.action><strong>Simple触发器管理>></strong></a> 添加 Simple 触发器/任务</td>
            				</tr>
            				<tr>
            					<td width="30%" style="vertical-align:top;background-color:white">
            					<table width="100%" border="0" cellspacing="0" cellpadding="0">
            						<tr align="center" class="t1">
										<td height="25" bgcolor="#D5E4F4"><strong>已存在触发器组别</strong></td>
										<td bgcolor="#D5E4F4"><strong>已存在触发器名称</strong></td>
									</tr>
									<s:iterator id="jj" value="listTrigger">
									<tr align="center">
										<td height="25" align="center">${TRIGGER_GROUP}</td>
										<td align="center">${TRIGGER_NAME}</td>
									</tr>
									</s:iterator>
            					</table>
            					</td>
            					
              					<td width="40%" height="470" align="center" valign="top" bgcolor="#F6F9FE">
              					
<form name="form1" method="post" action="TriggerSimpleAddExe.action" onSubmit="return mycheck()" >
<table width="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="30%" height="30" align="right">&nbsp;</td>
		<td width="70%">&nbsp;</td>
	</tr> 
    <tr>
    	<td height="30" align="right"><span style="color:red;">*</span>触发器组别：</td>
        <td><input name="TRIGGER_GROUP" type="text" class="text2" id="TRIGGER_GROUP">
        <select name="TRIGGER_GROUP_SELECT" id="TRIGGER_GROUP_SELECT" onchange="tChange()">
            <option value="">请选择</option>
        </select></td>
    </tr>
    <tr>
        <td height="30" align="right"><span style="color:red;">*</span>触发器名称：</td>
        <td><input name="TRIGGER_NAME" type="text" class="text2" id="TRIGGER_NAME">
        <span style="color:blue;">同组下，名称不可重复</span></td>
    </tr>
    <tr>
    	<td height="30" align="right">下个启动秒：</td>
        <td onmouseover="overShow()" onmouseout="outHide()">
        <input name="Delay_Sec" type="text" class="text2" id="Delay_Sec"
        onkeyup="this.value=this.value.replace(/\D/g,'')" >
        <span style="color:blue;">秒（默认：1秒）</span></td>
    </tr>
    <tr>
        <td height="30" align="right">重复次数：</td>
        <td title="额外运行次数">
        <input name="REPEAT_COUNT" type="text" class="text2" id="REPEAT_COUNT"
        onkeyup="this.value=this.value.replace(/\D/g,'')" >
        <input type="button" name="buttonInf" id="buttonInf" value="无穷"
        onclick="buttonInfClick();">
        <span style="color:blue;">次（默认：1次）</span></td>
    </tr>
    <tr>
        <td height="30" align="right">重复间隔：</td>
        <td ><input name="REPEAT_INTERVAL" type="text" class="text2" id="REPEAT_INTERVAL"
        onkeyup="this.value=this.value.replace(/\D/g,'')" >        
        <span style="color:blue;">秒（默认：5秒）</span></td>
    </tr>
    
   
    <tr>
        <td height="30" align="right"><span style="color:red;">*</span>选择任务：</td>
        <td>
        <select name="JOB_GROUP" id="JOB_GROUP" onchange="groupChange()">
            <option value="">请选择</option>            
        </select>        
        <select name="JOB_NAME" id="JOB_NAME" onchange="nameChange()">
            <option value="">请选择</option>            
        </select>
        <input name="TASK_NAME" type="text" class="text2" id="TASK_NAME" readonly> 
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
<div id="showDiv" style="position: absolute; background-color: white; border: 1px solid black;"></div>
</form>
              </td>
              					
              					<td width="30%" style="vertical-align:top;background-color:white">
              					<table width="100%" border="0" cellspacing="0" cellpadding="0">
            						<tr align="center" class="t1">
										<td height="25" bgcolor="#D5E4F4"><strong>调度器名称</strong></td>
										<td bgcolor="#D5E4F4"><strong>任务组别</strong></td>
										<td bgcolor="#D5E4F4"><strong>任务名称</strong></td>
										<td bgcolor="#D5E4F4"><strong>操作类</strong></td>
									</tr>
									<s:iterator id="tt" value="listJob">
									<tr align="center">
										<td height="25" align="center">${SCHED_NAME}</td>
										<td align="center">${JOB_GROUP}</td>
										<td align="center">${JOB_NAME}</td>
										<td align="center">${JOB_CLASS_NAME}</td>
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
