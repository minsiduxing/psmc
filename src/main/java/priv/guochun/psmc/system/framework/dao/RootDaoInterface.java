package priv.guochun.psmc.system.framework.dao;

import java.util.List;



public interface RootDaoInterface {
    
	/**
	 * 获取分页数据
	 * <p>Description:<p>
	 * @param sql
	 * @param start_line 起始行数
	 * @param start_line 终止行数
	 * @return
	 * @author guochun 2016-7-27
	 */

	public List<?> getListdataByJdbc(String sql,int start_line, int end_line);
	
	/**
     * 包装获取分页数据
     * <p>Description:<p>
     * @param hql
     * @param page_index
     * @param page_length
     * @return
     * @author guochun 2016-7-27
     */

    public int getCountByJdbc(String sql);
	
}
