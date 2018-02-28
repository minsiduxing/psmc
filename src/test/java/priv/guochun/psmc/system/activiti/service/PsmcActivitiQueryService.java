package priv.guochun.psmc.system.activiti.service;

import org.activiti.engine.task.Task;

/**
 * PSMC工作流查询服务
 * @author Administrator
 *
 */
public interface PsmcActivitiQueryService {
	
	/**
	 * 根据流程实例ID获取该流程实例的当前任务
	 * @param Piid
	 * @return
	 */
	public Task getCurrentTaskBypiid(String Piid);
	
	
}
