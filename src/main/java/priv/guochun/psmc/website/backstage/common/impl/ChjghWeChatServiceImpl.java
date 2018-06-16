package priv.guochun.psmc.website.backstage.common.impl;


import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.authentication.login.service.LoginService;
import priv.guochun.psmc.authentication.user.model.TabAccount;
import priv.guochun.psmc.authentication.user.model.TabPerson;
import priv.guochun.psmc.authentication.user.service.TabAccountService;
import priv.guochun.psmc.system.common.vcode.service.VerificationCodeService;
import priv.guochun.psmc.system.enums.VerificationCodeTypeEnum;
import priv.guochun.psmc.system.exception.PsmcBuisnessException;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.framework.sms.model.SmsModel;
import priv.guochun.psmc.system.framework.sms.service.MobileSmsSendService;
import priv.guochun.psmc.system.framework.util.GsonUtil;
import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.TimestampUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService;
import priv.guochun.psmc.website.backstage.activity.service.TabActivityManageService;
import priv.guochun.psmc.website.backstage.common.ChjghWeChatService;
import priv.guochun.psmc.website.backstage.excellentInnovation.service.ExcellentInnovationService;
import priv.guochun.psmc.website.backstage.pageView.model.TabPageView;
import priv.guochun.psmc.website.backstage.pageView.service.TabPageViewService;
import priv.guochun.psmc.website.backstage.report.model.TabReport;
import priv.guochun.psmc.website.backstage.report.service.ReportService;
import priv.guochun.psmc.website.backstage.util.ChjghContants;
import priv.guochun.psmc.website.enums.ModuleEnum;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;



public class ChjghWeChatServiceImpl implements ChjghWeChatService {

	private LoginService loginService;
	
	private VerificationCodeService verificationCodeService;
	
	
	private ExcellentInnovationService excellentInnovationService;
	
	
	private MobileSmsSendService chjghMobileSmsSendService;
	
	
	private InfoReleaseService infoReleaseService;
	
	
	private TabPageViewService tabPageViewService;
	
	private TabActivityManageService tabActivityManageService;

	@Resource  
	private WebServiceContext context;  
	
	private TabAccountService tabAccountService;

	@Autowired
	private ReportService reportService;
	
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
	public String getInfoList(String pageJson) {
		MyPage page = JSON.parseObject(pageJson, MyPage.class) ;
		Map<String, Object> paramMap = page.getQueryParams();
		if(paramMap == null){
			paramMap = new HashMap<String, Object>();
		}
		//审核通过已发布的信息
		paramMap.put("audit", ModuleEnum.AUDITED_PASS.getValue());
		paramMap.put("releaseStatus", ModuleEnum.IS_RELEASEED.getValue());
		//paramMap.put("oneLevelClassify", infoType);
		//移动端只查询未过期的信息
		paramMap.put("publishExpireDateBegin", DateUtil.getCurrentTimstamp());
		page.setQueryParams(paramMap);
		MsgModel msg = null;
		try {
			page = infoReleaseService.queryInfoListToMobile(page);
			msg = MsgModel.buildDefaultSuccess(page);
		} catch (Exception e) {
			msg = MsgModel.buildDefaultError("获取数据异常");
		}
		return GsonUtil.toJsonForObject(msg); 
	}


	@Override
	public String infoDetail(String uuid) {
		MsgModel msg = null;
		try {
			Map<String, Object> dataMap = infoReleaseService.getInfoDetailToMobile(uuid);
			int nums = 0;
			TabPageView pageView = tabPageViewService.queryPageviewByUuid(uuid);//获取浏览量
			if(pageView != null){
				nums = pageView.getNums();
			}
			//更新浏览次数
			tabPageViewService.saveOrUpdate(uuid);
			dataMap.put("nums", nums);
			msg = MsgModel.buildDefaultSuccess(dataMap);
		} catch (Exception e) {
			msg = MsgModel.buildDefaultError("获取数据异常");
		}
		return GsonUtil.toJsonForObject(msg); 
	}


	@Override
	public String getInnovationList(String pageJson) {
		MyPage page = JSON.parseObject(pageJson, MyPage.class) ;
		Map<String, Object> paramMap = page.getQueryParams();
		if(paramMap == null){
			paramMap = new HashMap<String, Object>();
		}
		//审核通过已发布的信息
		paramMap.put("audit", ModuleEnum.AUDITED_PASS.getValue());
		paramMap.put("releaseStatus", ModuleEnum.IS_RELEASEED.getValue());
		//移动端只查询未过期的信息
		paramMap.put("publishExpireDateBegin", DateUtil.getCurrentTimstamp());
		page.setQueryParams(paramMap); 
		MsgModel msg = null;
		try {
			page = excellentInnovationService.queryInnovationListToMobile(page);
			msg = MsgModel.buildDefaultSuccess(page);
		} catch (Exception e) {
			msg = MsgModel.buildDefaultError("获取数据异常");
		}
		return GsonUtil.toJsonForObject(msg); 
	}


	@Override
	public String innovationDetail(String innovationUuid) {
		MsgModel msg = null;
		try {
			Map<String, Object> dataMap = excellentInnovationService.getInnovationDetailToMobile(innovationUuid);
			int nums = 0;
			TabPageView pageView = tabPageViewService.queryPageviewByUuid(innovationUuid);//获取浏览量
			if(pageView != null){
				nums = pageView.getNums();
			}
			//更新浏览次数
			tabPageViewService.saveOrUpdate(innovationUuid);
			dataMap.put("nums", nums);
			msg = MsgModel.buildDefaultSuccess(dataMap);
		} catch (Exception e) {
			msg = MsgModel.buildDefaultError("获取数据异常");
		}
		return GsonUtil.toJsonForObject(msg); 
	}

