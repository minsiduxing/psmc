<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Expires" content="0">
<meta http-equiv="kiben" content="no-cache">

<%@ page isELIgnored="false"%>
<%@ taglib  uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
<%@ taglib  uri="http://prvi.guochun.com/mytag" prefix="g" %>  
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>  
	
	
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/zTree_v3-master/css/zTreeStyle/zTreeStyle${csssuffix}" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/publish${csssuffix}" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/zTree_v3-master/js/jquery.ztree.core${jssuffix}"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/zTree_v3-master/js/jquery.ztree.excheck${jssuffix}"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/zTree_v3-master/js/jquery.ztree.exedit${jssuffix}"></script>
	
	

<script type="text/javascript">
var basePath = '<%=request.getContextPath()%>';
var _chkStyle = "<%=request.getParameter("chkStyle").toString()%>";
var _rootPId = "<%=request.getParameter("rootPId").toString()%>";
var asyncLoadUrl =basePath+"/system/common/cityController.do";
asyncLoadUrl ='<c:url value="'+asyncLoadUrl+'"/>?method=getRegionJson';
var treeObj;
var setting = {
		view: {
			selectedMulti: false,
		},
		check: {
			enable: true,
			chkStyle: _chkStyle,
			chkboxType: { "Y": "p", "N": "p" },
			radioType: "all"	
		},
		data: {
			simpleData: {
				enable: true,
				idKey: "ID",
				pIdKey: "PID",
				rootPId: _rootPId
			},
			key:{
				name:"NAME",
			},
		},
		async: {
			enable: true,
			type : "get",
			url: asyncLoadUrl,
			autoParam: ["ID=cityId"]
		}
	};

 		
$(document).ready(function(){
	 var initTreeUrl =basePath+"/system/common/cityController.do";
	 initTreeUrl ='<c:url value="'+initTreeUrl+'"/>?method=initRegion&cityId='+_rootPId;
	 $.ajax({  
	        async : false,  
	        cache:true,  
	        type: 'get',  
	        dataType : "json",  
	        url: initTreeUrl,
	        success:function(data){
	        	treeObj = $.fn.zTree.init($("#regionTree"), setting, data); 
	        }  
	    });  
});

</script>

<!-- 属地控件的Div -->
<div id="regionTreeDiaLog"></div>


<ul id="regionTree" class="ztree"></ul>


