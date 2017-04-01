<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="../../../common.jsp"%>
<title>系统资源树</title>
<script type="text/javascript">
var basePath = $("#basePath").val();
var sysResourceTree;
var sysResourceTreePanel;
var setting = {
		data:{
			simpleData:{
				enable:true,
				idKey:"UUID",
				pIdKey:"PARENT_RESOURCE_UUID"
			},
			key:{
				name:"RESOURCE_NAME",
			}
		},
		edit:{
			enable:true,
			showRemoveBtn: false,
			showRenameBtn: false,
			drag:{
				isCopy:false,
				isMove:true,
				prev:false,
				next:false,
				inner:true
			}
		},
		view:{
			selectedMulti:false
			
		},
		callback:{
			//用于捕获节点被拖拽之前的事件回调函数，并且根据返回值确定是否允许开启拖拽操作
			beforeDrag:ZbeforeDrag,
			//用于捕获节点拖拽操作结束之前的事件回调函数，并且根据返回值确定是否允许此拖拽操作
			beforeDrop:ZbeforeDrop,
			//
			beforeRename: zTreeBeforeRename	
		}
	};

	function zTreeBeforeRename(treeId, treeNode, newName, isCancel) {
		var result = false;
		if(!isCancel){
			var data = {"resourceUuid":treeNode.UUID,"newName":newName};
			var _url=basePath + "/authentication/tabResource.do?method=ajaxUpdateResourceTheName";
			$.ajax({
				async:false,
				cache:false,
				type:'POST',
				dataType:"text",
				context:document.body,
				data:data,
				url:_url,
				success:function(data){
					result = commonObj.showResponse(data,updateNameSucFunc);
				},
				error:function (XMLHttpRequest, textStatus, errorThrown) {
					commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
				}
			});
		}else{
			result=true;
		}
		return result;
		
		
	}
	
	function ZbeforeDrag(treeId, treeNodes) {
		var uuid = treeNodes[0].RESOURCE_TYPE;
		if(uuid == 'e51a8663876f4a3394bb194d89d96735'){
			commonObj.alert("根节点不能拖拽!","warning");
			return false;
		}
		return true;
	}
	
	function ZbeforeDrop(treeId, treeNodes, targetNode, moveType) {
		if(targetNode == null){
			commonObj.alert("不能生成新的根节点!","warning");
			return false;
		}
		var dragedNodeParentUuid  = treeNodes[0].PARENT_RESOURCE_UUID;
		var tagetNodeUuid = targetNode.UUID;
		if(dragedNodeParentUuid == tagetNodeUuid){
			return false;
		}
		var result = false;
		var _url=basePath + "/authentication/tabResource.do?method=ajaxUpdateResourceTheParentUuid";
		var data ={resourceUuid:treeNodes[0].UUID,parentResourceUuid:tagetNodeUuid};
		$.ajax({
			async:false,
			cache:false,
			type:'POST',
			dataType:"text",
			context:document.body,
			data:data,
			url:_url,
			success:function(data){
				result = commonObj.showResponse(data,updateNameSucFunc);
			},
			error:function (XMLHttpRequest, textStatus, errorThrown) {
				commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
			}
		});
		return result;
	}

	var newNodes;
	var node;
	//添加成功回调函数
	function addSucFunc(data){
		var dataObj = JSON.parse(data);
		if(dataObj.id){
			newNodes[0].UUID=dataObj.id;
			sysResourceTree.addNodes(node, newNodes);
		}
	}
	//删除成功回调函数
	function delSucFunc(data){
		var dataObj = JSON.parse(data);
		if(dataObj.res=='success'){
			sysResourceTree.removeNode(node);
		}
		if(dataObj.res=='fail'){
			commonObj.alert(dataObj.rmsg,"warning");
		}
	}

	//修改成功回调函数
	function updateNameSucFunc(data){
		var dataObj = JSON.parse(data);
		if(dataObj.res=='success'){
			return true;
		}else
			return false;
	}

