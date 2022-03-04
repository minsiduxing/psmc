package priv.guochun.psmc.website.backstage.questionnaire.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.system.exception.PsmcBuisnessException;
import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.framework.sms.model.SmsModel;
import priv.guochun.psmc.system.framework.sms.service.MobileSmsSendService;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;
import priv.guochun.psmc.system.util.*;
import priv.guochun.psmc.website.backstage.common.BaseDao;
import priv.guochun.psmc.website.backstage.questionnaire.model.TabEvaluateInfo;
import priv.guochun.psmc.website.backstage.questionnaire.model.TabRealUrl;
import priv.guochun.psmc.website.backstage.questionnaire.service.TabEvaluateInfoService;
import priv.guochun.psmc.website.backstage.questionnaire.service.TabRealUrlService;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.*;

public class TabEvaluateInfoServiceImpl implements TabEvaluateInfoService{

	private static final String insertEvaluateSelective = "insertEvaluateSelective";
	private static final String selectEvaluateList = "selectEvaluateList";
	private static final String selectEvaluateByPrimaryKey = "selectEvaluateByPrimaryKey";
	private static final String updateEvaluateSelective = "updateEvaluateSelective";
	
	@Autowired
	private BaseDao baseDao;
	@Autowired
	private MobileSmsSendService baseMobileSmsSendService;
	@Autowired
	private TabRealUrlService tabRealUrlService;
	@Autowired
	private PsmcCacheFactory psmcCacheFactory;
	@Override
	public Map<String, Object> insertEvaluateInfoBusinessMethod(TabEvaluateInfo evaluateInfo, User user) {
		Map<String, Object> resultmap = new HashMap<String, Object>();
		Date currentDate = new Date();
		evaluateInfo.setEvaluateInfoUuid(UUIDGenerator.createUUID());
		evaluateInfo.setConsumptionDate(currentDate);
		evaluateInfo.setInputAccUuid(user.getUserUuid());
		evaluateInfo.setInputTime(currentDate);
		evaluateInfo.setNoticeTime(currentDate);

		Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
		Map<String, String> map = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);

		//消费金额、消费项目
		if(ContantsUtil.NOTICE_TYPE_1.equals(evaluateInfo.getEvaluateNoticeType()) 
				|| ContantsUtil.NOTICE_TYPE_2.equals(evaluateInfo.getEvaluateNoticeType())){
			//获取问卷地址
			String url =map.get("questionnaireUrl").toString();
			String url1 =map.get("shotUrl").toString();
			String visitUrl = url+"&questionnaireUuid="+evaluateInfo.getQuestionnaireUuid()+"&evaluateInfoUuid="+evaluateInfo.getEvaluateInfoUuid();
			evaluateInfo.setVisitUrl(visitUrl);
			TabRealUrl realUrl = new TabRealUrl();
			realUrl.setRealUrl(visitUrl);
			Integer id = tabRealUrlService.insertRealUrl(realUrl);
			String shortUrl = url1 + id;
			//转换短链接
//			String shortUrl = GenerateShortUrlUtil.createShortUrl(evaluateInfo.getVisitUrl());
			evaluateInfo.setVisitShortUrl(shortUrl);
			evaluateInfo.setEvaluateStatus(ContantsUtil.EVALUATE_STATUS_1); //待评价
		}//充值
		else {
			evaluateInfo.setEvaluateStatus(ContantsUtil.EVALUATE_STATUS_3); //无评价
		}

		evaluateInfo = this.getMsgContent(evaluateInfo);

		baseDao.insert(insertEvaluateSelective, evaluateInfo);
		//发送短信
		SmsModel sm = new SmsModel();
        sm.setCreateTime(TimestampUtil.createCurTimestamp());
        sm.setReceiveContext(evaluateInfo.getNoticeNote());
        sm.setSendType("2");

