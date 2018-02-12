package priv.guochun.psmc.system.activiti;

import java.util.List;

import org.activiti.engine.ActivitiException;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;

import priv.guochun.psmc.system.BaseTestClass;
/**
 * 测试工作量静态信息获取 及流程启动
 * @author Administrator
 *
 */
public class BaseActivitiTest1Junit extends BaseTestClass {

	@Autowired
	private RuntimeService  runtimeService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private RepositoryService repositoryService;
	
	protected static final  Logger logger  = LoggerFactory.getLogger(BaseActivitiTest1Junit.class);
	
	@Override
	public void test() {
		
		ProcessDefinition processDefinition = repositoryServiceTest();
		if(processDefinition!=null){
			String processDefinitionKey = processDefinition.getKey();
			//挂起流程 不允许在创建流程实例
			//repositoryService.suspendProcessDefinitionByKey(processDefinitionKey);
			ProcessInstance pInstance = null;
			try {
					pInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey);
				} catch (ActivitiException e) {
					logger.debug("process is suspend, start faild! ");
					e.printStackTrace();
					//激活流程
					//repositoryService.activateProcessDefinitionByKey(processDefinitionKey);
					pInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey);
			}
			logger.info("pInstance create success ");
			try {
				logger.info(Gson.class.newInstance().toJson(pInstance));
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	
	public ProcessDefinition repositoryServiceTest(){
		ProcessDefinitionQuery pdq = repositoryService.createProcessDefinitionQuery().processDefinitionKey("activitiFlow1");
		List<ProcessDefinition> proDefList = pdq.list();
		logger.debug("目前系统中的流程定义有:"+proDefList.size()+"条");
		if(proDefList!=null && proDefList.size()>0)
		{
			logger.debug("流程定义[0]:"+proDefList.get(0).getKey());
			logger.debug("流程定义[0]:"+proDefList.get(0).getName());
			return proDefList.get(0);
		}
		return null;
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
