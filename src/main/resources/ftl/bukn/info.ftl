<!DOCTYPE html>
<!--[if   lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if   IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if   IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if   gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<link rel="stylesheet" href="css/custom.css">
<link rel="stylesheet" href="css/info.css">
</head>
<body>
        <!-- 网站顶部部导航菜单 -->
		 <#include "head.html"/> 
		<!-- 网站顶部导航菜单结束 -->
	<div id="fh5co-page" style="background-color: #F5F5F5">
		
		<div class="fh5co-cover fh5co-cover-style-2">
			<div class="fh5co-overlay"></div>
			<div class="fh5co-cover-text">
				<div class="container">
					<div class="row">
						<div>
							<div class="fh5co-cover-intro">
								<h1 class="cover-text-lead wow fadeInUp" data-wow-duration="1s" data-wow-delay="1.5s">行情资讯</h1>
								<span class="companyEN">QUOTATION INFORMATION</span>
								<i class="companyLine"></i>
								<h2 class="cover-text-sublead wow fadeInUp" data-wow-duration="1s" data-wow-delay="1.8s">行情资讯为您实时提供最新，最具焦点，最有价值的行业资讯，掌握先机，财富先赢。</h2>
							</div>
						</div>
					</div>
				</div>	
			</div>
		</div>
		<!-- 顶部导航条 end-->
		<div class="fh5co-project-style-2">
			<div class="comContentDiv">
				<a name="compCuContent"></a>
				<div class="compCulture">
					<span class="compCuContent">行&nbsp;情&nbsp;资&nbsp;讯</span>
				</div>
				<div class="container" style="width: 80%;">
					<div class="row" style="margin: 5%;">
					 	<div class="col-md-4">
					 		<div class="productDiv">
					 			<a id="hotNews">热点新闻</a>
					 		</div>
					 	</div>
					  	<div class="col-md-4">
					 		<div class="productDiv">
					 			<a id="timeNews">实时资讯</a>
					 		</div>
					 	</div>
					 	<div class="col-md-4">
					 		<div class="productDiv">
					 			<a id="hangYeMove">行业动向</a>
					 		</div>
					 	</div>
					</div>
					<div class="infoBorder">
						<div id="newsBlock1" class="newsInfoDiv">
						</div>
						<!-- newsBlock2-->
						<div id="newsBlock2" class="newsInfoDiv">
						</div>
						<!-- newsBlock3-->
						<div id="newsBlock3" class="newsInfoDiv">
						</div>
					</div>
					<nav aria-label="Page navigation" class="tabDiv">
					  	<ul class="pagination pagination-lg" id="pageList">
					    		
					  	</ul>
					</nav>
				</div>	
			</div>
		</div>
		
		<!-- 网站底部导航菜单 -->
		 <#include "footer.html"/>  
		<!-- END footer -->
	</div>
	<!-- Modal -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  	<div class="modal-dialog" role="document"  style="width:100%;">
	    		<div class="modal-content">
	      			<div class="modal-header">
		        			<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        			<div class="modal-title text-center" id="myModalLabeltitle" ></div>
		        	 		<div id="newsauthor" class="text-right">
		        	 		   <span class="glyphicon glyphicon-user"></span><span id="author" ></span>
					          <span id="newdate"></span>
					         </div>
		        			<h3 class="modal-title text-right" id="myModalLabelsub" ></h3>
					</div>
				   <div class="modal-body">
			           <h3 id="newabstract" class="text-left">
					   </h3>
					<div id="myModalText" class="text-left">
						
					</div>
					  
				</div>
		      		<div class="modal-footer">
				        	<button style="width:10%;font-size:25px;" type="button" class="btn btn-default"   data-dismiss="modal">返回</button>
		      		</div>
	    		</div>
	  	</div>
	</div>

<!--    jQuery -->
<script src="js/jquery.min.js"></script>
<!--    jQuery Easing -->
<script src="js/jquery.easing.1.3.js"></script>
<!--    Bootstrap -->
<script src="js/bootstrap.min.js"></script>
<!--    Waypoints -->
<script src="js/jquery.waypoints.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<!--    Magnific Popup -->
<script src="js/jquery.magnific-popup.min.js"></script>
<!--    Stellar -->
<script src="js/jquery.stellar.min.js"></script>
<!--    countTo -->
<script src="js/jquery.countTo.js"></script>
<!--    WOW -->
<script src="js/wow.min.js"></script>
<script>
<#--新闻数据初始化因为要用模板获取数据不能用外部js begin -->
new WOW().init();
    //热点新闻
     var hotNewsArry = ${hotNews};
	//实时资讯
	var timeNewsArray =  ${quotationNews};
	//行业动向
	var hyNewsArray = ${latesTrendsNews};

</script>
<#--新闻数据初始化因为要用模板获取数据不能用外部js end -->
<script src="js/info.js"></script>
<!-- Main -->
<script src="js/main.js"></script>
</body>
</html>