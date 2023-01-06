$(document).ready(function(){

    var waitQueueCfgOption = {
        tabId:"waitQueueCfgList",
        toolbar:"toolbarId",
        url:selectWaitQueueCfgPageUrl,
        columns:[[
            {field:'cfgUuid',title:'主键',checkbox:true},
            {field:'orgName',title:'所属专卖局',resizable:true,align:'center',width:$(this).width() * 0.2},
            {field:'defaultCoordinate',title:'缺省坐标',align:'center',width:$(this).width() * 0.2},
            {field:'contactAddress',title:'联系地址',width:$(this).width() * 0.2},
            {field:'contactTel',title:'联系电话',align:'center',width:$(this).width() * 0.2},
            {field:'addressCoordinate',title:'联系地址坐标',align:'center',width:$(this).width() * 0.2},
            {field:'workTime',title:'工作时间',width:$(this).width() * 0.2},
            {field:'isFictitiousGrid',title:'是否启用虚拟网格',width:$(this).width() * 0.2,align:'center',formatter: function (value, row, index) {
                    if(value == 1){
                        return "是";
                    }else{
                        return "否";
                    }
                }},
            {field:'overdueDays',title:'轮候超期时限',align:'center',width:$(this).width() * 0.2},
            {field:'isClosedRetain',title:'是否启用歇业保留',width:$(this).width() * 0.2,align:'center',formatter: function (value, row, index) {
                    if(value == 1){
                        return "是";
                    }else{
                        return "否";
                    }
                }},
            {field:'closedRetainDays',title:'歇业保留天数',align:'center',width:$(this).width() * 0.2},
            {field:'createTime',title:'创建时间',align:'center',width:$(this).width() * 0.2}

        ]
        ],
    };
    //初始化列表
    commonObj.initPaginationGrid(waitQueueCfgOption);
});

//表单提交成功后的回调方法
function successCallback(data){
    $.messager.progress("close");
    $("#waitQueueCfgList").datagrid('reload');
    commonObj.showResponse(data);
}








