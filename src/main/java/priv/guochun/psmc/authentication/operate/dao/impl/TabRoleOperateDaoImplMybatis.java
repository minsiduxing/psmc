package priv.guochun.psmc.authentication.operate.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.authentication.operate.dao.TabRoleOperateDao;
import priv.guochun.psmc.system.framework.dao.IDaoTemplate;
import priv.guochun.psmc.system.util.MyStringUtil;

public class TabRoleOperateDaoImplMybatis implements TabRoleOperateDao
{
    protected static final  Logger logger  = LoggerFactory.getLogger(TabRoleOperateDaoImplMybatis.class);
    
    private SqlSessionTemplate sqlSession;
    private IDaoTemplate iDaoTemplate;
    
    public static final String deleteRoleOperateRelations="deleteRoleOperateRelations";
    public static final String getPrivilegDataListByRoleAndResource ="getPrivilegDataListByRoleAndResource";
    public static final String saveRoleResourceOperateRelationsTwo ="saveRoleResourceOperateRelationsTwo";
    public static final String selectRoleCountByOperate ="selectRoleCountByOperate";
    
    @Override
    public void deleteRoleOperateRelationByRoleUuids(String roleUuids)
    {
        Map<String,Object> condition4 = new HashMap<String,Object>();
        condition4.put("roleUuids", roleUuids.split(MyStringUtil.stringFormat));
        sqlSession.delete(deleteRoleOperateRelations,condition4);
    }
    
    @Override
    public void saveRoleResourceOperateRelations(String roleUuid,String resourceIds){
        
        deleteRoleOperateRelationByRoleUuids(roleUuid);

        Map<String,Object> condition4 = new HashMap<String,Object>();
        condition4.put("roleUuid", roleUuid);
        condition4.put("resourceIds", resourceIds.split(MyStringUtil.stringFormat));
        sqlSession.insert(saveRoleResourceOperateRelationsTwo,condition4);
    }
    
    
    @Override
    public List<Map<?,?>> getPrivilegDataListByRoleAndResource(String roleUuid,String resourceUuid){
        Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("roleUuid", roleUuid);
        condition.put("resourceUuid", resourceUuid);
        List<Map<?,?>> list = sqlSession.selectList(getPrivilegDataListByRoleAndResource,condition);
        return list;
    }

    @Override
    public int selectRoleCountByOperate(String operateUuid)
    {
        Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("operateUuid", operateUuid);
        int count = sqlSession.selectOne(selectRoleCountByOperate,condition);
        return count;
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
