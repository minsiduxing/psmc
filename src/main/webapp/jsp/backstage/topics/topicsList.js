$(document).ready(function(){ 
	//new datagrid 初始化 
	var option = {
		tabId:"topicsId",
		toolbar:"toolbarId",
		url:getInfoDataUrl,
		columns:[[   
		          {field:'topic_uuid',title:'主键id',checkbox:true},
		          {field:'topic_name',title:'信息名称',resizable:true},    
		          {field:'topic_content',title:'信息内容'}, 
		          {field:'create_person_name',title:'创建人'}, 
		          {field:'telephone',title:'联系电话'}, 
		          {field:'create_date',title:'创建时间'}, 
		          {field:'topic_status',title:'信息状态',formatter: function (value, row, index) {
                     if(value=='1'){return "正常"; }
                     if(value=='2'){return "禁止评论"; }
                     if(value=='3'){return "已删除"; }
                                                  
                  }},
		          {field:'lastCommentPerson',title:'最后评论人'}, 
		          {field:'last_comment_date',title:'最后评论时间'}, 
		          {field:'block_uuid',title:'所属板块id', hide:true}, 
		          {field:'create_person_uuid',title:'创建人id',hide:true}, 
		          {field:'last_comment_person_uuid',title:'最后评论人id',hide:true}
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
				var _url = deleteTopics+"&topicUuids="+ids;
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




