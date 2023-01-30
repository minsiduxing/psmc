package priv.guochun.psmc.inquest.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import priv.guochun.psmc.inquest.service.TabYcGridBaseInfoService;
import priv.guochun.psmc.inquest.service.TabYcGridCalculationModelService;
import priv.guochun.psmc.system.framework.dao.BaseDao;
import priv.guochun.psmc.system.framework.gd.GdWebApiService;
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
    @Autowired
    private GdWebApiService gdWebApiService;

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
    public MsgModel gridHanleCertCacl(String gridCmodelUuid, String gridUuid,Map<String,Object> param){
        return hanleCertCacl(gridCmodelUuid,gridUuid,param);
    }

    private MsgModel hanleCertCacl(String gridCmodelUuid,String gridUuid,Map<String,Object> param){
        String[] resultParam = new String[1];
        MsgModel rr;
        Map GridMap = tabYcGridBaseInfoService.queryGirdInfoByGridUuid(gridUuid);
        if(param !=null)
            GridMap.putAll(param);
        Map GridCmodelMap = queryGridCalculationModelBygridCmodelUuid(gridCmodelUuid);
        String GRID_NAME = GridMap.get("GRID_NAME").toString();
        String GRID_CMODEL_NAME = GridCmodelMap.get("GRID_CMODEL_NAME").toString();
        String RULE_TYPE_NAME = GridCmodelMap.get("RULE_TYPE_NAME").toString();
        String RULE_TYPE = GridCmodelMap.get("RULE_TYPE").toString();
        if("4".equals(RULE_TYPE) || "5".equals(RULE_TYPE) || "2".equals(RULE_TYPE)){
            MsgModel mm = gdWebApiService.walking(param);
            if(mm.isSuccess()){
                JSONObject routes = ((JSONObject)mm.getData()).getJSONObject("route");
                JSONArray paths = routes.getJSONArray("paths");
                String distance = paths.getJSONObject(0).getString("distance");
                if("4".equals(RULE_TYPE) || "5".equals(RULE_TYPE) || "2".equals(RULE_TYPE)){
                    GridMap.put("distance",distance);
                    resultParam[0] = distance;
                }
            }else{
                return mm;
            }
        }
        String expre = GridCmodelMap.get("RULE_FORMULA").toString();
        JSONObject tips = JSONObject.parseObject(GridCmodelMap.get("TIPS").toString());
        boolean result = false;
        StringBuffer sb1 = new StringBuffer();
        String reusltDesc;
        try{
            result = JetlUtil.execute(expre,GridMap);
            if(result){
                reusltDesc =tips.get("cacl_success").toString();
                rr = MsgModel.buildDefaultSuccess(String.format(reusltDesc,resultParam[0]),null);
            } else{
                reusltDesc =tips.get("process_failed").toString();
                rr = MsgModel.buildDefaultError(String.format(reusltDesc,resultParam[0]),null);
            }
        }catch(RuntimeException e){
            reusltDesc =RULE_TYPE_NAME+"测算异常:"+e.toString();
            rr = MsgModel.buildDefaultError(String.format(reusltDesc,resultParam[0]),null);
        }
        return rr;
    }

    public MsgModel gridHanleCertCacls(String gridUuid,Map<String, Object> param){
        StringBuffer sb1 = new StringBuffer();
        Map GridMap = tabYcGridBaseInfoService.queryGirdInfoByGridUuid(gridUuid);
        String GRID_MODEL_TYPE = GridMap.get("GRID_MODEL_TYPE").toString();
        List<Map> list = queryGridCalculationModelBygridModelTypeUuid(GRID_MODEL_TYPE);
        for(int i=0;i<list.size();i++){
            Map map = list.get(i);
            String GRID_CMODEL_UUID = map.get("GRID_CMODEL_UUID").toString();
            sb1.append(hanleCertCacl(GRID_CMODEL_UUID,gridUuid,param).getResult().getMsg());
        }
        return MsgModel.buildDefaultSuccess(sb1.toString(),null);
    }
}
