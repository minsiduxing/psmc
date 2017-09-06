$(document).ready(function(){ 
	//new datagrid 初始化 
	var option = {
		tabId:"newsTableId",
		toolbar:"toolbarId",
		url:getNewsDataUrl,
		columns:[[   
		          /**
		           * 可以解决表格右边空白的问题，但是没办法自适应浏览器大小，暂时不用
		           * width:parseInt($(this).width()*0.3)
		           */
		          {field:'UUID',title:'账号唯一ID',checkbox:true},
		          {field:'ACCOUNT_NAME',title:'账号名称'},    
		          {field:'ISLOCKEDNAME',title:'是否锁定'},  
		          {field:'PERSON_NAME',title:'姓名'}, 
		          {field:'SEXNAME',title:'性别'}, 
		          {field:'AGE',title:'年龄'}, 
		          {field:'TELEPHONE',title:'手机号'}, 
		          {field:'EMAIL',title:'Email',resizable:true}
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
			editdialog.panel({title:"修改"});
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