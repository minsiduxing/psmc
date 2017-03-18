package priv.guochun.psmc.authentication.operate.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.authentication.operate.dao.TabOperateDao;

public class TabOperateDaoImplMybatis implements TabOperateDao {

	protected static final Logger logger = LoggerFactory
			.getLogger(TabOperateDaoImplMybatis.class);

	public static final String getTabOperatesByCondition = "getTabOperatesByCondition";
	public static final String getPermitOperatesByRoleUuid = "getPermitOperatesByRoleUuid";
	public static final String deleteTabOperatesByResourceUuid ="deleteTabOperatesByResourceUuid";
	private SqlSessionTemplate sqlSession;

	
	
	@Override
    public List<Map<?, ?>> getTabOperates(String roleUuid, String resourceUuid)
    {
	    Map<String, Object> condition = new HashMap<String, Object>();
        condition.put("roleUuid", roleUuid);
        condition.put("resourceUuid", resourceUuid);
        return sqlSession.selectList(getTabOperatesByCondition, condition);
    }

    @Override
	public List<Map<?, ?>> getPermitOperatesByRoleUuid(String roleUuid) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("roleUuid", roleUuid);
		return sqlSession.selectList(getPermitOperatesByRoleUuid, condition);
	}
	
	
	public void deleteTabOperatesByResourceUuid(String resourceUuid){
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("resourceUuid", resourceUuid);
		sqlSession.delete(deleteTabOperatesByResourceUuid, condition);
	}
	

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

}
