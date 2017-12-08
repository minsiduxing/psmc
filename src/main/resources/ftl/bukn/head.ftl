<#import "../common/navbarfunction.ftl" as navf />
<script src="js/jquery.min.js"></script>
<script src="js/jquery.cookie.js"></script>
<style type="text/css">
		.dropdown-menu{
		 	background-color:#f5f5f5;
		}
		.dropdown-menu > li > a:hover, .dropdown-menu > li > a:focus {
		  	background-color: transparent;
		}
		.adv_ul div:hover img{
			-webkit-transform: rotate(360deg);
			-moz-transform: rotate(360deg);
			-ms-transform: rotate(360deg);
			-o-transform: rotate(360deg);
			transform: rotate(360deg);
			-webkit-transition: all 0.8s ease 0s;
			-moz-transition: all 0.8s ease 0s;
			-ms-transition: all 0.8s ease 0s;
			-o-transition: all 0.8s ease 0s;
			transition: all 0.8s ease 0s;
		}
		.index_font{
			font-family: "Montserrat", Arial, sans-serif !important;
  			font-weight: 700 !important;
			color: #fff !important;
		}
		.button_{
  			color: #7c5a53 !important;
  			font-weight: 600 !important;
		}
		.dropdown>a, .index_color{
			color:#333;
			font-size:14px;
			font-family:sans-serif;
		}
		.dropdown>a:hover, .index_color:hover{
			color: #333 !important;
			font-size: 16px;
            font-weight: 400;
		}
		.dropdown-menu>li>a, .index_colour{
			color:#333;
			font-size:14px;
			font-family:sans-serif;
			line-height:40px;
		}
		.btn-primary:hover{
			background-color: #45c46f !important;
			border: 2px solid #fff !important;
		}
		.fh5co-category>a:hover{
			background-color: #45c46f !important;
			border: 1px solid #fff !important;
		}
		h3{
			font-family: "STHeiti Light" !important;
			font-size: 25px !important;
		}
		.col-md-6>p{
			font-family: "STHeiti Light" !important;
			font-size: 20px !important;
		}
		.carousel{
			width: 70%;
			margin: 0 auto;
		}
		.buttonNext{
			border-bottom-color: rgb(128, 128, 128);
			border-bottom-left-radius: 23px;
			border-bottom-right-radius: 23px;
			border-bottom-style: solid;
			border-bottom-width: 2px;
			border-left-color: rgb(128, 128, 128);
			border-left-style: solid;
			border-left-width: 2px;
			border-right-color: rgb(128, 128, 128);
			border-right-style: solid;
			border-right-width: 2px;
			border-top-color: rgb(128, 128, 128);
			border-top-left-radius: 23px;
			border-top-right-radius: 23px;
			border-top-style: solid;
			border-top-width: 2px;
			box-sizing: border-box;
			color: rgb(128, 128, 128);
			display: block;
			font-size: 13px;
			font-weight: 400;
			height: 41px;
			text-align: center;
			width: 26px;
			margin: 0 auto;
		}
		
		.nav_ftype{
			color:#333;
			font-size:15px;
			font-weight:500;
			font-family:sans-serif;
		}
		
</style>
			<div class="container" style="background-color:#f5f5f5;width:100%">
				<nav class="navbar navbar-default" style="background-color: transparent;border: none;">
				  <div class="container-fluid" style="margin:25px 0 0 0">
				    <!-- Brand and toggle get grouped for better mobile display -->
				    <div class="navbar-header" style="margin-right:65px">
				      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				        <span class="sr-only">Toggle navigation</span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				      </button>
				      <img src="./images/LOGO.png" style="width:200px">
				    </div>
				     <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="float:right;">
				     <ul class="nav navbar-nav">
					<#list navbars as nav>
						<#if nav.menuLevel == 2>
						<#if navf.haveSubMenu(navbars,nav.menuUuid)==0>
						    <#if "退出" ==nav.menuName >
						       <li><a href="${nav.menuUrl!''}"  id="_logout"   onclick="logout()" class="nav_ftype">${nav.menuName!''}</a></li>
		                 <#else>
							   <li><a href="${nav.menuUrl!''}" class="nav_ftype">${nav.menuName!''}</a></li>
							</#if>
						 </#if>
						 <#if navf.haveSubMenu(navbars,nav.menuUuid)!=0 >
							 <li class="dropdown">
				            <a href="${nav.menuUrl!''}" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" class="nav_ftype">${nav.menuName!''}<span class="caret"></span></a>
								<ul class="dropdown-menu">
								<@navf.getSubNavbar navs=navbars  menuid=nav.menuUuid/>
								</ul>
							</li>
						</#if>
					</#if>
					</#list>
				</ul>
             </div><!-- /.navbar-collapse -->
	</div><!-- /.container-fluid -->
	</nav>
	</div>
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
var _url ="/psmc/login?username=query&ppassword=c4ca4238a0b923820dcc509a6f75849b&transmiturl=/website/backstage/webUserController.do?method=webuserloginout";
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