package priv.guochun.psmc.website.backstage.common.china.factory;

import priv.guochun.psmc.system.framework.filter.interceptor.china.PsmcInterfaceServiceProcessChina;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;

public class PsmcChjghProcessChinaFactory {

	
	public static PsmcInterfaceServiceProcessChina firstChina  = null;
	
	/**
	 * 组装测绘局工会接口的处理链
	 * @return
	 */
	public static synchronized PsmcInterfaceServiceProcessChina buildChjghProcessChina(){

		if(firstChina == null){
			Object obj = MySpringApplicationContext.getObject("psmcChjghMethodProcessChina");
			if(obj == null)
				throw new RuntimeException(" build china error: psmcChjghMethodProcessChina not in spring ioc!!! ");
			
			firstChina = (PsmcInterfaceServiceProcessChina)obj;
		}


//		Object headProcessChina = MySpringApplicationContext.getObject("headProcessChina");
//		if(headProcessChina == null)
//			throw new RuntimeException(" build china error: psmcChjghMethodProcessChina not in spring ioc!!! ");
//
//		firstChina.setNextProcessChina((PsmcInterfaceServiceProcessChina)headProcessChina);


		return firstChina;
	}
	
	
}
