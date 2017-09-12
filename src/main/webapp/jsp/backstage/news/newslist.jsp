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
			<li class="li-input"><label for="" class="input-label">新闻日期：</label>
				<input id="newsDateBegin" name="newsDateBegin" value=""></input>
			</li>
			
			<li class="li-input"><label for="" class="input-label">至</label>
			<input id="newsDateEnd" name="newsDateEnd" ></input>
			</li>
			<li class="li-input"><label for="" class="input-label">概要：</label>
				<input id="newsAbstarct" name="newsAbstarct" ></input>
			</li>
			<li class="li-input"><label for="" class="input-label">创建人：</label>
				<input id="createAccName" name="createAccName" ></input>
			</li>
			<li class="li-input"><label for="" class="input-label">发布人：</label>
				<input id="releaseAccName" name="releaseAccName" ></input>
			</li>
			<li class="li-input"><label for="" class="input-label">审核人：</label>
				<input id="auditAccName" name="auditAccName" ></input>
			</li>
			<li class="li-input"><label for="" class="input-label">修改人：</label>
				<input id="modifyAccName" name="modifyAccName" ></input>
			</li>
				<li class="li-input"><label for="" class="input-label">修改日期：</label>
				<input id="modifyDateBegin" name="modifyDateBegin" ></input>
			</li>
			<li class="li-input"><label for="" class="input-label">至：</label>
				<input id="modifyDateEnd" name="modifyDateEnd" />
			</li>
			<li class="li-input"><label for="" class="input-label">是否审核：</label>
				<input id="audit" name="audit" value=""></input>
			</li>
			<li class="li-input"><label for="" class="input-label">审核日期：</label>
			<input id="auditDateBegin" name="auditDateBegin" ></input>
			</li>
			<li class="li-input"><label for="" class="input-label">至：</label>
				<input id="auditDateEnd" name="auditDateEnd" />
			</li>
		     <li class="li-input"><label for="" class="input-label">是否发布：</label>
				<input id="releaseStatus" name="releaseStatus"> </input>
			</li>
			<li class="li-input"><label for="" class="input-label">发布日期：</label>
			<input id="releaseDateBegin" name="releaseDateBegin" ></input>
			</li>
			<li class="li-input"><label for="" class="input-label">至：</label>
				<input id="releaseDateEnd" name="releaseDateEnd" />
			</li>
			 <li class="li-input"><label for="" class="input-label">新闻分类：</label>
				<input id="towLevelClassify" name="towLevelClassify"> </input>
			</li>
			<li class="li-input"><label for="" class="input-label">到期日期：</label>
			<input id="publishExpireDateBegin" name="publishExpireDateBegin" ></input>
			</li>
			<li class="li-input"><label for="" class="input-label">至：</label>
				<input id="publishExpireDateEnd" name="publishExpireDateEnd" />
			</li>
			<li class="li-input"><label for="" class="input-label">创建日期：</label>
			<input id="createDateBegin" name="createDateBegin" ></input>

			</li>
			<li class="li-input"><label for="" class="input-label">至：</label>
					<input id="createDateEnd" name="createDateEnd" />
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
		<a href="" id="exportBtn" class="easyui-linkbutton query-btn" onclick="javascript:event.preventDefault();"  plain="true" iconCls="icon-excel">导出</a>
</div>
  </body>
</html>
<script type="text/javascript">
var basePath = $("#basePath").val();
var getNewsDataUrl = basePath+"/website/backstage/tabNewsController.do";
getNewsDataUrl ='<c:url value="'+getNewsDataUrl+'"/>?method=getNesPage';

var newsDo = basePath+"/website/backstage/tabNewsController.do";
var editNewsUrl ='<c:url value="'+newsDo+'"/>?method=newsEdit';
var removenews = '<c:url value="'+newsDo+'"/>?method=newsDelete';
$('#newsTitle').textbox({
	type : "text"
});
$('#newSubTitle').textbox({
	type : "text"
});
$('#newsAbstarct').textbox({
	multiline:true,
	type : "text"
});
$('#newsDateBegin').datetimebox({
});
$('#newsDateEnd').datetimebox({
});
$('#createDateBegin').datetimebox({
});
$('#createDateEnd').datetimebox({
});
$('#modifyDateBegin').datetimebox({
});
$('#modifyDateEnd').datetimebox({
});
$('#auditDateBegin').datetimebox({
});
$('#auditDateEnd').datetimebox({
});
$('#releaseDateBegin').datetimebox({
});
$('#releaseDateEnd').datetimebox({
});
$('#publishExpireDateBegin').datetimebox({
});
$('#publishExpireDateEnd').datetimebox({
});
$('#newAutor').textbox({
	type : "text"
});
$('#createAccName').textbox({
	type : "text",
});
$('#releaseAccName').textbox({
	type : "text"
});
$('#auditAccName').textbox({
	type : "text"
});
$('#modifyAccName').textbox({
	type : "text"
});
commonObj.initDictCombobox("audit","IF","<c:out value="${account.IS_LOCKED}"/>",false,true);
commonObj.initDictCombobox("releaseStatus","IF","<c:out value="${account.IS_LOCKED}"/>",false,true);
commonObj.initDictCombobox("towLevelClassify","IF","<c:out value="${account.IS_LOCKED}"/>",false,true);
</script>
