package priv.guochun.psmc.system.framework.cxf.china.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import priv.guochun.psmc.system.common.sysConfig.model.TabSysConfig;
import priv.guochun.psmc.system.common.sysConfig.service.TabSysConfigService;
import priv.guochun.psmc.system.framework.cxf.china.base.PsmcAbstractProcessChina;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 请求处理链路抽象类
 * @author guochun
 *
 */
public abstract class PsmCxfBaseProcessChina extends PsmcAbstractProcessChina{

	private static final String validate_type="validate";
	private static final String validate_type_number="number";
	private static final String validate_type_tk="tk";

	protected static final Logger logger  = LoggerFactory.getLogger(PsmCxfBaseProcessChina.class);
	/**
	 * 允许访问的集合 子类创建时进行初始化
	 */
	protected static Map<String,String> allowedUri = new HashMap<String,String>();

	public void initCxfallowedUri() {
		if(this.allowedUri.size() == 0) {
			TabSysConfigService tabSysConfigService = (TabSysConfigService) MySpringApplicationContext.getObject("tabSysConfigService");
			List<TabSysConfig> configs = tabSysConfigService.findSysConfigList(null, null);
			if (configs != null && configs.size() > 0) {
				for (int i = 0; i < configs.size(); i++) {
					TabSysConfig config = configs.get(i);
					this.allowedUri.put(config.getSysUrl(), config.getColumn1());
				}
			}
			logger.info("cxf allowedUri init over!");
		}
	}

	protected boolean uriIsPassed(String methodName){
		return allowedUri.containsKey(methodName);
	}


	/**
	 * 获取次数校验配置
	 * @param visitUrl
	 * @return
	 */
	protected JSONObject getNumberValiateJSONObject(String visitUrl){
		return getValiateJSONObject(visitUrl,validate_type_number);
	}

	/**
	 * 获取tk校验配置
	 * @param visitUrl
	 * @return
	 */
	protected JSONObject getTkValiateJSONObject(String visitUrl){
		return getValiateJSONObject(visitUrl,validate_type_tk);
	}

	private JSONObject getValiateJSONObject(String visitUrl,String validateSubType){
		JSONObject result = null;
		if(StringUtils.isNotBlank(visitUrl) && this.allowedUri.get(visitUrl) != null){
			JSONObject jo = (JSONObject)JSONObject.parseObject(this.allowedUri.get(visitUrl).toString());
			JSONArray validateJo = (JSONArray)JSONObject.parseArray(jo.getString(validate_type));
			if(validateJo == null)
				return result;
			for(int i=0;i<validateJo.size();i++){
				JSONObject jotemp = (JSONObject)validateJo.get(i);
				if(validateSubType.equals(jotemp.getString("type"))) {
					result = jotemp;
					break;
				}
			}
		}
		return result;
	}
}
