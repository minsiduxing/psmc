$(document).ready(function(){
    var option = {
        id:"ansjCommonFlowAccordDiv",
        fit:true,
        animate:true,
        multiple:false,//同时展开多个面板
        onSelect:function(){
            debugger;
            var pp = $('#ansjCommonFlowAccordDiv').accordion('getSelected');
            title = pp.panel("options").title;
            if("任务流转历史" == title){
                var option = {
                        tabId:"sologTableId",
                        url:selectProcessedTasks,
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
                            {field:'flow_end_time',align:'center',title:"流程结束时间",width:$(this).width() * 0.2}
                        ]
                    ]
                };
                //初始化本流程已完成任务
                commonObj.initPaginationGrid(option);
            }

            if("任务流转附件" == title){
                var option = {
                    tabId:"attachmentTableId",
                    url:selectProcessedTaskAttachmentsByPid,
                    columns:[[
                        {field:'flow_cn_name',align:'center',title:"流程名称",width:$(this).width() * 0.2},
                        {field:'task_id',align:'center',title:"任务id",hidden:true},
                        {field:'task_step_name',align:'center',title:"当前任务名称",width:$(this).width() * 0.2},
                        {field:'task_process_name',align:'center',title:"任务处理人",width:$(this).width() * 0.2},
                        {field:'task_start_time',align:'center',title:"任务开始时间",width:$(this).width() * 0.2},
                        {field:'task_end_time',align:'center',title:"任务结束时间",width:$(this).width() * 0.2},
                        {field:'task_state_name',align:'center',title:"任务状态",width:$(this).width() * 0.2},
                        {field:'file_name',align:'center',title:"操作",width:$(this).width() * 0.2,formatter: function (value, row, index) {
                                return "<a href='"+row['file_prefix']+row['file_path']+"'>"+row['file_name']+"</a>";
                            }}
                    ]
                    ]
                };
                //初始化本流程已完成任务
                commonObj.initPaginationGrid(option);
            }
        }
    };
    commonObj.initAccordionPanel(option);

    $("#ansjCommonFlowAccordDiv").accordion('add', {
        title:"流程图",
        animate:true,
        cache:true,
        selected:false,
        href:getFlowImgByInstanceId
    });
});




