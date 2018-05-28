package priv.guochun.psmc.authentication.user.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.authentication.user.dao.TabAccountDao;
import priv.guochun.psmc.authentication.user.model.TabAccount;
import priv.guochun.psmc.system.framework.dao.IDaoTemplate;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.ContantsUtil;

public class TabAccountDaoImplMybatis implements TabAccountDao
{
 
    protected static final  Logger logger  = LoggerFactory.getLogger(TabAccountDaoImplMybatis.class);
    
    public static final String getTabAccountByCondition="getTabAccountByCondition";
    public static final String accountUniqueValidate="accountUniqueValidate";
    public static final String getMyPageOfTabAccounts = "getMyPageOfTabAccounts";
    public static final String deletesAccounts ="deletesAccounts";
    public static final String insertAccount ="insertAccount";
    public static final String updateAccount ="updateAccount";
    
    private SqlSessionTemplate sqlSession;
    private IDaoTemplate iDaoTemplate;
    
    @Override
    public Map getTabAccount(String id)
    {
        Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("uuid", id);
        Map map = (Map)sqlSession.selectOne(getTabAccountByCondition,condition);
        return map;
    }
    
    public Map getTabAccountByPhone(String phone){
    	Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("telephone", phone);
        Map map = (Map)sqlSession.selectOne(getTabAccountByCondition,condition);
        return map;
    }
    
    
    @Override
    public Map getTabAccount(String username, String password)
    {
        Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("accountName", username);
        condition.put("accountPass", password);
        Map map = (Map)sqlSession.selectOne(getTabAccountByCondition,condition);
        return map;
    }

    @Override
    public List accountUniqueValidate(String username, String accountUuid)
    {
        Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("username", username);
        condition.put("accountUuid", accountUuid);
        List list  = sqlSession.selectList(accountUniqueValidate,condition);
        return list;
    }


    @Override
	 public MyPage getMyPageOfTabAccounts(MyPage mapage){
        Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("dict_no", ContantsUtil.DICTY_TYPE_SEX);
        //查询参数添加
        if(mapage.getQueryParams()!=null && mapage.getQueryParams().size()>0){
        	condition.putAll(mapage.getQueryParams());
        }
    	return iDaoTemplate.getMyPage(mapage, getMyPageOfTabAccounts, condition);
	 }

    @Override
    public void deletesAccounts(String ids)
    {
        Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("ids", ids.split(","));
        sqlSession.delete(deletesAccounts, condition);
    }

    @Override
    public void saveOrUpdateAccount(TabAccount tabAccount)
    {
      if(tabAccount == null || StringUtils.isBlank(tabAccount.getUuid())){
          throw new IllegalArgumentException("主键为空,无法进行对象持久化操作!");
      }
      String id = tabAccount.getUuid();
      Map map = this.getTabAccount(id);
      if(map !=null)
          sqlSession.update(updateAccount,tabAccount);
      else
          sqlSession.insert(insertAccount,tabAccount);
    }

    public SqlSessionTemplate getSqlSession()
    {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession)
    {
        this.sqlSession = sqlSession;
    }

    public IDaoTemplate getiDaoTemplate()
    {
        return iDaoTemplate;
    }

    public void setiDaoTemplate(IDaoTemplate iDaoTemplate)
    {
        this.iDaoTemplate = iDaoTemplate;
    }
    
    
    
}
