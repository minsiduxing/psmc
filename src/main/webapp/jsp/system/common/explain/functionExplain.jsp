<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <style type="text/css">
	.tds{
		text-align:right;
		width:15%
	}
	
  </style>
  </head>
<%@ include file="../../../../../common.jsp"%>
<body id="body">
<form id="explainForm" method="POST" >
	<div>
		<table style="font-size:12px; width:70%; border-collapse:separate; border-spacing:10px; margin-top: 30px;">
			<tr>
				<td class="tds">功能名称：</td>
				<td width="30%">
					<input id="functionCode" name="functionCode" style="width:30%;"/>
				</td>
			</tr>
			<tr></tr>
			<tr>
				<td class="tds">功能简介：</td>
				<td width="30%">
					<textarea style="width:75%; border-radius:4px; border: 1px solid #ccc;" rows="12" cols="" id="expainContent" name="expainContent"></textarea>
				</td>
			</tr>
		</table>
	</div>
		 <input type="hidden" id="explainUuid" name="explainUuid"/>
		 <input type="hidden" id="functionName" name="functionName"/>
		 <div style= "width:75%; margin-top: 20px" class="operButon" align="center">
		   <input id="submitbtn" type="button" class="easyui-linkbutton l-btn l-btn-small easyui-fluid" style="padding: 5px 0px;" onclick="save()" value="保存"/>
		 </div>
		 
	</form>
  </body>
</html>
<script type="text/javascript">
	var basePath = $("#basePath").val();
	var explainDo = basePath+"/system/common/functionExplainController.do";
	var addOrUpdateUrl ='<c:url value="'+explainDo+'"/>?method=addOrUpdate';
	var queryExplainUrl ='<c:url value="'+explainDo+'"/>?method=queryExplain';
	commonObj.initDictCombobox("functionCode","FUNCTION_NAME","",true,false);
	
	$("#expainContent").validatebox({
		required: true,    
	    validType: "text"
	});
	
	$(document).ready(function(){
		$('#functionCode').combobox({
		    onChange:function(newValue,oldValue){
		    	$.ajax({
					   type: "POST",
					   url: queryExplainUrl + "&functionCode=" + newValue,
					   success: function(data){
						   if(data != "null"){
							   data = JSON.parse(data);
							   $("#expainContent").val(data.expainContent);
							   $("#explainUuid").val(data.explainUuid);
						   }else{
							   $("#expainContent").val("");
							   $("#explainUuid").val("");
						   }
					   },
					   error:function(XMLHttpRequest, textStatus, errorThrown){
						   commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
					   }
				});
		    }
		});
	});
	
	function save(){
		event.preventDefault();
		var functionName = $("#functionCode").combobox("getText");
		$("#functionName").val(functionName);
		var result = $('#explainForm').form("validate");
		if(!Boolean(result)){
			$.messager.alert('警告','请填写必填项！','warning');
			return;
		}
		var explaindata = $("#explainForm").serialize();
		$.messager.progress(); 
		$.ajax({
			   type: "POST",
			   url: addOrUpdateUrl,
			   data:explaindata,
			   success: function(data){
				   $.messager.progress("close");
					commonObj.showResponse(data);
			   },
			   error:function(XMLHttpRequest, textStatus, errorThrown){
				   commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
				   $.messager.progress("close");
			   }
		});
	}
</script>