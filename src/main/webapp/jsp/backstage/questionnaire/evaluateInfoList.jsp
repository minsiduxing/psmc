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
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="add">新增</a>
	</g:auth>

	<g:auth operateNo="<%=OperateContantsUtil.SJHC_IMPORT_EXCEL%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" id="remove" onclick="openUploadDialog();">导入Excel</a>
	</g:auth>
</div>

	<div id="addEvaluateInfoDlg"></div>
	<div id="uploadExcelDlg" style="display: none;" align="center">
		<form id="uploadDivForm" enctype="multipart/form-data">
			<table class="table" style="margin-left: 0; margin-right: 0;">
				<tr><td>
					选择类型：<select id="evaluateNoticeType" name="evaluateNoticeType" class="select">
						<option value=1>消费金额</option>
						<option value=2>消费项目</option>
						<option value=3>充值金额</option>
					</select>
			    </td></tr>
			    <tr>
			    	<td>
			    	选择问卷：<select id="questionnaireUuid" name="questionnaireUuid">
			    		<option value="3543657fdgf43a221sads31">满意度调查</option>
			    	</select>
			    	</td>
			    </tr>
			    <tr><td>
			    	导入文件： <input id="file" name="file" type="file" class="inputTd" title="文件格式：xls"/>						
				    <a  id="fileUri"></a>
			    </td></tr>
			    <tr><td align="center">
				    <a href="javascript:void(0)"  onclick="uploadExcel()" class="easyui-linkbutton" >导  入</a>
				    <!-- <button type="button" onclick="closeFile()" class="inputTd primary_use" style="height:26px !important; line-height:26px !important; padding:0;">返回</button> -->
				</td></tr>
			</table>
		</form>
	</div>
	         
</body>

<script type="text/javascript">
var infoDo = basePath+"/website/backstage/EvauateInfoController.do";
var getInfoDataUrl = '<c:url value="'+infoDo+'"/>?method=evaluateInfoList';
var uploadExcelUrl = '<c:url value="'+infoDo+'"/>?method=loadExcelEvaluateInfo';

$(document).ready(function(){ 
	//datagrid 初始化 
	var evaluateOption = {
		tabId:"evaluateTableId",
		toolbar:"toolbarId",
		url:getInfoDataUrl,
		columns:[[   
		          {field:'evaluateInfoUuid',title:'消费信息主键标识',checkbox:true},
		          {field:'evaluateName',title:'客户姓名',resizable:true,align:'center',sortable:true},    
		          {field:'evaluatePhone',title:'客户电话',resizable:true,align:'center',sortable:true}, 
		          {field:'evaluateNickName',title:'客户昵称',align:'center',sortable:true}, 
		          {field:'consumptionDate',title:'消费时间',align:'center',sortable:true}, 
		          {field:'evaluateNoticeType',title:'消费类型',align:'center',sortable:true,resizable:true,formatter:function(value, row, index){
		        	  if(value=='1'){return "金额消费";}
		        	  if(value=='2'){return "项目消费";}
		        	  if(value=='3'){return "充值";}
		          }},
		          {field:'consumptionAmount',title:'消费金额',align:'center',sortable:true}, 
		          {field:'surplusAmount',title:'剩余金额',resizable:true,align:'center',sortable:true}, 
		          {field:'surplusScore',title:'剩余积分',align:'center',sortable:true}, 
		          {field:'surplusNumber',title:'剩余次数',align:'center',sortable:true}, 
		          {field:'rechargeAmount',title:'充值金额',resizable:true,align:'center',sortable:true}, 
		          {field:'consumptionItem',title:'消费项目',align:'center',sortable:true,resizable:true},
		          {field:'questionnaireName',title:'问卷名称',align:'center',sortable:true}
		         ] 
		      ]
	};
	//初始化优秀创新列表
	commonObj.initPaginationGrid(evaluateOption);
	//新增
	/* $("#add").click(function(){
		var _url = editInfoUrl+"&isEdit="+"add";
		window.location.href=_url;
		event.preventDefault();
	}); */
	
	//编辑
	/* $("#edit").click(function(){
		var rows = $("#innovationList").datagrid('getChecked');
		if (rows.length == 1){
			var rowObj = eval(rows[0]);
			if(rowObj.audit==1){
				commonObj.alert("该信息已经审核通过不能修改!","warning");
				return;
			}
			var uuid = rowObj.innovation_uuid;
			var _url = editInfoUrl+"&uuid="+uuid+"&isEdit="+"edit";
			window.location.href=_url;
		}else{
			commonObj.alert("请选择一条记录!","warning");
		}
		event.preventDefault();
	});
	
	//查看
	$("#priview").click(function(){
		var rows = $("#innovationList").datagrid('getChecked');
		if (rows.length == 1){
			var rowObj = eval(rows[0]);
			var uuid = rowObj.innovation_uuid;
			var _url = editInfoUrl+"&uuid="+uuid+"&isEdit="+"query";
			window.location.href=_url;
		}else{
			commonObj.alert("请选择一条记录!","warning");
			return;
		}
		event.preventDefault();
	});
	
	//删除
$("#remove").click(function(){
		var rows = $("#innovationList").datagrid('getChecked');
		var rlength = rows.length;
		var ids="";
		if (rlength > 0){
			for(var i=0;i<rlength;i++){
				var rowObj = eval(rows[i]);
				var newsid = rowObj.innovation_uuid;
				ids+=newsid;
				if(i<rlength-1)
					ids+=",";
			}
			$.messager.confirm('提示', '该操作不可逆，您确认删除选中信息?', function(r){
				if (r){
					var _url = removeInfo+"&uuids="+ids;
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
			});
			
		}else{
			commonObj.alert("请选择至少一条记录!","warning");
		}
		$.messager.progress("close");
		event.preventDefault();
	}); */


});
	var uploadDialog;
	//打开导入excel窗口
	function openUploadDialog(){
		uploadDialog = $("#uploadExcelDlg").dialog({
			modal: true,
			closed: true,
		    width: 400,
		    height: 200,
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