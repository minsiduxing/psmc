<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../common.jsp"%>
<title>电费基础信息查询结果</title>
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
function newFun(operate,sitIdEx){
	var url= basePath+"/sencondage/tabBaseElectricController.do?method=queryAndEditOne&operate="+operate+"&sitIdEx="+sitIdEx;
	if('query' == operate)
	 	window.open(url,"查看","height=700,width=800,top=200,left=300,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no");
	else if('edit' == operate)
		window.open(url,"编辑","height=700,width=800,top=200,left=300,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no");
	else if('add' == operate)
		window.open(url,"添加","height=700,width=800,top=200,left=300,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no");
}

function selectAll(){
	var flag = $("#checkFlag").val();
	if(0 !=flag){
		$("[name='sitIdExCheckbox']").removeProp("checked");
		$("#checkFlag").val(0);
	}else{
		$("[name='sitIdExCheckbox']").prop("checked",'true');
		$("#checkFlag").val(1);
	}
};

function deleteInfo(){

	var sitIdExCheckboxValue = jqchk();
	if(sitIdExCheckboxValue.length==0){
		alert("你还没有选择任何内容");
		return;
	}
	if(confirm("确定要删除吗,删除后站点下的电费数据也将同步删除,且数据无法恢复!")){
		window.parent.deleteInfo(sitIdExCheckboxValue);
	};
}

function jqchk(){  //jquery获取复选框值    
	  var chk_value =[];    
	  $('input[name="sitIdExCheckbox"]:checked').each(function(){    
	   chk_value.push($(this).val());    
	  });    
	  return chk_value;
	} ;   

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
<input id="queryButton" type="button" class="button" value="删除" onclick="deleteInfo();"/>
<button id="queryButton" type="button" class="button" onclick="newFun('add','');">添加</button>
</div>

<table id="omProductTable" class="table ui-border ">
<input type="hidden" id="checkFlag" value="0"/>
			<thead>
			<tr>
				<th><input type="checkbox" onchange="selectAll()"></th>
				<th>序号</th>
				<th>地市</th>
				<th>区县</th>
				<th>站点名称</th>
				<th>站点编码</th>
				<th>供电用户号</th>
				<th>是否共享</th>
				<th>共享情况</th>
				<th>分摊比例(移动)%</th>
				<th>分摊比例(电信)%</th>
				<th>分摊比例(联通)%</th>
				<th>运营商标杆</th>
				<th>共享起始日期</th>
				<th>合同编号</th>
				<th>合同名称</th>
<!-- 				<th>业主名称</th> -->
<!-- 				<th>合同签订日期</th> -->
<!-- 				<th>合同起始日期</th> -->
				<th>合同终止日期</th>
<!-- 				<th>合同金额</th> -->
<!-- 				<th>场租支付周期</th> -->
<!-- 				<th>年租金</th> -->
<!-- 				<th>合同续签日期</th> -->
<!-- 				<th>续签起始日期</th> -->
<!-- 				<th>续签终止日期</th> -->
<!-- 				<th>续签金额</th> -->
<!-- 				<th>是否更名</th> -->
				<th>站点状态</th>
				<th>供电方式</th>
				<th>操作</th>
			</tr>
			</thead>
			<tbody>
			
			<c:forEach items="${mypage.dataList}" var="info">
					<tr>
						<td class="td">
							<input type="checkbox" id="sitIdExCheckbox" name="sitIdExCheckbox" 
							value="${info.SIT_ID_EX}">
						</td>
						<td class="td"><c:out value="${info.INDEX_ID}"></c:out></td>
						<td class="td"><c:out value="${info.cityName}"></c:out></td>
						<td class="td"><c:out value="${info.countyName}"></c:out></td>
						<td class="td"><c:out value="${info.SIT_NAME}"/></td>
						<td class="td"><c:out value="${info.SIT_ID_EX}"/></td>
						<td class="td"><c:out value="${info.POWER_USER_NO}"/></td>
						<td class="td"><c:out value="${info.IS_SHARE}"/></td>
						<td class="td"><c:out value="${info.SHARE_SITUATION_NAME}"/></td>
						<td class="td"><c:out value="${info.SHARE_MOVE}"/></td>
						<td class="td"><c:out value="${info.SHARE_TELECOM}"/></td>
						<td class="td"><c:out value="${info.SHARE_UNICOM}"/></td>
						<td class="td"><c:out value="${info.OPERATOR_BENCHMARK}"/></td>
						<td class="td"><c:out value="${info.SHARE_START_DATE}"/></td>
						<td class="td"><c:out value="${info.CONTRACT_ID}"/></td>
						<td class="td"><c:out value="${info.CONTRACT_NAME}"/></td>
<%-- 						<td class="td"><c:out value="${info.OWNER_NAME}"/></td> --%>
<%-- 						<td class="td"><c:out value="${info.CONTRACT_SIGN_DATE}"/></td> --%>
<%-- 						<td class="td"><c:out value="${info.CONTRACT_START_DATE}"/></td> --%>
						<td class="td"><c:out value="${info.CONTRACT_END_DATE}"/></td>
<%-- 						<td class="td"><c:out value="${info.CONTRACT_MONEY}"/></td> --%>
<%-- 						<td class="td"><c:out value="${info.FIELD_PAYMENT_CYCLE}"/></td> --%>
<%-- 						<td class="td"><c:out value="${info.RENTAL_YEAR}"/></td> --%>
<%-- 						<td class="td"><c:out value="${info.CONTRACT_RENEW_DATE}"/></td> --%>
<%-- 						<td class="td"><c:out value="${info.CONTRACT_RENEW_STARTD}"/></td> --%>
<%-- 						<td class="td"><c:out value="${info.CONTRACT_RENEW_ENDD}"/></td> --%>
<%-- 						<td class="td"><c:out value="${info.RENEW_MONEY}"/></td> --%>
<%-- 						<td class="td"><c:out value="${info.IS_RENAME}"/></td> --%>
						<td class="td"><c:out value="${info.stateName}"/></td>
						<td class="td"><c:out value="${info.powerSupplyTypeName}"/></td>						
						<td class="td">
							<button id="queryButton" type="button" class="button" onclick="newFun('query','${info.SIT_ID_EX}');">查&nbsp;看</button>
							<button id="queryButton" type="button" class="button" onclick="newFun('edit','${info.SIT_ID_EX}');">编辑</button>
						</td>
					</tr>
			</c:forEach>
			</tbody>
			<tfoot>
					<td colspan="31">
						<g:page myPage="${mypage}"/>
					</td>
			</tfoot>
	</table>
</div>

</body>
</html>
