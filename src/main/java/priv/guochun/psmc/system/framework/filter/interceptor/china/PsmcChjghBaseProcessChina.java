package priv.guochun.psmc.system.framework.filter.interceptor.china;

import java.util.HashMap;
import java.util.Map;

import priv.guochun.psmc.website.backstage.common.china.PsmcAbstractProcessChina;

/**
 * 测绘局工会基础的请求处理链路抽象类
 * @author guochun
 *
 */
public abstract class PsmcChjghBaseProcessChina extends PsmcAbstractProcessChina{

	/**
	 * 允许访问的集合 子类创建时进行初始化
	 */
	protected Map<String,String> allowedUri = new HashMap<String,String>();
	
	
	protected boolean uriIsPassed(String methodName){
		return allowedUri.containsKey(methodName);
	}
	
}
