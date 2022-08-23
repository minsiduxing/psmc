package priv.guochun.psmc.system.framework.activiti.service;

import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.page.MyPage;

import java.util.List;
import java.util.Map;

/**
 * PSMC工作流基础服务
 * @author Administrator
 *
 */
public interface PsmcBaseWorkFlowService {
	
	/**
	 * 待接收任务
	 */
	public MyPage selectWaitReceiveTasks(User user,MyPage page);

	/**
	 * 待处理任务
	 */
	public MyPage selectWaitProcessTasks(User user,MyPage page);

	/**
	 * 已处理任务
	 */
	public MyPage selectProcessedTasks(User user,MyPage page);

	/**
	 * 我发起的任务（目前仅仅是由我发起，后续可以扩展我的单位或角色下的任务
	 * @param user
	 * @param page
	 * @return
	 */
	public MyPage selectStartedByMeTasks(User user,MyPage page);

	/**
	 * 发起流程
	 * @param variables
	 * @return
	 */
	public MsgModel startFlow(Map<String, Object> variables);

	/**
	 * 完成任务
	 * @param variables
	 * @return
	 */
	public MsgModel completeTask(String taskId,Map<String, Object> variables,Map<String, Object> transientVariables);

	/**
	 * 接收认领任务，认领后其他人待接收任务列表就没有了
	 * @param taskId
	 * @param userId
	 * @return
	 */
	public MsgModel claimTask(String taskId, String userId);

	/**
	 * 释放任务，释放后其他人待接收任务列表就出现了
	 * @param taskId
	 * @return
	 */
	public MsgModel unClaimTask(String taskId);

	/**
	 * 得到下一节点处理用户的分页集合
	 * @param pid 流程实例id
	 * @param currTaskId 当前节点id
	 * @param myPage 分页控件
	 * @return
	 */
	public MyPage getNextTaskUser(String pid, String currTaskId,MyPage myPage);

}
