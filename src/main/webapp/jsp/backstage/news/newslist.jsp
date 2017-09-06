<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="../../../common.jsp"%>
<script type="text/javascript" src="/newslist.js"></script>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>新闻列表页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body id="body">
  <!-- 信息查询 -->
<div class="query-content panel easyui-accordion accordion " data-options="selected:false" style="width:100%"> 
 <div title="信息查询" > 
    <form id="searchform" method="POST" class="query-form" >
	<ul class="searchform">
			<li class="li-input"><label for="" class="input-label">账号名称：</label>
				<input class="myinput" id="queryAccountName" name="accountName"></input>
			</li>
			<li class="li-input"><label for="" class="input-label">用户名：</label>
				<input class="myinput" id="queryPersonName" name="personName"></input>
			</li>
			<li class="li-input"><label for="" class="input-label">是否锁定：</label>
				<input id="queryIsLocked" name="isLocked" value=""></input>
			</li>
			
	</ul>
	</form>
	<div class="query-oper">
		<a href="#" class="easyui-linkbutton query-btn" onclick="commonObj.query('accountTableId','searchform')" id="submit_search" plain="true" iconCls="icon-search">查询</a>
		
	</div> 
 </div>
 </div>
 <!--信息查询结束  -->
<!--data grid  -->
 <table id="newsTableId" style="width:100%"></table>
  <!--工具栏  -->
<div id="toolbarId">
		<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="edit">修改</a>
		<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="remove">删除</a>
		<a href="" id="exportBtn" class="easyui-linkbutton query-btn"   plain="true" iconCls="icon-excel">导出</a>
</div>
<div id="editdialogDiv"></div>
  </body>
</html>

<script type="text/javascript">
var basePath = $("#basePath").val();

var getNewsDataUrl = basePath+"/website/backstage/tabNewsController.do";
getNewsDataUrl ='<c:url value="'+getNewsDataUrl+'"/>?method=getNesPage';
</script>
