var editdialog;


$(document).ready(function(){ 
	var option = {
		tabId:"sologTableId",
		toolbar:"toolbarId",
		url:selectWaitProcessTasksUrl,
		columns:[[
				{field:'tfi_uuid',align:'center',title:'流程实例id',hidden:true},
				{field:'tfc_uuid',align:'center',title:'流程配置id',hidden:true},
				{field:'flow_entrance',align:'center',title:"流程操作入口",hidden:true},
				{field:'task_step_key',align:'center',title:"当前任务key",hidden:true},
				{field:'flow_no',align:'center',title:"流程编号",width:$(this).width() * 0.2},
				{field:'flow_cn_name',align:'center',title:"流程名称",width:$(this).width() * 0.2},
				// {field:'flow_en_name',align:'center',title:"流程英文名称",width:$(this).width() * 0.2},
				// {field:'flow_version',align:'center',title:"流程版本",width:$(this).width() * 0.2},
				{field:'flow_state_name',align:'center',title:"流程状态",width:$(this).width() * 0.2},
				{field:'flow_start_time',align:'center',title:"流程开始时间",width:$(this).width() * 0.2},
				// {field:'flow_end_time',align:'center',title:"流程结束时间",width:$(this).width() * 0.2},
				{field:'task_id',align:'center',title:"任务id",hidden:true},
				{field:'task_step_name',align:'center',title:"任务名称",width:$(this).width() * 0.2},
				{field:'claim_time',align:'center',title:"任务接收时间",width:$(this).width() * 0.2},
				{field:'task_process_name',align:'center',title:"当前处理人",width:$(this).width() * 0.2},
				{field:'task_start_time',align:'center',title:"任务开始时间",width:$(this).width() * 0.2},
				// {field:'task_end_time',align:'center',title:"任务结束时间",width:$(this).width() * 0.2},
				{field:'task_state_name',align:'center',title:"任务状态",width:$(this).width() * 0.2},
				{field:' ',align:'center',title:"操作",width:$(this).width() * 0.2,formatter: function (value, row, index) {
					return "<a href='javascript:void(0)' onclick='unclaimTask(&apos;" + row['task_id'] + "&apos;)'>释放</a>&nbsp;&nbsp;" +
						"<a href='javascript:void(0)' onclick='completeTask(&apos;"+JSON.stringify(row)+ "&apos;)'>处理</a>";
				}}
			]
		]
	};
	//初始化待接收任务列表
	commonObj.initPaginationGrid(option);
});