	@Override
	public String getActivityList(String pageJson){
		MyPage page = JSON.parseObject(pageJson, MyPage.class) ;
		Map<String, Object> paramMap = page.getQueryParams();
		if(paramMap == null){
			paramMap = new HashMap<String, Object>();
		}
		//审核通过已发布的活动信息
		paramMap.put("audit", ModuleEnum.AUDITED_PASS.getValue());
		paramMap.put("releaseStatus", ModuleEnum.IS_RELEASEED.getValue());
		//移动端只查询未过期的活动信息
		paramMap.put("publishExpireDateBegin", DateUtil.getCurrentTimstamp());
		page.setQueryParams(paramMap);
		MsgModel msg = null;
		try {
			page = tabActivityManageService.queryActivityList(page);
			msg = MsgModel.buildDefaultSuccess(page);
		} catch (Exception e) {
			msg = MsgModel.buildDefaultError("获取数据异常");
		}
		return GsonUtil.toJsonForObject(msg);
	}
	
	@Override
	public String activityDetail(String activityUuid, String phone){
		MsgModel msg = null;
		try {
			Map<String, Object> dataMap = tabActivityManageService.getActivityByUuid(activityUuid);
			int nums = 0;
			boolean isSignUp = false;
			//获取浏览量
			TabPageView pageView = tabPageViewService.queryPageviewByUuid(activityUuid);
			if(pageView != null){
				nums = pageView.getNums();
			}
			//更新浏览量
			tabPageViewService.saveOrUpdate(activityUuid);
			//判断当前用户是否已经报名
			Map<String, Object> signUp = tabActivityManageService.getSignUpByActivityIdAndAccout(activityUuid, phone);
			if(signUp != null && signUp.size() > 0){
				isSignUp = true;
			}
			dataMap.put("isSignUp", isSignUp);
			dataMap.put("nums", nums);
			msg = MsgModel.buildDefaultSuccess(dataMap);
		} catch (Exception e) {
			msg = MsgModel.buildDefaultError("获取数据异常");
		}
		return GsonUtil.toJsonForObject(msg);
	}
	
	@Override
	public String signUp(String activityUuid, String phone){
		MsgModel msg = null;
		try {
			tabActivityManageService.addSignUpInfo(activityUuid, phone);
			msg = MsgModel.buildDefaultSuccess("报名成功", null);
		} catch (PsmcBuisnessException e) {
			msg = MsgModel.buildDefaultError(e.getMessage());
		}
		return GsonUtil.toJsonForObject(msg);
	}
	
	@Override
	public String cancelSignUp(String activityUuid, String phone){
		MsgModel msg = null;
		try {
			tabActivityManageService.deleteSignInfo(activityUuid, phone);
			msg = MsgModel.buildDefaultSuccess("取消报名成功", null);
		} catch (Exception e) {
			msg = MsgModel.buildDefaultError("操作失败");
		}
		return GsonUtil.toJsonForObject(msg);
	}
	
	@Override
	public String getSignUpList(String activityUuid){
		MsgModel msg = null;
		try {
			List<Map<String, Object>> signUpList = tabActivityManageService.querySignUpInfoList(activityUuid);
			msg = MsgModel.buildDefaultSuccess(signUpList);
		} catch (Exception e) {
			msg = MsgModel.buildDefaultError("获取数据异常");
		}
		return GsonUtil.toJsonForObject(msg);
	}
	@Override
	public String getReportListInfo( String pageSize,
									 String pageIndex,
									 String queryParameter){
		MyPage myPagep = new MyPage();
		if(StringUtils.isBlank(pageSize)||StringUtils.isBlank(pageIndex)){
			MsgModel msg = MsgModel.buildDefaultError("page prams is null ");
			return  GsonUtil.toJsonForObject(msg);
		}
		Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
		if(!pattern.matcher(pageSize).matches() || !pattern.matcher(pageIndex).matches()){
			MsgModel msg = MsgModel.buildDefaultError("the pageIndex Or pageSize  is null ");
			return  GsonUtil.toJsonForObject(msg);
		}
		myPagep = reportService.findReportPageToMobile(myPagep,queryParameter);
		MsgModel msg = MsgModel.buildDefaultSuccess(myPagep);
		return  GsonUtil.toJsonForObject(msg);
	}

	@Override
	public String getReportInfoDetail(String reportUUid) {
		if(StringUtils.isBlank(reportUUid)){
			MsgModel msg = MsgModel.buildDefaultError("reportUUid is null ");
			return  GsonUtil.toJsonForObject(msg);
		}
		Map<String, Object> result = reportService.getReportDetailToMobile(reportUUid);
		if(null==result || result.isEmpty()){
			MsgModel msg = MsgModel.buildDefaultError("error the report not exits ");
			return  GsonUtil.toJsonForObject(msg);
		}
		MsgModel msg = MsgModel.buildDefaultSuccess(result);
		return  GsonUtil.toJsonForObject(msg);
	}

	@Override
	public String addReport(TabReport report) {
		if(null == report){
			MsgModel msg = MsgModel.buildDefaultError("error add report is null  ");
			return  GsonUtil.toJsonForObject(msg);
		}
		reportService.saveOrUpdateReportToMobile(report);
		return GsonUtil.toJsonForObject( MsgModel.buildDefaultSuccess("add success"));
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

	/**
	 * @return the tabActivityManageService
	 */
	public TabActivityManageService getTabActivityManageService() {
		return tabActivityManageService;
	}

	/**
	 * @param tabActivityManageService the tabActivityManageService to set
	 */
	public void setTabActivityManageService(TabActivityManageService tabActivityManageService) {
		this.tabActivityManageService = tabActivityManageService;
	}
	
}
