$(document).ready(function(){

    var queueManageOption = {
        tabId:"queueManageList",
        url:selectQueueManagePageUrl,
        columns:[[
            {field:'queueUuid',title:'主键',checkbox:true},
            {field:'createTime',title:'登记时间',resizable:true,align:'center',width:$(this).width() * 0.2},
            {field:'gridName',title:'归属网格名称',width:$(this).width() * 0.2},
            {field:'companyName',title:'企业名称',width:$(this).width() * 0.2},
            {field:'managerName',title:'经营者姓名',align:'center',width:$(this).width() * 0.2},
            {field:'creditNo',title:'统一社会信用代码',align:'center',width:$(this).width() * 0.2},
            {field:'businessAddr',title:'经营地址',width:$(this).width() * 0.2},
            {field:'lineTel',title:'联系电话',align:'center',width:$(this).width() * 0.2},
            {field:'isPriority',title:'是否优先',width:$(this).width() * 0.2,align:'center',formatter: function (value, row, index) {
                    if(value == 1){
                        return "是";
                    }else{
                        return "否";
                    }
                }},
            {field:'priorityCondition',title:'优先条件',width:$(this).width() * 0.2},
            {field:'lineTel',title:'联系电话',align:'center',width:$(this).width() * 0.2},
            {field:'applyStatusName',title:'申请状态',align:'center',width:$(this).width() * 0.2},
            {field:'applyStatus',title:'申请状态',hidden:true,align:'center',width:$(this).width() * 0.2},
            {field:'noticeDate',title:'通知日期',align:'center',width:$(this).width() * 0.2},
            {field:'finishTypeName',title:'完成情形',width:$(this).width() * 0.2},
            {field:'finishTime',title:'完成时间',align:'center',width:$(this).width() * 0.2},
            {field:'remark',title:'备注',width:$(this).width() * 0.2},
            {field:'caozuo',title:'操作',align:'center',width:$(this).width() * 0.2, formatter:function (value, row, index) {
                    if(row.applyStatus == '1901'){
                        return '<a id="accept" href="">受理</a>' + '<a style="margin-left: 6px;" id="finish" href="">完成</a>';
                    }else if(row.applyStatus == '1902'){
                        return '<a id="notice" href="">通知</a>' + '<a style="margin-left: 6px;" id="finish" href="">完成</a>';
                    }else if(row.applyStatus == '1903'){
                        return '<a id="finish" href="">完成</a>';
                    }else{
                        return '';
                    }
            }}
        ]
        ],
    };
    //初始化列表
    commonObj.initPaginationGrid(queueManageOption);
});

//表单提交成功后的回调方法
function successCallback(data){
    $.messager.progress("close");
    $("#queueManageList").datagrid('reload');
    commonObj.showResponse(data);
}








