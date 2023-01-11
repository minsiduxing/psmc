<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<html>
<head>
	<%@ include file="../../../common.jsp"%>

	<title>网格多边形坐标采集功能</title>
</head>
<body id="body">
<style type="text/css">
	.amap-sug-result { z-index: 25000; }

	#panel {
		position: absolute;
		background-color: white;
		max-height: 90%;
		overflow-y: auto;
		top: 10px;
		right: 10px;
		width: 280px;
	}
</style>
<div style="width:100%;height:5%;margin: 5px;">
	<div style="font-size: 5px">
		<input id="address" name="address" style="width:30%;margin-right:1%">
		<input id="addrLocation" name="addrLocation" type="button" style="width:70px;margin-right:1%" value="地址定位"/>
		<input id="gridDraw" name="gridDraw" onclick="enableGridDraw(this);" type="button" style="width:70px;margin-right:1%" value="网格绘制"/>

		<input id="saveGridDraw" name="saveGridDraw" onclick="enableGridDraw(this);" type="button" style="display:none;width:40px;margin-right:1%" value="保存"/>
		<input id="cancelGridDraw" name="cancelGridDraw" onclick="enableGridDraw(this);" type="button" style="display:none;width:40px;margin-right:1%" value="取消"/>
	</div>
	<div id="panel"></div>
