package priv.guochun.psmc.system.activiti.service.impl;

import java.util.List;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.system.activiti.service.PsmcActivitiQueryService;

public class PsmcActivitiQueryServiceImpl implements PsmcActivitiQueryService {

	protected static final  Logger logger  = LoggerFactory.getLogger(PsmcActivitiQueryServiceImpl.class);
	private RuntimeService  runtimeService;
	private TaskService taskService;
	private RepositoryService repositoryService;
	
	
	@Override
	public Task getCurrentTaskBypiid(String piid){
		Task result = null;
		List<Task> list = taskService.createTaskQuery().list();
		for(int i=0;i<list.size();i++){
			Task task = list.get(i);
			String pinstanceId = task.getProcessInstanceId();
			if(piid.equals(pinstanceId)){
				result = task;
				break;
			}
		}
		return result;
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
