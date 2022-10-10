<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../common.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>消息池列表</title>
</head>
<body>
<div class="query-content panel easyui-accordion accordion " data-options="selected:false" style="width:100%"> 
 <div title="信息查询" > 
    <form id="searchform" method="POST" class="query-form" >
	<ul class="">
			<li class="li-input"><label for="" class="input-label">电话：</label>
				<input class="myinput" id="phone" name="phone"></input>
			</li>
			
	</ul>
	</form>
	<div class="query-oper">
		<a href="#" class="easyui-linkbutton query-btn" onclick="commonObj.query('messageTableId','searchform')" id="submit_search" plain="true" iconCls="icon-search">查询</a>
	</div> 
 </div>
 </div>
 <!--信息查询结束  -->
<!--data grid  -->
 <table id="messageTableId" style="width:100%"></table>
  <!--工具栏  -->
<div id="toolbarId">
	<g:auth operateNo="<%=OperateContantsUtil.SJHC_ADD_EVALUATE%>">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="add" onclick="openAddDialog();">新增</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="oneDel" onclick="oneDel();">一键删除</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="oneSend" onclick="oneSend();">一键发送</a>
	</g:auth>

	<g:auth operateNo="<%=OperateContantsUtil.SJHC_IMPORT_EXCEL%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" id="upload" onclick="openUploadDialog();">导入Excel</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-excel" plain="true" onclick="openDowloadDialog();">下载模板</a>
	</g:auth>
</div>

	<div id="addMessageDlg"></div>
	<div id="subjectResultDlg"></div>
	<!-- excel导入框 -->
	<div id="uploadExcelDlg" style="display: none;" align="center">
		<form id="uploadDivForm" enctype="multipart/form-data" class="addfrom">
			<ul class="addform-subcontent">
				
			    <li class="li-input"><label for="" class="input-label">导入文件：</label>
				    	<input id="file" name="file"  class="easyui-filebox" data-options="buttonText:'选择文件',prompt:'请选择xls文件...'" title="文件格式：xls"/>						
					    <a  id="fileUri"></a>
			    </li>
			    <li class="li-input" align="center">
				    <input type="button" onclick="uploadExcel()"  class="easyui-linkbutton" value="导   入" style="width:60px;height:30px; margin-top: 20px;">
				</li>
			</ul>
		</form>
	</div>
	
	<!-- 模板下载 -->
	<div id="downloadTemplateDlg" style="display: none;" align="center">
			<label class="input-label" style="width:240px; margin-top: 15px; margin-left: 15px"><a href="#" onclick="downloadTemplate(1);">1、消息模板下载</a></label>
			    
	</div>
	       
</body>

<script type="text/javascript">
var infoDo = basePath+"/website/backstage/TabMessagePoolController.do";
var getInfoDataUrl = '<c:url value="'+infoDo+'"/>?method=messagePoolList';
var toAddMessageUrl = '<c:url value="'+infoDo+'"/>?method=toAddMessagePool';
var uploadExcelUrl = '<c:url value="'+infoDo+'"/>?method=loadExcelMessagePool';
var dowloadUrl = '<c:url value="'+infoDo+'"/>?method=downloadExcelTemplate'; 
var delUrl = '<c:url value="'+infoDo+'"/>?method=deleteByMsgUuid'; 
var delAllUrl = '<c:url value="'+infoDo+'"/>?method=deleteAllMsg';
var sendAllUrl = '<c:url value="'+infoDo+'"/>?method=handSendSms';
var updateUrl = '<c:url value="'+infoDo+'"/>?method=updateByPrimaryKey';
$(document).ready(function(){ 
	//datagrid 初始化 
	var messageOption = {
		tabId:"messageTableId",
		toolbar:"toolbarId",
		url:getInfoDataUrl,
		sortName:"add_time",
		sortOrder:"desc",
		remoteSort:true,
		columns:[[   
		          {field:'msg_uuid',title:'主键标识',checkbox:true},
		          {field:'phone',title:'手机号',align:'center',sortable:true,width:$(this).width() * 0.2},
		          {field:'temp_code',title:'短信模板',resizable:true,align:'center',sortable:true,width:$(this).width() * 0.2},
		          {field:'add_time',title:'新增日期',align:'center',sortable:true,width:$(this).width() * 0.2},
		          {field:'caozuo', title:'操作',width:$(this).width() * 0.2,align:'center',formatter:function(value, row, index){
		        	  var str = '<a href="#" onclick="del(&apos;'+ row["msg_uuid"] +'&apos;);">删除</a> | <a href="#" onclick="updateDialog(&apos;'+ row["msg_uuid"] +'&apos;);">修改</a>';
		        	  return str;  
			          }}
		         ] 
		      ]
	};
	//初始化优秀创新列表
	commonObj.initPaginationGrid(messageOption);

});

