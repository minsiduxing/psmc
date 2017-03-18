package priv.guochun.psmc.system.framework.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;

import priv.guochun.psmc.system.util.PageNoUtil;

public class RootDao implements RootDaoInterface {
    
    private static final  Logger logger  = LoggerFactory.getLogger(RootDao.class);

	private HibernateTemplate hibernateTemplate;
	
	private JdbcTemplate jdbcTemplate;
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void saveModel(Object obj) {
		this.getHibernateTemplate().save(obj);
	}
	
	public void updateModel(Object obj) {
		this.getHibernateTemplate().update(obj);
	}

	public void deleteModel(Object obj) {
		this.getHibernateTemplate().delete(obj);
	}
	
	public void saveOrUpdateModel(Object obj) {
        this.getHibernateTemplate().saveOrUpdate(obj);
    }
	
	/*
	 * 不建议使用hiebernate查询
	 */
	@Deprecated 
	public List getListdata(final String hql,final int page_index, final int maxLength) {
		List list1 = getHibernateTemplate().execute(
				new  HibernateCallback() {
					public Object doInHibernate(Session session)throws HibernateException {
						List list2 = PageNoUtil. getList(session,hql,page_index,maxLength);
						return list2;
					}
				}
		);
		return list1;
	}
	
	/*
     * 不建议使用hiebernate查询
     */
	@Deprecated
	public int getCount(String hql,String[] args) {

		List list = this.getHibernateTemplate().find(hql, args);
		if(list!=null && list.size()>0){
			Object obj = list.iterator().next();
			if(obj!=null)
				return ((Long)obj).intValue();
			else
				return 0;
		}else
			return 0;
	}

    @Override
    public List getListdataByJdbc(String sql, int start_line, int end_line)
    {
        StringBuffer sb1 = new StringBuffer();
        sb1.append(" select *  from ( ");
            sb1.append(" select a.*,rownum as index_id from ( "+sql +" ) a ");
        sb1.append("  ) where index_id>"+start_line+" and index_id<="+end_line);
        logger.debug("enter getListdataByJdbc 查询分页数据sql :"+sb1.toString());
        return this.jdbcTemplate.queryForList(sb1.toString());
    }

    @Override
    public int getCountByJdbc(String sql)
    {
        StringBuffer sb1 = new StringBuffer();
        sb1.append(" select count(*) as total from ( ");
        sb1.append(sql);
        sb1.append(" ) ");
        logger.debug("enter getCountByJdbc 查询总数sql :"+sb1.toString());
        return Integer.parseInt(this.getJdbcTemplate().queryForMap(sb1.toString()).get("total").toString());
    }

	
	
	
	
	
	
}
