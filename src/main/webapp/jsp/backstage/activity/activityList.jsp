<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../common.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>活动信息列表页面</title>
  </head>
  <script type="text/javascript" src="<%=request.getContextPath()%>/jsp/backstage/activity/activityList.js"></script>
  <body id="body">
  <!-- 信息查询 -->
<div class="query-content panel easyui-accordion accordion " data-options="selected:false" style="width:100%"> 
 <div title="信息查询" > 
    <form id="searchform" method="POST" class="query-form" >
	<ul class="">
			<li class="li-input"><label for="" class="input-label">活动名称：</label>
				<input class="myinput" id="activityName" name="activityName"/>
			</li>
			<li class="li-input"><label for="" class="input-label">活动内容：</label>
				<input class="myinput" id="activityContent" name="activityContent"/>
			</li>
			<li class="li-input"><label for="" class="input-label">活动创建人：</label>
				<input id="createPerson" name="createPerson" />
			</li>
			<li class="li-input"><label for="" class="input-label">创建时间：</label>
				<input id="createBeginDate" name="createBeginDate" value=""></input>
			</li>
			<li class="li-input"><label for="" class="input-label">至</label>
				<input id="createEndDate" name="createEndDate" />
			
			
		    
			<li class="li-input"><label for="" class="input-label">是否审核：</label>
				<input id="audit" name="audit" value=""/>
			</li>
			<li class="li-input"><label for="" class="input-label">审核日期：</label>
			<input id="auditDateBegin" name="auditDateBegin" />
			</li>
			<li class="li-input"><label for="" class="input-label">至：</label>
				<input id="auditDateEnd" name="auditDateEnd" />
			</li>
			<li class="li-input"><label for="" class="input-label">活动开始时间：</label>
				<input id="activityBeginDate1" name="activityBeginDate1"/> 
			</li>
		     <li class="li-input"><label for="" class="input-label">至：</label>
				<input id="activityBeginDate2" name="activityBeginDate2"/>
			</li>
			
			
			<li class="li-input"><label for="" class="input-label">是否发布：</label>
				<input id="releaseStatus" name="releaseStatus"/>
			</li>
			<li class="li-input"><label for="" class="input-label">发布时间：</label>
			<input id="releaseDateBegin" name="releaseDateBegin" />
			</li>
			<li class="li-input"><label for="" class="input-label">至：</label>
				<input id="releaseDateEnd" name="releaseDateEnd" />
			</li>
			<li class="li-input"><label for="" class="input-label">活动结束时间：</label>
			<input id="activityEndDate1" name="activityEndDate1" />
			</li>
			<li class="li-input"><label for="" class="input-label">至：</label>
				<input id="activityEndDate2" name="activityEndDate2" />
			</li>
			
			<!--  <li class="li-input"><label for="" class="input-label">到期日期：</label>
			<input id="publishExpireDateBegin" name="publishExpireDateBegin" ></input>
			</li>
			<li class="li-input"><label for="" class="input-label">至：</label>
				<input id="publishExpireDateEnd" name="publishExpireDateEnd" />
			</li>-->
	</ul>
	</form>
	<div class="query-oper">
		<a href="#" class="easyui-linkbutton query-btn" onclick="commonObj.query('activityList','searchform')" id="submit_search" plain="true" iconCls="icon-search">查询</a>
	</div> 
 </div>
 </div>
 <!--信息查询结束  -->
<!--data grid  -->
 <table id="activityList" style="width:100%"></table>
  <!--工具栏  -->
<div id="toolbarId">
	<g:auth operateNo="<%=OperateContantsUtil.ACTIVITY_ADD%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="add">新增</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.ACTIVITY_EDIT%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="edit">修改</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.ACTIVITY_DEL%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="remove">删除</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.ACTIVITY_PREVIEW%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-view" onclick="javascript:event.preventDefault();" plain="true" id="priview">查看</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.ACTIVITY_AUDIT%>">
			<a href="#" id="auditNews" class="easyui-linkbutton" onclick="javascript:event.preventDefault();"  plain="true" iconCls="icon-audit">审核</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.ACTIVITY_RELEASE%>">
			<a href="#" id="releaseNews" class="easyui-linkbutton" onclick="javascript:event.preventDefault();"  plain="true" iconCls="icon-release">发布</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.ACTIVITY_UNDO%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-undo" onclick="javascript:event.preventDefault();" plain="true" id="undo" >撤销</a>
	</g:auth>
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
var infoDo = basePath+"/website/backstage/TabActivityManageController.do";
var getInfoDataUrl ='<c:url value="'+infoDo+'"/>?method=queryActivityList';
var editInfoUrl ='<c:url value="'+infoDo+'"/>?method=activityEdit';
var removeInfo = '<c:url value="'+infoDo+'"/>?method=deleteByUuids';
var auditInfo = '<c:url value="'+infoDo+'"/>?method=executeAudit';
var releaseInfo = '<c:url value="'+infoDo+'"/>?method=executeRelease';
var executeUndo = '<c:url value="'+infoDo+'"/>?method=executeUndo';
//----------------------------查询框初始化开始
$('#activityName').textbox({
});
$('#activityContent').textbox({
});
$('#createPerson').textbox({
});

$('#createBeginDate').datetimebox({
	editable:false
});
$('#createEndDate').datetimebox({
	editable:false
});
$('#activityBeginDate1').datetimebox({
	editable:false
});
$('#activityBeginDate2').datetimebox({
	editable:false
});
$('#activityEndDate1').datetimebox({
	editable:false
});
$('#activityEndDate2').datetimebox({
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
commonObj.initDictCombobox("audit","IF","",false,true);
commonObj.initDictCombobox("releaseStatus","IF","",false,true);


//----------------------------查询框初始化结束
//表单提交成功后的回调方法
function successCallback(data){
	$.messager.progress("close");
	$("#activityList").datagrid('reload');
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
