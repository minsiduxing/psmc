package priv.guochun.psmc.website.backstage.common.interceptor;
import java.util.Date;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.system.framework.filter.interceptor.model.VisitModel;
import priv.guochun.psmc.system.util.IpUtil;
import priv.guochun.psmc.website.backstage.common.china.factory.PsmcChjghProcessChinaFactory;

/**
 * psmc接口服务器拦截器
 * @author guochun
 *
 */
public class PsmcChjghServicePreInterceptor extends
		AbstractPhaseInterceptor<Message> {

	protected static final  Logger logger  = LoggerFactory.getLogger(PsmcChjghServicePreInterceptor.class);
	 
	protected PsmcChjghProcessChinaFactory psmcChjghProcessChinaFactory;
	
	
	public PsmcChjghServicePreInterceptor(){
		super(Phase.PRE_INVOKE);
	}
	
	public PsmcChjghServicePreInterceptor(String phase){
		super(phase);
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "static-access" })
	@Override
	public void handleMessage(Message message) throws Fault {
		HttpServletRequest request = (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);
		String clientIp = IpUtil.getIpAddr(request);
		Set set = message.entrySet();
		Iterator iter = set.iterator();
		String targetUri = null;
		String targetMethod = null;
		while(iter.hasNext())
		{
			Entry map = (Entry)iter.next();
//			logger.debug("***********"+map);
			String key = map.getKey().toString();
			if("org.apache.cxf.request.uri".equals(key)){
				targetUri = map.getValue().toString();
			}
			if("org.apache.cxf.resource.method".equals(key)){
				targetMethod = map.getValue().toString();
			}
		}
		VisitModel visitModel = new VisitModel();
		visitModel.setClientIp(clientIp);
		visitModel.setVisitDate(new Date());
		visitModel.setVisitTargetMethod(targetMethod);
		
		//组装处理链 对请求进行层层筛查
		String result = psmcChjghProcessChinaFactory.buildChjghProcessChina().processTask(visitModel);
		if(StringUtils.isNotBlank(result)){
			//如果不为空 说明链路处理期间遇到错误被拦截
			System.out.println(result);
			throw new Fault(new IllegalArgumentException(result)); 
			
		}
		
		
	}

	public PsmcChjghProcessChinaFactory getPsmcChjghProcessChinaFactory() {
		return psmcChjghProcessChinaFactory;
	}

	public void setPsmcChjghProcessChinaFactory(
			PsmcChjghProcessChinaFactory psmcChjghProcessChinaFactory) {
		this.psmcChjghProcessChinaFactory = psmcChjghProcessChinaFactory;
	}
	
	
	
	
}
