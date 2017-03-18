<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common.jsp"%>
<title>请求中转</title>
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
