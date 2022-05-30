package priv.guochun.psmc.system.framework.filter.interceptor.china;

import priv.guochun.psmc.system.framework.filter.interceptor.model.VisitModel;


/**
 * psmc 接口服务处理链接口
 * @author guochun
 *
 */

public interface PsmcInterfaceServiceProcessChina {

	/**
	 * 执行方法
	 * @param visitModel
	 * @return
	 */
	public String processTask(VisitModel visitModel);

	public abstract void setNextProcessChina(PsmcInterfaceServiceProcessChina ifProcessChina) ;
	
	
}
