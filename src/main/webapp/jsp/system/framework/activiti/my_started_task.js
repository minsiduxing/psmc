var editdialog;


$(document).ready(function(){ 
	var option = {
		tabId:"sologTableId",
		toolbar:"toolbarId",
		url:selectStartedByMeTasks,
		columns:[[   
				{field:'tfi_uuid',align:'center',title:'流程实例id',hidden:true},
				{field:'tfc_uuid',align:'center',title:'流程配置id',hidden:true},
				{field:'flow_entrance',align:'center',title:"流程操作入口",hidden:true},
				{field:'task_step_key',align:'center',title:"当前任务key",hidden:true},
				{field:'flow_no',align:'center',title:"流程编号",width:$(this).width() * 0.2},
				{field:'flow_cn_name',align:'center',title:"流程名称",width:$(this).width() * 0.2},
				{field:'flow_en_name',align:'center',title:"流程英文名称",width:$(this).width() * 0.2},
				{field:'flow_version',align:'center',title:"流程版本",width:$(this).width() * 0.2},
				{field:'flow_state_name',align:'center',title:"流程状态",width:$(this).width() * 0.2},
				{field:'flow_start_time',align:'center',title:"流程开始时间",width:$(this).width() * 0.2},
				{field:'flow_end_time',align:'center',title:"流程结束时间",width:$(this).width() * 0.2},
				{field:' ',align:'center',title:"操作",width:$(this).width() * 0.2,formatter: function (value, row, index) {
						return "<a href='javascript:void(0)' onclick='initFlowDialog(&apos;" + row['tfi_uuid'] + "&apos;)'>流程信息</a>";
					}}
			]
		]
	};
	//初始化待接收任务列表
	commonObj.initPaginationGrid(option);

	
});

/**
 * 打开查看流程流转信息的dialog
 */
var flowdialog;
function initFlowDialog(ftiUuid){
	var url = getFlowShowInfoUrl+"?ftiUuid="+ftiUuid;
	flowdialog = $("#flowdialogDiv").dialog({
		modal: true,
		closed: true,
		width: "100%",
		height: "100%",
		resizable:true,
		cache: false,
		maximized:true,
		href:url
	});
	flowdialog.dialog({align:'center',title:"流程信息"});
	flowdialog.dialog("open");

}



