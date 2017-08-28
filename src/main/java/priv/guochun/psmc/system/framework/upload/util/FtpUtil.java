package priv.guochun.psmc.system.framework.upload.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.log4j.Logger;
import org.springframework.cache.Cache;

import priv.guochun.psmc.system.enums.FileEnum;
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
     * 流缓冲区存放的大小 
     */  
    private final static int UPLOAD_BUFFER_SIZE=1024*1024;  
  
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
    private FtpUtil(){
    	   
    }
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
    	String uptempDir = cache.get(CacheContants.CACHE_SYSTEM_UPLOAD_REMOTE_UP_TEMP_DIR,String.class);
    	String downtempDir = cache.get(CacheContants.CACHE_SYSTEM_UPLOAD_REMOTE_DOWN_TEMP_DIR,String.class);
    	
    	FtpModel ftm = null;
    	if(null!=isRemote &&!"".equals(isRemote)){
    		ftm = new FtpModel(ip,port, user, password, path, os, isRemote,uptempDir,downtempDir);
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
    	String uptempDir = SystemPropertiesUtil.getUploadTempPathPropertyValue();
    	String downtempDir = SystemPropertiesUtil.getDownloadTempPathPropertyValue();
    	FtpModel ftm = new FtpModel(ip,port, user, password, path, os, isRemote,uptempDir,downtempDir);
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
        	  //设置将过程中使用到的命令输出到控制台  
        	this.ftpClient.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out))); 
        	// 连接
            ftpClient.connect(ftm.getRemoteIp(), Integer.parseInt(ftm.getRemotePort()));
             logger.info("ftpClient.connect");
            // 登录
            boolean islogin= ftpClient.login(ftm.getRemoteUser(), ftm.getRemotePassword());
            if(islogin){
            	 logger.info("设置ftp被动传输模式");
                 ftpClient.enterLocalPassiveMode();
                  logger.info("ftpClient.login");
                  ftpClient.setBufferSize(UPLOAD_BUFFER_SIZE);  
                  
                  //超时时间  
                  int defaultTimeoutSecond=30*60 * 1000;  
                  ftpClient.setDefaultTimeout(defaultTimeoutSecond);  
                  ftpClient.setConnectTimeout(defaultTimeoutSecond );  
                  ftpClient.setDataTimeout(defaultTimeoutSecond);  
                    
                 if (ftm.getRemotePath() != null && ftm.getRemotePath().length() > 0 && !"/".equals(ftm.getRemotePath()))
                 {
                      logger.info("指定目录:"+ftm.getRemotePath());
                     // 跳转到指定目录
                      boolean isHavesub = ftpClient.changeWorkingDirectory(ftm.getRemotePath());
                      if(!isHavesub){
                    	  ftpClient.makeDirectory(ftm.getRemotePath());
                    	  ftpClient.changeWorkingDirectory(ftm.getRemotePath());
                    	  
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
            	 try {
                     boolean flag = ftpClient.logout();
                     if (!flag) {
                         logger.error("退出FtpClient失败！");
                     }else{
                    	 logger.info("用户退出登录");
                     }
              }
            catch (IOException e)
            {
                logger.error(e.toString());
            }finally{
            	try {
					ftpClient.disconnect();
					 ftpClient=null; 
					logger.info("断开ftp连接");
				} catch (IOException e) {
					 logger.error("断开ftp连接失败！");
					e.printStackTrace();
				}
                
            }
         }
    }
    /**  
     * 递归创建远程服务器目录  
     * @param remote 远程服务器文件绝对路径  
     * @param ftpClient FTPClient对象  
     * @return 目录创建是否成功  
     * @throws IOException  
     */  
    public boolean CreateDirecroty(String remote,FTPClient ftpClient) throws IOException{   
        String directory = PSMCFileUtils.getFileDirectroyPath(remote);   
         if(!directory.equalsIgnoreCase("/")&&!ftpClient.changeWorkingDirectory(PSMCFileUtils.encodedFileName(directory))){   
            //如果远程目录不存在，则递归创建远程服务器目录   
            int start=0;   
            int end = 0;   
            if(directory.startsWith("/")){   
                start = 1;   
            }else{   
                start = 0;   
            }   
            end = directory.indexOf("/",start);   
            ftpClient.changeWorkingDirectory("/");
            while(true){   
                String subDirectory = new String(PSMCFileUtils.encodedFileName(remote.substring(start,end)));   
                if(!ftpClient.changeWorkingDirectory(subDirectory)){   
                    if(ftpClient.makeDirectory(subDirectory)){   
                        ftpClient.changeWorkingDirectory(subDirectory);   
                    }else {   
                        logger.info("创建目录失败");   
                        return false;   
                    }   
                }   
                   
                start = end + 1;   
                end = directory.indexOf("/",start);   
                   
                //检查所有目录是否创建完毕   
                if(end <= start){   
                    break;   
                }   
            }   
        }   
        return true;   
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
        	String filePath =ufm.getFile_upload_real_path();
        	//判断是否是远程上传
        	long beginTime = System.currentTimeMillis();
        	boolean status = false;
        	if("true".equals(ftm.getIsRemote())){
        		status= this.remoteUpload(ufm);
        	}else{
        		status = this.localUpload(ufm,path);
        	}
        	if(status){
        		long endTime = System.currentTimeMillis();
            	logger.info("文件:["
        		+PSMCFileUtils.getFileNameByPath(ufm.getFileSystemName())+"]上传成功！总耗时："
        		+(endTime-beginTime)+"ms;"+"文件大小：["+PSMCFileUtils.GetFileSize(ufm.getFile())+"]"
        		);
            	  //清空缓存目录
            	 File tempDir = new File(ftm.getUploadTempDir());
                 PSMCFileUtils.deleteAllFilesOfDir(tempDir);
        	}else{
        		throw new RuntimeException("文件上传失败！");
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
    private boolean localUpload(UploadFileModel ufm,String rootPath) {
    	//在判断是否存在目录
    	File rootDir = new File(rootPath);
    	if(!rootDir.exists()){
  		  //创建目录
    		rootDir.mkdir();
  	    }
    	String path= PSMCFileUtils.getFileDirectroyPath(ufm.getFile_upload_real_path());
    	File subDir = new File(path);
    	if(!subDir.exists()){
  		  //创建目录
    		subDir.mkdir();
  	    }
    	//上传文件到本地
    	File targetFile = ufm.getFile();   
        //保存  
        try {  
            FileUtils.copyFileToDirectory(targetFile, subDir);
        } catch (Exception e) {  
        	logger.error("----------文件：["+ufm.getFileRealName()+"]上传失败!失败原因："+e.getMessage());
            e.printStackTrace();  
        }  
		return true;
	}
    
    /**
     * <p>Description:远程上传文件包含新文件和断点上传并显示进度<p>
     * @param ufm ftp实体
     * @return
     * @author wanglei 2017年8月27日
     */
    private boolean remoteUpload(UploadFileModel ufm){  
    	FtpModel ftm = this.readPro();
    	Integer result = null;
    	//本地临时路径
    	String local = ftm.getUploadTempDir()+PSMCFileUtils.getFileNameByPath(ufm.file_upload_real_path);
    	//远程路径
    	String remote = ufm.getFile_upload_real_path();
    	try {
			//连接服务器
			this.connectServer(ftm);
			//设置PassiveMode传输   
			ftpClient.enterLocalPassiveMode();   
			//设置以二进制流的方式传输   
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);   
			ftpClient.setControlEncoding("UTF-8");   
			//对远程目录的处理   
			String remoteFileName = remote;   
			if(remote.contains("/")){   
			    remoteFileName = PSMCFileUtils.getFileNameByPath(remote);   
			    //创建服务器远程目录结构，创建失败直接返回   
			    if(CreateDirecroty(remote, ftpClient)==false){   
			    	logger.info("创建远程目录失败！");
			        return false;   
			    }   
			}   
			   
			//检查远程是否存在文件   
			FTPFile[] files = ftpClient.listFiles(PSMCFileUtils.encodedFileName(remote));   
			if(files.length == 1){   
			    long remoteSize = files[0].getSize();   
			    File f = new File(local);   
			    long localSize = f.length();   
			    if(remoteSize==localSize){  
			    	logger.error("文件已存在且和本地文件一样大");
			        return true;   
			    }else if(remoteSize > localSize){   
			    	logger.error("失败原因:文件已存在且大于本地文件");
			        return false;   
			    }   
			      
			    //尝试移动文件内读取指针,实现断点续传   
			    result = uploadFile(remoteFileName, f, ftpClient, remoteSize);   
			    //如果断点续传没有成功，则删除服务器上文件，重新上传   
			    if(result == FileEnum.REMOTE_BREAK_UPLOAD_BREAK_FAILE.getValue()){   
			        if(!ftpClient.deleteFile(remoteFileName)){  
			        	logger.error("删除远程文件失败！");
			            return false;   
			        }   
			        result = uploadFile(remoteFileName, f, ftpClient, 0);   
			    }   
			}else {   
			    result = uploadFile(remoteFileName, new File(local), ftpClient, 0);   
			}
		} catch (IOException e) {
			logger.error(e);
			e.printStackTrace();
		}  finally{
			//关闭资源
			 this.closeServer();
		} 
          
       return true;
    }
	
    /**  
     * 从FTP服务器上下载文件,支持断点续传，上传百分比汇报  
     * @param remote 远程文件路径  
     * @param local 本地文件路径  
     * @return 上传的状态  
     * @throws IOException   
	 *  @author wanglei 2017年8月27日 
	 */
	public File downloadFileByFtp(String fileName){
		if(StringUtils.isBlank(fileName)){
			return null;
		}
		File resFile = null;
		FtpModel ftm = this.readPro();
		//判断是否需要远程下载
	try {
		if("true".equals(ftm.getIsRemote())){
			//连接服务器
			this.connectServer(ftm);
			 //设置被动模式   
	        ftpClient.enterLocalPassiveMode();   
	        //设置以二进制方式传输   
				ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
				  //检查远程文件是否存在   
		        FTPFile[] files = ftpClient.listFiles(PSMCFileUtils.encodedFileName(fileName));  
		        if(files.length != 1){   
		            logger.info("远程文件不存在");   
		            return null;   
		        }
		        
		        long lRemoteSize = files[0].getSize();   
		        //创建临时文件
				 String name= PSMCFileUtils.getFileNameByPath(fileName);
				 File temdir = new File(ftm.getDoownLoadTempdir());
				 if(!temdir.exists()){
					 temdir.mkdirs(); 
				 }
				 resFile = new File(ftm.getDoownLoadTempdir()+name);
				 if(!resFile.exists()){
					 resFile.createNewFile(); 
				 }
		        //本地存在文件，进行断点下载   
		        if(resFile.exists()){   
		            long localSize = resFile.length();   
		            //判断本地文件大小是否大于远程文件大小   
		            if(localSize >= lRemoteSize){   
		                logger.info("本地文件大于远程文件，下载中止 将从本地获取");   
		                return resFile;   
		            } 
		            //进行断点续传，并记录状态   
		            FileOutputStream out = new FileOutputStream(resFile,true);   
		            ftpClient.setRestartOffset(localSize);   
		            InputStream in = ftpClient.retrieveFileStream(PSMCFileUtils.encodedFileName(fileName));  
		            //传输进度监控
		            this.getDownLoadProcess(in, out, lRemoteSize);
		            boolean isDo = ftpClient.completePendingCommand();   
		            if(isDo){   
		            	  logger.info("文件：["+name+"]下载成功！");   
		            }else {   
		            	  logger.info("文件：["+name+"]下载失败!");   
		            }   
		        }else{
		        	//不进行断点下载
		        	FileOutputStream out = new FileOutputStream(resFile,true);   
		            InputStream in = ftpClient.retrieveFileStream(PSMCFileUtils.encodedFileName(fileName));   
		            //传输进度监控
		            this.getDownLoadProcess(in, out, lRemoteSize);   
		            boolean isDo = ftpClient.completePendingCommand();   
		            if(isDo){   
		            	  logger.info("文件：["+name+"]下载成功!");   
		            }else {   
		            	  logger.info("文件：["+name+"]下载失败!");   
		            }   
		        }
           }else{
        	   //如果是本地下载则直接返回本地文件
        	   resFile = new File(fileName);
			}
		} catch (IOException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} finally
        {
           if("true".equals(ftm.getIsRemote())){
        	   //断开远程连接
        	 this.closeServer();
           }
           logger.info("---下载文件大小：["+PSMCFileUtils.GetFileSize(resFile)+"]");
        }
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
        	long beginTime = System.currentTimeMillis();
        	//判断是否是远程上传
        	 String path= PSMCFileUtils.getFileDirectroyPath(fileName);
             String name =  PSMCFileUtils.getFileNameByPath(fileName);
        	if("true".equals(ftm.getIsRemote())){
        		//连接服务器
                this.connectServer(ftm);
                ftpClient.changeWorkingDirectory(PSMCFileUtils.encodedFileName(path));
                if(!ftpClient.deleteFile(PSMCFileUtils.encodedFileName(name))) throw new RuntimeException("删除文件失败！");
            }else{
            	//本地删除
            	FileUtils.forceDelete(new File(fileName));
            }
        	long endTime = System.currentTimeMillis();
        	logger.info("文件:["+name+"]删除成功！总耗时："+(endTime-beginTime)+"ms");
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
	
	 /**  
     * 上传文件到服务器,新上传和断点续传  
     * @param remoteFile 远程文件名，在上传之前已经将服务器工作目录做了改变  
     * @param localFile 本地文件File句柄，绝对路径  
     * @param processStep 需要显示的处理进度步进值  
     * @param ftpClient FTPClient引用  
     * @return  
     * @throws IOException 
     * @author wanglei 2017年8月27日 
     */  
	private Integer uploadFile(String remoteFile,File localFile,FTPClient ftpClient,long remoteSize) throws IOException{   
    	Integer status =null;   
    	 
        //显示进度的上传   
        long step =  PSMCFileUtils.getFileSize(localFile)/ 100;   
        long process = 0;   
        long localreadbytes = 0L;   
        RandomAccessFile raf = new RandomAccessFile(localFile,"r");   
        OutputStream out = ftpClient.appendFileStream(PSMCFileUtils.encodedFileName(remoteFile));   
        //断点续传   
        if(remoteSize>0){   
            ftpClient.setRestartOffset(remoteSize);   
            process = remoteSize /step;   
            raf.seek(remoteSize);   
            localreadbytes = remoteSize;   
        }   
        byte[] bytes = new byte[UPLOAD_BUFFER_SIZE];   
        int c;   
        while((c = raf.read(bytes))!= -1){   
            out.write(bytes,0,c);   
            localreadbytes+=c;   
            if(localreadbytes / step != process){   
                process = localreadbytes / step;   
                logger.info("上传进度："+process+"%");    
                //TODO 汇报上传状态   
            }   
        }   
        out.flush();   
        raf.close();   
        out.close();   
        boolean result =ftpClient.completePendingCommand();   
        if(remoteSize > 0){   
            status = result?FileEnum.REMOTE_BREAK_UPLOAD_SUCCESS.getValue():FileEnum.REMOTE_BREAK_UPLOAD_BREAK_FAILE.getValue();   
        }else {   
        	status = result?FileEnum.REMOTE_NEW_UPLOAD_SUCCESS.getValue():FileEnum.REMOTE_NEW_UPLOAD_SUCCESS.getValue();     
        }   
        return status;   
    }    
	/**
	 * <p>Description:输出文件传输的进度<p>
	 * @author wanglei 2017年8月27日
	 */
	private  void  getDownLoadProcess(InputStream in,FileOutputStream out,long fileSize){
		byte[] bytes = new byte[UPLOAD_BUFFER_SIZE];   
        long step = fileSize /100;   
        long process=0;   
        long localSize = 0L;   
        int c;   
        try {
			while((c = in.read(bytes))!= -1){   
			    out.write(bytes, 0, c);   
			    localSize+=c;   
			    long nowProcess = localSize /step;   
			    if(nowProcess > process){   
			        process = nowProcess;   
			        if(process % 10 == 0)   
			          logger.info("当前文件下载进度："+process+"%");   
			        //TODO 更新文件下载进度,值存放在process变量中   
			    }   
			}
			 in.close();   
		     out.close(); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}     
	}
	/**
	 * <p>Description:获取制定路径下的所有文件<p>
	 * @return
	 * @author wanglei 2017年8月27日
	 */
	public Map<String,Object> getFileList(String path)
    {
        List<String> fileLists = new ArrayList<String>();
        List<String> directory = new ArrayList<String>();
        Map<String,Object> res = new HashMap<String, Object>();
        if(null == path){
        	return null;
        }
        // 获得指定目录下所有文件名
        FTPFile[] ftpFiles = null;
        try
        {
            //连接服务器
        	FtpModel ftm = this.readPro();
    		//判断是否需要远程下载
    		this.connectServer(ftm);
        	ftpClient.changeWorkingDirectory(path);
            ftpFiles = ftpClient.listFiles();
          
        }
        catch (IOException e)
        {
            logger.error(e.getMessage());
        }finally{
        	this.closeServer();
        }
        for (int i = 0; ftpFiles != null && i < ftpFiles.length; i++)
        {
            FTPFile file = ftpFiles[i];
            if (file.isFile())
            {
                fileLists.add(PSMCFileUtils.decodedFileName(file.getName()));
            }if(file.isDirectory()){
            	directory.add(PSMCFileUtils.decodedFileName(file.getName()));
            }
        }
        res.put("files", fileLists);
        res.put("directorys", directory);
        return res;
    }
	
}
