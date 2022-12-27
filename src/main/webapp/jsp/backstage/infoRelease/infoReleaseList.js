$(document).ready(function(){ 
	//new datagrid 初始化 
	var option = {
		tabId:"infoReleaseId",
		toolbar:"toolbarId",
		url:getInfoDataUrl,
		columns:[[   
		          /**
		           * 可以解决表格右边空白的问题，但是没办法自适应浏览器大小，暂时不用
		           * width:parseInt($(this).width()*0.3)
		           */
		          {field:'uuid',title:'信息标示',checkbox:true},
		          {field:'news_title',title:'信息标题',resizable:true,align:'center',sortable:true,width:$(this).width() * 0.2},
		          {field:'news_date',title:'创建日期',align:'center',sortable:true,width:$(this).width() * 0.2},
		          {field:'news_author',title:'信息创建人',align:'center',sortable:true,width:$(this).width() * 0.2},
		          {field:'audit',title:'审核状态',align:'center',sortable:true,width:$(this).width() * 0.2,formatter: function (value, row, index) {
                     if(value=='1'){return "审核通过"; }
                     if(value=='2'){return "未审核"; }
                     if(value=='3'){return "审核不通过"; }
                                                  
                  }},
		          {field:'auditAccName',title:'信息审核人',align:'center',sortable:true,width:$(this).width() * 0.2},
		          {field:'audit_date',title:'信息审核时间',resizable:true,align:'center',sortable:true,width:$(this).width() * 0.2},
		          {field:'two_level_classify',title:'信息分类',resizable:true,align:'center',sortable:true,width:$(this).width() * 0.2,formatter: function (value, row, index) {
	                     if(value=='1401'){return "美味食谱"; }
	                     if(value=='1402'){return "日常通知"; }
	                     if(value=='1403'){return "大院新闻"; }
	                     if(value=='1404'){return "便民电话"; }
	                     if(value=='1405'){return "政策法律"; }
	                     if(value=='1501'){return "关于介绍"; }
	                     if(value=='1502'){return "业务领域"; }
	                     if(value=='1503'){return "新闻动态"; }
	                     if(value=='1504'){return "联系我们"; }
						 if(value=='1505'){return "欢迎页"; }
						 if(value=='1506'){return "用户服务协议"; }
						 if(value=='1507'){return "预判完毕告知"; }
	                     if(value=='1601'){return "合伙人"; }
	                     if(value=='1602'){return "专职律师"; }
	                     if(value=='1603'){return "辅助人员"; }

	                  }},
		          {field:'release_status',title:'发布状态',resizable:true,align:'center',width:$(this).width() * 0.2,sortable:true,formatter: function (value, row, index) {
	                     if(value=='2'){return "未发布"; }
	                     if(value=='1'){return "已发布"; }
	                                                  
	                  }},
		          {field:'releaseAccName',title:'信息发布人',align:'center',sortable:true,width:$(this).width() * 0.2},
		          {field:'release_date',title:'信息发布时间',align:'center',sortable:true,width:$(this).width() * 0.2},
		          {field:'publish_expire_date',title:'信息过期时间',align:'center',sortable:true,width:$(this).width() * 0.2}
		         ] 
		      ]
	};
	//初始化新闻列表
	commonObj.initPaginationGrid(option);
	
	//新增
	$("#add").click(function(){
		var oneLevelClassify = $("#oneLevelClassify").val();
		var _url = editInfoUrl+"&isEdit="+"add"+"&oneLevelClassify="+oneLevelClassify;
		window.location.href=_url;
		event.preventDefault();
	});
	
	//编辑
	$("#edit").click(function(){
		var rows = $("#infoReleaseId").datagrid('getChecked');
		var oneLevelClassify = $("#oneLevelClassify").val();
		if (rows.length == 1){
			var rowObj = eval(rows[0]);
			if(rowObj.audit==1){
				commonObj.alert("该信息已经审核通过不能修改!","warning");
				return;
			}
			var uuid = rowObj.uuid;
			var _url = editInfoUrl+"&uuid="+uuid+"&isEdit="+"edit"+"&oneLevelClassify="+oneLevelClassify;
			window.location.href=_url;
		}else{
			commonObj.alert("请选择一条记录!","warning");
		}
		event.preventDefault();
	});
	
	//查看
	$("#priview").click(function(){
		var rows = $("#infoReleaseId").datagrid('getChecked');
		var oneLevelClassify = $("#oneLevelClassify").val();
		if (rows.length == 1){
			var rowObj = eval(rows[0]);
			var uuid = rowObj.uuid;
			var _url = editInfoUrl+"&uuid="+uuid+"&isEdit="+"query"+"&oneLevelClassify="+oneLevelClassify;
			window.location.href=_url;
		}else{
			commonObj.alert("请选择一条记录!","warning");
		}
		event.preventDefault();
	});
	
	//删除
$("#remove").click(function(){
		var rows = $("#infoReleaseId").datagrid('getChecked');
		var rlength = rows.length;
		var ids="";
		if (rlength > 0){
			for(var i=0;i<rlength;i++){
				var rowObj = eval(rows[i]);
				var newsid = rowObj.uuid;
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
	var rows = $("#infoReleaseId").datagrid('getChecked');
	var rlength = rows.length;
	var ids="";
	if (rlength > 0){		
		for(var i=0;i<rlength;i++){
			var rowObj = eval(rows[i]);
			var newsid = rowObj.uuid;
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
/*//预览
$("#priview").click(function(){
	var rows = $("#infoReleaseId").datagrid('getChecked');
	var rlength = rows.length;
	if(rlength ==1){
		var rowObj = eval(rows[0]);
		 uuid = rowObj.uuid;
		 window.location.href='/psmc/resources/bhkn/previewInfo.html?id='+uuid;
	}else{
		commonObj.alert('请选择一条信息!',"warning");
		return ;
	}
	$.messager.progress("close");
	event.preventDefault();
});*/
//发布
$("#releaseNews").click(function(){
	var rows = $("#infoReleaseId").datagrid('getChecked');
	var rlength = rows.length;
	uuids="";
	if (rlength > 0){		
		for(var i=0;i<rlength;i++){
			var rowObj = eval(rows[i]);
			var newsid = rowObj.uuid;
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
		var rows = $("#infoReleaseId").datagrid('getChecked');
		var rlength = rows.length;
		var ids="";
		if (rlength > 0){		
			for(var i=0;i<rlength;i++){
				var rowObj = eval(rows[i]);
				var uuid = rowObj.uuid;
				var audit = rowObj.audit;
				if(audit==2){
					commonObj.alert('存在未审核的信息!',"warning");
					return ;
				}
				ids+=uuid;
				if(i<rlength-1)
					ids+=",";
			}
			$.messager.confirm('提示', '确认选中的信息执行撤销操作吗?', function(r){
				if (r){
				var _url = executeUndo+"&uuids="+ids;
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
	$("#infoReleaseId").datagrid('reload');
	commonObj.showResponse(data);
}
