<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="../../../common.jsp"%>
<title>录入客户信息</title>

</head>
<body>
<form id="editForm" method="POST" class="addfrom">

		<ul class="addform-subcontent">
			<li class="li-input"><label for="" class="input-label" style="">消费类型：</label>
				<!-- <select id="evaluateNoticeType" name="evaluateNoticeType" onchange="noticeTypeChange();">
					<option value=1>消费金额</option>
					<option value=2>消费项目</option>
					<option value=3>充值金额</option>
				</select> -->
				<input id="evaluateNoticeType" name="evaluateNoticeType" ></input> 
			</li>
			<li class="li-input" id="active7"><label for="" class="input-label" style="">选择问卷：</label>
				<input class="myinput" id="questionnaireUuid" name="questionnaireUuid"></input>
			</li>
			<li class="li-input"><label for="" class="input-label" style="">客户姓名：</label>
				<input class="myinput" id="evaluateName" name="evaluateName"></input>
			</li>
			<li class="li-input"><label for="" class="input-label" style="">客户昵称：</label>
				<input class="myinput" id="evaluateNickName" name="evaluateNickName"></input>
			</li> 
			<li class="li-input"><label for="" class="input-label" style="">客户电话：</label>
				<input id="evaluatePhone" name="evaluatePhone"></input>
			</li>
			<li id="consumptionDateLi" class="li-input"><label for="" class="input-label" style="">消费（充值）时间：</label>
				<input id="consumptionDate" name="consumptionDate"></input>
			</li>
			<li id="active1" class="li-input"><label for="" class="input-label" style="">消费金额：</label>
				<input id="consumptionAmount" name="consumptionAmount"></input>
			</li>
			<li id="active2" class="li-input"><label for="" class="input-label" style="">消费项目：</label>
				<input id="consumptionItem" name="consumptionItem"></input>
			</li>
			<li id="active3" class="li-input"><label for="" class="input-label" style="">充值金额：</label>
				<input id="rechargeAmount" name="rechargeAmount"></input>
			</li>
			<li id="active8" class="li-input"><label for="" class="input-label" style="">赠送金额：</label>
				<input id="giveAmount" name="giveAmount"></input>
			</li>
			<li id="active4" class="li-input"><label for="" class="input-label" style="">剩余金额：</label>
				<input id="surplusAmount" name="surplusAmount"></input>
			</li>
			<li id="active5" class="li-input"><label for="" class="input-label" style="">剩余次数：</label>
				<input id="surplusNumber" name="surplusNumber"></input>
			</li>
			<li id="active6" class="li-input"><label for="" class="input-label" style="">剩余积分：</label>
				<input id="surplusScore" name="surplusScore"></input>
			</li>

			<li id="active10" class="li-input"><label for="" class="input-label" style="">专享：</label>
				<input id="vipRemark" name="vipRemark"></input>
			</li>

			<li id="active11" class="li-input"><label for="" class="input-label" style="">管家：</label>
				<input id="butler" name="butler"></input>
			</li>
			<li id="active12" class="li-input"><label for="" class="input-label" style="">其余描述：</label>
				<input id="otherRemark" name="otherRemark"></input>
			</li>
		</ul>
	</form>
	<div align="center">
		<input type="button" onclick="submitEvauateInfo();" class="easyui-linkbutton" value="提   交" style="width:60px;height:30px;" >
	</div>
