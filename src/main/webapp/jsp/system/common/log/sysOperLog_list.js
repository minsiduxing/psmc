
var editdialog;



$(document).ready(function(){ 
	var option = {
		tabId:"sologTableId",
		toolbar:"toolbarId",
		url:getTabDataUrl,
		columns:[[   
		          /**
		           * 可以解决表格右边空白的问题，但是没办法自适应浏览器大小，暂时不用
		           * width:parseInt($(this).width()*0.3)
		           */
		          {field:'uuid',title:'唯一标示',hidden:true},
		          {field:'log_type',hidden:true}, 
		          {field:'log_type_name',title:"一级分类"}, 
		          {field:'log_sub_type',hidden:true}, 
		          {field:'log_sub_type_name',title:"二级分类"}, 
		          {field:'bussiness_uuid',title:'业务ID',hidden:true},  
		          {field:'operid',hidden:true}, 
		          {field:'opername',title:"操作人"},   
		          {field:'oper_date',title:"操作时间"},
		          {field:'oper_input',title:"输入",width:300,fixed:true},
		          {field:'oper_output',title:"输出",width:300,fixed:true},
		          {field:'oper_result_desc',title:"操作描述"},
		          {field:'oper_result',title:"操作结果"}
		         ] 
		      ]
	};
	//初始化日志信息列表
	commonObj.initPaginationGrid(option);
	
});




