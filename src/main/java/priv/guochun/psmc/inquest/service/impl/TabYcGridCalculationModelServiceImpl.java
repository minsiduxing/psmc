package priv.guochun.psmc.inquest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import priv.guochun.psmc.inquest.service.TabYcGridBaseInfoService;
import priv.guochun.psmc.inquest.service.TabYcGridCalculationModelService;
import priv.guochun.psmc.system.framework.dao.BaseDao;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.util.JetlUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 网格测算公式
 */
public class TabYcGridCalculationModelServiceImpl implements TabYcGridCalculationModelService {

    @Autowired
    private BaseDao baseDao;
    @Autowired
    private TabYcGridBaseInfoService tabYcGridBaseInfoService;

    private final String selectGridCalculationModelInfoList = "selectGridCalculationModelInfoList";

    public MyPage selectGridCalculationModelInfoList(MyPage myPage){
        Map<String,Object> condition = new HashMap<String,Object>();
        //查询参数添加
        if(myPage.getQueryParams()!=null && myPage.getQueryParams().size()>0){
            condition.putAll(myPage.getQueryParams());
        }
        myPage = baseDao.getMyPage(myPage,selectGridCalculationModelInfoList,condition);
        return myPage;
    }

    public Map queryGridCalculationModelBygridCmodelUuid(String gridCmodelUuid){
        Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("gridCmodelUuid",gridCmodelUuid);
        return (Map)baseDao.queryForObject(selectGridCalculationModelInfoList,condition);
    }

    public List<Map> queryGridCalculationModelBygridModelTypeUuid(String gridModelTypeUuid){
        Map<String,Object> condition = new HashMap<String,Object>();
        condition.put("gridModelType",gridModelTypeUuid);
        return (List<Map>)baseDao.queryForList(selectGridCalculationModelInfoList,condition);
    }
    public MsgModel gridHanleCertCacl(String gridCmodelUuid, String gridUuid){
        String result = hanleCertCacl(gridCmodelUuid,gridUuid);
        return MsgModel.buildDefaultSuccess(result,null);
    }

    private String hanleCertCacl(String gridCmodelUuid,String gridUuid){
        Map GridMap = tabYcGridBaseInfoService.queryGirdInfoByGridUuid(gridUuid);
        Map GridCmodelMap = queryGridCalculationModelBygridCmodelUuid(gridCmodelUuid);
        String GRID_NAME = GridMap.get("GRID_NAME").toString();
        String GRID_CMODEL_NAME = GridCmodelMap.get("GRID_CMODEL_NAME").toString();
        String  RULE_TYPE_NAME = GridCmodelMap.get("RULE_TYPE_NAME").toString();
        String expre = GridCmodelMap.get("RULE_FORMULA").toString();
        boolean result = JetlUtil.execute(expre,GridMap);
        StringBuffer sb1 = new StringBuffer();
        String reusltDesc = result == true?"成功":"失败";
        sb1.append("网格【"+GRID_NAME+"】").append("店面【"+GRID_CMODEL_NAME+"】").append(RULE_TYPE_NAME).append(reusltDesc);
        return sb1.toString();
    }

    public MsgModel gridHanleCertCacls(String gridUuid){
        StringBuffer sb1 = new StringBuffer();
        Map GridMap = tabYcGridBaseInfoService.queryGirdInfoByGridUuid(gridUuid);
        String GRID_NAME = GridMap.get("GRID_NAME").toString();
        String GRID_MODEL_TYPE = GridMap.get("GRID_MODEL_TYPE").toString();
        List<Map> list = queryGridCalculationModelBygridModelTypeUuid(GRID_MODEL_TYPE);
        for(int i=0;i<list.size();i++){
            Map map = list.get(i);
            String GRID_CMODEL_NAME = map.get("GRID_CMODEL_NAME").toString();
            String  RULE_TYPE_NAME = map.get("RULE_TYPE_NAME").toString();
            String expre = map.get("RULE_FORMULA").toString();
            boolean result = JetlUtil.execute(expre,GridMap);
            StringBuffer sb2 = new StringBuffer();
            String reusltDesc = result == true?"成功":"失败";
            sb2.append("网格【"+GRID_NAME+"】").append("店面【"+GRID_CMODEL_NAME+"】").append(RULE_TYPE_NAME).append(reusltDesc).append("</br>");
            sb1.append(sb2);
        }
        return MsgModel.buildDefaultSuccess(sb1.toString(),null);
    }
}
