package priv.guochun.psmc.system.framework.activiti.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import priv.guochun.psmc.system.framework.activiti.dao.TFlowConfigMapper;
import priv.guochun.psmc.system.framework.activiti.dao.TFlowInstanceMapper;
import priv.guochun.psmc.system.framework.activiti.model.TFlowConfig;
import priv.guochun.psmc.system.framework.activiti.model.TFlowConfigExample;
import priv.guochun.psmc.system.framework.activiti.service.TFlowConfigService;
import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;

public class TFlowConfigServiceImpl implements TFlowConfigService {

	private SqlSession sqlSession;

	private PsmcCacheFactory psmcCacheFactory;
	@Override
	public List<TFlowConfig> getAllTFlowConfig(TFlowConfigExample example) {
		TFlowConfigMapper tFlowConfigMapper = sqlSession.getMapper(TFlowConfigMapper.class);
		return tFlowConfigMapper.selectByExample(example);
	}

	@Override
	public List<TFlowConfig> getWorkFlowDefinition() {
		List<TFlowConfig> list = psmcCacheFactory.getWorkFlow().get(CacheContants.CACHE_SYSTEM_WORKFOLW_DEFINITION,List.class);
		return list;
	}

	public TFlowConfig getWorkFlowDefinition(String flowEnName){
		TFlowConfig result = null;
		List<TFlowConfig> list = getWorkFlowDefinition();
		if(list !=null && list.size()>0){
			for(int i=0;i<list.size();i++){
				TFlowConfig obj = list.get(i);
				if(obj.getFlowEnName().equals(flowEnName)){
					result = obj;
					break;
				}
			}
		}
		return result;
	}

	public void update(TFlowConfig tFlowConfig){
		TFlowConfigMapper mapper = sqlSession.getMapper(TFlowConfigMapper.class);
		mapper.updateByPrimaryKey(tFlowConfig);
	}

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	public PsmcCacheFactory getPsmcCacheFactory() {
		return psmcCacheFactory;
	}

	public void setPsmcCacheFactory(PsmcCacheFactory psmcCacheFactory) {
		this.psmcCacheFactory = psmcCacheFactory;
	}
}
