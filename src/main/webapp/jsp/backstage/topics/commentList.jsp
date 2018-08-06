<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="../../../common.jsp"%>
<title>Insert title here</title>
</head>
<body>
	
	<input type="hidden" id="topicUuid" name="topicUuid" value="${param.topicUuid}">
	<div id="toolbarIds">
		<g:auth operateNo="<%=OperateContantsUtil.FLEA_MARKET_PAUSE%>">
				<a href="#" class="easyui-linkbutton" iconCls="icon-lock" plain="true" id="lock">禁止评论</a>
		</g:auth>
		<g:auth operateNo="<%=OperateContantsUtil.FLEA_MARKET_DEL%>">
				<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="remove">删除</a>
		</g:auth>
		<g:auth operateNo="<%=OperateContantsUtil.FLEA_MARKET_UNDO%>">
				<a href="#" class="easyui-linkbutton" iconCls="icon-undo" onclick="javascript:event.preventDefault();" plain="true" id="undo" >撤销</a>
		</g:auth>
	</div>
	<table id=commentList style="width:670px"></table>
</body>

<script type="text/javascript">

var basePath = $("#basePath").val();
var commentDo = basePath+"/website/backstage/tabCommentController.do";
var commentListUrl ='<c:url value="'+commentDo+'"/>?method=tabCommentList&topicUuid='+$("#topicUuid").val();

</script>
<script type="text/javascript" src="<%=request.getContextPath()%>/jsp/backstage/topics/commentList.js"></script>
</html>