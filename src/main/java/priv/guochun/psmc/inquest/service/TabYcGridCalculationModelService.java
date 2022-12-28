package priv.guochun.psmc.inquest.service;

import org.json.JSONObject;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.page.MyPage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 网格测算公式
 */
public interface TabYcGridCalculationModelService {
    /**
     * 分页查询网格数据
     * @param myPage
     * @return
     */
    MyPage selectGridCalculationModelInfoList(MyPage myPage);

    /**
     *
     * @param gridCmodelUuid
     * @return
     */
    public Map queryGridCalculationModelBygridCmodelUuid(String gridCmodelUuid);

    /**
     * 根据模型对应的测算类别加载所有的类别计算公式
     * @param gridModelType
     * @return
     */
    public List<Map> queryGridCalculationModelBygridModelTypeUuid(String gridModelType);

    /**
     * 测算某网格下的某公式计算结果
     * @param gridCmodelUuid
     * @param gridUuid
     */
    public MsgModel gridHanleCertCacl(String gridCmodelUuid, String gridUuid);

    /**
     * 测算某网格下的所有公式计算结果
     * @param gridUuid
     */
    public MsgModel  gridHanleCertCacls(String gridUuid);

}
