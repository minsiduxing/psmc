package priv.guochun.psmc.website.backstage.message.api;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.util.JsonUtil;
import priv.guochun.psmc.website.backstage.message.model.ReceiveDataDto;
import priv.guochun.psmc.website.backstage.message.service.TabMessagePoolService;

@Controller
@RequestMapping("/api/sms/SmsController")
public class SmsController extends MyController{
	
	protected static final  Logger logger  = LoggerFactory.getLogger(SmsController.class);
			
	@Autowired
	private TabMessagePoolService tabMessagePoolService;
	
	@RequestMapping(params="method=receiveReplies")
	@ResponseBody
	public void receiveReplies(ReceiveDataDto receiveDataDto) throws IOException {
		logger.info("入参："+JSONObject.toJSONString(receiveDataDto));
		Map<String, String> resMap = new HashMap<String, String>();
		if(receiveDataDto!=null) {
			if(receiveDataDto.getMobile()!=null && receiveDataDto.getContent()!=null) {
				if(receiveDataDto.getContent().toLowerCase().equals("td")) {
					tabMessagePoolService.deletePoolAndAddBlackByPhone(receiveDataDto.getMobile(), receiveDataDto.getContent());
					resMap.put("returnStatus", "1");
					resMap.put("message", "成功");
				}else {
					resMap.put("returnStatus", "0");
					resMap.put("message", "未回复td，数据不进行更改");
				}
			}else {
				resMap.put("returnStatus", "0");
				resMap.put("message", "手机号或回复内容为空");
			}
		}else {
			resMap.put("returnStatus", "0");
			resMap.put("message", "参数为空");
		}
		super.responseJson(JsonUtil.convertToJSONObject(resMap), this.response());
	}
}
