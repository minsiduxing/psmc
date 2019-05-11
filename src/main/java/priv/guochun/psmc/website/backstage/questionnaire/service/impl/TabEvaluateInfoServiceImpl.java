package priv.guochun.psmc.website.backstage.questionnaire.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.framework.sms.service.MobileSmsSendService;
import priv.guochun.psmc.system.util.ContantsUtil;
import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.SystemPropertiesUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.website.backstage.common.BaseDao;
import priv.guochun.psmc.website.backstage.questionnaire.model.TabEvaluateInfo;
import priv.guochun.psmc.website.backstage.questionnaire.service.TabEvaluateInfoService;
import priv.guochun.psmc.website.backstage.util.GenerateShortUrlUtil;
import priv.guochun.psmc.website.backstage.util.MsgTemplateUtil;

public class TabEvaluateInfoServiceImpl implements TabEvaluateInfoService{

	private static final String insertEvaluateSelective = "insertEvaluateSelective";
	private static final String selectEvaluateList = "selectEvaluateList";
	private static final String selectEvaluateByPrimaryKey = "selectEvaluateByPrimaryKey";
	private static final String updateEvaluateSelective = "updateEvaluateSelective";
	
	@Autowired
	private BaseDao baseDao;
	@Autowired
	private MobileSmsSendService baseMobileSmsSendService;

	@Override
	public void insertEvaluateInfoBusinessMethod(TabEvaluateInfo evaluateInfo, User user) {
		Date currentDate = new Date();
		evaluateInfo.setEvaluateInfoUuid(UUIDGenerator.createUUID());
		evaluateInfo.setConsumptionDate(currentDate);
		evaluateInfo.setInputAccUuid(user.getUserUuid());
		evaluateInfo.setInputTime(currentDate);
		evaluateInfo.setNoticeTime(currentDate);
		//消费金额、消费项目
		if(ContantsUtil.NOTICE_TYPE_1.equals(evaluateInfo.getEvaluateNoticeType()) 
				|| ContantsUtil.NOTICE_TYPE_2.equals(evaluateInfo.getEvaluateNoticeType())){
			//获取问卷地址
			String url = SystemPropertiesUtil.getQuestionnaireUrl();
			String visitUrl = url+"&questionnaireUuid="+evaluateInfo.getQuestionnaireUuid()+"&evaluateInfoUuid="+evaluateInfo.getEvaluateInfoUuid();
			evaluateInfo.setVisitUrl(visitUrl);
			//转换短链接
			String shortUrl = GenerateShortUrlUtil.createShortUrl(evaluateInfo.getVisitUrl());
			evaluateInfo.setVisitShortUrl(shortUrl);
			evaluateInfo.setEvaluateStatus(ContantsUtil.EVALUATE_STATUS_1); //待评价
		}//充值
		else {
			evaluateInfo.setEvaluateStatus(ContantsUtil.EVALUATE_STATUS_3); //无评价
		}
		
		String msgContent = this.getMsgContent(evaluateInfo);
		evaluateInfo.setNoticeNote(msgContent);
		
		//发送短信
		/*SmsModel sm = new SmsModel();
        sm.setCreateTime(TimestampUtil.createCurTimestamp());
        sm.setReceiveContext(msgContent);
        sm.setReceiveNo(evaluateInfo.getEvaluatePhone());
        MsgModel mm = baseMobileSmsSendService.sendSms(sm);
        if(mm.isSuccess()){
    	    GsonUtil.toJsonForObject(MsgModel.buildDefaultSuccess());
    		
        }else{
       	    GsonUtil.toJsonForObject(mm);
        }*/
		baseDao.insert(insertEvaluateSelective, evaluateInfo);
	}
	
	@Override
	public MyPage queryEvaluateInfoList(MyPage page){
		Map<String,Object> condition = new HashMap<String,Object>();
		 //查询参数添加
		if(page.getQueryParams()!=null && page.getQueryParams().size()>0){
			condition.putAll(page.getQueryParams());
		}
		return baseDao.getMyPage(page, selectEvaluateList, condition);
	}

