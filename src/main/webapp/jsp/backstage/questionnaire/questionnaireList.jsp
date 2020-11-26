<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="../../../common.jsp"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>问卷信息列表</title>
</head>
<body>
<div class="query-content panel easyui-accordion accordion " data-options="selected:false" style="width:100%"> 
 <div title="信息查询" > 
    <form id="searchform" method="POST" class="query-form" >
	<ul class="">
			<li class="li-input"><label for="" class="input-label">问卷标题：</label>
				<input class="myinput" id="questionnaireName" name="questionnaireName"></input>
			</li>
			
		    <li class="li-input"><label for="" class="input-label">是否启用：</label>
				<input id="isEnable" name="isEnable"/>
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
	<g:auth operateNo="<%=OperateContantsUtil.NEWS_ADD%>">
		<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain="true" id="add">新增</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.NEWS_EDIT%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain="true" id="edit">修改</a>
	</g:auth>
	<g:auth operateNo="<%=OperateContantsUtil.NEWS_DELETE%>">
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain="true" id="remove">删除</a>
	</g:auth>
</div>

	<div id="editQuestionnaireDlg"></div>
	         
</body>
</html>