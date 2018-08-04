package priv.guochun.psmc.website.backstage.common.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;

import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.authentication.login.service.LoginService;
import priv.guochun.psmc.authentication.user.model.TabAccount;
import priv.guochun.psmc.authentication.user.model.TabPerson;
import priv.guochun.psmc.authentication.user.service.TabAccountService;
import priv.guochun.psmc.authentication.user.service.TabPersonService;
import priv.guochun.psmc.system.common.vcode.model.TabVerificationCode;
import priv.guochun.psmc.system.common.vcode.service.VerificationCodeService;
import priv.guochun.psmc.system.enums.AccountLockEnum;
import priv.guochun.psmc.system.enums.AccountTypeEnum;
import priv.guochun.psmc.system.enums.VerificationCodeTypeEnum;
import priv.guochun.psmc.system.exception.PsmcBuisnessException;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.framework.sms.model.SmsModel;
import priv.guochun.psmc.system.framework.sms.service.MobileSmsSendService;
import priv.guochun.psmc.system.framework.upload.service.UploadAssemblyInterface;
import priv.guochun.psmc.system.framework.util.GsonUtil;
import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.SystemPropertiesUtil;
import priv.guochun.psmc.system.util.TimestampUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService;
import priv.guochun.psmc.website.backstage.activity.service.TabActivityManageService;
import priv.guochun.psmc.website.backstage.attachment.service.TabAttachmentService;
import priv.guochun.psmc.website.backstage.common.ChjghWeChatService;
import priv.guochun.psmc.website.backstage.dept.service.TabDeptService;
import priv.guochun.psmc.website.backstage.excellentInnovation.service.ExcellentInnovationService;
import priv.guochun.psmc.website.backstage.pageView.model.TabPageView;
import priv.guochun.psmc.website.backstage.pageView.service.TabPageViewService;
import priv.guochun.psmc.website.backstage.report.model.TabReport;
import priv.guochun.psmc.website.backstage.report.service.ReportService;
import priv.guochun.psmc.website.backstage.topics.model.TabComment;
import priv.guochun.psmc.website.backstage.topics.model.TabTopics;
import priv.guochun.psmc.website.backstage.topics.service.TabCommentService;
import priv.guochun.psmc.website.backstage.topics.service.TabTopicsService;
import priv.guochun.psmc.website.backstage.util.ChjghContants;
import priv.guochun.psmc.website.enums.ModuleEnum;



public class ChjghWeChatServiceImpl implements ChjghWeChatService {
	
	protected static final  Logger logger  = LoggerFactory.getLogger(ChjghWeChatServiceImpl.class);

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
	
	private TabDeptService tabDeptService;

	@Autowired
	TabPersonService tabPersonService;

	private TabTopicsService tabTopicsService;
	private TabCommentService tabCommentService;
	private UploadAssemblyInterface uploadAssemblyInterface;
	private TabAttachmentService tabAttachmentService;
	
	public TabAttachmentService getTabAttachmentService() {
		return tabAttachmentService;
	}

	public void setTabAttachmentService(TabAttachmentService tabAttachmentService) {
		this.tabAttachmentService = tabAttachmentService;
	}


	@Override
	public String createVcode(int type,String phone) {
		 
		if((type != VerificationCodeTypeEnum.VCODE_LOGIN.getValue().intValue()
				&& type != VerificationCodeTypeEnum.VCODE_REGISTER.getValue().intValue())
			 	|| StringUtils.isBlank(phone)){
			 return GsonUtil.toJsonForObject(MsgModel.buildDefaultError("非法参数!"));
		 }
		 
		 if(type == VerificationCodeTypeEnum.VCODE_LOGIN.getValue().intValue()){
			 	//如果是登录，需要验证该手机号为注册用户
			 User user = loginService.buildUserByPhone(phone,AccountTypeEnum.WECHAT_USER.getValue().intValue());
			 if(user == null){
				 return GsonUtil.toJsonForObject(MsgModel.buildDefaultError("该手机号未注册,请先进行注册!"));
			 }
		 }
		 
         TabVerificationCode verificationCode = verificationCodeService.createCode(type, phone);
         String code =  verificationCode.getCode();
         
         SmsModel sm = new SmsModel();
         sm.setCreateTime(TimestampUtil.createCurTimestamp());
         sm.setReceiveContext("{\"code\":\""+code+"\"}");
         sm.setReceiveNo(phone);
         MsgModel mm = chjghMobileSmsSendService.sendSms(sm);
         if(mm.isSuccess()){
        	Properties pp = SystemPropertiesUtil.getProps();
        	//短信是否开启
     		boolean sms_enable =Boolean.parseBoolean(pp.getProperty("sms_enable"));
     		if(sms_enable)
     			return GsonUtil.toJsonForObject(MsgModel.buildDefaultSuccess());
     		else
     			return GsonUtil.toJsonForObject(MsgModel.buildDefaultSuccess(code));
         }else{
        	 logger.warn("获取验证码短信发送失败 "+GsonUtil.toJsonForObject(mm));
        	 verificationCodeService.deleteCode(verificationCode.getUuid());
        	 return GsonUtil.toJsonForObject(mm);
         }
        	 
	}

