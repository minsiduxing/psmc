package priv.guochun.psmc.system.framework.upload.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import priv.guochun.psmc.system.framework.upload.factory.MyCommonsMultipartResolverFactory;
import priv.guochun.psmc.system.framework.upload.model.UploadFileModel;
import priv.guochun.psmc.system.framework.upload.service.UploadAssemblyInterface;
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
              //转换成多部分request    
              MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
              //取得request中的所有文件名  
              Iterator<String> iter = multiRequest.getFileNames();  
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
                          String fileTempAllPath = SystemPropertiesUtil.getUploadTempPathPropertyValue() +fileSystemName+"."+model.getSuffix(); 
                          String fileRealAllPath = SystemPropertiesUtil.getUploadPathPropertyValue() +fileSystemName+"."+model.getSuffix(); 
                          File localFile = new File(fileTempAllPath);  
                          file.transferTo(localFile);
                          model.setTemp_file_path(fileTempAllPath);
                          model.setFile_upload_real_path(fileRealAllPath);
                          model.setFile(localFile);
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
