package priv.guochun.psmc.system.common.city.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import priv.guochun.psmc.system.framework.dao.RootDao;

public class CityDaoImpl extends RootDao implements CityDao {

    private static final  Logger logger  = LoggerFactory.getLogger(CityDaoImpl.class.getName());

	@Override
	public List getAllCity() {
		return this.getJdbcTemplate().queryForList("select * from tab_city ");
	}

	@Override
	public List getSubRegionByCityId(String[] ids, boolean containMySelf, boolean containSub) throws Exception {

		if(ids == null || ids.length<=0)
			throw new Exception("属地ids参数传递错误,id["+ids+"]");
		
		StringBuffer idSb = new StringBuffer();
		for(int i=0;i<ids.length;i++){
			idSb.append("'"+ids[i]+"'");
			if(i<ids.length)
				idSb.append(",");
		}
		String idstr = idSb.substring(0,idSb.lastIndexOf(","));

		
		StringBuffer sb1 = new StringBuffer();
		sb1.append(" select distinct  a.city_id as id,a.city_name as name, ");
		sb1.append(" a.parent_id as pid,(case when b.city_id is not null then 'true' else 'false' end) \"isParent\" ,a.ordernum ");
		sb1.append(" from tab_city  a left join tab_city b on a.city_id=b.parent_id  ");
		sb1.append(" where 1=1   ");
		
		
		
		if(containMySelf && containSub)
		{
			sb1.append(" and ( a.city_id in("+idstr+") or a.parent_id in("+idstr+") )");
			
		}else if(containMySelf && !containSub)
		{
			sb1.append(" and  a.city_id in("+idstr+") ");
		}else if(!containMySelf && containSub)
		{
			sb1.append(" and  a.parent_id in("+idstr+") ");
		}else
			sb1.append(" and 1=2 ");
		
		sb1.append(" order by a.ordernum asc  ");
		
		logger.debug("fun getSubRegionByCityId sql "+sb1.toString());
		
		return this.getJdbcTemplate().queryForList(sb1.toString());
	}

}
