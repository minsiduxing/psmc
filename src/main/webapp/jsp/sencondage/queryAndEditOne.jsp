<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../common.jsp"%>
<title></title>

<script type="text/javascript">
function  showResponse(data,status,xhr){
    data = JSON.parse(data); 
	   if("success" == data.res){
			alert("数据编辑成功!");
			$("#id").val(data.id);
			//$("#sitIdEx").attr("readOnly",true);
			//$("#powerUserNo").attr("readOnly",true);
		}else{
			alert(data.msg);
			}
}
	function showRequest(){
	  var result = $("#editForm").valid();
	  return result;
	}
	
function shareValidate(){
	  var isShare = $("#isShare").val();
	  var powerUserNo = $("#powerUserNo").val();
	  if(isShare == null || isShare=='' || powerUserNo == null || powerUserNo=='' ){
		  if(confirm("您暂时未填写共享信息或供电用户号,此操作将会影响站点电费信息导入,是否继续?")){
			  if(isShare == null || isShare=='')
			  {
				  $("#shareSituationName").val("");
				  $("#shareMove").val("");
				  $("#shareTelecom").val("");
				  $("#shareUnicom").val("");
				  return true;
			  }
			  
		  }
		  //else
			//  return false;
		  
	  }
	  var shareSituationName = $("#shareSituationName").val();
	  var shareMove = $("#shareMove").val();
	  var shareTelecom = $("#shareTelecom").val();
	  var shareUnicom = $("#shareUnicom").val();
	  if('否' == isShare){
		  if("移动"!=shareSituationName 
				  && "电信"!=shareSituationName 
				  && "联通"!=shareSituationName){
			  alert("共享情况填写错误");
			  return false;
		  }else{
			 if("移动" == shareSituationName){
				 $("#shareMove").val("100");
				 $("#shareTelecom").val("");
				 $("#shareUnicom").val("");
			 }
			 if ("电信" == shareSituationName){
				 $("#shareMove").val("");
				 $("#shareTelecom").val("100");
				 $("#shareUnicom").val("");
			 }
			 if ("联通" == shareSituationName){
					$("#shareMove").val("");
					$("#shareTelecom").val("");
					$("#shareUnicom").val("100");
			 }
			 return true;
		  }
	  }else{
		  if(shareSituationName.indexOf("&") == -1){
			  alert("请填写正确的共享情况和各运营商分摊信息!");
			  return false;
		  }
		  var sitnames = shareSituationName.split("&");
		  if(sitnames.length < 2){
			  alert("请填写正确的共享情况和各运营商分摊信息!");
			  return false;
		  }
		  var sitresult = true;
		  
		  for(var i=0;i<sitnames.length;i++){
				 var value = sitnames[i];
				 if(value!="移动" && value!="电信" && value!="联通"){
					 sitresult = false;
					 break;
				 }
		  }	
		  if(!sitresult){
			  alert("请填写正确的共享情况和各运营商分摊信息!");
			  return false;
		  }
		  if(shareSituationName.indexOf("移动") != -1){
			  if(shareMove=='' || shareMove == null){
				  alert("请填写移动运营商分摊金额");
				  return false;
			  }
		  }else
			  $("#shareMove").val("");
		  if(shareSituationName.indexOf("电信") != -1){
			  if(shareTelecom=='' || shareTelecom == null){
				  alert("请填写电信运营商分摊金额");
				  return false;
			  }
		  }else
			  $("#shareTelecom").val("");
		  
		  if(shareSituationName.indexOf("联通") != -1){
			  if(shareUnicom=='' || shareUnicom == null){
				  alert("请填写联通运营商分摊金额");
				  return false;
			  }
		  }else
			  $("#shareUnicom").val("");
		  return true; 
		}
}
	
	
$(document).ready(function() {
    var formOption = {
  	      beforeSubmit:showRequest,
  	      success: showResponse
    };
    
	$('#queryButton').click(function(){
		var result = shareValidate();
		if(result)
	   	{
			$("#editForm").ajaxSubmit(formOption);
		   	return false;
	   	}
	});
	
	$("#closeBut").click(function(){
		window.close();
	});
	  
});


</script>
</head>
<body>
<div class=\"datagrid-mask\" style=\"background:#666666;\"></div>
<div class=\"datagrid-mask-msg\"></div>


<div class="main"><!—主容器，样式名：main-->

