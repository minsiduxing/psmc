$(document).ready(function(){

    var regionCoordinateOption = {
        tabId:"regionCoordinateList",
        url:selectRegionCoordinatePageUrl,
        columns:[[
            {field:'coordUuid',title:'主键',checkbox:true},
            {field:'regionTypeName',title:'区域类型',align:'center',width:$(this).width() * 0.2},
            {field:'regionName',title:'区域名称',width:$(this).width() * 0.2},
            {field:'coordinate',title:'经纬度坐标',align:'center',width:$(this).width() * 0.2},
            {field:'isActive',title:'状态',width:$(this).width() * 0.2,align:'center',formatter: function (value, row, index) {
                    if(value == 1){
                        return "启用";
                    }else{
                        return "停用";
                    }
                }},
            {field:'createTime',title:'创建时间',align:'center',width:$(this).width() * 0.2,align:'center'}
        ]
        ],
    };
    //初始化列表
    commonObj.initPaginationGrid(regionCoordinateOption);
});

//表单提交成功后的回调方法
function successCallback(data){
    $.messager.progress("close");
    $("#regionCoordinateList").datagrid('reload');
    commonObj.showResponse(data);
}








