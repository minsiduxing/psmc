var editdialog;

$(document).ready(function(){
    var option = {
        tabId:"sologTableId",
        toolbar:"toolbarId",
        showHeader:false,
        url:selectGridInfoList,
        columns:[[
            /**
             * 可以解决表格右边空白的问题，但是没办法自适应浏览器大小，暂时不用
             * width:parseInt($(this).width()*0.3)
             */
            {field:'GRID_UUID',align:'center',title:'唯一标示',checkbox:true},
            {field:'GRID_NAME',align:'center',title:"网格名称",width:$(this).width() * 0.2},
            {field:'GRID_TYPE_NAME',align:'center',title:"网格类型",width:$(this).width() * 0.2},
            {field:'GRID_PEPOLE_COUNT',align:'center',title:"网格人口数",width:$(this).width() * 0.2},
            {field:'PLANNING_ISSUE_CERT_TOTAL',align:'center',title:"规划办证数量",width:$(this).width() * 0.2},
            {field:'ACTUAL_ISSUE_CERT_TOTAL',align:'center',title:"已办证数量",width:$(this).width() * 0.2},
            {field:'IS_MAINTAIN_COORDINATE_NAME',align:'center',title:"已采集坐标",width:$(this).width() * 0.2,formatter: function (value, row, index) {
                    if(value == '是'){
                    return "<img style='width:20px;height:20px' title='网格坐标' onclick='gatherCoordinate(&apos;" + row['GRID_UUID'] + "&apos;)' src='../../js/jquery-easyui-1.4.5/themes/icons/extends/zuobiao.png'></img>";
                    }else{
                        return value;
                    }
                }},
            {field:'IS_CONFIGED_RULE_NAME',align:'center',title:"已配置规则",width:$(this).width() * 0.2,formatter: function (value, row, index) {
                    if(value == '是'){
                        return "<img style='width:15px;height:15px' title='网格测算'  src='../../js/jquery-easyui-1.4.5/themes/icons/extends/cesuan.png' onclick='gridhanleCertCacl(&apos;" + row['GRID_UUID'] + "&apos;)'></img>";
                    }else{
                        return value;
                    }
                }},
            {field:'GRID_MTYPE_NAME',align:'center',title:"测算类别名称",width:$(this).width() * 0.2},
            {field:'LEGAL_PROVISION_DESC',align:'left',title:"测算类别依据",width:$(this).width() * 1.5},
            {field:'ORG_NAME',align:'center',title:"所属专卖局",width:$(this).width() * 0.2}
        ]]
    };
    //初始化日志信息列表
    commonObj.initPaginationGrid(option);
});

commonObj.initDictCombobox("gridType","GRID_TYPE",null,false,true);
commonObj.initDictCombobox("isConfigEdRule","IF",null,false,true);
commonObj.initDictCombobox("isMaintainCoordinate","IF",null,false,true);
commonObj.initDictCombobox("GRID_MTYPE_NAME","IF",null,false,true);
commonObj.initBusinessDictCombobox("gridMtypeUuid",loadGridModelTypeDictListUrl,false,true);

$('#gridName').textbox({
    iconAlign:'left'
});

$("#add").click(function(){
    var rows = $("#sologTableId").datagrid('getChecked');
    if (rows.length == 1){
        var rowObj = eval(rows[0]);
        var gridModelType = rowObj.GRID_MODEL_TYPE;
        var gridUuid = rowObj.GRID_UUID;
        var _url = gridCaclUrl+"&gridModelType="+gridModelType+"&gridUuid="+gridUuid;
    }else{
        commonObj.alert("请选择一条记录!","warning");
        return;
    }
    $('#ruleWin').window({
        maximizable:false,
        minimizable:false,
        collapsible:false,
        title:'网格测算公式',
        fit:true,
        href:_url,
        modal:true,
        onBeforeClose:function (){
            //循环删除全部的tab
            // var len = $('#ruleAccordion').tabs("tabs").length;
            // for(var i=0;i<len;i++){
            //     $('#ruleAccordion').tabs("close",0);
            // }
        }
    });
});

/**
 * 网格坐标采集
 * @param gridUuid
 */
function gatherCoordinate (gridUuid) {
    $('#ruleWin').window({
        maximizable: false,
        minimizable: false,
        collapsible: false,
        title: '网格坐标采集',
        fit: true,
        content:"<iframe scrolling='auto' frameborder='0' src='https://www.amap.com/' style='width:100%; height:100%; display:block;'></iframe>",
        modal: true
    })
}

//表单提交成功后的回调方法
function successCallback(data){
    $.messager.progress("close");
    data = JSON.parse(data);
    $.messager.show({
        title:'测算结果',
        msg:data.result.msg,
        timeout:10000,
        width:"600px",
        height:"300px",
        showType:'slide'
    });
    // commonObj.alert(data.result.msg,"info");
}

/**
 * 网格测算
 * @param gridUuid
 */
function gridhanleCertCacl(gridUuid){
    $.messager.progress();
    $.ajax({
        type: "POST",
        url: gridhanleCertCaclUrl,
        data: "&gridUuid="+gridUuid,
        success: function(data){
            successCallback(data);
        },
        error:function(XMLHttpRequest, textStatus, errorThrown){
            commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
            $.messager.progress("close");
        }
    });
}





