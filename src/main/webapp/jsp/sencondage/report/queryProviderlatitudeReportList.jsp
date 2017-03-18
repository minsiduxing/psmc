<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../../common.jsp"%>
<title>运营商纬度电费统计</title>
<style>
td,th {
	border-top: 1px #CCCCCC solid;
	border-right: 1px #CCCCCC solid;
	border-color: #CCCCCC;
	font-size: 12px;
	text-align: center;
	white-space: normal;
	height: 50px;
}

th {
	background-color: #EFF8FB;
	height: 50px;
	font-weight: bold;
}
</style>
<script type="text/javascript">
	var basePath = $("#basePath").val();
	function newFun(operate, id) {
		var url = basePath
				+ "/electricityController.do?method=queryAndEditOne&operate="
				+ operate + "&id=" + id;
		if ('edit' == operate)
			window
					.open(
							url,
							"查看",
							"height=700,width=800,top=200,left=300,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no");
	}
</script>

</head>
<body>



	<div class="barTitle">
		<!—标题栏样式，样式名：barTitle-->
		<div class="content">
			<!—标题栏内容-->
			<a href="javascript:;" onfocus="this.blur();"></a>
			<!—图标-->
			<span>信息列表</span>
		</div>
	</div>

	<div class="ui-table ui-widget ui-corner-all ui-margin ">
		<div class="nav">
			<!—grid按钮S栏->
		</div>

		<table id="omProductTable" class="table ui-border ">

			<thead>
				<tr>
					<th>地市</th>
					<th>区县</th>
					<th>电费总数</th>
					
					<th>移动共享电费总数</th>
					<th>移动独享电费总数</th>
					<th>移动电费总数</th>
					
					<th>电信共享电费总数</th>
					<th>电信独享电费总数</th>
					<th>电信电费总数</th>
					
					<th>联通共享电费总数</th>
					<th>联通独享电费总数</th>
					<th>联通电费总数</th>

				</tr>
			</thead>
			<tbody>

				<c:forEach items="${mypage.dataList}" var="info">
					<tr>
						<td class="td"><c:out value="${info.cityName}" /></td>
						<td class="td"><c:out value="${info.countyName}" /></td>
						<td class="td"><c:out value="${info.SUM_ALL_TOTAL_ELEC_COST}" /></td>
						
						<td class="td"><c:out value="${info.SUM_MOVE_MONEY_SHARED}" /></td>
						<td class="td"><c:out value="${info.SUM_MOVE_MONEY_UNSHARED}" /></td>
						<td class="td"><c:out value="${info.SUM_ALL_MOVE_MONEY}" /></td>
						
						<td class="td"><c:out value="${info.SUM_TELECOM_MONEY_SHARED}" /></td>
						<td class="td"><c:out value="${info.SUM_TELECOM_MONEY_UNSHARED}" /></td>
						<td class="td"><c:out value="${info.SUM_ALL_TELECOM_MONEY}" /></td>
						
						<td class="td"><c:out value="${info.SUM_UNICOM_MONEY_SHARED}" /></td>
						<td class="td"><c:out value="${info.SUM_UNICOM_MONEY_UNSHARED}" /></td>
						<td class="td"><c:out value="${info.SUM_ALL_UNICOM_MONEY}" /></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<%-- <td colspan="8"><g:page myPage="${mypage}" /></td> --%>
			</tfoot>
		</table>
	</div>

</body>
</html>
