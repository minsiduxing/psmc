package priv.guochun.psmc.system.framework.upload.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.cache.Cache;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;
import priv.guochun.psmc.system.framework.upload.base.PsmcBaseFileProcessService;
import priv.guochun.psmc.system.framework.upload.factory.MyCommonsMultipartResolverFactory;
import priv.guochun.psmc.system.framework.upload.model.UploadFileModel;
import priv.guochun.psmc.system.framework.upload.util.FastdfsUtils;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PsmcFastdfstProcessServiceImpl implements PsmcBaseFileProcessService {

    private CommonsMultipartResolver multipartResolver;

    @Override
    public List<UploadFileModel> uploadFiles(HttpServletRequest request) throws IOException {
        List<UploadFileModel> files = new ArrayList<UploadFileModel>();
        //创建一个通用的多部分解析器
        multipartResolver = MyCommonsMultipartResolverFactory.getInstance().createCommonsMultipartResolver(request);
        //判断 request 是否有文件上传,即多部分请求
        if(multipartResolver.isMultipart(request)) {
            PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
            Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
            Map<String, String> sysMap = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
            //转换成多部分request
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
            Iterator<String> iter = multiRequest.getFileNames();
            while(iter.hasNext()){
                UploadFileModel model = new UploadFileModel();
                //取得上传文件
                MultipartFile file = multiRequest.getFile(iter.next());
                //取得当前上传文件的文件名称
                String myFileName = file.getOriginalFilename();
                if(myFileName.trim() !="" &&myFileName.indexOf(".") != -1){
                    String filename = myFileName.substring(0,myFileName.indexOf("."));
                    String suffix = myFileName.substring(myFileName.indexOf(".")+1,myFileName.length());
                    model.setFileRealName(filename);
                    model.setSuffix(suffix);
                }
                byte[] fileB = file.getBytes();
                String [] result = FastdfsUtils.uploadFile(fileB,myFileName,fileB.length);
                StringBuffer sb1 = new StringBuffer();
                for(int i=0;i<result.length;i++){
                    sb1.append(result[i]);
                    if(i<result.length-1)
                        sb1.append("/");
                }
                model.setFileSystemName(result[1]);
                model.setFile_upload_real_path(sb1.toString());
                model.setFileCompleteUrl(sysMap.get("file_prefix_path").toString()+ sb1.toString());
                files.add(model);
            }
        }
        return files.size()>0?files:null;
    }

    public UploadFileModel uploadFile(HttpServletRequest request) throws IOException{
        List<UploadFileModel> uploadFiles = uploadFiles(request);
        return  uploadFiles !=null?uploadFiles.get(0):null;
    }

    public Boolean deleteFile(String filePath){
        PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
        Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
        Map<String, String> sysMap = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
        String file_prefix_path = sysMap.get("file_prefix_path").toString();
        if(StringUtils.isNotBlank(filePath)){
            filePath = filePath.replaceAll(file_prefix_path,"");
            String groupName = filePath.substring(0,filePath.indexOf("/"));
            String realFilePath = filePath.substring(filePath.indexOf("/")+1,filePath.length());
            return FastdfsUtils.deleteFile(groupName,realFilePath);
        }
        return false;
    }
}
