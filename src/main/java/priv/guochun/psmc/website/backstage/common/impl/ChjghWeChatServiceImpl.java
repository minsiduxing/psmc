package priv.guochun.psmc.website.backstage.common.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Hashtable;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.authentication.login.service.LoginService;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.util.GsonUtil;
import priv.guochun.psmc.website.backstage.common.ChjghWeChatService;


public class ChjghWeChatServiceImpl implements ChjghWeChatService {

	private LoginService loginService;
	@Override
	public String login(String phone, String code) {
		MsgModel msg = null;
		// TODO 验证码校验
		
		//用户校验
		User user = loginService.buildUserByPhone(phone);
		if(user == null){
			msg = MsgModel.buildError("用户不存在");
			return GsonUtil.toJsonForObject(msg);
		}
		
		if("1".equals(user.getIsLocked())){
			msg = MsgModel.buildError("用户已锁定");
			return GsonUtil.toJsonForObject(msg);
		}
		
		msg = MsgModel.buildSuccess(user);
		return GsonUtil.toJsonForObject(msg);
	}
	
	
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	
	
	
}
