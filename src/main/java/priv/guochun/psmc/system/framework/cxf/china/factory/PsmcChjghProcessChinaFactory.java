package priv.guochun.psmc.system.framework.cxf.china.factory;

import priv.guochun.psmc.system.framework.cxf.china.base.PsmcInterfaceServiceProcessChina;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;

public class PsmcChjghProcessChinaFactory {

	
	public static PsmcInterfaceServiceProcessChina firstChina  = null;
	
	/**
	 * 组装测绘局工会接口的处理链
	 * @return
	 */
	public static synchronized PsmcInterfaceServiceProcessChina buildChjghProcessChina(){

		if(firstChina == null){
			Object obj = MySpringApplicationContext.getObject("psmcFirstValiateProcessChina");
			if(obj == null)
				throw new RuntimeException(" build china error: psmcFirstValiateProcessChina not in spring ioc!!! ");
			
			firstChina = (PsmcInterfaceServiceProcessChina)obj;
		}


		Object tkProcessChina = MySpringApplicationContext.getObject("psmcTkValiateProcessChina");
		if(tkProcessChina == null)
			throw new RuntimeException(" build china error: psmcTkValiateProcessChina not in spring ioc!!! ");

		firstChina.setNextProcessChina((PsmcInterfaceServiceProcessChina)tkProcessChina);


		return firstChina;
	}
	
	
}
