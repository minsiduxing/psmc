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
		<input type="hidden" id="smsBusniessType" name="smsBusniessType" value="<c:out value="${smsBusniessType}"/>">
	<ul class="">
			<li class="li-input"><label for="" class="input-label">客户姓名：</label>
				<input class="myinput" id="evaluateName1" name="evaluateName1"></input>
			</li>
			<li class="li-input"><label for="" class="input-label">客户电话：</label>
				<input class="myinput" id="evaluatePhone1" name="evaluatePhone1"></input>
			</li>
			
		    <li class="li-input"><label for="" class="input-label">短信类型：</label>
				<input id="evaluateNoticeType1" name="evaluateNoticeType1"/>
			</li>
			
			<li class="li-input"><label for="" class="input-label">消费时间：</label>
			<input id="consumptionDateBegin" name="consumptionDateBegin" ></input>

			</li> 
			<li class="li-input"><label for="" class="input-label">至：</label>
					<input id="consumptionDateEnd" name="consumptionDateEnd" />
			</li>
			 <li class="li-input"><label for="" class="input-label">状态：</label>
				<input id="evaluateStatus" name="evaluateStatus"/>
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
		<c:if test="${smsBusniessType == 13}">
			<a href="#" class="easyui-linkbutton" iconCls="icon-redo" plain="true" id="upload" onclick="openUploadDialog();">导入Excel</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-excel" plain="true" onclick="openDowloadDialog();">下载模板</a>
		</c:if>
	</g:auth>
</div>

	<div id="addEvaluateInfoDlg"></div>
	<div id="subjectResultDlg"></div>
	<!-- excel导入框 -->
	<div id="uploadExcelDlg" style="display: none;" align="center">
		<form id="uploadDivForm" enctype="multipart/form-data" class="addfrom">
			<ul class="addform-subcontent">
				<li class="li-input"><label for="" class="input-label">选择类型：</label>
					
						<input id="noticeType" name="noticeType" />	
			    	
			    </li>
			    <li class="li-input" id="ishow"><label for="" class="input-label">选择问卷：</label>
			    		<input id="questionUuid" name="questionUuid" />
			    </li>
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
			<label class="input-label" style="width:240px; margin-top: 15px; margin-left: 15px"><a href="#" onclick="downloadTemplate(1);">1、金额消费信息模板下载</a></label>
			    
			<label class="input-label" style="width:240px; margin-top: 15px; margin-left: 15px"><a href="#" onclick="downloadTemplate(2);">2、项目消费信息模板下载</a></label>
			    
			<label class="input-label" style="width:240px; margin-top: 15px; margin-left: 15px"><a href="#" onclick="downloadTemplate(3);">3、充值信息模板下载</a></label>
			    
	</div>
	       
</body>

<script type="text/javascript">
var infoDo = basePath+"/website/backstage/EvauateInfoController.do";
var getInfoDataUrl = '<c:url value="'+infoDo+'"/>?method=evaluateInfoList';
var uploadExcelUrl = '<c:url value="'+infoDo+'"/>?method=loadExcelEvaluateInfo';
var toAddEvaluateInfoUrl = '<c:url value="'+infoDo+'"/>?method=toAddEvaluateInfo';
var dowloadUrl = '<c:url value="'+infoDo+'"/>?method=downloadExcelTemplate'; 
var sendMsgUrl = '<c:url value="'+infoDo+'"/>?method=sendMsg';
//查看评价详情
var questionDo = basePath+"/website/backstage/QuestionnaireController.do";
var queryResultDetailsUrl = '<c:url value="'+questionDo+'"/>?method=queryResultDetails';

commonObj.initDictCombobox("evaluateNoticeType1","NOTICE_TYPE",null,false,true,'<c:out value="${smsBusniessType}"/>');
commonObj.initDictCombobox("evaluateStatus","EVALUATE_STATUS",null,true,false);
commonObj.initDictCombobox("noticeType","NOTICE_TYPE",null,true,false);
commonObj.initQuestionnaireCombobox("questionUuid",null,true);

$("#evaluateName1").textbox({});
$("#evaluatePhone1").textbox({});
$("#consumptionDateBegin").datebox({});
$("#consumptionDateEnd").datebox({});

$('#noticeType').combobox({
    onChange: function () {
    	var evaluateNoticeType = $("#noticeType").combobox('getValue');
    	if(evaluateNoticeType == '1' ||evaluateNoticeType == '2'){
    		$("#ishow").show();
    	}else{
    		$("#ishow").hide();
    	}
    }
});

