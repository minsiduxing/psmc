
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
		          {field:'id',align:'center',title:'唯一标示',hidden:true},
		          {field:'sys_key',align:'center',title:"系统配置【键】",width:$(this).width() * 0.3},
			      {field:'sys_value',align:'center',title:"系统配置【值】",width:$(this).width() * 0.3},
				  {field:'remark',align:'center',title:"描述",width:$(this).width() * 0.3}
		         ] 
		      ]
	};
	//初始化日志信息列表
	commonObj.initPaginationGrid(option);
	
});




