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
		},
		callback: {
			onCheck: zTreeOnCheck
		}
	};
var treeObj;
var operatePanel;
var privilegDataList;



//节点选中时的触发事件
function zTreeOnCheck(event, treeId, treeNode) {
	var resourceUuid = treeNode.UUID;
	var resourceName = treeNode.RESOURCE_NAME;
	var _url =basePath + "/authentication/tabResource.do";
	 _url = '<c:url value="'+_url+'"/>?method=getPrivilegDataListByRoleAndResource'; 	 
	 _url+="&roleUuid="+_roleUuid+"&resourceUuid="+resourceUuid;
	 	if(privilegDataList != undefined){
	 		 	//重置面板内容
	 			operatePanel.panel("clear");
	 			operatePanel.panel({content:'<ul id="privilegListUl"></ul>'});
	 			operatePanel.panel("refresh");
	 	 }
	 	 
		 privilegDataList = $('#privilegListUl').datalist({ 
			    url:_url, 
			    fit:true,
			    cache:true,
			    method:"get",
			    rownumbers:true,
			    checkbox:true, 
			    lines:true,
			    singleSelect:false,
			    idField:"OPERATE_UUID",
			    valueField:"OPERATE_UUID",
			    textField:"OPERATE_NAME",
			    onLoadSuccess:function(data){
				    if(data == null || data.total ==0){
				    	commonObj.alert("当前角色下此资源["+resourceName+"]下无操作项!","warning");
					}
				  	var dataArr = Array.prototype.slice.call(data.rows); 
				    for(var i=0;i<dataArr.length;i++){
				    	var dataRow = dataArr[i];
				    	var OPERATE_UUID = dataRow.OPERATE_UUID;
				    	var CHECKED = dataRow.CHECKED;
				    	if(CHECKED ==="true")
				    	privilegDataList.datagrid("selectRecord",OPERATE_UUID);
				    }
				 }
			});  
	
	};

	



function initoperatePanel(){
	operatePanel = $('#operateDiv').panel({    
		  width:"100%",    
		  height:"100%",    
		  title: '资源操作项',    
		  content:'<ul id="privilegListUl"></ul>',
		  closable:false,
		  cache:true,
		  tools: [{    
		    iconCls:'icon-save',    
		    handler:function(){
		    	var resourceNode = treeObj.getCheckedNodes(true)[0];
				var resourceUuid = resourceNode.UUID;
				var resourceName = resourceNode.RESOURCE_NAME;
		    	var resourceType = resourceNode.RESOURCE_TYPE;
		    	if(resourceType!=3){
		    		commonObj.alert("当前角色下此资源["+resourceName+"]下无操作项!","warning");
		    		return;
		    	}
		    	var operateArr = privilegDataList.datagrid("getChecked");
		    	var operate_uuids = "";
		    	var operate_length = operateArr.length;
		    	if(operate_length<1){
		    		commonObj.alert("未勾选此资源["+resourceName+"]下的操作项或此资源下无操作项!","warning");
		    		return;
		    	}
		    	for(var i=0;i<operate_length;i++){
		    		if(i<(operate_length-1))
		    			operate_uuids += operateArr[i].OPERATE_UUID+",";
		    		else
		    			operate_uuids += operateArr[i].OPERATE_UUID;
		    	}
		    	var editUrl = basePath + "/authentication/tabResource.do";
		    	editUrl = '<c:url value="'+editUrl+'"/>?method=editRoleResourceOperateRelations'; 
	    		editUrl +="&roleUuid="+_roleUuid+"&resourceUuid="+resourceUuid+"&operate_uuids="+operate_uuids;
		    			 
			    $.ajax({  
		 	        async : false,  
		 	        cache:false,  
		 	        type: 'POST',  
		 	        dataType : "text",  
		 	        url: editUrl,
		 	        success:function(data){
		 	        	commonObj.showResponse(data);
		 	        },
		 	        error: function(XMLHttpRequest, textStatus, errorThrown) {
	                    commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
	                }
		 	        
		 	    }); 
		    }    
		  }]    
		});   
}


 		
$(document).ready(function(){
	 var _url =basePath + "/authentication/tabResource.do";
	 _url = '<c:url value="'+_url+'"/>?method=getResourceTreeByRoleUuid&roleUuid='+_roleUuid; 
	 $.ajax({  
	        async : false,  
	        cache:false,  
	        type: 'GET',  
	        dataType : "json",  
	        url: _url,
	        success:function(data){
	        	treeObj = $.fn.zTree.init($("#regionTree"), setting, data); 
	        	treeObj.expandAll(true);
	        }  
	    });  
	 initoperatePanel();
});

</script>
<div id="resourcePrivilegDiv" class="easyui-layout" style="width:100%;height:100%;">   
    <div data-options="region:'west',title:'角色资源树',split:true" style="width:40%;">
    	<ul id="regionTree" class="ztree"></ul>
    </div>   
    
    <div data-options="region:'center'">
    	<div id="operateDiv">
    		
    	</div>
    </div>   
</div>  

