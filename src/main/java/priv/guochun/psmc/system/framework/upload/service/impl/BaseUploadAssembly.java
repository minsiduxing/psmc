package priv.guochun.psmc.system.framework.upload.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;
import priv.guochun.psmc.system.framework.upload.factory.MyCommonsMultipartResolverFactory;
import priv.guochun.psmc.system.framework.upload.model.UploadFileModel;
import priv.guochun.psmc.system.framework.upload.service.UploadAssemblyInterface;
import priv.guochun.psmc.system.framework.upload.util.PSMCFileUtils;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;
import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.SystemPropertiesUtil;

public class BaseUploadAssembly implements UploadAssemblyInterface
{

    public static final Logger logger  = LoggerFactory.getLogger(BaseUploadAssembly.class.getName());
    
    private  CommonsMultipartResolver multipartResolver;
    
    public void UploadAssembly(){
       
    }
    
    @Override
    public List<UploadFileModel> getFiles(HttpServletRequest request)throws IllegalStateException, IOException
    {
        List<UploadFileModel> files = new ArrayList<UploadFileModel>();
        //创建一个通用的多部分解析器  
         multipartResolver =MyCommonsMultipartResolverFactory.getInstance().createCommonsMultipartResolver(request);
        //判断 request 是否有文件上传,即多部分请求  
          if(multipartResolver.isMultipart(request)){
              PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
              Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
              Map<String, String> sysMap = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
              String system_upload_dir =sysMap.get("system_upload_dir").toString();
              //转换成多部分request    
              MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
              String imagePath = (String) request.getAttribute("imagePath");
              //取得request中的所有文件名  
              Iterator<String> iter = multiRequest.getFileNames();  
              Map<String, MultipartFile> map = multiRequest.getFileMap();
              while(iter.hasNext()){
                  UploadFileModel model = new UploadFileModel();
                  //取得上传文件  
                  MultipartFile file = multiRequest.getFile(iter.next());  
                  if(file != null){
                      //取得当前上传文件的文件名称  
                      String myFileName = file.getOriginalFilename();  
                      if(myFileName.trim() !="" &&myFileName.indexOf(".") != -1){
                          String filename = myFileName.substring(0,myFileName.indexOf("."));
                          String suffix = myFileName.substring(myFileName.indexOf(".")+1,myFileName.length());
                          model.setFileRealName(filename);
                       
                          String fileSystemName = DateUtil.getCurrentDateTime()+"-"+filename;
                          model.setFileSystemName(fileSystemName);
                          model.setSuffix(suffix);
                          
                          //重命名上传后的文件名  
                          String fileSuffix = model.getSuffix();
                          String cutomFilePath = fileSystemName + "." + fileSuffix;
                          if(StringUtils.isNotBlank(imagePath)){
                        	  cutomFilePath = imagePath + cutomFilePath;
                          }
                          String fileTempAllPath = SystemPropertiesUtil.getUploadTempPathPropertyValue() +cutomFilePath; 
                          String fileRealAllPath =system_upload_dir+cutomFilePath;
//                          
                          //如果文件为图片则新建image文件夹
                          if(PSMCFileUtils.isPicture(fileSuffix)){
                        	  cutomFilePath = "image/" + cutomFilePath;
                        	  fileRealAllPath = system_upload_dir+cutomFilePath;
                          }
                          File localFile = new File(fileTempAllPath);  
                          if(!localFile.exists()){
                        	  localFile.mkdirs();
                          }
                          file.transferTo(localFile);
                          model.setTemp_file_path(fileTempAllPath);
                          model.setFile_upload_real_path(fileRealAllPath);
                          model.setFile(localFile);
                          model.setCustom_file_path(cutomFilePath);
                          files.add(model);
                      }else{
                          logger.warn("文件不存在.............file name is null ");
                      }
                  }else{
                      logger.warn("文件不存在..............file is null ");
                  }
              }
              return files;
              }else{
                  logger.warn("无文件上传!");
                  return null;
              }
    }

    @Override
    public UploadFileModel getFile(HttpServletRequest request)throws IllegalStateException, IOException
    {
        List<UploadFileModel> list  = getFiles(request);
        if(list !=null && list.size()>0) {
                return list.get(0);
        }else {
            logger.warn("文件不存在..............");
            return null;
        }
    }  
}
