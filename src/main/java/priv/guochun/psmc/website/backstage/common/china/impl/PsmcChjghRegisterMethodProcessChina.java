package priv.guochun.psmc.website.backstage.common.china.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import priv.guochun.psmc.system.framework.filter.interceptor.china.PsmcChjghBaseProcessChina;
import priv.guochun.psmc.system.framework.filter.interceptor.model.VisitModel;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.util.GsonUtil;
import priv.guochun.psmc.system.util.DateUtil;

/**
 * 测绘局工会注册方法 预处理链路类
 * @author guochun
 *
 */
public class PsmcChjghRegisterMethodProcessChina extends  PsmcChjghBaseProcessChina{

	private Map<String,Long> loginMap =  new HashMap<String,Long>();
	
	private long visitLockTime = 60;
	
	public PsmcChjghRegisterMethodProcessChina(){
		this.allowedUri.put("/psmc/services/chjgh/weChatService/register",null);
	}
	
	@Override
	public String processTask(VisitModel visitModel) {
		if(visitModel != null && uriIsPassed(visitModel.getTargetUri())){
			String clientIp = visitModel.getClientIp();
			String visitTargetMethod = visitModel.getVisitTargetMethod();
			Date visitDate = visitModel.getVisitDate();
			String visitKey = clientIp+"_"+visitTargetMethod;
			
			//如果没有访问信息，则记录一条并返回
			if(!loginMap.containsKey(visitKey)){
				loginMap.put(visitKey, DateUtil.getCurrentDateTime());
			}else{
				long lastLoginTime = loginMap.get(visitKey);
				long visitTime = visitDate.getTime();
				//如果第二次访问在5分钟内
				if((visitTime - lastLoginTime)/1000 <= visitLockTime){
					String msg = visitKey+"两次访问的时间间隔在"+visitLockTime+"秒内!";
					logger.debug(msg);
					return GsonUtil.toJsonForObject(MsgModel.buildDefaultError(msg));
				}else
					loginMap.put(visitKey, DateUtil.getCurrentDateTime());
			}
		}
		//传递给下一个链类处理
		return this.processNextChina(visitModel);
	}
	
}
