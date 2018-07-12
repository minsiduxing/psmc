<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../common.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>信息发布列表页面</title>
  </head>
  <script type="text/javascript" src="<%=request.getContextPath()%>/jsp/backstage/infoRelease/infoReleaseList.js"></script>
  <body id="body">
  <!-- 信息查询 -->
<div class="query-content panel easyui-accordion accordion " data-options="selected:false" style="width:100%"> 
 <div title="信息查询" > 
    <form id="searchform" method="POST" class="query-form" >
	<ul class="">
			<li class="li-input"><label for="" class="input-label">标题：</label>
				<input class="myinput" id="newsTitle" name="newsTitle"></input>
			</li>
			<li class="li-input"><label for="" class="input-label">作者：</label>
				<input id="newAutor" name="newAutor" value=""></input>
			</li>
			 <li class="li-input"><label for="" class="input-label">信息分类：</label>
				<input id="towLevelClassify" name="towLevelClassify"> </input>
			</li>
			<li class="li-input"><label for="" class="input-label">信息日期：</label>
				<input id="newsDateBegin" name="newsDateBegin" value=""></input>
			</li>
			
			<li class="li-input"><label for="" class="input-label">至</label>
			<input id="newsDateEnd" name="newsDateEnd" ></input>
			</li>
		
		<!-- 	<li class="li-input"><label for="" class="input-label">创建人：</label>
				<input id="createAccName" name="createAccName" ></input>
			</li> -->
			<li class="li-input"><label for="" class="input-label">发布人：</label>
				<input id="releaseAccName" name="releaseAccName" ></input>
			</li>
			<li class="li-input"><label for="" class="input-label">审核人：</label>
				<input id="auditAccName" name="auditAccName" ></input>
			</li>
			<li class="li-input"><label for="" class="input-label">审核是否通过：</label>
				<input id="audit" name="audit" value=""></input>
			</li>
			<li class="li-input"><label for="" class="input-label">审核日期：</label>
			<input id="auditDateBegin" name="auditDateBegin" ></input>
			</li>
			<li class="li-input"><label for="" class="input-label">至：</label>
				<input id="auditDateEnd" name="auditDateEnd" />
			</li>
		     <li class="li-input"><label for="" class="input-label">发布是否通过：</label>
				<input id="releaseStatus" name="releaseStatus"/>
			</li>
			<li class="li-input"><label for="" class="input-label">发布日期：</label>
			<input id="releaseDateBegin" name="releaseDateBegin" ></input>
			</li>
			<li class="li-input"><label for="" class="input-label">至：</label>
				<input id="releaseDateEnd" name="releaseDateEnd" />
			</li>
			
			<li class="li-input"><label for="" class="input-label">到期日期：</label>
			<input id="publishExpireDateBegin" name="publishExpireDateBegin" ></input>
			</li>
			<li class="li-input"><label for="" class="input-label">至：</label>
				<input id="publishExpireDateEnd" name="publishExpireDateEnd" />
			</li>
		<!-- 	<li class="li-input"><label for="" class="input-label">创建日期：</label>
			<input id="createDateBegin" name="createDateBegin" ></input>

			</li> -->
			<!-- <li class="li-input"><label for="" class="input-label">至：</label>
					<input id="createDateEnd" name="createDateEnd" />
			</li> -->
			
	</ul>
		<input type="hidden" id="oneLevelClassify" name="oneLevelClassify" value="${param.oneLevelClassify}"/>
	</form>
	<div class="query-oper">
		<a href="#" class="easyui-linkbutton query-btn" onclick="commonObj.query('infoReleaseId','searchform')" id="submit_search" plain="true" iconCls="icon-search">查询</a>
	</div> 
 </div>
 </div>
 <!--信息查询结束  -->
<!--data grid  -->
 <table id="infoReleaseId" style="width:100%"></table>
  <!--工具栏  -->
<div id="toolbarId">
<c:if test="${param.oneLevelClassify=='11'}">
	<g:auth operateNo="<%=OperateContantsUtil.WORK_MANAGER_ADD%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="add">新增</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.WORK_MANAGER_EDIT%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="edit">修改</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.WORK_MANAGER_DEL%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="remove">删除</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.WORK_MANAGER_PREVIEW%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-view" onclick="javascript:event.preventDefault();" plain="true" id="priview">查看</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.WORK_MANAGER_AUDIT%>">
			<a href="#" id="auditNews" class="easyui-linkbutton" onclick="javascript:event.preventDefault();"  plain="true" iconCls="icon-audit">审核</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.WORK_MANAGER_RELEASE%>">
			<a href="#" id="releaseNews" class="easyui-linkbutton" onclick="javascript:event.preventDefault();"  plain="true" iconCls="icon-release">发布</a>
	</g:auth>
</c:if>
<c:if test="${param.oneLevelClassify=='12'}">
	<g:auth operateNo="<%=OperateContantsUtil.LEGAL_PROVISIONS_ADD%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="add">新增</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.LEGAL_PROVISIONS_EDIT%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="edit">修改</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.LEGAL_PROVISIONS_DEL%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="remove">删除</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.LEGAL_PROVISIONS_PREVIEW%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-view" onclick="javascript:event.preventDefault();" plain="true" id="priview">查看</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.LEGAL_PROVISIONS_AUDIT%>">
			<a href="#" id="auditNews" class="easyui-linkbutton" onclick="javascript:event.preventDefault();"  plain="true" iconCls="icon-audit">审核</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.LEGAL_PROVISIONS_RELEASE%>">
			<a href="#" id="releaseNews" class="easyui-linkbutton" onclick="javascript:event.preventDefault();"  plain="true" iconCls="icon-release">发布</a>
	</g:auth>
