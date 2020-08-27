package priv.guochun.psmc.website.backstage.questionnaire.service.impl;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.system.exception.PsmcBuisnessException;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.framework.sms.model.SmsModel;
import priv.guochun.psmc.system.framework.sms.service.MobileSmsSendService;
import priv.guochun.psmc.system.framework.util.GsonUtil;
import priv.guochun.psmc.system.util.ContantsUtil;
import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.JsonUtil;
import priv.guochun.psmc.system.util.SystemPropertiesUtil;
import priv.guochun.psmc.system.util.TimestampUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.website.backstage.common.BaseDao;
import priv.guochun.psmc.website.backstage.questionnaire.model.TabEvaluateInfo;
import priv.guochun.psmc.website.backstage.questionnaire.model.TabRealUrl;
import priv.guochun.psmc.website.backstage.questionnaire.service.TabEvaluateInfoService;
import priv.guochun.psmc.website.backstage.questionnaire.service.TabRealUrlService;
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
	@Autowired
	private TabRealUrlService tabRealUrlService;

	@Override
	public Map<String, Object> insertEvaluateInfoBusinessMethod(TabEvaluateInfo evaluateInfo, User user) {
		Map<String, Object> resultmap = new HashMap<String, Object>();
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
			String url1 = SystemPropertiesUtil.getShortUrl();
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
		
		String msgContent = this.getMsgContent(evaluateInfo);
		evaluateInfo.setNoticeNote(msgContent);
		baseDao.insert(insertEvaluateSelective, evaluateInfo);
		//发送短信
		SmsModel sm = new SmsModel();
        sm.setCreateTime(TimestampUtil.createCurTimestamp());
        sm.setReceiveContext(msgContent);
        sm.setSendType("2");
        if(ContantsUtil.NOTICE_TYPE_1.equals(evaluateInfo.getEvaluateNoticeType())) {
        	sm.setSmsId(ContantsUtil.MSG_CONTENT_1);
        }else if(ContantsUtil.NOTICE_TYPE_2.equals(evaluateInfo.getEvaluateNoticeType())) {
        	sm.setSmsId(ContantsUtil.MSG_CONTENT_2);
        }else if(ContantsUtil.NOTICE_TYPE_3.equals(evaluateInfo.getEvaluateNoticeType())) {
        	sm.setSmsId(ContantsUtil.MSG_CONTENT_3);
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
			String url = SystemPropertiesUtil.getQuestionnaireUrl();
			String url1 = SystemPropertiesUtil.getShortUrl();
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
        		String msgContent = this.getMsgContent(evaluateInfo);
        		evaluateInfo.setNoticeNote(msgContent);
        		baseDao.insert(insertEvaluateSelective, evaluateInfo);
        		//发送短信
        		SmsModel sm = new SmsModel();
                sm.setCreateTime(TimestampUtil.createCurTimestamp());
                sm.setReceiveContext(msgContent);
                sm.setSendType("2");
                if(ContantsUtil.NOTICE_TYPE_1.equals(evaluateInfo.getEvaluateNoticeType())) {
                	sm.setSmsId(ContantsUtil.MSG_CONTENT_1);
                }else if(ContantsUtil.NOTICE_TYPE_2.equals(evaluateInfo.getEvaluateNoticeType())) {
                	sm.setSmsId(ContantsUtil.MSG_CONTENT_2);
                }else if(ContantsUtil.NOTICE_TYPE_3.equals(evaluateInfo.getEvaluateNoticeType())) {
                	sm.setSmsId(ContantsUtil.MSG_CONTENT_3);
                }
                sm.setReceiveContext(msgContent);
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
	public String getMsgContent(TabEvaluateInfo evaluateInfo) {
		List mlist = new ArrayList<Map<String, Object>>();
		Map<String, Object> contentParamMap = new HashMap<String, Object>();
		contentParamMap.put("手机号码", evaluateInfo.getEvaluatePhone());
		contentParamMap.put("evaluateNickName", evaluateInfo.getEvaluateNickName());
		contentParamMap.put("consumptionDate", DateUtil.getDateString(evaluateInfo.getConsumptionDate()));
		//获取短信模板内容
		if(ContantsUtil.NOTICE_TYPE_1.equals(evaluateInfo.getEvaluateNoticeType())){
			contentParamMap.put("consumptionAmount", evaluateInfo.getConsumptionAmount());
			contentParamMap.put("surplusAmount", evaluateInfo.getSurplusAmount());
			contentParamMap.put("surplusScore", evaluateInfo.getSurplusScore());
			contentParamMap.put("visitShortUrl", evaluateInfo.getVisitShortUrl());
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
		}else if(ContantsUtil.NOTICE_TYPE_3.equals(evaluateInfo.getEvaluateNoticeType())){
			contentParamMap.put("rechargeAmount", evaluateInfo.getRechargeAmount());
			contentParamMap.put("surplusAmount", evaluateInfo.getSurplusAmount());
			contentParamMap.put("giveAmount", evaluateInfo.getGiveAmount()); //赠送金额
		}
		mlist.add(contentParamMap);
		return JsonUtil.convertToJSONArray(mlist).toString();
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
