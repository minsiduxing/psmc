$(document).ready(function(){

    var licInfoOption = {
        tabId:"licInfoList",
        toolbar:"toolbarId",
        url:selectLicInfoPageUrl,
        columns:[[
            {field:'licUuid',title:'主键',checkbox:true},
            {field:'gridName',title:'网格名称',align:'center',width:"100px"},
            {field:'managerName',title:'负责人姓名',resizable:true,align:'center',width:"100px"},
            {field:'lineTel',title:'联系电话',resizable:true,align:'center',width:"100px"},
            {field:'companyName',title:'企业名称',align:'center',resizable:true,width:"200px"},
            {field:'businessAddr',title:'经营地址',align:'left',width:"200px"},
            {field:'ecoTypeName',title:'经济类型',resizable:true,align:'center',width:"100px"},
            {field:'licNo',title:'许可证号',resizable:true,align:'center',width:"100px"},
            {field:'licStatusName',title:'许可证状态',align:'center',width:"100px"},
            {field:'coordinate',title:'零售户坐标',align:'center',width:"150px"},
            {field:'isNotConsult',title:'是否作为参考物',align:'center',width:"100px",formatter: function (value, row, index) {
                    if(value == 1){
                        return "是";
                    }else{
                        return "否";
                    }
                }},
            {field:'notConsultTypeName',title:'不作为参考物类型',align:'center',width:"120px"},
            {field:'closeDecideTime',title:'失效时间',align:'center',width:"100px"},
            {field:'licStartDate',title:'许可证有效期起',resizable:true,align:'center',width:"100px"},
            {field:'licEndDate',title:'许可证有效期止',resizable:true,align:'center',width:"100px"},
            {field:'orgName',title:'所属专卖局',resizable:true,width:"100px"}
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








