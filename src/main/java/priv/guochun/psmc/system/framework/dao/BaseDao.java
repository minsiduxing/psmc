package priv.guochun.psmc.system.framework.dao;

import java.util.List;

import priv.guochun.psmc.system.framework.page.MyPage;

public interface BaseDao {

	/**
	 * 插入一条记录
	 * @param SQL语句ID号
	 * @param parameterObject 要插入的对象(map javaBean)
	 */
	public int insert(String statementName, Object parameterObject);
	
	/**
	 * 查询一条记录
	 * @param SQL语句ID号
	 * @param parameterObject 查询条件对象(map javaBean)
	 */
	public Object queryForObject(String statementName, Object parameterObject);
	
	/**
	 * 查询一条记录
	 * @param SQL语句ID号
	 */
	public Object queryForObject(String statementName);
	
	/**
	 * 查询记录集合
	 * @param SQL语句ID号
	 * @param parameterObject 查询条件对象(map javaBean)
	 */
	public List queryForList(String statementName, Object parameterObject);
	
	/**
	 * 查询记录集合
	 * @param SQL语句ID号
	 */
	public List queryForList(String statementName);
	
	/**
	 * 更新记录
	 * @param SQL语句ID号
	 * @param parameterObject 更新对象(map javaBean)
	 */
	public int update(String statementName, Object parameterObject);
	
	/**
	 * 更新记录
	 * @param SQL语句ID号
	 */
	public int update(String statementName);
	
	/**
	 * 删除记录
	 * @param SQL语句ID号
	 * @param parameterObject 更新对象(map javaBean)
	 */
	public int delete(String statementName, Object parameterObject);
	
	/**
	 * 删除记录
	 * @param SQL语句ID号
	 */
	public int delete(String statementName);
	
	/**
	 * 通过mybatis插件构建分页对象
	 * @param mapage 分页对象,仅包含起始行数和页数的分页对象
	 * @param statement 目标sqlid
	 * @param parameter 参数对象
	 * @return
	 */
	public MyPage getMyPage(MyPage mapage,String statement, Object parameter);

}
