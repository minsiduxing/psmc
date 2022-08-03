package priv.guochun.psmc.system.framework.cxf.china.base;

import priv.guochun.psmc.system.framework.cxf.china.model.VisitModel;


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

	/**
	 * 设置下一个处理链路
	 * @param ifProcessChina
	 */

	public abstract void setNextProcessChina(PsmcInterfaceServiceProcessChina ifProcessChina) ;

	/**
	 * 初始化处理权限
	 */
	public abstract void initCxfallowedUri();
}
