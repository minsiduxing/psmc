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
function completeTask(jsonStr){
	obj = JSON.parse(jsonStr);
	var flow_entrance = obj.flow_entrance;
	var taskKey = obj.task_step_key;
	var tfi_uuid = obj.tfi_uuid;
	var task_id = obj.task_id;
	var task_step_key = obj.task_step_key;

	var flow_cn_name = obj.flow_cn_name;
	var flow_start_time = obj.flow_start_time;
	var task_step_name = obj.task_step_name;
	var task_process_name = obj.task_process_name;

	var url = flow_entrance+"&pid="+tfi_uuid+"&taskId="+task_id+"&taskKey="+task_step_key
		+"&flow_cn_name="+flow_cn_name+"&flow_start_time="+flow_start_time+"&task_step_name="+task_step_name+"&task_process_name="+task_process_name;
	var param;
	//这里是测试流程的代码，和正式无关
	if(flow_entrance == 'http://127.0.0.1:8080/psmc/system/framework/tjyFlowTestController.do?method=submitTask'){
		if(taskKey == 'usertask1'){
			param = "variables[ywblx_hxr]=admin&variables[test]=admin2";
		}else if(taskKey == 'usertask2'){
			param = "variables[role_chief]=sys_manager";
		}else if(taskKey == 'audit'){
			param = "variables[chief_audit]=0&variables[ywblx_hxr]=cbadmin&variables[group_director]=17,ly_manager";
		}
	}else{
		window.location.href=url;
	}

	$.messager.progress();
	$.ajax({
		type: "POST",
		url: url,
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
 * 打开流程图
 * @param divId
 * @param url
 */
function openFlowchart(divId,url){
	$('#'+divId).window({
		maximizable:false,
		minimizable:false,
		collapsible:false,
		title:'流程图',
		width:"100%",
		height:"95%",
		modal:true,
		href:url
	});
}