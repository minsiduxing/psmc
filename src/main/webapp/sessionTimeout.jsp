<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Expires" content="0">
<meta http-equiv="kiben" content="no-cache">

<%@ page isELIgnored="false"%>
<%@ taglib  uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
<%@ taglib  uri="http://prvi.guochun.com/mytag" prefix="g" %>  
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>  
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
top.location.href='<c:url value="/login.jsp"/>';
</script>
</html>
