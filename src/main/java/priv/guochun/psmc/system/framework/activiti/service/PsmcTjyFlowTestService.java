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

	/**
	 * 认领任务（认领后其他人看不到任务了）
	 * @param taskId
	 * @param userId
	 * @return
	 */
	public MsgModel claimTask(String taskId, String userId);

	/**
	 * 释放任务
	 * @param taskId
	 * @return
	 */
	public MsgModel unClaimTask(String taskId);
}
