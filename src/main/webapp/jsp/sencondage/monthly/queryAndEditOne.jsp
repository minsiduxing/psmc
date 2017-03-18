<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../../common.jsp"%>
<title></title>

<script type="text/javascript">
function  showResponse(data,status,xhr){
    data = JSON.parse(data); 
	   if("success" == data.res){
			alert("数据编辑成功!");
			$("#id").val(data.id);
		}else{
			alert(data.msg);
			}
}
	function showRequest(){
	  var result = $("#editForm").valid();
	  return result;
	}

	
	
$(document).ready(function() {
    var formOption = {
  	      beforeSubmit:showRequest,
  	      success: showResponse
    };
    
	$('#queryButton').click(function(){
		$("#editForm").ajaxSubmit(formOption);
		 return false;
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
action="<%=request.getContextPath() %>/sencondage/tabMonthlyElectricController.do?method=editabMonthlyElectric">
<input type="hidden" class="text" id="id" name="id" value="${map.ID}"/>
<input type="hidden" class="text" id="FileInputAccount" name="FileInputAccount" value="${map.FILE_INPUT_ACCOUNT}"/>
<%-- <input type="hidden" class="text" id="IsShare" name="IsShare" value="${map.IS_SHARE}"/> --%>
<%-- <input type="hidden" class="text" id="ShareSituationName" name="ShareSituationName" value="${map.SHARE_SITUATION_NAME}"/> --%>

<%-- <input type="hidden" class="text" id="ShareMove" name="ShareMove" value="${map.SHARE_MOVE}"/> --%>
<%-- <input type="hidden" class="text" id="ShareMoveMoney" name="ShareMoveMoney" value="${map.SHARE_MOVE_MONEY}"/> --%>

<%-- <input type="hidden" class="text" id="ShareTelecom" name="ShareTelecom" value="${map.SHARE_TELECOM}"/> --%>
<%-- <input type="hidden" class="text" id="ShareTelecomMoney" name="ShareTelecomMoney" value="${map.SHARE_TELECOM_MONEY}"/> --%>

<%-- <input type="hidden" class="text" id="ShareUnicom" name="ShareUnicom" value="${map.SHARE_UNICOM}"/> --%>
<%-- <input type="hidden" class="text" id="ShareUnicomMoney" name="ShareUnicomMoney" value="${map.SHARE_UNICOM_MONEY}"/> --%>



<table class="table">
<tr>
	<td class="inputLabelTd">所属站点</td>
	<td class="inputTd">
		<g:select list="${sitDictList}"  defaultOption="false"  keyname="baseElectricId" keyid="baseElectricId" value="${map.BASE_ELECTRIC_ID}"/>
	</td>
	<td class="inputLabelTd">电费所属月份</td>
	<td class="inputTd">
		<input type="text" required date="true" class="text" id="FileInputDate" name="FileInputDate" 
		value="<fmt:formatDate value="${map.FILE_INPUT_DATE}" pattern="yyyy-MM"/>" onclick="WdatePicker({dateFmt: 'yyyy-MM'})"/>
	</td>
</tr>
<tr>
	<td class="inputLabelTd">电价</td>
	<td class="inputTd">
		<input type="text"  number="true" class="text" id="ElecCost" name="ElecCost" value="${map.ELEC_COST}"/>
	</td>
	<td class="inputLabelTd">电量</td>
	<td class="inputTd">
		<input type="text"  number="true" class="text" id="ElecAmount" name="ElecAmount" value="${map.ELEC_AMOUNT}"/>
	</td>
	
</tr>
<tr>
	<td class="inputLabelTd">起码</td>
	<td class="inputTd">
		<input type="text"  number="true" class="text" id="StartCode" name="StartCode" value="${map.START_CODE}"/>
	</td>
	<td class="inputLabelTd">止码</td>
	<td class="inputTd">
		<input type="text"  number="true" class="text" id="EndCode" name="EndCode" value="${map.END_CODE}"/>
	</td>
	
</tr>
<tr>
	<td class="inputLabelTd">电费合计</td>
	<td class="inputTd">
		<input type="text"  required number="true" class="text" id="TotalElecCost" name="TotalElecCost" value="${map.TOTAL_ELEC_COST}"/>
	</td>
	<td class="inputLabelTd">维管费</td>
	<td class="inputTd">
		<input type="text"  number="true" class="text" id="MaintainCost" name="MaintainCost" value="${map.MAINTAIN_COST}"/>
	</td>
</tr>
<tr>
	<td class="inputLabelTd">普票</td>
	<td class="inputTd">
		<input type="text"  number="true" class="text" id="GeneralTicket" name="GeneralTicket" value="${map.GENERAL_TICKET}"/>
	</td>
	<td class="inputLabelTd">增票</td>
	<td class="inputTd">
		<input type="text"  number="true" class="text" id="IncreaseTicket" name="IncreaseTicket" value="${map.INCREASE_TICKET}"/>
	</td>
</tr>
<tr>
	
<!-- 	<td class="inputLabelTd">购电抄表日期 </td> -->
<!-- 	<td class="inputTd"> -->
<!-- 		<input type="text" date="true" class="text" id="PurchaseCopyDate" name="PurchaseCopyDate"  -->
<%-- 		value="<fmt:formatDate value="${map.PURCHASE_COPY_DATE}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt: 'yyyy-MM-dd'})"/> --%>
<!-- 	</td> -->
</tr>
<!-- <tr> -->
<!-- 	<td class="inputLabelTd">购电起始日期 </td> -->
<!-- 	<td class="inputTd"> -->
<!-- 		<input type="text" date="true" class="text" id="PurchaseStartDate" name="PurchaseStartDate"  -->
<%-- 		value="<fmt:formatDate value="${map.PURCHASE_START_DATE}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt: 'yyyy-MM-dd'})"/> --%>
<!-- 	</td> -->
<!-- 	<td class="inputLabelTd">购电截止日期 </td> -->
<!-- 	<td class="inputTd"> -->
<!-- 		<input type="text" date="true" class="text" id="PurchaseEndDate" name="PurchaseEndDate"  -->
<%-- 		value="<fmt:formatDate value="${map.PURCHASE_END_DATE}" pattern="yyyy-MM-dd"/>" onclick="WdatePicker({dateFmt: 'yyyy-MM-dd'})"/> --%>
<!-- 	</td> -->
<!-- </tr> -->

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
