package priv.guochun.psmc.website.backstage.news.dao;

import java.util.List;
import java.util.Map;

import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.website.backstage.news.model.TabNews;

/**
 * <p>Title:新闻类的Dao </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright ICSS(c) 2017</p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2017年9月3日
 */
public interface TabNewsDao {
	/**
	 * <p>Description:新增修改新闻信息<p>
	 * @param tabNews  新闻实体类
	 * @author wanglei 2017年9月3日
	 */
	public void saveOrUpdateTabNews (TabNews tabNews);
	/**
	 * <p>Description:根据id删除新闻<p>
	 * @param uuids id
	 * @author wanglei 2017年9月3日
	 */
	public void deleteTabNewsByUuids(String uuids);
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
	public MyPage getNewsByCondition(MyPage myPage);
	/**
	 * <p>Description:根据条件返回新闻列表<p>
	 * @param myPage 分页信息
	 * @return 新闻list
	 * @author wanglei 2017年9月3日
	 */
	public List<Map<String,Object>> getNewsListByCondition(MyPage myPage);
	/**
	 * <p>Description:根据二级分类查询列表<p>
	 * @param towLevelClassify 二级分类内容
	 * @return
	 * @author wanglei 2017年9月3日
	 */
	public List<Map<String,Object>> getShowNewsTitlesListByTowLevelClassify(String towLevelClassify);
}
