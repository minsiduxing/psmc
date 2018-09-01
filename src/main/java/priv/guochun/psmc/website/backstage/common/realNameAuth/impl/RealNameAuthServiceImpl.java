package priv.guochun.psmc.website.backstage.common.realNameAuth.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.system.common.log.model.TSysOperLog;
import priv.guochun.psmc.system.common.log.service.TSysOperLogService;
import priv.guochun.psmc.system.common.sysConfig.model.TabSysConfig;
import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;
import priv.guochun.psmc.system.framework.util.LogResultEnum;
import priv.guochun.psmc.system.framework.util.LogTypeEnum;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;
import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.website.backstage.common.realNameAuth.RealNameAuthService;
import priv.guochun.psmc.website.backstage.dept.service.TabDeptService;
import priv.guochun.psmc.website.backstage.util.HttpUtils;

/**
 * 身份实名认证
 * @author Administrator
 *
 */
public class RealNameAuthServiceImpl implements RealNameAuthService{
	
	private final static  Logger logger  = LoggerFactory.getLogger(RealNameAuthServiceImpl.class);
	
	@Autowired
	private TSysOperLogService tSysOperLogService;
	
	/**
	 * 实名认证
	 * @param name 姓名
	 * @param idCard 身份证号
	 * @return
	 */
	@Override
	public String realNameAuth(String name, String idCard){
		logger.info("调用实名认证开始. name:" + name + ",idCard:" + idCard);
		//记录系统日志
		TSysOperLog sysOperLog = new TSysOperLog();
		sysOperLog.setUuid(UUIDGenerator.createUUID());
		sysOperLog.setLogType(LogTypeEnum.LogTypeSysOper4.getIndex());
		sysOperLog.setLogTypeName(LogTypeEnum.LogTypeSysOper4.getName());
		sysOperLog.setLogSubType(LogTypeEnum.LogTypeSysOper4_1.getIndex());
		sysOperLog.setLogSubTypeName(LogTypeEnum.LogTypeSysOper4_1.getName());
		sysOperLog.setOperDate(DateUtil.getCurrentTimstamp());
		sysOperLog.setOpername(name);
		sysOperLog.setOperInput("name:" + name + ", idCard:" + idCard);
		String result = "";
	    try {
	    	//获取实名认证系统参数配置
			PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory)MySpringApplicationContext.getObject("psmcCacheFactory");
			psmcCacheFactory.getCacheSystem();
			TabSysConfig sysConfig = psmcCacheFactory.getCacheSysConfigBykey(CacheContants.REAL_NAME_AUTHENTICATION);
			if(sysConfig != null){
				String host = sysConfig.getSysUrl();
				String path = sysConfig.getSysMethod();
				String appCode = sysConfig.getAppCode();
//					String host = "https://idcardcert.market.alicloudapi.com";
//				    String path = "/idCardCert";
			    String method = "GET";
//				    String appcode = "6832b17a03e9482d97bf9f041ac3fe8d";
			    Map<String, String> headers = new HashMap<String, String>();
			    //最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139xxx
			    headers.put("Authorization", "APPCODE " + appCode);
			    Map<String, String> querys = new HashMap<String, String>();
			    querys.put("idCard", idCard);
			    querys.put("name", name);
		    	HttpResponse response = HttpUtils.doGet(host, path, method, headers, querys);
	//		    	System.out.println(response.toString());//如不输出json, 请打开这行代码，打印调试头部状态码。
	//	                //状态码: 200 正常；400 URL无效；401 appCode错误； 403 次数用完； 500 API网管错误
	//		    	int code = response.getStatusLine().getStatusCode();
		    	//获取response的body
		    	//01:验证通过，02：验证不通过，202：无法验证，203：异常情况，204：姓名格式不正确，204：身份证格式不正确
		    	result = EntityUtils.toString(response.getEntity());
		    	sysOperLog.setOperResult(LogResultEnum.success.getIndex());
		    	sysOperLog.setOperResultDesc(LogResultEnum.success.getName());
		    	sysOperLog.setOperOutput(result);
		    	logger.info("调用实名认证结束. code:" + response.getStatusLine().getStatusCode() + "result:" + result);
			}else{
				sysOperLog.setOperResult(LogResultEnum.error.getIndex());
		    	sysOperLog.setOperResultDesc(LogResultEnum.error.getName());
		    	sysOperLog.setOperOutput("未获取到系统参数配置,实名认证调用失败." );
		    	logger.error("未获取到系统参数配置,实名认证调用失败.");
			}
	    } catch (Exception e) {
	    	sysOperLog.setOperResult(LogResultEnum.error.getIndex());
	    	sysOperLog.setOperResultDesc(LogResultEnum.error.getName());
	    	sysOperLog.setOperOutput("调用实名认证异常." + e.getMessage());
	    	logger.error("调用实名认证异常." + e.getMessage());
	    }
		tSysOperLogService.save(sysOperLog);
	    return result;
	}
	
	
}
