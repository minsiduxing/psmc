package priv.guochun.psmc.system.framework.dao;

import priv.guochun.psmc.system.framework.page.MyPage;


@Deprecated
public interface IDaoTemplate {

	
	/**
	 * 通过mybatis插件构建分页对象
	 * @param mapage 分页对象,仅包含起始行数和页数的分页对象
	 * @param statement 目标sqlid
	 * @param parameter 参数对象
	 * @return
	 */
	public MyPage getMyPage(MyPage mapage,String statement, Object parameter);
	
}
