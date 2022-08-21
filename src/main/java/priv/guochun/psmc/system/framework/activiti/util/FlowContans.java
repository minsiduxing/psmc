package priv.guochun.psmc.system.framework.activiti.util;


public class FlowContans {
	

	//流程状态（运行中）
	public final static int FLOW_STATE_RUNNING=1;
	//流程状态（已完成）
	public final static int FLOW_STATE_END=2;

	//流程节点创建触发事件名称
	public final static String FLOW_START_EVENT="start";

	//流程节点结束触发事件名称
	public final static String FLOW_END_EVENT="end";

	public final static int FLOW_TASK_RUNNING=1;

	public final static int FLOW_TASK_END=99;

}