	@Override
	public void sendMsgBusinessMethod(Integer phone) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 导入Excel数据
	 */
	@Override
	public void saveExcelEvaluateBusinessMethod(List<String[]> excelList, Integer evaluateNoticeType, String questionnaireUuid, User user) {
		if(excelList != null && !excelList.isEmpty()) {
			Date currentDate = new Date();
			//第一条数据是表头，跳过
            for(int i=1; i<excelList.size(); i++) {
            	String[] strs = excelList.get(i);
        		TabEvaluateInfo evaluateInfo = new TabEvaluateInfo();
        		evaluateInfo.setEvaluateInfoUuid(UUIDGenerator.createUUID());
        		evaluateInfo.setQuestionnaireUuid(questionnaireUuid);
        		evaluateInfo.setInputAccUuid(user.getUserUuid());
        		evaluateInfo.setInputTime(currentDate);
        		evaluateInfo.setEvaluateNoticeType(evaluateNoticeType);
        		evaluateInfo.setEvaluateName(strs[0]);
        		evaluateInfo.setEvaluateNickName(strs[1]);
        		evaluateInfo.setEvaluatePhone(strs[2]);
        		try {
					evaluateInfo.setConsumptionDate(DateUtil.getDate(strs[3], "yyyy-mm-dd"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
        		if(ContantsUtil.NOTICE_TYPE_1.equals(evaluateNoticeType)){
        			evaluateInfo.setConsumptionAmount(new BigDecimal(strs[4]));
        			evaluateInfo.setSurplusAmount(new BigDecimal(strs[5]));
        			evaluateInfo.setSurplusScore(Integer.valueOf(strs[6]));
            	}else if(ContantsUtil.NOTICE_TYPE_2.equals(evaluateNoticeType)){
            		evaluateInfo.setConsumptionItem(strs[4]);
            		evaluateInfo.setSurplusNumber(Integer.valueOf(strs[5]));
            		evaluateInfo.setSurplusScore(Integer.valueOf(strs[6]));
            	}else{
            		evaluateInfo.setRechargeAmount(new BigDecimal(strs[4]));
            		evaluateInfo.setSurplusAmount(new BigDecimal(strs[5]));
            	}
        		evaluateInfo.setNoticeNote(this.getMsgContent(evaluateInfo));
        		baseDao.insert(insertEvaluateSelective, evaluateInfo);
            }
        }
		
	}
	
	/**
	 * 获取短信内容
	 * @param evaluateInfo
	 * @return
	 */
	private String getMsgContent(TabEvaluateInfo evaluateInfo){
		String templateContent = "";
		Map<String, Object> contentParamMap = new HashMap<String, Object>();
		contentParamMap.put("evaluateName", evaluateInfo.getEvaluateName());
		contentParamMap.put("consumptionDate", DateUtil.getDateString(evaluateInfo.getConsumptionDate()));
		//获取短信模板内容
		if(ContantsUtil.NOTICE_TYPE_1.equals(evaluateInfo.getEvaluateNoticeType())){
			templateContent = SystemPropertiesUtil.getMsgContent_1();
			contentParamMap.put("consumptionAmount", evaluateInfo.getConsumptionAmount());
			contentParamMap.put("surplusAmount", evaluateInfo.getSurplusAmount());
			contentParamMap.put("surplusScore", evaluateInfo.getSurplusScore());
			contentParamMap.put("visitShortUrl", evaluateInfo.getVisitShortUrl());
		}else if(ContantsUtil.NOTICE_TYPE_2.equals(evaluateInfo.getEvaluateNoticeType())){
			templateContent = SystemPropertiesUtil.getMsgContent_2();
			contentParamMap.put("consumptionItem", evaluateInfo.getConsumptionItem());
			contentParamMap.put("surplusNumber", evaluateInfo.getSurplusNumber());
			contentParamMap.put("surplusScore", evaluateInfo.getSurplusScore());
			contentParamMap.put("visitShortUrl", evaluateInfo.getVisitShortUrl());
		}else if(ContantsUtil.NOTICE_TYPE_3.equals(evaluateInfo.getEvaluateNoticeType())){
			templateContent = SystemPropertiesUtil.getMsgContent_3();
			contentParamMap.put("rechargeAmount", evaluateInfo.getRechargeAmount());
			contentParamMap.put("surplusAmount", evaluateInfo.getSurplusAmount());
		}
		
		return MsgTemplateUtil.handleTemplate(templateContent, contentParamMap);
	}

	@Override
	public TabEvaluateInfo selectById(String evaluateInfoUuid) {
		TabEvaluateInfo tabEvaluateInfo = (TabEvaluateInfo) baseDao.queryForObject(selectEvaluateByPrimaryKey, evaluateInfoUuid);
		return tabEvaluateInfo;
	}
	
	@Override
	public void updateEvaluate(TabEvaluateInfo tabEvaluateInfo){
		baseDao.update(updateEvaluateSelective, tabEvaluateInfo);
	}
	
	
}
