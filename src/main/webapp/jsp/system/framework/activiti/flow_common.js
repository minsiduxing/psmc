//领取任务
function claimTask(taskId){
	$.messager.progress();
	$.ajax({
		type: "POST",
		url: claimTaskUrl,
		data: "&taskId="+taskId,
		success: function(data){
			successCallback(data);
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
			$.messager.progress("close");
		}
	});
}
//释放任务
function unclaimTask(taskId){
	$.messager.progress();
	$.ajax({
		type: "POST",
		url: unclaimTaskUrl,
		data: "taskId="+taskId,
		success: function(data){
			successCallback(data);
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
			$.messager.progress("close");
		}
	});
}
//处理任务
function completeTask(taskId,taskKey){
	var param;
	if(taskKey == 'usertask1'){
		param = "taskId="+taskId+"&variables[ywblx_hxr]=admin&variables[test]=admin2";
	}else if(taskKey == 'usertask2'){
		param = "taskId="+taskId+"&variables[role_chief]=sys_manager";
	}else if(taskKey == 'audit'){
		param = "taskId="+taskId+"&variables[chief_audit]=0&variables[ywblx_hxr]=cbadmin&variables[group_director]=17,ly_manager";
	}else{
		param = "taskId="+taskId;
	}
	$.messager.progress();
	$.ajax({
		type: "POST",
		url: completeTaskUrl,
		data: param,
		success: function(data){
			successCallback(data);
		},
		error:function(XMLHttpRequest, textStatus, errorThrown){
			commonObj.showError(XMLHttpRequest, textStatus, errorThrown);
			$.messager.progress("close");
		}
	});
}

//表单提交成功后的回调方法
function successCallback(data){
	$.messager.progress("close");
	$("#sologTableId").datagrid('reload');
	commonObj.showResponse(data);
}

/**
 * 打开查看流程流转信息的dialog
 */
var flowdialog;
function initFlowDialog(ftiUuid){
	var url = getFlowShowInfoUrl+"?ftiUuid="+ftiUuid;
	flowdialog = $("#flowdialogDiv").dialog({
		modal: true,
		closed: true,
		width: "100%",
		height: "100%",
		resizable:true,
		cache: false,
		maximized:true,
		href:url
	});
	flowdialog.dialog({align:'center',title:"流程信息"});
	flowdialog.dialog("open");

}


