$(document).ready(function(){
    //new datagrid 初始化
    var itemCfgOption = {
        tabId:"itemCfgList",
        toolbar:"toolbarId",
        url:selectItemCfgListUrl,
        columns:[[
            /**
             * 可以解决表格右边空白的问题，但是没办法自适应浏览器大小，暂时不用
             * width:parseInt($(this).width()*0.3)
             */
            {field:'itemUuid',title:'题目主键',checkbox:true},
            {field:'stageName',title:'阶段名称',resizable:true,align:'center',width:$(this).width() * 0.2},
            {field:'questionType',title:'题目类型',align:'center',width:$(this).width() * 0.2,formatter: function (value, row, index) {
                    if(value=='1'){return "单选"; }
                    if(value=='2'){return "多选"; }
                }},
            {field:'questionName',title:'题目名称',halign:'center',width:"60%"},
            // {field:'isAffectedBsg',title:'是否受特殊群体影响',width:$(this).width() * 0.2,align:'center',formatter: function (value, row, index) {
            //         if(value){
            //             return "是";
            //         }else{
            //             return "否";
            //         }
            //     }},
            {field:'isAffectedJlcl',title:'是否距离测算',width:$(this).width() * 0.2,align:'center',formatter: function (value, row, index) {
                    if(value){
                        return "是";
                    }else{
                        return "否";
                    }
                }},
            {field:'isAffectedBhdcs',title:'是否饱和度测算',width:$(this).width() * 0.2,align:'center',formatter: function (value, row, index) {
                    if(value){
                        return "是";
                    }else{
                        return "否";
                    }
                }},
            // {field:'displayAtlas',title:'配图地址',align:'center',width:$(this).width() * 0.2},
            // {field:'displayVidio',title:'视频地址',align:'center',width:$(this).width() * 0.2},
            //{field:'createTime',title:'创建时间',align:'center',width:$(this).width() * 0.2,align:'center'}
        ]
        ],
    };
    //初始化列表
    commonObj.initPaginationGrid(itemCfgOption);

    //这段代码是获取当前页的所有行
    /*var rows = $("#itemCfgList").datagrid("getRows");
    $("#itemCfgList").datagrid("deleteRow",_index);
    $("#itemCfgList").datagrid('appendRow',{});*/

    //新增
    $("#add").click(function(){
        var _url = toYcInquestItemEditUrl+"&isEdit="+"add";
        window.location.href=_url;
        event.preventDefault();
    });

    //编辑
    $("#edit").click(function(){
        var rows = $("#itemCfgList").datagrid('getChecked');
        if (rows.length == 1){
            var rowObj = eval(rows[0]);
            var uuid = rowObj.itemUuid;
            var _url = toYcInquestItemEditUrl+"&uuid="+uuid+"&isEdit="+"edit";
            window.location.href=_url;
        }else{
            commonObj.alert("请选择一条记录!","warning");
        }
        event.preventDefault();
    });

    //查看
    $("#priview").click(function(){
        var rows = $("#itemCfgList").datagrid('getChecked');
        if (rows.length == 1){
            var rowObj = eval(rows[0]);
            var uuid = rowObj.itemUuid;
            var _url = toYcInquestItemEditUrl+"&uuid="+uuid+"&isEdit="+"query";
            window.location.href=_url;
        }else{
            commonObj.alert("请选择一条记录!","warning");
        }
        event.preventDefault();
    });

    //删除
    $("#remove").click(function(){
        var rows = $("#itemCfgList").datagrid('getChecked');
        var rlength = rows.length;
        var ids="";
        if (rlength > 0){
            for(var i=0;i<rlength;i++){
                var rowObj = eval(rows[i]);
                var uuid = rowObj.itemUuid;
                ids+=uuid;
                if(i<rlength-1)
                    ids+=",";
            }
            $.messager.confirm('提示', '该操作不可逆，您确认删除选中信息?', function(r){
                if (r){
                    var _url = deleteInquestItemUrl+"&itemUuids="+ids;
                    $.messager.progress();
                    $.ajax({
                        type: "POST",
                        url: _url,
                        success: function(data){
                            successCallback(data);
                        },
                        error:function(XMLHttpRequest, textStatus, errorThrown){
                            commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
                            $.messager.progress("close");
                        }
                    });
                }
            });

        }else{
            commonObj.alert("请选择至少一条记录!","warning");
        }
        $.messager.progress("close");
        event.preventDefault();
    });


});

//表单提交成功后的回调方法
function successCallback(data){
    $.messager.progress("close");
    $("#itemCfgList").datagrid('reload');
    commonObj.showResponse(data);
}








