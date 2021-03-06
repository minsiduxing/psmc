<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="../../../../common.jsp"%>

<title>系统日志列表</title>
<script type="text/javascript" src="sysOperLog_list.js"></script>
</head>
<body id="body">

<div class="query-content panel easyui-accordion accordion " data-options="selected:false" style="width:100%"> 
 <div title="信息查询" > 
    <form id="searchform" method="POST" class="query-form" >
	<ul class="searchform">
			<li class="li-input"><label for="" class="input-label">日志一级分类：</label>
				<input class="myinput" id="log_type" name="log_type"></input>
			</li>
			<li class="li-input"><label for="" class="input-label">日志二级分类：</label>
				<input class="myinput" id="log_sub_type" name="log_sub_type"></input>
			</li>	
			<li class="li-input"><label for="" class="input-label">操作人：</label>
				<input class="myinput" id="opername" name="opername"></input>
			</li>		
	</ul>
	</form>
	<div class="query-oper">
		<a href="#" class="easyui-linkbutton" onclick="commonObj.query('sologTableId','searchform')" id="submit_search" plain="true" iconCls="icon-search">查询</a>
	</div> 
 </div>
 </div>
 
<table id="sologTableId" style="width:100%"></table>
<div id="toolbarId">
</div>
</body>
<script type="text/javascript">
var basePath = $("#basePath").val();

var getTabDataUrl = basePath+"/system/common/sysOperLogController.do";
getTabDataUrl ='<c:url value="'+getTabDataUrl+'"/>?method=sysOperLogList';

commonObj.initDictCombobox("log_type","LOG_TYPE",null,false,true);
commonObj.initDictCombobox("log_sub_type","LOG_SUB_TYPE",null,false,true);
</script>
</html>