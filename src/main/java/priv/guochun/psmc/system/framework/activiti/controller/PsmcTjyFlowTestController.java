package priv.guochun.psmc.system.framework.activiti.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.guochun.psmc.system.framework.activiti.core.PsmcWorkFlowContext;
import priv.guochun.psmc.system.framework.activiti.util.FlowContans;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.JsonUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/system/framework/tjyFlowTestController")
public class PsmcTjyFlowTestController extends MyController {
	
	@Autowired
	private PsmcWorkFlowContext psmcWorkFlowContext;

	@ResponseBody
	@RequestMapping(params="method=startFlow")  
	public void startFlow() throws IOException{
		
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put(FlowContans.FLOW_COMMON_VARIABLES_FLOW_EN_NAME, "TEST_ONE_FLOW");
		//流程启动人
		variables.put(FlowContans.FLOW_COMMON_VARIABLES_STARTED, this.getUserBySeesion(this.request()).getAccountName());

		MsgModel mm = psmcWorkFlowContext.getPsmcBaseWorkFlowService().startFlow(variables);
		this.responseHtmltext(JSON.toJSONString(mm), this.response());
	}

	/**
	 * 完成任务
	 * @throws IOException
	 */
	@RequestMapping(params="method=completeTask")
	public void completeTask() throws IOException{
		Map<String, Object> variables = new HashMap<String, Object>();
		if(FlowContans.FLOW_TEST_ONE_FLOW_USERTASK1.equals(this.request().getParameter("taskKeyId"))){
			variables.put(FlowContans.FLOW_TEST_ONE_FLOW_USERTASK2_VARS_YWBLX_HXR, "lyadmin");
		}
		if(FlowContans.FLOW_TEST_ONE_FLOW_USERTASK2.equals(this.request().getParameter("taskKeyId"))){
			//科长审批候选(分配到角色)
			variables.put(FlowContans.FLOW_TEST_ONE_FLOW_AUDIT_VARS_ROLE_CHIEF, "sys_manager");
		} else if(FlowContans.FLOW_TEST_ONE_FLOW_AUDIT.equals(this.request().getParameter("taskKeyId"))){
			//1通过0不通过
			variables.put(FlowContans.FLOW_TEST_ONE_FLOW_AUDIT_VARS_CHIEF_AUDIT, this.request().getParameter("audit"));
			//局长审批候选（分配到组）
			variables.put(FlowContans.FLOW_TEST_ONE_FLOW_APPROVAL_VARS_GROUP_DIRECTOR, "17,lyadmin");
		}
		MsgModel mm = psmcWorkFlowContext.getPsmcBaseWorkFlowService().completeTask(this.request().getParameter("taskId"),variables);
		this.responseHtmltext(JSON.toJSONString(mm), this.response());
	}

	/**
	 * 接收认领任务，认领后其他人待接收任务列表就没有了
	 * @throws IOException
	 */
	@RequestMapping(params="method=claimTask")
	public void claimTask() throws IOException{
		MsgModel mm = psmcWorkFlowContext.getPsmcBaseWorkFlowService().claimTask(this.request().getParameter("taskId"),this.request().getParameter("userId"));
		this.responseHtmltext(JSON.toJSONString(mm), this.response());
	}

	/**
	 * 释放任务，释放后其他人待接收任务列表就出现了
	 * @throws IOException
	 */
	@RequestMapping(params="method=unClaimTask")
	public void unClaimTask() throws IOException{
		MsgModel mm = psmcWorkFlowContext.getPsmcBaseWorkFlowService().unClaimTask(this.request().getParameter("taskId"));
		this.responseHtmltext(JSON.toJSONString(mm), this.response());
	}

	/**
	 * 待接收任务
	 * @param myPage
	 * @throws IOException
	 */
	@RequestMapping(params="method=selectWaitReceiveTasks")
	@ResponseBody
	public void selectWaitReceiveTasks(MyPage myPage) throws IOException{
		MyPage page = psmcWorkFlowContext.getPsmcBaseWorkFlowService().selectWaitReceiveTasks(this.getUserBySeesion(this.request()),myPage);
		super.responseJson(JsonUtil.convertToJSONObject(page), this.response());
	}

	/**
	 * 待处理任务（已接收）
	 * @param myPage
	 * @throws IOException
	 */
	@RequestMapping(params="method=selectWaitProcessTasks")
	@ResponseBody
	public void selectWaitProcessTasks(MyPage myPage) throws IOException{
		MyPage page = psmcWorkFlowContext.getPsmcBaseWorkFlowService().selectWaitProcessTasks(this.getUserBySeesion(this.request()),myPage);
		super.responseJson(JsonUtil.convertToJSONObject(page), this.response());
	}

	/**
	 * 已处理任务
	 * @param myPage
	 * @throws IOException
	 */
	@RequestMapping(params="method=selectProcessedTasks")
	@ResponseBody
	public void selectProcessedTasks(MyPage myPage) throws IOException{
		MyPage page = psmcWorkFlowContext.getPsmcBaseWorkFlowService().selectProcessedTasks(this.getUserBySeesion(this.request()),myPage);
		super.responseJson(JsonUtil.convertToJSONObject(page), this.response());
	}

	/**
	 * 我发起的任务
	 * @param myPage
	 * @throws IOException
	 */
	@RequestMapping(params="method=selectStartedByMeTasks")
	@ResponseBody
	public void selectStartedByMeTasks(MyPage myPage) throws IOException{
		MyPage page = psmcWorkFlowContext.getPsmcBaseWorkFlowService().selectStartedByMeTasks(this.getUserBySeesion(this.request()),myPage);
		super.responseJson(JsonUtil.convertToJSONObject(page), this.response());
	}

	/**
	 * 获取到下一节点任务的处理用户
	 * @param pid
	 * @param taskId
	 * @param myPage
	 * @throws IOException
	 */
	@RequestMapping(params="method=getNextTaskUser")
	public void getNextTaskUser(String pid,String taskId,MyPage myPage) throws IOException {
		myPage = psmcWorkFlowContext.getPsmcBaseWorkFlowService().getNextTaskUser(pid,taskId,myPage);
		super.responseJson(JsonUtil.convertToJSONObject(myPage), this.response());
	}
}
