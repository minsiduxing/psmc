package priv.guochun.psmc.website.backstage.news.service;

import java.util.List;
import java.util.Map;

import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.website.backstage.module.model.TabModule;
import priv.guochun.psmc.website.backstage.news.model.TabNews;

/**
 * <p>Title: 新闻相关的业务接口</p>
 * <p>Description: 包含新闻的新增、修改、删除、列表查询 </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2017年9月3日
 */
public interface TabNewsService {
	/**
	 * <p>Description:新增修改新闻信息<p>
	 * @param tabNews  新闻实体类
	 * @author wanglei 2017年9月3日
	 */
	public void saveOrUpdateTabNewsBusinessMethod (TabNews tabNews,TabModule tam);
	/**
	 * <p>Description:根据id删除新闻<p>
	 * @param uuids id
	 * @author wanglei 2017年9月3日
	 */
	public void deleteTabNewsByUuidsBusinessMethod(String uuids);
	/**
	 * <p>Description:根据id 主键获取新闻<p>
	 * @param uuid主键
	 * @return 新闻实体
	 * @author wanglei 2017年9月3日
	 */
	public Map<String,Object> getNewsByNewsUuid(String uuid);
	/**
	 * <p>Description:根据条件获取新闻信息分页<p>
	 * @param myPage
	 * @return 新闻分页列表
	 * @author wanglei 2017年9月3日
	 */
	public MyPage getNewsByConditionBusinessMethod(MyPage myPage);
	/**
	 * <p>Description:根据用户id获取列表信息<p>
	 * @param myPage
	 * @param userUuid
	 * @return
	 * @author wanglei 2017年9月5日
	 */
	public MyPage getNewsByCondition(MyPage myPage,String userUuid);
	/**
	 * <p>Description:根据条件返回新闻列表<p>
	 * @param myPage 分页信息
	 * @return 新闻list
	 * @author wanglei 2017年9月3日
	 */
	public List<Map<String,Object>> getNewsListByConditionBusinessMethod(MyPage myPage);
	/**
	 * <p>Description:根据二级分类查询列表<p>
	 * @param towLevelClassify 二级分类内容
	 * @return
	 * @author wanglei 2017年9月3日
	 */
	public List<Map<String,Object>> getShowNewsTitlesListByTowLevelClassify(String towLevelClassify);
	/**
	 * <p>Description:审核新闻<p>
	 * @author wanglei 2017年9月3日
	 */
	public void executeAuditNewsBusinessMethod(TabModule tam);
	/**
	 * <p>Description:发布新闻<p>
	 * @author wanglei 2017年9月3日
	 */
	public void executeReleaseNewsBusinessMethod(TabModule tam);
	/**
	 * <p>Description:取消发布新闻<p>
	 * @param tam
	 * @author wanglei 2017年9月4日
	 */
	public void executeCancleReleaseNewsBusinessMethod(TabModule tam);
}
