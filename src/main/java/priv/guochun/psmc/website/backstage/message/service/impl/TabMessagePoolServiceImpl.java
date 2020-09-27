package priv.guochun.psmc.website.backstage.message.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.framework.sms.model.SmsModel;
import priv.guochun.psmc.system.framework.sms.service.MobileSmsSendService;
import priv.guochun.psmc.system.util.JsonUtil;
import priv.guochun.psmc.website.backstage.common.BaseDao;
import priv.guochun.psmc.website.backstage.message.model.TabMessageBlack;
import priv.guochun.psmc.website.backstage.message.model.TabMessagePool;
import priv.guochun.psmc.website.backstage.message.model.TabMessageTemp;
import priv.guochun.psmc.website.backstage.message.service.TabMessageBlackService;
import priv.guochun.psmc.website.backstage.message.service.TabMessagePoolService;
import priv.guochun.psmc.website.backstage.message.service.TabMessageTempService;
import priv.guochun.psmc.website.backstage.util.MsgTemplateUtil;

@Service
public class TabMessagePoolServiceImpl implements TabMessagePoolService {

	protected static final  Logger logger  = LoggerFactory.getLogger(TabMessagePoolServiceImpl.class);
	
	private static final String selectMessageList = "selectMessageList";
	private static final String selectMessagePoolByExampleNotPage = "selectMessagePoolByExampleNotPage";
	private static final String selectTempCode = "selectTempCode";
	private static final String insertMessagePoolSelective = "insertMessagePoolSelective";
	private static final String deleteMessagegPoolByPrimaryKey = "deleteMessagegPoolByPrimaryKey";
	private static final String deleteMessagegPoolByPhone = "deleteMessagegPoolByPhone";
	private static final String updatePoolByPrimaryKey = "updatePoolByPrimaryKey";
	private static final String selectMessagePoolByPrimaryKey = "selectMessagePoolByPrimaryKey";
	private static final String selectMessagePageList = "selectMessagePageList";
	private static final String countMessagePageList = "countMessagePageList";
	
	@Autowired
	private BaseDao baseDao;
	@Autowired
	private TabMessageTempService tabMessageTempService;
	@Autowired
	private TabMessageBlackService tabMessageBlackService;
	@Autowired
	private MobileSmsSendService baseMobileSmsSendService;
	
	@Override
	public MyPage queryTabMessagePoolList(MyPage page) {
		Map<String,Object> condition = new HashMap<String,Object>();
		 //查询参数添加
		if(page.getQueryParams()!=null && page.getQueryParams().size()>0){
			condition.putAll(page.getQueryParams());
		}
		return baseDao.getMyPage(page, selectMessageList, condition);
	}

	@Override
	public int insert(TabMessagePool tabMessagePool) {
		tabMessagePool.setMsgUuid(UUID.randomUUID().toString().replace("-", ""));
		return baseDao.insert(insertMessagePoolSelective, tabMessagePool); 
	}

	@Override
	public int deleteMessagegPoolByPrimaryKey(String msgUuid) {
		// TODO Auto-generated method stub
		return baseDao.delete(deleteMessagegPoolByPrimaryKey, msgUuid);
	}
	@Override
	public int deleteByPhone(String phone) {
		TabMessagePool tabMessagePool = new TabMessagePool();
		tabMessagePool.setPhone(phone);
		return baseDao.delete(deleteMessagegPoolByPhone, tabMessagePool);
	}
	
	@Override
	public void deletePoolAndAddBlackByPhone(String phone,String content) {
		this.deleteByPhone(phone);
		TabMessageBlack tabMessageBlack  = new TabMessageBlack();
		tabMessageBlack.setBlackUuid(UUID.randomUUID().toString().replace("-", ""));
		tabMessageBlack.setPhone(phone);
		tabMessageBlack.setReason(content);
		tabMessageBlackService.insertBlack(tabMessageBlack);
	}
	
	@Override
	public int updateByPrimaryKey(TabMessagePool tabMessagePool) {
		// TODO Auto-generated method stub
		return baseDao.update(updatePoolByPrimaryKey, tabMessagePool);
	}

	@Override
	public void saveExcelMessageBusinessMethod(List<String[]> excelList) {
		// TODO Auto-generated method stub
		if(excelList != null && !excelList.isEmpty()) {
			//第一条数据是表头，跳过
            for(int i=1; i<excelList.size(); i++) {
            	String customVals = "";
            	String[] strs = excelList.get(i);
            	TabMessagePool messagePool = new TabMessagePool();
            	messagePool.setMsgUuid(UUID.randomUUID().toString().replace("-", ""));
            	messagePool.setPhone(strs[0]);
            	messagePool.setTempCode(strs[1]);
            	customVals+=strs[2]+"|";
            	customVals+=strs[3]+"|";
            	customVals+=strs[4]+"|";
            	customVals+=strs[5]+"|";
            	customVals+=strs[6];
            	messagePool.setCustomVal(customVals.substring(0, customVals.length()-1));
        		baseDao.insert(insertMessagePoolSelective, messagePool);
            }
        }
	}

	@Override
	public List<TabMessagePool> queryByTempCodeList(String tempCode) {
		TabMessagePool messagePool = new TabMessagePool();
		messagePool.setTempCode(tempCode);
		List<TabMessagePool> list =  baseDao.queryForList(selectMessagePoolByExampleNotPage,messagePool);
		return list;
	}
	
