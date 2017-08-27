<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传测试</title>
</head>
<body>
<%@ include file="../common.jsp"%>
<form action='<c:url value="/system/freamwork/fileUploadController"/>?method=testFileUpload' method="post" enctype="multipart/form-data">
<input type="file" name ="file1" />
<input type = "submit" value="上传"/>
<!-- 图片测试-->
<img alt="测试图片" src='<c:url value="/system/freamwork/fileUploadController"/>?method=getImage&filePath=/log/psmc-upload/image/1503827969232-1503758893527-IMG_20140205_140419.jpg'>
</form>
</body>
</html>