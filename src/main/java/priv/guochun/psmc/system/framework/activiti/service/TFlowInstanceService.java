package priv.guochun.psmc.system.framework.activiti.service;

import org.json.JSONObject;

import priv.guochun.psmc.system.framework.activiti.model.TFlowInstance;

/**
 * 自定义的工作流实例化表
 */
public interface TFlowInstanceService {

	public JSONObject save(TFlowInstance tFlowInstance);


	public TFlowInstance getTFlowInstanceBytfiId(String tfiId);


	public void update(TFlowInstance tFlowInstance);
	
}
