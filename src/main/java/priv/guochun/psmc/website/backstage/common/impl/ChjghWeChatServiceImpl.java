package priv.guochun.psmc.website.backstage.common.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.authentication.login.service.LoginService;
import priv.guochun.psmc.authentication.user.model.TabAccount;
import priv.guochun.psmc.authentication.user.model.TabPerson;
import priv.guochun.psmc.authentication.user.service.TabAccountService;
import priv.guochun.psmc.authentication.user.service.TabPersonService;
import priv.guochun.psmc.system.common.dict.service.TabDataDictService;
import priv.guochun.psmc.system.common.explain.model.TabFunctionExplain;
import priv.guochun.psmc.system.common.explain.service.TabFunctionExplainService;
import priv.guochun.psmc.system.common.vcode.model.TabVerificationCode;
import priv.guochun.psmc.system.common.vcode.service.VerificationCodeService;
import priv.guochun.psmc.system.enums.AccountLockEnum;
import priv.guochun.psmc.system.enums.AccountTypeEnum;
import priv.guochun.psmc.system.enums.IfEnum;
import priv.guochun.psmc.system.enums.VerificationCodeTypeEnum;
import priv.guochun.psmc.system.exception.PsmcBuisnessException;
import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.framework.sms.model.SmsModel;
import priv.guochun.psmc.system.framework.sms.service.MobileSmsSendService;
import priv.guochun.psmc.system.framework.sms.util.SmsTypeEnum;
import priv.guochun.psmc.system.framework.upload.service.UploadAssemblyInterface;
import priv.guochun.psmc.system.framework.util.GsonUtil;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;
import priv.guochun.psmc.system.util.*;
import priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService;
import priv.guochun.psmc.website.backstage.activity.service.TabActivityManageService;
import priv.guochun.psmc.website.backstage.attachment.service.TabAttachmentService;
import priv.guochun.psmc.website.backstage.common.ChjghWeChatService;
import priv.guochun.psmc.website.backstage.common.realNameAuth.RealNameAuthService;
import priv.guochun.psmc.website.backstage.dept.service.TabDeptService;
import priv.guochun.psmc.website.backstage.excellentInnovation.service.ExcellentInnovationService;
import priv.guochun.psmc.website.backstage.laud.service.TabLaudService;
import priv.guochun.psmc.website.backstage.pageView.model.TabPageView;
import priv.guochun.psmc.website.backstage.pageView.service.TabPageViewService;
import priv.guochun.psmc.website.backstage.report.model.TabReport;
import priv.guochun.psmc.website.backstage.report.service.ReportService;
import priv.guochun.psmc.website.backstage.topics.model.TabComment;
import priv.guochun.psmc.website.backstage.topics.model.TabTopics;
import priv.guochun.psmc.website.backstage.topics.service.TabCommentService;
import priv.guochun.psmc.website.backstage.topics.service.TabTopicsService;
import priv.guochun.psmc.website.backstage.util.ChjghContants;
import priv.guochun.psmc.website.backstage.util.IdCardUtil;
import priv.guochun.psmc.website.enums.ModuleEnum;

