package priv.guochun.psmc.authentication.user.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.authentication.user.dao.TabPersonDao;
import priv.guochun.psmc.authentication.user.model.TabPerson;

public class TabPersonDaoImplMybatis implements TabPersonDao
{

    protected static final  Logger logger  = LoggerFactory.getLogger(TabPersonDaoImplMybatis.class);
    
    public static final String getTabPersonByCondition="getTabPersonByCondition";
    public static final String deletesTabPersons="deletesTabPersons";
    public static final String updateTabPerson="updateTabPerson";
    public static final String insertTabPerson="insertTabPerson";
    
    private SqlSessionTemplate sqlSession;

    @Override
    public Map getTabPersonByUuid(String uuid)
    {
        Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("uuid", uuid);
        Map map = (Map)sqlSession.selectOne(getTabPersonByCondition,condition);
        return map;
    }

    @Override
    public Map getTabPersonByAccountId(String id)
    {
        Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("accUuid", id);
        Map map = (Map)sqlSession.selectOne(getTabPersonByCondition,condition);
        return map;
    }

    @Override
    public void deleteTabPersonsByAccUuids(String accUuids)
    {
        Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("ids", accUuids.split(","));
        sqlSession.delete(deletesTabPersons, condition);
        
    }
    
    @Override
    public void saveOrUpdatePerson(TabPerson tabPerson)
    {
        if(tabPerson == null || StringUtils.isBlank(tabPerson.getUuid())){
            throw new IllegalArgumentException("主键为空,无法进行对象持久化操作!");
        }
        String id = tabPerson.getUuid();
        Map map = this.getTabPersonByUuid(id);
        if(map !=null)
            sqlSession.update(updateTabPerson,tabPerson);
        else
            sqlSession.insert(insertTabPerson,tabPerson);
    }
    
    @Override
    public List<Object> getTabPersonByGroupid(String groupid)
    {
        Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("groupid", groupid);
        List<Object> list = sqlSession.selectList(getTabPersonByCondition,condition);
        return list;
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
