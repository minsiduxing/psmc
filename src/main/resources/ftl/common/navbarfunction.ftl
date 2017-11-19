<#-- 定义函数获取导航栏子菜单-->
<#macro  getSubNavbar navs  menuid>

	<#list navs as nav>
	<#if nav.parentMenuUuid??>
			<#if nav.parentMenuUuid==menuid>

			   <li>
			   <#if "退出"==nav.menuName >
			   <a href="${nav.menuUrl!''}" id="_logout" onclick="logout()" >${nav.menuName!''}</a>
			   <#else>
				 <a href="${nav.menuUrl!''}">${nav.menuName!''}</a>
			</#if>
			   </li>
		<@getSubNavbar navs=navs  menuid=nav.menuUuid/>
	</#if>	
	</#if>			
 	</#list>	
</#macro >
<#-- 判断是否有子菜单-->
<#function haveSubMenu navs  menuid>
  <#assign x = 0> 
  <#list navs as nav>
	<#if nav.parentMenuUuid??>
		 <#if nav.parentMenuUuid==menuid>
		   <#assign x=x+1>;
         </#if>	
	</#if>
 </#list>	
 <#return x>	
</#function>