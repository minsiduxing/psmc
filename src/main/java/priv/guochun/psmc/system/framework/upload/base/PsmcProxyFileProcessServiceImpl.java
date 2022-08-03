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
public class PsmcProxyFileProcessServiceImpl implements PsmcBaseFileProcessService {

    @Override
    public List<UploadFileModel> uploadFiles(HttpServletRequest request) throws IOException {
        return getRealFileProcessService().uploadFiles(request);
    }

    public UploadFileModel uploadFile(HttpServletRequest request) throws IOException{
        return getRealFileProcessService().uploadFile(request);
    }

    public Boolean deleteFile(String filePath) throws IOException {
        return getRealFileProcessService().deleteFile(filePath);
    }

    private PsmcBaseFileProcessService getRealFileProcessService (){
        PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
        Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
        Map<String, String> sysMap = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
        String file_service_type = sysMap.get("file_service_type").toString();
        return (PsmcBaseFileProcessService)MySpringApplicationContext.getObject("psmc"+file_service_type+"FileProcessService");
    }

}
