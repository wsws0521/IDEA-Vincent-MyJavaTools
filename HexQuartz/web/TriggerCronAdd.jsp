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
<link href="Style/themes/bootstrap/easyui.css" rel="stylesheet" type="text/css" />
<link href="Style/themes/icon.css" rel="stylesheet" type="text/css" />
<link href="Style/icon.css" rel="stylesheet" type="text/css" />

<script src="js/jquery-1.7.1.min.js" language="javascript" type="text/javascript"></script>
<script src="js/jquery.easyui.min.js" type="text/javascript" charset="utf-8"></script> 
<script src="js/cron.js" type="text/javascript" charset="utf-8"></script> 
<style type="text/css">
    .line
    {
        height: 25px;
        line-height: 25px;
        margin: 3px;
    }
    .imp
    {
        padding-left: 25px;
    }
    .col
    {
        width: 60px;
    }
</style>
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

<script type="text/javascript">
function mycheck(){
	debugger;	
	if(isNull(form1.cron.value)){
		alert("请输入Cron表达式！");
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
	if(isNull(form1.TASK_NAME.value)||isNull(form1.TASK_NAME.value)){
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

function cronChange(){
	debugger;
	var cron = $("#cron").val();
	$.ajax({
		type:"POST",
		url:"${pageContext.request.contextPath}/Cron5.action",
		data:{"cron":cron},
        dataType:"json",
        async:false,
        success:function(data){
        	//alert(data); 
        	document.getElementById("cron5").innerText = data;
        }
	})	
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
function everyTime(dom) {
	debugger;
	var item = $("input[name=v_" + dom.name + "]");
	item.val("*");
	item.change();
	
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
              					<a href=TriggerCronManager.action ><strong>Cron触发器管理>></strong></a> 添加 Cron 触发器/任务</td>
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
 <div class="easyui-layout" id="12345" style="width:100%;height:470px;;border:1px rgb(202,196,196) solid;border-radius:5px">
 	<div style="height: 100%;">
		<div class="easyui-tabs" style="width:100%" data-options="fit:true,border:false">
			<div title="秒">
				<div class="line">
                	<input type="radio" checked="checked" name="second" onclick="everyTime(this)">
                	 每秒 允许的通配符[, - * /]
                </div>
                <div class="line">
                    <input type="radio" name="second" onclick="cycle(this)">
                                                            周期从
                    <input class="numberspinner" style="width: 60px;" data-options="min:1,max:58" value="1" id="secondStart_0">
                    -
                    <input class="numberspinner" style="width: 60px;" data-options="min:2,max:59" value="2" id="secondEnd_0">
                                                                       秒
                </div>
               <div class="line">
                   <input type="radio" name="second" onclick="startOn(this)">
                   从
                   <input class="numberspinner" style="width: 60px;" data-options="min:0,max:59" value="0"
                       id="secondStart_1">
                   秒开始,每
                   <input class="numberspinner" style="width: 60px;" data-options="min:1,max:59" value="1"
                       id="secondEnd_1">
                            秒执行一次</div>
                   <div class="line">
                       <input type="radio" name="second" id="sencond_appoint">
               	指定</div>
                        <div class="imp secondList">
                            <input type="checkbox" value="1">01
                            <input type="checkbox" value="2">02
                            <input type="checkbox" value="3">03
                            <input type="checkbox" value="4">04
                            <input type="checkbox" value="5">05
                            <input type="checkbox" value="6">06
                            <input type="checkbox" value="7">07
                            <input type="checkbox" value="8">08
                            <input type="checkbox" value="9">09
                            <input type="checkbox" value="10">10</div>
                        <div class="imp secondList">
                            <input type="checkbox" value="11">11
                            <input type="checkbox" value="12">12
                            <input type="checkbox" value="13">13
                            <input type="checkbox" value="14">14
                            <input type="checkbox" value="15">15
                            <input type="checkbox" value="16">16
                            <input type="checkbox" value="17">17
                            <input type="checkbox" value="18">18
                            <input type="checkbox" value="19">19
                            <input type="checkbox" value="20">20</div>
                        <div class="imp secondList">
                            <input type="checkbox" value="21">21
                            <input type="checkbox" value="22">22
                            <input type="checkbox" value="23">23
                            <input type="checkbox" value="24">24
                            <input type="checkbox" value="25">25
                            <input type="checkbox" value="26">26
                            <input type="checkbox" value="27">27
                            <input type="checkbox" value="28">28
                            <input type="checkbox" value="29">29
                            <input type="checkbox" value="30">30</div>
                        <div class="imp secondList">
                            <input type="checkbox" value="31">31
                            <input type="checkbox" value="32">32
                            <input type="checkbox" value="33">33
                            <input type="checkbox" value="34">34
                            <input type="checkbox" value="35">35
                            <input type="checkbox" value="36">36
                            <input type="checkbox" value="37">37
                            <input type="checkbox" value="38">38
                            <input type="checkbox" value="39">39
                            <input type="checkbox" value="40">40</div>
                        <div class="imp secondList">
                            <input type="checkbox" value="41">41
                            <input type="checkbox" value="42">42
                            <input type="checkbox" value="43">43
                            <input type="checkbox" value="44">44
                            <input type="checkbox" value="45">45
                            <input type="checkbox" value="46">46
                            <input type="checkbox" value="47">47
                            <input type="checkbox" value="48">48
                            <input type="checkbox" value="49">49
                            <input type="checkbox" value="50">50</div>
                        <div class="imp secondList">
                            <input type="checkbox" value="51">51
                            <input type="checkbox" value="52">52
                            <input type="checkbox" value="53">53
                            <input type="checkbox" value="54">54
                            <input type="checkbox" value="55">55
                            <input type="checkbox" value="56">56
                            <input type="checkbox" value="57">57
                            <input type="checkbox" value="58">58
                            <input type="checkbox" value="59">59</div>
			</div>
			<div title="分钟">
				<div class="line">
                            <input type="radio" checked="checked" name="min" onclick="everyTime(this)">
                            分钟 允许的通配符[, - * /]</div>
                        <div class="line">
                            <input type="radio" name="min" onclick="cycle(this)">
                            周期从
                            <input class="numberspinner" style="width: 60px;" data-options="min:1,max:58" value="1"
                                id="minStart_0">
                            -
                            <input class="numberspinner" style="width: 60px;" data-options="min:2,max:59" value="2"
                                id="minEnd_0">
                            分钟</div>
                        <div class="line">
                            <input type="radio" name="min" onclick="startOn(this)">
                            从
                            <input class="numberspinner" style="width: 60px;" data-options="min:0,max:59" value="0"
                                id="minStart_1">
                            分钟开始,每
                            <input class="numberspinner" style="width: 60px;" data-options="min:1,max:59" value="1"
                                id="minEnd_1">
                            分钟执行一次</div>
                        <div class="line">
                            <input type="radio" name="min" id="min_appoint">
                            指定</div>
                        <div class="imp minList">
                            <input type="checkbox" value="1">01
                            <input type="checkbox" value="2">02
                            <input type="checkbox" value="3">03
                            <input type="checkbox" value="4">04
                            <input type="checkbox" value="5">05
                            <input type="checkbox" value="6">06
                            <input type="checkbox" value="7">07
                            <input type="checkbox" value="8">08
                            <input type="checkbox" value="9">09
                            <input type="checkbox" value="10">10</div>
                        <div class="imp minList">
                            <input type="checkbox" value="11">11
                            <input type="checkbox" value="12">12
                            <input type="checkbox" value="13">13
                            <input type="checkbox" value="14">14
                            <input type="checkbox" value="15">15
                            <input type="checkbox" value="16">16
                            <input type="checkbox" value="17">17
                            <input type="checkbox" value="18">18
                            <input type="checkbox" value="19">19
                            <input type="checkbox" value="20">20</div>
                        <div class="imp minList">
                            <input type="checkbox" value="21">21
                            <input type="checkbox" value="22">22
                            <input type="checkbox" value="23">23
                            <input type="checkbox" value="24">24
                            <input type="checkbox" value="25">25
                            <input type="checkbox" value="26">26
                            <input type="checkbox" value="27">27
                            <input type="checkbox" value="28">28
                            <input type="checkbox" value="29">29
                            <input type="checkbox" value="30">30</div>
                        <div class="imp minList">
                            <input type="checkbox" value="31">31
                            <input type="checkbox" value="32">32
                            <input type="checkbox" value="33">33
                            <input type="checkbox" value="34">34
                            <input type="checkbox" value="35">35
                            <input type="checkbox" value="36">36
                            <input type="checkbox" value="37">37
                            <input type="checkbox" value="38">38
                            <input type="checkbox" value="39">39
                            <input type="checkbox" value="40">40</div>
                        <div class="imp minList">
                            <input type="checkbox" value="41">41
                            <input type="checkbox" value="42">42
                            <input type="checkbox" value="43">43
                            <input type="checkbox" value="44">44
                            <input type="checkbox" value="45">45
                            <input type="checkbox" value="46">46
                            <input type="checkbox" value="47">47
                            <input type="checkbox" value="48">48
                            <input type="checkbox" value="49">49
                            <input type="checkbox" value="50">50</div>
                        <div class="imp minList">
                            <input type="checkbox" value="51">51
                            <input type="checkbox" value="52">52
                            <input type="checkbox" value="53">53
                            <input type="checkbox" value="54">54
                            <input type="checkbox" value="55">55
                            <input type="checkbox" value="56">56
                            <input type="checkbox" value="57">57
                            <input type="checkbox" value="58">58
                            <input type="checkbox" value="59">59</div>
			</div>
			<div title="小时">
				<div class="line">
                            <input type="radio" checked="checked" name="hour" onclick="everyTime(this)">
                            小时 允许的通配符[, - * /]</div>
                        <div class="line">
                            <input type="radio" name="hour" onclick="cycle(this)">
                            周期从
                            <input class="numberspinner" style="width: 60px;" data-options="min:0,max:23" value="0"
                                id="hourStart_0">
                            -
                            <input class="numberspinner" style="width: 60px;" data-options="min:2,max:23" value="2"
                                id="hourEnd_1">
                            小时</div>
                        <div class="line">
                            <input type="radio" name="hour" onclick="startOn(this)">
                            从
                            <input class="numberspinner" style="width: 60px;" data-options="min:0,max:23" value="0"
                                id="hourStart_1">
                            小时开始,每
                            <input class="numberspinner" style="width: 60px;" data-options="min:1,max:23" value="1"
                                id="hourEnd_1">
                            小时执行一次</div>
                        <div class="line">
                            <input type="radio" name="hour" id="hour_appoint">
                            指定</div>
                        <div class="imp hourList">
                            AM:
                            <input type="checkbox" value="0">00
                            <input type="checkbox" value="1">01
                            <input type="checkbox" value="2">02
                            <input type="checkbox" value="3">03
                            <input type="checkbox" value="4">04
                            <input type="checkbox" value="5">05
                            <input type="checkbox" value="6">06
                            <input type="checkbox" value="7">07
                            <input type="checkbox" value="8">08
                            <input type="checkbox" value="9">09
                            <input type="checkbox" value="10">10
                            <input type="checkbox" value="11">11
                        </div>
                        <div class="imp hourList">
                            PM:
                            <input type="checkbox" value="12">12
                            <input type="checkbox" value="13">13
                            <input type="checkbox" value="14">14
                            <input type="checkbox" value="15">15
                            <input type="checkbox" value="16">16
                            <input type="checkbox" value="17">17
                            <input type="checkbox" value="18">18
                            <input type="checkbox" value="19">19
                            <input type="checkbox" value="20">20
                            <input type="checkbox" value="21">21
                            <input type="checkbox" value="22">22
                            <input type="checkbox" value="23">23</div>
			</div>		
 			<div title="日">
                        <div class="line">
                            <input type="radio" checked="checked" name="day" onclick="everyTime(this)">
                            日 允许的通配符[, - * / L W]</div>
                        
                        <div class="line">
                            <input type="radio" name="day" onclick="cycle(this)">
                            周期从
                            <input class="numberspinner" style="width: 60px;" data-options="min:1,max:31" value="1"
                                id="dayStart_0">
                            -
                            <input class="numberspinner" style="width: 60px;" data-options="min:2,max:31" value="2"
                                id="dayEnd_0">
                            日</div>
                        <div class="line">
                            <input type="radio" name="day" onclick="startOn(this)">
                            从
                            <input class="numberspinner" style="width: 60px;" data-options="min:1,max:31" value="1"
                                id="dayStart_1">
                            日开始,每
                            <input class="numberspinner" style="width: 60px;" data-options="min:1,max:31" value="1"
                                id="dayEnd_1">
                            天执行一次</div>
                        <div class="line">
                            <input type="radio" name="day" onclick="workDay(this)">
                            每月
                            <input class="numberspinner" style="width: 60px;" data-options="min:1,max:31" value="1"
                                id="dayStart_2">
                            号最近的那个工作日</div>
                        <div class="line">
                            <input type="radio" name="day" onclick="lastDay(this)">
                            本月最后一天</div>
                        <div class="line">
                        <input type="radio" name="day" id="day_appoint" onclick="appoint(this)">
                            指定
                        <input type="radio" name="day" onclick="unAppoint(this)">
                            不指定</div>
                        <div class="imp dayList">
                            <input type="checkbox" value="1">1
                            <input type="checkbox" value="2">2
                            <input type="checkbox" value="3">3
                            <input type="checkbox" value="4">4
                            <input type="checkbox" value="5">5
                            <input type="checkbox" value="6">6
                            <input type="checkbox" value="7">7
                            <input type="checkbox" value="8">8
                            <input type="checkbox" value="9">9
                            <input type="checkbox" value="10">10
                            <input type="checkbox" value="11">11
                            <input type="checkbox" value="12">12
                            <input type="checkbox" value="13">13
                            <input type="checkbox" value="14">14
                            <input type="checkbox" value="15">15
                            <input type="checkbox" value="16">16                        
                            <input type="checkbox" value="17">17
                            <input type="checkbox" value="18">18
                            <input type="checkbox" value="19">19
                            <input type="checkbox" value="20">20
                            <input type="checkbox" value="21">21
                            <input type="checkbox" value="22">22
                            <input type="checkbox" value="23">23
                            <input type="checkbox" value="24">24
                            <input type="checkbox" value="25">25
                            <input type="checkbox" value="26">26
                            <input type="checkbox" value="27">27
                            <input type="checkbox" value="28">28
                            <input type="checkbox" value="29">29
                            <input type="checkbox" value="30">30
                            <input type="checkbox" value="31">31
                        </div>
                    </div>
            <div title="月">
                <div class="line">
                    <input type="radio" checked="checked" name="mouth" onclick="everyTime(this)">
                    月 允许的通配符[, - * /]</div>
                
                <div class="line">
                    <input type="radio" name="mouth" onclick="cycle(this)">
                    周期从
                    <input class="numberspinner" style="width: 60px;" data-options="min:1,max:12" value="1"
                        id="mouthStart_0">
                    -
                    <input class="numberspinner" style="width: 60px;" data-options="min:2,max:12" value="2"
                        id="mouthEnd_0">
                    月</div>
                <div class="line">
                    <input type="radio" name="mouth" onclick="startOn(this)">
                    从
                    <input class="numberspinner" style="width: 60px;" data-options="min:1,max:12" value="1"
                        id="mouthStart_1">
                    日开始,每
                    <input class="numberspinner" style="width: 60px;" data-options="min:1,max:12" value="1"
                        id="mouthEnd_1">
                    月执行一次</div>
                <div class="line">
                    <input type="radio" name="mouth" id="mouth_appoint">
                    指定
                    <input type="radio" name="mouth" onclick="unAppoint(this)">
                    不指定</div>
                <div class="imp mouthList">
                    <input type="checkbox" value="1">1
                    <input type="checkbox" value="2">2
                    <input type="checkbox" value="3">3
                    <input type="checkbox" value="4">4
                    <input type="checkbox" value="5">5
                    <input type="checkbox" value="6">6
                    <input type="checkbox" value="7">7
                    <input type="checkbox" value="8">8
                    <input type="checkbox" value="9">9
                    <input type="checkbox" value="10">10
                    <input type="checkbox" value="11">11
                    <input type="checkbox" value="12">12
                </div>
            </div>
            <div title="周">
                <div class="line">
                    <input type="radio" checked="checked" name="week" onclick="everyTime(this)">
                    周 允许的通配符[, - * / L #]</div>
                
                <div class="line">
                    <input type="radio" name="week" onclick="startOn(this)">
                    周期 从星期<input class="numberspinner" style="width: 60px;" data-options="min:1,max:7"
                        id="weekStart_0" value="1">
                    -
                    <input class="numberspinner" style="width: 60px;" data-options="min:2,max:7" value="2"
                        id="weekEnd_0"></div>
                <div class="line">
                    <input type="radio" name="week" onclick="weekOfDay(this)">
                    第<input class="numberspinner" style="width: 60px;" data-options="min:1,max:4" value="1"
                        id="weekStart_1">
                    周 的星期<input class="numberspinner" style="width: 60px;" data-options="min:1,max:7"
                        id="weekEnd_1" value="1"></div>
                <div class="line">
                    <input type="radio" name="week" onclick="lastWeek(this)">
                    本月最后一个星期<input class="numberspinner" style="width: 60px;" data-options="min:1,max:7"
                        id="weekStart_2" value="1"></div>
                <div class="line">
                    <input type="radio" name="week" id="week_appoint" onclick="appoint(this)">
                    指定
                    <input type="radio" name="week" onclick="unAppoint(this)">
                    不指定</div>
                <div class="imp weekList">
                    <input type="checkbox" value="1">1
                    <input type="checkbox" value="2">2
                    <input type="checkbox" value="3">3
                    <input type="checkbox" value="4">4
                    <input type="checkbox" value="5">5
                    <input type="checkbox" value="6">6
                    <input type="checkbox" value="7">7
                </div>
            </div>
            <div title="年">
                <div class="line">
                    <input type="radio" checked="checked" name="year" onclick="unAppoint(this)">
                    不指定 允许的通配符[, - * /] 非必填</div>
                <div class="line">
                    <input type="radio" name="year" onclick="everyTime(this)">
                    每年</div>
                <div class="line">
                    <input type="radio" name="year" onclick="cycle(this)">周期 从
                    <input class="numberspinner" style="width: 90px;" data-options="min:2013,max:3000"
                        id="yearStart_0" value="2017">
                    -
                    <input class="numberspinner" style="width: 90px;" data-options="min:2014,max:3000"
                        id="yearEnd_0" value="2018"></div>
            </div>
        </div>
 	</div>
 	<div data-options="region:'south',border:false" style="height:170px">
 		<fieldset style="border-radius: 3px; height: 145px;"> 		
            <legend>Cron表达式</legend>
            <form name="form1" method="post" action="TriggerCronAddExe.action" onSubmit="return mycheck()" >
            <table style="height: 100px;">
                <tbody>
                    <tr>
                        <td><div style="width:55px"></div></td>
                        <td align="center">秒</td>
                        <td align="center">分钟</td>
                        <td align="center">小时</td>
                        <td align="center">日</td>
                        <td align="center">月</td>
                        <td align="center">星期</td>
                        <td align="center">年</td>
                    </tr>
                    <tr>
                        <td>字段:</td>
                        <td>
                            <input type="text" name="v_second" class="col" value="*" readonly="readonly" />
                        </td>
                        <td>
                            <input type="text" name="v_min" class="col" value="*" readonly="readonly" />
                        </td>
                        <td>
                            <input type="text" name="v_hour" class="col" value="*" readonly="readonly" />
                        </td>
                        <td>
                            <input type="text" name="v_day" class="col" value="*" readonly="readonly" />
                        </td>
                        <td>
                            <input type="text" name="v_mouth" class="col" value="*" readonly="readonly" />
                        </td>
                        <td>
                            <input type="text" name="v_week" class="col" value="?" readonly="readonly" />
                        </td>
                        <td>
                            <input type="text" name="v_year" class="col" readonly="readonly" />
                        </td>
                    </tr>
                    <tr>
                        <td>表达式:</td>
                        <td colspan="6">
                        	<input type="text" name="cron" style="width: 100%;" value="* * * * * ?" id="cron" oninput="cronChange()"/>
                        </td>
                        <td>
                        	<input type="button" value="反解 " id="btnFan" class="col" onclick="btnFanFunc()"/>
                        </td>
                    </tr>
                    <tr></tr>
                    <tr>
				    	<td>触发器组:</td>
				        <td><input name="TRIGGER_GROUP" type="text" class="col" id="TRIGGER_GROUP"></td>
				        <td><select name="TRIGGER_GROUP_SELECT" id="TRIGGER_GROUP_SELECT" onchange="tChange()">
				            <option value="">请选择</option>
				        	</select></td>
				        <td>触发器名:</td>
				        <td><input name="TRIGGER_NAME" type="text" class="col" id="TRIGGER_NAME"></td>
				        <td colspan="2"><span style="color:red;">*</span><span style="color:blue;">同组名称不可重复</span></td>
				    </tr>
                    <tr>
                        <td>任务组别:</td>
                        <td colspan="2">
                        	<select name="JOB_GROUP" id="JOB_GROUP" onchange="groupChange()" style="width:100%">
            					<option value="">请选择</option>            
        					</select> 
                        </td>
                        <td>任务名称:</td>
                        <td colspan="2">
                        	<select name="JOB_NAME" id="JOB_NAME" onchange="nameChange()" style="width:100%">
					            <option value="">请选择</option>            
					        </select>
                        </td>
                        <td>
                        	<input name="TASK_NAME" type="text" class="col" id="TASK_NAME" readonly> 
                        </td>
                        <td>
                        	<input type="submit" value="启动 " id="btnStart" class="col" />
                        </td>                        
                    </tr>
                </tbody>
            </table>
            </form>
        </fieldset>
        <div style="text-align: center; margin-top: 5px;">
        <script type="text/javascript">
        

function btnFanFunc() {
    //获取参数中表达式的值
    debugger;
    var txt = $("#cron").val();
    if (txt) {
        var regs = txt.split(' ');
        $("input[name=v_second]").val(regs[0]);
        $("input[name=v_min]").val(regs[1]);
        $("input[name=v_hour]").val(regs[2]);
        $("input[name=v_day]").val(regs[3]);
        $("input[name=v_mouth]").val(regs[4]);
        $("input[name=v_week]").val(regs[5]);

        initObj(regs[0], "second");
        initObj(regs[1], "min");
        initObj(regs[2], "hour");
        initDay(regs[3]);
        initMonth(regs[4]);
        initWeek(regs[5]);

        if (regs.length > 6) {
            $("input[name=v_year]").val(regs[6]);
            initYear(regs[6]);
        }
    }
}


function initObj(strVal, strid) {
    var ary = null;
    var objRadio = $("input[name='" + strid + "'");
    if (strVal == "*") {
        objRadio.eq(0).attr("checked", "checked");
    } else if (strVal.split('-').length > 1) {
        ary = strVal.split('-');
        objRadio.eq(1).attr("checked", "checked");
        $("#" + strid + "Start_0").numberspinner('setValue', ary[0]);
        $("#" + strid + "End_0").numberspinner('setValue', ary[1]);
    } else if (strVal.split('/').length > 1) {
        ary = strVal.split('/');
        objRadio.eq(2).attr("checked", "checked");
        $("#" + strid + "Start_1").numberspinner('setValue', ary[0]);
        $("#" + strid + "End_1").numberspinner('setValue', ary[1]);
    } else {
        objRadio.eq(3).attr("checked", "checked");
        if (strVal != "?") {
            ary = strVal.split(",");
            for (var i = 0; i < ary.length; i++) {
                $("." + strid + "List input[value='" + ary[i] + "']").attr("checked", "checked");
            }
        }
    }
}

function initDay(strVal) {
    var ary = null;
    var objRadio = $("input[name='day'");
    if (strVal == "*") {
        objRadio.eq(0).attr("checked", "checked");
    } else if (strVal == "?") {
        objRadio.eq(1).attr("checked", "checked");
    } else if (strVal.split('-').length > 1) {
        ary = strVal.split('-');
        objRadio.eq(2).attr("checked", "checked");
        $("#dayStart_0").numberspinner('setValue', ary[0]);
        $("#dayEnd_0").numberspinner('setValue', ary[1]);
    } else if (strVal.split('/').length > 1) {
        ary = strVal.split('/');
        objRadio.eq(3).attr("checked", "checked");
        $("#dayStart_1").numberspinner('setValue', ary[0]);
        $("#dayEnd_1").numberspinner('setValue', ary[1]);
    } else if (strVal.split('W').length > 1) {
        ary = strVal.split('W');
        objRadio.eq(4).attr("checked", "checked");
        $("#dayStart_2").numberspinner('setValue', ary[0]);
    } else if (strVal == "L") {
        objRadio.eq(5).attr("checked", "checked");
    } else {
        objRadio.eq(6).attr("checked", "checked");
        ary = strVal.split(",");
        for (var i = 0; i < ary.length; i++) {
            $(".dayList input[value='" + ary[i] + "']").attr("checked", "checked");
        }
    }
}

function initMonth(strVal) {
    var ary = null;
    var objRadio = $("input[name='mouth'");
    if (strVal == "*") {
        objRadio.eq(0).attr("checked", "checked");
    } else if (strVal == "?") {
        objRadio.eq(1).attr("checked", "checked");
    } else if (strVal.split('-').length > 1) {
        ary = strVal.split('-');
        objRadio.eq(2).attr("checked", "checked");
        $("#mouthStart_0").numberspinner('setValue', ary[0]);
        $("#mouthEnd_0").numberspinner('setValue', ary[1]);
    } else if (strVal.split('/').length > 1) {
        ary = strVal.split('/');
        objRadio.eq(3).attr("checked", "checked");
        $("#mouthStart_1").numberspinner('setValue', ary[0]);
        $("#mouthEnd_1").numberspinner('setValue', ary[1]);

    } else {
        objRadio.eq(4).attr("checked", "checked");

        ary = strVal.split(",");
        for (var i = 0; i < ary.length; i++) {
            $(".mouthList input[value='" + ary[i] + "']").attr("checked", "checked");
        }
    }
}

function initWeek(strVal) {
    var ary = null;
    var objRadio = $("input[name='week'");
    if (strVal == "*") {
        objRadio.eq(0).attr("checked", "checked");
    } else if (strVal == "?") {
        objRadio.eq(1).attr("checked", "checked");
    } else if (strVal.split('/').length > 1) {
        ary = strVal.split('/');
        objRadio.eq(2).attr("checked", "checked");
        $("#weekStart_0").numberspinner('setValue', ary[0]);
        $("#weekEnd_0").numberspinner('setValue', ary[1]);
    } else if (strVal.split('-').length > 1) {
        ary = strVal.split('-');
        objRadio.eq(3).attr("checked", "checked");
        $("#weekStart_1").numberspinner('setValue', ary[0]);
        $("#weekEnd_1").numberspinner('setValue', ary[1]);
    } else if (strVal.split('L').length > 1) {
        ary = strVal.split('L');
        objRadio.eq(4).attr("checked", "checked");
        $("#weekStart_2").numberspinner('setValue', ary[0]);
    } else {
        objRadio.eq(5).attr("checked", "checked");
        ary = strVal.split(",");
        for (var i = 0; i < ary.length; i++) {
            $(".weekList input[value='" + ary[i] + "']").attr("checked", "checked");
        }
    }
}

function initYear(strVal) {
    var ary = null;
    var objRadio = $("input[name='year'");
    if (strVal == "*") {
        objRadio.eq(1).attr("checked", "checked");
    } else if (strVal.split('-').length > 1) {
        ary = strVal.split('-');
        objRadio.eq(2).attr("checked", "checked");
        $("#yearStart_0").numberspinner('setValue', ary[0]);
        $("#yearEnd_0").numberspinner('setValue', ary[1]);
    }
}
</script>
        </div>        
 	</div>
 	
 </div>
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
			<tr>
				<td align="center" valign="middle">
				 <input type="button" value="刷新 最近5次运行时间" id="btnRefresh" onclick="cronChange()"/><br/>
				<span style="color:blue;" id="cron5"></span>			
				</td>
			</tr>
		</table>

	</center>
</body>
</html>
