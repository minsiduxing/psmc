package priv.guochun.psmc.system.activiti.service;

import org.activiti.engine.runtime.ProcessInstance;

/**
 * PSMC工作流基础操作服务
 * @author Administrator
 *
 */
public interface PsmcActivitiOperService {
	
	/**
	 * 根据流程定义key启动一个流程实例
	 * @param processDefinitionKey
	 * @return
	 */
	public ProcessInstance startProcess(String pdkey);
	
	/**
	 * 挂起流程实例
	 */
	public void HangProcessInstance(String piid);
	/**
	 * 解挂流程实例
	 * @param piid
	 */
	public void UnHangProcessInstance(String piid);
	
	/**
	 * 挂起流程模板(挂起模板不影响流程实例正常运行)
	 * @param pdkey
	 */
	public void HangProcessTemplate(String pdkey);
	
	/**
	 * 解挂流程模板
	 * @param pdkey
	 */
	public void UnHangProcessTemplate(String pdkey);
	
	
	/**
	 * 受理任务
	 * @param taskId 任务ID
	 * @param userId 受理人ID
	 */
	public void ClaimTask(String taskId,String userId);
	
	/**
	 * 解除任务
	 * @param taskId
	 */
	public void UnClaimTask(String taskId);
	
	/**
	 * 完成任务
	 * @param taskId
	 */
	public void completeTask(String taskId);
	
	
}
