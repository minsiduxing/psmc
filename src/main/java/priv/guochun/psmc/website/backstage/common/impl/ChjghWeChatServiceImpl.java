package priv.guochun.psmc.website.backstage.common.impl;


import java.util.Map;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;

import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.authentication.login.service.LoginService;
import priv.guochun.psmc.system.common.vcode.service.VerificationCodeService;
import priv.guochun.psmc.system.enums.VerificationCodeTypeEnum;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.framework.util.GsonUtil;
import priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService;
import priv.guochun.psmc.website.backstage.common.ChjghWeChatService;
import priv.guochun.psmc.website.backstage.excellentInnovation.service.ExcellentInnovationService;
import priv.guochun.psmc.website.backstage.pageView.model.TabPageView;
import priv.guochun.psmc.website.backstage.pageView.service.TabPageViewService;


public class ChjghWeChatServiceImpl implements ChjghWeChatService {

	private LoginService loginService;
	
	private VerificationCodeService verificationCodeService;
	
	private ExcellentInnovationService excellentInnovationService;
	
	@Autowired
	private InfoReleaseService infoReleaseService;
	
	@Autowired
	private TabPageViewService tabPageViewService;

	@Resource  
	private WebServiceContext context;  
	
	@Override
	public String createVcode(int type) {
//		 MessageContext ctx = (MessageContext) context.getMessageContext();  
//         HttpServletRequest request = (HttpServletRequest) ctx  
//                 .get(AbstractHTTPDestination.HTTP_REQUEST);  
//         String ip = request.getRemoteAddr();  
		String ip ="127.0.0.1";
         String code = verificationCodeService.createCode(type, ip);
         return GsonUtil.toJsonForObject(MsgModel.buildDefaultSuccess(code));
	}

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
			msg = MsgModel.buildDefaultError("用户不存在");
			return GsonUtil.toJsonForObject(msg);
		}
		
		if("1".equals(user.getIsLocked())){
			msg = MsgModel.buildDefaultError("用户已锁定");
			return GsonUtil.toJsonForObject(msg);
		}
		
		msg = MsgModel.buildDefaultSuccess(user);
		return GsonUtil.toJsonForObject(msg);
	}
	
	@Override
	public String getInfoList(String infoType, String queryParameter, MyPage page) {
		page = infoReleaseService.getInfoListToMobile(infoType, queryParameter, page);
		MsgModel msg = MsgModel.buildDefaultSuccess(page);
		return GsonUtil.toJsonForObject(msg); 
	}


	@Override
	public String getDetailInfo(String uuid) {
		Map<String, Object> dataMap = infoReleaseService.getInfoDetailToMobile(uuid);
		tabPageViewService.saveOrUpdate(uuid);//保存或修改浏览量
		TabPageView pageView = tabPageViewService.queryPageviewByUuid(uuid);//获取浏览量
		dataMap.put("nums", pageView.getNums());
		MsgModel msg = MsgModel.buildDefaultSuccess(dataMap);
		return GsonUtil.toJsonForObject(msg); 
	}


	@Override
	public String getInnovationList(String queryParameter, MyPage page) {
		page = excellentInnovationService.getInnovationListToMobile(queryParameter, page);
		MsgModel msg = MsgModel.buildDefaultSuccess(page);
		return GsonUtil.toJsonForObject(msg); 
	}


	@Override
	public String getDetailInnovation(String innovationUuid) {
		Map<String, Object> dataMap = excellentInnovationService.getInnovationDetailToMobile(innovationUuid);
		tabPageViewService.saveOrUpdate(innovationUuid);
		TabPageView pageView = tabPageViewService.queryPageviewByUuid(innovationUuid);
		dataMap.put("nums", pageView.getNums());
		MsgModel msg = MsgModel.buildDefaultSuccess(dataMap);
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

	public WebServiceContext getContext() {
		return context;
	}


	public void setContext(WebServiceContext context) {
		this.context = context;
	}

}