var addDialog;
//打开消费信息录入界面
function openAddDialog(){
	addDialog = $("#addMessageDlg").dialog({
		modal: true,
		closed: true,
	    width: 400,
	    height: 370,
	    resizable:true,
	    cache: false,
	    buttons:[]
	});
	addDialog.panel({title:"新增"});
	addDialog.panel({iconCls:'icon-save'});
	addDialog.panel({href:toAddMessageUrl});
	addDialog.window("open");
}
function oneDel(){
	//一键清空
	if (!confirm('您确认要一键删除所有数据吗？')) {
		return;
	}
		$.ajax({
			  type: "POST",
			  url: delAllUrl
			}).done(function( data ) {
	 			successCallback(data);
			});
}
function oneSend(){
	//一键发送
	if (!confirm('您确认要将所有数据发出短信吗？')) {
		return;
	}
	$.ajax({
		type: "POST",
		url: sendAllUrl
	}).done(function( data ) {
		successCallback(data);
	});
}



//打开更新信息录入界面
function updateDialog(msgUuid){
	addDialog = $("#addMessageDlg").dialog({
		modal: true,
		closed: true,
	    width: 400,
	    height: 370,
	    resizable:true,
	    cache: false,
	    buttons:[]
	});
	addDialog.panel({title:"更新"});
	addDialog.panel({iconCls:'icon-save'});
	addDialog.panel({href:toAddMessageUrl+"&msgUuid="+msgUuid});
	addDialog.window("open");
}

//表单提交成功后的回调方法
function successCallback(data){
	$.messager.progress("close");
	$("#messageTableId").datagrid('reload');
	commonObj.showResponse(data);
}

var uploadDialog;
//打开导入excel窗口
function openUploadDialog(){
	uploadDialog = $("#uploadExcelDlg").dialog({
		modal: true,
		closed: true,
	    width: 400,
	    height: 220,
	    resizable:true,
	    cache: false,
	    buttons:[]
	});
	uploadDialog.panel({title:"导入Excel"});
	uploadDialog.window("open");
}

//模板下载dialog
var templateDialog;
function openDowloadDialog(){
	templateDialog = $("#downloadTemplateDlg").dialog({
		modal: true,
		closed: true,
	    width: 290,
	    height: 170,
	    resizable:true,
	    cache: false,
	    buttons:[]
	});
	templateDialog.panel({title:"模板下载"});
	templateDialog.window("open");
}

//下载模板
function downloadTemplate(evaluateNoticeType){
	window.location.href = dowloadUrl; 
}

//上传Excel
function uploadExcel(){
	
	var fileUrl = document.getElementById("filebox_file_id_1");
	if(fileUrl ==null || fileUrl=='undefined'  || fileUrl.value == null || fileUrl.value == ""){
		commonObj.alert("请先选择文件!","warning");
		return;
	}
	if(!fileUrl.value.match(/.xls/i) || fileUrl.value.match(/.xlsx/i)){
		commonObj.alert("导入格式不正确,目前系统只支持.xls格式！","warning");
		return;
	}

	$.messager.progress(); 
	$("#uploadDivForm").ajaxSubmit({
	 		url : uploadExcelUrl,
	 		type : "POST",
	 		cache : false,
	 		//dataType:"json", 
//	 		data : form,
	 		resetForm:true,
	 		success : function(data) {
	 			uploadDialog.window("close");
	 			successCallback(data);
			},
			error:function(XMLHttpRequest, textStatus, errorThrown){
				   commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
				   $.messager.progress("close");
		    }
	 });
	$.messager.progress("close"); 
}
function del(msgUuid){
	if (!confirm('您确认要删除吗？')) {
		return;
	}
		$.ajax({
			  type: "POST",
			  url: delUrl,
			  data: { msgUuid: msgUuid }
			}).done(function( data ) {
	 			successCallback(data);
			});
}

</script>
</html>