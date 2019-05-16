package priv.guochun.psmc.website.backstage.questionnaire.service;

import java.util.List;

import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.website.backstage.questionnaire.model.TabEvaluateInfo;

public interface TabEvaluateInfoService {

	public void insertEvaluateInfoBusinessMethod(TabEvaluateInfo evaluateInfo, User user);
	
	/**
	 * 手动补发短息
	 * @param evaluateInfoUuid
	 * @return
	 */
	public boolean sendMsg(String evaluateInfoUuid);
	
	public MyPage queryEvaluateInfoList(MyPage page);
	
	public void saveExcelEvaluateBusinessMethod(List<String[]> excelList, Integer evaluateNoticeType, String questionnaireUuid, User user);
	
	public TabEvaluateInfo selectById(String evaluateInfoUuid);
	
	public void updateEvaluate(TabEvaluateInfo tabEvaluateInfo);
}
