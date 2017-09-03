package priv.guochun.psmc.website.backstage.module.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;

import priv.guochun.psmc.website.backstage.module.dao.TabModuleDao;
import priv.guochun.psmc.website.backstage.module.model.TabModule;

public class TabModuleDaoImpl implements TabModuleDao {
    public static final String insertTabModel="insertTabModel";
    public static final String updateTabModel="updateTabModel";
    public static final String getListTabModelByCondition="getListTabModelByCondition";
    public static final String deletesTabModelByUuid="deletesTabModelByUuid";
  
    private SqlSessionTemplate sqlSession;
	@Override
	public void saveOrUpdateTabModule(TabModule tam) {
	    if(tam == null || StringUtils.isBlank(tam.getModelUuid())){
            throw new IllegalArgumentException("主键为空,无法进行对象持久化操作!");
        }
        String id = tam.getModelUuid();
        Map<String,Object> map = this.getModuleByUuid(id);
        if(map !=null)
            sqlSession.update(updateTabModel,tam);
        else
            sqlSession.insert(insertTabModel,tam);
	}
	@SuppressWarnings("unchecked")
	@Override
	public Map<String, Object> getModuleByUuid(String id) {
		Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("modelUuid", id);
        Map<String,Object> map = (Map<String,Object>)sqlSession.selectOne(getListTabModelByCondition,condition);
        return map;
	}

	@Override
	public void deleteTabModule(String ids) {
		Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("ids", ids.split(","));
        sqlSession.delete(deletesTabModelByUuid, condition);
	}

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}


}
