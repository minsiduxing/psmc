<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../../common.jsp"%>

<title>网站用户列表</title>
<script type="text/javascript" src="user_list.js"></script>
<script type="text/javascript" src="../../../js/md5.js"></script>
</head>
<body id="body">
<%-- <g:auth operateNo="<%=OperateContantsUtil.ACCOUNT_QUERY%>"> --%>
<div class="query-content panel easyui-accordion accordion " data-options="selected:false" style="width:100%"> 
 <div title="信息查询" > 
    <form id="searchform" method="POST" class="query-form" >
	<ul class="searchform">
			<li class="li-input"><label for="" class="input-label">用户账号：</label>
				<input class="myinput" id="queryUserId" name="userId"></input>
			</li>
			<li class="li-input"><label for="" class="input-label">用户姓名：</label>
				<input class="myinput" id="queryUserName" name="userName"></input>
			</li>
	</ul>
	</form>
	<div class="query-oper">
		<a href="#" class="easyui-linkbutton" onclick="commonObj.query('webUserTableId','searchform')" id="submit_search" plain="true" iconCls="icon-search">查询</a>
	</div> 
 </div>
 </div>
 <%-- </g:auth> --%>
<table id="webUserTableId" style="width:100%"></table>
<div id="toolbarId">
	<%-- <g:auth operateNo="<%=OperateContantsUtil.ACCOUNT_ADD%>"> --%>
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="add">新增</a>
	<%-- </g:auth> --%>
	<%-- <g:auth operateNo="<%=OperateContantsUtil.ACCOUNT_UPDATE%>"> --%>
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="edit">修改</a>
	<%-- </g:auth> --%>
	<%-- <g:auth operateNo="<%=OperateContantsUtil.ACCOUNT_DEL%>"> --%>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="remove">删除</a>
	<%-- </g:auth> --%>
	<%-- <g:auth operateNo="<%=OperateContantsUtil.ACCOUNT_EXPORT%>"> --%>
		<a href="" id="exportBtn" class="easyui-linkbutton"   plain="true" iconCls="icon-excel">导出</a>
	<%-- </g:auth> --%>
</div>
<div id="editdialogDiv"></div>
</body>
<script type="text/javascript">
var basePath = $("#basePath").val();

var getTabDataUrl = basePath+"/website/backstage/webUserController.do";
getTabDataUrl ='<c:url value="'+getTabDataUrl+'"/>?method=webUserList';

var addUserUrl = basePath+"/website/backstage/webUserController.do";
addUserUrl ='<c:url value="'+addUserUrl+'"/>?method=initEdit&oper=save';

var editUserUrl = basePath+"/website/backstage/webUserController.do";
editUserUrl ='<c:url value="'+editUserUrl+'"/>?method=initEdit&oper=edit';

var saveUserUrl = basePath+"/website/backstage/webUserController.do";
saveUserUrl ='<c:url value="'+saveUserUrl+'"/>?method=edit';
</script>
</html>