$(document).ready(function(){
	//datagrid 初始化 
	var evaluateOption = {
		tabId:"evaluateTableId",
		toolbar:"toolbarId",
		url:getInfoDataUrl,
		sortName:"input_time",
		sortOrder:"desc",
		remoteSort:true,
		queryParams:{queryParams:{'smsBusniessType':'<c:out value="${smsBusniessType}"/>'}},
		columns:[[   
		          {field:'evaluate_info_uuid',title:'消费信息主键标识',checkbox:true},
		          {field:'questionnaire_uuid',title:'问卷信息id',hidden:true},
		          {field:'evaluate_name',title:'客户姓名',resizable:true,align:'center',sortable:true,width:$(this).width() * 0.1},
		          {field:'evaluate_phone',title:'客户电话',resizable:true,align:'center',width:$(this).width() * 0.1},
		          {field:'evaluate_nick_name',title:'客户昵称',align:'center',width:$(this).width() * 0.1},
		          {field:'consumption_date',title:'消费（充值）日期',align:'center',sortable:true,width:$(this).width() * 0.15},
		          {field:'evaluate_notice_type',title:'短信类型',align:'center',sortable:true,resizable:true,width:$(this).width() * 0.1,formatter:function(value, row, index){
		        	  if(value=='1'){return "金额消费";}
		        	  if(value=='2'){return "项目消费";}
		        	  if(value=='3'){return "充值";}
		        	  if(value=='4'){return "卡余一类";}
		        	  if(value=='5'){return "卡余二类";}
		        	  if(value=='6'){return "卡余三类";}
		        	  if(value=='7'){return "未体验一类";}
		        	  if(value=='8'){return "未体验二类";}
		        	  if(value=='9'){return "专属福利";}
		          }},
			/**
			 * {field:'consumption_amount',title:'消费金额（元）',align:'center',sortable:true},
			 {field:'surplus_amount',title:'剩余金额（元）',resizable:true,align:'center',sortable:true},
			 {field:'surplus_score',title:'剩余积分',align:'center',sortable:true},
			 {field:'surplus_number',title:'剩余次数',align:'center',sortable:true},
			 {field:'recharge_amount',title:'充值金额（元）',resizable:true,align:'center',sortable:true},
			 {field:'consumption_item',title:'消费项目',align:'center'},
			 */
				  {field:'notice_content',title:'短信内容',align:'left',width:$(this).width() * 0.8},
			      {field:'questionnaire_name',title:'问卷名称',align:'center',width:$(this).width() * 0.1},
		          {field:'input_time',title:'录入时间',align:'center',sortable:true,width:$(this).width() * 0.1},
		          {field:'evaluate_status',title:'状态',align:'center',width:$(this).width() * 0.1,formatter:function(value, row, index){
		        	  if(value=='1'){return "待评价";}
		        	  else if(value=='2'){return ' <a href="#" onclick="querySubjectResult(&apos;'+ row["evaluate_info_uuid"] + "&apos;,&apos;" + row["questionnaire_uuid"] +'&apos;);">已评价</a> ';}
		        	  else if(value=='4'){return "发送失败";}
		        	  else{return ""; }
		          }},
		          {field:'evaluate_time',title:'评价时间',align:'center',sortable:true,width:$(this).width() * 0.1},
		          {field:'caozuo', title:'操作',width:$(this).width() * 0.1,align:'center',formatter:function(value, row, index){
		        	 if(row["evaluate_status"] == '4'){return '<a href="#" onclick="sendMsg(&apos;'+ row["evaluate_info_uuid"] +'&apos;);">重新发送</a>';}
		          }}
		         ] 
		      ]
	};
	//初始化优秀创新列表
	console.info(evaluateOption);
	commonObj.initPaginationGrid(evaluateOption);
	// commonObj.query('evaluateTableId','searchform');

});

	var addDialog;
	//打开消费信息录入界面
	function openAddDialog(){
		addDialog = $("#addEvaluateInfoDlg").dialog({
			modal: true,
			closed: true,
		    width: 500,
		    height: 500,
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
		var evaluateNoticeType = $("#noticeType").combobox('getValue');
		var questionnaireUuid = $("#questionUuid").combobox('getValue');
		if(evaluateNoticeType==null || evaluateNoticeType==""){
			commonObj.alert("请选择类型!","warning");
			return;
		}
		//充值不需要选择问卷
		if(evaluateNoticeType != '3'){
			if(questionnaireUuid==null || questionnaireUuid==""){
				commonObj.alert("请选择问卷!","warning");
				return;
			}  
		}
		
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
	
	//查看评价详情
	var subjectResultDialog;
	function querySubjectResult(evaluateInfoUuid,questionnaireUuid){
		subjectResultDialog = $("#subjectResultDlg").dialog({
			modal: true,
			closed: true,
		    width: 500,
		    height: 260,
		    resizable:true,
		    cache: false,
		    buttons:[]
		});
		subjectResultDialog.panel({title:"评价结果"});
		subjectResultDialog.panel({iconCls:'icon-save'});
		subjectResultDialog.panel({href:queryResultDetailsUrl + "&questionnaireUuid="+questionnaireUuid + "&evaluateInfoUuid="+evaluateInfoUuid});
		subjectResultDialog.window("open");
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
		window.location.href = dowloadUrl + "&evaluateNoticeType=" + evaluateNoticeType; 
	}
	
	function sendMsg(evaluateInfoUuid){
		$.messager.progress(); 
		$.ajax({
			   type: "POST",
			   url: sendMsgUrl,
			   data:{"evaluateInfoUuid":evaluateInfoUuid},
			   success: function(data){
				   $.messager.progress("close");
				   successCallback(data);
			   },
			   error:function(XMLHttpRequest, textStatus, errorThrown){
				   commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
				   $.messager.progress("close");
			   }
		});
	}
	
	//表单提交成功后的回调方法
	function successCallback(data){
		$.messager.progress("close");
		$("#evaluateTableId").datagrid('reload');
		commonObj.showResponse(data);
	}
</script>
</html>