<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="../../../../common.jsp"%>

<title>工作流待接收列表</title>
<script type="text/javascript" src="wait_receive_task.js"></script>
</head>
<body id="body">

<div class="query-content panel easyui-accordion accordion " data-options="selected:false" style="width:100%"> 
 <div title="信息查询" > 
    <form id="searchform" method="POST" class="query-form" >
	<ul class="searchform">
			<li class="li-input"><label for="" class="input-label">流程名称：</label>
				<input class="myinput" id="flow_cn_name" name="flow_cn_name"></input>
			</li>
			<li class="li-input"><label for="" class="input-label">任务名称：</label>
				<input class="myinput" id="task_step_name" name="task_step_name"></input>
			</li>
	</ul>
	</form>
	<div class="query-oper">
		<a href="#" class="easyui-linkbutton" onclick="commonObj.query('sologTableId','searchform')" id="submit_search" plain="true" iconCls="icon-search">查询</a>
	</div> 
 </div>
 </div>
 
<table id="sologTableId" style="width:100%"></table>
<div id="toolbarId">
</div>
</body>
<script type="text/javascript">
var basePath = $("#basePath").val();

var getTabDataUrl = basePath+"/system/framework/tjyFlowTestController.do";
var selectWaitReceiveTasks ='<c:url value="'+getTabDataUrl+'"/>?method=selectWaitReceiveTasks';
var claimTaskUrl ='<c:url value="'+getTabDataUrl+'"/>?method=claimTask';

$('#flow_cn_name').textbox({
	type : "text"
});

$('#task_step_name').textbox({
	type : "text"
});


</script>
</html>