package priv.guochun.psmc.website.backstage.common.impl;

import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.authentication.login.service.LoginService;
import priv.guochun.psmc.system.common.vcode.service.VerificationCodeService;
import priv.guochun.psmc.system.enums.VerificationCodeTypeEnum;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.util.GsonUtil;
import priv.guochun.psmc.website.backstage.common.ChjghWeChatService;


public class ChjghWeChatServiceImpl implements ChjghWeChatService {

	private LoginService loginService;
	
	private VerificationCodeService verificationCodeService;
	
	@Override
	public String login(String phone, String code) {
		MsgModel msg = null;
		// TODO 验证码校验
		msg = verificationCodeService.validateCode(code, VerificationCodeTypeEnum.VCODE_LOGIN.getValue());
		if(!msg.isSuccess()){
			return GsonUtil.toJsonForObject(msg);
		}
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


	public VerificationCodeService getVerificationCodeService() {
		return verificationCodeService;
	}


	public void setVerificationCodeService(
			VerificationCodeService verificationCodeService) {
		this.verificationCodeService = verificationCodeService;
	}

	
	
	
}
