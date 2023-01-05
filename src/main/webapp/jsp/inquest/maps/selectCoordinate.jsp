<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<html>
<head>
	<%@ include file="../../../common.jsp"%>

	<title>坐标选择</title>
</head>
<body id="body">
<div id="container" style="width:99%;height:99%"></div>
<script type="text/javascript">
	window._AMapSecurityConfig = {
		serviceHost:'https://www.minsiduxing.com:4431/_AMapService',
	}
</script>
<script src="https://webapi.amap.com/loader.js"></script>
<script type="text/javascript">
	var basePath = $("#basePath").val();
	var selectAllSysKeyInfosUrl = basePath+'/system/common/sysKeyController.do?method=selectSysKeyInfos';
	selectAllSysKeyInfosUrl = '<c:url value="'+selectAllSysKeyInfosUrl+'"/>';
	$.ajax({
		type: "POST",
		url: selectAllSysKeyInfosUrl,
		data: null,
		success: function(data){
			var datasjson = JSON.parse(data);
			var syskeys = datasjson.listArray;
			var gdkey = "";
			for(var i=0,l=syskeys.length;i<l;i++){
				if(syskeys[i].sys_key == 'gdmap_key'){
					gdkey = syskeys[i].sys_value;
				}
			}
			AMapLoader.load({
				"key": gdkey,              // 申请好的Web端开发者Key，首次调用 load 时必填
				"version": "2.0"   // 指定要加载的 JSAPI 的版本，缺省时默认为 1.4.15
			}).then((AMap)=>{
				var map = new AMap.Map('container');
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