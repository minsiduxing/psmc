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
    private static final String system_upload_temp_dir ="system_upload_temp_dir";
    private static final String system_upload_dir ="system_upload_dir";
    private static final String system_download_temp_dir ="system_download_temp_dir";
    
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
    
    public static String getPropertyValue(String key){
        if(props.containsKey(key)){
            return props.getProperty(key);
        }else{
            logger.warn(" key ["+key+"]  not in system.properties file ......." );
            return null;
        }          
    }
    
    
}
