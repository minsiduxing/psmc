<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<html>
<head>
	<%@ include file="../../common.jsp"%>

	<title>网格测算公式管理列表</title>
</head>
<body id="body">

<div class="query-content panel easyui-accordion accordion " data-options="selected:false" style="width:100%">
	<div title="信息查询" >
		<form id="searchform" method="POST" class="query-form" >
			<ul class="searchform">
				<li class="li-input"><label for="" class="input-label">店面位置特征：</label>
					<input class="myinput" id="gridCmodelName" name="gridCmodelName"></input>
				</li>
				<li class="li-input"><label for="" class="input-label">测算类别：</label>
					<input class="myinput" id="gridModelType" name="gridModelType"></input>
				</li>
				<li class="li-input"><label for="" class="input-label">计算方式：</label>
					<input class="myinput" id="ruleType" name="ruleType"></input>
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
	<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="add">新增</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="update">修改</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="del">删除</a>
</div>

<div id="ruleWin">
	<div id="ruleAccordion"></div>
</div>


</body>

<script type="text/javascript">
	var basePath = $("#basePath").val();

	var getTabDataUrl = basePath+"/inquest/tabYcGridCalculationModelController.do";
	getTabDataUrl ='<c:url value="'+getTabDataUrl+'"/>?method=selectGridCalculationModelInfoList&version='+'<%=request.getParameter("version").toString() %>';

	var loadGridModelTypeDictListUrl = basePath+"/inquest/tabYcGridModelTypeController.do";
	loadGridModelTypeDictListUrl ='<c:url value="'+loadGridModelTypeDictListUrl+'"/>?method=loadGridModelTypeDictList&version=<%=request.getParameter("version").toString() %>';


</script>
<script type="text/javascript" src="gridModelCacl.js"></script>
</html>