<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<script type="text/javascript">
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
	 var _url =basePath + "/authentication/tabResource.do?method=initEditResourceConfig&roleUuid=" + _roleUuid;
	 $.ajax({  
	        async : false,  
	        cache:false,  
	        type: 'GET',  
	        dataType : "json",  
	        url: _url,
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



