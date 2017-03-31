<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<title></title>
</head>
<body>
	
</body>
<script>
function getTopWinow(){  
	  var p = window;  
	  while(p != p.parent){  
	      p = p.parent;  
	  }  
	  return p;  
	}  
var top = getTopWinow(); //获取当前页面的顶层窗口对象
alert("登录超时,请重新登录.");
top.location.href="/psmc/login.jsp";
</script>
</html>
