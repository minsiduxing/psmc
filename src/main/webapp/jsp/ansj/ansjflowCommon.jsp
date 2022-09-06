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
<div id="ansjCommonFlowDiv" class="easyui-window" title="
当前任务:[<%=request.getParameter("task_step_name")%>]&nbsp;&nbsp;
任务处理人:[<%=request.getParameter("task_process_name")%>]"
	 data-options="fit:true,collapsible:false,minimizable:false,maximizable:false,closable:true,resizable:false,onClose:function(){history.back();}">

	<div id="ansjCommonFlowAccordDiv">
		<div title="任务业务操作">
			<script type="text/javascript">
				function closeWin(){
					$('#ansjCommonFlowDiv').window('close');
				}
			</script>
			<h2>
				 1、根据taskkey让面板加载不同页面，控制程序写在ansjflowCommon.js,可以参考编写。<br>
				 2、加载不同的页面需要注意：<br>
				 	a、新建的页面不能有html、head、title等内容，本质上，你新建的页面其实和当前页是一个页面，easyui会动态进行appendHtml处理。<br>
				    b、新建的页面就实现自己的业务，任务提交处理成功后调用本页面ansjCommonFlowDiv组件的窗口，框架已监听关闭，关闭后返回处理列表，点击下方任务提交试试看。<br>
			</h2>
			<h1><a herf="javascript:void(0)" onclick="closeWin()">任务提交</a>;</h1>
			<h2>
				几个还未完善的问题：<br>
				1、流程编号。<br>
				2、流程发起问题如何解决，目前暂时是放在业务端处理。也就是说，业务端需要有一个发起的列表，包含草稿、发起状态。<br>
				3、后续会考虑流程图在建立的时候，会添加一个发起的节点<br>
			</h2>


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