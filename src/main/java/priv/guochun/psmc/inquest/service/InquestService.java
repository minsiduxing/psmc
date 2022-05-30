package priv.guochun.psmc.inquest.service;

import org.springframework.web.bind.annotation.RequestBody;
import priv.guochun.psmc.inquest.model.TabYcInquestRecord;
import priv.guochun.psmc.inquest.model.TabYcStage;
import priv.guochun.psmc.inquest.model.vo.TabYcInquestItemCfgVO;
import priv.guochun.psmc.inquest.utils.ResultInfo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * 勘验服务
 *
 * @author wangtao
 * @date 2022/5/24
 */
@Path("/inquestWechatService")
@Produces({MediaType.APPLICATION_JSON})
public interface InquestService {

    /**
     * 小程序获取手机号
     * @param code
     * @return
     */
    @Path("/getPhoneNo")
    @GET
    ResultInfo getPhoneNo(@QueryParam("code")String code);

    /**
     * 小程序登录获取openid、sessionKey等
     * @param js_code
     * @return
     */
    @GET
    @Path("/codeToSession")
    ResultInfo codeToSession(@QueryParam("js_code")String js_code, @QueryParam("mobile")String mobile);

    /**
     * 查询勘验题目列表
     * @param tabYcInquestItemCfgVO
     * @return
     */
    @POST
    @Path("/findInquestItemList")
    ResultInfo findInquestItemList(@RequestBody TabYcInquestItemCfgVO tabYcInquestItemCfgVO);

    /**
     * 查询勘验阶段信息
     * @param stage
     * @return
     */
    @POST
    @Path("/selectStageList")
    ResultInfo selectStageList(@RequestBody TabYcStage stage);

    /**
     * 保存或更新勘验记录
     * @param record
     * @return
     */
    @POST
    @Path("/saveOrUpdateInquestRecord")
    ResultInfo saveOrUpdateInquestRecord(@RequestBody TabYcInquestRecord record);

    /**
     * 获取字典信息
     * @param dictNo
     * @return
     */
    @GET
    @Path("/getDictInfo")
    ResultInfo getDictInfo(@QueryParam("dictNo") String dictNo);
}
