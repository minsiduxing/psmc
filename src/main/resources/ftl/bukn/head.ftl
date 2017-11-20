<#import "../common/navbarfunction.ftl" as navf />
<script src="js/jquery.min.js"></script>
<script src="js/jquery.cookie.js"></script>
<nav class="fh5co-nav-style-1" role="navigation" data-offcanvass-position="fh5co-offcanvass-left">
			<div class="container">
				<div class="text-center fh5co-link-wrap index_font">
					<ul data-offcanvass="yes">
					<#list navbars as nav>
						<#if nav.menuLevel == 2>
						<#if navf.haveSubMenu(navbars,nav.menuUuid)==0>
						  <li class="wow index_color">
						    <#if "退出"==nav.menuName >
			                       <a href="${nav.menuUrl!''}" id="_logout" onclick="logout()" class="wow index_color">${nav.menuName!''}</a>
			                 <#else>
							    <a href="${nav.menuUrl!''}" class="wow index_color" >${nav.menuName!''}</a>
								</#if>
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
<script>
//判断用户cookie是否存在 
if($.cookie("userID")==null){  
  $('#_logout').css("display","none");
}
//退出登录
function logout(){
if(window.confirm("您确认退出登录吗？")){
var _url ="/psmc/login?username=query&password=c4ca4238a0b923820dcc509a6f75849b&transmiturl=/website/backstage/webUserController.do?method=webuserloginout";
		$.ajax({
 				async:false,
 				cache:false,
 				type:'POST',
 				dataType:"text",
 				url:_url,
 				success:function(data){
 					var dataObj = JSON.parse(data);
 					if(dataObj.res =="success"){
 						alert(dataObj.rmsg);
 						window.location.href="index.html";
 					}else{
 						writemsg(dataObj.rmsg);
 					}
 					
 				},
 				error:function (XMLHttpRequest, textStatus, errorThrown) {
 					
 				}
 			});
	}
}
</script>
</html>