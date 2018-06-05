package priv.guochun.psmc.system.common.log.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.system.common.log.dao.TSysOperLogDao;
import priv.guochun.psmc.system.common.log.dao.TSysOperLogMapper;
import priv.guochun.psmc.system.common.log.model.TSysOperLog;
import priv.guochun.psmc.system.framework.dao.IDaoTemplate;
import priv.guochun.psmc.system.framework.page.MyPage;

public class TSysOperLogDaoImpl implements TSysOperLogDao   {
	
	protected static final  Logger logger  = LoggerFactory.getLogger(TSysOperLogDaoImpl.class);
	private SqlSessionTemplate sqlSession;
	private IDaoTemplate iDaoTemplate;
	
	public static final String getMyPageOfTSysOperLog="getMyPageOfTSysOperLog";
	
	
	public MyPage getMyPageOfTSysOperLog(MyPage myPage){
		 Map<String,Object> condition = new HashMap<String,Object>();
	       if(myPage.getQueryParams()!=null && myPage.getQueryParams().size()>0){
	           condition.putAll(myPage.getQueryParams());
	       }
	        return iDaoTemplate.getMyPage(myPage, getMyPageOfTSysOperLog, condition);
	}
	
	public int save(TSysOperLog tTSysOperLog){
		TSysOperLogMapper mapper = sqlSession.getMapper(TSysOperLogMapper.class);
		int flag = mapper.insert(tTSysOperLog);
		return flag;
	}
	

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}

	public IDaoTemplate getiDaoTemplate() {
		return iDaoTemplate;
	}

	public void setiDaoTemplate(IDaoTemplate iDaoTemplate) {
		this.iDaoTemplate = iDaoTemplate;
	}
	
	
	

}