<div class="barTitle"> <!—标题栏样式，样式名：barTitle-->
<div class="content"><!—标题栏内容-->
<a href="javascript:;" onfocus="this.blur();"></a><!—图标-->
<c:if test="${'add' == operate}">
<span>添加</span>
</c:if>
<c:if test="${'edit' == operate}">
<span>编辑</span>
</c:if>
<c:if test="${'query' == operate}">
<span>查看</span>
</c:if>
</div>
</div>

<div id="conditions" class="ui-table ui-widget ui-corner-all ui-margin" style="display:block"><!—查询条件主容器-->
<form id="editForm" name="editForm" method="post" 
action="<%=request.getContextPath() %>/sencondage/tabBaseElectricController.do?method=editTabBaseElectricity">
<input type="hidden" class="text" id="id" name="id" value="${map.ID}"/>
<input type="hidden" class="text" id="cityId" name="cityId" value="0002"/>
<input type="hidden" class="text" id="status" name="status" value="${map.STATUS}"/>


<table class="table">
<tr>
	<td class="inputLabelTd">所属区县</td>
	<td class="inputTd">
		<g:select list="${countyList}"  defaultOption="false"  keyname="countyId" keyid="countyId" value="${map.COUNTY_ID}"/>
	</td>
	<td class="inputLabelTd">站点名称</td>
	<td class="inputTd">
		<input type="text"  required class="text" id="sitName" name="sitName" value="${map.SIT_NAME}"/>
	</td>
</tr>
<tr>
	<td class="inputLabelTd">站点编码</td>
	<td class="inputTd">
		 <input type="text" required
<%-- 		 <c:if test="${'edit' == operate}">readOnly</c:if> --%>
		 class="text" id="sitIdEx" name="sitIdEx" value="${map.SIT_ID_EX}"/>
	</td>
	<td class="inputLabelTd">供电用户号</td>
	<td class="inputTd">
		<input type="text"   
<%-- 		<c:if test="${'edit' == operate}">readOnly</c:if> --%>
		class="text" id="powerUserNo" name="powerUserNo" value="${map.POWER_USER_NO}"/>
	</td>
</tr>
<tr>
		<td class="inputLabelTd">供电方式</td>
		<td class="inputTd">
			<g:select list="${powerSupplyTypeList}" defaultOption="false"  keyname="powerSupplyType" keyid="powerSupplyType" value="${map.POWER_SUPPLY_TYPE}"/>
		</td>
		<td class="inputLabelTd">运营商标杆</td>
		<td class="inputTd">
			<input type="text"  required number="true" class="text" id="OperatorBenchmark" name="OperatorBenchmark" value="${map.OPERATOR_BENCHMARK}"/>
		</td>
	</tr>
<tr>
	<td class="inputLabelTd">是否共享</td>
	<td class="inputTd">
		<select  id="isShare" name="isShare" class="select">
			<option value="" <c:if test="${map.IS_SHARE ==''}">selected</c:if> >请选择</option>
			<option value="是" <c:if test="${map.IS_SHARE =='是'}">selected</c:if> >是</option>
			<option value="否" <c:if test="${map.IS_SHARE =='否'}">selected</c:if> >否</option>
		</select>
	</td>
	<td class="inputLabelTd">共享情况</td>
	<td class="inputTd">
		<input type="text" class="text" id="shareSituationName" name="shareSituationName" value="${map.SHARE_SITUATION_NAME}"/>
	</td>
</tr>
<tr>
	<td class="inputLabelTd">移动分摊比例</td>
	<td class="inputTd">
		<input type="text" number="true" class="text" id="shareMove" name="shareMove" value="${map.SHARE_MOVE}"/>
	</td>
	<td class="inputLabelTd">电信分摊比例</td>
	<td class="inputTd">
		<input type="text" number="true" class="text" id="shareTelecom" name="shareTelecom" value="${map.SHARE_TELECOM}"/>
	</td>
</tr>

<tr>
	<td class="inputLabelTd">联通分摊比例</td>
	<td class="inputTd">
		<input type="text" number="true" class="text" id="shareUnicom" name="shareUnicom" value="${map.SHARE_UNICOM}"/>
	</td>
	<td class="inputLabelTd">共享起始日期</td>
	<td class="inputTd">
		<input type="text" date="true" class="text" id="shareStartDate" name="shareStartDate" 
		value="${map.SHARE_START_DATE}" onclick="WdatePicker({dateFmt: 'yyyy-MM-dd'})"/>
	</td>
	
	
