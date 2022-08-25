package priv.guochun.psmc.authentication.resource.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.authentication.operate.model.TabRoleOperate;
import priv.guochun.psmc.authentication.resource.dao.TabRoleResourceDao;
import priv.guochun.psmc.authentication.resource.model.TabRoleResource;
import priv.guochun.psmc.system.framework.dao.IDaoTemplate;
import priv.guochun.psmc.system.util.MyStringUtil;

public class TabRoleResourceDaoImplMybatis implements TabRoleResourceDao
{
    
    protected static final  Logger logger  = LoggerFactory.getLogger(TabRoleResourceDaoImplMybatis.class);
    
    private SqlSessionTemplate sqlSession;
    private IDaoTemplate iDaoTemplate;
    
    public static final String deleteRoleResoureRelations="deleteRoleResoureRelations";
    public static final String saveResourcesRoleRelations ="saveResourcesRoleRelations";
    public static final String deleteRRORelationsByRoleUuidWithResourceUuid ="deleteRRORelationsByRoleUuidWithResourceUuid";
    public static final String saveRoleResourceOperateRelations ="saveRoleResourceOperateRelations";
    public static final String  getRoleResourceRelations ="getRoleResourceRelations";
    
    @Override
    public void deleteRoleResouceRelationByRoleUuids(String roleUuids)
    {
        Map<String,Object> condition4 = new HashMap<String,Object>();
        condition4.put("roleUuids", roleUuids.split(MyStringUtil.stringFormat_comma));
        sqlSession.delete(deleteRoleResoureRelations,condition4);
    }
    
    @Override
    public void saveResourcesRoleRelations(String roleUuid, String resourceIds)
    {
           List<TabRoleResource> list = new ArrayList<TabRoleResource>();
           if(!"".equals(resourceIds)){
               String[] resourceIdObj = resourceIds.split(",");
               for(int i=0;i<resourceIdObj.length;i++){
                   TabRoleResource tr = new TabRoleResource();
                   tr.setResourceId(resourceIdObj[i]);
                   tr.setRoleId(roleUuid);
                   list.add(tr);
               }
           }
           deleteRoleResouceRelationByRoleUuids(roleUuid);
           
           if(list.size()>0){
               Map<String,Object> condition = new HashMap<String,Object>();
               condition.put("ids", list);
               sqlSession.insert(saveResourcesRoleRelations,condition);
           }
    }

    
    public void deleteRRORelationsByRoleUuidWithResourceUuid(String roleUuid,String resourceId){
    	Map<String,Object> condition4 = new HashMap<String,Object>();
        condition4.put("roleUuid",roleUuid);
        condition4.put("resourceId",resourceId);
        sqlSession.delete(deleteRRORelationsByRoleUuidWithResourceUuid,condition4);
    }
    
    
    public void saveRoleResourceOperateRelations(String roleUuid,String resourceUuid,
    		String operate_uuids){
    	
    	List<TabRoleOperate> list = new ArrayList<TabRoleOperate>();
        if(!"".equals(operate_uuids)){
            String[] operateIdObj = operate_uuids.split(",");
            for(int i=0;i<operateIdObj.length;i++){
            	TabRoleOperate to = new TabRoleOperate();
            	to.setOperateUuid(operateIdObj[i].toString());
            	to.setRoleUuid(roleUuid);
                list.add(to);
            }
        }
        
        //删除该角色所拥有的 某一个资源下的所有操作
        deleteRRORelationsByRoleUuidWithResourceUuid(roleUuid,resourceUuid);
        
        //保存该角色所拥有的 某一个资源下的所选操作
        if(list.size()>0){
            Map<String,Object> condition = new HashMap<String,Object>();
            condition.put("ids", list);
            sqlSession.insert(saveRoleResourceOperateRelations,condition);
        }
    }
    
    public List<Map<?,?>> getRoleResourceRelations(String resourceUuid){
        Map<String,Object> condition4 = new HashMap<String,Object>();
        condition4.put("resourceUuid",resourceUuid);
        List<Map<?,?>> list = sqlSession.selectList(getRoleResourceRelations,condition4);
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

    public IDaoTemplate getiDaoTemplate()
    {
        return iDaoTemplate;
    }

    public void setiDaoTemplate(IDaoTemplate iDaoTemplate)
    {
        this.iDaoTemplate = iDaoTemplate;
    }

    
    
}
