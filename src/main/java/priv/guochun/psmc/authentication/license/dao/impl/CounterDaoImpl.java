package priv.guochun.psmc.authentication.license.dao.impl;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;

import priv.guochun.psmc.authentication.license.dao.CounterDao;
import priv.guochun.psmc.system.framework.dao.RootDao;

public class CounterDaoImpl extends RootDao implements CounterDao {
	protected static final Logger logger = LoggerFactory
			.getLogger(CounterDaoImpl.class);

	@Override
	public void setCount(int minutes) {
	    this.getJdbcTemplate().execute( "delete from tab_count ");
	    this.getJdbcTemplate().execute( "insert into tab_count (minutes) values(" + minutes+ ")");
	
	}

	@Override
	public int getCount() {

	    List<Map<String,Object>> list = null;
		try {
		     list = this.getJdbcTemplate().queryForList("SELECT minutes FROM  tab_count");
		     if(list != null && list.size()>0 && list.get(0)!=null &&!"".equals(list.get(0).get("minutes"))){
		         Integer minutes = Integer.parseInt(list.get(0).get("minutes").toString());
		         return minutes;
		     }else
		         return 0;
		} catch (DataAccessException e) {
			return 0;
		}
	}

	@Override
	public int decCount() {

		int minutes = this.getCount();
		minutes--;
		if (minutes < 1) {
			return 0;
		}
		this.setCount(minutes);
		return minutes;
	}

}
