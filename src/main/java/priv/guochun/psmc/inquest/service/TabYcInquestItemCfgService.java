package priv.guochun.psmc.inquest.service;

import priv.guochun.psmc.inquest.model.TabYcInquestItemCfg;
import priv.guochun.psmc.inquest.model.vo.TabYcInquestItemCfgVO;
import priv.guochun.psmc.system.framework.page.MyPage;

import java.util.List;

/**
 * 资格勘验题目配置
 *
 * @author wangtao
 * @date 2022/5/31
 */
public interface TabYcInquestItemCfgService {

    /**
     * 保存或者更新题目信息
     * @param ycInquestItemCfg
     */
    void saveOrUpdateInquestItem(TabYcInquestItemCfg ycInquestItemCfg);

    /**
     * 查询题目列表
     * @param myPage
     * @return
     */
    MyPage selectItemCfgList(MyPage myPage);

    /**
     * 根据id查询题目详情
     * @param itemUuid
     * @return
     */
    TabYcInquestItemCfgVO getInquestItemById(String itemUuid);

    /**
     * 根据id删除题目配置信息
     * @param itemUuids
     */
    void deleteInquestItemById(String itemUuids);

}
