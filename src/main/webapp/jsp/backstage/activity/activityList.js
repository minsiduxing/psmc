$(document).ready(function(){ 
	//new datagrid 初始化 
	var activityOption = {
		tabId:"activityList",
		toolbar:"toolbarId",
		url:getInfoDataUrl,
		columns:[[   
		          /**
		           * 可以解决表格右边空白的问题，但是没办法自适应浏览器大小，暂时不用
		           * width:parseInt($(this).width()*0.3)
		           */
		          {field:'activity_uuid',title:'活动主键标识',checkbox:true},
		          {field:'activity_name',title:'活动名称',resizable:true,align:'center',sortable:true},    
		          {field:'activity_content',title:'活动内容',halign:'center',formatter: function (value, row, index) {
	                     if(value.length>=15){return value.substring(0,15)+"......"; }	
	                     if(value.length<15){return value; }
		          }}, 
		          {field:'dept_name',title:'协会名称',align:'center',sortable:true},
		          {field:'create_person',title:'创建人',align:'center',sortable:true},
		          {field:'create_date',title:'创建时间',align:'center',sortable:true}, 
		          {field:'start_date',title:'活动开始时间',align:'center',sortable:true}, 
		          {field:'end_date',title:'活动结束时间',align:'center',sortable:true}, 
		          {field:'sign_up_end_date',title:'报名截止时间',align:'center',sortable:true}, 
		          {field:'signUpNums',title:'已报名人数',align:'center',sortable:true,formatter:function(value, row, index){
		        	  if(value==null || value==''){
		        		  return "<a href='javascript:void(0)' onclick='openSingUpListDialog(&apos;" + row['activity_uuid'] + "&apos;)'>"+0+"</a>";
		        	  }else{
		        		  return "<a href='javascript:void(0)' onclick='openSingUpListDialog(&apos;" + row['activity_uuid'] + "&apos;)'>"+value+"</a>";
		        	  }
		          }},
		          {field:'audit',title:'审核状态',align:'center',sortable:true,formatter: function (value, row, index) {
                     if(value=='1'){return "审核通过"; }
                     if(value=='2'){return "未审核"; }
                     if(value=='3'){return "审核不通过"; }
                                                  
                  }},
		          {field:'auditAccName',title:'活动审核人',align:'center',sortable:true}, 
		          {field:'audit_date',title:'活动审核时间',resizable:true,align:'center',sortable:true}, 
		          {field:'release_status',title:'发布状态',resizable:true,align:'center',sortable:true,formatter: function (value, row, index) {
                     if(value=='2'){return "未发布"; }
                     if(value=='1'){return "已发布"; }
	              }},
		          {field:'releaseAccName',title:'活动发布人',align:'center',sortable:true}, 
		          {field:'release_date',title:'活动发布时间',align:'center',sortable:true}, 
		          {field:'publish_expire_date',title:'信息过期时间',align:'center',sortable:true}
		         ] 
		      ],
	};
	//初始化活动信息列表
	commonObj.initPaginationGrid(activityOption);
	
	//新增
	$("#add").click(function(){
		var _url = editInfoUrl+"&isEdit="+"add";
		window.location.href=_url;
		event.preventDefault();
	});
	
	//编辑
	$("#edit").click(function(){
		var rows = $("#activityList").datagrid('getChecked');
		if (rows.length == 1){
			var rowObj = eval(rows[0]);
			if(rowObj.audit==1){
				commonObj.alert("该信息已经审核通过不能修改!","warning");
				return;
			}
			var uuid = rowObj.activity_uuid;
			var _url = editInfoUrl+"&uuid="+uuid+"&isEdit="+"edit";
			window.location.href=_url;
		}else{
			commonObj.alert("请选择一条记录!","warning");
		}
		event.preventDefault();
	});
	
	//查看
	$("#priview").click(function(){
		var rows = $("#activityList").datagrid('getChecked');
		if (rows.length == 1){
			var rowObj = eval(rows[0]);
			var uuid = rowObj.activity_uuid;
			var _url = editInfoUrl+"&uuid="+uuid+"&isEdit="+"query";
			window.location.href=_url;
		}else{
			commonObj.alert("请选择一条记录!","warning");
		}
		event.preventDefault();
	});
	
	//删除
$("#remove").click(function(){
		var rows = $("#activityList").datagrid('getChecked');
		var rlength = rows.length;
		var ids="";
		if (rlength > 0){
			for(var i=0;i<rlength;i++){
				var rowObj = eval(rows[i]);
				var newsid = rowObj.activity_uuid;
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
	var rows = $("#activityList").datagrid('getChecked');
	var rlength = rows.length;
	var ids="";
	if (rlength > 0){		
		for(var i=0;i<rlength;i++){
			var rowObj = eval(rows[i]);
			var newsid = rowObj.activity_uuid;
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
	var rows = $("#activityList").datagrid('getChecked');
	var rlength = rows.length;
	uuids="";
	if (rlength > 0){		
		for(var i=0;i<rlength;i++){
			var rowObj = eval(rows[i]);
			var newsid = rowObj.activity_uuid;
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
		var rows = $("#activityList").datagrid('getChecked');
		var rlength = rows.length;
		var ids="";
		if (rlength > 0){		
			for(var i=0;i<rlength;i++){
				var rowObj = eval(rows[i]);
				var activityUuid = rowObj.activity_uuid;
				var audit = rowObj.audit;
				if(audit==2){
					commonObj.alert('存在未审核的信息!',"warning");
					return ;
				}
				ids+=activityUuid;
				if(i<rlength-1)
					ids+=",";
			}
			$.messager.confirm('提示', '确认选中的信息执行撤销操作吗?', function(r){
				if (r){
				var _url = executeUndo+"&activityUuids="+ids;
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
	$("#activityList").datagrid('reload');
	commonObj.showResponse(data);
}

//表单dialog初始化方法
var signUpListdialog;
function initDialog(){
	signUpListdialog = $("#signUpListDiv").dialog({
		modal: true,
		closed: true,
	    width: 885,
	    height: 410,
	    resizable:true,
	    cache: false
	});
}

//打开报名列表dialog
function openSingUpListDialog(activityUuid){
	if(!signUpListdialog){
		initDialog();
	}
	signUpListdialog.panel({title:"报名信息"});
	signUpListdialog.panel({iconCls:'icon-save'});
	signUpListdialog.window("open");
	$("#activityUuid").val(activityUuid);
	initDialogDataGrid(activityUuid);
}

function initDialogDataGrid(activityUuid){
	var option = {
			tabId:"signUpList",
			toolbar:"toolbarId2",
			striped:true,
			url:querySignUpInfoPage + "&activityUuid="+activityUuid,
			columns:[[   
			          {field:'sign_up_uuid',title:'主键id',hidden:true},
			          {field:'activity_name',title:'活动名称',resizable:true,align:'center'},    
			          {field:'person_name',title:'姓名',align:'center',sortable:true}, 
			          {field:'person_mobile',title:'联系电话',align:'center',sortable:true}, 
			          {field:'sign_up_date',title:'报名时间',align:'center',sortable:true},
			          {field:'start_date',title:'活动开始时间',align:'center'}, 
			          {field:'end_date',title:'活动结束时间', align:'center'}, 
			          {field:'activity_uuid',title:'活动id',hidden:true}
			         ] 
			      ]
		};
		//初始化列表
		commonObj.initPaginationGrid(option);
}
