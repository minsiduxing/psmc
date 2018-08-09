$(document).ready(function(){ 
	var deptType = $("#deptType").val();
	var dept_name;
	var dept_introduction;
	if(deptType == '1'){
		 dept_name = '工作室名称';
		 dept_introduction = '工作室简介';
	 }else{
		 dept_name = '协会名称';
		 dept_introduction = '协会简介';
	 }
	//new datagrid 初始化 
	var deptOption = {
		tabId:"deptList",
		toolbar:"toolbarId",
		url:deptDataListUrl,
		columns:[[   
		          {field:'dept_uuid',title:'部门主键标识',checkbox:true},
		          {field:'dept_name',title:dept_name,resizable:true,align:'center',sortable:true},    
		          {field:'dept_introduction',title:dept_introduction,halign:'center',formatter: function (value, row, index) {
	                     if(value.length>=15){return value.substring(0,15)+"......"; }	
	                     if(value.length<15){return value; }
		          }}, 
		          {field:'dept_regulation',title:'规范管理办法',halign:'center',formatter: function (value, row, index) {
	                     if(value.length>=15){return value.substring(0,15)+"......"; }	
	                     if(value.length<15){return value; }
		          }},
		          {field:'createPersonName',title:'创建人',align:'center',sortable:true},
		          {field:'create_date',title:'创建时间',align:'center',sortable:true}, 
		          {field:'audit',title:'审核状态',align:'center',sortable:true,formatter: function (value, row, index) {
	                     if(value=='1'){return "审核通过"; }
	                     if(value=='2'){return "未审核"; }
	                     if(value=='3'){return "审核不通过"; }
	               }}, 
		          {field:'audit_date',title:'审核时间',align:'center',sortable:true}, 
		          {field:'auditAccName',title:'审核人',align:'center',sortable:true}, 
		          {field:'release_status',title:'发布状态',align:'center',sortable:true,formatter: function (value, row, index) {
	                     if(value=='2'){return "未发布"; }
	                     if(value=='1'){return "已发布"; }
	                                                  
	              }}, 
		          {field:'release_date',title:'发布时间',align:'center',sortable:true}, 
		          {field:'releaseAccName',title:'发布人',align:'center',sortable:true}, 
		          {field:'lastModifyPersonName',title:'最后修改人',align:'center',sortable:true}, 
		          {field:'last_modify_time',title:'最后修改时间',align:'center',sortable:true}, 
		          {field:'create_person',title:'创建人ID', hidden:true}, 
		          {field:'last_modify_person',title:'最后修改人ID', hidden:true}
		         ] 
		      ]
	};
	
	//初始化部门信息列表
	commonObj.initPaginationGrid(deptOption);
	
	//新增
	$("#add").click(function(){
		var _url = toDeptEditUrl+"&isEdit="+"add";
		window.location.href=_url;
		event.preventDefault();
	});
	
	//编辑
	$("#edit").click(function(){
		var rows = $("#deptList").datagrid('getChecked');
		if (rows.length == 1){
			var rowObj = eval(rows[0]);
			var uuid = rowObj.dept_uuid;
			if(rowObj.audit==1){
				commonObj.alert("该信息已经审核通过不能修改!","warning");
				return;
			}
			var _url = toDeptEditUrl+"&deptUuid="+uuid+"&isEdit="+"edit";
			window.location.href=_url;
		}else{
			commonObj.alert("请选择一条记录!","warning");
		}
		event.preventDefault();
	});
	
	//查看
	$("#priview").click(function(){
		var rows = $("#deptList").datagrid('getChecked');
		if (rows.length == 1){
			var rowObj = eval(rows[0]);
			var uuid = rowObj.dept_uuid;
			var _url = toDeptEditUrl+"&deptUuid="+uuid+"&isEdit="+"query";
			window.location.href=_url;
		}else{
			commonObj.alert("请选择一条记录!","warning");
		}
		event.preventDefault();
	});
	
	//删除
$("#remove").click(function(){
		var deptType =  $("#deptType").val();
		var rows = $("#deptList").datagrid('getChecked');
		var rlength = rows.length;
		var ids="";
		if (rlength > 0){
			for(var i=0;i<rlength;i++){
				var rowObj = eval(rows[i]);
				var newsid = rowObj.dept_uuid;
				ids+=newsid;
				if(i<rlength-1)
					ids+=",";
			}
			var msg = "";
			if(deptType == '1'){
				msg = "删除选中的信息会同步删除该工作室下的所有创新成果信息，您确认删除吗？";
			}else{
				msg = "删除选中的信息会同步删除该协会下的所有活动信息，您确认删除吗？";
			}
			$.messager.confirm('提示', msg, function(r){
				if (r){
					var _url = removeDept+"&uuids="+ids+"&deptType="+deptType;
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
	var rows = $("#deptList").datagrid('getChecked');
	var rlength = rows.length;
	var ids="";
	if (rlength > 0){		
		for(var i=0;i<rlength;i++){
			var rowObj = eval(rows[i]);
			var newsid = rowObj.dept_uuid;
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
				var _url = auditDept+"&uuids="+ids;
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
		commonObj.alert('请至少选择一条信息!',"warning");
		return ;
	}
	$.messager.progress("close");
	event.preventDefault();
});

//发布
$("#releaseNews").click(function(){
	var rows = $("#deptList").datagrid('getChecked');
	var rlength = rows.length;
	uuids="";
	if (rlength > 0){		
		for(var i=0;i<rlength;i++){
			var rowObj = eval(rows[i]);
			var newsid = rowObj.dept_uuid;
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
		if(r){
			var _url = releaseDept+"&uuids="+uuids;
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
		commonObj.alert('请至少选择一条信息!',"warning");
		return ;
	}
	$.messager.progress("close");
	event.preventDefault();
});

	//撤销
	$("#undo").click(function(){
		var rows = $("#deptList").datagrid('getChecked');
		var rlength = rows.length;
		var ids="";
		if (rlength > 0){		
			for(var i=0;i<rlength;i++){
				var rowObj = eval(rows[i]);
				var deptUuid = rowObj.dept_uuid;
				var audit = rowObj.audit;
				if(audit==2){
					commonObj.alert('存在未审核的信息!',"warning");
					return ;
				}
				ids+=deptUuid;
				if(i<rlength-1)
					ids+=",";
			}
			$.messager.confirm('提示', '确认选中的信息执行撤销操作吗?', function(r){
				if (r){
				var _url = executeUndo+"&deptUuids="+ids;
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
	$("#deptList").datagrid('reload');
	commonObj.showResponse(data);
}
