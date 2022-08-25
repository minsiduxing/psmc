<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ include file="../../../../common.jsp"%>

<!--流程展示信息div -->
<div id="flowShowInfoAccordionDiv"></div>

<script type="text/javascript">
	var basePath = $("#basePath").val();
	var ftiUuid = "<%= request.getParameter("ftiUuid") %>";
	var getTabDataUrl = basePath+"/system/framework/tjyFlowTestController.do";
	getFlowImgByInstanceId ='<c:url value="'+getTabDataUrl+'"/>?method=getFlowImgByInstanceId&pid='+ftiUuid;
	var option ={
		id:"flowShowInfoAccordionDiv",
		fit:true,
		animate:"true",
		multiple:"false",//同时展开多个面板
		border:false

	};
	commonObj.initAccordionPanel(option);

	$("#flowShowInfoAccordionDiv").accordion('add', {
		title:'流程图',
		fit:true,
		href:getFlowImgByInstanceId
	});

	$("#flowShowInfoAccordionDiv").accordion('add', {
		title: '流程操作记录',
		fit:true,
		content: '操作记录！！！！！！！！！！！！！！！',
		selected:false
	});
</script>
