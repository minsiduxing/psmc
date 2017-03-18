<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../../common.jsp"%>
<title>各区县上个月超标杆的总数统计</title>
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
					<th>站点电费总数</th>
					<th>超标杆电费总数</th>
				</tr>
			</thead>
			<tbody>

				<c:forEach items="${mypage.dataList}" var="info">
					<tr>
						<td class="td"><c:out value="${info.cityName}" /></td>
						<td class="td"><c:out value="${info.countyName}" /></td>
						<td class="td"><c:out value="${info.count_site}" /></td>	
						<td class="td"><c:out value="${info.last_sum_exceed}" /></td>
					</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<%-- <td colspan="13"><g:page myPage="${mypage}" /></td> --%>
			</tfoot>
		</table>
	</div>

</body>
</html>
