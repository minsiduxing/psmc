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
		          {field:'news_title',title:'信息标题',resizable:true},    
		        /*  {field:'news_subtitle',title:'新闻副标题',resizable:true},  */
		          {field:'news_date',title:'信息日期'}, 
		          {field:'news_author',title:'信息作者'}, 
		         /* {field:'news_abstract',title:'新闻概要',formatter: function (value, row, index) {
	                     if(value.length>=10){return value.substring(0,10)+"......"; }	
	                     if(value.length<10){return value; }
	              }}, */
		         /* {field:'createAccName',title:'新闻创建人'}, 
		          {field:'create_date',title:'新闻创建时间',resizable:true}, */
		          /*{field:'modifyccName',title:'新闻修改人'}, 
		          {field:'modify_date',title:'新闻修改时间',resizable:true}, */
		          {field:'audit',title:'审核状态',formatter: function (value, row, index) {
                     if(value=='1'){return "审核通过"; }
                     if(value=='2'){return "未审核"; }
                     if(value=='3'){return "审核不通过"; }
                                                  
                  }},
		          {field:'auditAccName',title:'信息审核人'}, 
		          {field:'audit_date',title:'信息审核时间',resizable:true}, 
		          {field:'two_level_classify',title:'信息分类',resizable:true,formatter: function (value, row, index) {
	                     if(value=='1401'){return "美味食谱"; }
	                     if(value=='1402'){return "日常通知"; }
	                     if(value=='1403'){return "大院新闻"; }
	                     if(value=='1404'){return "便民电话"; }
	                     if(value=='1405'){return "政策法律"; }
	                  }},
		          {field:'release_status',title:'发布状态',resizable:true,formatter: function (value, row, index) {
	                     if(value=='0'){return "未发布"; }
	                     if(value=='1'){return "已发布"; }
	                                                  
	                  }},
		          {field:'releaseAccName',title:'信息发布人'}, 
		          {field:'release_date',title:'信息发布时间'}, 
		          {field:'publish_expire_date',title:'信息过期时间'}
		         ] 
		      ]
	};
	//初始化新闻列表
	commonObj.initPaginationGrid(option);
	//编辑
	$("#edit").click(function(){
		var rows = $("#infoReleaseId").datagrid('getChecked');
		
		if (rows.length == 1){
			var rowObj = eval(rows[0]);
			if(rowObj.audit==1){
				commonObj.alert("该信息已经审核通过不能修改!","warning");
				return;
			}
			var uuid = rowObj.uuid;
			var _url = editInfoUrl+"&uuid="+uuid;
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
//预览
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
});
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
			commonObj.alert('选择的新闻中存在发布过的信息!',"warning");
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
//表单提交成功后的回调方法
function successCallback(data){
	$.messager.progress("close");
	$("#infoReleaseId").datagrid('reload');
	commonObj.showResponse(data);
}

});
