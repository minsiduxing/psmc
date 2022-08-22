package priv.guochun.psmc.system.framework.activiti.core.listener;

import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.engine.task.IdentityLinkType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import priv.guochun.psmc.system.framework.activiti.core.PsmcWorkFlowContext;
import priv.guochun.psmc.system.framework.activiti.util.FlowContans;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;

/**
 * psmc自定义任务事件监听
 */
public class PsmcActivitiTaskHandlerListener implements TaskListener
{

    protected static final  Logger logger  = LoggerFactory.getLogger(PsmcActivitiTaskHandlerListener.class);

    private PsmcWorkFlowContext psmcWorkFlowContext;

    public PsmcActivitiTaskHandlerListener(){
        psmcWorkFlowContext = (PsmcWorkFlowContext)MySpringApplicationContext.getObject("psmcWorkFlowContext");
    }
    @Override
    public void notify(DelegateTask delegateTask) {
        /**
         * 这里要实现自动流转，给执行任务赋处理人，实现思路：
         * 简单的实现方式是在表里配置流程图下各个节点的选人方式，然后根据方式找人按照下面赋值即可，这种方式的缺点是
         * 1、如果流程有多个分支暂时不能很好支持；
         * 2、不支持页面选人，因为都是后台驱动的，使用有限制。
         * 最好的实现方式是获取当前节点的下一节点在流程图里的配置，根据配置找人，这种方式的优点是：
         * 1、可以提供给前端做选择；
         * 2、可以提供给后端做自动化设置；
         */
        final String taskDefinitionKey = delegateTask.getTaskDefinitionKey();

        if("create".equalsIgnoreCase(delegateTask.getEventName()) && FlowContans.FLOW_TEST_ONE_FLOW_USERTASK1.equals(taskDefinitionKey)){
            TaskService taskService = psmcWorkFlowContext.getTaskService();
            taskService.addUserIdentityLink(delegateTask.getId(),"admin",IdentityLinkType.CANDIDATE);
            taskService.addUserIdentityLink(delegateTask.getId(),"zx_admin2",IdentityLinkType.CANDIDATE);
            taskService.addUserIdentityLink(delegateTask.getId(),"zx_admin3",IdentityLinkType.CANDIDATE);
        }
        /**
         * event (required): 事件类型.。支持的类型有：
         *
         * create: 任务被创建，并且所有的属性都被设置好后。
         *
         * assignment: 任务被委派给某人后.。注意: 当流程执行到达一个userTask时，会先触发一个assignment事件，再触发create事件。
         *
         * complete:在任务完成后，且被从运行时数据（runtime data）中删除前触发。
         *
         * delete: 在任务将要被删除之前发生。注意，当任务通过completeTask完成任务时，它也会被执行。
         */
        // 当前任务节点创建的任务数据的唯一标识, 也就是act_ru_task的ID_的值
        final String id = delegateTask.getId();
        // 当前任务节点的name, 也就是act_ru_task的NAME_的值, 流程图中任务的Name列(就是下面截图中的Name)
        final String name = delegateTask.getName();
        // 流程实例ID
        final String processInstanceId = delegateTask.getProcessInstanceId();
        // 执行ID
        final String executionId = delegateTask.getExecutionId();
        // 流程定义ID
        final String processDefinitionId = delegateTask.getProcessDefinitionId();
        // 监听器类型, 实现TaskListener接口的监听器类型有create,assignment,complete,delete,all
        final String eventName = delegateTask.getEventName();
        // 当前任务节点的签收人
        final String assignee = delegateTask.getAssignee();
    }

}
