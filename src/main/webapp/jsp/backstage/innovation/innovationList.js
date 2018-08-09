$(document).ready(function(){ 
	//new datagrid 初始化 
	var innovationOption = {
		tabId:"innovationList",
		toolbar:"toolbarId",
		url:getInfoDataUrl,
		columns:[[   
		          /**
		           * 可以解决表格右边空白的问题，但是没办法自适应浏览器大小，暂时不用
		           * width:parseInt($(this).width()*0.3)
		           */
		          {field:'innovation_uuid',title:'创新主键标识',checkbox:true},
		          {field:'achievement_name',title:'成果名称',resizable:true,align:'center',sortable:true},    
		          {field:'org_name',title:'单位名称',resizable:true,align:'center',sortable:true}, 
		          {field:'declare_person',title:'申报人姓名',align:'center',sortable:true}, 
		          {field:'first_complete_person',title:'第一完成人',align:'center',sortable:true}, 
		          {field:'other_complete_person',title:'其他完成人',align:'center',sortable:true}, 
		          {field:'dept_name',title:'部门名称',resizable:true,align:'center',sortable:true}, 
		          {field:'innovation_date',title:'创新时间',align:'center',sortable:true}, 
		          {field:'achievement_form',title:'体现形式',align:'center',sortable:true,resizable:true,formatter:function(value, row, index){
		        	  if(value=='1'){return "创新技术、应用新技术成果";}
		        	  if(value=='2'){return "创新工艺、提出新的操作法";}
		        	  if(value=='3'){return "研发新工具、改造老设备";}
		          }},
		          {field:'audit',title:'审核状态',align:'center',sortable:true,formatter: function (value, row, index) {
                     if(value=='1'){return "审核通过"; }
                     if(value=='2'){return "未审核"; }
                     if(value=='3'){return "审核不通过"; }
                                                  
                  }},
		          {field:'auditAccName',title:'信息审核人',align:'center',sortable:true}, 
		          {field:'auditTime',title:'信息审核时间',resizable:true,align:'center',sortable:true}, 
		          {field:'release_status',title:'发布状态',align:'center',sortable:true,resizable:true,formatter: function (value, row, index) {
                     if(value=='2'){return "未发布"; }
                     if(value=='1'){return "已发布"; }
	                                                  
	              }},
		          {field:'releaseAccName',title:'信息发布人',align:'center',sortable:true}, 
		          {field:'release_date',title:'信息发布时间',align:'center',sortable:true}, 
		          {field:'publish_expire_date',title:'信息过期时间',align:'center',sortable:true}
		         ] 
		      ]
	};
	//初始化优秀创新列表
	commonObj.initPaginationGrid(innovationOption);
	//新增
	$("#add").click(function(){
		var _url = editInfoUrl+"&isEdit="+"add";
		window.location.href=_url;
		event.preventDefault();
	});
	
	//编辑
	$("#edit").click(function(){
		var rows = $("#innovationList").datagrid('getChecked');
		if (rows.length == 1){
			var rowObj = eval(rows[0]);
			if(rowObj.audit==1){
				commonObj.alert("该信息已经审核通过不能修改!","warning");
				return;
			}
			var uuid = rowObj.innovation_uuid;
			var _url = editInfoUrl+"&uuid="+uuid+"&isEdit="+"edit";
			window.location.href=_url;
		}else{
			commonObj.alert("请选择一条记录!","warning");
		}
		event.preventDefault();
	});
	
	//查看
	$("#priview").click(function(){
		var rows = $("#innovationList").datagrid('getChecked');
		if (rows.length == 1){
			var rowObj = eval(rows[0]);
			var uuid = rowObj.innovation_uuid;
			var _url = editInfoUrl+"&uuid="+uuid+"&isEdit="+"query";
			window.location.href=_url;
		}else{
			commonObj.alert("请选择一条记录!","warning");
			return;
		}
		event.preventDefault();
	});
	
	//删除
$("#remove").click(function(){
		var rows = $("#innovationList").datagrid('getChecked');
		var rlength = rows.length;
		var ids="";
		if (rlength > 0){
			for(var i=0;i<rlength;i++){
				var rowObj = eval(rows[i]);
				var newsid = rowObj.innovation_uuid;
				ids+=newsid;
				if(i<rlength-1)
					ids+=",";
			}
			$.messager.confirm('提示', '该操作不可逆，您确认删除选中信息?', function(r){
				if (r){
					var _url = removeInfo+"&uuids="+ids;
					$.messager.progress(); 
					$.ajax({
						   type: "POST",
						   url: _url,
						   success: function(data){
							   successCallback(data);
						   },
						   error:function(XMLHttpRequest, textStatus, errorThrown){
							   commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
							   $.messager.progress("close");
						   }
						});
				}
			});
			
		}else{
			commonObj.alert("请选择至少一条记录!","warning");
		}
		$.messager.progress("close");
		event.preventDefault();
	});
//审核
$("#auditNews").click(function(){
	var rows = $("#innovationList").datagrid('getChecked');
	var rlength = rows.length;
	var ids="";
	if (rlength > 0){		
		for(var i=0;i<rlength;i++){
			var rowObj = eval(rows[i]);
			var newsid = rowObj.innovation_uuid;
			var audit = rowObj.audit;
			var releasestatus = rowObj.release_status;
			if(audit==1){
				commonObj.alert('存在已经审核通过的信息!',"warning");
				return ;
			}
			if(releasestatus==1){
				commonObj.alert('存在已经发布的!,不能审核',"warning");
				return ;
			}
			ids+=newsid;
			if(i<rlength-1)
				ids+=",";
		}
		
		$.messager.confirm('提示', '确认选中的信息审核通过?', function(r){
			if (r){
			var _url = auditInfo+"&uuids="+ids;
			$.messager.progress(); 
			$.ajax({
				   type: "POST",
				   url: _url,
				   success: function(data){
					   successCallback(data);
				   },
				   error:function(XMLHttpRequest, textStatus, errorThrown){
					   commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
					   $.messager.progress("close");
				   }
				});
		
	}});
	}else{
		commonObj.alert('请至少选择一条信息!',"warning");
		return ;
	}
	$.messager.progress("close");
	event.preventDefault();
});

//发布
$("#releaseNews").click(function(){
	var rows = $("#innovationList").datagrid('getChecked');
	var rlength = rows.length;
	uuids="";
	if (rlength > 0){		
		for(var i=0;i<rlength;i++){
			var rowObj = eval(rows[i]);
			var newsid = rowObj.innovation_uuid;
			var audit = rowObj.audit;
			var releasestatus = rowObj.release_status;
		if(audit!=1){
			commonObj.alert('存在未审核或未审核通过的信息,不能发布!',"warning");
			return ;
		}
		if(releasestatus==1){
			commonObj.alert('选择的信息中存在发布过的信息!',"warning");
			return ;
		}
		uuids+=newsid;
		if(i<rlength-1)
			uuids+=",";
	  }
	$.messager.confirm('提示', '确认发布选择的信息吗?', function(r){
			if (r){
				    $('#dlg').dialog('open');				
			}
			
	    });
  }else{
		commonObj.alert('请至少选择一条信息!',"warning");
		return ;
	}
	$.messager.progress("close");
	event.preventDefault();
});

	//撤销
	$("#undo").click(function(){
		var rows = $("#innovationList").datagrid('getChecked');
		var rlength = rows.length;
		var ids="";
		if (rlength > 0){		
			for(var i=0;i<rlength;i++){
				var rowObj = eval(rows[i]);
				var innovationUuid = rowObj.innovation_uuid;
				var audit = rowObj.audit;
				if(audit==2){
					commonObj.alert('存在未审核的信息!',"warning");
					return ;
				}
				ids+=innovationUuid;
				if(i<rlength-1)
					ids+=",";
			}
			$.messager.confirm('提示', '确认选中的信息执行撤销操作吗?', function(r){
				if (r){
				var _url = executeUndo+"&innovationUuids="+ids;
				$.messager.progress(); 
				$.ajax({
					   type: "POST",
					   url: _url,
					   success: function(data){
						   successCallback(data);
					   },
					   error:function(XMLHttpRequest, textStatus, errorThrown){
						   commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
						   $.messager.progress("close");
					   }
					});
			
		}});
		}else{
			commonObj.alert('请至少选择一条信息!',"warning");
			return ;
		}
		$.messager.progress("close");
		event.preventDefault();
	});

});

//表单提交成功后的回调方法
function successCallback(data){
	$.messager.progress("close");
	$("#innovationList").datagrid('reload');
	commonObj.showResponse(data);
}
