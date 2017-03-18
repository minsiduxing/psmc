<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../common.jsp"%>
<title> 单站点阶段电费统计</title>
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
function newFun(operate,id){
	var url= basePath+"/electricityController.do?method=queryAndEditOne&operate="+operate+"&id="+id;
	if('edit' == operate)
	 	window.open(url,"查看","height=700,width=800,top=200,left=300,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no");
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
				<th>站点名称</th>
				<th>站点编码</th>
				<th>供电用户号</th>
				<th>电费总和数</th>
				<th>电费平均数</th>
			</tr>
			</thead>
			<tbody>
			
			<c:forEach items="${mypage.dataList}" var="info">
					<tr>
						<td class="td"><c:out value="${info.CITYNAME}"></c:out></td>
						<td class="td"><c:out value="${info.COUNTYNAME}"></c:out></td>
						<td class="td"><c:out value="${info.SIT_NAME}"/></td>
						<td class="td"><c:out value="${info.SIT_ID_EX}"/></td>
						<td class="td"><c:out value="${info.POWER_USER_NO}" /></td>
						<td class="td"><c:out value="${info.SUM_ELEC_COST}"/></td>
						<td class="td"><c:out value="${info.AVG_ELEC_COST}"/></td>

						
					</tr>
			</c:forEach>
			</tbody>
			<tfoot>
					<td colspan="7">
						<g:page myPage="${mypage}"/>
					</td>
			</tfoot>
	</table>
</div>

</body>
</html>
