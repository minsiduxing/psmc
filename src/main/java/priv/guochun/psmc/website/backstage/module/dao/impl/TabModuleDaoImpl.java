package priv.guochun.psmc.website.backstage.module.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;

import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.website.backstage.module.dao.TabModuleDao;
import priv.guochun.psmc.website.backstage.module.model.TabModule;

public class TabModuleDaoImpl implements TabModuleDao {
    public static final String insertTabModel="insertTabModel";
    public static final String updateTabModel="updateTabModel";
    public static final String getListTabModelByCondition="getListTabModelByCondition";
    public static final String deletesTabModelByUuid="deletesTabModelByUuid";
    public static final String relaeaseTabModel="relaeaseTabModel";
    public static final String auditTabModel="auditTabModel";
    public static final String undoTabModel = "undoTabModel";
  
    private SqlSessionTemplate sqlSession;
	@Override
	public void saveOrUpdateTabModule(TabModule tam) {
	    if(tam == null || StringUtils.isBlank(tam.getModelUuid())){
            throw new IllegalArgumentException("主键为空,无法进行对象持久化操作!");
        }
        String id = tam.getModelUuid();
        TabModule  map = this.getModuleByUuid(id);
        if(map !=null)
            sqlSession.update(updateTabModel,tam);
        else
            sqlSession.insert(insertTabModel,tam);
	}
	@Override
	public TabModule getModuleByUuid(String id) {
		Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("modelUuid", id);
        TabModule map = (TabModule)sqlSession.selectOne(getListTabModelByCondition,condition);
        return map;
	}
	@Override
	public List<TabModule> getModulesByUuids(String ids) {
		Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("modelUuids", ids.split(","));
		return sqlSession.selectList(getListTabModelByCondition, condition);
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
	@Override
	public void excuteAudiTabModules(String ids, TabModule tam) {
		Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("ids", ids.split(","));
        condition.put("modifyDate", tam.getModifyDate());
        condition.put("auditAccUuid", tam.getAuditAccUuid());
        condition.put("modifyAccUuid", tam.getModifyAccUuid());
        condition.put("audit", tam.getAudit());
        condition.put("auditDate", tam.getAuditDate());
        sqlSession.update(auditTabModel, condition);
	}
	@Override
	public void excuteReleaseTabModules(String ids, TabModule tam) {
		Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("ids", ids.split(","));
        condition.put("modifyDate", tam.getModifyDate());
        condition.put("releaseAccUuid", tam.getReleaseAccUuid());
        condition.put("modifyAccUuid", tam.getModifyAccUuid());
        condition.put("releaseStatus", tam.getReleaseStatus());
        condition.put("releaseDate", DateUtil.getCurrentTimstamp());
        sqlSession.update(relaeaseTabModel, condition);
	}
	
	@Override
	public void executeUndoTabModules(String ids, TabModule tam) {
		Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("ids", ids.split(","));
        condition.put("modifyDate", tam.getModifyDate());
        condition.put("modifyAccUuid", tam.getModifyAccUuid());
        condition.put("auditAccUuid", tam.getAuditAccUuid());
        condition.put("audit", tam.getAudit());
        condition.put("auditDate", tam.getAuditDate());
        condition.put("releaseAccUuid", tam.getReleaseAccUuid());
        condition.put("releaseStatus", tam.getReleaseStatus());
        condition.put("releaseDate", tam.getReleaseDate());
        sqlSession.update(undoTabModel, condition);
	}
}
