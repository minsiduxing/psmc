package priv.guochun.psmc.system.common.log.dao;

import priv.guochun.psmc.system.common.log.model.TSysOperLog;
import priv.guochun.psmc.system.framework.page.MyPage;

public interface TSysOperLogDao  {
	
	
	/**
	 * 得到分页日志数据
	 * @param myPage
	 * @return
	 */
	
	public MyPage getMyPageOfTSysOperLog(MyPage myPage);
	
	/**
	 * 保存
	 * @param tTSysOperLog
	 * @return
	 */
	public int save(TSysOperLog tTSysOperLog);

}
