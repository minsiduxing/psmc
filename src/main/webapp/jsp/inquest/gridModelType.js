var editdialog;

$(document).ready(function(){
    var option = {
        tabId:"sologTableId",
        toolbar:"toolbarId",
        showHeader:false,
        url:getTabDataUrl,
        columns:[[
            /**
             * 可以解决表格右边空白的问题，但是没办法自适应浏览器大小，暂时不用
             * width:parseInt($(this).width()*0.3)
             */
            {field:'GRID_UUID',align:'center',title:'唯一标示',hidden:true},
            {field:'GRID_MTYPE_NAME',align:'center',title:"测算类别名称",width:$(this).width() * 0.2},
            {field:'LEGAL_PROVISION_DESC',align:'left',title:"测算类别依据",width:$(this).width() * 1},
            {field:'ORG_NAME',align:'center',title:"所属专卖局",width:$(this).width() * 0.2},
            {field:'11',align:'center',title:"操作结果",width:$(this).width() * 0.2}
        ]
        ]
    };
    //初始化日志信息列表
    commonObj.initPaginationGrid(option);
});

commonObj.initDictCombobox("log_type","LOG_TYPE",null,false,true);
commonObj.initDictCombobox("log_sub_type","LOG_SUB_TYPE",null,false,true);

$('#opername').textbox({
    iconAlign:'left'
});

$("#add").click(function(){
    $('#ruleWin').window({
        maximizable:false,
        minimizable:false,
        collapsible:false,
        title:'网格下属规则',
        width:"100%",
        height:"95%",
        modal:true,
        onBeforeClose:function (){
            //循环删除全部的tab
            var len = $('#ruleAccordion').tabs("tabs").length;
            for(var i=0;i<len;i++){
                $('#ruleAccordion').tabs("close",0);
            }
        }
    });
    $('#ruleAccordion').tabs({
        animate:true
    });
    $("#ruleAccordion").tabs('add', {
        title:"店面面向街道",
        animate:true,
        cache:false,
        selected:true,
        href:girdRuleQueryUrl
    });
    $("#ruleAccordion").tabs('add', {
        title:"店面面向小巷",
        animate:true,
        cache:false,
        selected:false,
        href:girdRuleQueryUrl2
    });
});





