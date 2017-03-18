<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../common.jsp"%>
<title>合同报表</title>
<style>
	 td,th{ border-top:1px #CCCCCC solid;
            border-right:1px #CCCCCC solid;
            border-color:#CCCCCC;
            font-size: 12px;
            text-align: center;
            white-space:normal;
            height: 50px;
            }
     th{background-color: #EFF8FB;height: 50px;font-weight: bold;}
</style>
<script type="text/javascript">
var basePath = $("#basePath").val();
function openDetail(status){
	var url=basePath+"/sencondage/tabBaseElectricController.do?method=queryBaseElectricityList&status="+status;
	window.open(url,"","height=700,width=800,top=200,left=300,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no");
}
</script>

</head>
<body>



<div class="barTitle"> <!—标题栏样式，样式名：barTitle-->
<div class="content"><!—标题栏内容-->
<a href="javascript:;" onfocus="this.blur();"></a><!—图标-->
<span>信息列表</span>
</div>
</div>

<div class="ui-table ui-widget ui-corner-all ui-margin " >
<div class="nav"><!—grid按钮S栏->
</div>

<table id="omProductTable" class="table ui-border ">

			<thead>
			<tr>
				<th>地市</th>
				<th>区县</th>
				<th>站点总数</th>
				<th>即将到期未续签总数</th>
				<th>即将到期已续签总数</th>
				<th>已超期未续签总数</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${list}" var="info">
					<tr>
						<td class="td"><c:out value="${info.CITYNAME}"></c:out></td>
						<td class="td"><c:out value="${info.COUNTYNAME}"></c:out></td>
						<td class="td"><c:out value="${info.TOTAL}"/></td>
						<td class="td">
<!-- 						<a href="#" onclick="openDetail(1)"> -->
							<c:out value="${info.SOONNOTRENEW}"/>
<!-- 						</a> -->
						</td>
						<td class="td">
<!-- 						<a href="#" onclick="openDetail(2)"> -->
							<c:out value="${info.SOONRENEW}"/>
<!-- 						</a> -->
						</td>
						<td class="td">
<!-- 						<a href="#" onclick="openDetail(3)"> -->
							<c:out value="${info.OVERDUENOTRENEW}"/>
<!-- 						</a> -->
						</td>
					</tr>
			</c:forEach>
			</tbody>
			
	</table>
</div>

</body>
</html>
