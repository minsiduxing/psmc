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
		if("pa".equals(request().getParameter("taskName").toString())){
			String currStep = request().getParameter("currStep").toString();
			if("1".equals(currStep)){
				flowCommonParam.getVariables().put("step", "qaJbrTask"); // qaJbrTask流程图要改成qaFzrTask
				flowCommonParam.getVariables().put("paFzrList", flowCommonParam.getVariablesList());
			}
			if("2".equals(currStep)){
				flowCommonParam.getVariables().put("step", "qaZgTask");
				flowCommonParam.getVariables().put("paZgList", flowCommonParam.getVariablesList());
			}
			if("3".equals(currStep)){
				flowCommonParam.getVariables().put("step", "qaZgjlTask");
				flowCommonParam.getVariables().put("paZgjlList", flowCommonParam.getVariablesList());
			}
			if("4".equals(currStep)){
				flowCommonParam.getVariables().put("step", "nextTask");
				flowCommonParam.getVariables().put("fgsJbr", "fgsJbr");
			}
			flowCommonParam.getVariables().put("pass", false);
		}

		if("fgs".equals(request().getParameter("taskName").toString())){
			String currStep = request().getParameter("currStep").toString();
			if("1".equals(currStep)){
				flowCommonParam.getVariables().put("step", "fgsFzrTask");
				flowCommonParam.getVariables().put("paFzrList", flowCommonParam.getVariablesList());
			}
			if("2".equals(currStep)){
				flowCommonParam.getVariables().put("step", "fgsZgTask");
				flowCommonParam.getVariables().put("paZgList", flowCommonParam.getVariablesList());
			}
			if("3".equals(currStep)){
				flowCommonParam.getVariables().put("step", "fgsZgjlTask");
				flowCommonParam.getVariables().put("paZgjlList", flowCommonParam.getVariablesList());
			}
			if("4".equals(currStep)){
				flowCommonParam.getVariables().put("step", "nextTask");
				flowCommonParam.getVariables().put("gcjJbr", "gcjJbr");
			}
			if("5".equals(currStep)){
				flowCommonParam.getVariables().put("step", "prevTask");
			}
			flowCommonParam.getVariables().put("pass", true);
		}

		if("gcj".equals(request().getParameter("taskName").toString())){
			String currStep = request().getParameter("currStep").toString();
			if("1".equals(currStep)){
				flowCommonParam.getVariables().put("step", "gcjFzrTask");
				flowCommonParam.getVariables().put("paFzrList", flowCommonParam.getVariablesList());
			}
			if("2".equals(currStep)){
				flowCommonParam.getVariables().put("step", "gcjZgTask");
				flowCommonParam.getVariables().put("paZgList", flowCommonParam.getVariablesList());
			}
			if("3".equals(currStep)){
				flowCommonParam.getVariables().put("step", "gcjZgjlTask");
				flowCommonParam.getVariables().put("paZgjlList", flowCommonParam.getVariablesList());
			}
			if("4".equals(currStep)){
				flowCommonParam.getVariables().put("step", "endTask");
			}
			if("5".equals(currStep)){
				flowCommonParam.getVariables().put("step", "prevTask");
			}
			flowCommonParam.getVariables().put("pass", true);
		}


		MsgModel mm = psmcWorkFlowContext.getPsmcBaseWorkFlowService().completeTask(flowCommonParam.getTaskId(),flowCommonParam.getVariables(),flowCommonParam.getTransientVariables());
		this.responseMsgModel(mm, this.response());
	}
}
