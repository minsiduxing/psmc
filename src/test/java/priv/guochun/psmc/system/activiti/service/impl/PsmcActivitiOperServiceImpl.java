package priv.guochun.psmc.system.activiti.service.impl;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.system.activiti.service.PsmcActivitiOperService;

public class PsmcActivitiOperServiceImpl implements PsmcActivitiOperService {

	protected static final  Logger logger  = LoggerFactory.getLogger(PsmcActivitiOperServiceImpl.class);
	private RuntimeService  runtimeService;
	private TaskService taskService;
	private RepositoryService repositoryService;
	
	@Override
	public ProcessInstance startProcess(String processDefinitionKey) {
		ProcessInstance pinstance = runtimeService.startProcessInstanceByKey(processDefinitionKey);
		return pinstance;
	}

	public void HangProcessInstance(String piid){
		runtimeService.suspendProcessInstanceById(piid);
	}
	
	public void UnHangProcessInstance(String piid){
		runtimeService.activateProcessInstanceById(piid);
	}
	
	public void HangProcessTemplate(String pdkey){
		repositoryService.suspendProcessDefinitionByKey(pdkey);
	}
	
	public void UnHangProcessTemplate(String pdkey){
		repositoryService.activateProcessDefinitionByKey(pdkey);
	}
	
	@Override
	public void ClaimTask(String taskId, String userId) {
		taskService.claim(taskId, userId);
	}

	@Override
	public void UnClaimTask(String taskId) {
		taskService.unclaim(taskId);
	}

	@Override
	public void completeTask(String taskId) {
		taskService.complete(taskId);
	}
	
	

	public RuntimeService getRuntimeService() {
		return runtimeService;
	}

	public void setRuntimeService(RuntimeService runtimeService) {
		this.runtimeService = runtimeService;
	}

	public TaskService getTaskService() {
		return taskService;
	}

	public void setTaskService(TaskService taskService) {
		this.taskService = taskService;
	}

	public RepositoryService getRepositoryService() {
		return repositoryService;
	}

	public void setRepositoryService(RepositoryService repositoryService) {
		this.repositoryService = repositoryService;
	}
	
	
}
