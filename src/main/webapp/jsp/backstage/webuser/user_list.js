var editdialog;

$(document).ready(function(){ 
	var option = {
		tabId:"webUserTableId",
		toolbar:"toolbarId",
		url:getTabDataUrl,
		columns:[[   
		          {field:'UUID',title:'账号唯一ID',checkbox:true},
		          {field:'USER_ID',title:'用户账号'},    
		          {field:'PASSWORD',title:'密码',hidden:true},  
		          {field:'USER_NAME',title:'用户姓名'}, 
		          {field:'ID_CARD',title:'身份证'}, 
		          {field:'PHONE',title:'手机号码'}
		         ] 
		      ]
	};
	//初始化用户信息列表
	commonObj.initPaginationGrid(option);
	
	$("#add").click(function(){
			
			if(!editdialog){
				initDialog();
			}
			editdialog.panel({title:"新增"});
			editdialog.panel({iconCls:'icon-save'});
			editdialog.panel({href:addUserUrl});
			editdialog.window("open");
		});
});

//表单dialog初始化方法
function initDialog(){
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
					    url:saveAccountUrl,    
					    onSubmit: function(){
					    	return onSubmit();
					    },    
					    success:function(data){
					    	successCallback(data);
					    }
					}); 
					$('#editForm').submit(); 
			}
		}]
		
	});
}