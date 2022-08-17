package priv.guochun.psmc.system.framework.activiti.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.guochun.psmc.system.framework.activiti.service.PsmcTjyFlowTestService;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.model.MsgModel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/system/framework/tjyFlowTestController")
public class PsmcTjyFlowTestController extends MyController {
	
	@Autowired
	private PsmcTjyFlowTestService psmcTjyFlowTestService;
	
	@ResponseBody
	@RequestMapping(params="method=startFlow")  
	public void startFlow() throws IOException{
		
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("formNo", "tjyflowId");
		//流程启动人
		variables.put("startUserId", this.getUserBySeesion(this.request()).getAccountName());
		//立项人角色
		variables.put("role_businessment", "lx_admin,lx_admin2,lx_admin3");

		MsgModel mm = psmcTjyFlowTestService.startFlow(variables);
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
		MsgModel mm = psmcTjyFlowTestService.completeTask(this.request().getParameter("taskId"),variables);
		this.responseHtmltext(JSON.toJSONString(mm), this.response());
	}

	/**
	 * 接收认领任务，认领后其他人待接收任务列表就没有了
	 * @throws IOException
	 */
	@RequestMapping(params="method=claimTask")
	public void claimTask() throws IOException{
		Map<String, Object> variables = new HashMap<String, Object>();
		MsgModel mm = psmcTjyFlowTestService.claimTask(this.request().getParameter("taskId"),this.request().getParameter("userId"));
		this.responseHtmltext(JSON.toJSONString(mm), this.response());
	}

	/**
	 * 释放任务，释放后其他人待接收任务列表就出现了
	 * @throws IOException
	 */
	@RequestMapping(params="method=unClaimTask")
	public void unClaimTask() throws IOException{
		Map<String, Object> variables = new HashMap<String, Object>();
		MsgModel mm = psmcTjyFlowTestService.unClaimTask(this.request().getParameter("taskId"));
		this.responseHtmltext(JSON.toJSONString(mm), this.response());
	}
}
