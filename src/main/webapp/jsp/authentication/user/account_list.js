
var editdialog;

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
//表单提交成功后的回调方法
function successCallback(data){
	$.messager.progress("close");
	$("#accountTableId").datagrid('reload');
	commonObj.showResponse(data);
}

//密码md5加密
function convertMd5(){
	//编辑时不能修改密码
	if($('#accountPass').attr("type")!="hidden"){
		//当密码不为空的时候再加密
		var accoutPass = $('#accountPass').textbox('getValue');
		if(accoutPass!=''&&accoutPass!=null && accoutPass!='undefined'){
			$('#accountPass').textbox('setValue',hex_md5(accoutPass));
		}
	}
}

//表单dialog初始化方法
function initDialog(){
	editdialog = $("#editdialogDiv").dialog({
		modal: true,
		closed: true,
	    width: 635,
	    height: 480,
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
					convertMd5();
					$('#editForm').submit(); 
					//$("#editdialogDiv").dialog('close');
			}
		}]
		
	});
}

$(document).ready(function(){ 
	var option = {
		tabId:"accountTableId",
		toolbar:"toolbarId",
		url:getTabDataUrl,
		columns:[[   
		          /**
		           * 可以解决表格右边空白的问题，但是没办法自适应浏览器大小，暂时不用
		           * width:parseInt($(this).width()*0.3)
		           */
		          {field:'UUID',align:'center',title:'账号唯一ID',checkbox:true},
		          {field:'ACCOUNT_NAME',align:'center',title:'账号名称',width:$(this).width() * 0.2},
		          {field:'ISLOCKEDNAME',align:'center',title:'是否锁定',width:$(this).width() * 0.2},
		          {field:'PERSON_NAME',align:'center',title:'姓名',width:$(this).width() * 0.2},
		          {field:'SEXNAME',align:'center',title:'性别',width:$(this).width() * 0.2},
		          {field:'AGE',align:'center',title:'年龄',width:$(this).width() * 0.2},
		          {field:'TELEPHONE',align:'center',title:'手机号',width:$(this).width() * 0.2},
		          {field:'id_card',align:'center',title:'身份证号',width:$(this).width() * 0.2},
		          {field:'area',align:'center',title:'所在地区',width:$(this).width() * 0.2},
		          {field:'authTypeName',align:'center',title:'实名认证方式',width:$(this).width() * 0.2},
		          {field:'GROUP_CODE',align:'center',title:'隶属组编码',width:$(this).width() * 0.2},
		          {field:'GROUP_NAME',align:'center',title:'隶属组名称',width:$(this).width() * 0.2},
		          {field:'EMAIL',align:'center',title:'Email',resizable:true,width:$(this).width() * 0.2},
		          {field:'ACCOUNT_TYPE_NAME',align:'center',title:'账户类型',width:$(this).width() * 0.2}
		         ] 
		      ]
	};
	//初始化用户信息列表
	commonObj.initPaginationGrid(option);
	$("#add").click(function(){
		
		if(!editdialog){
			initDialog();
		}
		editdialog.panel({align:'center',title:"新增"});
		editdialog.panel({iconCls:'icon-save'});
		editdialog.panel({href:addAccountUrl});
		editdialog.window("open");
	});
	
	$("#edit").click(function(){
		var rows = $("#accountTableId").datagrid('getChecked');
		if (rows.length == 1){
			var rowObj = eval(rows[0]);
			var ACC_UUID = rowObj.ACC_UUID;
			var _url = editAccountUrl+"&uuid="+ACC_UUID;
			if(!editdialog){
				initDialog();
			}
			editdialog.panel({align:'center',title:"修改"});
			editdialog.panel({iconCls:'icon-edit'});
			editdialog.panel({href:_url});
			editdialog.window("open");
			
		}else{
			commonObj.alert("请选择一条记录!","warning");
		}
	});
	
	$("#remove").click(function(){
		
		var rows = $("#accountTableId").datagrid('getChecked');
		var rlength = rows.length;
		var ids="";
		if (rlength > 0){
			for(var i=0;i<rlength;i++){
				var rowObj = eval(rows[i]);
				var ACC_UUID = rowObj.ACC_UUID;
				ids+=ACC_UUID;
				if(i<rlength-1)
					ids+=",";
			}
			$.messager.confirm('提示', '该操作不可逆，您确认删除该用户账户信息?', function(r){
				if (r){
					var _url = removeAccountUrl+"&uuids="+ids;
					$.messager.progress(); 
					$.ajax({
						   type: "POST",
						   url: _url,
						   success: function(data){
							   successCallback(data);
						   },
						   error:function(XMLHttpRequest, textStatus, errorThrown){
							   commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
						   }
						});
				}
			});
			
		}else{
			commonObj.alert("请选择至少一条记录!","warning");
		}
		$.messager.progress("close");
		
	});
	
});




