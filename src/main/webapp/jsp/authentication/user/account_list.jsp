<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="../../../common.jsp"%>

<title>账号列表</title>
<script type="text/javascript" src="account_list.js"></script>
<script type="text/javascript" src="../../../js/md5.js"></script>
</head>
<body id="body">
<g:auth operateNo="<%=OperateContantsUtil.ACCOUNT_QUERY%>">
<div class="query-content panel easyui-accordion accordion " data-options="selected:false" style="width:100%"> 
 <div title="信息查询" > 
    <form id="searchform" method="POST" class="query-form" >
	<ul class="searchform">
			<li class="li-input"><label for="" class="input-label">账号名称：</label>
				<input class="myinput" id="queryAccountName" name="accountName"></input>
			</li>
			<li class="li-input"><label for="" class="input-label">用户名：</label>
				<input class="myinput" id="queryPersonName" name="personName"></input>
			</li>
			<li class="li-input"><label for="" class="input-label">是否锁定：</label>
				<input id="queryIsLocked" name="isLocked" value=""></input>
			</li>
			
	</ul>
	</form>
	<div class="query-oper">
		<a href="#" class="easyui-linkbutton query-btn" onclick="commonObj.query('accountTableId','searchform')" id="submit_search" plain="true" iconCls="icon-search">查询</a>
		
	</div> 
 </div>
 </div>
 </g:auth>
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
	<g:auth operateNo="<%=OperateContantsUtil.ACCOUNT_EXPORT%>">
		<a href="#" class="easyui-linkbutton query-btn" plain="true" iconCls="icon-print">导出</a>
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
$('#queryAccountName').textbox({
	type : "text"
});

$('#queryPersonName').textbox({
	type : "text"
});

commonObj.initDictCombobox("queryIsLocked","IF","<c:out value="${account.IS_LOCKED}"/>",false,true);
</script>
</html>