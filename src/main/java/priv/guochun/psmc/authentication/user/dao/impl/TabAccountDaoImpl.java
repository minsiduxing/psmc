package priv.guochun.psmc.authentication.user.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.authentication.user.dao.TabAccountDao;
import priv.guochun.psmc.authentication.user.model.TabAccount;
import priv.guochun.psmc.system.framework.dao.RootDao;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.ContantsUtil;
import priv.guochun.psmc.system.util.MyStringUtil;

public class TabAccountDaoImpl extends RootDao implements TabAccountDao
{
	protected static final  Logger logger  = LoggerFactory.getLogger(TabAccountDaoImpl.class);

    @Override
    public Map getTabAccount(String id)
    {
       StringBuffer sb1 = new StringBuffer();
       sb1.append("SELECT * FROM  TAB_ACCOUNTS where 1=1  and UUID='"+id+"'");
       logger.debug("query sql "+ sb1.toString());
       return this.getJdbcTemplate().queryForMap(sb1.toString());
    }

    @Override
    public Map getTabAccount(String username, String password)
    {
        StringBuffer sb1 = new StringBuffer();
        sb1.append("SELECT * FROM  TAB_ACCOUNTS where 1=1 ");
        if(StringUtils.isNotBlank(username)){
            sb1.append(" and ACCOUNT_NAME='"+username+"'");
        }
        if(StringUtils.isNotBlank(password)){
            sb1.append(" and ACCOUNT_PASS='"+password+"'");
        }
        logger.debug("query sql "+ sb1.toString());
        return this.getJdbcTemplate().queryForMap(sb1.toString());
    }
    
    public List accountUniqueValidate(String username,String accountUuid){
    	StringBuffer sb1 = new StringBuffer();
        sb1.append("SELECT * FROM  TAB_ACCOUNTS where 1=1 ");
        if(StringUtils.isNotBlank(username)){
            sb1.append(" and ACCOUNT_NAME='"+username+"'");
        }
        if(StringUtils.isNotBlank(accountUuid)){
            sb1.append(" and UUID<>'"+accountUuid+"'");
        }
        logger.debug("query sql "+ sb1.toString());
        return this.getJdbcTemplate().queryForList(sb1.toString());
    }
    
	 @Override
	 public MyPage getMyPageOfTabAccounts(MyPage myPage){
		return null;
	 }
	
	private String getTabAccountsSql(){
		StringBuffer sb1 = new StringBuffer();
	    sb1.append(" select a.uuid as acc_uuid,a.account_name,a.account_pass,a.is_locked,  ");
	    sb1.append(" b.uuid as person_id,b.person_name,b.sex,b.age,b.telephone,b.email,c.dict_name as sexName ");
	    sb1.append("  from tab_accounts a ,tab_person b  ");
	    sb1.append(" left join tab_data_dict c on b.sex=c.dict_id  ");
	    sb1.append(" and c.dict_no='"+ContantsUtil.DICTY_TYPE_SEX+"' ");
	    sb1.append("  ");
	    sb1.append("  where a.uuid=b.acc_uuid ");
	    return sb1.toString();
	}

	@Override
	public void deletesAccounts(String ids) {
		 String newId = MyStringUtil.StringFormatMethod(ids);
		 if(newId == null)
			 return;
		 StringBuffer sb1 = new StringBuffer();
	     sb1.append("DELETE FROM  TAB_ACCOUNTS where 1=1  and UUID in "+newId);
	     logger.debug("query sql "+ sb1.toString());
	     this.getJdbcTemplate().execute(sb1.toString());
	}

    @Override
    public void saveOrUpdateAccount(TabAccount tabAccount)
    {
       this.getHibernateTemplate().saveOrUpdate(tabAccount);
    }
	
	
}
