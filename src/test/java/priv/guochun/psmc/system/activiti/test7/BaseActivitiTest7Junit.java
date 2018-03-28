package priv.guochun.psmc.system.activiti.test7;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.system.activiti.BaseActivitiTest;
import priv.guochun.psmc.system.activiti.service.impl.PsmcActivitiOperServiceImpl;
import priv.guochun.psmc.system.activiti.service.impl.PsmcActivitiQueryServiceImpl;
import priv.guochun.psmc.system.activiti.test6.ParamModel;

/**
 * 
 * @author Administrator
 *
 */
public class BaseActivitiTest7Junit extends BaseActivitiTest {

	protected static final  Logger logger  = LoggerFactory.getLogger(BaseActivitiTest7Junit.class);
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
	
	/*自动结束任务*/
	public void completTask(String piid){
		long count = this.oper.getTaskService().createTaskQuery().processInstanceId(piid).count();
		if(count>0){
			Map var = new Hashtable();
			ParamModel pm = new ParamModel();
			pm.setNext(true); //设置flow5的序列流转
			pm.setStep(2);
			var.put("nextObj", pm);
			var.put("role", "role1");
			var.put("group", "group1");
			
			this.getTaskService().complete(query.getCurrentTaskBypiid(piid).getId(), var);
			completTask(piid);
		}
	}

	/**
	 * 测试task
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void signalStartFlow(){	
//		userAllot();
//		taskQuery1();
		completTask("82bea1b4-326f-11e8-95a7-74e50b897790");
	}
	
	
	public void taskQuery1(){
		String candidate = "role1";
		String candidateG = "group1";
		long l = this.query.getTaskService().createTaskQuery().taskCandidateOrAssigned(candidate).count();
		
		long l1 = this.query.getTaskService().createTaskQuery().taskAssignee("guochun").count();
		
		long l2 = this.query.getTaskService().createTaskQuery().taskCandidateGroup(candidateG).count();
		
		long l3 = this.query.getTaskService().createTaskQuery().taskCandidateUser(candidate).count();
		
		long l4 = this.query.getTaskService().createTaskQuery().taskAssigneeLike("guochun").count();
		System.out.println("----"+l);
		System.out.println("----"+l1);
		System.out.println("----"+l2);
		System.out.println("----"+l3);
		System.out.println("----"+l4);
		
	}
	/**
	 * 测试用户分配
	 */
	public void userAllot(){
		String candidate = "role1";
		Map var = new Hashtable();
		var.put("role",candidate);
		var.put("group", "group1");
		ProcessInstance pinstance =this.getRuntimeService().startProcessInstanceByKey("task_flow1Id",var);
		
	}
	
	
	//打印任务对象
		public void printTaskList(List<Task> list){
			if(list != null && list.size()>0){
				for(int i=0;i<list.size();i++){
					Task task = list.get(i);
					StringBuffer sb1 = new StringBuffer();
					sb1.append("----------------\n");
					sb1.append("taskId:"+task.getId()+"\n");
					sb1.append("taskName:"+task.getName()+"\n");
					sb1.append("getParentTaskId:"+task.getParentTaskId()+"\n");
					sb1.append("CreateTime:"+task.getCreateTime()+"\n");
					sb1.append("ClaimTime:"+task.getClaimTime()+"\n");
					sb1.append("dueDate:"+task.getDueDate()+"\n");
					sb1.append("Assignee:"+task.getAssignee()+"\n");
					sb1.append("owner:"+task.getOwner()+"\n");
					sb1.append("processDefinitionId:"+task.getProcessDefinitionId()+"\n");
					sb1.append("processInstanceId:"+task.getProcessInstanceId()+"\n");
					
					logger.info(sb1.toString());
				}
			}
		}
	
	
}
