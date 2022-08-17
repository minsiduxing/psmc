package priv.guochun.psmc.system.framework.activiti.core.listener;

import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.task.IdentityLinkType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import priv.guochun.psmc.system.framework.activiti.core.PsmcWorkFlowContext;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;

/**
 * psmc自定义流程人员查找
 */
    public class PsmcActivitiExecutionListener implements ExecutionListener
{

    protected static final  Logger logger  = LoggerFactory.getLogger(PsmcActivitiExecutionListener.class);

    private PsmcWorkFlowContext psmcWorkFlowContext;

    public PsmcActivitiExecutionListener(){
        psmcWorkFlowContext = (PsmcWorkFlowContext)MySpringApplicationContext.getObject("psmcWorkFlowContext");
    }


    @Override
    public void notify(DelegateExecution execution) {
        /**
         *event（必选）：任务监听器会被调用的任务类型。 可能的类型为：
         *start：流程节点创建后触发。
         *end：当任务完成，并尚未从运行数据中删除时触发。
         */
        logger.debug("psmc自定义执行监听器执行了execution.getEventName():"+execution.getEventName());
        logger.debug("psmc自定义执行监听器执行了execution.getId():"+execution.getId());
        logger.debug("psmc自定义执行监听器执行了execution.getCurrentActivityId():"+execution.getCurrentActivityId());
        logger.debug("psmc自定义执行监听器执行了execution.getProcessDefinitionId():"+execution.getProcessDefinitionId());
        logger.debug("psmc自定义执行监听器执行了execution.getProcessInstanceId():"+execution.getProcessInstanceId());
    }
}
