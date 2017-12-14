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
<!-- 公司历程时间轴 -->
<link href="css/timerStyle.css" rel="stylesheet">
<!-- Modernizr JS -->
<script src="js/modernizr-2.6.2.min.js"></script>
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
<script src="js/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" href="css/custom.css">

<!-- baidu -->
<script type="text/javascript" src="http://api.map.baidu.com/api?key=&v=1.1&services=true"></script>

<style type="text/css" media="screen">
	 /* 解决页面抖动*/
	 body{ overflow: auto !important;} .modal{ overflow: auto !important;} 
	  /* 百度样式*/
    .iw_poi_title {color:#CC5522;font-size:14px;font-weight:bold;overflow:hidden;padding-right:13px;white-space:nowrap}
    .iw_poi_content {font:12px arial,sans-serif;overflow:visible;padding-top:4px;white-space:-moz-pre-wrap;word-wrap:break-word}
	</style>
</head>
<body>
<!-- 网站顶部部导航菜单 -->
		 <#include "head.html"/> 
		<!-- 网站顶部导航菜单结束 -->
	<div id="fh5co-page" style="background-color:#F5F5F5">
		<div class="fh5co-cover fh5co-cover-style-2">
			<div class="fh5co-overlay"></div>
			<div class="fh5co-cover-text">
				<div class="container">
					<div class="row">
						<div>
							<div class="fh5co-cover-intro">
								<h1 class="cover-text-lead wow fadeInUp" data-wow-duration="1s" data-wow-delay="1.5s">加入我们</h1>
								<span class="companyEN">JOIN US</span>
								<i class="companyLine"></i>
								<h2 class="cover-text-sublead wow fadeInUp" data-wow-duration="1s" data-wow-delay="1.8s">欢迎加入博汇康宁</h2>
							</div>
						</div>
					</div>
				</div>	
			</div>
		</div>
		
		
		<!--联系我们 start-->
		
		<div class="fh5co-projects" style="background-color:white">
				</br>	
				<div class="container" style="width: 80%;">
					<div class="row" style="text-align:center;font-family:sans-serif;font-size:26px;">
						<div class="col-md-3" style="width:100%;">
					 		<img src="./images/rwm.png" style="width: 15%">
					 		</br></br></br>
					 		<p>联系地址:陕西省西安市科技路西段绿地鸿海大厦B座9层</p>
							<p>联系电话:029-84536670</p>
							<p>电子邮箱:bhkn@bohuikangning.com</p>
					 	</div>
					</div>
					</br>
					<div class="row">
					 	<div class="col-md-3"  style="width: 100%;">
					 		<!--百度地图容器-->
  							<div style="width:95%;height:300px;border:#ccc solid 1px;" id="dituContent"></div>			
					 	</div>
					</div>
				</div>
				</br>
		</div>
		<!--联系我们 end-->
		
		
		<!-- 网站底部导航菜单 -->
		 <#include "footer.html"/>  
		<!-- END footer -->
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

<!-- Main -->
<script src="js/main.js"></script>
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

<script type="text/javascript">
    //创建和初始化地图函数：
    function initMap(){
        createMap();//创建地图
        setMapEvent();//设置地图事件
        addMapControl();//向地图添加控件
        addMarker();//向地图中添加marker
    }
    
    //创建地图函数：
    function createMap(){
        var map = new BMap.Map("dituContent");//在百度地图容器中创建一个地图
        var point = new BMap.Point(108.847594,34.244938);//定义一个中心点坐标
        map.centerAndZoom(point,18);//设定地图的中心点和坐标并将地图显示在地图容器中
        window.map = map;//将map变量存储在全局
    }
    
    //地图事件设置函数：
    function setMapEvent(){
        map.enableDragging();//启用地图拖拽事件，默认启用(可不写)
        map.enableScrollWheelZoom();//启用地图滚轮放大缩小
        map.enableDoubleClickZoom();//启用鼠标双击放大，默认启用(可不写)
        map.enableKeyboard();//启用键盘上下左右键移动地图
    }
    
    //地图控件添加函数：
    function addMapControl(){
        //向地图中添加缩放控件
	var ctrl_nav = new BMap.NavigationControl({anchor:BMAP_ANCHOR_TOP_LEFT,type:BMAP_NAVIGATION_CONTROL_LARGE});
	map.addControl(ctrl_nav);
        //向地图中添加缩略图控件
	var ctrl_ove = new BMap.OverviewMapControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT,isOpen:0});
	map.addControl(ctrl_ove);
        //向地图中添加比例尺控件
	var ctrl_sca = new BMap.ScaleControl({anchor:BMAP_ANCHOR_BOTTOM_LEFT});
	map.addControl(ctrl_sca);
    }
    
    //标注点数组
    var markerArr = [{title:"博汇康宁（深圳）投资基金管理有限公司",content:"联系地址：陕西省西安市科技路西段绿地鸿海大厦B座9层</br></br>联系电话:029-84536670</br></br>电子邮箱:bhkn@bohuikangning.com",point:"108.846736|34.24496",isOpen:1,icon:{w:21,h:21,l:0,t:0,x:6,lb:5}}
		 ];
    //创建marker
    function addMarker(){
        for(var i=0;i<markerArr.length;i++){
            var json = markerArr[i];
            var p0 = json.point.split("|")[0];
            var p1 = json.point.split("|")[1];
            var point = new BMap.Point(p0,p1);
			var iconImg = createIcon(json.icon);
            var marker = new BMap.Marker(point,{icon:iconImg});
			var iw = createInfoWindow(i);
			var label = new BMap.Label(json.title,{"offset":new BMap.Size(json.icon.lb-json.icon.x+10,-20)});
			marker.setLabel(label);
            map.addOverlay(marker);
            label.setStyle({
                        borderColor:"#808080",
                        color:"#333",
                        cursor:"pointer"
            });
			
			(function(){
				var index = i;
				var _iw = createInfoWindow(i);
				var _marker = marker;
				_marker.addEventListener("click",function(){
				    this.openInfoWindow(_iw);
			    });
			    _iw.addEventListener("open",function(){
				    _marker.getLabel().hide();
			    })
			    _iw.addEventListener("close",function(){
				    _marker.getLabel().show();
			    })
				label.addEventListener("click",function(){
				    _marker.openInfoWindow(_iw);
			    })
				if(!!json.isOpen){
					label.hide();
					_marker.openInfoWindow(_iw);
				}
			})()
        }
    }
    //创建InfoWindow
    function createInfoWindow(i){
        var json = markerArr[i];
        var iw = new BMap.InfoWindow("<b class='iw_poi_title' title='" + json.title + "'>" + json.title + "</b><div class='iw_poi_content'>"+json.content+"</div>");
        return iw;
    }
    //创建一个Icon
    function createIcon(json){
        var icon = new BMap.Icon("http://app.baidu.com/map/images/us_mk_icon.png", new BMap.Size(json.w,json.h),{imageOffset: new BMap.Size(-json.l,-json.t),infoWindowOffset:new BMap.Size(json.lb+5,1),offset:new BMap.Size(json.x,json.h)})
        return icon;
    }
    
    initMap();//创建和初始化地图
</script>
</body>
</html>