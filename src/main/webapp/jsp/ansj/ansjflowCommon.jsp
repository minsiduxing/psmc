<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<html>
<head>
	<%@ include file="../../common.jsp"%>
	<title>公共操作</title>
	<script type="text/javascript" src="ansjflowCommon.js"></script>
</head>
<body id="body">
<div id="ansjCommonFlowDiv" class="easyui-window" title="本环节：【局长审批，处理人：李四】 上一环节【科长审核，处理人：张三】"
	 data-options="fit:true,collapsible:false,minimizable:false,maximizable:false,closable:true,resizable:false,onClose:function(){history.back();}">

	<div id="ansjCommonFlowAccordDiv">
		<div title="任务业务操作">
			<h1>业务操作，业务操作，业务操作。。。。。。</h1>
		</div>
		<div title="任务流转历史">
			<table id="sologTableId"></table>
		</div>
		<div title="任务流转附件">
			<table id="attachmentTableId"></table>
		</div>
	</div>
</div>

<script type="text/javascript">
	var basePath = $("#basePath").val();
	var getTabDataUrl = basePath+"/system/framework/flowCommonController.do";
	var selectProcessedTasks ='<c:url value="'+getTabDataUrl+'"/>?method=selectProcessedTasksByPid&pid=<%=request.getParameter("pid")%>';
	var selectProcessedTaskAttachmentsByPid ='<c:url value="'+getTabDataUrl+'"/>?method=selectProcessedTaskAttachmentsByPid&pid=<%=request.getParameter("pid")%>';
	var getFlowImgByInstanceId ='<c:url value="'+getTabDataUrl+'"/>?method=getFlowImgByInstanceId&pid=<%=request.getParameter("pid")%>';
</script>
</body>
</html>