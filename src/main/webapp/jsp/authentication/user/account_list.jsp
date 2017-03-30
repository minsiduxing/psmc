<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="../../../common.jsp"%>

<title>账号列表</title>
<script type="text/javascript" src="account_list.js"></script>
</head>
<body id="body">
<table id="accountTableId"></table>
<div id="toolbarId">
	<g:auth operateNo="<%=OperateContantsUtil.ACCOUNT_ADD%>">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="add">新增</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.ACCOUNT_UPDATE%>">
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="edit">修改</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.ACCOUNT_DEL%>">
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="remove">删除</a>
	</g:auth>
</div>
<div id="editdialogDiv"></div>
</body>
</html>