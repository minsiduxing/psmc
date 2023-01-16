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
		经营地址：<input id="searchAddress" name="searchAddress" style="width:30%;margin-right:1%">
		<input id="search" name="search" onclick="search();" type="button" style="width:70px;margin-right:1%" value="地址搜索"/>
		<input id="cacl" name="cacl" onclick="caclFun();" type="button" style="width:70px;margin-right:1%" value="开始测算"/>
	</div>
	<div id="panel"></div>
</div>
<div id="container" style="width:100%;height:450px;"></div>

<script type="text/javascript">
	var basePath = $("#basePath").val();
	var selectAllSysKeyInfosUrl = basePath+'/system/common/sysKeyController.do?method=selectAllCacheSysKeyInfos';
	var queryAllGirdUrl = basePath+'/inquest/tabYcGridBaseinfoController.do?method=queryAllGird';
	var queryAllregionCoordUrl = basePath+'/inquest/tabYcRegionCoordinateController.do?method=queryAllregionCoordinate';

	var selectGridCalculationModelInfoListBymodelTypeUuidUrl = basePath+'/inquest/tabYcGridCalculationModelController.do?method=selectGridCalculationModelInfoListBymodelTypeUuid';
	var gridCmodelHanleCertCaclUrl = basePath+'/inquest/tabYcGridCalculationModelController.do?method=gridCmodelHanleCertCacl';

	selectAllSysKeyInfosUrl = '<c:url value="'+selectAllSysKeyInfosUrl+'"/>';
	queryAllGirdUrl = '<c:url value="'+queryAllGirdUrl+'"/>';
	queryAllregionCoordUrl = '<c:url value="'+queryAllregionCoordUrl+'"/>';
	selectGridCalculationModelInfoListBymodelTypeUuidUrl = '<c:url value="'+selectGridCalculationModelInfoListBymodelTypeUuidUrl+'"/>';
	gridCmodelHanleCertCaclUrl = '<c:url value="'+gridCmodelHanleCertCaclUrl+'"/>';

	//地图对象
	var map;
	var gdkey = '';
	var gdmap_jsapi_version = '';
	var gdmap_init_info = '';
	var gdmap_cacl_param = '';
	//网格总量
	var gridDatas;
	//中小学总量
	var regionCoordinateDatas;
	//覆盖物数组
	var coverGroups = [];
	//经营地址
	var businessAddress = '';
	//已选择网格
	var choosedGrid;
