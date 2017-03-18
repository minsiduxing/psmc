package priv.guochun.psmc.system.common.dict.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TabDataDictDaoImplMybatis   implements TabDataDictDao {

    
    protected static final  Logger logger  = LoggerFactory.getLogger(TabDataDictDaoImplMybatis.class);
    
    public static final String getDictDataList="getDictDataList";
    
    private SqlSessionTemplate sqlSession;
	
	@Override
	public List getDictDataList(Integer dict_type)throws Exception{
	    Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("dictType", dict_type);
        List list = sqlSession.selectList(getDictDataList, condition);
        return list;
	}
	
	public List getDictDataList(String dict_no)throws Exception{
	    Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("dictNo", dict_no);
        List list = sqlSession.selectList(getDictDataList, condition);
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
