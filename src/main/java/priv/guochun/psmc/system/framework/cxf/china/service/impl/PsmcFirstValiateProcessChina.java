package priv.guochun.psmc.system.framework.cxf.china.service.impl;

import com.alibaba.fastjson.JSONObject;
import priv.guochun.psmc.system.framework.cxf.china.service.PsmCxfBaseProcessChina;
import priv.guochun.psmc.system.framework.cxf.china.model.VisitModel;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.util.GsonUtil;
import priv.guochun.psmc.system.util.DateUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 接口处理首链路（次数校验）
 */
public class PsmcFirstValiateProcessChina extends PsmCxfBaseProcessChina {

	private Map<String,Long> loginMap =  new HashMap<String,Long>();

	@Override
	public String processTask(VisitModel visitModel) {
		if(this.allowedUri.size() ==0){
			return GsonUtil.toJsonForObject(MsgModel.buildDefaultError("系统初始化未完成,请稍后在试!"));
		}
		String visitUrl = visitModel.getBasePathRaiseRoot() + visitModel.getPathToMatchSlash();
		if (visitModel != null && this.uriIsPassed(visitUrl)) {
			String clientIp = visitModel.getClientIp();
			String visitTargetMethod = visitModel.getVisitTargetMethod();
			Date visitDate = visitModel.getVisitDate();
			String visitKey = clientIp + "_" + visitTargetMethod;

			JSONObject jo = this.getNumberValiateJSONObject(visitUrl);
			if(jo != null){
				//默认校验时间一分钟，接口还可以根据配置来调整
				long visitLockTime = 60;
				if(jo.getLong("second") != 0)
					visitLockTime = jo.getLong("second");
				//如果没有访问信息，则记录一条并返回
				if(!loginMap.containsKey(visitKey)){
					loginMap.put(visitKey, DateUtil.getCurrentDateTime());
				}else{
					long lastLoginTime = loginMap.get(visitKey);
					long visitTime = visitDate.getTime();
					long result = visitLockTime - (visitTime - lastLoginTime)/1000;
					if((visitTime - lastLoginTime)/1000 <= visitLockTime){
						String msg = "您访问的太频繁了,请稍等"+result+"秒后进行操作!";
						return GsonUtil.toJsonForObject(MsgModel.buildDefaultError(msg));
					}else
						loginMap.put(visitKey, DateUtil.getCurrentDateTime());
				}
				return this.processNextChina(visitModel);
			}else{
				//传递给下一个链类处理
				return this.processNextChina(visitModel);
			}
		} else
			return GsonUtil.toJsonForObject(MsgModel.buildDefaultError("非法请求"));
	}
}
