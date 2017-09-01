package priv.guochun.psmc.website.backstage.navbar.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.website.backstage.navbar.dao.TabNavBarDao;
import priv.guochun.psmc.website.backstage.navbar.model.TabNavBar;

public class TabNavBarDaoImpl implements TabNavBarDao {
	  protected static final  Logger logger  = LoggerFactory.getLogger(TabNavBarDaoImpl.class);
	  public static final String getShowTabNavBarByCondition="getShowTabNavBarByCondition";
	    
	  private SqlSessionTemplate sqlSession;
	@Override
	public void saveOrUpdateTabNavBar(TabNavBar tnav) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTabNavBarByMenuUuid(String ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<TabNavBar> getAllShowTabNavBar() {
		Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("isLocked", 2);
        List<TabNavBar> results = sqlSession.selectList(getShowTabNavBarByCondition,condition);
		return results;
	}

	@Override
	public  List<Map<String,Object>> getShowTabNavBarByParentMenuUuid(String parentMenuUuid) {
		// TODO Auto-generated method stub
		return null;
	}
	public SqlSessionTemplate getSqlSession()
    {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession)
    {
        this.sqlSession = sqlSession;
    }
}
