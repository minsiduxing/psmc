package priv.guochun.psmc.system.common.dict.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;

import priv.guochun.psmc.system.framework.dao.RootDao;

public class TabDataDictDaoImpl extends RootDao implements TabDataDictDao {

	
	@Override
	public List getDictDataList(Integer dict_type)throws Exception{
		String sql = getDictDataSql(dict_type,null);
		return this.getJdbcTemplate().queryForList(sql);
	}
	
	public List getDictDataList(String dict_no)throws Exception{
		String sql = getDictDataSql(null,dict_no);
		return this.getJdbcTemplate().queryForList(sql);
	}
	
	private String getDictDataSql(Integer dict_type,String dict_no){
		StringBuffer sb1 = new StringBuffer();
		sb1.append("select dict_id as id,dict_name as name ");
//		if(defaultValue!=null){
//			sb1.append(",(case when dict_id='"+defaultValue+"' then 'true' else 'false' end )  as \"selected\" ");
//		}
		
		sb1.append("  from tab_data_dict where 1=1 ");
		if(dict_type!=null){
			sb1.append(" and  dict_type = "+dict_type);
		}
		if(StringUtils.isNotBlank(dict_no)){
			sb1.append(" and  dict_no = '"+dict_no+"'");
		}
		
		sb1.append(" order by ordernum asc ");
		
		return sb1.toString();
	}
	
}
