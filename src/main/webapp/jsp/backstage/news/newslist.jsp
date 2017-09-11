<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ include file="../../../common.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>新闻列表页面</title>
  </head>
  <script type="text/javascript" src="jsp/backstage/news/newslist.js"></script>
  <body id="body">
  <!-- 信息查询 -->
<div class="query-content panel easyui-accordion accordion " data-options="selected:false" style="width:100%"> 
 <div title="信息查询" > 
    <form id="searchform" method="POST" class="query-form" >
	<ul class="">
			<li class="li-input"><label for="" class="input-label">标题：</label>
				<input class="myinput" id="newsTitle" name="newsTitle"></input>
			</li>
			<li class="li-input"><label for="" class="input-label">子标题：</label>
				<input class="myinput" id="newSubTitle" name="newSubTitle"></input>
			</li>
			<li class="li-input"><label for="" class="input-label">作者：</label>
				<input id="newAutor" name="newAutor" value=""></input>
			</li>
			<li class="li-input"><label for="" class="input-label">概要：</label>
				<input id="newsAbstarct" name="newsAbstarct" value=""></input>
			</li>
			<li class="li-input"><label for="" class="input-label">创建人：</label>
				<input id="createAccName" name="createAccName" value=""></input>
			</li>
			<li class="li-input"><label for="" class="input-label">发布人：</label>
				<input id="releaseAccName" name="releaseAccName" value=""></input>
			</li>
			<li class="li-input"><label for="" class="input-label">审核人：</label>
				<input id="auditAccName" name="auditAccName" value=""></input>
			</li>
			<li class="li-input"><label for="" class="input-label">修改人：</label>
				<input id="modifyAccName" name="modifyAccName" value=""></input>
			</li>
			<li class="li-input"><label for="" class="input-label">审核状态：</label>
				<input id="audit" name="audit" value=""></input>
			</li>
	</ul>
	</form>
	<div class="query-oper">
		<a href="#" class="easyui-linkbutton query-btn" onclick="commonObj.query('newsTableId','searchform')" id="submit_search" plain="true" iconCls="icon-search">查询</a>
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
		<a href="#" id="exportBtn" class="easyui-linkbutton query-btn"   plain="true" iconCls="icon-excel">导出</a>
</div>
  </body>
</html>
<script type="text/javascript">
var basePath = $("#basePath").val();
var getNewsDataUrl = basePath+"/website/backstage/tabNewsController.do";
getNewsDataUrl ='<c:url value="'+getNewsDataUrl+'"/>?method=getNesPage';

var editNewsUrl = basePath+"/website/backstage/tabNewsController.do";
editNewsUrl ='<c:url value="'+editNewsUrl+'"/>?method=newsEdit';
</script>
