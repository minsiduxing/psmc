<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../../common.jsp"%>

<script type="text/javascript">
var _chkStyle = "<%=request.getParameter("chkStyle").toString()%>";
var _rootPId = "<%=request.getParameter("rootPId").toString()%>";
var asyncLoadUrl =basePath+"/system/common/cityController.do";
asyncLoadUrl ='<c:url value="'+asyncLoadUrl+'"/>?method=getRegionJson&cityId='+_rootPId;
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
			autoParam: ["ID=id"]
		}
	};

 		
$(document).ready(function(){
	 var initTreeUrl =basePath+"/system/common/cityController.do";
	 initTreeUrl ='<c:url value="'+initTreeUrl+'"/>?method=initRegion&cityId='+_rootPId;
	 alert(initTreeUrl);
	 $.ajax({  
	        async : false,  
	        cache:false,  
	        type: 'POST',  
	        dataType : "json",  
	        url: initTreeUrl,
	        success:function(data){
	        	treeObj = $.fn.zTree.init($("#regionTree"), setting, data); 
	        }  
	    });  
});

</script>
<ul id="regionTree" class="ztree"></ul>


