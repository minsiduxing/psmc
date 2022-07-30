package priv.guochun.psmc.system.framework.cxf.china.impl;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import priv.guochun.psmc.authentication.user.service.TabAccountService;
import priv.guochun.psmc.system.framework.filter.interceptor.china.PsmcChjghBaseProcessChina;
import priv.guochun.psmc.system.framework.filter.interceptor.model.VisitModel;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.util.GsonUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 处理tk验证
 */
public class PsmcTkValiateProcessChina extends  PsmcChjghBaseProcessChina{

	private Map<String,Long> loginMap =  new HashMap<String,Long>();
	@Autowired
	private TabAccountService tabAccountService;

	@Override
	public String processTask(VisitModel visitModel) {
			String visitUrl = visitModel.getBasePathRaiseRoot() + visitModel.getPathToMatchSlash();
			JSONObject jo = this.getTkValiateJSONObject(visitUrl);
			if(jo != null){
				String tk = visitModel.getTk();
				if (StringUtils.isNotBlank(tk)) {
					Map map = tabAccountService.getTabAccount(tk);
					if(map == null)
						return GsonUtil.toJsonForObject(MsgModel.buildDefaultError("验证失败,非法用户请求"));
					} else
						return GsonUtil.toJsonForObject(MsgModel.buildDefaultError("验证失败,非法用户请求"));
				}
			//传递给下一个链类处理
			return this.processNextChina(visitModel);
	}
}