</c:if>
<c:if test="${param.oneLevelClassify=='13'}">
	<g:auth operateNo="<%=OperateContantsUtil.WORK_RELEASE_ADD%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="add">新增</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.WORK_RELEASE_EDIT%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="edit">修改</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.WORK_RELEASE_DEL%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="remove">删除</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.WORK_RELEASE_PREVIEW%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-view" onclick="javascript:event.preventDefault();" plain="true" id="priview">查看</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.WORK_RELEASE_AUDIT%>">
			<a href="#" id="auditNews" class="easyui-linkbutton" onclick="javascript:event.preventDefault();"  plain="true" iconCls="icon-audit">审核</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.WORK_RELEASE_RELEASE%>">
			<a href="#" id="releaseNews" class="easyui-linkbutton" onclick="javascript:event.preventDefault();"  plain="true" iconCls="icon-release">发布</a>
	</g:auth>
</c:if>
<c:if test="${param.oneLevelClassify=='14'}">
	<g:auth operateNo="<%=OperateContantsUtil.EARLY_KNOW_ADD%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="add">新增</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.EARLY_KNOW_EDIT%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="edit">修改</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.EARLY_KNOW_DEL%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="remove">删除</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.EARLY_KNOW_PREVIEW%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-view" onclick="javascript:event.preventDefault();" plain="true" id="priview">查看</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.EARLY_KNOW_AUDIT%>">
			<a href="#" id="auditNews" class="easyui-linkbutton" onclick="javascript:event.preventDefault();"  plain="true" iconCls="icon-audit">审核</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.EARLY_KNOW_RELEASE%>">
			<a href="#" id="releaseNews" class="easyui-linkbutton" onclick="javascript:event.preventDefault();"  plain="true" iconCls="icon-release">发布</a>
	</g:auth>
</c:if>
</div>

<div id="dlg" class="easyui-dialog" title="信息到期日期" style="width:200px;height:120px;padding:10px"
			data-options="
				iconCls: 'icon-save',buttons:'#dlg-buttons'
			" closed="true" >
	         <input class="easyui-datetimebox" id="publishExpireDate" name="publishExpireDate"
                        data-options="required:true,showSeconds:true" style="width:150px">
	</div>
	<div id="dlg-buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" onclick="publishNews();">确定</a>
	</div>
  </body>
</html>

<script type="text/javascript">
var basePath = $("#basePath").val();
var infoDo = basePath+"/website/backstage/InfoReleaseController.do";
var getInfoDataUrl ='<c:url value="'+infoDo+'"/>?method=getInfoReleaseList&oneLevelClassify='+$("#oneLevelClassify").val();
var editInfoUrl ='<c:url value="'+infoDo+'"/>?method=infoEdit';
var removeInfo = '<c:url value="'+infoDo+'"/>?method=infoDelete';
var auditInfo = '<c:url value="'+infoDo+'"/>?method=executeAuditInfo';
var releaseInfo = '<c:url value="'+infoDo+'"/>?method=executeReleaseInfo';
var priviewInfo = '<c:url value="'+infoDo+'"/>?method=getInfoContent';
//----------------------------查询框初始化开始
$('#newsTitle').textbox({
	type : "text"
});
/* $('#newSubTitle').textbox({
	type : "text"
}); */
/* $('#newsAbstarct').textbox({
	multiline:true,
	type : "text"
}); */
$('#newsDateBegin').datetimebox({
	editable:false
});
$('#newsDateEnd').datetimebox({
	editable:false
});
$('#createDateBegin').datetimebox({
	editable:false
});
$('#createDateEnd').datetimebox({
	editable:false
});
$('#modifyDateBegin').datetimebox({
	editable:false
});
$('#modifyDateEnd').datetimebox({
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
$('#publishExpireDateBegin').datetimebox({
	editable:false
});
$('#publishExpireDateEnd').datetimebox({
	editable:false
});
$('#newAutor').textbox({
	type : "text"
});
$('#createAccName').textbox({
	type : "text",
});
$('#releaseAccName').textbox({
	type : "text"
});
$('#auditAccName').textbox({
	type : "text"
});
$('#modifyAccName').textbox({
	type : "text"
});
commonObj.initDictCombobox("audit","IF","",false,true);
commonObj.initDictCombobox("releaseStatus","IF","<c:out value="${account.IS_LOCKED}"/>",false,true);
commonObj.initDictCombobox("towLevelClassify","NEWS_TYPE","<c:out value="${account.IS_LOCKED}"/>",false,true);

//----------------------------查询框初始化结束
//表单提交成功后的回调方法
function successCallback(data){
	$.messager.progress("close");
	$("#infoReleaseId").datagrid('reload');
	commonObj.showResponse(data);
}
var uuids="";
function publishNews(){
	var _date = $("#publishExpireDate").datebox('getValue');;
	if(_date!=''){
		$('#dlg').dialog('close');
		var _url = releaseInfo+"&uuids="+uuids+"&publishExpireDate="+_date;
		$.messager.progress(); 
		$.ajax({
			   type: "POST",
			   url: _url,
			   success: function(data){
				   successCallback(data);
			   },
			   error:function(XMLHttpRequest, textStatus, errorThrown){
				   commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
				   $.messager.progress("close");
			   }
			});
	}
	 $.messager.progress("close");
  }
</script>
