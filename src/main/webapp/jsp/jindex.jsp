<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<%@ include file="../common.jsp"%>
<title>欢迎访问后台管理系统</title>

</head>
<body class="easyui-layout"style="margin-left:0.5%;margin-right:0.5%">
	<div id="sysTopDiv" data-options="region:'north',title:'',split:true" style="height:5%;">
			<div class="title" title="title">尊敬的用户：<c:out value='${user.accountName}'/>，欢迎您登入系统</div>
			<div class="title" title="title"><a id="updatePasswd">修改密码</a></div>
			<div class="title" title="title"><a id="logOut">退出登录</a></div>
	</div>	
	
    <div id="sysFootDiv" data-options="region:'south',title:'',split:true" style="height:5%;">
    </div>
    
    <div id="sysLeftDiv" data-options="region:'west',title:'菜单栏',split:true" style="width:16%;" >
		<div id="navigationId" fit="true" class="easyui-accordion"></div>
	</div>
    
    <div id="sysFunctionDiv" data-options="region:'center',title:'功能区'" style="width:83%;" >
    	<div id="sysFunctionTabs"  class="easyui-tabs" style="width:100%;height:99%;"></div>
    </div>
</body>

<script type="text/javascript">
var basePath = $("#basePath").val();
var roleUuid = "<c:out value='${user.roleUuid}'/>";
$(document).ready(function(){     
	//初始化菜单栏
	initSysLeftDiv();
	//初始化功能栏
	initsysFunctionDiv();
});

//退出登录操作 add by yangqing 2017-4-8
$('#logOut').click(function (){
	var url = "<c:url value='/logOut'/>";
	$.messager.confirm('提示', '您确定退出登录?', function(r){
		if (r){
			window.location = url;
		}
	});
});

//修改密码操作 add by yangqing 2017-4-8
$('#updatePasswd').click(function(){
	addTab("修改密码页面","<c:url value='/jsp/updatePasswd.jsp'/>");
});

function initsysFunctionDiv(){
	addTab("欢迎页面","");
}

function addTab(title, url){
	if ($('#sysFunctionTabs').tabs('exists', title)){
		$('#sysFunctionTabs').tabs('select', title);
	} else {
		var content = '<iframe scrolling="auto" frameborder="0"  src="'+url+'" style="width:100%;height:99%;"></iframe>';
		$('#sysFunctionTabs').tabs('add',{
			title:title,
			content:content,
			closable:true
		});
	}
}


function initSysLeftDiv(){
	//动态创建加载导航栏
	var url = basePath+'/authentication/loginController.do';
	url ='<c:url value="'+url+'"/>';
	url +='?method=getNavigationBarResources&roleUuid='+roleUuid;
    $.ajax({
		   type: "GET",
		   url: url,
		   success: function(data){
		     var navigations = JSON.parse(data).listArray;
		     for(var i=0;i<navigations.length;i++){
		    	 var panelId = "navigationPanelId"+i;
		    	 var treeId = "navigationTreeId"+i;
		    	 var panelName= navigations[i].RESOURCE_NAME;
		    	 var option={
		    			id:panelId,
		    			treeId:treeId,
		    			selected:i==0?true:false,
		    			title:panelName,
		    			uuid:navigations[i].UUID,
		    			iconCls:'icon-reload',
		    			content:'<ul id="'+treeId+'" class="ztree"></ul>'	
		    	};
				$('#navigationId').accordion('add',option);
		     }
		   }
		});
   
    	
		$('#navigationId').accordion({   
			//导航栏面板被选择时的触发方法
			onSelect:function(title, index)
		    {
		        var panel = $('#navigationId').accordion('getSelected');
		        if (panel)
		        {
		        	//初始化树 默认将当前导航栏作为 该模块的root节点，树的其余节点通过onclick事件动态添加
		        	var treeId = panel.panel("options").treeId;
		            var uuid = panel.panel("options").uuid;
		            var url = basePath+'/authentication/loginController.do';
		        	url ='<c:url value="'+url+'"/>';
					url +='?method=initNavigationBarTree&roleUuid='+roleUuid+'&resourceId='+uuid;
					
		            var treeObj = $.fn.zTree.getZTreeObj(treeId);
		        	if(treeObj){
		        		return;
		        	}
		        	
		        	var setting = { 
		        			view: {
	        					selectedMulti: false
	        				},
		        			data: {
		        				simpleData: {
		        					enable : true,              
		        				    idKey : "ID",                 
		        				    pIdKey : "PID",        
		        				    rootPId:uuid
		        				},
		        				key: {
		        					name: "RESOURCE_NAME"
		        				},
		        				keep: {
		        					parent:true
		        				}
		        			},
		        			callback: {
	        					onClick: zTreeOnClick,
	        					onExpand:zTreeOnExpand,
	        					onCollapse:zTreeonCollapse,
	        					beforeClick:zTreebeforeClick
	        				}
		        		}; 
		    	    
		            $.ajax({  
		    	        async : false,  
		    	        cache:false,  
		    	        type: 'GET',  
		    	        dataType : "json",  
		    	        url: url,
		    	        success:function(data){
		    	        	$.fn.zTree.init($("#"+treeId), setting, data); 
		    	        },
		    	        error:function (XMLHttpRequest, textStatus, errorThrown) {
							commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
						}  
		    	    });  

		    		function zTreebeforeClick(treeId, treeNode) {
		    			if (!treeNode.isParent) {
		    				return true;
		    			} else {
		    				//如果返回false，则不调用zTreeOnClick
		    				return false;
		    			}
		    		}
		    		
		            function zTreeOnClick(event, treeId, treeNode) {
		            	var url = basePath+treeNode.RESOURCE_URL;
		            	url ='<c:url value="'+url+'"/>';
		            	var name = treeNode.RESOURCE_NAME;
		            	addTab(name,url);
		    		};
		    		
		    		function zTreeOnExpand(event, treeId, treeNode) {
		    			var treeObj = $.fn.zTree.getZTreeObj(treeId);
		    			var roleUuid = treeNode.ROLE_ID;
		    			var uuid = treeNode.UUID;
		    			var url = basePath+'/authentication/loginController.do';
		    			url ='<c:url value="'+url+'"/>';
		    			url+='?method=getSubResoruces&roleUuid='+roleUuid+'&resourceId='+uuid;
			        	

		    			$.ajax({  
			    	        async : false,  
			    	        cache:false,  
			    	        type: 'GET',  
			    	        dataType : "json",  
			    	        url: url,
			    	        success:function(data){
			    	        	newNode = treeObj.addNodes(treeNode, data);
			    	        } ,
			    	        error:function (XMLHttpRequest, textStatus, errorThrown) {
								commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
							}  
			    	    }); 
			    	};
			    	
			    	function zTreeonCollapse(event, treeId, treeNode) {
			    		var treeObj = $.fn.zTree.getZTreeObj(treeId);
			    		treeObj.removeChildNodes(treeNode);
			    	};
		        }
		    }
		});
}
</script>
</html>
