<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<#-- 定义函数获取导航栏子菜单-->
<#macro  getSubNavbar navs  menuid>
	<ul>
	<#list navs as nav>
	<#if nav.parentMenuUuid??>
			<#if nav.parentMenuUuid==menuid>
			<li>
				<a href="${nav.menuUrl!''}">${nav.menuName!''}</a>
			</li>
		<@getSubNavbar navs=navs  menuid=nav.menuUuid/>
	</#if>	
	</#if>			
 	</#list>
	</ul>
	
</#macro >
<ul>
<#list navbars as nav>
	<#if nav.menuLevel == 1>
		<li>
		<a href="${nav.menuUrl!''}">${nav.menuName!''}</a>
		<@getSubNavbar navs=navbars  menuid=nav.menuUuid/>
	</li>
	</#if>
</#list>
</ul>
<#--导航菜单测试-->
<#--分页组件测试-->
</body>
</html>