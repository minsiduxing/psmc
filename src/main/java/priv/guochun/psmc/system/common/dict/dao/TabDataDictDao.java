package priv.guochun.psmc.system.common.dict.dao;

import java.util.List;
import java.util.Map;

public interface TabDataDictDao {

	/**
	 * 通过字典编码获取数据字典
	 * @param dict_no
	 * @return
	 * @throws Exception
	 */
	public List<Map<?, ?>> getDictDataListByDictNo(String dict_no);
	
	
	
	
}
