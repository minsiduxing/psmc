package priv.guochun.psmc.system.framework.cxf.interceptor;
import java.util.Date;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.transport.http.AbstractHTTPDestination;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.system.framework.cxf.china.model.VisitModel;
import priv.guochun.psmc.system.util.IpUtil;
import priv.guochun.psmc.system.framework.cxf.china.factory.PsmcChjghProcessChinaFactory;

/**
 * psmc接口服务器拦截器
 * @author guochun
 *
 */
public class PsmcServicePreInterceptor extends
		AbstractPhaseInterceptor<Message> {

	protected static final  Logger logger  = LoggerFactory.getLogger(PsmcServicePreInterceptor.class);
	 
	protected PsmcChjghProcessChinaFactory psmcChjghProcessChinaFactory;
	
	
	public PsmcServicePreInterceptor(){
		super(Phase.PRE_INVOKE);
	}
	
	public PsmcServicePreInterceptor(String phase){
		super(phase);
	}
	
	
	
	@SuppressWarnings({ "rawtypes", "static-access" })
	@Override
	public void handleMessage(Message message) throws Fault {
		HttpServletRequest request = (HttpServletRequest) message.get(AbstractHTTPDestination.HTTP_REQUEST);
		String clientIp = IpUtil.getIpAddr(request);
		String tk = request.getHeader("tk");
		Set set = message.entrySet();
		Iterator iter = set.iterator();
		String targetUri = null;
		String targetMethod = null;
		String pathToMatchSlash = null;
		String basePath = null;
		String basePathRaiseRoot = null;
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
			if("path_to_match_slash".equals(key)){
				pathToMatchSlash = map.getValue().toString();
			}
			if("org.apache.cxf.message.Message.BASE_PATH".equals(key)){
				basePath = map.getValue().toString();
				basePathRaiseRoot = basePath.substring(basePath.indexOf("/",1),basePath.length());
			}
		}
		VisitModel visitModel = new VisitModel();
		visitModel.setClientIp(clientIp);
		visitModel.setVisitDate(new Date());
		visitModel.setVisitTargetMethod(targetMethod);
		visitModel.setTargetUri(targetUri);
		visitModel.setPathToMatchSlash(pathToMatchSlash);
		visitModel.setBasePath(basePath);
		visitModel.setBasePathRaiseRoot(basePathRaiseRoot);
		visitModel.setTk(tk);
		//组装处理链 对请求进行层层筛查
		String result = psmcChjghProcessChinaFactory.buildChjghProcessChina().processTask(visitModel);
		if(StringUtils.isNotBlank(result)){
			//如果不为空 说明链路处理期间遇到错误被拦截
			logger.warn(result);
			HttpServletResponse response = (HttpServletResponse)message.get(AbstractHTTPDestination.HTTP_RESPONSE);
			ServletOutputStream out;
			try {
				response.setContentType("application/json;charset=UTF-8");
				out = response.getOutputStream();
				out.write(result.getBytes("utf-8"));
				out.flush();
				message.getInterceptorChain().doInterceptStartingAfter(message, "org.apache.cxf.jaxrs.interceptor.JAXRSOutInterceptor");
				out.close();
			} catch (Exception e) {
				logger.error("cxf拦截器返回异常："+e);
			}
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
