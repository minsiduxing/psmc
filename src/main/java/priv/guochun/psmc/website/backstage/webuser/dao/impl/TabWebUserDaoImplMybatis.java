package priv.guochun.psmc.website.backstage.webuser.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.system.framework.dao.IDaoTemplate;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.website.backstage.webuser.dao.TabWebUserDao;
import priv.guochun.psmc.website.backstage.webuser.model.TabWebUser;

public class TabWebUserDaoImplMybatis implements TabWebUserDao {

	protected static final  Logger logger  = LoggerFactory.getLogger(TabWebUserDaoImplMybatis.class);
	
	public static final String getWebUserList="getWebUserList";
	public static final String queryUserCount="queryUserCount";
	public static final String findUserByCondition="findUserByCondition";
	public static final String updateUser="updateUser";
	public static final String saveTabWebUser="saveTabWebUser";
	public static final String updateTabWebUserByUuid="updateTabWebUserByUuid";
	public static final String executeWebUserUniqueValidate="executeWebUserUniqueValidate";  
	
	private SqlSessionTemplate sqlSession;
	
	private IDaoTemplate iDaoTemplate;
	
	@Override
	public MyPage getWebUserList(MyPage mapage) {
		return iDaoTemplate.getMyPage(mapage, getWebUserList,null);
	}
	
	@Override
	public int queryUserCount(String userId, String password) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("userId", userId);
		condition.put("password", password);
		return sqlSession.selectOne(queryUserCount, condition);
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

	public static Logger getLogger() {
		return logger;
	}

	public static String getGetwebuserlist() {
		return getWebUserList;
	}

	@Override
	public Map<String, Object> findUserByCondition(TabWebUser twu) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("userId", twu.getUserId());
		condition.put("uuid", twu.getUuid());
		return sqlSession.selectOne(findUserByCondition, condition);
	}

	@Override
	public void updateUser(TabWebUser twu) {
		sqlSession.update(updateUser,twu);
	}

	@Override
	public void saveTabWebUser(TabWebUser user) {
		sqlSession.insert(saveTabWebUser, user);
	}

	@Override
	public void updateTabWebUserByUuid(TabWebUser user) {
		sqlSession.update(updateTabWebUserByUuid, user);
	}

	@Override
	public int executeWebUserUniqueValidate(TabWebUser user) {
		return sqlSession.selectOne(executeWebUserUniqueValidate, user);
	}
}
