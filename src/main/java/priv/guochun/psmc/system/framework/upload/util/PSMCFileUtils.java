package priv.guochun.psmc.system.framework.upload.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;



/**
 * <p>Title: 文件工具类</p>
 * <p>Description: </p>
 * @author <a href="mailTo:18829012118@126.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2017年8月26日
 */
public class PSMCFileUtils {
	private final static String ENCODING="UTF-8";
	private final static String DECODING="iso8859-1";
	private static final Logger logger = Logger.getLogger(FtpUtil.class);
	/**判断文件是否为图片
	 * @param fileSuffix 文件后缀
	 * @return true:是 false:否
	 * @throws Exception
	 */
	public static boolean isPicture(String fileSuffix){
		// 文件名称为空的场合
		if(StringUtils.isBlank(fileSuffix)){
			// 返回不和合法
			return false;
		}
		// 声明图片后缀名数组
		String imgeArray [] = {
			"bmp", "dib", "gif","jfif", "jpe","jpeg", 
			"jpg", "6", "png", "7","tif", "8",
			"tiff", "ico", "10"};
		// 遍历名称数组
		for(int i = 0; i<imgeArray.length;i++){
			// 判断单个类型文件的场合
			if(! StringUtils.isBlank(fileSuffix)
			&& imgeArray [i].equals(fileSuffix.toLowerCase())
			&& imgeArray [i].equals(fileSuffix)){
				return true;
			}
		}
		return false;
	}
	/**
	 * <p>Description:根据文件路径获取文件名<p>
	 * @param path 文件路径
	 * @return 文件名
	 * @author wanglei 2017年8月26日
	 */
	public static String getFileNameByPath(String path){
		if(StringUtils.isNotBlank(path)){
			// 返回不和合法
			return path.substring(path.lastIndexOf("/")+1);
		}
		return null;
	}
	/**
	 * <p>Description:根据文件路径获取文件存储目录<p>
	 * @param path 路径
	 * @return 文件目录
	 * @author wanglei 2017年8月26日
	 */
	public static String getFileDirectroyPath(String path){
		if(StringUtils.isNotBlank(path)){
			// 返回不和合法
			return path.substring(0,path.lastIndexOf("/")+1);
		}
		return null;
	}
	/**
	 * <p>Description:防止中文乱码对文件路径进行重新编码<p>
	 * @param path 文件路径
	 * @return 编码后的路径
	 * @author wanglei 2017年8月26日
	 */
	public static String encodedFileName(String path){
		if(StringUtils.isNotBlank(path)){
			// 返回不和合法
			try {
				return new String(path.getBytes(ENCODING),DECODING);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	public static String decodedFileName(String path){
		if(StringUtils.isNotBlank(path)){
			// 返回不和合法
			try {
				return new String(path.getBytes(DECODING),ENCODING);
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	/**
	 * <p>Description:递归删除文件夹所有文件<p>
	 * @param path 文件
	 * @author wanglei 2017年8月27日
	 */
	public static void deleteAllFilesOfDir(File path) {  
		 logger.info("--------------正在清空:"+path.getPath()+"下所有文件");
	    if (!path.exists())  
	        return;  
	    if (path.isFile()) {  
	        path.delete();  
	        return;  
	    }  
	    File[] files = path.listFiles();  
	    for (int i = 0; i < files.length; i++) {  
	        deleteAllFilesOfDir(files[i]); 
	        logger.info("--------------正在删除:"+files[i].getName());
	    }  
	    logger.info("--------------共计删除文件数:"+files.length);
	    path.delete();  
	}  
	/**
	 * <p>Description:返回文件大小因为File的length()方法返回的类型为long,
        long 最大值是：9223372036854775807在计算大文件是会报错，
           所以用 java.nio.*下的新工具——FileChannel<p>
	 * @param file 文件
	 * @return 文件大小
	 * @author wanglei 2017年8月27日
	 */
	public static long getFileSize(File file){
		long size = 0;
		if(null == file){
			return 0;
		}
		 FileChannel fc= null;  
    	 FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			fc= fis.getChannel(); 
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         try {
        	 size= fc.size();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}  
         return size; 
	}
	/**
	 * <p>Description:获取文件大小返回合适的大小<p>
	 * @param file
	 * @return
	 * @author wanglei 2017年8月27日
	 */
	public static String GetFileSize(File file){
	    String size = ""; 
	    if(null==file){
	    	 return size;
	    }
	    if(file.exists() && file.isFile()){
	    long fileS = file.length();
	      DecimalFormat df = new DecimalFormat("#.00"); 
	           if (fileS < 1024) {
	               size = df.format((double) fileS) + "BT";
	           } else if (fileS < 1048576) {
	               size = df.format((double) fileS / 1024) + "KB";
	           } else if (fileS < 1073741824) {
	               size = df.format((double) fileS / 1048576) + "MB";
	           } else {
	               size = df.format((double) fileS / 1073741824) +"GB";
	           }
	    }else if(file.exists() && file.isDirectory()){
	    size = "";
	    }else{
	    size = "0BT";
	    }
	    return size;
	   }
}
