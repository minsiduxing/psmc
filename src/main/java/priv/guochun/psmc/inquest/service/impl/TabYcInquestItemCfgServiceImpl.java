package priv.guochun.psmc.inquest.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import priv.guochun.psmc.inquest.model.TabYcInquestItemCfg;
import priv.guochun.psmc.inquest.model.TabYcInquestOptionCfg;
import priv.guochun.psmc.inquest.model.TabYcStage;
import priv.guochun.psmc.inquest.model.vo.TabYcInquestItemCfgVO;
import priv.guochun.psmc.inquest.service.TabYcInquestItemCfgService;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.website.backstage.attachment.service.TabAttachmentService;
import priv.guochun.psmc.system.framework.dao.BaseDao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 资格勘验题目配置服务
 *
 * @author wangtao
 * @date 2022/6/1
 */
public class TabYcInquestItemCfgServiceImpl implements TabYcInquestItemCfgService {

    @Autowired
    private BaseDao baseDao;
    @Autowired
    private TabAttachmentService tabAttachmentService;

    @Override
    public void saveOrUpdateInquestItem(TabYcInquestItemCfg ycInquestItemCfg){
        if (StringUtils.isNotBlank(ycInquestItemCfg.getStageCode())){
            Map<String, Object> param = new HashMap<>();
            param.put("stageCode",ycInquestItemCfg.getStageCode() );
            TabYcStage stage = (TabYcStage) baseDao.queryForObject("selectStageList", param);
            ycInquestItemCfg.setStageUuid(stage == null ? "" : stage.getStageUuid());
        }
        if (StringUtils.isBlank(ycInquestItemCfg.getItemUuid())){
            ycInquestItemCfg.setItemUuid(UUIDGenerator.createUUID());
            ycInquestItemCfg.setCreateTime(new Date());
            ycInquestItemCfg.setActive(true);
            baseDao.insert("insertInquestItemCfg", ycInquestItemCfg);
        }else {
            baseDao.update("updateInquestItemCfg", ycInquestItemCfg);
        }
        tabAttachmentService.updateBusinessUuidToAttachment(ycInquestItemCfg.getItemUuid(), ycInquestItemCfg.getAttachmentUuids());
    }


    public void saveOrUpdateInquestOption(List<TabYcInquestOptionCfg> optionCfgList, String itemUuid){
        if (optionCfgList != null && optionCfgList.size() > 0){
            Map<String, String> param = new HashMap<>();
            param.put("itemUuid", itemUuid);
            baseDao.delete("deleteOptionByItemUuid", param);
            for (TabYcInquestOptionCfg optionCfg : optionCfgList) {
                optionCfg.setItemUuid(itemUuid);
                optionCfg.setActive(true);
                optionCfg.setCreateTime(new Date());
                baseDao.insert("insertInquestOptionCfg", optionCfg);
            }
        }
    }

    @Override
    public MyPage selectItemCfgList(MyPage myPage){
        Map<String,Object> condition = new HashMap<String,Object>();
        //查询参数添加
        if(myPage.getQueryParams()!=null && myPage.getQueryParams().size()>0){
            condition.putAll(myPage.getQueryParams());
        }
        return baseDao.getMyPage(myPage, "selectItemCfgList", condition);
    }

    @Override
    public TabYcInquestItemCfgVO getInquestItemById(String itemUuid){
        Map<String, String> param = new HashMap<>();
        param.put("itemUuid", itemUuid);
        return (TabYcInquestItemCfgVO) baseDao.queryForObject("getInquestItemById", param);
    }

    @Override
    public void deleteInquestItemById(String itemUuids){
        Map<String, Object> param = new HashMap<>();
        param.put("itemUuids", itemUuids.split(","));
        baseDao.delete("deleteOptionByItemUuid", param);
        baseDao.delete("deleteInquestItemById", param);
    }

}
