package priv.guochun.psmc.website.backstage.message.service;

import java.util.List;
import java.util.Map;

import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.website.backstage.message.model.TabMessagePool;

public interface TabMessagePoolService {
	
	/**
	 * 查询所有带分页
	 * @param page
	 * @return
	 */
	public MyPage queryTabMessagePoolList(MyPage page);
	/**
	 * 根据模板code查询，不分页
	 * @return
	 */
	public List<TabMessagePool> queryByTempCodeList(String tempCode);
	/**
	 * 根据模板code查询,分页
	 * @param page
	 * @return
	 */
	public List<TabMessagePool> queryTabMessagePoolPageList(int pageIndex, int pageSize, String tempCode);
	/**
	 * 根据模板code查询总条数
	 */
	public int tabMessagePoolPageCount(String tempCode);
	
	public TabMessagePool queryPoolByUuid(String msgUuid);
	/**
	 * 新增
	 * @param tabMessagePool
	 * @return
	 */
	public int insert(TabMessagePool tabMessagePool);
	/**
	 * 根据主键删除
	 * @param msgUuid
	 * @return
	 */
	public int deleteMessagegPoolByPrimaryKey(String msgUuid);
	
	public int deleteByPhone(String phone);
	/**
	 * 根据主键修改
	 * @param tabMessagePool
	 * @return
	 */
	public int updateByPrimaryKey(TabMessagePool tabMessagePool);
	/**
	 * 导入excel
	 * @param excelList
	 */
	public void saveExcelMessageBusinessMethod(List<String[]> excelList);
	/**
	 * 查询当前使用的短信模板
	 * @return
	 */
	public List<String> queryTempCode();
	/**
	 * 发送短信、彩信
	 */
	public void sendMsg();
	
	public void deletePoolAndAddBlackByPhone(String phone,String content);
	
	/**
	 * 查询短信余额
	 * @return
	 */
	public Map<String, String> getBalance();
}
