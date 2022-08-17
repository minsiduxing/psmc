package priv.guochun.psmc.system.framework.activiti.core.listener;

import org.activiti.engine.TaskService;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.activiti.engine.task.IdentityLinkType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import priv.guochun.psmc.system.framework.activiti.core.PsmcWorkFlowContext;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;

/**
 * psmc自定义流程人员查找
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
         * 根据流程任务配置的方式来：方式有根据角色找人、根据组找人、根据组&角色交集找人，这种方式的缺点是暂时不能很好的支持页面选择人，其实也是可以的就是还要研究
         */
        if("create".equalsIgnoreCase(delegateTask.getEventName())){
            TaskService taskService = psmcWorkFlowContext.getTaskService();
            taskService.addUserIdentityLink(delegateTask.getId(),"zx_admin1",IdentityLinkType.CANDIDATE);
            taskService.addUserIdentityLink(delegateTask.getId(),"zx_admin2",IdentityLinkType.CANDIDATE);
            taskService.addUserIdentityLink(delegateTask.getId(),"zx_admin3",IdentityLinkType.CANDIDATE);
        }
    }

}
