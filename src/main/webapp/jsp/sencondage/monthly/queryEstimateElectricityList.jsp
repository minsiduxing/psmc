<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../../common.jsp"%>
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
function newFun(operate,id,FILE_INPUT_DATE){
	var url= basePath+"/sencondage/tabMonthlyElectricController.do?method=queryAndEditOne&operate="+operate+"&id="+id+"&fileInputDate="+FILE_INPUT_DATE;
	if('query' == operate)
	 	window.open(url,"查看","height=700,width=800,top=200,left=300,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no");
	else if('edit' == operate)
		window.open(url,"编辑","height=700,width=800,top=200,left=300,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no");
	else if('add' == operate)
		window.open(url,"添加","height=700,width=800,top=200,left=300,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no");
}

function jqchk(){  //jquery获取复选框值    
	  var chk_value =[];    
	  $('input[name="sitIdExCheckbox"]:checked').each(function(){    
	   chk_value.push($(this).val());    
	  });    
	  return chk_value;
	} ;   


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
<input type="hidden" id="checkFlag" value="0"/>
			<thead>
			<tr>
				<th><input type="checkbox" onchange="selectAll()"></th>
				<th>序号</th>
				<th>地市</th>
				<th>区县</th>
				<th>电费数据所属月份</th>
				<th>站点名称</th>
				<th>站点编码</th>
				<th>供电用户号</th>
				<th>电价</th>
				<th>电量</th>
				<th>运营商标杆</th>
				<th>电费合计</th>
				<th>是否共享</th>
				<th>共享情况</th>
				<th>分摊比例</br>(移动%)</th>
				<th>分摊金额(元)</br>(移动)</th>
				<th>分摊比例</br>(电信%)</th>
				<th>分摊金额(元)</br>(电信)</th>
				<th>分摊比例</br>(联通%)</th>
				<th>分摊金额(元)</br>(联通)</th>
				<th>共享起始日期</th>
				<th>操作</th>
			</tr>
			</thead>
			<tbody>
			
			<c:forEach items="${mypage.dataList}" var="info">
					<tr>
						<td class="td">
							<input type="checkbox" id="sitIdExCheckbox" name="sitIdExCheckbox" 
							value="${info.id}">
						</td>
						<td class="td"><c:out value="${info.INDEX_ID}"></c:out></td>
						<td class="td"><c:out value="${info.CITYNAME}"></c:out></td>
						<td class="td"><c:out value="${info.COUNTYNAME}"></c:out></td>
						<td class="td"><c:out value="${info.FILE_INPUT_DATE}"/></td>
						<td class="td"><c:out value="${info.SIT_NAME}"/></td>
						<td class="td"><c:out value="${info.SIT_ID_EX}"/></td>
						<td class="td"><c:out value="${info.POWER_USER_NO}"/></td>
						<td class="td"><c:out value="${info.ELEC_COST}"/></td>
						<td class="td"><c:out value="${info.ELEC_AMOUNT}"/></td>
						<td class="td"><c:out value="${info.OPERATOR_BENCHMARK}"/></td>
						<td class="td"><c:out value="${info.TOTAL_ELEC_COST}"/></td>
						<td class="td"><c:out value="${info.IS_SHARE}"/></td>
						<td class="td"><c:out value="${info.SHARE_SITUATION_NAME}"/></td>
						<td class="td"><c:out value="${info.SHARE_MOVE}"/></td>
						<td class="td"><c:out value="${info.SHARE_MOVE_MONEY}"/></td>
						<td class="td"><c:out value="${info.SHARE_TELECOM}"/></td>
						<td class="td"><c:out value="${info.SHARE_TELECOM_MONEY}"/></td>
						<td class="td"><c:out value="${info.SHARE_UNICOM}"/></td>
						<td class="td"><c:out value="${info.SHARE_UNICOM_MONEY}"/></td>
						<td class="td"><c:out value="${info.SHARE_START_DATE}"/></td>
						<td class="td">
							<button id="queryButton" type="button" class="button" onclick="newFun('query','${info.elecId}','${info.FILE_INPUT_DATE}');">查&nbsp;看</button>	
						</td>
					</tr>
			</c:forEach>
			</tbody>
			<tfoot>
					<td colspan="26">
						<g:page myPage="${mypage}"/>
					</td>
			</tfoot>
	</table>
</div>

</body>
</html>
