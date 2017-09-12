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
		          {field:'uuid',title:'新闻标示',checkbox:true},
		          {field:'news_title',title:'新闻标题',resizable:true},    
		          {field:'news_subtitle',title:'新闻副标题',resizable:true},  
		          {field:'news_date',title:'新闻日期'}, 
		          {field:'news_author',title:'新闻作者'}, 
		          {field:'news_abstract',title:'新闻简介',formatter: function (value, row, index) {
	                     if(value.length>=10){return value.substring(0,10)+"......"; }	
	                     if(value.length<10){return value; }
	              }}, 
		          {field:'createAccName',title:'新闻创建人'}, 
		          {field:'create_date',title:'新闻创建时间',resizable:true}, 
		          {field:'modifyccName',title:'新闻修改人'}, 
		          {field:'modify_date',title:'新闻修改时间',resizable:true}, 
		          {field:'audit',title:'审核状态',formatter: function (value, row, index) {
                     if(value=='0'){return "未审核"; }
                     if(value=='1'){return "审核通过"; }
                     if(value=='2'){return "审核不通过"; }
                                                  
                  }},
		          {field:'auditAccName',title:'新闻审核人'}, 
		          {field:'audit_date',title:'新闻审核时间',resizable:true}, 
		          {field:'two_level_classify',title:'新闻分类',resizable:true,formatter: function (value, row, index) {
	                     if(value=='1'){return "公司新闻"; }
	                     if(value=='2'){return "行业资讯"; }
	                                                  
	                  }},
		          {field:'release_status',title:'发布状态',resizable:true,formatter: function (value, row, index) {
	                     if(value=='0'){return "未发布"; }
	                     if(value=='1'){return "已发布"; }
	                                                  
	                  }},
		          {field:'releaseAccName',title:'新闻发布人'}, 
		          {field:'release_date',title:'新闻发布时间'}, 
		          {field:'publish_expire_date',title:'新闻过期时间'}
		         ] 
		      ]
	};
	//初始化新闻列表
	commonObj.initPaginationGrid(option);
	//编辑
	$("#edit").click(function(){
		var rows = $("#newsTableId").datagrid('getChecked');
		if (rows.length == 1){
			var rowObj = eval(rows[0]);
			var uuid = rowObj.uuid;
			var _url = editNewsUrl+"&uuid="+uuid;
			window.location.href=_url;
		}else{
			commonObj.alert("请选择一条记录!","warning");
		}
		event.preventDefault();
	});
$("#remove").click(function(){
		var rows = $("#newsTableId").datagrid('getChecked');
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
			$.messager.confirm('提示', '该操作不可逆，您确认删除选中新闻信息?', function(r){
				if (r){
					var _url = removenews+"&newsIds="+ids;
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
//表单提交成功后的回调方法
function successCallback(data){
	$.messager.progress("close");
	$("#newsTableId").datagrid('reload');
	commonObj.showResponse(data);
}
});
