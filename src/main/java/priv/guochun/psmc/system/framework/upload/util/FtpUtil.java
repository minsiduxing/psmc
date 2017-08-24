package priv.guochun.psmc.system.framework.upload.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.log4j.Logger;
import org.springframework.cache.Cache;

import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;
import priv.guochun.psmc.system.framework.upload.model.FtpModel;
import priv.guochun.psmc.system.framework.upload.model.UploadFileModel;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;
import priv.guochun.psmc.system.util.SystemPropertiesUtil;

/**
 * <p>Title:文件上传ftp工具 </p>
 * <p>Description:该类为 文件上传ftp工具其中支持的方法有：
 * 1、读取缓存中的文件上传配置。2、配置文件读取文件配置
 * 3、封装ftp的model对象。4、上传文件返回文件路径，5、删除文件。
 * 6、删除文件夹。7、连接文件服务器。8、关闭连接
 * 9、下载文件（返回文件）10、下载文件（返回二进制流）</p>
 * <p>Copyright: Copyright ICSS(c) 2017</p>
 * @author <a href="mailTo:18829012118@126.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2017年8月21日
 */
public class FtpUtil {
 	private static final Logger logger = Logger.getLogger(FtpUtil.class);
    private FTPClient ftpClient;
    private static FtpUtil util;
   
    
	
    /**
     * <p>Description:初始化工具类<p>
     * @return 工具类
     * @author wanglei 2017年8月21日
     */
    public static final FtpUtil getFtputil (){
    	if(null==util){
    		util = new FtpUtil();
    	}
    	return util;
    }
    private FtpUtil(){}
    /**
     * <p>Description:根据缓存获取文件上传对象:<p>
     * @return
     * @author wanglei 2017年8月21日
     */
    private FtpModel  getFtpProperFromCache(){
    	 PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory)MySpringApplicationContext.getObject("psmcCacheFactory");
    	   
    	Cache cache = psmcCacheFactory.getCacheSystem();
    	String ip = cache.get(CacheContants.CACHE_SYSTEM_UPLOAD_REMOTE_IP,String.class);
    	String port = cache.get(CacheContants.CACHE_SYSTEM_UPLOAD_REMOTE_PORT,String.class);
    	String user = cache.get(CacheContants.CACHE_SYSTEM_UPLOAD_REMOTE_USER,String.class);
    	String password = cache.get(CacheContants.CACHE_SYSTEM_UPLOAD_REMOTE_PARSSWORD,String.class);
    	String path = cache.get(CacheContants.CACHE_SYSTEM_UPLOAD_PATH,String.class);
    	String isRemote = cache.get(CacheContants.CACHE_SYSTEM_UPLOAD_IS_REMOTE,String.class);
    	String os = cache.get(CacheContants.CACHE_SYSTEM_UPLOAD_REMOTE_OS,String.class);
    	FtpModel ftm = null;
    	if(null!=isRemote &&!"".equals(isRemote)){
    		ftm = new FtpModel(ip,port, user, password, path, os, isRemote);
    	}
    	
