<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../common.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>优秀创新信息列表页面</title>
  </head>
  <script type="text/javascript" src="<%=request.getContextPath()%>/jsp/backstage/innovation/innovationList.js"></script>
  <body id="body">
  <!-- 信息查询 -->
<div class="query-content panel easyui-accordion accordion " data-options="selected:false" style="width:100%"> 
 <div title="信息查询" > 
    <form id="searchform" method="POST" class="query-form" >
	<ul class="">
			<li class="li-input"><label for="" class="input-label">所属单位：</label>
				<input class="myinput" id="orgName" name="orgName"/>
			</li>
			<li class="li-input"><label for="" class="input-label">申报负责人：</label>
				<input class="myinput" id="declarePerson" name="declarePerson"/>
			</li>
			<li class="li-input"><label for="" class="input-label">成果名称：</label>
				<input id="achievementName" name="achievementName" />
			</li>
			<li class="li-input"><label for="" class="input-label">创新日期：</label>
				<input id="innovationDateBegin" name="innovationDateBegin" value=""></input>
			</li>
			<li class="li-input"><label for="" class="input-label">至</label>
				<input id="innovationDateEnd" name="innovationDateEnd" />
			
			
		    <li class="li-input"><label for="" class="input-label">第一完成人：</label>
				<input id="firstCompletePerson" name="firstCompletePerson" />
			</li> 
			<li class="li-input"><label for="" class="input-label">所在部门：</label>
				<input id="deptName" name="deptName" value=""/>
			</li>
			<li class="li-input"><label for="" class="input-label">是否审核：</label>
				<input id="audit" name="audit" value=""/>
			</li>
			<li class="li-input"><label for="" class="input-label">审核日期：</label>
			<input id="auditDateBegin" name="auditDateBegin" />
			</li>
			<li class="li-input"><label for="" class="input-label">至：</label>
				<input id="auditDateEnd" name="auditDateEnd" />
			</li>
			
			
			<li class="li-input"><label for="" class="input-label">其他完成人：</label>
				<input id="otherCompletePerson" name="otherCompletePerson"/> 
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
			
			<!--  <li class="li-input"><label for="" class="input-label">到期日期：</label>
			<input id="publishExpireDateBegin" name="publishExpireDateBegin" ></input>
			</li>
			<li class="li-input"><label for="" class="input-label">至：</label>
				<input id="publishExpireDateEnd" name="publishExpireDateEnd" />
			</li>-->
	</ul>
	</form>
	<div class="query-oper">
		<a href="#" class="easyui-linkbutton query-btn" onclick="commonObj.query('innovationList','searchform')" id="submit_search" plain="true" iconCls="icon-search">查询</a>
	</div> 
 </div>
 </div>
 <!--信息查询结束  -->
<!--data grid  -->
 <table id="innovationList" style="width:100%"></table>
  <!--工具栏  -->
<div id="toolbarId">
	<g:auth operateNo="<%=OperateContantsUtil.INFO_ADD%>">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="add">新增</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.INFO_EDIT%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="edit">修改</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.INFO_DEL%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="remove">删除</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.INFO_PREVIEW%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-view" onclick="javascript:event.preventDefault();" plain="true" id="priview">查看</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.INFO_AUDIT%>">
			<a href="#" id="auditNews" class="easyui-linkbutton" onclick="javascript:event.preventDefault();"  plain="true" iconCls="icon-audit">审核</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.INFO_RELEASE%>">
			<a href="#" id="releaseNews" class="easyui-linkbutton" onclick="javascript:event.preventDefault();"  plain="true" iconCls="icon-release">发布</a>
	</g:auth>
</div>

<div id="dlg" class="easyui-dialog" title="新闻到期日期" style="width:200px;height:120px;padding:10px"
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
var infoDo = basePath+"/website/backstage/ExcellentInnovationController.do";
var getInfoDataUrl ='<c:url value="'+infoDo+'"/>?method=excellentInnovationList';
var editInfoUrl ='<c:url value="'+infoDo+'"/>?method=innovationEdit';
var removeInfo = '<c:url value="'+infoDo+'"/>?method=deleteByUuids';
var auditInfo = '<c:url value="'+infoDo+'"/>?method=executeAudit';
var releaseInfo = '<c:url value="'+infoDo+'"/>?method=executeRelease';
//var priviewInfo = '<c:url value="'+infoDo+'"/>?method=getInfoReleaseByUuid';
//----------------------------查询框初始化开始
$('#orgName').textbox({
});
$('#declarePerson').textbox({
});
$('#achievementName').textbox({
});
$('#firstCompletePerson').textbox({
});
$('#deptName').textbox({
});
$('#otherCompletePerson').textbox({
});
$('#innovationDateBegin').datetimebox({
});
$('#innovationDateEnd').datetimebox({
});
$('#auditDateBegin').datetimebox({
});
$('#auditDateEnd').datetimebox({
});
$('#releaseDateBegin').datetimebox({
});
$('#releaseDateEnd').datetimebox({
});
$('#publishExpireDateBegin').datetimebox({
});
$('#publishExpireDateEnd').datetimebox({
});
commonObj.initDictCombobox("audit","IF","",false,true);
commonObj.initDictCombobox("releaseStatus","IF","",false,true);


//----------------------------查询框初始化结束
//表单提交成功后的回调方法
function successCallback(data){
	$.messager.progress("close");
	$("#innovationList").datagrid('reload');
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
