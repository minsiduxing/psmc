package priv.guochun.psmc.system.activiti;

import java.util.List;

import org.activiti.engine.ActivitiTaskAlreadyClaimedException;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 测试工作流任务查询、声明、完成
 * @author Administrator
 *
 */
public class BaseActivitiTest2Junit extends BaseActivitiTest {

	protected static final  Logger logger  = LoggerFactory.getLogger(BaseActivitiTest2Junit.class);
	
	@Override
	public void test() {
		completeTask(getTaskByProcessInstanceId("72dde8fb-1c5a-11e8-9c4e-74e50b897790"));
		
	}
	
	public Task getTaskByProcessInstanceId(String processInstanceId){
		Task result = null;
		List<Task> list = this.getTaskService().createTaskQuery().list();
		for(int i=0;i<list.size();i++){
			Task task = list.get(i);
			String piid = task.getProcessInstanceId();
			if(piid.equals(processInstanceId)){
				result = task;
			}
		}
		return result;
	}
	
	
	public void getTask(){
				
		completeTask("30002");
		completeTask("30005");
		//查询代办任务
//		List<Task> list = this.getTaskService().createTaskQuery().list();
//		printTaskList(list);
	}
	
	//声明（受理）任务
	public void ClaimTask(Task task){
		try{
			this.getTaskService().claim(task.getId(), "guochun_claim");
			logger.debug("task "+task.getId()+"受理成功!");
		}catch(ActivitiTaskAlreadyClaimedException e){
			logger.debug("task "+task.getId()+"受理失败!");
			e.printStackTrace();
		}
	}
	
	//完成任务
	public void completeTask(Task task){
//		流程实例的挂起、激活
//		this.getRuntimeService().suspendProcessInstanceById(task.getProcessInstanceId());
//		this.getRuntimeService().activateProcessInstanceById(task.getProcessInstanceId());
		this.getTaskService().complete(task.getId());
		logger.info("task "+task.getId()+"complete成功!");
	}
	
	public void completeTask(String taskId){
		this.getTaskService().complete(taskId);
		logger.info("task "+taskId+"complete成功!");
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
				
				logger.debug(sb1.toString());
			}
		}
	}
	
}
