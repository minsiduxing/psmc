package priv.guochun.psmc.system.activiti.test3;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.activiti.engine.runtime.Execution;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
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
public class BaseActivitiTest3Junit extends BaseActivitiTest {

	protected static final  Logger logger  = LoggerFactory.getLogger(BaseActivitiTest3Junit.class);
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
		
		setPublicVar();
//		setLocalVar();
	}
	
	/**
	 * 全局变量 在流程实例全局可见
	 */
	@SuppressWarnings("unused")
	public void setPublicVar(){
		String piid = null;
		String pdkey ="activitiFlow1";
		if(piid == null){
			Map<String, Object> variables = new Hashtable<String, Object>();
			variables.put("variable1_name", "任务1");
			variables.put("variable2_name", "任务2");
			ProcessInstance processInstance = this.getRuntimeService().startProcessInstanceByKey(pdkey, variables);
			piid = processInstance.getProcessInstanceId();
		}
		logger.info("piid = "+piid+" process created !!!");
		Task task = query.getCurrentTaskBypiid(piid);
		oper.completeTask(query.getCurrentTaskBypiid(piid).getId());
	}
	
	
	public void setLocalVar(){
		String processInstanceId = "280ab782-1c37-11e8-9f5b-74e50b897790";
		List<Execution> list = this.getRuntimeService().createExecutionQuery().rootProcessInstanceId(processInstanceId).list();
		for(int i=0;i<list.size();i++){
			Execution execution = list.get(i);
			logger.info("execution.getId() "+execution.getId());
			if("280ab785-1c37-11e8-9f5b-74e50b897790".equals(execution.getId())) {
				/**
				 * 运行期添加变量
				 * 执行组变量 在流程实例全局可见
				 */
				this.getRuntimeService().setVariable(execution.getId(), "variable3_name", "根据执行树添加的Variable");
				
				/**
				 * 运行期添加变量
				 * 执行组变量 在当前执行组可见
				 */
				this.getRuntimeService().setVariableLocal(execution.getId(), "variable4_name", "根据执行树添加的VariableLocal");
				
				
				/**
				 * 运行期添加变量
				 * 任务变量 在流程实例全局可见
				 * 
				 */
				this.getTaskService().setVariable("2811e378-1c37-11e8-9f5b-74e50b897790", "variable5_name", "根据任务添加的Variable");
				/**
				 * 运行期添加变量
				 * 任务变量 在当前任务可见
				 * 
				 */
				this.getTaskService().setVariableLocal("2811e378-1c37-11e8-9f5b-74e50b897790", "variable6_name", "根据任务添加的VariableLocal");
			}
			logger.info("execution.getName() "+execution.getName());
			logger.info("execution.getDescription() "+execution.getDescription());
			logger.info("execution.getParentId() "+execution.getParentId());
			logger.info("execution.getSuperExecutionId() "+execution.getSuperExecutionId());
			logger.info("execution.getActivityId() "+execution.getActivityId());
			logger.info("execution.getProcessInstanceId() "+execution.getProcessInstanceId());
			logger.info("---------------------------------------------------------- ");
		}
	}
	
}
