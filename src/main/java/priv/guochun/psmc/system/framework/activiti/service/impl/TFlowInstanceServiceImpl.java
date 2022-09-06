package priv.guochun.psmc.system.framework.activiti.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;

import priv.guochun.psmc.system.framework.activiti.dao.TFlowInstanceMapper;
import priv.guochun.psmc.system.framework.activiti.model.TFlowInstance;
import priv.guochun.psmc.system.framework.activiti.service.TFlowInstanceService;
import priv.guochun.psmc.system.framework.util.ReturnModel;

public class TFlowInstanceServiceImpl implements TFlowInstanceService {

	private SqlSession sqlSession;
	
	@Override
	public JSONObject save(TFlowInstance tFlowInstance) {
		TFlowInstanceMapper mapper = sqlSession.getMapper(TFlowInstanceMapper.class);
		int flag = mapper.insert(tFlowInstance);
		if(flag>0)
			return ReturnModel.createSuccessJSONObject("流程实例保存成功");
		else
			return ReturnModel.createFailJSONObject("流程实例保存失败");
	}

	public void update(TFlowInstance tFlowInstance) {
		TFlowInstanceMapper mapper = sqlSession.getMapper(TFlowInstanceMapper.class);
		mapper.updateByPrimaryKey(tFlowInstance);
	}

	public TFlowInstance getTFlowInstanceBytfiId(String tfiId) {

		TFlowInstanceMapper mapper = sqlSession.getMapper(TFlowInstanceMapper.class);
		return mapper.selectByPrimaryKey(tfiId);
	}
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	
}
