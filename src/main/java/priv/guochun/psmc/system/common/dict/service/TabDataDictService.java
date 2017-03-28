package priv.guochun.psmc.system.common.dict.service;

import java.util.List;
import java.util.Map;

public interface TabDataDictService {
    
    /**
     * 获取系统所有的数据字典
     * @return
     */
    public List<Map<?,?>> getDictDataList();
    
    /**
     * 根据数据字典key获取当前数据字典信息
     * @param dict_no
     * @return
     */
	public List<Map<?,?>> getDictDataList(String dict_no);
	/**
	 * 根据数据字典id和类型获取某个数据字典对象
	 * @param id
	 * @return
	 */
	public Map<?,?> getDictDataById(String id,String dict_no);
	
}
