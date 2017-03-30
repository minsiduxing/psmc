<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		window.location.href=basePath+"/authentication/loginController.do?method=entrance";
	});
</script>
</html>