    	return ftm;
    }
    /**
     * <p>Description:根据配置文件返回ftpmodel<p>
     * @return
     * @author wanglei 2017年8月22日
     */
    private FtpModel  getFtpProperFromFile(){ 
    	String ip = SystemPropertiesUtil.getSystemRemoteIp();
    	String port = SystemPropertiesUtil.getSystemRemotePort();
    	String user = SystemPropertiesUtil.getSystemRemoteUsername();
    	String password = SystemPropertiesUtil.getSystemRemotePassword();
    	String path = SystemPropertiesUtil.getUploadPathPropertyValue();
    	String isRemote = SystemPropertiesUtil.getSystemUploadIsremote();
    	String os = SystemPropertiesUtil.getSystemRemoteOs();
    	FtpModel ftm = new FtpModel(ip,port, user, password, path, os, isRemote);
    	return ftm;
    }
    /**
     * <p>Description:获取文件上传配置类的model<p>
     * @return
     * @throws IOException
     * @author wanglei 2017年8月22日
     */
    private FtpModel readPro()
    {
    	FtpModel ftpmodel = getFtpProperFromCache();
        if (null == ftpmodel)
        {
            	ftpmodel = getFtpProperFromFile();
                return ftpmodel;
        }
        return ftpmodel;
    }
    /**
     * <p>Description:连接服务器<p>
     * @param ftm ftp连接实体
     * @author wanglei 2017年8月22日
     */
    public void connectServer(FtpModel ftm)
    {
        ftpClient = new FTPClient();
        try
        {	
            // 连接
            ftpClient.connect(ftm.getRemoteIp(), Integer.parseInt(ftm.getRemotePort()));
             logger.info("ftpClient.connect");
            // 登录
            boolean islogin= ftpClient.login(ftm.getRemoteUser(), ftm.getRemotePassword());
            if(islogin){
            	 logger.info("设置ftp被动传输模式");
                 ftpClient.enterLocalPassiveMode();
                  logger.info("ftpClient.login");
                 if (ftm.getRemotePath() != null && ftm.getRemotePath().length() > 0 && !"/".equals(ftm.getRemotePath()))
                 {
                      logger.info("指定目录:"+ftm.getRemotePath());
                     // 跳转到指定目录
                      boolean isHavesub = ftpClient.changeWorkingDirectory(ftm.getRemotePath());
                      if(!isHavesub){
                    	  ftpClient.makeDirectory(ftm.getRemotePath());
                       }
                      logger.info("跳转到指定目录:"+ftm.getRemotePath());
                 }
            }else{
            	  logger.error(":登录失败!");
                  throw new RuntimeException("登录服务器失败,请检测服务器配置,若有疑问请联系管理员!");
            }
           
        }
        catch (SocketException e)
        {
            logger.error(e.getMessage() + ":连接FTP服务器失败!");
            throw new RuntimeException("连接服务器失败,请检测服务器配置,若有疑问请联系管理员!");

        }
        catch (IOException e)
        {
            logger.error(e.getMessage() + ":连接FTP服务器失败!");
            throw new RuntimeException("连接服务器失败,请检测服务器配置,若有疑问请联系管理员!");
        }
    }

    /**
     * <p>Description:关闭服务器<p>
     * @author wanglei 2017年8月22日
     */
    public void closeServer()
    {
        if (ftpClient.isConnected())
        {
            try
            {
                ftpClient.logout();
                 logger.info("用户退出登录");
                ftpClient.disconnect();
                logger.info("断开ftp连接");
            }
            catch (IOException e)
            {
                logger.error(e.toString());
            }
        }
    }
   
    /**
     * <p>Description:上传文件<p>
     * @param ufm 文件对象
     * @return 文件路径
     * @throws IOException
     * @author wanglei 2017年8月22日
     */
    public String uploadFile(UploadFileModel ufm) throws IOException
    {
        if (ufm != null && null!=ufm.getFile())
        {
        	FtpModel ftm = this.readPro();
        	String path = ftm.getRemotePath();
        	String filePath =null;
        	//判断是否是远程上传
        	if("true".equals(ftm.getIsRemote())){
        		//连接服务器
                this.connectServer(ftm);
                filePath = this.remoteUpload(ufm);
        	}else{
        		filePath = this.localUpload(ufm,path);
        	}
            return filePath;
        }
        else
        {
            logger.warn("发送到ftp的附件不存在");
            return "";
        }
    }
    // 实现本地文件上传
    private String localUpload(UploadFileModel ufm,String rootPath) {
		
    	String savePath = ufm.getFile_upload_real_path();
    	
    	//在判断是否存在目录
    	File tempsub = new File(rootPath);
    	if(!tempsub.exists()){
  		  //创建目录
    		tempsub.mkdir();
  	    }
    	//上传文件到本地
    	File targetFile = ufm.getFile();   
        StringBuffer filePath = new StringBuffer("/");
        //保存  
        try {  
        	filePath.append(savePath).append("/")
            .append(ufm.getFileRealName());
        		
        	long beginTime = System.currentTimeMillis();
            FileUtils.copyFileToDirectory(targetFile, tempsub);;  
            long endTimes = System.currentTimeMillis();
            logger.info("-----------------文件："+ufm.getFileRealName()+"上传成功！上传至："+savePath+"总耗时：["+(endTimes-beginTime)+"ms]");
        } catch (Exception e) {  
        	logger.error("-----------------文件："+ufm.getFileRealName()+"上传失败!");
            e.printStackTrace();  
        }  
		return filePath.toString();
	}
 // 实现远程文件上传
	private String remoteUpload(UploadFileModel ufm) throws IOException
    {
        InputStream input = null;
        try
        {
        	//设置为二进制数据格式
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            //设置服务器环境
            ftpClient.enterLocalPassiveMode();
            //设置文件转化形式
            ftpClient.setFileTransferMode(FTP.STREAM_TRANSFER_MODE);
            //将文件转化成二进制流
            input = new FileInputStream(ufm.getFile());
            long beginTime = System.currentTimeMillis();
             //上传文件
            boolean flag = ftpClient.storeFile(new String(ufm.getFile().getName().getBytes("utf-8"),"iso8859-1"), input);
            // 修改返回文件保存路径
            // return flag;
            long endTimes = System.currentTimeMillis();
            StringBuffer filePath = new StringBuffer("/");
            if (flag)
            {
                filePath.append(ufm.getFileRealName());
                logger.info("-----------------文件："+ufm.getFileRealName()+
                		"上传成功！上传至："+ufm.getFile_upload_real_path()+"总耗时：["+(endTimes-beginTime)+"ms]");
            }else{
            	 logger.error("-----------------文件："+ufm.getFileRealName()+"上传失败!");
            }
            return filePath.toString();
        }
        catch (IOException e)
        {
            throw e;
        }
        finally
        {
            if (input != null)
            {
                try
                {
                    input.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            this.closeServer();
        }
    }
	
	 
	 /**
	 * <p>Description:现在文件返回一个二进制流<p>
	 * @param fileName 文件全名（含路径）
	 * @return
	 * @throws IOException
	 * @author wanglei 2017年8月24日
	 */
	public InputStream downloadFileBytesByFtp(String fileName) throws IOException
	    {
	        InputStream ins = null;
	        FtpModel ftm = this.readPro();
	        try
	        {
	        	//判断是否是远程上传
	        	if("true".equals(ftm.getIsRemote())){
	        		//连接服务器
	                this.connectServer(ftm);
	            ins = ftpClient.retrieveFileStream(new String(fileName.getBytes("utf-8"),"iso8859-1"));
	        	}else{
	        		//如果在本地直接返回本地文件二进制流
		        	ins = new FileInputStream(fileName);
	        	}
	        	
	        }
	        catch (IOException e)
	        {
	            logger.error(e.getMessage());
	            throw e;
	        }finally
	        {
	        	if("true".equals(ftm.getIsRemote())){
	            this.closeServer();
	            }
	        }
	        return ins;
	    }
	/**
	 * <p>Description:下载文件返回文件对象<p>
	 * @param fileName
	 * @return
	 * @throws IOException
	 * @author wanglei 2017年8月24日
	 */
	public File downloadFileByFtp(String fileName) throws IOException{
		File resFile = new File(fileName);
		 InputStream ins = downloadFileBytesByFtp(fileName);
		 OutputStream os = new FileOutputStream(resFile);
		 int bytesRead = 0;
		 byte[] buffer = new byte[8192];
		 while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
		 os.write(buffer, 0, bytesRead);
		 }
		 os.close();
		 ins.close();
		return resFile;
	}
	/**
	 * <p>Description:删除文件<p>
	 * @param fileName 文件名-含全路径
	 * @author wanglei 2017年8月24日
	 */
	public void deleteFile(String fileName)
    {
		FtpModel ftm = this.readPro();
        try
        {
        	//判断是否是远程上传
        	if("true".equals(ftm.getIsRemote())){
        		//连接服务器
                this.connectServer(ftm);
                String path= fileName.substring(0,fileName.lastIndexOf("/")+1);
                String name = fileName.substring(fileName.lastIndexOf("/")+1);
                ftpClient.changeWorkingDirectory(new String(path.getBytes("UTF-8"),"iso8859-1"));
                if(!ftpClient.deleteFile(new String(name.getBytes("UTF-8"),"iso8859-1"))) throw new RuntimeException("删除文件失败！");
            }else{
            	//本地删除
            	FileUtils.forceDelete(new File(fileName));
            }
        }
        catch (IOException e)
        {
            logger.error(e.getMessage());
        }finally
        {if("true".equals(ftm.getIsRemote())){
            this.closeServer();
            }
        }
    }
}
