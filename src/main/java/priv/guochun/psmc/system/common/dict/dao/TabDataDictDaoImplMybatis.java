package priv.guochun.psmc.system.common.dict.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TabDataDictDaoImplMybatis   implements TabDataDictDao {

    
    protected static final  Logger logger  = LoggerFactory.getLogger(TabDataDictDaoImplMybatis.class);
    
    public static final String getDictDataList="getDictDataList";
    
    private SqlSessionTemplate sqlSession;
	
	
	public List<Map<?, ?>> getDictDataListByDictNo(String dict_no){
        Map<String,Object> condition = new HashMap<String,Object>();
        if(StringUtils.isBlank(dict_no)){
            condition.put("dictNo", dict_no);
        }
        List<Map<?, ?>> list = sqlSession.selectList(getDictDataList, condition);
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
