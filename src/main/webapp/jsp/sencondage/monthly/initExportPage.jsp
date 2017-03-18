<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.List"%> 
<%@page import="java.util.Map"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="../../../common.jsp"%>
<title></title>
<script type="text/javascript" src="<%=request.getContextPath() %>/jsp/firstage/electricityList.js"></script>
<script type="text/javascript">
function confirmIt(){
	var str=document.getElementsByName("dictNames");
	var objarray=str.length;
	var chestr="";
	for (var i=0;i<objarray;i++)
	{
	  if(str[i].checked == true)
	  {
	   chestr+=str[i].value+",";
	  }
	}
	
	$("#q_export_column",window.opener.document).val(chestr);
	var url ='<c:url value="/sencondage/tabMonthlyElectricController.do?method=exportmonthlyElectricity"/>';
	$("#queryForm",window.opener.document).attr("action",url);
	$("#queryForm",window.opener.document).submit();
	//$("#listDataShowFrame",window.opener.document).show();
	window.close();

	
}
</script>
</head>
<body>



<div class="barTitle"> <!—标题栏样式，样式名：barTitle-->
<div class="content"><!—标题栏内容-->
<a href="javascript:;" onfocus="this.blur();"></a><!—图标-->
<span>导出字段信息</span>
</div>
</div>

<div class="ui-table ui-widget ui-corner-all ui-margin " >
<div class="nav"><!—grid按钮栏->
</div>
<table id="listable" class="table ui-border ">
			<tbody>
			 
				<%
				  List datalist = (List)request.getAttribute("datalist");
				 int index =0;
                 for(int i=0;i<datalist.size();i++){
                     Map map = (Map)datalist.get(i);
                    if(i/5==index){
                 		%>
                 			<tr>
                 		<%	
                 		index++;
                    }
                    
                    %>
                    	<td>
							<input type="checkbox" id="dictId" name="dictNames" 
										value="<%=map.get("ID").toString() %>@<%=map.get("NAME").toString() %>" checked><%=map.get("NAME").toString() %></input>
						</td>
                    <%
                    	
                    if((i+1)/10==index){
                 		%>
                 			</tr>
                 		<%	
                    }
                 }
				%>
<%-- 			<c:forEach items="${datalist}" var="info"> --%>
<!-- 					<tr> -->
<!-- 						<td> -->
<%-- 							<input type="checkbox" id="dictId" name="dictNames" value="<c:out value="${info.dictId}"></c:out>@<c:out value="${info.dictName}"></c:out>" checked/> --%>
<!-- 						</td> -->
<%-- 						<td><c:out value="${info.dictName}"></c:out></td> --%>
<!-- 					</tr> -->
<%-- 			</c:forEach> --%>
			</tbody>
					<tr>
						<td colspan="2">
							<input type="button" class="button"  value="确认" onclick="confirmIt();">
						</td>
					</tr>
	</table>
</div>
</body>
</html>