</tr>
<tr>
	<td class="inputLabelTd">合同编号</td>
	<td class="inputTd">
		<input type="text" class="text" id="contractId" name="contractId" value="${map.CONTRACT_ID}"/>
	</td>
	<td class="inputLabelTd">合同名称</td>
	<td class="inputTd">
		<input type="text" class="text" id="contractName" name="contractName" value="${map.CONTRACT_NAME}"/>
	</td>
</tr>
<tr>
	<td class="inputLabelTd">业主名称</td>
	<td class="inputTd">
		<input type="text" class="text" id="ownerName" name="ownerName" value="${map.OWNER_NAME}"/>
	</td>
	<td class="inputLabelTd">合同签订日期</td>
	<td class="inputTd">
		<input type="text" date="true" class="text" id="contractSignDate" name="contractSignDate" 
		value="${map.CONTRACT_SIGN_DATE}" onclick="WdatePicker({dateFmt: 'yyyy-MM-dd'})"/>
	</td>
</tr>
<tr>
	<td class="inputLabelTd">合同起始日期</td>
	<td class="inputTd">
		<input type="text" date="true" class="text" id="contractStartDate" name="contractStartDate" 
		value="${map.CONTRACT_START_DATE}" onclick="WdatePicker({dateFmt: 'yyyy-MM-dd'})"/>
	</td>
	
	
	<td class="inputLabelTd">合同终止日期</td>
	<td class="inputTd">
		<input type="text" date="true" class="text" id="contractEndDate" name="contractEndDate" 
		value="${map.CONTRACT_END_DATE}" onclick="WdatePicker({dateFmt: 'yyyy-MM-dd'})"/>
	</td>
</tr>


<tr>
	<td class="inputLabelTd">合同金额</td>
	<td class="inputTd">
		<input type="text" number="true" class="text" id="contractMoney" name="contractMoney" value="${map.CONTRACT_MONEY}"/>
	</td>
	<td class="inputLabelTd">场租支付周期</td>
	<td class="inputTd">
		<input type="text" class="text" id="fieldPaymentCycle" name="fieldPaymentCycle" 
		value="${map.FIELD_PAYMENT_CYCLE}" />
	</td>
</tr>
<tr>
	<td class="inputLabelTd">年租金</td>
	<td class="inputTd">
		<input type="text" number="true" class="text" id="rentalYear" name="rentalYear" value="${map.RENTAL_YEAR}"/>
	</td>
	<td class="inputLabelTd">合同续签日期</td>
	<td class="inputTd">
		<input type="text" date="true" class="text" id="contractRenewDate" name="contractRenewDate" 
		value="${map.CONTRACT_RENEW_DATE}" onclick="WdatePicker({dateFmt: 'yyyy-MM-dd'})"/>
	</td>
</tr>

<tr>
	<td class="inputLabelTd">续签起始日期</td>
	<td class="inputTd">
		<input type="text" date="true" class="text" id="contractRenewStartd" name="contractRenewStartd" 
		value="${map.CONTRACT_RENEW_STARTD}" onclick="WdatePicker({dateFmt: 'yyyy-MM-dd'})"/>
	</td>
	<td class="inputLabelTd">续签终止日期</td>
	<td class="inputTd">
		<input type="text" date="true" class="text" id="contractRenewEndd" name="contractRenewEndd" 
		value="${map.CONTRACT_RENEW_ENDD}" onclick="WdatePicker({dateFmt: 'yyyy-MM-dd'})"/>
	</td>
</tr>

<tr>
	<td class="inputLabelTd">续签金额</td>
	<td class="inputTd">
		<input type="text" number="true" class="text" id="renewMoney" name="renewMoney" 
		value="${map.RENEW_MONEY}"/>
	</td>
	<td class="inputLabelTd">是否更名</td>
	<td class="inputTd">
		<select  id="isRename" name="isRename" class="select">
			<option value="否" <c:if test="${map.IS_RENAME =='否'}">selected</c:if> >否</option>
			<option value="是" <c:if test="${map.IS_RENAME =='是'}">selected</c:if> >是</option>
		</select>
	</td>
</tr>

<tr>
	<td colspan="3" class="inputTd">
		<c:if test="${'edit' == operate || 'add' == operate}">
			<button id="queryButton" type="button" class="button">提交</button>
		</c:if>
		<button id="closeBut" type="button" class="button" >关闭</button>
	</td>	
</tr>

</table>
</form>
</div>
</div>

</body>
</html>
