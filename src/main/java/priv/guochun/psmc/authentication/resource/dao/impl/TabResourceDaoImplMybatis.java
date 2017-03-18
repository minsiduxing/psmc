package priv.guochun.psmc.authentication.resource.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.authentication.resource.dao.TabResourceDao;
import priv.guochun.psmc.authentication.resource.model.TabResource;


public class TabResourceDaoImplMybatis  implements TabResourceDao
{
	
	protected static final Logger logger = LoggerFactory
	.getLogger(TabResourceDaoImplMybatis.class);

	public static final String getSubResourcesByResourceId="getSubResourcesByResourceId";
    public static final String getResource="getResource";
    public static final String getSystemAllResourcesBelongRole="getSystemAllResourcesBelongRole";
    public static final String getResourcesBelongRole="getResourcesBelongRole";
    public static final String insertTabResource ="insertTabResource";
    public static final String updateTabResource ="updateTabResource";
    public static final String getTabResourceOrderNum ="getTabResourceOrderNum";
    public static final String deleteResource ="deleteResource";
    public static final String updateResourceTheParentUuid ="updateResourceTheParentUuid";
    public static final String updateResourceTheName ="updateResourceTheName";
    
	private SqlSessionTemplate sqlSession;

	@Override
	public List<Map<?,?>> getSubResourcesByResourceId(String resourceId,
			Integer resourceType, boolean ContainSelf, String roleId) {
			if(StringUtils.isBlank(resourceId)){
	    		String msg ="系统该方法参数为空!"; 
	    		logger.warn(msg);
	    		throw new NullPointerException(msg);
	    	}
		 	Map<String,Object> condition = new HashMap<String,Object>();
	        condition.put("resourceId", resourceId);
	        condition.put("resourceType", resourceType);
	        condition.put("roleId", roleId);
	        condition.put("ContainSelf", ContainSelf);

	        List<Map<?,?>> list =sqlSession.selectList(getSubResourcesByResourceId,condition);
	        return list;
	}

	@Override
	public Map<?,?> getResource(String resourceId, Integer resourceType,
			String roleId) {
		Map<String,Object> condition = new HashMap<String,Object>();
		condition.put("resourceId", resourceId);
        condition.put("resourceType", resourceType);
        condition.put("roleId", roleId);

        Map<?,?> map = (Map<?,?>)sqlSession.selectOne(getResource,condition);
        return map;
	}
	
	public List<Map<?,?>> getSystemAllResourcesBelongRole(String roleId){
	    Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("roleId", roleId);
        List<Map<?,?>> list =sqlSession.selectList(getSystemAllResourcesBelongRole,condition);
        return list;
	}
	
	
	public List<Map<?,?>> getResourcesBelongRole(String roleId){
        Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("roleId", roleId);
        List<Map<?,?>> list =sqlSession.selectList(getResourcesBelongRole,condition);
        return list;
    }
	
	 public void updateResourceTheParentUuid(String resourceUuid,String parentResourceUuid){
		 if(StringUtils.isBlank(updateResourceTheParentUuid) ||
				 StringUtils.isBlank(parentResourceUuid)){
	    		String msg ="系统该方法参数不能为空!"; 
	    		logger.warn(msg);
	    		throw new NullPointerException(msg);
	    	}
		 Map<String,Object> condition = new HashMap<String,Object>();
	     condition.put("resourceUuid", resourceUuid);
	     condition.put("parentResourceUuid", parentResourceUuid);
	     sqlSession.delete(updateResourceTheParentUuid,condition);

	 }
	 
	 public void updateResourceTheName(String resourceUuid,String newName){
		 if(StringUtils.isBlank(resourceUuid) ||StringUtils.isBlank(newName)){
	    		String msg ="系统该方法参数不能为空!"; 
	    		logger.warn(msg);
	    		throw new NullPointerException(msg);
	     }
		 Map<String,Object> condition = new HashMap<String,Object>();
	     condition.put("resourceUuid", resourceUuid);
	     condition.put("newName", newName);
	     sqlSession.delete(updateResourceTheName,condition);
		 
	 }
	 
	 
	
	
	 public void saveResource(TabResource tabResource){
	     sqlSession.insert(insertTabResource,tabResource);
	 }
	
	 public void updateResource(TabResource tabResource){
	     sqlSession.update(updateTabResource,tabResource);
	 }
	 
	 public Integer getTabResourceOrderNum(){
	    Integer result =  sqlSession.selectOne(getTabResourceOrderNum);
	    return result;
	 }
	 

	@Override
	public void deleteResource(String resourceUuid) {
		Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("resourceUuid", resourceUuid);
        sqlSession.delete(deleteResource,condition);
	}

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

   

	

    
}
