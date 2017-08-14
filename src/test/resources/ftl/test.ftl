<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<#--测试一般输出-->

<#-- 测试if
<#if userName == "root" >
 尊敬的管理员${userName}你拥有最高权限！
 <#else>
 ${userName} Hello welcome to Freemark Test!
</#if>
-->
<#-- 测试for
<#list userName as u>
${u_index}  ${u}
</#list>
-->
<#-- 测试for Javabean-->
<#list stus as stu>
学号:${stu.temaNum}姓名:${stu.name}年龄:${stu.age}性别:${stu.sex}
</#list>
</body>
</html>