	@Override
	public String login(String phone, String code) {
		if(StringUtils.isBlank(phone) || StringUtils.isBlank(code)){
			 return GsonUtil.toJsonForObject(MsgModel.buildDefaultError("非法参数!"));
		}
		
		MsgModel msg = null;
		//这里校验不会改变验证码状态
		msg = verificationCodeService.validateCode(code, VerificationCodeTypeEnum.VCODE_LOGIN.getValue(),null);
		if(!msg.isSuccess()){
			return GsonUtil.toJsonForObject(msg);
		}
		//用户校验
		User user = loginService.buildUserByPhone(phone,AccountTypeEnum.WECHAT_USER.getValue().intValue());
		if(user == null){
			msg = MsgModel.buildDefaultError("用户不存在");
			return GsonUtil.toJsonForObject(msg);
		}
		
		if(String.valueOf(AccountLockEnum.LOCKED.getValue().intValue()).equals(user.getIsLocked())){
			msg = MsgModel.buildDefaultError("用户已锁定");
			return GsonUtil.toJsonForObject(msg);
		}
		
		msg = MsgModel.buildDefaultSuccess(user);
		if(msg.isSuccess()){
			//这里校验会改变验证码状态
			verificationCodeService.validateCode(code, VerificationCodeTypeEnum.VCODE_LOGIN.getValue());
		}
		return GsonUtil.toJsonForObject(msg);
	}
	
	@Override
	public String register(String name,String phone,String code){
		if(StringUtils.isBlank(name) || StringUtils.isBlank(code) || StringUtils.isBlank(code)){
			 return GsonUtil.toJsonForObject(MsgModel.buildDefaultError("非法参数!"));
		}
		MsgModel msg = null;
		//这里校验不会改变验证码状态
		msg = verificationCodeService.validateCode(code, VerificationCodeTypeEnum.VCODE_REGISTER.getValue(),null);
		if(!msg.isSuccess()){
			return GsonUtil.toJsonForObject(msg);
		}
		
		User user = loginService.buildUserByPhone(phone,AccountTypeEnum.WECHAT_USER.getValue().intValue());
		if(user != null){
			verificationCodeService.validateCode(code, VerificationCodeTypeEnum.VCODE_REGISTER.getValue());
			msg = MsgModel.buildDefaultError("该手机号已被注册!");
			return GsonUtil.toJsonForObject(msg);
		}
		
		TabAccount account = new TabAccount();
		String accUuid = UUIDGenerator.createUUID();
		String personUuid = UUIDGenerator.createUUID();
		account.setUuid(accUuid);
		account.setAccountName(phone);
		account.setAccountPass(ChjghContants.WECHAT_PW);
		account.setIsLocked(String.valueOf(AccountLockEnum.NO_LOCKED.getValue().intValue()));
		account.setAccountType(AccountTypeEnum.WECHAT_USER.getValue().intValue());
		
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
			user = loginService.buildUserByPhone(phone,AccountTypeEnum.WECHAT_USER.getValue().intValue());
			msg = MsgModel.buildDefaultSuccess("用户注册成功!",user);
			verificationCodeService.validateCode(code, VerificationCodeTypeEnum.VCODE_REGISTER.getValue());
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
									 String queryParameter,
									 String reportType,
									 String reportUserUuid){
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
		myPagep.setPageSize(Integer.parseInt(pageSize));
		myPagep.setPageIndex(Integer.parseInt(pageIndex));
		myPagep = reportService.findReportPageToMobile(myPagep,queryParameter,reportType,reportUserUuid);
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
		String addUserID = report.getReportUserUuid();
		if(StringUtils.isBlank(addUserID)){ return GsonUtil.toJsonForObject( MsgModel.buildDefaultError("申报人不存在"));}
		Map tempWebUser = tabPersonService.getTabPersonById(addUserID);
		if(null == tempWebUser || tempWebUser.isEmpty()){
			return GsonUtil.toJsonForObject( MsgModel.buildDefaultError("申报人不存在"));
		}
		reportService.saveOrUpdateReportToMobile(report);
		return GsonUtil.toJsonForObject( MsgModel.buildDefaultSuccess("add success"));
	}
	
