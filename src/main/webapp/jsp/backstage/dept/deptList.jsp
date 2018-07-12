<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../common.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>部门列表页面</title>
  </head>
  <script type="text/javascript" src="<%=request.getContextPath()%>/jsp/backstage/dept/deptList.js"></script>
  <body id="body">
  <!-- 信息查询 -->
<div class="query-content panel easyui-accordion accordion " data-options="selected:false" style="width:100%"> 
 <div title="信息查询" > 
    <form id="searchform" method="POST" class="query-form" >
	<ul class="">
		<c:if test="${param.deptType=='1'}">
			<li class="li-input"><label for="" class="input-label">工作室名称：</label>
				<input class="myinput" id="deptName" name="deptName"/>
			</li>
		</c:if>
		<c:if test="${param.deptType=='2'}">
			<li class="li-input"><label for="" class="input-label">协会名称：</label>
				<input class="myinput" id="deptName" name="deptName"/>
			</li>
		</c:if>
			<li class="li-input"><label for="" class="input-label">创建人：</label>
				<input id="createPerson" name="createPerson" />
			</li>
			<li class="li-input"><label for="" class="input-label">是否审核：</label>
				<input id="audit" name="audit" value=""/>
			</li>
			<li class="li-input"><label for="" class="input-label">创建时间：</label>
				<input id="createBeginDate" name="createBeginDate" value=""></input>
			</li>
			<li class="li-input"><label for="" class="input-label">至</label>
				<input id="createEndDate" name="createEndDate" />
			</li>
			
			
			<li class="li-input"><label for="" class="input-label">审核日期：</label>
			<input id="auditDateBegin" name="auditDateBegin" />
			</li>
			<li class="li-input"><label for="" class="input-label">至：</label>
				<input id="auditDateEnd" name="auditDateEnd" />
			</li>
			<li class="li-input"><label for="" class="input-label">是否发布：</label>
				<input id="releaseStatus" name="releaseStatus"/>
			</li>
			<li class="li-input"><label for="" class="input-label">发布日期：</label>
			<input id="releaseDateBegin" name="releaseDateBegin" />
			</li>
			<li class="li-input"><label for="" class="input-label">至：</label>
				<input id="releaseDateEnd" name="releaseDateEnd" />
			</li>
	</ul>
		<input type="hidden" id="deptType" name="deptType" value="${param.deptType}" />
	</form>
	<div class="query-oper">
		<a href="#" class="easyui-linkbutton query-btn" onclick="commonObj.query('deptList','searchform')" id="submit_search" plain="true" iconCls="icon-search">查询</a>
	</div> 
 </div>
 </div>
 <!--信息查询结束  -->
<!--data grid  -->
 <table id="deptList" style="width:100%"></table>
  <!--工具栏  -->
<div id="toolbarId">
<c:if test="${param.deptType=='1'}">
	<g:auth operateNo="<%=OperateContantsUtil.WORK_ROOM_ADD%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="add">新增</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.WORK_ROOM_EDIT%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="edit">修改</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.WORK_ROOM_DEL%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="remove">删除</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.WORK_ROOM_PREVIEW%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-view" onclick="javascript:event.preventDefault();" plain="true" id="priview">查看</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.WORK_ROOM_AUDIT%>">
			<a href="#" id="auditNews" class="easyui-linkbutton" onclick="javascript:event.preventDefault();"  plain="true" iconCls="icon-audit">审核</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.WORK_ROOM_RELEASE%>">
			<a href="#" id="releaseNews" class="easyui-linkbutton" onclick="javascript:event.preventDefault();"  plain="true" iconCls="icon-release">发布</a>
	</g:auth>
</c:if>
<c:if test="${param.deptType=='2'}">
	<g:auth operateNo="<%=OperateContantsUtil.ASSOCIATION_ADD%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="add">新增</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.ASSOCIATION_EDIT%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="edit">修改</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.ASSOCIATION_DEL%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="remove">删除</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.ASSOCIATION_PREVIEW%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-view" onclick="javascript:event.preventDefault();" plain="true" id="priview">查看</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.ASSOCIATION_AUDIT%>">
			<a href="#" id="auditNews" class="easyui-linkbutton" onclick="javascript:event.preventDefault();"  plain="true" iconCls="icon-audit">审核</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.ASSOCIATION_RELEASE%>">
			<a href="#" id="releaseNews" class="easyui-linkbutton" onclick="javascript:event.preventDefault();"  plain="true" iconCls="icon-release">发布</a>
	</g:auth>
</c:if>
</div>

</body>
</html>

<script type="text/javascript">
var basePath = $("#basePath").val();
var deptDo = basePath+"/website/backstage/TabDeptController.do";
var deptDataListUrl ='<c:url value="'+deptDo+'"/>?method=findDeptList&deptType='+$("#deptType").val();
var toDeptEditUrl ='<c:url value="'+deptDo+'"/>?method=toDeptEdit&deptType='+$("#deptType").val();
var removeDept = '<c:url value="'+deptDo+'"/>?method=deleteDept';
var auditDept = '<c:url value="'+deptDo+'"/>?method=auditDept';
var releaseDept = '<c:url value="'+deptDo+'"/>?method=releaseDept';
//----------------------------查询框初始化开始
$('#deptName').textbox({
});
$('#deptIntroduction').textbox({
});
$('#createPerson').textbox({
});

$('#createBeginDate').datetimebox({
	editable:false
});
$('#createEndDate').datetimebox({
	editable:false
});
$('#auditDateBegin').datetimebox({
	editable:false
});
$('#auditDateEnd').datetimebox({
	editable:false
});
$('#releaseDateBegin').datetimebox({
	editable:false
});
$('#releaseDateEnd').datetimebox({
	editable:false
});
commonObj.initDictCombobox("audit","IF","",false,true);
commonObj.initDictCombobox("releaseStatus","IF","",false,true);


//----------------------------查询框初始化结束

</script>
