
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]>    <html class="no-js"> <!--<![endif]-->
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>博汇康宁</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FREEHTML5.CO" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
	<meta name="author" content="FREEHTML5.CO" />
	
	<!-- Google Fonts -->
	
	
	<!-- Animate.css -->
	<link rel="stylesheet" href="css/animate.css">
	<!-- Icomoon Icon Fonts-->
	<link rel="stylesheet" href="css/icomoon.css">
	<!-- Magnific Popup-->
	<link rel="stylesheet" href="css/magnific-popup.css">
	<!-- Owl Carousel -->
	<link rel="stylesheet" href="css/owl.carousel.min.css">
	<link rel="stylesheet" href="css/owl.theme.default.min.css">
	<!-- Bootstrap  -->
	<link rel="stylesheet" href="css/bootstrap.css">
	
	<!-- Cards -->
	<link rel="stylesheet" href="css/cards.css">

	<!-- Modernizr JS -->
	<script src="js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->
	<style type="text/css">
		.dropdown-menu{
		 	background-color: transparent;
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
  			font-weight: 600 !important;
			color: #fff !important;
		}
		.button_{
  			color: #7c5a53 !important;
  			font-weight: 600 !important;
		}
		.dropdown>a, .index_color{
			color: #FFFAFD !important;
			font-weight: 100;
		}
		.dropdown>a:hover, .index_color:hover{
			color: #FFFAFD !important;
			font-weight: 100;
		}
		.dropdown-menu>li>a, .index_colour{
			color: #FFFAFD !important;
			font-weight: 100;
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
			font-size: 18px !important;
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
	</style>
	</head>
	<body>
	
<div id="fh5co-page" style="background-color: #F5F5F5">
		<!-- 网站顶部部导航菜单 -->
<#import "../common/navbarfunction.ftl" as navf />
<div id="fh5co-page" style="background-color: #F5F5F5">
		<nav class="fh5co-nav-style-1" role="navigation" data-offcanvass-position="fh5co-offcanvass-left">	<div class="container">
				<div class="text-center fh5co-link-wrap">
					<ul data-offcanvass="yes">
						<li>
							<img src="./images/LOGO.png" style="width: 14%;">
						</li>
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
<script>
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
		<!-- 网站顶部导航菜单结束 -->
		<div class="fh5co-cover js-full-height" data-next="yes"  style="background-image: url(images/full_001.jpg); background-size:100% 100%;background-repeat:no-repeat;background-position:center;">
		</div>
		<div class="fh5co-project-style-2">
			<div class="text-center" style="width: 70%;margin: 0 auto;">
				<img src="./images/welcome.jpg" style="width: 100%;">
			</div>
			<!-- 企业文化的滚动模态框效果-->
			<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" data-interval="2000">
				<!-- Indicators -->
			  	<ol class="carousel-indicators">
					<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
					<li data-target="#carousel-example-generic" data-slide-to="1"></li>
					<li data-target="#carousel-example-generic" data-slide-to="2"></li>
					<li data-target="#carousel-example-generic" data-slide-to="3"></li>
				  </ol>
			  	<!-- Wrapper for slides -->
			  	<div class="carousel-inner" role="listbox">
			    		<div class="item active">
			      			<img src="images/full_401.jpg" alt="...">
			      			<div class="carousel-caption">
			      			</div>
			    		</div>
			   	 	<div class="item">
			     			<img src="images/full_402.jpg" alt="...">
			      			<div class="carousel-caption">
			      			</div>
			    		</div>
			     		<div class="item">
			      			<img src="images/full_403.jpg" alt="...">
			      			<div class="carousel-caption">
			      			</div>
			    		</div>
			    		<div class="item">
			      			<img src="images/full_404.jpg" alt="...">
			      			<div class="carousel-caption">
			      			</div>
			    		</div>
			  	</div>
			  	<!-- Controls -->
			  	<a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
			    		<span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
			    		<span class="sr-only">Previous</span>
			  	</a>
			  	<a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
			    		<span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			    		<span class="sr-only">Next</span>
			  	</a>		  	
			</div>
			<!-- <div class="container text-center" style="margin-top: 100px;">
				<h2 class="fh5co-heading wow fadeInUp text" data-wow-duration="1s" data-wow-delay=".5s">选择博汇康宁</h2>
			</div>
			<div class="fh5co-features-style-1" style="background-image: url(images/3e.jpg);" data-stellar-background-ratio="0.5">
				<div class="fh5co-overlay"></div>
				<div class="container" style="z-index: 3; position: relative;">
					<div class="row">
						<div class="fh5co-features">
							<div class="fh5co-feature wow fadeInUp" data-wow-duration="1s" data-wow-delay=".8s">
								<div class="icon"><i class="glyphicon glyphicon-education" aria-hidden="true"></i></div>
								<h3>公司资质</h3>
								<p>公司成立于2015年12月，注册资本金超过5000万元人民币，核心成员均有10年以上金融行业资历，目前管理资金规模已达4亿元人民币</p>
							</div>
							<div class="fh5co-feature wow fadeInUp" data-wow-duration="1s" data-wow-delay="1.1s">
								<div class="icon"><i class="glyphicon glyphicon-user" aria-hidden="true"></i></div>
								<h3>团队实力</h3>
								<p>我们拥有一支富有敬业精神和创造力、经验丰富、高素质和专业化的管理团队，团队由金融、投资、企业管理、法律等领域的高端人才、权威专家组成</p>
							</div>
							<div class="fh5co-feature wow fadeInUp" data-wow-duration="1s" data-wow-delay="1.4s">
								<div class="icon"><i class="glyphicon glyphicon-tasks" aria-hidden="true"></i></div>
								<h3>风控体系</h3>
								<p>以风险控制为前提、以市场为导向、以客户为中心、以效益为目标，追求可持续发展，力争发展成为“资本充足、运作安全、内控严密、服务优质、效益良好、有核心竞争力”的现代金融服务企业</p>
							</div>

							<div class="fh5co-feature wow fadeInUp" data-wow-duration="1s" data-wow-delay="1.7s">
								<div class="icon"><i class="glyphicon glyphicon-yen" aria-hidden="true"></i></div>
								<h3>理财方式</h3>
								<p> 	专业的金融产品数据库  帮您轻松理财，资深研究团队深入调研为您提供最放心的服务，三位一体360°的风控体系，只选定性强的金融产品，专属您的理财顾问 一站式服务、咨询、签约省时省心</p>
							</div>
							<div class="fh5co-feature wow fadeInUp" data-wow-duration="1s" data-wow-delay="2s">
								<div class="icon"><i class="glyphicon glyphicon-comment" aria-hidden="true"></i></div>
								<h3>一手讯息</h3>
								<p>获取金融行业的一首财富讯息，实时动态刷新，为您的投资提供高瞻远见的财富指引</p>
							</div>
							<div class="fh5co-feature wow fadeInUp" data-wow-duration="1s" data-wow-delay="2.3s">
								<div class="icon"><i class="glyphicon glyphicon-cloud" aria-hidden="true"></i></div>
								<h3>会员平台</h3>
								<p>成为博汇康宁的尊贵会员，在帮助您稳健理财投资的同时，我们还提供个性化理财方案的定制，变化性的协调方案以及更为精准的财富方向把控，为您的理财之路保驾护航</p>
							</div>

						</div>
					</div>
				</div>
			</div> -->

			
			<div class="fh5co-projects">
				<div class="text-center" id="productlist" style="width: 70%;margin: 0 auto;">
					<img src="./images/product_introduction.jpg" style="width: 100%">
				</div>
				<!-- 
				<ul>
					<li class="wow fadeInUp" style="background-image: url(images/2.jpg);" data-wow-delay="0s">
						<a>
							<div class="fh5co-overlay"></div>
							<div class="container">
								<div class="fh5co-text">
									<div class="fh5co-text-inner">
										<div class="row">
											<div class="col-md-6"><h3>博汇康宁价值优选1期私募证券投资基金</h3></div>
											<div class="col-md-6"><p>投资领域：证券交易所上市交易股票（包括在主板、中小板、创业板上市的股票、上市公司非公开发行股票及新股申购、公募证券投资金）;直接投资...</p></div>
										</div>
									</div>
								</div>
							</div>
						</a>
					</li>
					<li class="wow fadeInUp" style="background-image: url(images/6.jpg);" data-wow-delay="0s">
						<a>
							<div class="fh5co-overlay"></div>
							<div class="container">
								<div class="fh5co-text">
									<div class="fh5co-text-inner">
										<div class="row">
											<div class="col-md-6"><h3>博汇康宁景博稳健1号私募基金</h3></div>
											<div class="col-md-6"><p>本基金允许投资的金融工具包括： 1、权益类金融产品：A股股票、股票期权、期货、融资融券、交易所上市的股票型/混合型基金（含交易所上市的封闭式及开放式证券投资基金、LOF、ETF基金）...</p></div>
										</div>
									</div>
								</div>
							</div>
						</a>
					</li>
					<li class="wow fadeInUp" style="background-image: url(images/65.jpg);" data-wow-delay="0s">
						<a>
							<div class="fh5co-overlay"></div>
							<div class="container">
								<div class="fh5co-text">
									<div class="fh5co-text-inner">
										<div class="row">
											<div class="col-md-6"><h3>博汇康宁股票型管理1期私募证券投资基金</h3></div>
											<div class="col-md-6"><p>投资领域：沪深交易所发行、上市的股票（包括上市公司非公开发行股票、新股申购）、新三板挂牌公司股份、沪港通中港股通标的范围内的股票、深港通中港股通标的范围内的股票、债券、资产支持证券、债券回购...</p></div>
										</div>
									</div>
								</div>
							</div>
						</a>
					</li>
				</ul>
				-->
			</div>
		</div>
		
		<!--
		<div class="fh5co-counter-style-2" style="background-image: url(images/r.jpg);">
			<div class="fh5co-overlay"></div>
			<div class="container" id="numCount">
				<div class="fh5co-section-content-wrap">
					<div class="fh5co-section-content">
						<div class="row">
							<div class="col-md-4 text-center wow fadeInUp" data-wow-duration="1s" data-wow-delay=".5s">
								<div class="icon">
									<i class="glyphicon glyphicon-hand-down"></i>
								</div>
								<span class="fh5co-counter js-counter" data-from="0" data-to="188" data-speed="5000" data-refresh-interval="50"></span>
								<span class="fh5co-counter-label">今日访问量</span>
								
							</div>
							<div class="col-md-4 text-center wow fadeInUp" data-wow-duration="1s" data-wow-delay=".8s">
								<div class="icon">
									<i class="glyphicon glyphicon-thumbs-up"></i>
								</div>
								<span id="dataTo" class="fh5co-counter js-counter" data-from="0" data-to="" data-speed="5000" data-refresh-interval="50"></span>
								<span class="fh5co-counter-label">用户咨询量</span>
							</div>
							<div class="col-md-4 text-center wow fadeInUp" data-wow-duration="1s" data-wow-delay="1.1s">
								<div class="icon">
									<i class="glyphicon glyphicon-user"></i>
								</div>
								<span class="fh5co-counter js-counter" data-from="0" data-to="48" data-speed="5000" data-refresh-interval="50"></span>
								<span class="fh5co-counter-label">会员客户总量</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
			-->
		<!-- 网站底部导航菜单 -->
		<!-- 网站底部导航菜单 -->
		 <#include "footer.html"/>  
		<!-- END footer -->
		<!-- END footer -->
		
	</div>
	<!-- END page-->

	<!-- jQuery -->
	<script src="js/jquery.min.js"></script>
	<!-- jQuery Easing -->
	<script src="js/jquery.easing.1.3.js"></script>
	<!-- Bootstrap -->
	<script src="js/bootstrap.min.js"></script>
	<!-- Waypoints -->
   <script src="js/jquery.waypoints.min.js"></script>
	<!-- Owl Carousel -->
	<script src="js/owl.carousel.min.js"></script>
	<!-- Magnific Popup -->
	<script src="js/jquery.magnific-popup.min.js"></script>
	<!-- Stellar -->
	<script src="js/jquery.stellar.min.js"></script>
	<!-- countTo -->
	<script src="js/jquery.countTo.js"></script>
	<!-- WOW -->
	<script src="js/wow.min.js"></script>
	<script src="js/jquery.cookie.js"></script>
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
		new WOW().init();
		//设置今日访客量的随机两位数（30~99）
		var num = Math.random()*70+30;
		num = parseInt(num, 10);
		$("#dataTo").data('to',num);
	</script>
	<!-- Main -->
	<script src="js/main.js">
		$('#toProduct').click(function () {

			$('html, body').animate({
				scrollTop: $( $.attr(this, 'href') ).offset().top}, 1000);
			 return false;

		});
		$('#toInfo').click(function () {

			$('html, body').animate({
				scrollTop: $( $.attr(this, 'href') ).offset().top}, 1000);
			 return false;

		});
		$('#toNumCount').click(function () {

			$('html, body').animate({
				scrollTop: $( $.attr(this, 'href') ).offset().top}, 1000);
			 return false;

		});

	</script>
	</body>
</html>
