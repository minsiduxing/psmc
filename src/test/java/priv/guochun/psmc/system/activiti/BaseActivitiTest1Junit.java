package priv.guochun.psmc.system.activiti;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

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
	private HistoryService historyService;
	
	@Autowired
	private RepositoryService repositoryService;
	
	protected static final  Logger logger  = LoggerFactory.getLogger(BaseActivitiTest1Junit.class);
	
	@Override
	public void test() {

		taskService.claim("d21b4660-3edc-11e8-9032-74e50b897790", "guochun_claim");
		Map map = new HashMap();
//		map.put("chief_audit", "1");
//		map.put("role_director", "role_director_user");
		
		taskService.complete("d21b4660-3edc-11e8-9032-74e50b897790",map);
		
//		System.out.println(historyService.createHistoricActivityInstanceQuery().list());
		
//		List list = taskService.createTaskQuery().taskAssignee("cla").list();
//		System.out.println(list.size());
//		
//		list = taskService.createTaskQuery().taskCandidateUser("roleU").list();
//		System.out.println(list.size());
//		
//		list = taskService.createTaskQuery().taskCandidateGroup("roleG").list();
//		System.out.println(list.size());
//		
		
//		ProcessDefinition processDefinition = repositoryServiceTest();
//		if(processDefinition!=null){
//			String processDefinitionKey = processDefinition.getKey();
//			//挂起流程 不允许在创建流程实例
//			//repositoryService.suspendProcessDefinitionByKey(processDefinitionKey);
//			ProcessInstance pInstance = null;
//			try {
//					pInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey);
//				} catch (ActivitiException e) {
//					logger.debug("process is suspend, start faild! ");
//					e.printStackTrace();
//					//激活流程
//					//repositoryService.activateProcessDefinitionByKey(processDefinitionKey);
//					pInstance = runtimeService.startProcessInstanceByKey(processDefinitionKey);
//			}
//			logger.info("pInstance create success ");
//			try {
//				logger.info(Gson.class.newInstance().toJson(pInstance));
//			} catch (InstantiationException | IllegalAccessException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
		
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
