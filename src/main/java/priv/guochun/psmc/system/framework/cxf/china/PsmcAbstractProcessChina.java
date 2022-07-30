package priv.guochun.psmc.system.framework.cxf.china;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.system.framework.filter.interceptor.china.PsmcInterfaceServiceProcessChina;
import priv.guochun.psmc.system.framework.filter.interceptor.model.VisitModel;

public abstract class PsmcAbstractProcessChina implements PsmcInterfaceServiceProcessChina{

	protected static final  Logger logger  = LoggerFactory.getLogger(PsmcAbstractProcessChina.class);
	 
	private PsmcInterfaceServiceProcessChina ifProcessChina;
	
	@Override
	public void setNextProcessChina(PsmcInterfaceServiceProcessChina ifProcessChina) {
		this.ifProcessChina = ifProcessChina;
	}
	
	protected String processNextChina(VisitModel visitModel){
		if(ifProcessChina != null)
			return ifProcessChina.processTask(visitModel);
		return null;
	}
	
}
