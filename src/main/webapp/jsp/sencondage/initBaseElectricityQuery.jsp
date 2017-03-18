<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../common.jsp"%>
<title></title>

<script type="text/javascript">

function exportInfo(){
	 var url  = '<c:url value="/sencondage/tabBaseElectricController.do?method=exportBaseElectricity"/>';
	 $("#queryForm").attr("action",url);
	 $("#queryForm").submit();
}
function queryInfo(){
	$("#queryForm").attr("action",'<c:url value="/sencondage/tabBaseElectricController.do?method=queryBaseElectricityList"/>');
	$("#queryForm").submit();
 	$("#listDataShowFrame").show();
}
function importInfo(flag){
	if(1 == flag)
		window.location.href="<%=request.getContextPath() %>/jsp/sencondage/multipartElectricity.jsp";
	else
		window.location.href="<%=request.getContextPath() %>/jsp/sencondage/multipartElectricityContract.jsp";
}
function deleteInfo(ids){
	var url  = '<c:url value="/sencondage/tabBaseElectricController.do?method=deletesBaseElectricity"/>';
	$("#ids").val(ids);
	$("#queryForm").attr("action",url);
	$("#queryForm").submit();
}


</script>
</head>
<body>
<div class=\"datagrid-mask\" style=\"background:#666666;\"></div>
<div class=\"datagrid-mask-msg\"></div>


<div class="main"><!—主容器，样式名：main-->

<div class="barTitle"> <!—标题栏样式，样式名：barTitle-->
<div class="content"><!—标题栏内容-->
<a href="javascript:;" onfocus="this.blur();"></a><!—图标-->
<span>查询条件</span>
</div>
</div>

<div id="conditions" class="ui-table ui-widget ui-corner-all ui-margin" style="display:block"><!—查询条件主容器-->
<form id="queryForm"

 name="queryForm" method="POST" target="listDataShowFrame">
<input type="hidden" id="ids" name="ids"/>
<input type="hidden" id="q_export_column" name="q_export_column"/>
<table class="table">
<tr>
	<td>区县</td>
	<td class="inputTd">
		<g:select list="${cityList}" defaultOption="true" keyname="countyId" keyid="countyId"/>
	</td>
	
	<td>站点状态</td>
	<td class="inputTd">
		<g:select list="${sitTypeList}" defaultOption="true" keyname="status" keyid="status"/>
	</td>
	
	<td>合同编号</td>
	<td class="inputTd"><input id="contractId" name="contractId" type="text" /></td>

</tr>
<tr>
	<td>合同名称</td>
	<td class="inputTd"><input id="contractName" name="contractName" type="text" /></td>
	
	<td>合同签订日期开始</td>
	<td class="inputTd"><input type="text" readOnly="true" onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd'})" id="contractSignDateS" name="contractSignDateS"/>
	至
	<input type="text" readOnly="true" onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd'})" id="contractSignDateE" name="contractSignDateE"/>
	</td>
	
	<td>合同终止日期开始</td>
	<td class="inputTd"><input type="text" readOnly="true" onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd'})" id="contractEndDateS" name="contractEndDateS"/>
	至
	<input type="text" readOnly="true" onfocus="WdatePicker({dateFmt: 'yyyy-MM-dd'})" id="contractEndDateE" name="contractEndDateE"/>
	</td>

</tr>

<tr>
	<td>站点名称</td>
	<td class="inputTd"><input id="sitName" name="sitName" type="text"/></td>
	
	<td>站点编码</td>
	<td class="inputTd"><input id="sitIdEx" name="sitIdEx" type="text" /></td>

	<td>供电用户号</td>
	<td class="inputTd"><input id="powerUserNo" name="powerUserNo" type="text" /></td>
	
</tr>

<tr>
		<td colspan="6"> 
		<input id="queryButton" type="button" class="button" value="查询" onclick="queryInfo();"/>
		
		<input id="exportBtn"   type="button" class="button" value="导出"  onclick="exportInfo();"/>
		
		<input id="exportBtn"   type="button" class="button" value="导入站点信息"  onclick="importInfo(1);"/>
		
		<input id="exportBtn"   type="button" class="button" value="导入合同信息"  onclick="importInfo(2);"/>
		
	</td>
</tr>

</table>
</form>
</div>
</div>
<iframe id="listDataShowFrame" name="listDataShowFrame" height="380px" width="100%" frameborder="2" style="display: none;"></iframe>
</body>
</html>
