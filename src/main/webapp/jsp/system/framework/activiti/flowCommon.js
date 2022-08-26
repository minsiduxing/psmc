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
function completeTask(tfi_uuid,flow_entrance,task_id,taskKey){
	var url = flow_entrance+"?pid="+tfi_uuid+"&taskId="+task_id+"&taskKey="+taskKey;
	var param;
	//这里是测试流程的代码，和正式无关
	if(flow_entrance == '/system/framework/tjyFlowTestController.do?method=submitTask'){
		if(taskKey == 'usertask1'){
			param = "taskId="+taskId+"&variables[ywblx_hxr]=admin&variables[test]=admin2";
		}else if(taskKey == 'usertask2'){
			param = "taskId="+taskId+"&variables[role_chief]=sys_manager";
		}else if(taskKey == 'audit'){
			param = "taskId="+taskId+"&variables[chief_audit]=0&variables[ywblx_hxr]=cbadmin&variables[group_director]=17,ly_manager";
		}else{
			param = "taskId="+taskId;
		}
	}else{
		//这里打开流程操作的showdialog窗口
		openFlowOperDialog(url);
		return;
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
function openFlowDialog(ftiUuid){
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


/**
 * 打开查看流程操作信息的dialog
 */
var flowOperdialog;
function openFlowOperDialog(url){
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
	flowOperdialog.dialog({align:'center',title:"流程操作"});
	flowOperdialog.dialog("open");
}

