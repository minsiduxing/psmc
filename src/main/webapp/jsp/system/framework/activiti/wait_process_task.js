var editdialog;


$(document).ready(function(){ 
	var option = {
		tabId:"sologTableId",
		toolbar:"toolbarId",
		url:getTabDataUrl,
		columns:[[   
				{field:'tfi_uuid',title:'流程实例id',hidden:true},
				{field:'tfi_uuid',title:'流程实例id',hidden:true},
				{field:'flow_entrance',title:"流程操作入口",hidden:true},
				{field:'task_step_key',title:"当前任务key",hidden:true},
				{field:'flow_no',title:"流程编号",width:$(this).width() * 0.2},
				{field:'flow_cn_name',title:"流程名称",width:$(this).width() * 0.2},
				{field:'flow_en_name',title:"流程英文名称",width:$(this).width() * 0.2},
				{field:'flow_version',title:"流程版本",width:$(this).width() * 0.2},
				{field:'flow_state_name',title:"流程状态",width:$(this).width() * 0.2},
				{field:'flow_start_time',title:"流程开始时间",width:$(this).width() * 0.2},
				{field:'flow_end_time',title:"流程结束时间",width:$(this).width() * 0.2},
				{field:'task_id',title:"任务id",hidden:true},
				{field:'task_step_name',title:"当前任务名称",width:$(this).width() * 0.2},
				{field:'claim_time',title:"接收时间",width:$(this).width() * 0.2},
				{field:'task_process_name',title:"处理人",width:$(this).width() * 0.2},
				{field:'task_start_time',title:"任务开始时间",width:$(this).width() * 0.2},
				{field:'task_end_time',title:"任务结束时间",width:$(this).width() * 0.2},
				{field:'task_state',title:"任务状态",width:$(this).width() * 0.2},
				{field:'oper_result',title:"操作",width:$(this).width() * 0.2}
			]
		]
	};
	//初始化待接收任务列表
	commonObj.initPaginationGrid(option);
	
});