	public void sendMsg() {
		//超过该数值分页
		int isPageCount = 1000;
		//查询所有模板(正在有效使用的)
		List<String> slist =  queryTempCode();
		for (String tCode : slist) {
			if(tCode!=null && !tCode.equals("")) {
				//根据模板code查询模板详情
				TabMessageTemp tmt = tabMessageTempService.queryByTempCode(tCode);
				//根据模板code查询对应手机号总条数
				int count = tabMessagePoolPageCount(tCode);
				List<TabMessagePool> tmpPoollist = null;
				if(count>isPageCount) {
					int runnum = count%isPageCount==0?(count/isPageCount):(count/isPageCount)+1;
					for (int i = 0; i < runnum; i++) {
						//根据模板code查询对应的手机号，分页查询
						tmpPoollist  = this.queryTabMessagePoolPageList(isPageCount*i, isPageCount,tCode);
						batchSendSms(tmt, tmpPoollist);
					}
				}else {
					tmpPoollist = this.queryByTempCodeList(tCode);
					batchSendSms(tmt, tmpPoollist);
				}
			}
		}
	}

	private void batchSendSms(TabMessageTemp tmt, List<TabMessagePool> tmpPoollist) {
		if(tmpPoollist.size()<0 || tmt==null || tmt.getTempUuid() == null) {
			return;
		}
		//拼接手机号
		String phone = AssemblingPhone(tmpPoollist);
		//短信发送
		if(tmt.getType().equals("0")) {
			SmsModel smsModel = new SmsModel();
			smsModel.setReceiveNo(phone);
			smsModel.setSendType("0");
			smsModel.setReceiveContext(tmt.getTempContent());
			baseMobileSmsSendService.sendSms(smsModel);
			//mmsutil.smsSend(phone, tmt.getTempContent());
		}else if(tmt.getType().equals("1")){
			SmsModel smsModel = new SmsModel();
			smsModel.setReceiveNo(phone);
			//彩信发送
			//创建彩信接口
			String classPath = this.getClass().getClassLoader().getResource("/").getPath();   
			classPath=classPath.substring(0, classPath.indexOf("WEB-INF"));
			String resPath = classPath+"resources"+File.separator+"mms"+File.separator+"sm01.jpg";
			smsModel.setmPath(resPath);
			smsModel.setSendType("1");
			smsModel.setReceiveContext(tmt.getTempContent());
			baseMobileSmsSendService.sendSms(smsModel);
			//String taskId = mmsutil.create(tmt.getTempContent(),resPath);
			//mmsutil.send(taskId,phone);
		}else if(tmt.getType().equals("3")){
			Map<String, Object> contentParamMap =null;
			for (TabMessagePool tabMessagePool : tmpPoollist) {
				//个性化自定义短信
				SmsModel smsModel = new SmsModel();
				smsModel.setReceiveNo(phone);
				smsModel.setSendType("2");
				smsModel.setSmsId(tmt.getTempId());
				//内容拼接
				String [] customVals = tabMessagePool.getCustomVal().split("\\|");
				contentParamMap = new HashMap<String, Object>();
				for (int i = 0; i < customVals.length; i++) {
					contentParamMap.put("content"+(i+1), customVals[i]);
				}
				String tempContent = MsgTemplateUtil.handleTemplate(tmt.getTempContent(), contentParamMap);
				smsModel.setReceiveContext(tempContent);
				baseMobileSmsSendService.sendSms(smsModel);
			}
		}
	}
	
	
	//拼接手机号
    private String AssemblingPhone(List<TabMessagePool> list) {
    	String phone="";
    	for (TabMessagePool tmp : list) {
			phone+=tmp.getPhone()+",";
		}
    	if(!phone.equals("")) {
    		phone=phone.substring(0,phone.length()-1);
    	}
    	return phone;
    }

	@Override
	public List<String> queryTempCode() {
		List<String> list =  baseDao.queryForList(selectTempCode);
		return list;
	}

	@Override
	public TabMessagePool queryPoolByUuid(String msgUuid) {
		
		TabMessagePool tabMessagePool = (TabMessagePool) baseDao.queryForObject(selectMessagePoolByPrimaryKey, msgUuid);
		return tabMessagePool;
	}

	@Override
	public List<TabMessagePool> queryTabMessagePoolPageList(int pageIndex, int pageSize, String tempCode) {
		Map<String, Object> dataMap = new HashMap<String,Object>();
		dataMap.put("pageIndex", pageIndex);
		dataMap.put("pageSize", pageSize);
		dataMap.put("tempCode", tempCode);
		return baseDao.queryForList(selectMessagePageList, dataMap);
	}

	@Override
	public int tabMessagePoolPageCount(String tempCode) {
		TabMessagePool tabMessagePool = new TabMessagePool();
		tabMessagePool.setTempCode(tempCode);
		return (int) baseDao.queryForObject(countMessagePageList, tabMessagePool);
	}

	@Override
	public Map<String, String> getBalance() {
		String smsGroup =baseMobileSmsSendService.getBalance("0");
		String mmsBalance =baseMobileSmsSendService.getBalance("1");
		String smsCustom =baseMobileSmsSendService.getBalance("2");
		Map<String, String> dataMap = new HashMap<String,String>();
		dataMap.put("smsGroup", smsGroup);
		dataMap.put("mmsBalance", mmsBalance);
		dataMap.put("smsCustom", smsCustom);
		return dataMap;
	}
}
