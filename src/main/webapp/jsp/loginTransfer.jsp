<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>

<%@ include file="../common.jsp"%>
<title></title>
</head>
<body>
</body>
<script>
	$(function(){
		var basePath = $("#basePath").val();
		var url=basePath+'/authentication/loginController.do?method=entrance';
		url ='<c:url value="'+url+'"/>';
		window.location.href=url;
	});
</script>
</html>
