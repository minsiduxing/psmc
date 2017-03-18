package priv.guochun.psmc.system.common.dict.dao;

import java.util.List;

public interface TabDataDictDao {

	
	/**
	 * 通过字典类型获取数据字典
	 * @param dict_type
	 * @return
	 * @throws Exception
	 */
	public List getDictDataList(Integer dict_type)throws Exception;
	
	
	/**
	 * 通过字典编码获取数据字典
	 * @param dict_no
	 * @return
	 * @throws Exception
	 */
	public List getDictDataList(String dict_no)throws Exception;
	
	
	
	
}
