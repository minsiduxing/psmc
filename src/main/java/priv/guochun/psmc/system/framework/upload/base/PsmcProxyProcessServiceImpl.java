package priv.guochun.psmc.system.framework.upload.base;

import org.springframework.cache.Cache;
import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;
import priv.guochun.psmc.system.framework.upload.model.UploadFileModel;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * psmc代理服务，主要是实现运行期的切换
 */
public class PsmcProxyProcessServiceImpl implements PsmcBaseFileProcessService {

    @Override
    public List<UploadFileModel> uploadFiles(HttpServletRequest request) throws IOException {
        return getObj().uploadFiles(request);
    }

    public UploadFileModel uploadFile(HttpServletRequest request) throws IOException{
        return getObj().uploadFile(request);
    }

    public Boolean deleteFile(String filePath) throws IOException {
        return getObj().deleteFile(filePath);
    }

    private PsmcBaseFileProcessService getObj (){
        PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
        Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
        Map<String, String> sysMap = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
        String file_service_type = sysMap.get("file_service_type").toString();
        return (PsmcBaseFileProcessService)MySpringApplicationContext.getObject("psmc"+file_service_type+"FileProcessService");
    }

}
