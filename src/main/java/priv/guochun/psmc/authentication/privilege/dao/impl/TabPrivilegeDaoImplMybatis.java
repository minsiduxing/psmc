package priv.guochun.psmc.authentication.privilege.dao.impl;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.authentication.privilege.dao.TabPrivilegeDao;

public class TabPrivilegeDaoImplMybatis implements TabPrivilegeDao
{
    protected static final Logger logger = LoggerFactory
            .getLogger(TabPrivilegeDaoImplMybatis.class);

    public static final String queryTabPrivilegeForCombboox="queryTabPrivilegeForCombboox";
   
    private SqlSessionTemplate sqlSession;

    @Override
    public List  queryTabPrivilegeForCombboox()
    {
        return sqlSession.selectList(queryTabPrivilegeForCombboox);
    }
    
    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }
}
