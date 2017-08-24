package priv.guochun.psmc.system.util;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.support.PropertiesLoaderUtils;


public class SystemPropertiesUtil
{

    private final static Logger logger  = LoggerFactory.getLogger(SystemPropertiesUtil.class.getName());    
    private static Properties props = null;    
    private static String file_name  = null;    
    //文件上传临时路径
    private static final String system_upload_temp_dir ="system_upload_temp_dir";
    /**
     * 文件上传路径
     */
    private static final String system_upload_dir ="system_upload_dir";
    /**
     * 文件下载临时路径
     */
    private static final String system_download_temp_dir ="system_download_temp_dir";
    /**
     * 文件是否远程上传
     */
    private static final String system_upload_isremote ="system_upload_isremote";
    /**
     * 远程
     */
    private static final String system_remote_ip ="system_remote_ip";
    /**
     * 远程端口
     */
    private static final String system_remote_port ="system_remote_port";
    /**
     * 远程用户名
     */
    private static final String system_remote_username ="system_remote_username";
    /**
     * 远程密码
     */
    private static final String system_remote_password ="system_remote_password";
    /**
     * 远程操作系统
     */
    private static final String system_remote_os ="system_remote_os";
    
    /**
     * 初始化system.propeties
     * <p>Description:<p>
     * @author guochun 2016-6-29
     */
    public static void loadPropertiesInit(String propertiesfileName){  
        file_name = propertiesfileName;
        props = new Properties();  
            try {  
                props=PropertiesLoaderUtils.loadAllProperties(file_name);  
                for(Object key:props.keySet()){  
                    logger.debug(key+":");  
                    logger.debug(props.get(key).toString());  
                }  
                logger.info("system.properties load success over.......");
            } catch (IOException e) {  
                logger.error(e.getMessage());
            }               
     }
    
    public static Properties getProps(){
        return props;
    }
    
    
    public static String getDownloadTempPathPropertyValue(){
        return getPropertyValue(system_download_temp_dir);
    }
    public static String getUploadTempPathPropertyValue(){
        return getPropertyValue(system_upload_temp_dir);
    }
    
    public static String getUploadPathPropertyValue(){
        return getPropertyValue(system_upload_dir);
    }
    
    public static String getSystemUploadIsremote() {
		return getPropertyValue(system_upload_isremote);
	}

	public static String getSystemRemoteIp() {
		return getPropertyValue(system_remote_ip);
	}

	public static String getSystemRemotePort() {
		return getPropertyValue(system_remote_port);
	}

	public static String getSystemRemoteUsername() {
		return getPropertyValue(system_remote_username);
	}

	public static String getSystemRemotePassword() {
		return getPropertyValue(system_remote_password);
	}

	public static String getSystemRemoteOs() {
		return getPropertyValue(system_remote_os);
	}

	public static String getPropertyValue(String key){
        if(props.containsKey(key)){
            return props.getProperty(key);
        }else{
            logger.warn(" key ["+key+"]  not in system.properties file ......." );
            return null;
        }          
    }
    
    
}
