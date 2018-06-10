package priv.guochun.psmc.website.backstage.common.impl;


import java.util.Map;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;

import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.authentication.login.service.LoginService;
import priv.guochun.psmc.authentication.user.model.TabAccount;
import priv.guochun.psmc.authentication.user.model.TabPerson;
import priv.guochun.psmc.authentication.user.service.TabAccountService;
import priv.guochun.psmc.system.common.vcode.service.VerificationCodeService;
import priv.guochun.psmc.system.enums.VerificationCodeTypeEnum;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.framework.sms.model.SmsModel;
import priv.guochun.psmc.system.framework.sms.service.MobileSmsSendService;
import priv.guochun.psmc.system.framework.util.GsonUtil;
import priv.guochun.psmc.system.util.TimestampUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService;
import priv.guochun.psmc.website.backstage.common.ChjghWeChatService;
import priv.guochun.psmc.website.backstage.excellentInnovation.service.ExcellentInnovationService;
import priv.guochun.psmc.website.backstage.pageView.model.TabPageView;
import priv.guochun.psmc.website.backstage.pageView.service.TabPageViewService;
import priv.guochun.psmc.website.backstage.util.ChjghContants;


public class ChjghWeChatServiceImpl implements ChjghWeChatService {

	private LoginService loginService;
	
	private VerificationCodeService verificationCodeService;
	
	private ExcellentInnovationService excellentInnovationService;
	
	@Autowired
	private MobileSmsSendService chjghMobileSmsSendService;
	
	@Autowired
	private InfoReleaseService infoReleaseService;
	
	@Autowired
	private TabPageViewService tabPageViewService;

	@Resource  
	private WebServiceContext context;  
	
	@Autowired
	private TabAccountService tabAccountService;
	
	@Override
	public String createVcode(int type,String phone) {
//		 MessageContext ctx = (MessageContext) context.getMessageContext();  
//         HttpServletRequest request = (HttpServletRequest) ctx  
//                 .get(AbstractHTTPDestination.HTTP_REQUEST);  
         
         String ip = "localhost";
         String code = verificationCodeService.createCode(type, ip);
         
         SmsModel sm = new SmsModel();
         sm.setCreateTime(TimestampUtil.createCurTimestamp());
         sm.setReceiveContext("{\"code\":\""+code+"\"}");
         sm.setReceiveNo(phone);
         MsgModel mm = chjghMobileSmsSendService.sendSms(sm);
         if(mm.isSuccess())
        	 return GsonUtil.toJsonForObject(MsgModel.buildDefaultSuccess(code));
         else
        	 return GsonUtil.toJsonForObject(mm);
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
	public String register(String name,String phone,String code){
		MsgModel msg = null;
		// TODO 验证码校验
		msg = verificationCodeService.validateCode(code, VerificationCodeTypeEnum.VCODE_REGISTER.getValue());
		if(!msg.isSuccess()){
			return GsonUtil.toJsonForObject(msg);
		}
		
		User user = loginService.buildUserByPhone(phone);
		if(user != null){
			msg = MsgModel.buildDefaultError("该手机号已被注册!");
			return GsonUtil.toJsonForObject(msg);
		}
		
		TabAccount account = new TabAccount();
		String accUuid = UUIDGenerator.createUUID();
		String personUuid = UUIDGenerator.createUUID();
		account.setUuid(accUuid);
		account.setAccountName(phone);
		account.setAccountPass(ChjghContants.WECHAT_PW);
		account.setIsLocked("2");
		
		TabPerson person = new TabPerson();
		person.setUuid(personUuid);
		person.setAccUuid(accUuid);
		person.setTelephone(phone);
		person.setCityId("00");
		person.setGroupid(ChjghContants.WECHAT_GROUP_CODE);
		person.setPersonName(name);
		person.setSex(3);
		
		boolean flag = tabAccountService.register(account, person, ChjghContants.WECHAT_ROLE_ID);
		if(flag){
			user = loginService.buildUserByPhone(phone);
			msg = MsgModel.buildDefaultSuccess("用户注册成功!",user);
			return GsonUtil.toJsonForObject(msg);
		}else{
			msg = MsgModel.buildDefaultError("用户注册失败,请联系管理员!");
			return GsonUtil.toJsonForObject(msg);
		}
			
		
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

	
	public ExcellentInnovationService getExcellentInnovationService() {
		return excellentInnovationService;
	}

	public void setExcellentInnovationService(
			ExcellentInnovationService excellentInnovationService) {
		this.excellentInnovationService = excellentInnovationService;
	}

	public MobileSmsSendService getChjghMobileSmsSendService() {
		return chjghMobileSmsSendService;
	}

	public void setChjghMobileSmsSendService(
			MobileSmsSendService chjghMobileSmsSendService) {
		this.chjghMobileSmsSendService = chjghMobileSmsSendService;
	}

	public InfoReleaseService getInfoReleaseService() {
		return infoReleaseService;
	}

	public void setInfoReleaseService(InfoReleaseService infoReleaseService) {
		this.infoReleaseService = infoReleaseService;
	}

	public TabPageViewService getTabPageViewService() {
		return tabPageViewService;
	}

	public void setTabPageViewService(TabPageViewService tabPageViewService) {
		this.tabPageViewService = tabPageViewService;
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

	public TabAccountService getTabAccountService() {
		return tabAccountService;
	}

	public void setTabAccountService(TabAccountService tabAccountService) {
		this.tabAccountService = tabAccountService;
	}
	
}
