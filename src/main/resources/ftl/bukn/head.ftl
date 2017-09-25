<#import "../common/navbarfunction.ftl" as navf />
<nav class="fh5co-nav-style-1" role="navigation" data-offcanvass-position="fh5co-offcanvass-left">
			<div class="container">
				<div class="col-lg-2 col-md-3 col-sm-3 col-xs-12 fh5co-logo">
					 <a href="#" id ="topinfo" class="wow fadeInUp"  data-wow-duration="1s" data-wow-delay="0.5s"></a> 
				</div>
				<div class="col-lg-10 col-md-9 col-sm-9 text-center fh5co-link-wrap index_font">
					<ul data-offcanvass="yes">
					<#list navbars as nav>
						<#if nav.menuLevel == 2>
						<#if navf.haveSubMenu(navbars,nav.menuUuid)==0>
						  <li class="wow index_color">
							<a href="${nav.menuUrl!''}" class="wow index_color" >${nav.menuName!''}</a>
						  </li>
						 </#if>
						 <#if navf.haveSubMenu(navbars,nav.menuUuid)!=0 >
							<li class="dropdown">
							
							 <a href="${nav.menuUrl!''}" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">${nav.menuName!''}<span class="caret"></span></a>
								<ul class="dropdown-menu">
								<@navf.getSubNavbar navs=navbars  menuid=nav.menuUuid/>
								</ul>
							</li>
						</#if>
					</#if>
					</#list>
					</ul>
		  </div> 
      </div>
</nav>
<#--导航菜单测试-->
<#--分页组件测试-->
</body>
</html>