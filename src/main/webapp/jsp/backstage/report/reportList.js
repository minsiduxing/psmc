$(document).ready(function(){ 
	// datagrid 初始化
	var reportListData = {
		tabId:"reportList",
		toolbar:"toolbarId",
		url:getReportList,
		columns:[[   
		          /**
		           * 可以解决表格右边空白的问题，但是没办法自适应浏览器大小，暂时不用
		           * width:parseInt($(this).width()*0.3)
		           */
		          {field:'reportUuid',title:'申报主键',checkbox:true},
		          {field:'reportTitle',title:'申报标题',resizable:true,align:'center',sortable:true,
                      formatter:function(value, row, index){
                        return "<a href='"+getReportReply+row.reportUuid+"'>"+value+"</a>";
                      }},
		          {field:'reportUserName',title:'申报人姓名',resizable:true,align:'center',sortable:true},
		          {field:'reportTime',title:'申报时间',align:'center',sortable:true},
                  {field:'reportTel',title:'申报电话',align:'center',sortable:true},
                  {field:'reportStatusName',title:'状态',align:'center',sortable:true},
		          {field:'reportStaus',title:'状态',hidden:true}
		         ]
		      ]
	};
	//初始化申报列表
	commonObj.initPaginationGrid(reportListData);
	//删除
$("#remove").click(function(){
		var rows = $("#reportList").datagrid('getChecked');
		var rlength = rows.length;
		var ids="";
		if (rlength > 0){
			for(var i=0;i<rlength;i++){
				var rowObj = eval(rows[i]);
				var reportUuid = rowObj.reportUuid;
				ids+=reportUuid;
				if(i<rlength-1)
					ids+=",";
			}
			$.messager.confirm('提示', '该操作不可逆，您确认删除选中信息?', function(r){
				if (r){
					var _url = removeRport+"&ids="+ids;
					$.messager.progress(); 
					$.ajax({
						   type: "DELETE",
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
//回复
$("#replyReport").click(function(){
	var rows = $("#reportList").datagrid('getChecked');
	var rlength = rows.length;
	var ids="";
	if (rlength == 1){
		for(var i=0;i<rlength;i++){
			var rowObj = eval(rows[i]);
			var newsid = rowObj.reportUuid;
			var reportStaus = rowObj.reportStaus;
			if(reportStaus==1){
				commonObj.alert('该信息已经回复！',"warning");
				return ;
			}
			ids+=newsid;
			if(i<rlength-1)
				ids+=",";
		}
		var _url = getReportReply+ids;
		 window.location.href =_url;
	}else{
		commonObj.alert('请选择一条信息!',"warning");
		return ;
	}
	$.messager.progress("close");
	event.preventDefault();
});
//处理
    $("#reportDeal").click(function(){
        var rows = $("#reportList").datagrid('getChecked');
        var rlength = rows.length;
        var ids="";
        if (rlength >= 1){
            for(var i=0;i<rlength;i++){
                var rowObj = eval(rows[i]);
                var newsid = rowObj.reportUuid;
                var reportStaus = rowObj.reportStaus;
                if(reportStaus==3){
                    commonObj.alert('请选择未处理的申报信息！',"warning");
                    return ;
                }
                ids+=newsid;
                if(i<rlength-1)
                    ids+=",";
            }
            var _url = updateRport+"&reportUuids="+ids+"&reportStatus=3";
            $.messager.progress();
            $.ajax({
                type: "PUT",
                url: _url,
                success: function(data){
                    successCallback(data);
                },
                error:function(XMLHttpRequest, textStatus, errorThrown){
                    commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
                    $.messager.progress("close");
                }
            });
        }else{
            commonObj.alert('请至少选择一条信息!',"warning");
            return ;
        }
        $.messager.progress("close");
        event.preventDefault();
    });
//受理
    $("#reportAccept").click(function(){
        var rows = $("#reportList").datagrid('getChecked');
        var rlength = rows.length;
        var ids="";
        if (rlength >= 1){
            for(var i=0;i<rlength;i++){
                var rowObj = eval(rows[i]);
                var newsid = rowObj.reportUuid;
                var reportStaus = rowObj.reportStaus;
                if(reportStaus==4){
                    commonObj.alert('请选择未受理的申报信息！',"warning");
                    return ;
                }
                ids+=newsid;
                if(i<rlength-1)
                    ids+=",";
            }
            var _url = updateRport+"&reportUuids="+ids+"&reportStatus=4";
            $.messager.progress();
            $.ajax({
                type: "PUT",
                url: _url,
                success: function(data){
                    successCallback(data);
                },
                error:function(XMLHttpRequest, textStatus, errorThrown){
                    commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
                    $.messager.progress("close");
                }
            });
        }else{
            commonObj.alert('请至少选择一条信息!',"warning");
            return ;
        }
        $.messager.progress("close");
        event.preventDefault();
    });
    //备案
    $("#reportRecord").click(function(){
        var rows = $("#reportList").datagrid('getChecked');
        var rlength = rows.length;
        var ids="";
        if (rlength >= 1){
            for(var i=0;i<rlength;i++){
                var rowObj = eval(rows[i]);
                var newsid = rowObj.reportUuid;
                var reportStaus = rowObj.reportStaus;
                if(reportStaus==5){
                    commonObj.alert('请选择未备案的申报信息！',"warning");
                    return ;
                }
                ids+=newsid;
                if(i<rlength-1)
                    ids+=",";
            }
            var _url = updateRport+"&reportUuids="+ids+"&reportStatus=5";
            $.messager.progress();
            $.ajax({
                type: "PUT",
                url: _url,
                success: function(data){
                    successCallback(data);
                },
                error:function(XMLHttpRequest, textStatus, errorThrown){
                    commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
                    $.messager.progress("close");
                }
            });
        }else{
            commonObj.alert('请至少选择一条信息!',"warning");
            return ;
        }
        $.messager.progress("close");
        event.preventDefault();
    });
//表单提交成功后的回调方法
function successCallback(data){
	$.messager.progress("close");
	$("#reportList").datagrid('reload');
	commonObj.showResponse(data);
}

});