        if(ContantsUtil.NOTICE_TYPE_1.equals(evaluateInfo.getEvaluateNoticeType())) {
        	sm.setSmsId(ContantsUtil.MSG_CONTENT_1);
        }else if(ContantsUtil.NOTICE_TYPE_2.equals(evaluateInfo.getEvaluateNoticeType())) {
        	sm.setSmsId(ContantsUtil.MSG_CONTENT_2);
        }else if(ContantsUtil.NOTICE_TYPE_3.equals(evaluateInfo.getEvaluateNoticeType())) {
        	sm.setSmsId(ContantsUtil.MSG_CONTENT_3);
        }else if(ContantsUtil.NOTICE_TYPE_4.equals(evaluateInfo.getEvaluateNoticeType())) {
			sm.setSmsId(ContantsUtil.MSG_CONTENT_4);
		}else if(ContantsUtil.NOTICE_TYPE_5.equals(evaluateInfo.getEvaluateNoticeType())) {
			sm.setSmsId(ContantsUtil.MSG_CONTENT_5);
		}else if(ContantsUtil.NOTICE_TYPE_6.equals(evaluateInfo.getEvaluateNoticeType())) {
			sm.setSmsId(ContantsUtil.MSG_CONTENT_6);
		}else if(ContantsUtil.NOTICE_TYPE_7.equals(evaluateInfo.getEvaluateNoticeType())) {
			sm.setSmsId(ContantsUtil.MSG_CONTENT_7);
		}else if(ContantsUtil.NOTICE_TYPE_8.equals(evaluateInfo.getEvaluateNoticeType())) {
			sm.setSmsId(ContantsUtil.MSG_CONTENT_8);
		}else if(ContantsUtil.NOTICE_TYPE_9.equals(evaluateInfo.getEvaluateNoticeType())) {
			sm.setSmsId(ContantsUtil.MSG_CONTENT_9);
		}
        sm.setReceiveNo(evaluateInfo.getEvaluatePhone());
        MsgModel mm = baseMobileSmsSendService.sendSms(sm);
        resultmap.put("success", true);
		resultmap.put("msg", "保存成功");
        if(!mm.isSuccess()){
        	evaluateInfo.setEvaluateStatus(ContantsUtil.EVALUATE_STATUS_4); //短信发送失败;
        	baseDao.update(updateEvaluateSelective, evaluateInfo);
        	resultmap.put("success", false);
            resultmap.put("msg", "保存成功，短信发送失败");
        }
		return resultmap;
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
	public boolean sendMsg(String evaluateInfoUuid) {
		TabEvaluateInfo evaluateInfo = this.selectById(evaluateInfoUuid);
		//发送短信
		SmsModel sm = new SmsModel();
        sm.setCreateTime(TimestampUtil.createCurTimestamp());
        sm.setReceiveContext(evaluateInfo.getNoticeNote());
        sm.setReceiveNo(evaluateInfo.getEvaluatePhone());
        MsgModel mm = baseMobileSmsSendService.sendSms(sm);
        //发送成功
        if(mm.isSuccess()){
        	evaluateInfo.setEvaluateStatus(ContantsUtil.EVALUATE_STATUS_1); //待评价;
        	this.updateEvaluate(evaluateInfo);
        	return true;
        }else{
        	return false;
        }
	}
	
