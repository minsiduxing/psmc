package priv.guochun.psmc.system.activiti;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.system.BaseTestClass;
import priv.guochun.psmc.system.activiti.service.PsmcActivitiOperService;

public class BaseActivitiTest extends BaseTestClass {

	@Autowired
	private RuntimeService  runtimeService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private RepositoryService repositoryService;
	private PsmcActivitiOperService psmcActivitiOperService;
	
	protected static final  Logger logger  = LoggerFactory.getLogger(BaseActivitiTest.class);
	

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

	@Override
	public void test() {
		// TODO Auto-generated method stub
		
	}

	public PsmcActivitiOperService getPsmcActivitiOperService() {
		return psmcActivitiOperService;
	}

	public void setPsmcActivitiOperService(PsmcActivitiOperService psmcActivitiOperService) {
		this.psmcActivitiOperService = psmcActivitiOperService;
	}
	

	
	
	

}
