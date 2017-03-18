<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../../common.jsp"%>

<title>角色列表</title>
<script type="text/javascript" src="role_list.js"></script>

</head>
<body id="body">
<table id="roleTableId"></table>

<div id="toolbarId">
	<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="add">新增</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="edit">修改</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="remove">删除</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="resourceSet">资源配置</a>
	<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="privilegeSet">权限配置</a>
</div>

<div id="editdialogDiv" style="overflow:hidden;"></div>

<div id="resourceSetdialogDiv" style="overflow:hidden;"></div>

<div id="privilegeSetdialogDiv" style="overflow:hidden;"></div>


</body>
</html>