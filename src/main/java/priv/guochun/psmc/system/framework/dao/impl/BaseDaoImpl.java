package priv.guochun.psmc.system.framework.dao.impl;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;

import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.framework.dao.BaseDao;

public class BaseDaoImpl implements BaseDao {

	private SqlSessionTemplate sqlSession;
	
	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public int delete(String statementName, Object parameterObject) {
		return sqlSession.delete(statementName, parameterObject);
	}

	@Override
	public int delete(String statementName) {
		return sqlSession.delete(statementName);
	}

	@Override
	public int insert(String statementName, Object parameterObject){
		return sqlSession.insert(statementName, parameterObject);
	}


	@Override
	public List queryForList(String statementName, Object parameterObject) {
		return sqlSession.selectList(statementName, parameterObject);
	}

	@Override
	public List queryForList(String statementName) {
		return sqlSession.selectList(statementName);
	}

	@Override
	public Object queryForObject(String statementName, Object parameterObject) {
		return sqlSession.selectOne(statementName, parameterObject);
	}

	@Override
	public Object queryForObject(String statementName) {
		return sqlSession.selectOne(statementName);
	}

	@Override
	public int update(String statementName, Object parameterObject) {
		return sqlSession.update(statementName, parameterObject);
	}

	@Override
	public int update(String statementName) {
		return sqlSession.update(statementName);
	}
	
	@Override
	public MyPage getMyPage(MyPage myPage, String statement, Object parameter) {
		  if(myPage!=null){
			  List<?> list = sqlSession.selectList(statement,parameter,
						new RowBounds(myPage.getPageIndex(),myPage.getPageSize()));
			  myPage.buildMyPage(list);
			  return myPage;
		  }else{
			  throw new IllegalArgumentException("myPage参数为空,无法进行分页查询!");
		  }  
	}

}