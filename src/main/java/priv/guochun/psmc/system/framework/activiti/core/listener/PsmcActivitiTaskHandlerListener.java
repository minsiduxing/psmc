package priv.guochun.psmc.system.framework.activiti.core.listener;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import priv.guochun.psmc.system.framework.activiti.core.PsmcWorkFlowContext;
import priv.guochun.psmc.system.framework.activiti.util.FlowContans;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;

/**
 * psmc的activiti的任务执行监听器，针对多实例的话，是子任务执行的监听器
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

        final String taskDefinitionKey = delegateTask.getTaskDefinitionKey();

        if("complete".equalsIgnoreCase(delegateTask.getEventName()) && FlowContans.FLOW_CXXMGL_USERTASK2.equals(taskDefinitionKey)) {
            String exId = delegateTask.getExecutionId();
            RuntimeService rs = psmcWorkFlowContext.getRuntimeService();
            TaskService ts = psmcWorkFlowContext.getTaskService();
            boolean pass = (Boolean) rs.getVariable(exId, "pass");
            if (!pass) {

            }
        }
    }
}