</div>
<div id="container" style="width:100%;height:95%;"></div>
<script type="text/javascript">
	var basePath = $("#basePath").val();
	var selectAllSysKeyInfosUrl = basePath+'/system/common/sysKeyController.do?method=selectAllCacheSysKeyInfos';
	var updateGridCoodinateUrl = basePath+'/inquest/tabYcGridBaseinfoController.do?method=updateGirdCoordnate';
	var queryGridByGridUuidUrl = basePath+'/inquest/tabYcGridBaseinfoController.do?method=queryGridByGridUuid';

	selectAllSysKeyInfosUrl = '<c:url value="'+selectAllSysKeyInfosUrl+'"/>';
	updateGridCoodinateUrl = '<c:url value="'+updateGridCoodinateUrl+'"/>';
	queryGridByGridUuidUrl = '<c:url value="'+queryGridByGridUuidUrl+'"/>';
	//地图对象
	var map;
	//网格多边形对象
	var polygon;
	// 鼠标插件
	var mouseTool;
	//绘制新的多边形的临时保存对象
	var overlays = [];

	var gridUuid ='<%=request.getParameter("gridUuid")%>';
	var coordinated ='';
	var mapStyle = '';
	$.ajax({
		type: "POST",
		url: queryGridByGridUuidUrl,
		data: "gridUuid="+gridUuid,
		success: function(data){
			var gridData = JSON.parse(data);
			coordinated = gridData.GRID_COORDINATE != null ? gridData.GRID_COORDINATE : '';
			mapStyle = JSON.parse(gridData.MAP_STYLE);
			/**
			 * 入口 从配置里加载内容绘制地图
			 */
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

						//多边形轮廓线的节点坐标数组
						if(coordinated != null && coordinated !="") {
							polygon = new AMap.Polygon({
								path: eval("["+coordinated+"]")
							});
							polygon.setOptions(mapStyle);
							map.add(polygon);
							map.setFitView(polygon);

							polygon.on('click', function(ev) {
								// 触发事件的对象
								var target = ev.target;
								// 触发事件的地理坐标，AMap.LngLat 类型
								var lnglat = ev.lnglat;
								// 触发事件的像素坐标，AMap.Pixel 类型
								var pixel = ev.pixel;
								// 触发事件类型
								var type = ev.type;
								// 创建 infoWindow 实例
								var infoWindow = new AMap.InfoWindow({
									content: "<p>网格名称:"+gridData.GRID_NAME+"</p>" +
											 "<p>网格人口总数:"+gridData.GRID_PEPOLE_COUNT+"</p>" +
											 "<p>规划办证数量:"+gridData.PLANNING_ISSUE_CERT_TOTAL+",已办证数量："+gridData.PLANNING_ISSUE_CERT_TOTAL+"</p>" +
											 "<p>测算类别依据:</p>" +
											 "<p>"+gridData.LEGAL_PROVISION_DESC+"</p>"
								});

								// 打开信息窗体
								infoWindow.open(map,eval('['+lnglat+']'));
							});
						};

						var clickHandler = function(e) {
							//中心点随鼠标点击移动
							map.setCenter(new AMap.LngLat(e.lnglat.getLng(),e.lnglat.getLat()));
						};
						// 绑定事件
						map.on('click', clickHandler);

						var autoComplete;
						var placeSearch;
						AMap.plugin('AMap.AutoComplete', function(){
							var autoOptions = {
								city: '西安',
								input: 'address'
							};
							// 实例化AutoComplete
							 autoComplete= new AMap.AutoComplete(autoOptions);
						});

						AMap.plugin(["AMap.PlaceSearch"], function() {
							//构造地点查询类
							 placeSearch = new AMap.PlaceSearch({
								pageSize: 5, // 单页显示结果条数
								pageIndex: 1, // 页码
								city: "西安", // 兴趣点城市
								citylimit: true,  //是否强制限制在设置的城市内搜索
								map: map, // 展现结果的地图实例
								panel: "panel", // 结果列表将在此容器中进行展示。
								autoFitView: true // 是否自动调整地图视野使绘制的 Marker点都处于视口的可见范围
							});
						});

						autoComplete.on('select', function(e){
							placeSearch.search(e.poi.name);
						});


					}).catch((e)=>{
						console.error("jsapi加载错误提示："+e);  //加载错误提示
					});
				},
				error:function(XMLHttpRequest, textStatus, errorThrown){
					commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
				}
			});
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
		}
	});




	//开启关闭坐标采集
	function enableGridDraw(obj){
		var ival = obj.value;
		if(ival == "取消"){
			$("#gridDraw").css("display","");
			$("#saveGridDraw").css("display","none");
			$("#cancelGridDraw").css("display","none");
			//取消插件
			mouseTool.close(true);
			map.remove(overlays);
			//恢复以前的多边形
			if(polygon != null && polygon != "")
				polygon.show();
			overlays = [];
		}
		if(ival == "保存"){
			if(overlays == null || overlays == "" || overlays == []){
				alert("请选择坐标");
				return;
			}else{
				$.ajax({
					type: "POST",
					url: updateGridCoodinateUrl,
					data: "isMaintainCoordinate=1&coordinate="+overlays+"&gridUuid="+gridUuid,
					success: function(data){
						var r = JSON.parse(data).result;
						//取消插件
						mouseTool.close(true);
						if(eval(r.flag == 1)){
							commonObj.alert(r.msg,"info");
							map.clearMap();
							polygon = new AMap.Polygon({
								path: eval("["+overlays+"]"),
							});
							polygon.setOptions(mapStyle);
							map.add(polygon);
							map.setFitView(polygon);
							polygon.on('click', function(ev) {
								// 触发事件的对象
								var target = ev.target;
								// 触发事件的地理坐标，AMap.LngLat 类型
								var lnglat = ev.lnglat;
								// 触发事件的像素坐标，AMap.Pixel 类型
								var pixel = ev.pixel;
								// 触发事件类型
								var type = ev.type;
								// 创建 infoWindow 实例
								var infoWindow = new AMap.InfoWindow({
									content: "<p>网格名称:"+gridData.GRID_NAME+"</p>" +
											"<p>网格人口总数:"+gridData.GRID_PEPOLE_COUNT+"</p>" +
											"<p>规划办证数量:"+gridData.PLANNING_ISSUE_CERT_TOTAL+",已办证数量："+gridData.PLANNING_ISSUE_CERT_TOTAL+"</p>" +
											"<p>测算类别依据:</p>" +
											"<p>"+gridData.LEGAL_PROVISION_DESC+"</p>"
								});

								// 打开信息窗体
								infoWindow.open(map,eval('['+lnglat+']'));
							});
						}
						else{
							map.remove(overlays);
							//恢复以前的多边形
							if(polygon != null && polygon != "")
								polygon.show();
							commonObj.warn(r.msg,"warn");
						}
						overlays=[];
						commonObj.query('sologTableId','searchform');
					},
					error:function(XMLHttpRequest, textStatus, errorThrown){
						commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
					}
				});
				$("#gridDraw").css("display","");
				$("#saveGridDraw").css("display","none");
				$("#cancelGridDraw").css("display","none");
			}
		}
		if(ival == "网格绘制"){
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
				//鼠标菜单插件的监听事件
				mouseTool.on('draw', function(ev) {
					var paths = ev.obj.getPath();
					for(var i=0;i<paths.length;i++){
						overlays.push("["+paths[i].lng+","+paths[i].lat+"]");
					}
				});
			});
		}
	}
</script>
</body>
</html>