package priv.guochun.psmc.system.framework.activiti.core.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import priv.guochun.psmc.system.framework.activiti.core.PsmcWorkFlowContext;
import priv.guochun.psmc.system.framework.activiti.model.TFlowInstance;
import priv.guochun.psmc.system.framework.activiti.util.FlowContans;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;
import priv.guochun.psmc.system.util.TimestampUtil;

/**
 * 自定义监听器，监听流程完成后进行状态处理
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

        String eventName = execution.getEventName();

        if(FlowContans.FLOW_EVENT_START.equals(eventName)){
            //流程启动在runtime的start方法里实现了，这里不管了。
        }

        if(FlowContans.FLOW_EVENT_END.equals(eventName)){
            String tfiId = execution.getProcessInstanceId();
            TFlowInstance tFlowInstance = psmcWorkFlowContext.gettFlowInstanceService().getTFlowInstanceBytfiId(tfiId);
            tFlowInstance.setFlowState(FlowContans.FLOW_STATE_END);
            tFlowInstance.setFlowEndTime(TimestampUtil.createCurTimestamp());
            psmcWorkFlowContext.gettFlowInstanceService().update(tFlowInstance);
        }
    }
}
