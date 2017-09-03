package priv.guochun.psmc.website.backstage.modulepublish.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;

import priv.guochun.psmc.website.backstage.modulepublish.dao.TabModulePublishDao;
import priv.guochun.psmc.website.backstage.modulepublish.model.TabModulePublish;

public class TabModulePublishDaoImpl implements TabModulePublishDao {
	 
    public static final String getListTabPublishModelByCondition="getListTabPublishModelByCondition";
    public static final String insertTabPublishModel="insertTabPublishModel";
    public static final String updateTabPublishModel="updateTabPublishModel";
    public static final String deletesTabPublishModelByUuid="deletesTabPublishModelByUuid";
    public static final String deletesTabPublishModelByModuleUuids="deletesTabPublishModelByModuleUuids";
    private SqlSessionTemplate sqlSession;
	@Override
	public void saveOrUpdateTabModulePublish(TabModulePublish tmp) {
	 if(tmp == null || StringUtils.isBlank(tmp.getPblishUuid())){
            throw new IllegalArgumentException("主键为空,无法进行对象持久化操作!");
        }
        String id = tmp.getPblishUuid();
        TabModulePublish map = this.getTabModulePublishByid(id);
        if(map !=null)
            sqlSession.update(updateTabPublishModel,tmp);
        else
            sqlSession.insert(insertTabPublishModel,tmp);
	}

	@Override
	public void deleteTabModulePublishByids(String ids) {
		Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("ids", ids.split(","));
        sqlSession.delete(deletesTabPublishModelByUuid, condition);
	}
	@Override
	public void deleteTabModulePublishByModuleids(String mids) {
		Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("ids", mids.split(","));
        sqlSession.delete(deletesTabPublishModelByModuleUuids, condition);
	}
	@Override
	public TabModulePublish getTabModulePublishByid(String id) {
		Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("pblishUuid", id);
        TabModulePublish map = (TabModulePublish)sqlSession.selectOne(getListTabPublishModelByCondition,condition);
        return map;
	}
	@Override
	public List<TabModulePublish> getTabModulePublishsByModuleids(String ids) {
		Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("modelUuids", ids.split(","));
		return sqlSession.selectList(getListTabPublishModelByCondition, condition);
	}
	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	

	

}
