package priv.guochun.psmc.system.common.dict.service;

import java.util.List;
import java.util.Map;

public interface TabDataDictService {


	
	public List getDictDataList(int dict_type);
	
	public Map getDictDataMapByIdAsKey(int dict_type);
	
	public Map getDictDataMapByNameAsKey(int dict_type);
	
	public List getDictDataList(String dict_no);
	
}