import javax.annotation.Resource;
import javax.xml.ws.WebServiceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Pattern;



		public class ChjghWeChatServiceImpl implements ChjghWeChatService {

			protected static final  Logger logger  = LoggerFactory.getLogger(ChjghWeChatServiceImpl.class);

			private LoginService loginService;

			private VerificationCodeService verificationCodeService;


			private ExcellentInnovationService excellentInnovationService;


			private MobileSmsSendService baseMobileSmsSendService;


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
			private TabLaudService tabLaudService;
			@Autowired
			private RealNameAuthService realNameAuthService;
			@Autowired
			private TabFunctionExplainService tabFunctionExplainService;

			@Autowired
			private TabDataDictService tabDataDictService;

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

         PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
		 Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
		 Map<String, String> map = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);


         SmsModel sm = new SmsModel();
         sm.setCreateTime(TimestampUtil.createCurTimestamp());
		 sm.setReceiveNo(phone);
		 sm.setSendType(SmsTypeEnum.SmsTypeEnum2.getUuid());
         sm.setReceiveContext("[{\"手机号码\":\""+phone+"\",\"code\":\""+code+"\"}]");
		 sm.setSmsId(SmsTypeEnum.ZY_PLATFORM_SCZGYJ_VERIFICATION_CODE_SMS_ID);

         MsgModel mm = baseMobileSmsSendService.sendSms(sm);
         if(mm.isSuccess()){
        	Properties pp = SystemPropertiesUtil.getProps();
        	//短信是否开启
     		boolean sms_enable =Boolean.valueOf(map.get("sms_enable").toString());
     		if(sms_enable)
     			return GsonUtil.toJsonForObject(MsgModel.buildDefaultSuccess());
     		else
     			return GsonUtil.toJsonForObject(MsgModel.buildDefaultSuccess(code));
         }else{
        	 logger.error("获取验证码短信发送失败 "+GsonUtil.toJsonForObject(mm));
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
	public String register(String name,String phone,String code,String idCard){
		if(StringUtils.isBlank(name) || StringUtils.isBlank(code) || StringUtils.isBlank(code) || StringUtils.isBlank(idCard)){
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
		//校验身份证号的合法性
		if(!IdCardUtil.validateCard(idCard)){
			msg = MsgModel.buildDefaultError("身份证号不合法!");
			return GsonUtil.toJsonForObject(msg);
		}
		//对用户输入的姓名和身份证号进行实名认证
		String result = realNameAuthService.realNameAuth(name, idCard);
		if(StringUtils.isBlank(result)){
			msg = MsgModel.buildDefaultError("实名认证异常,请联系管理员!");
			return GsonUtil.toJsonForObject(msg);
		}
		JSONObject json = JSON.parseObject(result);
		//返回状态码不等于01，则认证失败
		if(!json.getString("status").equals("01")){
			msg = MsgModel.buildDefaultError(json.getString("msg"));
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
		account.setIsAuth(IfEnum.YES.getValue());
		account.setAuthType(IfEnum.YES.getValue());
		
		TabPerson person = new TabPerson();
		person.setUuid(personUuid);
		person.setAccUuid(accUuid);
		person.setTelephone(phone);
		person.setCityId("00");
		person.setGroupid(ChjghContants.WECHAT_GROUP_CODE);
		person.setPersonName(name);
		person.setAddrCode(json.getString("addrCode"));
		person.setArea(json.getString("area"));
		person.setBirthday(json.getString("birthday"));
		person.setCity(json.getString("city"));
		person.setIdCard(json.getString("idCard"));
		person.setPrefecture(json.getString("prefecture"));
		person.setProvince(json.getString("province"));
		person.setAge(IdCardUtil.getAgeByBirthday(json.getString("birthday")));
		if(ModuleEnum.SEX_MAN.getName().equals(json.getString("sex"))){
			person.setSex(Integer.valueOf(ModuleEnum.SEX_MAN.getValue()));
		}else if(ModuleEnum.SEX_WOMAN.getName().equals(json.getString("sex"))){
			person.setSex(Integer.valueOf(ModuleEnum.SEX_WOMAN.getValue()));
		}else{
			person.setSex(Integer.valueOf(ModuleEnum.SEX_OTHER.getValue()));
		}
		
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
		//审核通过 modify 20210623 修改只查询已审核过的就行了。
		paramMap.put("audit", ModuleEnum.AUDITED_PASS.getValue());
//		//已发布
//		paramMap.put("releaseStatus", ModuleEnum.IS_RELEASEED.getValue());
//		//移动端只查询未过期的信息
//		paramMap.put("publishExpireDateBegin", DateUtil.getCurrentTimstamp());

		page.setQueryParams(paramMap);
		MsgModel msg = null;
		try {
			page = infoReleaseService.queryInfoListToMobile(page);
			msg = MsgModel.buildDefaultSuccess(page);
		} catch (Exception e) {
			logger.error("获取数据异常." + e);
			msg = MsgModel.buildDefaultError("获取数据异常");
		}
		return GsonUtil.toJsonForObject(msg); 
	}


	@Override
	public String infoDetail(String uuid,String oneLevelClassify,String towLevelClassify) {
		MyPage page = JSON.parseObject(null, MyPage.class) ;
		if(page == null){
			page = new MyPage();
			page.setPageSize(10);
		}
		Map<String, Object> paramMap = page.getQueryParams();
		if(paramMap == null){
			paramMap = new HashMap<String, Object>();
		}
		//审核通过已发布的信息
		paramMap.put("audit", ModuleEnum.AUDITED_PASS.getValue());
		//paramMap.put("releaseStatus", ModuleEnum.IS_RELEASEED.getValue());
		//移动端只查询未过期的信息
		//paramMap.put("publishExpireDateBegin", DateUtil.getCurrentTimstamp());
		MsgModel msg = null;
		try {
				Map<String, Object> dataMap = null;
				if(StringUtils.isNotBlank(uuid)){
					paramMap.put("uuid", uuid);
					page.setQueryParams(paramMap);
					dataMap = (Map<String, Object>)infoReleaseService.getInfoDetailToMobile(uuid);
				}else{
					if(StringUtils.isNotBlank(oneLevelClassify) && StringUtils.isNotBlank(towLevelClassify)) {
						paramMap.put("oneLevelClassify", oneLevelClassify);
						paramMap.put("towLevelClassify", towLevelClassify);
						page.setQueryParams(paramMap);
						dataMap = (Map<String, Object>)infoReleaseService.getInfoDetailToMobile(paramMap);
					}else
						msg = MsgModel.buildDefaultError("参数不全");
				}
				if(dataMap != null){
					uuid = dataMap.get("uuid").toString();
					int nums = 0;
					TabPageView pageView = tabPageViewService.queryPageviewByUuid(uuid);//获取浏览量
					if(pageView != null){
						nums = pageView.getNums();
					}
					//更新浏览次数
					tabPageViewService.saveOrUpdate(uuid);
					dataMap.put("nums", nums);
					msg = MsgModel.buildDefaultSuccess(dataMap);
				}
		} catch (Exception e) {
			logger.error("获取数据异常." + e);
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
			logger.error("获取数据异常." + e);
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
			logger.error("获取数据异常." + e);
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
			logger.error("获取数据异常." + e);
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
			logger.error("获取数据异常." + e);
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
			logger.error("报名异常." + e);
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
			logger.error("取消报名异常." + e);
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
			logger.error("获取数据异常." + e);
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
	public String getReportInfoDetail(String reportUUid, String personUuid) {
		if(StringUtils.isBlank(reportUUid)){
			MsgModel msg = MsgModel.buildDefaultError("reportUUid is null ");
			return  GsonUtil.toJsonForObject(msg);
		}
		Map<String, Object> result = reportService.getReportDetailToMobile(reportUUid);
		if(null==result || result.isEmpty()){
			MsgModel msg = MsgModel.buildDefaultError("error the report not exits ");
			return  GsonUtil.toJsonForObject(msg);
		}
		if(result.get("reportType").equals("advice")){
			//是否已点赞
			boolean isLaud = tabLaudService.selectIsLaud(reportUUid, personUuid);
			result.put("isLaud", isLaud);
		}
		//留言报修需要查询图片附件
		if(result.get("reportType").equals("repair")) {
			List<Map<String, Object>> attachmentList = tabAttachmentService.queryAttachmentList(reportUUid);
			result.put("attachmentList", attachmentList);
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
			logger.error("获取数据异常." + e);
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
			logger.error("获取数据异常." + e);
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
			logger.error("添加主题异常." + e);
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
			logger.error("获取数据异常." + e);
			msg = MsgModel.buildDefaultError("获取数据异常");
		}
		return GsonUtil.toJsonForObject(msg);
	}
	
	public String topicsDetail(String topicUuid, String personUuid){
		MsgModel msg = null;
		try {
			Map<String, Object> dataMap = new HashMap<String, Object>();
			//更新浏览量
			tabPageViewService.saveOrUpdate(topicUuid);
			//主题信息详情
			Map<String, Object> topicMap = tabTopicsService.queryTopicsToMobile(topicUuid);
			//是否已点赞
			boolean isLaud = tabLaudService.selectIsLaud(topicUuid, personUuid);
			//附件信息
			List<Map<String, Object>> attachmentList = tabAttachmentService.queryAttachmentList(topicUuid);
			dataMap.put("topicMap", topicMap);
			dataMap.put("attachmentList", attachmentList);
			dataMap.put("isLaud", isLaud);
			msg = MsgModel.buildDefaultSuccess("获取数据成功", dataMap);
		} catch (Exception e) {
			logger.error("获取数据异常." + e);
			msg = MsgModel.buildDefaultError("获取数据异常");
		}
		return GsonUtil.toJsonForObject(msg); 
	}
	
	public String commentList(String pageJson){
		MsgModel msg = null;
		try {
			MyPage myPage = JSON.parseObject(pageJson, MyPage.class) ;
			Map<String, Object> paramMap = myPage.getQueryParams();
			if(paramMap != null && paramMap.get("topicUuid") != null){
				//评论信息列表
				myPage = tabCommentService.queryCommentListToMobile(myPage);
				msg = MsgModel.buildDefaultSuccess("获取数据成功", myPage);
			}else{
				msg = MsgModel.buildDefaultError("查询参数为空");
			}
			
		} catch (Exception e) {
			logger.error("获取数据异常." + e);
			msg = MsgModel.buildDefaultError("获取数据异常");
		}
		return GsonUtil.toJsonForObject(msg); 
	}
	
	public String addTabComment(TabComment tabComment){
		MsgModel msg = null;
		try {
			Map<String, Object> topicMap = tabTopicsService.queryTopicsToMobile(tabComment.getTopicUuid());
			if(topicMap != null && ContantsUtil.BLOCK_STATUS_2.equals(topicMap.get("topic_status"))){
				msg = MsgModel.buildDefaultError("该主题已被禁止评论");
				return GsonUtil.toJsonForObject(msg); 
			}
			tabCommentService.saveOrUpdateToMobile(tabComment);
			msg = MsgModel.buildDefaultSuccess("保存成功", null);
		} catch (Exception e) {
			logger.error("添加评论异常." + e);
			msg = MsgModel.buildDefaultError("操作异常");
		}
		return GsonUtil.toJsonForObject(msg); 
	}
	
	public String deleteComment( String commentUuid){
		MsgModel msg = null;
		try {
			tabCommentService.deleteCommentToMobile(commentUuid);
			msg = MsgModel.buildDefaultSuccess("删除成功", null);
		} catch (Exception e) {
			logger.error("删除评论异常." + e);
			msg = MsgModel.buildDefaultError("操作异常");
		}
		return GsonUtil.toJsonForObject(msg); 
	}
	
	@Override
	public String addLaud(String moduleUuid, String personUuid){
		if(StringUtils.isBlank(moduleUuid) || StringUtils.isBlank(personUuid)){
			MsgModel msg = MsgModel.buildDefaultError("参数不合法 ");
			return  GsonUtil.toJsonForObject(msg);
		}
		MsgModel msg = null;
		try {
			tabLaudService.addLaud(moduleUuid, personUuid);
			msg = MsgModel.buildDefaultSuccess("点赞成功", null);
		} catch (Exception e) {
			logger.error("点赞异常." + e);
			msg = MsgModel.buildDefaultError("操作异常");
		}
		return GsonUtil.toJsonForObject(msg); 
	}
	
	@Override
	public String cancelLaud(String moduleUuid, String personUuid) {
		if(StringUtils.isBlank(moduleUuid) || StringUtils.isBlank(personUuid)){
			MsgModel msg = MsgModel.buildDefaultError("参数不合法 ");
			return  GsonUtil.toJsonForObject(msg);
		}
		MsgModel msg = null;
		try {
			tabLaudService.deleteLaud(moduleUuid, personUuid);
			msg = MsgModel.buildDefaultSuccess("取消点赞成功", null);
		} catch (Exception e) {
			logger.error("取消点赞异常." + e);
			msg = MsgModel.buildDefaultError("操作异常");
		}
		return GsonUtil.toJsonForObject(msg); 
	}
	
	@Override
	public String getExplainbyCode(String functionCode) {
		if(StringUtils.isBlank(functionCode)){
			MsgModel msg = MsgModel.buildDefaultError("参数不合法 ");
			return  GsonUtil.toJsonForObject(msg);
		}
		MsgModel msg = null;
		try {
			TabFunctionExplain explain = tabFunctionExplainService.queryExplainByCode(functionCode);
			msg =  MsgModel.buildDefaultSuccess("查询成功", explain);
		} catch (Exception e) {
			logger.error("查询异常." + e);
			msg = MsgModel.buildDefaultError("查询异常");
		}
		return GsonUtil.toJsonForObject(msg); 
	}
	
	@Override
	public String deleteReport(String reportUuid) {
		if(StringUtils.isBlank(reportUuid)){
			MsgModel msg = MsgModel.buildDefaultError("参数不合法 ");
			return  GsonUtil.toJsonForObject(msg);
		}
		MsgModel msg = null;
		try {
			reportService.deleteReportToMobile(reportUuid);
			msg =  MsgModel.buildDefaultSuccess("删除成功", null);
		} catch (Exception e) {
			logger.error("删除失败." + e);
			msg = MsgModel.buildDefaultError("删除失败");
		}
		return GsonUtil.toJsonForObject(msg);
	}
	
	@Override
	public String deleteTopic(String topicUuid) {
		if(StringUtils.isBlank(topicUuid)){
			MsgModel msg = MsgModel.buildDefaultError("参数不合法 ");
			return  GsonUtil.toJsonForObject(msg);
		}
		MsgModel msg = null;
		try {
			TabTopics topics = new TabTopics();
			topics.setTopicUuid(topicUuid);
			topics.setTopicStatus(ContantsUtil.BLOCK_STATUS_3);
			tabTopicsService.deleteTopicToMobile(topics);
			msg =  MsgModel.buildDefaultSuccess("删除成功", null);
		} catch (Exception e) {
			logger.error("删除失败." + e);
			msg = MsgModel.buildDefaultError("删除失败");
		}
		return GsonUtil.toJsonForObject(msg);
	}

	@Override
	public String getDict(String dictNo,String parentDictType) {
		List<Map<?,?>> list = tabDataDictService.getDictDataList(dictNo,parentDictType);
		JSONArray ja = JsonUtil.convertToJSONArray(list);
		return GsonUtil.toJsonForObject(ja);
	}

			public ExcellentInnovationService getExcellentInnovationService() {
		return excellentInnovationService;
	}
	
	public void setExcellentInnovationService(
			ExcellentInnovationService excellentInnovationService) {
		this.excellentInnovationService = excellentInnovationService;
	}

	
	public MobileSmsSendService getBaseMobileSmsSendService()
    {
        return baseMobileSmsSendService;
    }

    public void setBaseMobileSmsSendService(MobileSmsSendService baseMobileSmsSendService)
    {
        this.baseMobileSmsSendService = baseMobileSmsSendService;
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

	public TabLaudService getTabLaudService() {
		return tabLaudService;
	}

	public void setTabLaudService(TabLaudService tabLaudService) {
		this.tabLaudService = tabLaudService;
	}


}
