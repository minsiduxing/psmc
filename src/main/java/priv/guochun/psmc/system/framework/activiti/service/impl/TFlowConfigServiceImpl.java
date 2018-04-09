package priv.guochun.psmc.system.framework.activiti.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import priv.guochun.psmc.system.framework.activiti.dao.TFlowConfigMapper;
import priv.guochun.psmc.system.framework.activiti.model.TFlowConfig;
import priv.guochun.psmc.system.framework.activiti.model.TFlowConfigExample;
import priv.guochun.psmc.system.framework.activiti.service.TFlowConfigService;

public class TFlowConfigServiceImpl implements TFlowConfigService {

	private SqlSession sqlSession;
	
	
	@Override
	public List<TFlowConfig> getAllTFlowConfig(TFlowConfigExample example) {
		TFlowConfigMapper tFlowConfigMapper = sqlSession.getMapper(TFlowConfigMapper.class);
		return tFlowConfigMapper.selectByExample(example);
	}
	
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
}
