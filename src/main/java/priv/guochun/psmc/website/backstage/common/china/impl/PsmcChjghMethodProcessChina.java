package priv.guochun.psmc.website.backstage.common.china.impl;

import priv.guochun.psmc.system.framework.filter.interceptor.china.PsmcChjghBaseProcessChina;
import priv.guochun.psmc.system.framework.filter.interceptor.model.VisitModel;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.util.GsonUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 测绘局工会部分方法 预处理链路类
 * @author guochun
 *
 */
public class PsmcChjghMethodProcessChina extends  PsmcChjghBaseProcessChina{

	private Map<String,Long> loginMap =  new HashMap<String,Long>();

	//服务方法访问间隔时间 单位秒
	private long visitLockTime = 20;
	
	public PsmcChjghMethodProcessChina(){

		this.allowedUri.put("/services/chjgh/weChatService/register",null);
		this.allowedUri.put("/services/chjgh/weChatService/login",null);
		this.allowedUri.put("/services/chjgh/weChatService/getVcode",null);

		this.allowedUri.put("/services/chjgh/weChatService/getInfoList",null);
		this.allowedUri.put("/services/chjgh/weChatService/getDetailInfo",null);
	}
	
	@Override
	public String processTask(VisitModel visitModel) {
		if(visitModel != null && this.basePathRaiseRootIsPassed(visitModel.getBasePathRaiseRoot()+visitModel.getPathToMatchSlash())){
			String clientIp = visitModel.getClientIp();
			String visitTargetMethod = visitModel.getVisitTargetMethod();
			Date visitDate = visitModel.getVisitDate();
			String visitKey = clientIp+"_"+visitTargetMethod;
			
			//如果没有访问信息，则记录一条并返回
//			if(!loginMap.containsKey(visitKey)){
//				loginMap.put(visitKey, DateUtil.getCurrentDateTime());
//			}else{
//				long lastLoginTime = loginMap.get(visitKey);
//				long visitTime = visitDate.getTime();
//
//				if((visitTime - lastLoginTime)/1000 <= visitLockTime){
//					String msg = "您访问的太频繁了,请稍等片刻操作!";
//					logger.warn(visitKey+" 访问频率超过限定时间 ");
//					return GsonUtil.toJsonForObject(MsgModel.buildDefaultError(msg));
//				}else
//					loginMap.put(visitKey, DateUtil.getCurrentDateTime());
//			}
			//传递给下一个链类处理
			return this.processNextChina(visitModel);
		}else
			return GsonUtil.toJsonForObject(MsgModel.buildDefaultError("非法请求"));
	}
	
}
