package priv.guochun.psmc.system.framework.activiti.service;

import priv.guochun.psmc.system.framework.model.MsgModel;

import java.util.Map;

public interface PsmcTjyFlowTestService {

	/**
	 * 发起流程
	 * @param variables
	 * @return
	 */
	public MsgModel startFlow(Map<String, Object> variables);

	/**
	 * 完成任务
	 * @param variables
	 * @return
	 */
	public MsgModel completeTask(String taskId, Map<String, Object> variables);
}
