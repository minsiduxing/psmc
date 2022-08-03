package priv.guochun.psmc.system.framework.cxf.china.service.impl;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import priv.guochun.psmc.authentication.user.service.TabAccountService;
import priv.guochun.psmc.system.framework.cxf.china.model.VisitModel;
import priv.guochun.psmc.system.framework.cxf.china.service.PsmCxfBaseProcessChina;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.util.GsonUtil;

import java.util.Map;

/**
 * 处理tk验证
 */
public class PsmcTkValiateProcessChina extends PsmCxfBaseProcessChina {

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
						return GsonUtil.toJsonForObject(MsgModel.buildDefaultError("验证失败,身份认证失败"));
				} else
						return GsonUtil.toJsonForObject(MsgModel.buildDefaultError("验证失败,身份认证失败"));
			}
			//传递给下一个链类处理
			return this.processNextChina(visitModel);
	}
}
