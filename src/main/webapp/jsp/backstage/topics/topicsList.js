$(document).ready(function(){ 
	var blockUuid = $("#blockUuid").val();
	var isHide = false;
	//投诉表扬没有评论
	if(blockUuid == '04' || blockUuid == '05'){
		isHide = true;
	}
	//new datagrid 初始化 
	var option = {
		tabId:"topicsId",
		toolbar:"toolbarId",
		url:topicListUrl,
		columns:[[   
		          {field:'topic_uuid',title:'主键id',checkbox:true},
		          {field:'topic_name',title:'信息名称',resizable:true,align:'center',sortable:true},    
		          {field:'topic_content',title:'信息内容',halign:'center',sortable:true,formatter:function(value, row, index){
		        	  if(value.length > 40){
		        		  return value.substring(0,40) + "......";
		        	  }else{
		        		  return value;
		        	  }
		          }}, 
		          {field:'create_person_name',title:'创建人',align:'center',sortable:true}, 
		          {field:'telephone',title:'联系电话',align:'center',sortable:true}, 
		          {field:'create_date',title:'创建时间',align:'center',sortable:true}, 
		          {field:'topic_status',title:'信息状态',align:'center',sortable:true,formatter: function (value, row, index) {
                     if(value=='1'){return "正常"; }
                     if(value=='2'){return "禁止评论"; }
                     if(value=='3'){return "已删除"; }
                  }},
                  {field:'release_status',title:'发布状态',align:'center',sortable:true,formatter: function (value, row, index) {
                      if(value=='1'){return "已发布"; }
                      if(value=='2'){return "未发布"; }
                  }},
                  {field:'release_time',title:'发布时间',align:'center',sortable:true}, 
                  {field:'releasePersonName',title:'发布人',align:'center',sortable:true}, 
                  {field:'laudNums',title:'点赞数',align:'center',sortable:true,formatter:function(value, row, index){
		        	  if(value==null || value==''){
		        		  return 0;
		        	  }else{
		        		  return "<a href='javascript:void(0)' onclick='openLaudListDialog(&apos;" + row['topic_uuid'] + "&apos;)'>"+value+"</a>";
		        	  }
		          }},
		          {field:'lastCommentPerson',title:'最后评论人',align:'center',sortable:true,hidden:isHide}, 
		          {field:'last_comment_date',title:'最后评论时间',align:'center',sortable:true,hidden:isHide}, 
		          {field:'block_uuid',title:'所属板块id', hidden:true}, 
		          {field:'create_person_uuid',title:'创建人id',hidden:true}, 
		          {field:'last_comment_person_uuid',title:'最后评论人id',hidden:true}
		         ] 
		      ]
	};
	//初始化新闻列表
	commonObj.initPaginationGrid(option);
	
	//禁评
	$("#lock").click(function(){
		var rows = $("#topicsId").datagrid('getChecked');
		var rlength = rows.length;
		var ids="";
		if (rlength > 0){		
			for(var i=0;i<rlength;i++){
				var rowObj = eval(rows[i]);
				var topicUuid = rowObj.topic_uuid;
				var topicStatus = rowObj.topic_status;
				var releaseStatus = rowObj.release_status;
				if(releaseStatus != 1){
					commonObj.alert('存在未发布的信息!',"warning");
					return ;
				}
				if(topicStatus==2){
					commonObj.alert('存在已经禁止评论的信息!',"warning");
					return ;
				}
				ids+=topicUuid;
				if(i<rlength-1)
					ids+=",";
			}
			
			$.messager.confirm('提示', '确认选中的信息禁止评论吗?', function(r){
				if (r){
				var _url = pauseTopicsCommentUrl+"&topicUuids="+ids;
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
	
	
	//删除
	$("#remove").click(function(){
		var rows = $("#topicsId").datagrid('getChecked');
		var rlength = rows.length;
		var ids="";
		if (rlength > 0){		
			for(var i=0;i<rlength;i++){
				var rowObj = eval(rows[i]);
				var topicUuid = rowObj.topic_uuid;
				ids+=topicUuid;
				if(i<rlength-1)
					ids+=",";
			}
			
			$.messager.confirm('提示', '确认删除选中的信息吗?', function(r){
				if (r){
				var _url = deleteTopicsUrl+"&topicUuids="+ids;
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
	
	//撤销
	$("#undo").click(function(){
		var rows = $("#topicsId").datagrid('getChecked');
		var rlength = rows.length;
		var ids="";
		if (rlength > 0){		
			for(var i=0;i<rlength;i++){
				var rowObj = eval(rows[i]);
				var topicUuid = rowObj.topic_uuid;
				var topicStatus = rowObj.topic_status;
				if(topicStatus==1){
					commonObj.alert('存在状态正常的信息!',"warning");
					return ;
				}
				ids+=topicUuid;
				if(i<rlength-1)
					ids+=",";
			}
			
			$.messager.confirm('提示', '确认选中的信息执行撤销操作吗?', function(r){
				if (r){
				var _url = undoTopicsUrl+"&topicUuids="+ids;
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
	
	//查看
	$("#priview").click(function(){
		var rows = $("#topicsId").datagrid('getChecked');
		if (rows.length == 1){
			var rowObj = eval(rows[0]);
			var topicUuid = rowObj.topic_uuid;
			openCommentListDialog(topicUuid);
		}else{
			commonObj.alert("请选择一条记录!","warning");
		}
		event.preventDefault();
	});
	
	//发布
	$("#release").click(function(){
		var rows = $("#topicsId").datagrid('getChecked');
		var rlength = rows.length;
		var ids="";
		if (rlength > 0){		
			for(var i=0;i<rlength;i++){
				var rowObj = eval(rows[i]);
				var topicUuid = rowObj.topic_uuid;
				var releaseStatus = rowObj.release_status;
				if(releaseStatus==1){
					commonObj.alert('存在已发布的信息!',"warning");
					return ;
				}
				ids+=topicUuid;
				if(i<rlength-1)
					ids+=",";
			}
			
			$.messager.confirm('提示', '确认发布选中的信息吗?', function(r){
				if (r){
				var _url = releaseUrl+"&topicUuids="+ids;
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
	
	//取消发布
	$("#banRelease").click(function(){
		var rows = $("#topicsId").datagrid('getChecked');
		var rlength = rows.length;
		var ids="";
		if (rlength > 0){		
			for(var i=0;i<rlength;i++){
				var rowObj = eval(rows[i]);
				var topicUuid = rowObj.topic_uuid;
				var releaseStatus = rowObj.release_status;
				if(releaseStatus==2){
					commonObj.alert('存在未发布的信息!',"warning");
					return ;
				}
				ids+=topicUuid;
				if(i<rlength-1)
					ids+=",";
			}
			
			$.messager.confirm('提示', '确认取消发布选中的信息吗?', function(r){
				if (r){
				var _url = banReleaseUrl+"&topicUuids="+ids;
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
	
	//表单提交成功后的回调方法
	function successCallback(data){
		$.messager.progress("close");
		$("#topicsId").datagrid('reload');
		commonObj.showResponse(data);
	}
});

var commentListdialog;
//表单dialog初始化方法
function initDialog(){
	commentListdialog = $("#commentListDialogDiv").dialog({
		modal: true,
		closed: true,
	    width: 850,
	    height: 500,
	    resizable:true,
	    cache: false
	});
}

//打开评论列表dialog
function openCommentListDialog(topicUuid){
	if(!commentListdialog){
		initDialog();
	}
	commentListdialog.panel({title:"信息详情"});
	commentListdialog.panel({href:toTopicsDetail+'&topicUuid='+topicUuid});
	commentListdialog.window("open");
}

//点赞信息dialog
var laudListdialog;
function iniLaudListtDialog(){
	laudListdialog = $("#laudListDiv").dialog({
		modal: true,
		closed: true,
	    width: 500,
	    height: 410,
	    resizable:true,
	    cache: false
	});
}

function openLaudListDialog(topicUuid){
	if(!laudListdialog){
		iniLaudListtDialog();
	}
	laudListdialog.panel({title:"点赞人员"});
	laudListdialog.window("open");
	$("#moduleUuid").val(topicUuid);
	initLaudDataGrid(topicUuid);
}
//初始化点赞列表数据
function initLaudDataGrid(topicUuid){
	var option = {
			tabId:"laudList",
			toolbar:"toolbarId2",
			striped:true,
			url:queryLaudListUrl + "&uuid="+topicUuid + "&businessType=topic" ,
			columns:[[   
			          {field:'laud_uuid',title:'主键id',hidden:true},  
			          {field:'infoName',title:'信息名称',align:'center',sortable:true},
			          {field:'laud_person_name',title:'点赞人姓名',align:'center',sortable:true}, 
			          {field:'laud_date',title:'点赞时间',align:'center',sortable:true},
			          {field:'module_uuid',title:'信息id',hidden:true}
			         ] 
			      ]
		};
		//初始化列表
		commonObj.initPaginationGrid(option);
}

//导出
function exportExcel(){
	var moduleUuid = $("#moduleUuid").val();
	window.location = exportLaudListUrl + "&moduleUuid=" + moduleUuid + "&businessType=topic";
}


