package priv.guochun.psmc.inquest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import priv.guochun.psmc.inquest.service.TabYcRegionCoordinateService;
import priv.guochun.psmc.system.framework.dao.BaseDao;
import priv.guochun.psmc.system.framework.page.MyPage;

import java.util.HashMap;
import java.util.Map;

/**
 * @description 区域坐标服务实现类
 * @author wangt
 * @create 2022/12/28 16:13
 */
public class TabYcRegionCoordinateServiceImpl implements TabYcRegionCoordinateService {

    @Autowired
    private BaseDao baseDao;

    @Override
    public MyPage selectRegionCoordinatePage(MyPage page) {
        Map<String,Object> condition = new HashMap<String,Object>();
        //查询参数添加
        if(page.getQueryParams()!=null && page.getQueryParams().size()>0){
            condition.putAll(page.getQueryParams());
        }
        return baseDao.getMyPage(page, "selectRegionCoordinatePage", condition);
    }
}
