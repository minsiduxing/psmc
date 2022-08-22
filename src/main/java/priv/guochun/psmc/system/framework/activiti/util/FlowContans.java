package priv.guochun.psmc.system.framework.activiti.util;


public class FlowContans {
	

	//流程状态（运行中）
	public final static int FLOW_STATE_RUNNING=1;
	//流程状态（已完成）
	public final static int FLOW_STATE_END=2;
	//流程节点创建触发事件名称
	public final static String FLOW_EVENT_START="start";
	//流程节点结束触发事件名称
	public final static String FLOW_EVENT_END="end";

	public final static int FLOW_TASK_RUNNING=1;

	public final static int FLOW_TASK_END=99;

	public final static String FLOW_COMMON_VARIABLES_STARTED = "startUserId" ;
	public final static String FLOW_COMMON_VARIABLES_FLOW_EN_NAME = "flow_en_name" ;

	/*******************************************TEST_ONE_FLOW流程相关start*****************************************************************************/
	//这里定义的是具体业务流程
	public final static String FLOW_TEST_ONE_FLOW = "TEST_ONE_FLOW" ;
	public final static String FLOW_TEST_ONE_FLOW_USERTASK1 = "usertask1" ;
	public final static String FLOW_TEST_ONE_FLOW_USERTASK2 = "usertask2" ;
	public final static String FLOW_TEST_ONE_FLOW_USERTASK2_VARS_YWBLX_HXR = "ywblx_hxr" ;
	public final static String FLOW_TEST_ONE_FLOW_AUDIT = "audit" ;
	public final static String FLOW_TEST_ONE_FLOW_AUDIT_VARS_ROLE_CHIEF = "role_chief" ;
	public final static String FLOW_TEST_ONE_FLOW_AUDIT_VARS_CHIEF_AUDIT = "chief_audit" ;

	public final static String FLOW_TEST_ONE_FLOW_APPROVAL = "approval" ;
	public final static String FLOW_TEST_ONE_FLOW_APPROVAL_VARS_GROUP_DIRECTOR = "group_director" ;
	/*******************************************TEST_ONE_FLOW流程相关end*****************************************************************************/
}
