package priv.guochun.psmc.system.common.city.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CityDaoImplMybatis implements CityDao {

    protected static final  Logger logger  = LoggerFactory.getLogger(CityDaoImplMybatis.class);
    
    public static final String getAllCity="getAllCity";
    public static final String getSubRegionByCityId="getSubRegionByCityId";
    
    private SqlSessionTemplate sqlSession;
    
    
    @Override
    public List<Map<?, ?>> getSubRegionByCityId(String[] ids,
            boolean containMySelf, boolean containSub) throws Exception {
          Map<String,Object> condition = new HashMap<String,Object>();
          condition.put("cityIds", ids);
          condition.put("containMySelf", containMySelf);
          condition.put("containSub", containSub);
          List<Map<?,?>> list = sqlSession.selectList(getSubRegionByCityId,condition);
        return list;
    }

    public SqlSessionTemplate getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }
    
    

}
