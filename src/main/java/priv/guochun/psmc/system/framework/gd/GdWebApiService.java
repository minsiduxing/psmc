package priv.guochun.psmc.system.framework.gd;

import priv.guochun.psmc.system.framework.model.MsgModel;

import java.util.Map;

public interface GdWebApiService {

    /**
     * 高德步行规划服务
     * @param url
     * @param param
     * @return
     */
    public MsgModel walking(Map<String,Object> param);

    /**
     * 高德距离测量服务
     * @param param
     * @return
     */
    public MsgModel distances(Map<String,Object> param);
}
