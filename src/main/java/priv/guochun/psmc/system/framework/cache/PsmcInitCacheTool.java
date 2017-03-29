package priv.guochun.psmc.system.framework.cache;

/**
 * 缓存数据初始化接口 主要用于提供缓存数据加载的接口
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright ICSS(c) 2017</p>
 * @author <a href="mailTo:Guochun002@chinasofti.com">guochun</a>
 * @version 1.0
 * @history:
 * Created by guochun 2017-3-10
 */
public interface PsmcInitCacheTool
{
    /**
     * 系统所有许可操作的缓存数据初始化
     * <p>Description:<p>
     * @author guochun 2017-3-10
     */
    public void resourcePermitOperatesInit();
    
    /**
     * 数据字典缓存数据初始化
     */
    public void dataDictInit();
    
    /**
     * 属地缓存数据初始化
     */
    public void tabCityInit();
    
    /**
     * 统一缓存数据初始化入口,根据缓存数据的key进行数据初始化
     * <p>Description:<p>
     * @param key
     * @author guochun 2017-3-10
     */
    
    public void initCache(Object key);
    
    
}