<script type="text/javascript">
	
	
	$("#evaluateNickName").textbox({
		required : true
	});
	
	$("#evaluateName").textbox({
		required : true
	});

	$("#evaluatePhone").textbox({
		required : true
	});

	$("#consumptionAmount").numberbox({
		required : true
	});

	 $("#consumptionItem").textbox({
		required : true
	});

	$("#rechargeAmount").numberbox({
		required : true
	}); 
	$("#surplusAmount").numberbox({
		required : true
	});

	$("#surplusNumber").textbox({
		required : true
	}); 

	$("#surplusScore").numberbox({
		required : true
	});

	$('#consumptionDate').datebox({
		editable:false,
		required : true
	});
	
	$('#giveAmount').numberbox({
		required : true
	});
	$('#vipRemark').textbox({
		required : true
	});
	$('#butler').textbox({
		required : true
	});
	$('#otherRemark').textbox({
		required : true
	});

	
	$(document).ready(function() {
		commonObj.initDictCombobox("evaluateNoticeType","NOTICE_TYPE",null,true,false);
		commonObj.initQuestionnaireCombobox("questionnaireUuid",null,true);
	});

	function  sethiden(){
		$("#active1").hide();$('#consumptionAmount').numberbox({required:false});
		$("#active2").hide();$('#consumptionItem').textbox({required:false});
		$("#active3").hide();$('#rechargeAmount').numberbox({required:false});
		$("#active4").hide();$('#surplusAmount').numberbox({required:false});
		$("#active5").hide();$('#surplusNumber').textbox({required:false});
		$("#active6").hide();$('#surplusScore').numberbox({required:false});
		$("#active7").hide();
		$("#active8").hide();$('#giveAmount').numberbox({required:false});
		$("#active10").hide();$('#vipRemark').textbox({required:false});
		$("#active11").hide();$('#butler').textbox({required:false});
		$("#active12").hide();$('#otherRemark').textbox({required:false});
		$("#consumptionDateLi").hide();$('#consumptionDate').datebox({required:false});

	}

	 $("#evaluateNoticeType").combobox({
	        onSelect: function () {
	            var evaluateNoticeType = $("#evaluateNoticeType").combobox('getValue');
	            if(evaluateNoticeType == "1"){ //消费金额
					sethiden();
	    			$("#active1").show();$('#consumptionAmount').numberbox({required:true});
	    			$("#active4").show();$('#surplusAmount').numberbox({required:true});
	    			$("#active6").show();$('#surplusScore').numberbox({required:true});
	    			$("#active7").show();
					$("#consumptionDateLi").show();$('#consumptionDate').datebox({required:true});
	    		}else if(evaluateNoticeType == "2"){ //消费项目
					sethiden();
	    			$("#active2").show();$('#consumptionItem').textbox({required:true});
	    			$("#active5").show();$('#surplusNumber').textbox({required:true});
	    			$("#active6").show();$('#surplusScore').numberbox({required:true});
	    			$("#active7").show();
					$("#consumptionDateLi").show();$('#consumptionDate').datebox({required:true});
	    		}else if(evaluateNoticeType == "3"){ //充值金额
					sethiden();
	    			$("#active3").show();$('#rechargeAmount').numberbox({required:true});
	    			$("#active4").show();$('#surplusAmount').numberbox({required:true});
	    			$("#active8").show();$('#giveAmount').numberbox({required:true});
					$("#consumptionDateLi").show();$('#consumptionDate').datebox({required:true});
	    		}else if(evaluateNoticeType == "4"){ //卡余提醒一类
					sethiden();
					$("#active4").show();$('#surplusAmount').numberbox({required:true});
					$("#active2").show();$('#consumptionItem').textbox({required:true});
					$("#active12").show();$('#otherRemark').textbox({required:true});
					$("#active5").show();$('#surplusNumber').textbox({required:true});
					$("#active2 label:first-child").text("待体验项目：");

				}else if(evaluateNoticeType == "5"){ //卡余提醒二类
					sethiden();
					$("#active4").show();$('#surplusAmount').numberbox({required:true});
					$("#active2").show();$('#consumptionItem').textbox({required:true});
					$("#active2 label:first-child").text("待体验项目：");
				}else if(evaluateNoticeType == "6"){ //卡余提醒三类
					sethiden();
					$("#active4").show();$('#surplusAmount').numberbox({required:true});
					$("#active12").show();$('#otherRemark').textbox({required:true});

				}else if(evaluateNoticeType == "7"){ //未体验提醒一类
					sethiden();
					$("#active2").show();$('#consumptionItem').textbox({required:true});
					$("#active2 label:first-child").text("未体验项目：");

				}else if(evaluateNoticeType == "8"){ //未体验提醒二类
					sethiden();
					$("#active2").show();$('#consumptionItem').textbox({required:true});
					$("#active5").show();$('#surplusNumber').textbox({required:true});
					$("#active12").show();$('#otherRemark').textbox({required:true});
					$("#active2 label:first-child").text("未体验项目：");
				}else if(evaluateNoticeType == "9"){ //专享
					sethiden();
					$("#active12").show();$('#otherRemark').textbox({required:true});
					$("#active11").show();$('#butler').textbox({required:true});
					$("#active10").show();$('#vipRemark').textbox({required:true});
					$("#consumptionDateLi").show();$('#consumptionDate').datebox({required:true});
					$("#consumptionDateLi label:first-child").text("有效期：");
					$("#active12 label:first-child").text("最近店内描述：");
				}
	        }
	   })
	
	
	//提交
	function submitEvauateInfo(){
		var evaluateNoticeType = $("#evaluateNoticeType").combobox('getValue');
		var questionnaireUuid = $("#questionnaireUuid").combobox('getValue');
		if(evaluateNoticeType==null || evaluateNoticeType==""){
			commonObj.alert("请选择类型!","warning");
			return;
		}
		if(evaluateNoticeType == '1' || evaluateNoticeType == '2' ){
			if(questionnaireUuid==null || questionnaireUuid==""){
				commonObj.alert("请选择问卷!","warning");
				return;
			}  
		}
		
		var result = $('#editForm').form("validate");
		if(!Boolean(result)){
			$.messager.alert('警告','请填写必填项！','warning');
			return;
		}
		
		var evaluatePhone = $("#evaluatePhone").textbox('getValue'); //手机号码
		var consumptionAmount = $("#consumptionAmount").textbox('getValue'); //消费金额
		var rechargeAmount = $("#rechargeAmount").textbox('getValue');//充值金额
		var surplusAmount = $("#surplusAmount").textbox('getValue');//剩余金额
		var surplusNumber = $("#surplusNumber").textbox('getValue');//剩余次数
		var surplusScore = $("#surplusScore").textbox('getValue');//剩余积分
		var consumptionItem = $("#consumptionItem").textbox('getValue');//消费项目
		
		var pattern = /^1[345789]\d{9}$/;
		if(!pattern.test(evaluatePhone)){
			 $.messager.alert('警告','请输入正确的手机号码！','warning');
			 return;
		}
		
		if(evaluateNoticeType == '2'){
			var itemArray = consumptionItem.split("&");
			var numArray = surplusNumber.split("&");
			if(itemArray.length != numArray.length){
				$.messager.alert('警告','消费项目数与剩余次数不匹配！','warning');
				 return;
			}
		}
		/* if(evaluateNoticeType == '1'){
			if(isNaN(consumptionAmount)){
				$.messager.alert('警告','请输入正确的消费金额！','warning');
			}
			if(isNaN(surplusAmount)){
				$.messager.alert('警告','请输入正确的剩余金额！','warning');
			}
			if(isNaN(surplusScore)){
				$.messager.alert('警告','请输入正确的剩余积分！','warning');
			}
		}
		if(evaluateNoticeType == '2'){
			if(isNaN(surplusNumber)){
				$.messager.alert('警告','输入正确的剩余次数！','warning');
			}
			if(isNaN(surplusScore)){
				$.messager.alert('警告','输入正确的剩余积分！','warning');
			}
		}
		if(evaluateNoticeType == '2'){
			if(isNaN(rechargeAmount)){
				$.messager.alert('警告','输入正确的充值金额！','warning');
			}
		} */
		var evauateInfo = $("#editForm").serialize();
		var url = '<c:url value="/website/backstage/EvauateInfoController.do"/>?method=submit';
		$.messager.progress(); 
		$.ajax({
			   type: "POST",
			   url: url,
			   data:evauateInfo,
			   success: function(data){
				   $.messager.progress("close");
				   addDialog.window("close");
				   successCallback(data);
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