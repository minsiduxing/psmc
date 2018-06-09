<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="../../../common.jsp"%>
<title>组织机构资源树</title>


<script type="text/javascript">
var basePath = $("#basePath").val();

var addResourcetUrl = basePath+"/authentication/tabGroupController.do";
addResourcetUrl ='<c:url value="'+addResourcetUrl+'"/>?method=initEdit&oper=save';

var editResourcetUrl = basePath+"/authentication/tabGroupController.do";
editResourcetUrl ='<c:url value="'+editResourcetUrl+'"/>?method=initEdit&oper=edit';

var saveResourcetUrl = basePath + "/authentication/tabGroupController.do";
saveResourcetUrl ='<c:url value="'+saveResourcetUrl+'"/>?method=saveOrUpdateGroup';

var sysResourceTree;
var sysResourceTreePanel;
var editdialog; //资源添加弹出框
var operateConfigDialog;//操作配置弹出框
var setting = {
		data:{
			simpleData:{
				enable:true,
				idKey:"group_code",
				pIdKey:"parent_group_code"
			},
			key:{
				name:"group_name",
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
			beforeDrop:ZbeforeDrop
		}
	};

	function ZbeforeDrag(treeId, treeNodes) {
		var group_type = treeNodes[0].group_type;
		if(group_type == '1' || group_type == '2'){
			commonObj.alert("单位节点不能拖拽!","warning");
			return false;
		}
		return true;
	}
	
	function ZbeforeDrop(treeId, treeNodes, targetNode, moveType) {
		if(targetNode == null){
			commonObj.alert("不能生成新的根节点!","warning");
			return false;
		}
		var dragedNodeParentGroupCode  = treeNodes[0].parent_group_code;
		var tagetNodeGroupCode = targetNode.group_code;
		if(dragedNodeParentGroupCode == tagetNodeGroupCode){
			return false;
		}

		var result = false;
		var _url=basePath + "/authentication/tabGroupController.do";
		_url ='<c:url value="'+_url+'"/>?method=ajaxUpdateGroupTheParentGroupCode';
		//传递当前组code 和拖拽后的上级组code
		var data ={groupCode:treeNodes[0].group_code,parentGroupCode:tagetNodeGroupCode};
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
				$.messager.progress("close");
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
		var dataObj = JSON.parse(data);
		if(dataObj.result.flag !='1'){
			commonObj.alert("修改失败!","warning");
			return false;
		}
		commonObj.alert("修改成功!","warning");
		
		var sysResourceTree = $.fn.zTree.getZTreeObj("sysResourceTree");
		var newNode = {uuid:dataObj.data.uuid,
						group_code:dataObj.data.groupCode,
						group_name:dataObj.data.groupName,
						parent_group_code:dataObj.data.parentGroupCode};
		var parentNode = sysResourceTree.getNodeByParam("group_code", dataObj.data.parentGroupCode, null);
		sysResourceTree.addNodes(parentNode, newNode, true);
		$("oper").val("edit");
	}
	
	//删除成功回调函数
	function delSucFunc(data){
		$.messager.progress("close");
		var dataObj = JSON.parse(data);
		if(dataObj.result.flag =='1'){
			alert_autoClose("提示","删除成功!","info");
			sysResourceTree.removeNode(node);
		}
		if(dataObj.result.flag !='1'){
			commonObj.alert("删除失败!","warning");
		}
	}

	//修改成功回调函数
	function updateNameSucFunc(data){
		$.messager.progress("close");
		var dataObj = JSON.parse(data);
		console.info(dataObj);
		if(dataObj.result.flag !='1'){
			commonObj.alert("修改失败!","warning");
			return false;
		}
		var groupCode = dataObj.data.groupCode;
		var groupName = dataObj.data.groupName;
		var sysResourceTree = $.fn.zTree.getZTreeObj("sysResourceTree");
		var thisNode = sysResourceTree.getNodeByParam("group_code", groupCode, null);
		thisNode.group_name = groupName;
		sysResourceTree.updateNode(thisNode); 
		alert_autoClose("提示","修改成功!","info");
		return true;
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
	if(commonObj.isAuth("<%=OperateContantsUtil.USER_GROUP_ADD%>")){
		toolsObj[length] = {
				iconCls:'icon-add',
				handler:function(){
					var selectNodes = sysResourceTree.getSelectedNodes();
					if(selectNodes.length<1){
						commonObj.alert("未选择父节点,无法添加资源菜单!","warning");
					}
					node = selectNodes[0];
					var url = "";
					url = addResourcetUrl + '&parentGroupCode=' + node.group_code;
					initResourceDialog(addSucFunc);
					editdialog.panel({title:"新增"});
					editdialog.panel({iconCls:'icon-save'});
					editdialog.panel({href:url});
					editdialog.window("open");
					
				}
			};
		length++;
	 };

	 //修改资源节点信息
	 if(commonObj.isAuth("<%=OperateContantsUtil.USER_GROUP_UPDATE%>")){
			toolsObj[length] = {
					iconCls:'icon-edit',
					handler:function(){
						var selectNodes = sysResourceTree.getSelectedNodes();
						if(selectNodes.length!=1){
							commonObj.alert("请选择待修改的节点!","warning");
							return;
						}
						node = selectNodes[0];
						var url = "";
						url = editResourcetUrl + '&groupCode=' + node.group_code;
						initResourceDialog(updateNameSucFunc);
						editdialog.panel({title:"修改"});
						editdialog.panel({iconCls:'icon-save'});
						editdialog.panel({href:url});
						editdialog.window("open"); 
					}
				};
			length++;
	 };

	 //删除资源节点信息
	 if(commonObj.isAuth("<%=OperateContantsUtil.USER_GROUP_DEL%>")){
			toolsObj[length] = {
					iconCls:'icon-remove',
					handler:function(){
						$.messager.confirm('提示', '该操作不可逆，确认删除？', function(r){
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
								$.messager.progress(); 
								var data ={uuid:node.uuid};
								var _url=basePath + "/authentication/tabGroupController.do";
								_url ='<c:url value="'+_url+'"/>?method=delGroup';
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
										$.messager.progress("close");
										commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
									}
								});
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
		  title:"组织机构树",
		  fit:false,
		  tools:toolsObj
	});   
}



$(document).ready(function(){
	 initoperatePanel();  
	 var _url =basePath + "/authentication/tabGroupController.do";
	 _url ='<c:url value="'+_url+'"/>?method=initTabGroup';
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
function initResourceDialog(sucFunc){
	editdialog = $("#editdialogDiv").dialog({
		modal: true,
		closed: false,
	    width: 750,
	    height: 300,
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
					    	commonObj.showResponse(data,sucFunc);
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
<div id="operateConfigDialogDiv"></div>
</body>
</html>