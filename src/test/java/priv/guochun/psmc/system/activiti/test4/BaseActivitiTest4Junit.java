package priv.guochun.psmc.system.activiti.test4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.system.activiti.BaseActivitiTest;
import priv.guochun.psmc.system.activiti.service.impl.PsmcActivitiOperServiceImpl;
import priv.guochun.psmc.system.activiti.service.impl.PsmcActivitiQueryServiceImpl;

/**
 * 测试工作流变量
 * @author Administrator
 *
 */
public class BaseActivitiTest4Junit extends BaseActivitiTest {

	protected static final  Logger logger  = LoggerFactory.getLogger(BaseActivitiTest4Junit.class);
	private PsmcActivitiOperServiceImpl oper;
	private PsmcActivitiQueryServiceImpl query;
	
	@Override
	public void test() {
		oper = new PsmcActivitiOperServiceImpl();
		oper.setRuntimeService(this.getRuntimeService());
		oper.setTaskService(this.getTaskService());
		oper.setRepositoryService(this.getRepositoryService());
		
		query = new PsmcActivitiQueryServiceImpl();
		query.setRuntimeService(this.getRuntimeService());
		query.setTaskService(this.getTaskService());
		query.setRepositoryService(this.getRepositoryService());
		
		signalStartFlow();
	}
	

	/**
	 * 测试sigal 启动流程
	 */
	public void signalStartFlow(){
//		this.getTaskService().complete(query.getCurrentTaskBypiid("4dd5d041-1dc9-11e8-b816-74e50b897790").getId());
//		this.getTaskService().complete(query.getCurrentTaskBypiid("4de67213-1dc9-11e8-b816-74e50b897790").getId());
		
		this.getRuntimeService().signalEventReceived("globalSigalName");
	}
	
	
	
}
