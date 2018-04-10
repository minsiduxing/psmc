package priv.guochun.psmc.system.framework.activiti.service.impl;

import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import priv.guochun.psmc.system.framework.activiti.core.PsmcWorkFlowContext;
import priv.guochun.psmc.system.framework.activiti.service.PsmcTjyFlowTestService;

public class PsmcTjyFlowTestServiceImpl implements PsmcTjyFlowTestService {

	private PsmcWorkFlowContext psmcWorkFlowContext;
	
	public String startFlow(Map<String, Object> variables){
		ProcessInstance pi = psmcWorkFlowContext.getRuntimeService().startProcessInstanceByKey(variables.get("formNo").toString(), variables);
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(pi);
	}

	public PsmcWorkFlowContext getPsmcWorkFlowContext() {
		return psmcWorkFlowContext;
	}

	public void setPsmcWorkFlowContext(PsmcWorkFlowContext psmcWorkFlowContext) {
		this.psmcWorkFlowContext = psmcWorkFlowContext;
	}

	
	
	
}
