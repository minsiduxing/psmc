package priv.guochun.psmc.system.framework.filter.interceptor.china;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import priv.guochun.psmc.system.framework.cxf.china.PsmcAbstractProcessChina;

/**
 * 测绘局工会基础的请求处理链路抽象类
 * @author guochun
 *
 */
public abstract class PsmcChjghBaseProcessChina extends PsmcAbstractProcessChina{

	private static final String validate_type="validate";
	private static final String validate_type_number="number";
	private static final String validate_type_tk="tk";

	/**
	 * 允许访问的集合 子类创建时进行初始化
	 */
	protected Map<String,String> allowedUri = new HashMap<String,String>();
	{
		this.allowedUri.put("/services/chjgh/weChatService/register", "{\"validate\": [{\"type\": \"number\",\"second\": 60}]}");
		this.allowedUri.put("/services/chjgh/weChatService/login","{\"validate\": [{\"type\": \"number\",\"second\": 60}]}");
		this.allowedUri.put("/services/chjgh/weChatService/getVcode","{\"validate\": [{\"type\": \"number\",\"second\": 10}]}");

		this.allowedUri.put("/services/chjgh/weChatService/getInfoList",null);
		this.allowedUri.put("/services/chjgh/weChatService/getDetailInfo",null);
		this.allowedUri.put("/services/chjgh/weChatService/getDict",null);

		this.allowedUri.put("/services/inquest/inquestWechatService/getPhoneNo","{\"validate\": [{\"type\": \"number\",\"second\": 60}]}");
		this.allowedUri.put("/services/inquest/inquestWechatService/codeToSession","{\"validate\": [{\"type\": \"number\",\"second\": 60}]}");
		this.allowedUri.put("/services/inquest/inquestWechatService/findInquestItemList","{\"validate\": [{\"type\": \"number\",\"second\": 60},{\"type\": \"tk\"}]}");
		this.allowedUri.put("/services/inquest/inquestWechatService/saveOrUpdateInquestRecord","{\"validate\": [{\"type\": \"number\",\"second\": 60},{\"type\": \"tk\"}]}");
		this.allowedUri.put("/services/inquest/inquestWechatService/getDictInfo","{\"validate\": [{\"type\": \"number\",\"second\": 60},{\"type\": \"tk\"}]}");
		this.allowedUri.put("/services/inquest/inquestWechatService/selectStageList","{\"validate\": [{\"type\": \"number\",\"second\": 60},{\"type\": \"tk\"}]}");
		this.allowedUri.put("/services/inquest/inquestWechatService/selectInquestRecord","{\"validate\": [{\"type\": \"number\",\"second\": 60},{\"type\": \"tk\"}]}");
	}

	protected boolean uriIsPassed(String methodName){
		return allowedUri.containsKey(methodName);
	}


	protected boolean basePathRaiseRootIsPassed(String basePathRaiseRoot){
		return allowedUri.containsKey(basePathRaiseRoot);
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
