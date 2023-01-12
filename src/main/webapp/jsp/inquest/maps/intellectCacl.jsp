<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<html>
<head>
	<%@ include file="../../../common.jsp"%>
	<title>智能测算</title>
</head>
<body id="body">
<%@ include file="./gd_js_load.jsp"%>
<style type="text/css">
	.amap-sug-result { z-index: 25000; }
	#panel {
		z-index: 25000;
		position: absolute;
		background-color: white;
		max-height: 90%;
		overflow-y: auto;
		top: 30px;
		right: 10px;
		width: 280px;
	}
</style>
<div style="width:100%;height:5%;margin: 5px;">
	<div style="font-size: 5px">
		<input id="address" name="address" style="width:30%;margin-right:1%">
		<input id="search" name="search" onclick="search();" type="button" style="width:70px;margin-right:1%" value="地址搜索"/>
		<input id="cacl" name="cacl" onclick="search();" type="button" style="width:70px;margin-right:1%" value="智能测算"/>
	</div>
	<div id="panel"></div>
</div>
<div id="container" style="width:100%;height:450px;"></div>

<script type="text/javascript">
	var basePath = $("#basePath").val();
	var selectAllSysKeyInfosUrl = basePath+'/system/common/sysKeyController.do?method=selectAllCacheSysKeyInfos';
	var queryAllGirdUrl = basePath+'/inquest/tabYcGridBaseinfoController.do?method=queryAllGird';

	selectAllSysKeyInfosUrl = '<c:url value="'+selectAllSysKeyInfosUrl+'"/>';
	queryAllGirdUrl = '<c:url value="'+queryAllGirdUrl+'"/>';
	//地图对象
	var map;
	var gdkey = "";
	var gdmap_jsapi_version = "";
	var gdmap_init_info;
	var gridDatas;
	var coverGroups = [];
	/**
	 * 入口 从配置里加载内容绘制地图
	 */
	$.ajax({
		type: "POST",
		url: selectAllSysKeyInfosUrl,
		data: null,
		success: function(data) {
			var datasjson = JSON.parse(data);
			var syskeys = datasjson.listArray;

			for(var i=0,l=syskeys.length;i<l;i++){
				if(syskeys[i].sys_key == 'gdmap_key'){
					gdkey = syskeys[i].sys_value;
				}
				if(syskeys[i].sys_key == 'gdmap_jsapi_version'){
					gdmap_jsapi_version = syskeys[i].sys_value;
				}
				if(syskeys[i].sys_key == 'gdmap_init_info'){
					gdmap_init_info = JSON.parse(syskeys[i].sys_value);
				}
			}
			var map_d_init = eval(gdmap_init_info.default_init);
			AMapLoader.load({
				"key": gdkey,              // 申请好的Web端开发者Key，首次调用 load 时必填
				"version": gdmap_jsapi_version   // 指定要加载的 JSAPI 的版本，缺省时默认为 1.4.15
			}).then((AMap)=>{
				map = new AMap.Map('container', ({
							zoom:map_d_init.zoom,
							center:JSON.parse(map_d_init.center)
						})
				);
				AMap.plugin([
					'AMap.ToolBar',
					'AMap.Scale',
					'AMap.HawkEye',
					'AMap.MapType',
					'AMap.Geolocation',
				], function(){
					// 在图面添加工具条控件，工具条控件集成了缩放、平移、定位等功能按钮在内的组合控件
					map.addControl(new AMap.ToolBar());
					// 在图面添加比例尺控件，展示地图在当前层级和纬度下的比例尺
					map.addControl(new AMap.Scale());
					//
					// // 在图面添加鹰眼控件，在地图右下角显示地图的缩略图
					// map.addControl(new AMap.HawkEye({isOpen:true}));

					// 在图面添加类别切换控件，实现默认图层与卫星图、实施交通图层之间切换的控制
					map.addControl(new AMap.MapType());

					// // 在图面添加定位控件，用来获取和展示用户主机所在的经纬度位置
					// map.addControl(new AMap.Geolocation());
				});
				var clickHandler = function(e) {
					if(coverGroups != [] && coverGroups.length>0){
						map.remove(coverGroups);
						coverGroups=[];
					}
					dynamicLoadCovers("["+e.lnglat.getLng()+","+e.lnglat.getLat()+"]");
					//中心点随鼠标点击移动
					map.setCenter(new AMap.LngLat(e.lnglat.getLng(),e.lnglat.getLat()));
				};
				// 绑定事件
				map.on('click', clickHandler);

				//初始化网格添加物
				$.ajax({
					type: "POST",
					url: queryAllGirdUrl,
					data: null,
					success: function (data) {
						gridDatas = JSON.parse(data).listArray;
						dynamicLoadCovers(map_d_init.center);
					}, error: function (XMLHttpRequest, textStatus, errorThrown) {
						commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
					}
				})
			}).catch((e)=>{
				console.error("jsapi加载错误提示："+e);  //加载错误提示
			});
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
		}
	});

	/*动态加载覆盖物*/
	function dynamicLoadCovers(centerCoordinate){
		for (var i = 0; i < gridDatas.length; i++) {
			var gridData = eval(gridDatas[i]);
			//计算坐标点和网格的地面距离
			var dis = AMap.GeometryUtil.distanceToSegment(eval(centerCoordinate),eval("["+gridData.GRID_COORDINATE+"]"));
			gridData.DIS = dis;
			gridDatas[i] = gridData;
			/*<=100米的话纳入展示的覆盖物范围内*/
			if(parseInt(dis)<=1000){
				var polygon = new AMap.Polygon({
					path: eval("["+gridData.GRID_COORDINATE+"]")
				});
				polygon.setOptions(JSON.parse(gridData.MAP_STYLE));
				coverGroups.push(polygon);
			}
		}
		console.info(gridDatas);

		if(coverGroups == [] || coverGroups.length == 0){
		}else{
			map.add(coverGroups);
			map.setFitView();
		}

	}
	/*简单版搜索功能*/
	function search(){
		var address = $("#address").val();
		AMap.plugin(["AMap.PlaceSearch"], function() {
			//构造地点查询类
			placeSearch = new AMap.PlaceSearch({
				pageSize: 10, // 单页显示结果条数
				pageIndex: 1, // 页码
				city: gdmap_init_info.default_city, // 兴趣点城市
				citylimit: true,  //是否强制限制在设置的城市内搜索
				map: map, // 展现结果的地图实例
				panel: "panel", // 结果列表将在此容器中进行展示。
				autoFitView: true // 是否自动调整地图视野使绘制的 Marker点都处于视口的可见范围
			});
		});
		placeSearch.search(address);
	}
</script>
</body>
</html>