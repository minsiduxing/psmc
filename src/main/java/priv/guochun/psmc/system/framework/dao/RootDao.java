package priv.guochun.psmc.system.framework.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;

public class RootDao implements RootDaoInterface {
    
    private static final  Logger logger  = LoggerFactory.getLogger(RootDao.class);

	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
    @Override
    public List<?> getListdataByJdbc(String sql, int start_line, int end_line)
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
