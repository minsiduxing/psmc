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
<g:auth operateNo="<%=OperateContantsUtil.ROLE_QUERY%>">
<div class="query-content panel easyui-accordion accordion " data-options="selected:false" style="width:100%"> 
	<div title="角色查询" >
	    <form id="searchform" method="POST" class="query-form" >
			<ul class="searchform">
				<li class="li-input"><label for="" class="input-label">角色编码：</label>
					<input class="myinput" id="queryRoleNo" name="roleNo"></input>
				</li>
				<li class="li-input"><label for="" class="input-label">角色名称：</label>
					<input class="myinput" id="queryRoleName" name="roleName"></input>
				</li>
			</ul>
		</form>
		<div class="query-oper">
			<a href="#" class="easyui-linkbutton query-btn" onclick="commonObj.query('roleTableId','searchform')" id="submit_search" plain="true" iconCls="icon-search">查询</a>
		</div> 
	</div>
</div>
</g:auth>
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
	<g:auth operateNo="<%=OperateContantsUtil.ROLE_EXPORT%>">
		<a href="" id="exportBtn" class="easyui-linkbutton query-btn"   plain="true" iconCls="icon-print">导出</a>
	</g:auth>
</div>

<div id="editdialogDiv" style="overflow:hidden;"></div>

<div id="resourceSetdialogDiv" style="overflow:hidden;"></div>

<div id="privilegeSetdialogDiv" style="overflow:hidden;"></div>


</body>
<script type="text/javascript">
var basePath = $("#basePath").val();
var saveRoleUrl = basePath + "/authentication/roleController.do";
saveRoleUrl ='<c:url value="'+saveRoleUrl+'"/>?method=edit';

var getRoleTabDataUrl = basePath+"/authentication/roleController.do";
getRoleTabDataUrl ='<c:url value="'+getRoleTabDataUrl+'"/>?method=rolesList';

var addRoleUrl = basePath + "/authentication/roleController.do";
addRoleUrl ='<c:url value="'+addRoleUrl+'"/>?method=initEdit&oper=save';

var editRoleUrl = basePath + "/authentication/roleController.do";
editRoleUrl ='<c:url value="'+editRoleUrl+'"/>?method=initEdit&oper=edit';

var removeRoleUrl = basePath+"/authentication/roleController.do";
removeRoleUrl ='<c:url value="'+removeRoleUrl+'"/>?method=deletes';

var roleResourceSetUrl =  basePath + "/jsp/authentication/resource/resourceBelongRoleTree.jsp";
roleResourceSetUrl ='<c:url value="'+roleResourceSetUrl+'"/>';

var roleResourceConfigUrl = basePath + "/authentication/tabResource.do";
roleResourceConfigUrl ='<c:url value="'+roleResourceConfigUrl+'"/>?method=editResourceConfig';

var privilegeSetUrl = basePath + "/jsp/authentication/resource/resourcePrivilegConfig.jsp";
privilegeSetUrl ='<c:url value="'+privilegeSetUrl+'"/>';

var exportRoleUrl =  basePath+"/authentication/roleController.do";
exportRoleUrl ='<c:url value="'+exportRoleUrl+'"/>?method=exportRole';
//导出路径
$('#exportBtn').attr('href',exportRoleUrl);

$('#queryRoleNo').textbox({
	type : "text"
});

$('#queryRoleName').textbox({
	type : "text"
});

</script>


</html>