	/**
	 * 导入Excel数据
	 */
	@Override
	public void saveExcelEvaluateBusinessMethod(List<String[]> excelList, Integer evaluateNoticeType, String questionnaireUuid, User user) {
		if(excelList != null && !excelList.isEmpty()) {
			Date currentDate = new Date();
			//获取问卷地址
			PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
			Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
			Map<String, String> map = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
			String url =map.get("questionnaireUrl").toString();
			String url1 =map.get("shotUrl").toString();
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
        		evaluateInfo.setNoticeTime(currentDate);
        		try {
					evaluateInfo.setConsumptionDate(DateUtil.getDate(strs[3], "yyyy-MM-dd"));
				} catch (ParseException e) {
					throw new PsmcBuisnessException("时间格式错误！");
				}
        		String visitUrl = url+"&questionnaireUuid="+evaluateInfo.getQuestionnaireUuid()+"&evaluateInfoUuid="+evaluateInfo.getEvaluateInfoUuid();
        		if(ContantsUtil.NOTICE_TYPE_1.equals(evaluateNoticeType)){
        			evaluateInfo.setConsumptionAmount(new BigDecimal(strs[4]));
        			evaluateInfo.setSurplusAmount(new BigDecimal(strs[5]));
        			evaluateInfo.setSurplusScore(Integer.valueOf(strs[6]));
        			evaluateInfo.setEvaluateStatus(ContantsUtil.EVALUATE_STATUS_1); //待评价
        			evaluateInfo.setVisitUrl(visitUrl);
        			TabRealUrl realUrl = new TabRealUrl();
        			realUrl.setRealUrl(visitUrl);
        			Integer id = tabRealUrlService.insertRealUrl(realUrl);
        			String shortUrl = url1 + id;
        			//转换短链接
//        			String shortUrl = GenerateShortUrlUtil.createShortUrl(visitUrl);
        			evaluateInfo.setVisitShortUrl(shortUrl);
            	}else if(ContantsUtil.NOTICE_TYPE_2.equals(evaluateNoticeType)){
            		String consumptionItem = strs[4];
            		String surplusNumber = strs[5];
            		if(StringUtils.isNotBlank(consumptionItem) && StringUtils.isNotBlank(surplusNumber)){
            			String[] itemArray = consumptionItem.split("&");
                		String[] numberArray = surplusNumber.split("&");
                		if(itemArray.length != numberArray.length){
                			throw new PsmcBuisnessException("消费项目数与剩余次数不匹配！");
                		}
            		}
            		evaluateInfo.setConsumptionItem(consumptionItem);
            		evaluateInfo.setSurplusNumber(surplusNumber);
            		evaluateInfo.setSurplusScore(Integer.valueOf(strs[6]));
            		evaluateInfo.setEvaluateStatus(ContantsUtil.EVALUATE_STATUS_1); //待评价
            		evaluateInfo.setVisitUrl(visitUrl);
            		TabRealUrl realUrl = new TabRealUrl();
        			realUrl.setRealUrl(visitUrl);
        			Integer id = tabRealUrlService.insertRealUrl(realUrl);
        			String shortUrl = url1 + id;
            		//转换短链接
//        			String shortUrl = GenerateShortUrlUtil.createShortUrl(visitUrl);
        			evaluateInfo.setVisitShortUrl(shortUrl);
            	}else{
            		evaluateInfo.setRechargeAmount(new BigDecimal(strs[4]));
            		evaluateInfo.setSurplusAmount(new BigDecimal(strs[5]));
            		evaluateInfo.setGiveAmount(strs[6]); //赠送金额
            		evaluateInfo.setEvaluateStatus(ContantsUtil.EVALUATE_STATUS_3); //充值不需要评价
            	}
				evaluateInfo = this.getMsgContent(evaluateInfo);
        		baseDao.insert(insertEvaluateSelective, evaluateInfo);
        		//发送短信
        		SmsModel sm = new SmsModel();
                sm.setCreateTime(TimestampUtil.createCurTimestamp());
                sm.setReceiveContext(evaluateInfo.getNoticeNote());
                sm.setSendType("2");
                if(ContantsUtil.NOTICE_TYPE_1.equals(evaluateInfo.getEvaluateNoticeType())) {
                	sm.setSmsId(ContantsUtil.MSG_CONTENT_1);
                }else if(ContantsUtil.NOTICE_TYPE_2.equals(evaluateInfo.getEvaluateNoticeType())) {
                	sm.setSmsId(ContantsUtil.MSG_CONTENT_2);
                }else if(ContantsUtil.NOTICE_TYPE_3.equals(evaluateInfo.getEvaluateNoticeType())) {
                	sm.setSmsId(ContantsUtil.MSG_CONTENT_3);
                }
                sm.setReceiveContext(evaluateInfo.getNoticeNote());
                sm.setReceiveNo(evaluateInfo.getEvaluatePhone());
                MsgModel mm = baseMobileSmsSendService.sendSms(sm);
                if(!mm.isSuccess()){
                	evaluateInfo.setEvaluateStatus(ContantsUtil.EVALUATE_STATUS_4); //短信发送失败;
                	baseDao.update(updateEvaluateSelective, evaluateInfo);
                }
        		
            }
        }
		
	}
	
	/**
	 * 获取短信内容
	 * @param evaluateInfo
	 * @return
	 */
	/*private String getMsgContent(TabEvaluateInfo evaluateInfo){
		String templateContent = "";
		Map<String, Object> contentParamMap = new HashMap<String, Object>();
		contentParamMap.put("evaluateNickName", evaluateInfo.getEvaluateNickName());
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
			String itemContent = "";
			String[] itemArray = evaluateInfo.getConsumptionItem().split("&");
			String[] numberArray = evaluateInfo.getSurplusNumber().split("&");
			//拼接消费项目
			for (int i = 0; i < itemArray.length; i++) {
				itemContent += itemArray[i] + "，剩余" + numberArray[i] + "次，";
			}
			contentParamMap.put("itemContent", itemContent);
			contentParamMap.put("surplusScore", evaluateInfo.getSurplusScore());
			contentParamMap.put("visitShortUrl", evaluateInfo.getVisitShortUrl());
		}else if(ContantsUtil.NOTICE_TYPE_3.equals(evaluateInfo.getEvaluateNoticeType())){
			templateContent = SystemPropertiesUtil.getMsgContent_3();
			contentParamMap.put("rechargeAmount", evaluateInfo.getRechargeAmount());
			contentParamMap.put("surplusAmount", evaluateInfo.getSurplusAmount());
			contentParamMap.put("giveAmount", evaluateInfo.getGiveAmount()); //赠送金额
		}
		
		return MsgTemplateUtil.handleTemplate(templateContent, contentParamMap);
	}*/

	@SuppressWarnings("unchecked")
	public TabEvaluateInfo getMsgContent(TabEvaluateInfo evaluateInfo) {
		String smsTemplateContent = "";
		List mlist = new ArrayList<Map<String, Object>>();
		Map<String, Object> contentParamMap = new HashMap<String, Object>();
		contentParamMap.put("手机号码", evaluateInfo.getEvaluatePhone());
		contentParamMap.put("evaluateNickName", evaluateInfo.getEvaluateNickName());

		//获取短信模板内容
		if(ContantsUtil.NOTICE_TYPE_1.equals(evaluateInfo.getEvaluateNoticeType())){
			contentParamMap.put("consumptionAmount", evaluateInfo.getConsumptionAmount());
			contentParamMap.put("surplusAmount", evaluateInfo.getSurplusAmount());
			contentParamMap.put("surplusScore", evaluateInfo.getSurplusScore());
			contentParamMap.put("visitShortUrl", evaluateInfo.getVisitShortUrl());
			contentParamMap.put("consumptionDate", DateUtil.getDateString(evaluateInfo.getConsumptionDate()));
			smsTemplateContent = ContantsUtil.MSG_CONTENT_REMARK_1;
		}else if(ContantsUtil.NOTICE_TYPE_2.equals(evaluateInfo.getEvaluateNoticeType())){
			String itemContent = "";
			String[] itemArray = evaluateInfo.getConsumptionItem().split("&");
			String[] numberArray = evaluateInfo.getSurplusNumber().split("&");
			//拼接消费项目
			for (int i = 0; i < itemArray.length; i++) {
				itemContent += itemArray[i] + "，剩余" + numberArray[i] + "次，";
			}
			contentParamMap.put("itemContent", itemContent);
			contentParamMap.put("surplusScore", evaluateInfo.getSurplusScore());
			contentParamMap.put("visitShortUrl", evaluateInfo.getVisitShortUrl());
			contentParamMap.put("consumptionDate", DateUtil.getDateString(evaluateInfo.getConsumptionDate()));
			smsTemplateContent = ContantsUtil.MSG_CONTENT_REMARK_2;
		}else if(ContantsUtil.NOTICE_TYPE_3.equals(evaluateInfo.getEvaluateNoticeType())){
			contentParamMap.put("rechargeAmount", evaluateInfo.getRechargeAmount());
			contentParamMap.put("surplusAmount", evaluateInfo.getSurplusAmount());
			contentParamMap.put("giveAmount", evaluateInfo.getGiveAmount()); //赠送金额
			contentParamMap.put("consumptionDate", DateUtil.getDateString(evaluateInfo.getConsumptionDate()));
			smsTemplateContent = ContantsUtil.MSG_CONTENT_REMARK_3;
		}else if(ContantsUtil.NOTICE_TYPE_4.equals(evaluateInfo.getEvaluateNoticeType())){//卡余提醒一
			contentParamMap.put("surplusNumber", evaluateInfo.getSurplusNumber());
			contentParamMap.put("consumptionItem", evaluateInfo.getConsumptionItem());
			contentParamMap.put("surplusAmount", evaluateInfo.getSurplusAmount());
			contentParamMap.put("otherRemark", evaluateInfo.getOtherRemark());
			smsTemplateContent = ContantsUtil.MSG_CONTENT_REMARK_4;
		}else if(ContantsUtil.NOTICE_TYPE_5.equals(evaluateInfo.getEvaluateNoticeType())){//卡余提醒二
			contentParamMap.put("consumptionItem", evaluateInfo.getConsumptionItem());
			contentParamMap.put("surplusAmount", evaluateInfo.getSurplusAmount());
			smsTemplateContent = ContantsUtil.MSG_CONTENT_REMARK_5;
		}else if(ContantsUtil.NOTICE_TYPE_6.equals(evaluateInfo.getEvaluateNoticeType())){//卡余提醒三
			contentParamMap.put("surplusAmount", evaluateInfo.getSurplusAmount());
			contentParamMap.put("otherRemark", evaluateInfo.getOtherRemark());
			smsTemplateContent = ContantsUtil.MSG_CONTENT_REMARK_6;
		}else if(ContantsUtil.NOTICE_TYPE_7.equals(evaluateInfo.getEvaluateNoticeType())){//未体验提醒一
			contentParamMap.put("consumptionItem", evaluateInfo.getConsumptionItem());
			smsTemplateContent = ContantsUtil.MSG_CONTENT_REMARK_7;
		}else if(ContantsUtil.NOTICE_TYPE_8.equals(evaluateInfo.getEvaluateNoticeType())){//未体验提醒二
			contentParamMap.put("consumptionItem", evaluateInfo.getConsumptionItem());
			contentParamMap.put("otherRemark", evaluateInfo.getOtherRemark());
			contentParamMap.put("surplusNumber", evaluateInfo.getSurplusNumber());
			smsTemplateContent = ContantsUtil.MSG_CONTENT_REMARK_8;
		}else if(ContantsUtil.NOTICE_TYPE_9.equals(evaluateInfo.getEvaluateNoticeType())){//专享提醒
			contentParamMap.put("otherRemark", evaluateInfo.getOtherRemark());
			contentParamMap.put("butler", evaluateInfo.getButler());
			contentParamMap.put("vipRemark", evaluateInfo.getVipRemark());
			contentParamMap.put("consumptionDate", DateUtil.getDateString(evaluateInfo.getConsumptionDate()));
			smsTemplateContent = ContantsUtil.MSG_CONTENT_REMARK_9;
		}
		mlist.add(contentParamMap);
		String str = JsonUtil.convertToJSONArray(mlist).toString();
		evaluateInfo.setNoticeNote(str);

		//将发送的短信内容完全匹配出来进行保存
		Set set = contentParamMap.keySet();
		Iterator iter = set.iterator();
		while(iter.hasNext()){
			String key = iter.next().toString();
			if(smsTemplateContent.indexOf("${"+key+"}") != -1)
			{
				String vlaue = contentParamMap.get(key)!=null?contentParamMap.get(key).toString():"";
				smsTemplateContent = smsTemplateContent.replaceAll("\\$\\{"+key+"\\}",vlaue);
			}
		}
		evaluateInfo.setNoticeContent(smsTemplateContent);
		return evaluateInfo;
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

	public PsmcCacheFactory getPsmcCacheFactory() {
		return psmcCacheFactory;
	}

	public void setPsmcCacheFactory(PsmcCacheFactory psmcCacheFactory) {
		this.psmcCacheFactory = psmcCacheFactory;
	}
}
