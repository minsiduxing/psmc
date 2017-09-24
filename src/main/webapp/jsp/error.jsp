<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../common.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>发生错误</title>
</head>
<body>
<script type="text/javascript">
$(function(){
$.messager.alert('发生错误！', '${exception}','error', function(r){
			  history.go(-1);
	});
});

</script>
</body>
</html>