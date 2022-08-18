package priv.guochun.psmc.system.framework.activiti.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.guochun.psmc.system.framework.activiti.core.PsmcWorkFlowContext;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.page.MyPage;

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
		variables.put("formNo", "tjyflowId");
		//流程启动人
		variables.put("startUserId", this.getUserBySeesion(this.request()).getAccountName());
		//立项人角色
		variables.put("role_businessment", "admin,lx_admin2,lx_admin3");

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
		if("usertask2".equalsIgnoreCase(this.request().getParameter("taskKeyId"))){
			//科长审批角色
			variables.put("role_chief", "kz_role");
		} else if("audit".equalsIgnoreCase(this.request().getParameter("taskKeyId"))){
			//1通过0不通过
			variables.put("chief_audit", this.request().getParameter("audit"));
			//局长审批角色
			variables.put("role_director", "jz_admin");
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
		Map<String, Object> variables = new HashMap<String, Object>();
		MsgModel mm = psmcWorkFlowContext.getPsmcBaseWorkFlowService().claimTask(this.request().getParameter("taskId"),this.request().getParameter("userId"));
		this.responseHtmltext(JSON.toJSONString(mm), this.response());
	}

	/**
	 * 释放任务，释放后其他人待接收任务列表就出现了
	 * @throws IOException
	 */
	@RequestMapping(params="method=unClaimTask")
	public void unClaimTask() throws IOException{
		Map<String, Object> variables = new HashMap<String, Object>();
		MsgModel mm = psmcWorkFlowContext.getPsmcBaseWorkFlowService().unClaimTask(this.request().getParameter("taskId"));
		this.responseHtmltext(JSON.toJSONString(mm), this.response());
	}

	/**
	 * 待接收任务
	 * @param myPage
	 * @throws IOException
	 */
	@RequestMapping(params="method=selectWaitReceiveTasks")
	public void selectWaitReceiveTasks(MyPage myPage) throws IOException{
		MyPage page = psmcWorkFlowContext.getPsmcBaseWorkFlowService().selectWaitReceiveTasks(this.getUserBySeesion(this.request()),myPage);
		this.responseHtmltext(JSON.toJSONString(page), this.response());
	}

	/**
	 * 待处理任务（已接收）
	 * @param myPage
	 * @throws IOException
	 */
	@RequestMapping(params="method=selectWaitProcessTasks")
	public void selectWaitProcessTasks(MyPage myPage) throws IOException{
		MyPage page = psmcWorkFlowContext.getPsmcBaseWorkFlowService().selectWaitProcessTasks(this.getUserBySeesion(this.request()),myPage);
		this.responseHtmltext(JSON.toJSONString(page), this.response());
	}

	/**
	 * 已处理任务
	 * @param myPage
	 * @throws IOException
	 */
	@RequestMapping(params="method=selectProcessedTasks")
	public void selectProcessedTasks(MyPage myPage) throws IOException{
		MyPage page = psmcWorkFlowContext.getPsmcBaseWorkFlowService().selectProcessedTasks(this.getUserBySeesion(this.request()),myPage);
		this.responseHtmltext(JSON.toJSONString(page), this.response());
	}

	/**
	 * 我发起的任务
	 * @param myPage
	 * @throws IOException
	 */
	@RequestMapping(params="method=selectStartedByMeTasks")
	public void selectStartedByMeTasks(MyPage myPage) throws IOException{
		MyPage page = psmcWorkFlowContext.getPsmcBaseWorkFlowService().selectStartedByMeTasks(this.getUserBySeesion(this.request()),myPage);
		this.responseHtmltext(JSON.toJSONString(page), this.response());
	}

}
