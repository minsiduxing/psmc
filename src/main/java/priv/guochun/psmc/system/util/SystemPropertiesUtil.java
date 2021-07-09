package priv.guochun.psmc.system.util;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

public class SystemPropertiesUtil
{

    private final static Logger logger  = LoggerFactory.getLogger(SystemPropertiesUtil.class.getName());    
    private static Properties props = null;    
    private static String file_name  = null;    


    /**
     * 新闻图片宽度
     */
    private static final String news_pic_width ="news_pic_width";
    /**
     * 新闻图片高度
     */
    private static final String news_pic_height ="news_pic_height";
    
    /**
     * 生成网页服务器路径 
     */
    private static final String gennerate_ftlfile_path ="gennerate_ftlfile_path";
    /**
     * 生成网页tomcat路径 
     */
    private static final String gennerate_ftlfile_local_path ="gennerate_ftlfile_local_path";
    /**
     * 是否部署
     */
    private static final String is_publish ="is_publish";

    /**
     * 初始化system.propeties
     * <p>Description:<p>
     * @author guochun 2016-6-29
     */
    public static void loadPropertiesInit(String propertiesfileName){  
        file_name = propertiesfileName;
        props = new Properties();  
            try {  
            	//解决读取中文乱码
            	EncodedResource encodedResource = new EncodedResource(new ClassPathResource(file_name), "UTF-8");
            	props=PropertiesLoaderUtils.loadProperties(encodedResource);
//                props=PropertiesLoaderUtils.loadAllProperties(file_name); 
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


	public static String getNewsPicWidth() {
		return getPropertyValue(news_pic_width);
	}

	public static String getNewsPicHeight() {
		return getPropertyValue(news_pic_height);
	}
	
	

	public static String getGennerateFtlfileLocalPath() {
		return getPropertyValue(gennerate_ftlfile_local_path);
	}

	public static String getGennerateFtlfilePath() {
		return getPropertyValue(gennerate_ftlfile_path);
	}

	public static String getIsPublish() {
		return getPropertyValue(is_publish);
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
