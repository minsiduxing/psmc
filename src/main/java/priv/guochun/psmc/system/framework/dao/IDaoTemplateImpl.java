package priv.guochun.psmc.system.framework.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.system.framework.page.MyPage;

public class IDaoTemplateImpl implements IDaoTemplate {
	
	protected static final  Logger logger  = LoggerFactory.getLogger(IDaoTemplateImpl.class);
    
    private SqlSessionTemplate sqlSession;
    
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

	public SqlSessionTemplate getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	

}
