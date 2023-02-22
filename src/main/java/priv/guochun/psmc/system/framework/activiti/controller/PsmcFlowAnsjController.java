package priv.guochun.psmc.system.framework.activiti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.guochun.psmc.system.framework.activiti.core.PsmcWorkFlowContext;
import priv.guochun.psmc.system.framework.activiti.model.FlowCommonParam;
import priv.guochun.psmc.system.framework.activiti.util.FlowContans;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.model.MsgModel;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/system/framework/AnsjFlowController")
public class PsmcFlowAnsjController extends MyController {
	
	@Autowired
	private PsmcWorkFlowContext psmcWorkFlowContext;

	@ResponseBody
	@RequestMapping(params="method=startFlow")  
	public void startFlow(FlowCommonParam flowCommonParam) throws IOException{
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put(FlowContans.FLOW_COMMON_VARIABLES_FLOW_EN_NAME, "CXXMGL");
		//流程启动人
		variables.put(FlowContans.FLOW_COMMON_VARIABLES_STARTED, this.getUserBySeesion(this.request()).getAccountName());
		MsgModel mm = psmcWorkFlowContext.getPsmcBaseWorkFlowService().startFlow(variables);
		this.responseMsgModel(mm, this.response());
	}

	/**
	 * 完成任务
	 * @param flowCommonParam
	 * @throws IOException
	 */
	@RequestMapping(params="method=submitTask")
	public void submitTask(FlowCommonParam flowCommonParam) throws IOException{
		//flowCommonParam.getVariables().put("paFzrList", flowCommonParam.getVariablesList());
		if("end".equals(request().getParameter("isEnd")!=null?request().getParameter("isEnd").toString():"")){
			flowCommonParam.getVariables().put("paZq", "1");
			flowCommonParam.getVariables().put("paZjl", "admin");
		}
		MsgModel mm = psmcWorkFlowContext.getPsmcBaseWorkFlowService().completeTask(flowCommonParam.getTaskId(),flowCommonParam.getVariables(),flowCommonParam.getTransientVariables());
		this.responseMsgModel(mm, this.response());
	}
}
