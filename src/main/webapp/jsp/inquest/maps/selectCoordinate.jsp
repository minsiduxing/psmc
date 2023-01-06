<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<html>
<head>
	<%@ include file="../../../common.jsp"%>

	<title>网格多边形坐标采集功能</title>
</head>
<body id="body">
<div style="width:100%;height:5%;margin: 5px;">
	<div style="font-size: 5px">
		<input id="address" name="address" style="width:30%;margin-right:1%">
		<input id="addrLocation" name="addrLocation" type="button" style="width:70px;margin-right:1%" value="地址定位"/>
		<input id="gridDraw" name="gridDraw" onclick="enableGridDraw(this);" type="button" style="width:70px;margin-right:1%" value="网格绘制"/>

		<input id="saveGridDraw" name="saveGridDraw" onclick="enableGridDraw(this);" type="button" style="display:none;width:40px;margin-right:1%" value="保存"/>
		<input id="cancelGridDraw" name="cancelGridDraw" onclick="enableGridDraw(this);" type="button" style="display:none;width:40px;margin-right:1%" value="取消"/>
	</div>
</div>
<div id="container" style="width:100%;height:95%;"></div>
<script type="text/javascript">
	//开启关闭坐标采集
	function enableGridDraw(obj){
		debugger;
		var ival = obj.value;
		if(ival == "取消"){
			$("#gridDraw").css("display","");
			$("#saveGridDraw").css("display","none");
			$("#cancelGridDraw").css("display","none");
			//取消插件
			//恢复以前的多边形
			if(polygon != null && polygon != "")
				polygon.show();

			mouseTool.close();
		}
		if(ival == "保存"){
			$("#gridDraw").css("display","");
			$("#saveGridDraw").css("display","none");
			$("#cancelGridDraw").css("display","none");
			if(polygon != null && polygon != "")
				map.remove(polygon);

		}
		if(ival == "开启网格绘制"){
			$("#gridDraw").css("display","none");
			$("#saveGridDraw").css("display","");
			$("#cancelGridDraw").css("display","");
			//取消插件
			//隐藏以前的多边形
			if(polygon != null && polygon != "")
				polygon.hide();
			//通过插件方式引入 AMap.MouseTool 工具
			map.plugin(["AMap.MouseTool"],function(){
				//在地图中添加MouseTool插件
				mouseTool = new AMap.MouseTool(map);
				//用鼠标工具画多边形
				var drawPolygon = mouseTool.polygon();
			});
		}


	}


	//地图对象
	var map;
	//网格多边形对象
	var polygon;
	var mouseTool;
	var coordinated ='<%=request.getParameter("coordinated")%>';
	var basePath = $("#basePath").val();
	var selectAllSysKeyInfosUrl = basePath+'/system/common/sysKeyController.do?method=selectAllCacheSysKeyInfos';
	selectAllSysKeyInfosUrl = '<c:url value="'+selectAllSysKeyInfosUrl+'"/>';
	$.ajax({
		type: "POST",
		url: selectAllSysKeyInfosUrl,
		data: null,
		success: function(data){
			var datasjson = JSON.parse(data);
			var syskeys = datasjson.listArray;
			var gdkey = "";
			var gdmap_jsapi_version = "";
			var gdmap_market_icon = "";
			for(var i=0,l=syskeys.length;i<l;i++){
				if(syskeys[i].sys_key == 'gdmap_key'){
					gdkey = syskeys[i].sys_value;
				}
				if(syskeys[i].sys_key == 'gdmap_jsapi_version'){
					gdmap_jsapi_version = syskeys[i].sys_value;
				}
				if(syskeys[i].sys_key == 'gdmap_market_icon'){
					gdmap_market_icon = syskeys[i].sys_value;
				}
			}
			AMapLoader.load({
				"key": gdkey,              // 申请好的Web端开发者Key，首次调用 load 时必填
				"version": gdmap_jsapi_version   // 指定要加载的 JSAPI 的版本，缺省时默认为 1.4.15
			}).then((AMap)=>{
				 map = new AMap.Map('container',{
					zoom: 10,  //设置地图显示的缩放级别
					center: [108.953984,34.255958]//设置地图中心点坐标
				});

				AMap.plugin('AMap.ToolBar',function(){//异步加载插件
					var toolbar = new AMap.ToolBar();
					map.addControl(toolbar);
				});
				//多边形轮廓线的节点坐标数组
				if(coordinated != null && coordinated !="") {
					 polygon = new AMap.Polygon({
						path: eval(coordinated),
						fillColor: '#808000', // 多边形填充颜色
						strokeColor: '#808000', // 线条颜色
						strokeStyle:'dashed',//实线虚线
						fillOpacity:'0.1',//透明度
					});
					map.add(polygon);
					//改为自适应展示
					//map.setZoomAndCenter(17,eval(coordinated)[0]);
					map.setFitView(polygon);
				}

				var clickHandler = function(e) {
					//中心点随鼠标点击移动
					map.setCenter(new AMap.LngLat(e.lnglat.getLng(),e.lnglat.getLat()));
				};
				// 绑定事件
				map.on('click', clickHandler);

				map.on('click', function(ev) {
					// 触发事件的对象
					var target = ev.target;
					// 触发事件的地理坐标，AMap.LngLat 类型
					var lnglat = ev.lnglat;
					// 触发事件的像素坐标，AMap.Pixel 类型
					var pixel = ev.pixel;
					// 触发事件类型
					var type = ev.type;
				});
			}).catch((e)=>{
				console.error("jsapi加载错误提示："+e);  //加载错误提示
			});
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
			$.messager.progress("close");
		}
	});
</script>
</body>
</html>