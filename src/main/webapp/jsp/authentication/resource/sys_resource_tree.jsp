<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="../../../common.jsp"%>
<title>系统资源树</title>


<script type="text/javascript">
var basePath = $("#basePath").val();

var addResourcetUrl = basePath+"/authentication/tabResource.do";
addResourcetUrl ='<c:url value="'+addResourcetUrl+'"/>?method=initEdit&oper=save';

var editResourcetUrl = basePath+"/authentication/tabResource.do";
editResourcetUrl ='<c:url value="'+editResourcetUrl+'"/>?method=initEdit&oper=edit';

var saveResourcetUrl = basePath + "/authentication/tabResource.do";
saveResourcetUrl ='<c:url value="'+saveResourcetUrl+'"/>?method=edit';

var editOperateUrl = basePath + "/authentication/tabOperate.do";
editOperateUrl ='<c:url value="'+editOperateUrl+'"/>?method=operateList';

var sysResourceTree;
var sysResourceTreePanel;
var editdialog; //资源添加弹出框
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
			var _url=basePath + "/authentication/tabResource.do";
			_url ='<c:url value="'+_url+'"/>?method=ajaxUpdateResourceTheName';	
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
		var _url=basePath + "/authentication/tabResource.do";
		_url ='<c:url value="'+_url+'"/>?method=ajaxUpdateResourceTheParentUuid';
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
		$.messager.progress("close");
		alert_autoClose("提示","添加成功!","info");
		var sysResourceTree = $.fn.zTree.getZTreeObj("sysResourceTree");
		var dataObj = JSON.parse(data);
		var newNode = {UUID:dataObj.uuid,RESOURCE_NAME:dataObj.resourceName,PARENT_RESOURCE_UUID:dataObj.parentResourceUuid};
		var parentNode = sysResourceTree.getNodeByParam("UUID", dataObj.parentResourceUuid, null);
		sysResourceTree.addNodes(parentNode, newNode, true);
	}
	
	//删除成功回调函数
	function delSucFunc(data){
		var dataObj = JSON.parse(data);
		if(dataObj.res=='success'){
			alert_autoClose("提示","删除成功!","info");
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
			alert_autoClose("提示","修改成功!","info");
			return true;
		}else
			return false;
	}
	
	//2秒提示框
	function alert_autoClose(title,msg,icon){  
		 var interval;  
		 var time=1000;  
		 var x=2;    //设置时间2s
		$.messager.alert(title,msg,icon,function(){});  
		 interval=setInterval(fun,time);  
		        function fun(){  
		      --x;  
		      if(x==0){  
		          clearInterval(interval);  
		  $(".messager-body").window('close');    
		       }  
		}; 
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
					if(!editdialog){
						addResourcetUrl = addResourcetUrl + '&parentResourceUuid=' + node.UUID;
						initResourceDialog();
					}
					editdialog.panel({title:"新增"});
					editdialog.panel({iconCls:'icon-save'});
					editdialog.panel({href:addResourcetUrl});
					editdialog.window("open");
					
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
				 		if(!editdialog){
							editResourcetUrl = editResourcetUrl + '&id=' + node.UUID;
							initResourceDialog();
						}
						editdialog.panel({title:"修改"});
						editdialog.panel({iconCls:'icon-save'});
						editdialog.panel({href:editResourcetUrl});
						editdialog.window("open"); 
					}
				};
			length++;
	 };

	 if(commonObj.isAuth("<%=OperateContantsUtil.RESOURCE_DEL%>")){
			toolsObj[length] = {
					iconCls:'icon-remove',
					handler:function(){
						$.messager.confirm('提示', '确认删除?', function(r){
							if (r){
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
								var _url=basePath + "/authentication/tabResource.do";
								_url ='<c:url value="'+_url+'"/>?method=ajaxDeleteResource';
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
						});
					}
				};
			length++;
	 };
	 
	<%-- if(commonObj.isAuth("<%=OperateContantsUtil.RESOURCE_OPERATE%>")){ --%>
			toolsObj[length] = {
					iconCls:'icon-tip',
					handler:function(){
						var selectNodes = sysResourceTree.getSelectedNodes();
						if(selectNodes.length!=1){
							commonObj.alert("请选择需要配置的节点!","warning");
							return;
						}
						node = selectNodes[0];
				 		if(!editdialog){
				 			editOperateUrl = editOperateUrl + '&id=' + node.UUID;
				 			initOperateDialog();
						}
						editdialog.panel({title:"修改"});
						editdialog.panel({iconCls:'icon-save'});
						editdialog.panel({href:editOperateUrl});
						editdialog.window("open"); 
						//sysResourceTree.editName(node);
					}
				};
			length++;
/* /* 	  }; */ 
	 
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
	 var _url =basePath + "/authentication/tabResource.do";
	 _url ='<c:url value="'+_url+'"/>?method=getSysResouceTreeData';
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

//资源表单dialog初始化方法
function initResourceDialog(){
	editdialog = $("#editdialogDiv").dialog({
		modal: true,
		closed: false,
	    width: 705,
	    height: 280,
	    resizable:true,
	    cache: false,
	    buttons:[{
			text:'保存',
			iconCls:'icon-save',
			handler:function(){
					$('#editForm').form({    
					    url:saveResourcetUrl,    
					    onSubmit: function(){
					    	 return onSubmit();
					    },    
					    success:function(data){
					    	commonObj.showResponse(data,addSucFunc);
					    }
					}); 
					$('#editForm').submit();
					$("#editdialogDiv").dialog('close');
			}
		}]
	});
}

//业务配置表单dialog初始化方法
function initOperateDialog(){
	editdialog = $("#editdialogDiv").dialog({
		modal: true,
		closed: true,
	    width: 705,
	    height: 280,
	    resizable:true,
	    cache: false,
	    buttons:[{
			text:'保存',
			iconCls:'icon-save',
			handler:function(){
					$('#editForm').form({    
					    url:saveResourcetUrl,    
					    onSubmit: function(){
					    	 return onSubmit();
					    },    
					    success:function(data){
					    	addSucFunc(data);
					    }
					}); 
					$('#editForm').submit();
					$("#editdialogDiv").dialog('close');
			}
		}]
	});
}

//表单校验
function onSubmit(){
	debugger;
	var result = $('#editForm').form("validate");
	if(Boolean(result)){
		$.messager.progress(); 
		return true;
	}else{
		return false;
	}
}

</script>
</head>
<body id="body">
<div id="sysResourceTreePanelDiv">
	<ul id="sysResourceTree" class="ztree"></ul>
</div>
<div id="editdialogDiv"></div>
</body>
</html>





