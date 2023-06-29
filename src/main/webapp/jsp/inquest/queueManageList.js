$(document).ready(function(){

    var queueManageOption = {
        tabId:"queueManageList",
        toolbar:"toolbarId",
        url:selectQueueManagePageUrl,
        columns:[[
            {field:'queueUuid',title:'主键',checkbox:true},
            {field:'caozuo',title:'操作',align:'center',width:"100px", formatter:function (value, row, index) {
                    if(row.applyStatus == '1901'){
                        return '<a id="notice" href="">通知</a>' + '<a style="margin-left: 6px;" id="finish" href="">完成</a>';
                    }else if(row.applyStatus == '1902'){
                        return '<a id="notice" href="">受理</a>' + '<a style="margin-left: 6px;" id="finish" href="">完成</a>';
                    }else if(row.applyStatus == '1903'){
                        return '<a id="finish" href="">完成</a>';
                    }else{
                        return '';
                    }
                }},
            {field:'isPriority',title:'是否优先办理',width:"100px",align:'center',formatter: function (value, row, index) {
                    if(value == 1){
                        return "是["+row.priorityCondition+"]";
                    }else{
                        return "否";
                    }
            }},
            {field:'createTime',title:'申请时间',resizable:true,align:'center',width:"150px"},
            {field:'applyStatusName',title:'申请状态',align:'center',width:"100px"},
            {field:'noticeDate',title:'通知日期',align:'center',width:"100px"},
            {field:'gridName',title:'网格名称',align:'center',width:"100px"},
            // {field:'coordinate',title:'经纬度坐标',align:'center',width:"100px"},
            {field:'managerName',title:'经营者姓名',align:'center',width:"100px"},
            {field:'lineTel',title:'联系电话',align:'center',width:"100px"},
            {field:'companyName',title:'企业名称',align:'center',width:"150px"},
            {field:'creditNo',title:'社信代码',align:'center',width:"150px"},
            {field:'businessAddr',title:'经营地址',width:"300px"},
            // {field:'priorityCondition',title:'优先条件',align:'center',width:"100px"},
            {field:'finishTime',title:'办理完成时间',align:'center',width:"150px"},
            {field:'finishTypeName',title:'办理完成结果',align:'center',width:"100px"},
            {field:'orgName',title:'所属专卖局',align:'center',width:"150px"}
            // {field:'remark',title:'备注',width:"100px"},
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








