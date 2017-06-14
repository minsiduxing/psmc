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
<div class="query-content panel easyui-accordion accordion " data-options="selected:false" style="width:100%"> 
 <div title="信息查询" > 
    <form id="" method="POST" class="query-form" >
	<ul class="">
			<li class="li-input"><label for="" class="input-label">账号名称：</label>
				<input class="myinput" id="" name=""></input>
			</li>
			<li class="li-input"><label for="" class="input-label">账号密码：</label>
				<input class="myinput" id="" name=""></input>
			</li>
			<li class="li-input"><label for="" class="input-label">是否锁定：</label>
				<input id="" name="isLocked"></input></li>
			<li class="li-input"><label for="" class="input-label">姓名：</label>
				<input class="myinput" id="" name=""></input></li>
			<li class="li-input"><label for="" class="input-label">性别：</label>
				<input id="" name=""></input></li>
			<li class="li-input"><label for="" class="input-label">年龄：</label>
				<input class="myinput" id="" name=""></input></li>
			<li class="li-input"><label for="" class="">手机号：</label>
				<input class="myinput" id="" name=""></input></li>
			<li class="li-input"><label for="" class="inpt-label">Email：</label>
				<input class="myinput" id="" name=""></input></li>
	
			<li class="li-input"><label for="" class="input-label">所属地：</label>
				<input class="myinput" id="" name="cityName"></input> <input
				type="hidden" id="cityId" name="cityId" value="${person.CITYID}"></input>
			</li>
			<li class="li-input"><label for="" class="input-label">所属角色：</label>
				<input id="" name="roleUuid"></input></li>
	</ul>
	</form>
	<div class="query-oper">
		<a href="#" class="easyui-linkbutton query-btn" plain="true" iconCls="icon-search">查询</a>
		<a href="#" class="easyui-linkbutton query-btn" plain="true" iconCls="icon-print">导出</a>
	</div> 
 </div>
 </div>
<table id="accountTableId" style="width:100%"></table>
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
<script type="text/javascript">
var basePath = $("#basePath").val();
var saveAccountUrl = basePath+"/authentication/accountController.do";
saveAccountUrl ='<c:url value="'+saveAccountUrl+'"/>?method=edit';

var getTabDataUrl = basePath+"/authentication/accountController.do";
getTabDataUrl ='<c:url value="'+getTabDataUrl+'"/>?method=accountsList';

var addAccountUrl = basePath+"/authentication/accountController.do";
addAccountUrl ='<c:url value="'+addAccountUrl+'"/>?method=initEdit&oper=save';

var editAccountUrl = basePath+"/authentication/accountController.do";
editAccountUrl ='<c:url value="'+editAccountUrl+'"/>?method=initEdit&oper=edit';

var removeAccountUrl = basePath+"/authentication/accountController.do";
removeAccountUrl ='<c:url value="'+removeAccountUrl+'"/>?method=deletes';

</script>
</html>