<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="../../../../common.jsp"%>

<title>系统数据字典列表</title>
<script type="text/javascript" src="dict.js"></script>
</head>
<body id="body">

 
<table id="sologTableId" style="width:100%"></table>
<div id="toolbarId">
</div>
</body>
<script type="text/javascript">
var basePath = $("#basePath").val();

var getTabDataUrl = basePath+"/system/common/dictController.do";
getTabDataUrl ='<c:url value="'+getTabDataUrl+'"/>?method=selectAllDicts';

$('#dict_id').textbox({
	iconAlign:'left'
})
$('#dict_name').textbox({
	iconAlign:'left'
})

</script>
</html>