</script>
<script src="./znkyCore.js"></script>
<script>
	/**
	 * 入口 从配置里加载内容绘制地图
	 */
			var version = "<%=request.getParameter("version")%>";
			var data = commonObj.postAjax(selectAllSysKeyInfosUrl,null);
			var datasjson = JSON.parse(data);
			var syskeys = datasjson.listArray;
			for(var i =0;i<syskeys.length;i++){
				var syskeyobj = syskeys[i];
				if(syskeyobj.sys_key == 'gdmap_key'){
					gdkey = JSON.parse(syskeyobj.sys_value);
				}
				if(syskeyobj.sys_key == 'gdmap_jsapi_version'){
					gdmap_jsapi_version = syskeyobj.sys_value;
				}
				if(syskeyobj.sys_key == 'gdmap_init_info'){
					gdmap_init_info = JSON.parse(syskeyobj.sys_value);
				}
				if(syskeyobj.sys_key == 'gdmap_cacl_param'){
					gdmap_cacl_param = JSON.parse(syskeyobj.sys_value);
				}
			}
			var map_d_init = eval(gdmap_init_info.default_init);

			AMapLoader.load({
				"key": gdkey.jsapi,              // 申请好的Web端开发者Key，首次调用 load 时必填
				"version": gdmap_jsapi_version   // 指定要加载的 JSAPI 的版本，缺省时默认为 1.4.15
			}).then((AMap)=> {
				map = new AMap.Map('container', ({
							zoom: map_d_init.zoom,
							center: JSON.parse(map_d_init.center)
						})
				);
				AMap.plugin([
					'AMap.ToolBar',
					'AMap.Scale',
					'AMap.HawkEye',
					'AMap.MapType',
					'AMap.Geolocation',
				], function () {
					// 在图面添加工具条控件，工具条控件集成了缩放、平移、定位等功能按钮在内的组合控件
					map.addControl(new AMap.ToolBar());
					// 在图面添加比例尺控件，展示地图在当前层级和纬度下的比例尺
					map.addControl(new AMap.Scale());
					// 在图面添加类别切换控件，实现默认图层与卫星图、实施交通图层之间切换的控制
					map.addControl(new AMap.MapType());
				});

				var clickHandler = function (e) {
					//动态加载覆盖物（网格、特殊区域、零售户）
					dynamicLoadCovers("[" + e.lnglat.getLng() + "," + e.lnglat.getLat() + "]");
					//中心点随鼠标点击移动
					map.setCenter(new AMap.LngLat(e.lnglat.getLng(), e.lnglat.getLat()));
				};
				// 绑定事件
				map.on('click', clickHandler);

				//初始化网格
				var gdata = commonObj.postAjax(queryAllGirdUrl, "version="+version);
				gridDatas = JSON.parse(gdata).listArray;

				//初始化特殊区域
				var rdata = commonObj.postAjax(queryAllregionCoordUrl, null);
				regionCoordinateDatas = eval(rdata);
				//初始化零售户

				//动态加载覆盖物（网格、特殊区域、零售户）
				dynamicLoadCovers(map_d_init.center);
			});


	/*动态加载覆盖物（网格、特殊区域、零售户）*/
	function dynamicLoadCovers(centerCoordinate){
		if (coverGroups != [] && coverGroups.length > 0) {
			map.remove(coverGroups);
			coverGroups = [];
		}

		if(businessAddress != null && businessAddress !=''){
			map.remove(businessAddress);
		}
		for (var i = 0; i < gridDatas.length; i++) {
			var gridData = eval(gridDatas[i]);
			//计算坐标点和网格的地面距离
			var dis = AMap.GeometryUtil.distanceToSegment(eval(centerCoordinate),eval("["+gridData.GRID_COORDINATE+"]"));
			gridData.DIS = dis;
			gridDatas[i] = gridData;
			if(parseInt(dis)<=gdmap_cacl_param.origin_to_grid_dis){
				var polygon = new AMap.Polygon({
					path: eval("["+gridData.GRID_COORDINATE+"]"),
					extData:gridData
				});
				polygon.setOptions(JSON.parse(gridData.MAP_STYLE));
				polygon.on('click', polygonClickFunc);
				coverGroups.push(polygon);
			}
		}
		// console.info(regionCoordinateDatas);
		for (var i = 0; i < regionCoordinateDatas.length; i++) {
			var regioncData = JSON.parse(regionCoordinateDatas[i]);
			//计算坐标点和网格的地面距离
			var dis = AMap.GeometryUtil.distance(eval(centerCoordinate),eval("["+regioncData.coordinate+"]"));
			regioncData.DIS = dis;
			regionCoordinateDatas[i] = JSON.stringify(regioncData);
			/*展示原点<=x米范围内覆盖物*/
			if(parseInt(dis)<=gdmap_cacl_param.origin_to_grid_dis){
				var marker = new AMap.Marker({
					position: eval("["+regioncData.coordinate+"]"),
					title: regioncData.regionName
				});
				coverGroups.push(marker);
			}
		}

		if(coverGroups != [] && coverGroups.length != 0){
			map.add(coverGroups);
		}
		businessAddress = new AMap.Marker({
			position: eval(centerCoordinate),   // 经纬度对象，也可以是经纬度构成的一维数组[116.39, 39.9]
			title: '经营地址'
		});
		map.add(businessAddress);
		map.setFitView();

		isPointInRing(centerCoordinate);
	}

	//网格覆盖物事件
	function polygonClickFunc(ev){
		// 触发事件的对象
		var target = ev.target;
		// 触发事件的地理坐标，AMap.LngLat 类型
		var lnglat = ev.lnglat;
		// 触发事件的像素坐标，AMap.Pixel 类型
		var pixel = ev.pixel;
		// 触发事件类型
		var type = ev.type;
		var p0 = [ev.lnglat.getLng(),ev.lnglat.getLat()];

		// 创建 infoWindow 实例
		var gridDataTemp = target.getExtData();
		// var infoWindow = new AMap.InfoWindow({
		// 	content: "<p>网格名称:"+gridDataTemp.GRID_NAME+"</p>" +
		// 			"<p>网格人口总数:"+gridDataTemp.GRID_PEPOLE_COUNT+",规划办证数量:"+gridDataTemp.PLANNING_ISSUE_CERT_TOTAL+",已办证数量："+gridDataTemp.PLANNING_ISSUE_CERT_TOTAL+"</p>" +
		// 			"<p></p>" +
		// 			"<p>测算类别依据:</p>" +
		// 			"<p>"+gridDataTemp.LEGAL_PROVISION_DESC+"</p>"
		// });
		// 打开信息窗体
		// infoWindow.open(map,eval('['+lnglat+']'));

		dynamicLoadCovers(p0);
	}

	/**
	 * 测算总入口
	 */
	function caclFun(){
		if(choosedGrid != null && choosedGrid != ''){
		}else{
			commonObj.alert("您的经营地址所在地暂无网格归属,请确认是否属于如下网格：","info");
			choosedGrid = '';
		}

		$.messager.confirm('消息', "归属网格"+choosedGrid.GRID_NAME+"</br>您已在地图上选择并正确标记了经营地址的坐标位置?", function(r){
			if (r){
				//获取该网格类型对应的所有计算公式
				var gridCaclModelList = JSON.parse(commonObj.postAjax(selectGridCalculationModelInfoListBymodelTypeUuidUrl, "modelTypeUuid="+choosedGrid.GRID_MTYPE_UUID));
				//console.info("该网格类型对应的所有计算公式:"+gridCaclModelList);

				//门店特征
				var features = loadFeaturesHtmlContent(gridCaclModelList);

				$.messager.confirm('您的门店特征：',features, function(r){
					if (r){
						var gridCmNo = $("#featureInp").val();
						// debugger;
						var newgridCaclModelList = loadNewCmodelListByFeatures(gridCmNo,gridCaclModelList);
						//分别执行公式进行测算
						var rresult = "";
						for(var z=0;z<newgridCaclModelList.length;z++){
							var rdata = null;
							var newgridCaclMode = newgridCaclModelList[z];
							var ruleType = newgridCaclMode.RULE_TYPE;
							if(4 == ruleType || 5 == ruleType){
								rdata = disCacl(newgridCaclMode);
							}
							if(1 == ruleType || 3 == ruleType){
								rdata = totalAndVolumeCacl(newgridCaclMode);
							}
							 // debugger;
							if(rdata !=null){
								console.info(rdata);
								rdata = JSON.parse(rdata);
								rresult +="</br>"+rdata.result.msg;
							}
						}
						commonObj.alert(rresult,"info");
					}
				});
			}
		});
	}
</script>
</body>
</html>