package priv.guochun.psmc.website.backstage.news.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;

import priv.guochun.psmc.system.framework.dao.IDaoTemplate;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.website.backstage.news.dao.TabNewsDao;
import priv.guochun.psmc.website.backstage.news.model.TabNews;

public class TabNewsDaoImpl implements TabNewsDao {
    
    public static final String getListNewsByCondition="getListNewsByCondition";
    public static final String getNewsByUuid="getNewsByUuid";
    public static final String getNewsTitlesListByTwoLevelClassify="getNewsTitlesListByTwoLevelClassify";
    public static final String insertTabNews="insertTabNews";
    public static final String updateTabNews="updateTabNews";
    public static final String deletesTabNewsByUuid="deletesTabNewsByUuid";
    
    private SqlSessionTemplate sqlSession;
    private IDaoTemplate iDaoTemplate;
	@Override
	public void saveOrUpdateTabNews(TabNews tabNews) {
		 if(tabNews == null || StringUtils.isBlank(tabNews.getNewsUuid())){
	            throw new IllegalArgumentException("主键为空,无法进行对象持久化操作!");
	        }
	        String id = tabNews.getNewsUuid();
	        Map<String,Object> map = this.getNewsByNewsUuid(id);
	        if(map !=null)
	            sqlSession.update(updateTabNews,tabNews);
	        else
	            sqlSession.insert(insertTabNews,tabNews);
	}

	@Override
	public void deleteTabNewsByUuids(String uuids) {
		Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("ids", uuids.split(","));
        sqlSession.delete(deletesTabNewsByUuid, condition);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getNewsByNewsUuid(String uuid) {
	    Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("newsUuid", uuid);
        Map<String,Object> map = (Map<String,Object>)sqlSession.selectOne(getNewsByUuid,condition);
        return map;
	}

	@Override
	public MyPage getNewsByCondition(MyPage myPage) {
		Map<String,Object> condition = new HashMap<String,Object>();
		 //查询参数添加
       if(myPage.getQueryParams()!=null && myPage.getQueryParams().size()>0){
       	condition.putAll(myPage.getQueryParams());
       }
       return iDaoTemplate.getMyPage(myPage, getListNewsByCondition, condition);
	}

	@Override
	public List<Map<String, Object>> getNewsListByCondition(MyPage myPage) {
		Map<String,Object> condition = new HashMap<String,Object>();
		 //查询参数添加
        if(myPage.getQueryParams()!=null && myPage.getQueryParams().size()>0){
        	condition.putAll(myPage.getQueryParams());
        }
        List<Map<String,Object>> list  = sqlSession.selectList(getListNewsByCondition,condition);
        return list;
	}

	@Override
	public List<Map<String, Object>> getShowNewsTitlesListByTowLevelClassify(
			String towLevelClassify) {
		Map<String,Object> condition = new HashMap<String,Object>();
		 //查询参数添加
       	condition.put("towLevelClassify",towLevelClassify);
       	condition.put("publishExpireDate",DateUtil.getCurrentTimstamp());
       List<Map<String,Object>> list  = sqlSession.selectList(getNewsTitlesListByTwoLevelClassify,condition);
       return list;
	}

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	public IDaoTemplate getiDaoTemplate() {
		return iDaoTemplate;
	}

	public void setiDaoTemplate(IDaoTemplate iDaoTemplate) {
		this.iDaoTemplate = iDaoTemplate;
	}

}
