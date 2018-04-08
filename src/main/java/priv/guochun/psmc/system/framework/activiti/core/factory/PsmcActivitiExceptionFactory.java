package priv.guochun.psmc.system.framework.activiti.core.factory;

import priv.guochun.psmc.system.framework.activiti.core.exception.PsmcActivitiNotAllowUeseApiException;

public class PsmcActivitiExceptionFactory {

	
	public static PsmcActivitiNotAllowUeseApiException createNotAllowUeseApiException(){
		return new PsmcActivitiNotAllowUeseApiException("当前API未开放使用");
	}
}
