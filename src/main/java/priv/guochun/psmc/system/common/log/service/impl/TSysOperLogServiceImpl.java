package priv.guochun.psmc.system.common.log.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;

import priv.guochun.psmc.system.common.log.dao.TSysOperLogMapper;
import priv.guochun.psmc.system.common.log.model.TSysOperLog;
import priv.guochun.psmc.system.common.log.service.TSysOperLogService;
import priv.guochun.psmc.system.framework.util.ReturnModel;

public class TSysOperLogServiceImpl implements TSysOperLogService {

	private SqlSession sqlSession;
	
	public JSONObject save(TSysOperLog tTSysOperLog){
		TSysOperLogMapper mapper = sqlSession.getMapper(TSysOperLogMapper.class);
		int flag = mapper.insert(tTSysOperLog);
		if(flag>0)
			return ReturnModel.createSuccessJSONObject("日志保存成功");
		else
			return ReturnModel.createFailJSONObject("日志保存失败");
	}

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	
}
