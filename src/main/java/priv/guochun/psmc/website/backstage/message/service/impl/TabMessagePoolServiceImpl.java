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
import priv.guochun.psmc.website.backstage.common.BaseDao;
import priv.guochun.psmc.website.backstage.message.model.TabMessageBlack;
import priv.guochun.psmc.website.backstage.message.model.TabMessagePool;
import priv.guochun.psmc.website.backstage.message.model.TabMessageTemp;
import priv.guochun.psmc.website.backstage.message.service.TabMessageBlackService;
import priv.guochun.psmc.website.backstage.message.service.TabMessagePoolService;
import priv.guochun.psmc.website.backstage.message.service.TabMessageTempService;

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
            	String[] strs = excelList.get(i);
            	TabMessagePool messagePool = new TabMessagePool();
            	messagePool.setMsgUuid(UUID.randomUUID().toString().replace("-", ""));
            	messagePool.setPhone(strs[0]);
            	messagePool.setTempCode(strs[1]);
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
		//查询所有模板(正在有效使用的)
		List<String> slist =  queryTempCode();
		for (String tCode : slist) {
			if(tCode!=null && !tCode.equals("")) {
				//根据模板code查询对应的手机号
				List<TabMessagePool> tmplist = queryByTempCodeList(tCode);
				//根据模板code查询模板详情
				TabMessageTemp tmt = tabMessageTempService.queryByTempCode(tCode);
				if(tmplist.size()<0 || tmt==null || tmt.getTempUuid() == null) {
					continue;
				}
				//拼接手机号
				String phone = AssemblingPhone(tmplist);
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
				}
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
}
