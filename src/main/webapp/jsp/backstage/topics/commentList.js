var commentListdialog;

//表单dialog初始化方法
function initDialog(){
	commentListdialog = $("#commentListDialogDiv").dialog({
		modal: true,
		closed: true,
	    width: 885,
	    height: 410,
	    resizable:true,
	    cache: false
	});
}

//打开评论列表dialog
function openCommentListDialog(topicUuid){
	if(!commentListdialog){
		initDialog();
	}
	commentListdialog.panel({title:"评论列表"});
	commentListdialog.panel({iconCls:'icon-save'});
	commentListdialog.window("open");
	initDialogDataGrid(topicUuid);
}

function initDialogDataGrid(topicUuid){
	var option = {
			tabId:"commentList",
			toolbar:"toolbarId2",
			striped:true,
			url:commentListUrl + "&topicUuid="+topicUuid,
			columns:[[   
			          {field:'comment_uuid',title:'主键id',checkbox:true},
			          {field:'comment_person_name',title:'评论人',resizable:true,width:'80px',align:'center',sortable:true},    
			          {field:'comment_content',title:'评论内容',width:'350px',halign:'center',sortable:true}, 
			          {field:'comment_date',title:'评论时间',width:'170px',align:'center',sortable:true}, 
			          {field:'comment_status',title:'评论状态',width:'80px',align:'center',sortable:true,formatter: function (value, row, index) {
	                     if(value=='1'){return "正常"; }
	                     if(value=='2'){return "已屏蔽"; }
	                     if(value=='3'){return "已删除"; }
	                                                  
	                  }},
			          {field:'to_person_name',title:'评论目标人',width:'90px',align:'center',sortable:true}, 
			          {field:'topic_uuid',title:'主题id', hidden:true}, 
			          {field:'comment_person_uuid',title:'评论人id',hidden:true}, 
			          {field:'to_person_uuid',title:'目标人id',hidden:true}
			         ] 
			      ]
		};
		//初始化列表
		commonObj.initPaginationGrid(option);
}

//屏蔽
function lockComment(){
	var rows = $("#commentList").datagrid('getChecked');
	var rlength = rows.length;
	var ids="";
	if (rlength > 0){		
		for(var i=0;i<rlength;i++){
			var rowObj = eval(rows[i]);
			var commentUuid = rowObj.comment_uuid;
			var commentStatus = rowObj.comment_status;
			if(commentStatus==2){
				commonObj.alert('存在已经屏蔽的信息!',"warning");
				return ;
			}
			ids+=commentUuid;
			if(i<rlength-1)
				ids+=",";
		}
		
		$.messager.confirm('提示', '确认屏蔽选中的评论信息吗?', function(r){
			if (r){
			var _url = pauseCommentUrl+"&commentUuids="+ids;
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
}


//删除
function removeComment(){
	var rows = $("#commentList").datagrid('getChecked');
	var rlength = rows.length;
	var ids="";
	if (rlength > 0){		
		for(var i=0;i<rlength;i++){
			var rowObj = eval(rows[i]);
			var commentUuid = rowObj.comment_uuid;
			ids+=commentUuid;
			if(i<rlength-1)
				ids+=",";
		}
		
		$.messager.confirm('提示', '确认删除选中的信息吗?', function(r){
			if (r){
			var _url = deleteCommentUrl+"&commentUuids="+ids;
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
}

//撤销
function undoComment(){
	debugger;
	var rows = $("#commentList").datagrid('getChecked');
	var rlength = rows.length;
	var ids="";
	if (rlength > 0){		
		for(var i=0;i<rlength;i++){
			var rowObj = eval(rows[i]);
			var commentUuid = rowObj.comment_uuid;
			var commentStatus = rowObj.comment_status;
			if(commentStatus==1){
				commonObj.alert('存在状态正常的信息!',"warning");
				return ;
			}
			ids+=commentUuid;
			if(i<rlength-1)
				ids+=",";
		}
		
		$.messager.confirm('提示', '确认选中的信息执行撤销操作吗?', function(r){
			if (r){
			var _url = undoCommentUrl+"&commentUuids="+ids;
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
}


//表单提交成功后的回调方法
function successCallback(data){
	$.messager.progress("close");
	$("#commentList").datagrid('reload');
	commonObj.showResponse(data);
}