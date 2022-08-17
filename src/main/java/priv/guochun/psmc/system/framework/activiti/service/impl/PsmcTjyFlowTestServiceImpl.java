package priv.guochun.psmc.system.framework.activiti.service.impl;

import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import priv.guochun.psmc.system.framework.activiti.core.PsmcWorkFlowContext;
import priv.guochun.psmc.system.framework.activiti.service.PsmcTjyFlowTestService;
import priv.guochun.psmc.system.framework.model.MsgModel;

public class PsmcTjyFlowTestServiceImpl implements PsmcTjyFlowTestService {

	private PsmcWorkFlowContext psmcWorkFlowContext;

	public MsgModel startFlow(Map<String, Object> variables){
		MsgModel mm = null;
		ProcessInstance pi = psmcWorkFlowContext.getRuntimeService().startProcessInstanceByKey(variables.get("formNo").toString(), variables);
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return MsgModel.buildDefaultSuccess(gson.toJson(pi));
	}
	public MsgModel completeTask(String taskId,Map<String, Object> variables){
		MsgModel mm = null;
		psmcWorkFlowContext.getTaskService().complete(taskId,variables);
		return MsgModel.buildDefaultSuccess();
	}

	public PsmcWorkFlowContext getPsmcWorkFlowContext() {
		return psmcWorkFlowContext;
	}

	public void setPsmcWorkFlowContext(PsmcWorkFlowContext psmcWorkFlowContext) {
		this.psmcWorkFlowContext = psmcWorkFlowContext;
	}

	
	
	
}
