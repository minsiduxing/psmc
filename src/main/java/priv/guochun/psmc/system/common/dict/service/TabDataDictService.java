package priv.guochun.psmc.system.common.dict.service;

import priv.guochun.psmc.system.framework.page.MyPage;

import java.util.List;
import java.util.Map;

public interface TabDataDictService {
    
    /**
     * 获取系统所有的数据字典（初始化用）
     * @return
     */
    public List<Map<?,?>> getDictDataList();
    
    /**
     * 从缓存获取根据数据字典key获取当前数据字典信息
     * @param dict_no
     * @param parentDictType 上级字典类别
     * @return
     */
	public List<Map<?,?>> getDictDataList(String dict_no,String parentDictType);

    /**
     * 从数据库中得到分页的数据字典
     * @param page
     * @return
     */
    public MyPage getDictDataList(MyPage page);
}
