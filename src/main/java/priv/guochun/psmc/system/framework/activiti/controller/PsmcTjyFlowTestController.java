package priv.guochun.psmc.system.framework.activiti.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import priv.guochun.psmc.system.framework.activiti.service.PsmcTjyFlowTestService;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.model.MsgModel;

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
		//申请人角色
		variables.put("role_requirement", "role_requirement");
		//立项人角色
		variables.put("role_businessment", "role_businessment");
		
//		//科长审批角色
//		variables.put("role_chief", "role_chief");
//		//1通过0不通过
//		variables.put("chief_audit", "1");
//		variables.put("chief_audit", "0");
//		//局长审批角色
//		variables.put("role_director", "role_director");

		MsgModel mm = psmcTjyFlowTestService.startFlow(variables);
		this.responseHtmltext(JSONObject.valueToString(mm), this.response());
	}


	@RequestMapping(params="method=completeTask")
	public void completeTask() throws IOException{
		Map<String, Object> variables = new HashMap<String, Object>();
		MsgModel mm = psmcTjyFlowTestService.completeTask(this.request().getParameter("taskId"),variables);
		this.responseHtmltext(JSONObject.valueToString(mm), this.response());
	}
}
