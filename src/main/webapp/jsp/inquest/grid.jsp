<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<html>
<head>
	<%@ include file="../../common.jsp"%>

	<title>网格管理列表</title>
</head>
<body id="body">

<div class="query-content panel easyui-accordion accordion " data-options="selected:false" style="width:100%">
	<div title="信息查询" >
		<form id="searchform" method="POST" class="query-form" >
			<ul class="searchform">
				<li class="li-input"><label for="" class="input-label">网格名称：</label>
					<input class="myinput" id="gridName" name="gridName"></input>
				</li>
				<li class="li-input"><label for="" class="input-label">是否配置规则：</label>
					<input class="myinput" id="isConfigEdRule" name="isConfigEdRule"></input>
				</li>
				<li class="li-input"><label for="" class="input-label">是否采集坐标：</label>
					<input class="myinput" id="isMaintainCoordinate" name="isMaintainCoordinate"></input>
				</li>
				<li class="li-input"><label for="" class="input-label">网格测算类别：</label>
					<input class="myinput" id="gridMtypeName" name="gridMtypeName"></input>
				</li>
			</ul>
		</form>
		<div class="query-oper">
			<a href="#" class="easyui-linkbutton" onclick="commonObj.query('sologTableId','searchform')" id="submit_search" plain="true" iconCls="icon-search">查询</a>
		</div>
	</div>
</div>

<table id="sologTableId" style="width:100%"></table>
<div id="toolbarId">
	<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="add">测算公式</a>
</div>

<div id="ruleWin">
	<div id="ruleAccordion"></div>
</div>


</body>

<script type="text/javascript">
	var basePath = $("#basePath").val();

	var getTabDataUrl = basePath+"/inquest/tabYcGridBaseinfoController.do";
	getTabDataUrl ='<c:url value="'+getTabDataUrl+'"/>?method=selectGridInfoList';

	var gridCaclUrl = basePath+"/jsp/inquest/gridCacl.jsp?version="+'<%=request.getParameter("version").toString() %>';

	var loadGridModelTypeDictListUrl = basePath+"/inquest/tabYcGridModelTypeController.do";
	loadGridModelTypeDictListUrl ='<c:url value="'+loadGridModelTypeDictListUrl+'"/>?method=loadGridModelTypeDictList&version=<%=request.getParameter("version").toString() %>';


</script>

<script type="text/javascript" src="grid.js"></script>
</html>