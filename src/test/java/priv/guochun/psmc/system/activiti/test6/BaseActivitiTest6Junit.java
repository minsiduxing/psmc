package priv.guochun.psmc.system.activiti.test6;

import java.util.Hashtable;
import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.system.activiti.BaseActivitiTest;
import priv.guochun.psmc.system.activiti.service.impl.PsmcActivitiOperServiceImpl;
import priv.guochun.psmc.system.activiti.service.impl.PsmcActivitiQueryServiceImpl;

/**
 * 
 * @author Administrator
 *
 */
public class BaseActivitiTest6Junit extends BaseActivitiTest {

	protected static final  Logger logger  = LoggerFactory.getLogger(BaseActivitiTest6Junit.class);
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
	 * 测试sequenceFlow conditionExpression
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void signalStartFlow(){		
		sigalGateway();
	}
	
	/**
	 * 测试信号网关
	 */
	public void sigalGateway(){
		
		ProcessInstance pinstance = inclusiveGateway();
		
		this.getRuntimeService().signalEventReceived("test6SigalName1");
		
		/***********************task3.6**********************************/
		this.getTaskService().complete(query.getCurrentTaskBypiid(pinstance.getProcessInstanceId()).getId());
		/***********************task3.6**********************************/
		
		/***********************task4**********************************/
		this.getTaskService().complete(query.getCurrentTaskBypiid(pinstance.getProcessInstanceId()).getId());
		/***********************task4**********************************/
		
	}
	
	
	/**
	 * 测试独家+包容网关
	 */
	public ProcessInstance inclusiveGateway(){
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
