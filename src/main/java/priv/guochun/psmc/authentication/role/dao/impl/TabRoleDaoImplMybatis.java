package priv.guochun.psmc.authentication.role.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import priv.guochun.psmc.authentication.role.dao.TabRoleDao;
import priv.guochun.psmc.authentication.role.model.TabAccRole;
import priv.guochun.psmc.authentication.role.model.TabRole;
import priv.guochun.psmc.system.framework.dao.IDaoTemplate;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.MyStringUtil;

public class TabRoleDaoImplMybatis implements TabRoleDao {

	protected static final  Logger logger  = LoggerFactory.getLogger(TabRoleDaoImplMybatis.class);
    
    public static final String getTableRoleByCondition="getTableRoleByCondition";
    public static final String getAccountUnionRoleByAccount="getAccountUnionRoleByAccount";
    public static String getAccountUnionRoleByRoleUuids="getAccountUnionRoleByRoleUuids";
    public static final String getMyPageOfTabRoles="getMyPageOfTabRoles";
    public static final String deletesTabRole="deletesTabRole";
    public static final String deletesAccountsRoleRelationsByAccountUuids="deletesAccountsRoleRelationsByAccountUuids";
    public static final String deletesAccountsRoleRelationsByRoleUuids="deletesAccountsRoleRelationsByRoleUuids";
    
    
    public static final String insertTabRole="insertTabRole";
    public static final String updateTabRole="updateTabRole";
    public static final String roleUniqueValidate="roleUniqueValidate";
    
    public static final String saveAccRoleRelations="saveAccRoleRelations";
    
    
    
    private SqlSessionTemplate sqlSession;
    private IDaoTemplate iDaoTemplate;
	
	@Override
	public Map<?, ?> getTableRoleByUuid(String uuid) {
		Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("uuid", uuid);
        Map<?,?> map = sqlSession.selectOne(getTableRoleByCondition,condition);
        return map;
	}

	@Override
	public List<?> getAccountUnionRoleByAccount(String accountId) {
		Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("accUuid", accountId);
        List<?> list = sqlSession.selectList(getAccountUnionRoleByAccount,condition);
		return list;
	}
	
	
	public List<?> getAccountUnionRoleByRoleUuids(String roleUuids){
	    Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("roleUuids", roleUuids.split(MyStringUtil.stringFormat_comma));
        List<?> list = sqlSession.selectList(getAccountUnionRoleByRoleUuids,condition);
        return list;
	}

	   @Override
	    public MyPage getMyPageOfTabRoles(MyPage myPage)
	    {
	       Map<String,Object> condition = new HashMap<String,Object>();
	       if(myPage.getQueryParams()!=null && myPage.getQueryParams().size()>0){
	           condition.putAll(myPage.getQueryParams());
	       }
	        return iDaoTemplate.getMyPage(myPage, getMyPageOfTabRoles, condition);
	    }

	   public List<Map<?, ?>> getAllPageOfTabRoles(TabRole tabRole){
	       Map<String,Object> condition = new HashMap<String,Object>();
	       condition.put("roleNo", tabRole.getRoleNo());
	       condition.put("roleName", tabRole.getRoleName());
	       return  sqlSession.selectList(getMyPageOfTabRoles,condition);
	   }
	   
	   
	@Override
	public List<?> roleUniqueValidate(String uuid, String roleno){
		Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("uuid", uuid);
        condition.put("roleno", roleno);
        List<?> list = sqlSession.selectList(roleUniqueValidate,condition);
        return list;
	}
	
	
	public void saveOrUpdateTabRole(TabRole tabRole){
	    if(tabRole == null || StringUtils.isBlank(tabRole.getUuid())){
	          throw new IllegalArgumentException("主键为空,无法进行对象持久化操作!");
	      }
	      String id = tabRole.getUuid();
	      Map map = this.getTableRoleByUuid(id);
	      if(map !=null)
	          sqlSession.update(updateTabRole,tabRole);
	      else
	          sqlSession.insert(insertTabRole,tabRole);
	}

	
	public void deletesRoles(String uuids) {
		Map<String,Object> condition4 = new HashMap<String,Object>();
        condition4.put("ids", uuids.split(MyStringUtil.stringFormat_comma));
        sqlSession.delete(deletesTabRole,condition4);
	}
	
	
	 public void deletesAccountsRoleRelationsByAccountUuids(String accountUuids){
	     Map<String,Object> condition4 = new HashMap<String,Object>();
	     condition4.put("ids", accountUuids.split(MyStringUtil.stringFormat_comma));
	     sqlSession.delete(deletesAccountsRoleRelationsByAccountUuids,condition4);
	 }
	 
	 
    @Override
    public void deletesAccountsRoleRelationsByRoleUuids(String roleUuids)
    {
        Map<String,Object> condition4 = new HashMap<String,Object>();
        condition4.put("ids", roleUuids.split(MyStringUtil.stringFormat_comma));
        sqlSession.delete(deletesAccountsRoleRelationsByRoleUuids,condition4);
    }

    public void saveAccRoleRelations(String accUuid,String roleUuids){
	     List<TabAccRole> objList = new ArrayList<TabAccRole>();
	    String[] roleUuidObj =  roleUuids.split(MyStringUtil.stringFormat_comma);
	    for(int i=0;i<roleUuidObj.length;i++) {
	        TabAccRole  accRole = new TabAccRole();
	        accRole.setAccUuid(accUuid);
	        accRole.setRoleUuid(roleUuidObj[i]);
	        objList.add(accRole);
	    }
	    Map<String,Object> condition4 = new HashMap<String,Object>();
        condition4.put("ids", objList);
        sqlSession.insert(saveAccRoleRelations,condition4);
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
