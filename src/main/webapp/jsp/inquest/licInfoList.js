$(document).ready(function(){

    var licInfoOption = {
        tabId:"licInfoList",
        url:selectLicInfoPageUrl,
        columns:[[
            {field:'licUuid',title:'主键',checkbox:true},
            {field:'licNo',title:'许可证号',resizable:true,align:'center',width:$(this).width() * 0.2},
            {field:'gridName',title:'归属网格名称',width:$(this).width() * 0.2},
            {field:'longitude',title:'经纬度坐标',width:$(this).width() * 0.2,formatter: function (value, row, index) {
                    return row.longitude + "," + row.latitude;
                }},
            {field:'isNotConsult',title:'不作为参考物',align:'center',width:$(this).width() * 0.2,formatter: function (value, row, index) {
                    if(value == 1){
                        return "是";
                    }else{
                        return "否";
                    }
                }},
            {field:'notConsultTypeName',title:'不作为参考物类型',align:'center',width:$(this).width() * 0.2},
            {field:'licStatusName',title:'许可证状态',align:'center',width:$(this).width() * 0.2},
            {field:'closeDecideTime',title:'歇业决定时间',align:'center',width:$(this).width() * 0.2}
        ]
        ],
    };
    //初始化列表
    commonObj.initPaginationGrid(licInfoOption);
});

//表单提交成功后的回调方法
function successCallback(data){
    $.messager.progress("close");
    $("#licInfoList").datagrid('reload');
    commonObj.showResponse(data);
}








