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
	debugger;
	var url = flow_entrance+"&pid="+tfi_uuid+"&taskId="+task_id+"&taskKey="+taskKey;
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
		//这里打开流程操作的showdialog窗口
		openFlowOperDialog(url);
		return;
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
 * 基于主页面的查询条件（Accordion面板组件）动态增加一些展示面板，如流程图展示等，后续可以集成流程操作等。
 * mark：最早实现方式是在主页面弹出dialog，然后在增加流程展示、操作的ccordion，但是这种方式会导致主页面的查询条件（ccordion）组件异常，解决好多次解决不了。
 * accordionId 主界面的组件id
 * url 动态加载面板的url
 */
function dynamicAddAccordion(accordionId,panelName,url){
	debugger;
	$("#"+accordionId).accordion('add', {
		title:panelName,
		closable:true,
		animate:true,
		cache:false,
		href:url
	});
}
