package priv.guochun.psmc.inquest.service;

import priv.guochun.psmc.system.framework.page.MyPage;

import java.util.List;
import java.util.Map;

/**
 * 网格管理
 */
public interface TabYcGridModelTypeService {


    /**
     * 分页查询网格数据
     * @param myPage
     * @return
     */
    public MyPage selectGridModelTypeInfoList(MyPage myPage);

    /**
     * 查询网格测算类别数据
     * @param myPage
     * @return
     */
    public List<Map<?,?>> loadGridModelTypeDictList(MyPage myPage);

}
