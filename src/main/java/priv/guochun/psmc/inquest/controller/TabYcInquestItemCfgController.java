package priv.guochun.psmc.inquest.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import priv.guochun.psmc.inquest.model.TabYcInquestItemCfg;
import priv.guochun.psmc.inquest.model.vo.TabYcInquestItemCfgVO;
import priv.guochun.psmc.inquest.service.TabYcInquestItemCfgService;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.JsonUtil;
import priv.guochun.psmc.website.backstage.attachment.service.TabAttachmentService;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 资格勘验配置
 *
 * @author wangtao
 * @date 2022/6/2
 */
@Controller
@RequestMapping("/inquest/tabYcInquestItemCfgController")
public class TabYcInquestItemCfgController extends MyController {

    @Autowired
    private TabYcInquestItemCfgService tabYcInquestItemCfgService;
    @Autowired
    private TabAttachmentService tabAttachmentService;

    /**
     * 查询勘验题目列表
     * @param myPage
     * @throws IOException
     */
    @RequestMapping(params="method=selectItemCfgList")
    @ResponseBody
    public void selectItemCfgList(MyPage myPage) throws IOException {
        myPage = tabYcInquestItemCfgService.selectItemCfgList(myPage);
        super.responseJson(JsonUtil.convertJavaBeanToJSONObject(myPage), this.response());
    }

    /**
     * 保存
     * @param inquestItemCfg
     * @throws IOException
     */
    @RequestMapping(params = "method=saveOrUpdateInquestItem")
    public void saveOrUpdateInquestItem(TabYcInquestItemCfg inquestItemCfg, String isEdit) throws IOException {
        tabYcInquestItemCfgService.saveOrUpdateInquestItem(inquestItemCfg);
        super.responseJson(true, "保存成功!", this.response());
    }

    /**
     * 删除勘验题目
     * @param itemUuids
     * @throws IOException
     */
    @RequestMapping(params = "method=deleteInquestItemById")
    public void deleteInquestItemById(String itemUuids) throws IOException {
        tabYcInquestItemCfgService.deleteInquestItemById(itemUuids);
        super.responseJson(true, "删除成功!", this.response());
    }

    /**
     * 跳转到勘验题目列表界面
     * @return
     */
    @RequestMapping(params="method=ycInquestItemCfgList")
    public String ycInquestItemCfgList(){
        return "inquest/ycInquestItemCfgList";
    }

    /**
     * 跳转到勘验题目编辑页面
     * @param uuid
     * @param isEdit
     * @param model
     * @return
     */
    @RequestMapping(params="method=ycInquestItemEdit")
    public String ycInquestItemEdit(String uuid, String isEdit, Model model){
        if(StringUtils.isNotBlank(uuid)){
            TabYcInquestItemCfgVO inquestItemCfgVO = tabYcInquestItemCfgService.getInquestItemById(uuid);
            if (StringUtils.isNotBlank(inquestItemCfgVO.getDisplayVidio())){
                inquestItemCfgVO.setVideoName(inquestItemCfgVO.getDisplayVidio().substring(inquestItemCfgVO.getDisplayVidio().lastIndexOf("/") + 1));
            }
            List<Map<String, Object>> attachmentList = tabAttachmentService.queryAttachmentList(uuid);
            if (attachmentList != null && attachmentList.size() > 0){
                StringBuffer attachmentUuids = new StringBuffer();
                for (int i=0; i<attachmentList.size(); i++) {
                    if (i > 0){
                        attachmentUuids.append(",");
                    }
                    attachmentUuids.append(attachmentList.get(i).get("attachment_uuid").toString());
                }
                inquestItemCfgVO.setAttachmentUuids(attachmentUuids.toString());
            }
            model.addAttribute("info", inquestItemCfgVO);
            model.addAttribute("attachmentList", attachmentList);
        }
        model.addAttribute("isEdit", isEdit);
        return "inquest/addYcInquestItem";
    }


}