function initoperatePanel(){
	var toolsObj = [];
	var length = toolsObj.length;
	if(commonObj.isAuth("<%=OperateContantsUtil.RESOURCE_ADD%>")){
		toolsObj[length] = {
				iconCls:'icon-add',
				handler:function(){
					var selectNodes = sysResourceTree.getSelectedNodes();
					if(selectNodes.length<1){
						commonObj.alert("未选择父节点,无法添加资源菜单!","warning");
					}		
					node = selectNodes[0];
					newNodes = [{
							RESOURCE_NAME:"新节点",
							RESOURCE_URL:"/welcome.jsp",
							PARENT_RESOURCE_UUID:node.UUID}];

					var _url=basePath + "/authentication/tabResource.do?method=ajaxAddResource";
					var data ={
								resourceName:newNodes[0].RESOURCE_NAME,
								parentResourceUuid:newNodes[0].PARENT_RESOURCE_UUID,
								resourceUrl:newNodes[0].RESOURCE_URL};
					$.ajax({
						async:false,
						cache:false,
						type:'POST',
						dataType:"text",
						context:document.body,
						data:data,
						url:_url,
						success:function(data){
							commonObj.showResponse(data,addSucFunc);
						},
						error:function (XMLHttpRequest, textStatus, errorThrown) {
							commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
						}
					});
				}
			};
		length++;
	 };

	 if(commonObj.isAuth("<%=OperateContantsUtil.RESOURCE_UPDATE%>")){
			toolsObj[length] = {
					iconCls:'icon-edit',
					handler:function(){
						var selectNodes = sysResourceTree.getSelectedNodes();
						if(selectNodes.length!=1){
							commonObj.alert("请选择待修改的节点!","warning");
							return;
						}
						node = selectNodes[0];
						sysResourceTree.editName(node);
					}
				};
			length++;
	 };

	 if(commonObj.isAuth("<%=OperateContantsUtil.RESOURCE_DEL%>")){
			toolsObj[length] = {
					iconCls:'icon-remove',
					handler:function(){
						var selectNodes = sysResourceTree.getSelectedNodes();
						if(selectNodes.length<1){
							commonObj.alert("请选择待删除的节点!","warning");
							return;
						}		
						node = selectNodes[0];
						if(node.isParent){
							commonObj.alert("该节点下存在子节点,请先删除子节点!","warning");
							return;
						}
						if(node.RESOURCE_TYPE == 1){
							commonObj.alert("不能删除根节点!","warning");
							return;
						}
						var data ={resourceUuid:node.UUID};
						var _url=basePath + "/authentication/tabResource.do?method=ajaxDeleteResource";
						$.ajax({
							async:false,
							cache:false,
							type:'POST',
							dataType:"text",
							context:document.body,
							data:data,
							url:_url,
							success:function(data){
								commonObj.showResponse(data,delSucFunc);
							},
							error:function (XMLHttpRequest, textStatus, errorThrown) {
								commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
							}
						});
					}
				};
			length++;
	 };
	 
	sysResourceTreePanel = $('#sysResourceTreePanelDiv').panel({
		  cache:true,
		  width:"400px",
		  height:"600px",
		  title:"系统资源树",
		  fit:false,
		  tools:toolsObj
	});   
}



$(document).ready(function(){
	 initoperatePanel();  
	 var _url =basePath + "/authentication/tabResource.do?method=getSysResouceTreeData";
	 $.ajax({  
	        async:false,  
	        cache:false,  
	        type:'GET',  
	        dataType:"json",  
	        url:_url,
	        success:function(data){
	        	sysResourceTree = $.fn.zTree.init($("#sysResourceTree"), setting, data); 
	        	sysResourceTree.expandAll(true);
		     }  
	    });	 
});

</script>
</head>
<body id="body">
<div id="sysResourceTreePanelDiv">
	<ul id="sysResourceTree" class="ztree"></ul>
</div>

</body>
</html>





