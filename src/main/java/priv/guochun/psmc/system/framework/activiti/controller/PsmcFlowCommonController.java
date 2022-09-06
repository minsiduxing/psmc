package priv.guochun.psmc.system.framework.activiti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.guochun.psmc.system.framework.activiti.core.PsmcWorkFlowContext;
import priv.guochun.psmc.system.framework.activiti.model.FlowCommonParam;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.JsonUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/system/framework/flowCommonController")
public class PsmcFlowCommonController extends MyController {
	
	@Autowired
	private PsmcWorkFlowContext psmcWorkFlowContext;

	/**
     * 完成任务
	 * @param flowCommonParam
     * @throws IOException
	 */
	@RequestMapping(params="method=completeTask")
	public void completeTask(FlowCommonParam flowCommonParam) throws IOException{
		MsgModel mm = psmcWorkFlowContext.getPsmcBaseWorkFlowService().completeTask(flowCommonParam.getTaskId(),flowCommonParam.getVariables(),flowCommonParam.getTransientVariables());
		this.responseMsgModel(mm, this.response());
	}

	/**
	 * 接收认领任务，认领后其他人待接收任务列表就没有了
	 * @throws IOException
	 */
	@RequestMapping(params="method=claimTask")
	public void claimTask(String taskId) throws IOException{
		MsgModel mm = psmcWorkFlowContext.getPsmcBaseWorkFlowService().claimTask(taskId,this.getUserBySeesion(this.request()).getAccountName());
		this.responseMsgModel(mm, this.response());
	}

	/**
	 * 释放任务，释放后其他人待接收任务列表就出现了
	 * @throws IOException
	 */
	@RequestMapping(params="method=unClaimTask")
	public void unClaimTask(FlowCommonParam flowCommonParam) throws IOException{
		MsgModel mm = psmcWorkFlowContext.getPsmcBaseWorkFlowService().unClaimTask(flowCommonParam.getTaskId());
		this.responseMsgModel(mm, this.response());
	}

	/**
	 * 待接收任务
	 * @param myPage
	 * @throws IOException
	 */
	@RequestMapping(params="method=selectWaitReceiveTasks")
	@ResponseBody
	public void selectWaitReceiveTasks(MyPage myPage) throws IOException{
		MyPage page = psmcWorkFlowContext.getPsmcBaseWorkFlowService().selectWaitReceiveTasksBusinessMethod(this.getUserBySeesion(this.request()),myPage);
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
		MyPage page = psmcWorkFlowContext.getPsmcBaseWorkFlowService().selectWaitProcessTasksBusinessMethod(this.getUserBySeesion(this.request()),myPage);
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
		MyPage page = psmcWorkFlowContext.getPsmcBaseWorkFlowService().selectProcessedTasksBusinessMethod(this.getUserBySeesion(this.request()),myPage);
		super.responseJson(JsonUtil.convertToJSONObject(page), this.response());
	}


	/**
	 * 已处理任务
	 * @param pid
	 * @throws IOException
	 */
	@RequestMapping(params="method=selectProcessedTasksByPid")
	@ResponseBody
	public void selectProcessedTasksByPid(String pid) throws IOException{
		Map<String,Object> queryParams = new HashMap<>();
		queryParams.put("tfi_uuid",pid);
		MyPage page = new MyPage();
		page.setQueryParams(queryParams);
		page = psmcWorkFlowContext.getPsmcBaseWorkFlowService().selectProcessedTasksBusinessMethod(null,page);
		super.responseJson(JsonUtil.convertToJSONObject(page), this.response());
	}

	/**
	 * 已处理任务
	 * @param pid
	 * @throws IOException
	 */
	@RequestMapping(params="method=selectProcessedTaskAttachmentsByPid")
	@ResponseBody
	public void selectProcessedTaskAttachmentsByPid(String pid) throws IOException{
		Map<String,Object> queryParams = new HashMap<>();
		queryParams.put("queryAtachment","true");
		queryParams.put("tfi_uuid",pid);
		MyPage page = new MyPage();
		page.setQueryParams(queryParams);
		page = psmcWorkFlowContext.getPsmcBaseWorkFlowService().selectProcessedTasksBusinessMethod(null,page);
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
		MyPage page = psmcWorkFlowContext.getPsmcBaseWorkFlowService().selectStartedByMeTasksBusinessMethod(this.getUserBySeesion(this.request()),myPage);
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

	/**
	 * 根据流程id获取流程运行图片
	 * @param pid
	 * @throws Exception
	 */
	@RequestMapping(params="method=getFlowImgByInstanceId")
	public void getFlowImgByInstanceId(String pid) throws Exception {
		byte[] bytes = psmcWorkFlowContext.getPsmcBaseWorkFlowService().getFlowImgByInstanceId(pid);
		super.responseImage(bytes, response());
	}
}
