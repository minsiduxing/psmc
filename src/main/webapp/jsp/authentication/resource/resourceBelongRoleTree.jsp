<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="priv.guochun.psmc.authentication.operate.OperateContantsUtil" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Expires" content="0">
<meta http-equiv="kiben" content="no-cache">

<%@ page isELIgnored="false"%>
<%@ taglib  uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
<%@ taglib  uri="http://prvi.guochun.com/mytag" prefix="g" %>  
<%@ taglib prefix='fmt' uri="http://java.sun.com/jsp/jstl/fmt" %>  

<script type="text/javascript">
var basePath = $("#basePath").val();
var _roleUuid = "<%=request.getParameter("roleUuid").toString()%>";
var _chkStyle = "<%=request.getParameter("chkStyle").toString()%>";
var _rootPId = "<%=request.getParameter("rootPId").toString()%>";
var treeObj;
var resourceBelongRolePanel;
var setting = {
		view: {
			selectedMulti: false
		},
		check: {
			enable: true,
			chkStyle: _chkStyle,
			chkboxType: { "Y": "ps", "N": "ps" },
			radioType: "all"
		},
		data: {
			simpleData: {
				enable: true,
				idKey: "UUID",
				pIdKey: "PARENT_RESOURCE_UUID",
				rootPId: _rootPId
			},
			key:{
				name:"RESOURCE_NAME",
			},
		}
	};

 		
$(document).ready(function(){
	 initoperatePanel();  
	 var initresourceBelongRoleTreeUrl =basePath + "/authentication/tabResource.do";
	 initresourceBelongRoleTreeUrl = '<c:url value="'+initresourceBelongRoleTreeUrl+'"/>?method=initEditResourceConfig&roleUuid='+_roleUuid;
	 $.ajax({  
	        async : false,  
	        cache:false,  
	        type: 'GET',  
	        dataType : "json",  
	        url: initresourceBelongRoleTreeUrl,
	        success:function(data){
	        	treeObj = $.fn.zTree.init($("#resourceBelongRoleTree"), setting, data); 
	        	treeObj.expandAll(true);
	        }  
	    });	 
});


function initoperatePanel(){
	resourceBelongRolePanel = $('#resourceBelongRoleDiv').panel({    
		  content:'<ul id="resourceBelongRoleTree" class="ztree"></ul>',
		  closable:false,
		  cache:true,
		  noheader:true,
		  fit:true
		});   
}

</script>
<div id="resourceBelongRoleDiv"></div>



