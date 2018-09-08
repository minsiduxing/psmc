$(document).ready(function(){ 
	//是否隐藏列
	var isHide = true;
	//如果是合理化建议，需要显示
	if($("#reportType").val() == 'advice'){
		isHide = false;
	}
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
                  {field:'releaseStatus',title:'发布状态',align:'center',sortable:true,hidden:isHide,formatter:function(value, row, index){
                	  if(value == 1){
                		  return "已发布";
                	  }else{
                		  return "未发布";
                	  }
                  }},
                  {field:'releasePersonName',title:'发布人',align:'center',sortable:true,hidden:isHide},
                  {field:'releaseDate',title:'发布时间',align:'center',sortable:true,hidden:isHide},
                  {field:'laudNums',title:'点赞数',align:'center',sortable:true,hidden:isHide,formatter:function(value, row, index){
		        	  if(value==null || value==''){
		        		  return 0;
		        	  }else{
		        		  return "<a href='javascript:void(0)' onclick='openLaudListDialog(&apos;" + row['reportUuid'] + "&apos;)'>"+value+"</a>";
		        	  }
		          }},
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
    //发布
    $("#advicePublish").click(function(){
        var rows = $("#reportList").datagrid('getChecked');
        var rlength = rows.length;
        var ids="";
        if (rlength >= 1){
            for(var i=0;i<rlength;i++){
                var rowObj = eval(rows[i]);
                var newsid = rowObj.reportUuid;
                var releaseStatus = rowObj.releaseStatus;
                if(releaseStatus==1){
                    commonObj.alert('请选择未发布的合理化建议信息！',"warning");
                    return ;
                }
                ids+=newsid;
                if(i<rlength-1)
                    ids+=",";
            }
            $.messager.confirm('提示', '确认发布选中信息?', function(r){
            	if(r){
            		var _url = releaseOrCancelRelease+"&reportUuids="+ids+"&releaseStatus=1";
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
            	}
            });
        }else{
            commonObj.alert('请至少选择一条信息!',"warning");
            return ;
        }
        $.messager.progress("close");
        event.preventDefault();
    });
    //取消发布
    $("#advicePublishCancel").click(function(){
        var rows = $("#reportList").datagrid('getChecked');
        var rlength = rows.length;
        var ids="";
        if (rlength >= 1){
            for(var i=0;i<rlength;i++){
                var rowObj = eval(rows[i]);
                var newsid = rowObj.reportUuid;
                var releaseStatus = rowObj.releaseStatus;
                if(releaseStatus==2){
                    commonObj.alert('请选择已经发布的合理化建议信息！',"warning");
                    return ;
                }
                ids+=newsid;
                if(i<rlength-1)
                    ids+=",";
            }
            $.messager.confirm('提示', '确认取消发布选中信息?', function(r){
            	if(r){
            		var _url = releaseOrCancelRelease+"&reportUuids="+ids+"&releaseStatus=2";
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

//点赞信息dialog
var laudListdialog;
function iniLaudListtDialog(){
	laudListdialog = $("#laudListDiv").dialog({
		modal: true,
		closed: true,
	    width: 500,
	    height: 410,
	    resizable:true,
	    cache: false
	});
}

function openLaudListDialog(topicUuid){
	if(!laudListdialog){
		iniLaudListtDialog();
	}
	laudListdialog.panel({title:"点赞人员"});
	laudListdialog.window("open");
	$("#moduleUuid").val(topicUuid);
	initLaudDataGrid(topicUuid);
}
//初始化点赞列表数据
function initLaudDataGrid(topicUuid){
	var option = {
			tabId:"laudList",
			toolbar:"toolbarId2",
			striped:true,
			url:queryLaudListUrl + "&uuid="+topicUuid + "&businessType=report" ,
			columns:[[   
			          {field:'laud_uuid',title:'主键id',hidden:true},  
			          {field:'infoName',title:'信息名称',align:'center',sortable:true},
			          {field:'laud_person_name',title:'点赞人姓名',align:'center',sortable:true}, 
			          {field:'laud_date',title:'点赞时间',align:'center',sortable:true},
			          {field:'module_uuid',title:'信息id',hidden:true}
			         ] 
			      ]
		};
		//初始化列表
		commonObj.initPaginationGrid(option);
}

//导出
function exportExcel(){
	var moduleUuid = $("#moduleUuid").val();
	window.location = exportLaudListUrl + "&moduleUuid=" + moduleUuid + "&businessType=report";
}

