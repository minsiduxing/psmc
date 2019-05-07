<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="../../../common.jsp"%>
<title>录入客户信息</title>

</head>
<body>
<form id="editForm" method="POST" class="addfrom">
		<input type="hidden" id="questionnaireUuid" name="questionnaireUuid" value="<c:out value="${questionnaire.questionnaireUuid}"/>"/>

		<ul class="addform-subcontent">
			<li class="li-input"><label for="" class="input-label">通知类型：</label>
				<select id="evaluateNoticeType" name="evaluateNoticeType" onchange="noticeTypeChange();">
					<option value=1>消费金额</option>
					<option value=2>消费项目</option>
					<option value=3>充值金额</option>
				</select>
				<!-- <input id="evaluateNoticeType" name="evaluateNoticeType" onchange="noticeTypeChange();"></input> -->
			</li>
			<li class="li-input"><label for="" class="input-label">客户姓名：</label>
				<input class="myinput" id="evaluateName" name="evaluateName"></input>
			</li>
			<li class="li-input"><label for="" class="input-label">客户昵称：</label>
				<input class="myinput" id="evaluateNickName" name="evaluateNickName"></input>
			</li> 
			<li class="li-input"><label for="" class="input-label">客户电话：</label>
				<input id="evaluatePhone" name="evaluatePhone"></input>
			</li>
			<li class="li-input"><label for="" class="input-label">消费时间：</label>
				<input id="consumptionDate" name="consumptionDate"></input>
			</li>
			<li id="active1" class="li-input"><label for="" class="input-label">消费金额：</label>
				<input id="consumptionAmount" name="consumptionAmount"></input>
			</li>
			<li id="active2" hidden="true" class="li-input"><label for="" class="input-label">消费项目：</label>
				<input id="consumptionItem" name="consumptionItem"></input>
			</li>
			<li id="active3" hidden="true" class="li-input"><label for="" class="input-label">充值金额：</label>
				<input id="rechargeAmount" name="rechargeAmount"></input>
			</li>
			<li id="active4" class="li-input"><label for="" class="input-label">剩余金额：</label>
				<input id="surplusAmount" name="surplusAmount"></input>
			</li>
			<li id="active5" hidden="true" class="li-input"><label for="" class="input-label">剩余次数：</label>
				<input id="surplusNumber" name="surplusNumber"></input>
			</li>
			<li id="active6" class="li-input"><label for="" class="input-label">剩余积分：</label>
				<input id="surplusScore" name="surplusScore"></input>
			</li>
		</ul>
	</form>
	<div align="center">
		<input type="button" onclick="submitEvauateInfo();" class="easyui-linkbutton" value="提   交" style="width:60px;height:30px;" >
	</div>
<script type="text/javascript">

	$('#consumptionDate').datebox({
		editable:false,
		required : true
	});
	
	$(document).ready(function() {
		//commonObj.initDictCombobox("evaluateNoticeType","IF","",true,false);
	});
	
	//通知类型选择事件
	function noticeTypeChange(){
		var evaluateNoticeType = $("#evaluateNoticeType option:checked").val();
		if(evaluateNoticeType == "1"){ //消费金额
			$("#active2").hide();
			$("#active3").hide();
			$("#active5").hide();
			$("#active1").show();
			$("#active4").show();
			$("#active6").show();
		}else if(evaluateNoticeType == "2"){ //消费项目
			$("#active1").hide();
			$("#active3").hide();
			$("#active4").hide();
			$("#active2").show();
			$("#active5").show();
			$("#active6").show();
		}else if(evaluateNoticeType == "3"){ //充值金额
			$("#active1").hide();
			$("#active2").hide();
			$("#active5").hide();
			$("#active6").hide();
			$("#active3").show();
			$("#active4").show();
		}
	}
	
	//提交
	function submitEvauateInfo(){
		var result = $('#editForm').form("validate");
		if(!Boolean(result)){
			$.messager.alert('警告','请填写必填项！','warning');
			return;
		}
		var evauateInfo = $("#editForm").serialize();
		var url = '<c:url value="/website/backstage/EvauateInfoController.do"/>?method=submit';
		$.messager.progress(); 
		$.ajax({
			   type: "POST",
			   url: url,
			   data:evauateInfo,
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
</body>
</html>