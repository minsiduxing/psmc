package priv.guochun.psmc.system.activiti.test8;

import java.util.Hashtable;
import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.system.activiti.BaseActivitiTest;
import priv.guochun.psmc.system.activiti.service.impl.PsmcActivitiOperServiceImpl;
import priv.guochun.psmc.system.activiti.service.impl.PsmcActivitiQueryServiceImpl;
import priv.guochun.psmc.system.activiti.test6.ParamModel;

/**
 * 测试执行监听器 AND  任务监听器
 * @author Administrator
 *
 */
public class BaseActivitiTest8Junit extends BaseActivitiTest {

	protected static final  Logger logger  = LoggerFactory.getLogger(BaseActivitiTest8Junit.class);
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
		
		inclusiveGateway();
	}
	

	@SuppressWarnings("unchecked")
	public ProcessInstance inclusiveGateway(){
		Map var = new Hashtable();
		ParamModel pm = new ParamModel();
		pm.setNext(true); //设置flow5的序列流转
		var.put("nextObj", pm);
		var.put("role","role");
		var.put("group", "group1");
		
		ProcessInstance pinstance = oper.getRuntimeService().startProcessInstanceByKey("test8_flow1Id", var);
		
		/***********************task1 设置通过**********************************/
		var.put("finish", false);
		this.getTaskService().complete(query.getCurrentTaskBypiid(pinstance.getProcessInstanceId()).getId(), var);
		var.put("finish", true);
		this.getTaskService().complete(query.getCurrentTaskBypiid(pinstance.getProcessInstanceId()).getId(), var);
		this.getTaskService().complete(query.getCurrentTaskBypiid(pinstance.getProcessInstanceId()).getId(), var);
		/***********************task1 设置通过**********************************/
		
		/***********************task1.1**********************************/
		var = new Hashtable();
		pm = new ParamModel();
		pm.setStep(3);
		var.put("nextObj", pm);//独家网关、设置走任务3
		this.getTaskService().complete(query.getCurrentTaskBypiid(pinstance.getProcessInstanceId()).getId(), var);
		/***********************task1.1**********************************/
		
		
		/***********************task3**********************************/
		var = new Hashtable();
		pm = new ParamModel();
		pm.setInclusiveStep(1);
		var.put("nextObj", pm);//包容网关 包容inclusiveStep=1的任务
		this.getTaskService().complete(query.getCurrentTaskBypiid(pinstance.getProcessInstanceId()).getId(),var);
		/***********************task3**********************************/
		
		/***********************task3.1-3.2**********************************/
		//并行任务
		this.getTaskService().complete(query.getCurrentTaskBypiid(pinstance.getProcessInstanceId()).getId());
		this.getTaskService().complete(query.getCurrentTaskBypiid(pinstance.getProcessInstanceId()).getId());
		/***********************task3.1-3.2**********************************/
		
		
		/***********************task3.4**********************************/
		this.getTaskService().complete(query.getCurrentTaskBypiid(pinstance.getProcessInstanceId()).getId());
		/***********************task3.4**********************************/
		
		return pinstance;
	}
	
	
	/**
	 * 测试独家+并行网关
	 */
	public void parallelGateway(){
		ProcessInstance pinstance = oper.startProcess("seq_flow1Id");
		
		/***********************task1 设置通过**********************************/
		Map var = new Hashtable();
		ParamModel pm = new ParamModel();
		pm.setNext(true); //设置flow5的序列流转
		var.put("nextObj", pm);
		this.getTaskService().complete(query.getCurrentTaskBypiid(pinstance.getProcessInstanceId()).getId(), var);
		/***********************task1 设置通过**********************************/
		
		/***********************task1.1**********************************/
		var = new Hashtable();
		pm = new ParamModel();
		pm.setStep(2);
		var.put("nextObj", pm);//独家网关、设置走任务2
		this.getTaskService().complete(query.getCurrentTaskBypiid(pinstance.getProcessInstanceId()).getId(), var);
		/***********************task1.1**********************************/
		
		
		/***********************task2**********************************/
		//并行网关
		this.getTaskService().complete(query.getCurrentTaskBypiid(pinstance.getProcessInstanceId()).getId());
		/***********************task2**********************************/
		
		/***********************task2.1-2.2**********************************/
		//并行任务
		this.getTaskService().complete(query.getCurrentTaskBypiid(pinstance.getProcessInstanceId()).getId());
		this.getTaskService().complete(query.getCurrentTaskBypiid(pinstance.getProcessInstanceId()).getId());
		/***********************task2.1-2.2**********************************/
		
		
		/***********************task2.4**********************************/
		this.getTaskService().complete(query.getCurrentTaskBypiid(pinstance.getProcessInstanceId()).getId());
		/***********************task2.4**********************************/
	}
	
	
}