	@Override
	public String getDeptList(String pageJson) {
		MyPage page = JSON.parseObject(pageJson, MyPage.class) ;
		Map<String, Object> paramMap = page.getQueryParams();
		if(paramMap == null){
			paramMap = new HashMap<String, Object>();
		}
		//审核通过已发布的信息
		paramMap.put("audit", ModuleEnum.AUDITED_PASS.getValue());
		paramMap.put("releaseStatus", ModuleEnum.IS_RELEASEED.getValue());
		page.setQueryParams(paramMap); 
		MsgModel msg = null;
		try {
			page = tabDeptService.queryDeptListToMobile(page);
			msg = MsgModel.buildDefaultSuccess("获取数据成功", page);
		} catch (Exception e) {
			msg = MsgModel.buildDefaultError("获取数据异常");
		}
		return GsonUtil.toJsonForObject(msg); 
	}
	
	@Override
	public String deptDetail(String deptUuid) {
		MsgModel msg = null;
		try {
			Map<String, Object> dataMap = tabDeptService.getDeptDetailToMobile(deptUuid);
			msg = MsgModel.buildDefaultSuccess("获取数据成功", dataMap);
		} catch (Exception e) {
			msg = MsgModel.buildDefaultError("获取数据异常");
		}
		return GsonUtil.toJsonForObject(msg); 
	}
	
	public String addTopics(TabTopics tabTopics){
		MsgModel msg = null;
		try {
			tabTopicsService.saveOrUpdateToMobile(tabTopics);
			msg = MsgModel.buildDefaultSuccess("保存成功", null);
		} catch (Exception e) {
			msg = MsgModel.buildDefaultError("操作异常");
		}
		return GsonUtil.toJsonForObject(msg); 
	}
	
	public String queryTopicsList(String pageJson){
		MsgModel msg = null;
		try {
			MyPage page = JSON.parseObject(pageJson, MyPage.class) ;
			page = tabTopicsService.queryTopicListToMobile(page);
			msg = MsgModel.buildDefaultSuccess("获取数据成功", page);
		} catch (Exception e) {
			msg = MsgModel.buildDefaultError("获取数据异常");
		}
		return GsonUtil.toJsonForObject(msg);
	}
	
	public String topicsDetail(String pageJson){
		MsgModel msg = null;
		try {
			MyPage myPage = JSON.parseObject(pageJson, MyPage.class) ;
			Map<String, Object> paramMap = myPage.getQueryParams();
			if(paramMap != null && paramMap.get("topicUuid") != null){
				Map<String, Object> dataMap = new HashMap<String, Object>();
				//更新浏览量
				tabPageViewService.saveOrUpdate(paramMap.get("topicUuid").toString());
				//主题信息详情
				Map<String, Object> topicMap = tabTopicsService.queryTopicsToMobile(paramMap.get("topicUuid").toString());
				//附件信息
				List<Map<String, Object>> attachmentList = tabAttachmentService.queryAttachmentList(paramMap.get("topicUuid").toString());
				//评论信息列表
				myPage = tabCommentService.queryCommentListToMobile(myPage);
				dataMap.put("topicMap", topicMap);
				dataMap.put("attachmentList", attachmentList);
				dataMap.put("myPage", myPage);
				msg = MsgModel.buildDefaultSuccess("获取数据成功", dataMap);
			}else{
				msg = MsgModel.buildDefaultError("查询参数为空");
			}
			
		} catch (Exception e) {
			msg = MsgModel.buildDefaultError("获取数据异常");
		}
		return GsonUtil.toJsonForObject(msg); 
	}
	
	public String addTabComment(TabComment tabComment){
		MsgModel msg = null;
		try {
			tabCommentService.saveOrUpdateToMobile(tabComment);
			msg = MsgModel.buildDefaultSuccess("保存成功", null);
		} catch (Exception e) {
			msg = MsgModel.buildDefaultError("操作异常");
		}
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

	public TabDeptService getTabDeptService() {
		return tabDeptService;
	}

	public void setTabDeptService(TabDeptService tabDeptService) {
		this.tabDeptService = tabDeptService;
	}

	public TabTopicsService getTabTopicsService() {
		return tabTopicsService;
	}

	public void setTabTopicsService(TabTopicsService tabTopicsService) {
		this.tabTopicsService = tabTopicsService;
	}

	public TabCommentService getTabCommentService() {
		return tabCommentService;
	}

	public void setTabCommentService(TabCommentService tabCommentService) {
		this.tabCommentService = tabCommentService;
	}

	public UploadAssemblyInterface getUploadAssemblyInterface() {
		return uploadAssemblyInterface;
	}

	public void setUploadAssemblyInterface(UploadAssemblyInterface uploadAssemblyInterface) {
		this.uploadAssemblyInterface = uploadAssemblyInterface;
	}
	
}
