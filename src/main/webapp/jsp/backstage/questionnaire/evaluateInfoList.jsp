<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../common.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>消费信息列表</title>
</head>
<body>
<div class="query-content panel easyui-accordion accordion " data-options="selected:false" style="width:100%"> 
 <div title="信息查询" > 
    <form id="searchform" method="POST" class="query-form" >
	<ul class="">
			<li class="li-input"><label for="" class="input-label">客户姓名：</label>
				<input class="myinput" id="evaluateName" name="evaluateName"></input>
			</li>
			<li class="li-input"><label for="" class="input-label">问卷标题：</label>
				<input class="myinput" id="questionnaireName" name="questionnaireName"></input>
			</li>
			
		    <!-- <li class="li-input"><label for="" class="input-label">消费类型：</label>
				<input id="evaluateNoticeType" name="evaluateNoticeType"/>
			</li> -->
			
			<li class="li-input"><label for="" class="input-label">消费时间：</label>
			<input id="consumptionDateBegin" name="consumptionDateBegin" ></input>

			</li> 
			<li class="li-input"><label for="" class="input-label">至：</label>
					<input id="consumptionDateEnd" name="consumptionDateEnd" />
			</li>
	</ul>
	</form>
	<div class="query-oper">
		<a href="#" class="easyui-linkbutton query-btn" onclick="commonObj.query('evaluateTableId','searchform')" id="submit_search" plain="true" iconCls="icon-search">查询</a>
	</div> 
 </div>
 </div>
 <!--信息查询结束  -->
<!--data grid  -->
 <table id="evaluateTableId" style="width:100%"></table>
  <!--工具栏  -->
<div id="toolbarId">
	<g:auth operateNo="<%=OperateContantsUtil.SJHC_ADD_EVALUATE%>">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="add" onclick="openAddDialog();">新增</a>
	</g:auth>

	<g:auth operateNo="<%=OperateContantsUtil.SJHC_IMPORT_EXCEL%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" id="remove" onclick="openUploadDialog();">导入Excel</a>
	</g:auth>
</div>

	<div id="addEvaluateInfoDlg"></div>
	
	<!-- excel导入框 -->
	<div id="uploadExcelDlg" style="display: none;" align="center">
		<form id="uploadDivForm" enctype="multipart/form-data">
			<table class="table" style="margin-left:0; margin-right:0; border-collapse:separate;border-spacing:10px;" >
				<tr><td>选择类型：</td>
					<td><select id="noticeType" name="noticeType" class="select">
							<option value=1>消费金额</option>
							<option value=2>消费项目</option>
							<option value=3>充值金额</option>
						</select>
			    	</td>
			    </tr>
			    <tr>
			    	<td>选择问卷：</td>
			    	<td><select id="questionnaireUuid" name="questionnaireUuid">
				    		<option value="3543657fdgf43a221sads31">满意度调查</option>
				    	</select>
			    	</td>
			    </tr>
			    <tr><td>导入文件：</td> 
			    	<td>
				    	<input id="file" name="file" type="file" class="inputTd" title="文件格式：xls"/>						
					    <a  id="fileUri"></a>
			    	</td>
			    </tr>
			    <tr>
			    <td colspan="2" align="center">
				    <input type="button" onclick="uploadExcel()"  class="easyui-linkbutton" value="导   入" style="width:60px;height:35px;">
				</td></tr>
			</table>
		</form>
	</div>
	         
</body>

<script type="text/javascript">
var infoDo = basePath+"/website/backstage/EvauateInfoController.do";
var getInfoDataUrl = '<c:url value="'+infoDo+'"/>?method=evaluateInfoList';
var uploadExcelUrl = '<c:url value="'+infoDo+'"/>?method=loadExcelEvaluateInfo';
var toAddEvaluateInfoUrl = '<c:url value="'+infoDo+'"/>?method=toAddEvaluateInfo';


$(document).ready(function(){ 
	//datagrid 初始化 
	var evaluateOption = {
		tabId:"evaluateTableId",
		toolbar:"toolbarId",
		url:getInfoDataUrl,
		columns:[[   
		          {field:'evaluate_info_uuid',title:'消费信息主键标识',checkbox:true},
		          {field:'evaluate_name',title:'客户姓名',resizable:true,align:'center',sortable:true},    
		          {field:'evaluate_phone',title:'客户电话',resizable:true,align:'center',sortable:true}, 
		          {field:'evaluate_nick_name',title:'客户昵称',align:'center',sortable:true}, 
		          {field:'consumption_Date',title:'消费时间',align:'center',sortable:true}, 
		          {field:'evaluate_notice_type',title:'消费类型',align:'center',sortable:true,resizable:true,formatter:function(value, row, index){
		        	  if(value=='1'){return "金额消费";}
		        	  if(value=='2'){return "项目消费";}
		        	  if(value=='3'){return "充值";}
		          }},
		          {field:'consumption_amount',title:'消费金额',align:'center',sortable:true}, 
		          {field:'surplus_amount',title:'剩余金额',resizable:true,align:'center',sortable:true}, 
		          {field:'surplus_score',title:'剩余积分',align:'center',sortable:true}, 
		          {field:'surplus_number',title:'剩余次数',align:'center',sortable:true}, 
		          {field:'recharge_amount',title:'充值金额',resizable:true,align:'center',sortable:true}, 
		          {field:'consumption_item',title:'消费项目',align:'center',sortable:true,resizable:true},
		          {field:'questionnaire_name',title:'问卷名称',align:'center',sortable:true}
		         ] 
		      ]
	};
	//初始化优秀创新列表
	commonObj.initPaginationGrid(evaluateOption);

});

	var addDialog;
	//打开消费信息录入界面
	function openAddDialog(){
		addDialog = $("#addEvaluateInfoDlg").dialog({
			modal: true,
			closed: true,
		    width: 400,
		    height: 330,
		    resizable:true,
		    cache: false,
		    buttons:[]
		});
		addDialog.panel({title:"新增"});
		addDialog.panel({iconCls:'icon-save'});
		addDialog.panel({href:toAddEvaluateInfoUrl});
		addDialog.window("open");
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
	
	//上传Excel
	function uploadExcel(){
		
		var evaluateNoticeType = $("#evaluateNoticeType option:selected").val();
		var questionnaireUuid = $("#questionnaireUuid option:selected").val();
		if(evaluateNoticeType==null || evaluateNoticeType==""){
			commonObj.alert("请选择类型!","warning");
			return;
		}
		if(questionnaireUuid==null || questionnaireUuid==""){
			commonObj.alert("请选择问卷!","warning");
			return;
		}
//		var fileUrl=$("#file")[0].files[0];
		var fileUrl = document.getElementById("file");
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
//		 		data : form,
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
	
	//表单提交成功后的回调方法
	function successCallback(data){
		$.messager.progress("close");
		$("#evaluateTableId").datagrid('reload');
		commonObj.showResponse(data);
	}
</script>
</html>