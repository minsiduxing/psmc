package priv.guochun.psmc.authentication.user.dao.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.authentication.user.dao.TabPersonDao;
import priv.guochun.psmc.authentication.user.model.TabPerson;
import priv.guochun.psmc.system.framework.dao.RootDao;
import priv.guochun.psmc.system.util.MyStringUtil;

public class TabPersonDaoImpl extends RootDao implements TabPersonDao
{

	protected static final  Logger logger  = LoggerFactory.getLogger(TabPersonDaoImpl.class);

    @Override
    public Map getTabPersonByUuid(String uuid)
    {
    	String sql = getTabPersonSql(uuid,null);
        return this.getJdbcTemplate().queryForMap(sql);
    }

    @Override
    public Map getTabPersonByAccountId(String id)
    {
        String sql = getTabPersonSql(null,id);
        return this.getJdbcTemplate().queryForMap(sql);
    }
    
    private String getTabPersonSql(String uuid,String acc_uuid){
    	StringBuffer sb1 = new StringBuffer();
    	sb1.append("SELECT a.*,b.city_name FROM  TAB_PERSON a,tab_city b where 1=1 ");
    	sb1.append(" and a.city_id=b.city_id ");
    	if(StringUtils.isNotBlank(uuid))
    		sb1.append(" and uuid='"+uuid+"' ");
    	if(StringUtils.isNotBlank(acc_uuid))
    		sb1.append(" and acc_uuid='"+acc_uuid+"' ");
    	return sb1.toString();
    }
    
    @Override
    public void deleteTabPersonsByAccUuids(String accUuids){
    	String newId = MyStringUtil.StringFormatMethod(accUuids);
		 if(newId == null)
			 return;
		 StringBuffer sb1 = new StringBuffer();
	     sb1.append("DELETE FROM  TAB_PERSON where 1=1  and ACC_UUID in "+newId);
	     logger.debug("query sql "+ sb1.toString());
	     this.getJdbcTemplate().execute(sb1.toString());
    }

    @Override
    public void saveOrUpdatePerson(TabPerson tabPerson)
    {
        this.getHibernateTemplate().saveOrUpdate(tabPerson);
        
    }
    

}
