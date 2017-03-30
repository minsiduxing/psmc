<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>

<%@ include file="../../../common.jsp"%>

<title>角色列表</title>
<script type="text/javascript" src="role_list.js"></script>

</head>
<body id="body">
<table id="roleTableId"></table>

<div id="toolbarId">
	<g:auth operateNo="<%=OperateContantsUtil.ROLE_ADD%>">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="add">新增</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.ROLE_UPDATE%>">
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="edit">修改</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.ROLE_DEL%>">
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="remove">删除</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.ROLE_HAVE_RESOURCE%>">
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="resourceSet">资源配置</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.ROLE_HAVE_OPERATE%>">
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="privilegeSet">业务操作配置</a>
	</g:auth>
</div>

<div id="editdialogDiv" style="overflow:hidden;"></div>

<div id="resourceSetdialogDiv" style="overflow:hidden;"></div>

<div id="privilegeSetdialogDiv" style="overflow:hidden;"></div>


</body>
</html>