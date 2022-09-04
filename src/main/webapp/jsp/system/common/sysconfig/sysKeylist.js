
$(document).ready(function(){ 
	var option = {
		tabId:"sologTableId",
		toolbar:"toolbarId",
		url:getTabDataUrl,
		columns:[[   
		          {field:'id',align:'center',title:'唯一标示',hidden:true},
		          {field:'sys_key',align:'center',title:"键",width:$(this).width() * 0.3,
					  editor:{type:'text'}
					  },
			      {field:'sys_value',align:'center',title:"值",width:$(this).width() * 0.3},
				  {field:'remark',align:'center',title:"描述",width:$(this).width() * 0.3}
		         ] 
		      ]
	};
	//初始化日志信息列表
	commonObj.initPaginationGrid(option);
	
});




