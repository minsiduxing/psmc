<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
<#list navbars as nav1>

		<#if !nav1.parentMenuUuid??>
		<li>
				<a href="${nav1.menuUrl!''}">${nav1.menuName!''}</a>
				<ul>
				<#list navbars as nav2>
				<#if nav2.parentMenuUuid??>
						<#if nav2.parentMenuUuid==nav1.menuUuid>
						<li>
						<a href="${nav2.menuUrl!''}">${nav2.menuName!''}</a>
						</li>
						</#if>
						</#if>
					</#list>

				</ul>
				
</li>
	</#if>

</#list>
</ul>
</body>
</html>