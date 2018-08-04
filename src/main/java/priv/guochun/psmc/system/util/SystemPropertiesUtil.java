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
     * 文件访问路径前缀
     */
    private static final String file_prefix_path = "file_prefix_path";
    /** 信息列表默认配图图片路径 **/
    private static final String help_declare_image_path = "help_declare_image_path"; //帮扶申报
    private static final String law_help_image_path = "law_help_image_path"; //法律援助
    private static final String Legal_provisions_image_path = "Legal_provisions_image_path"; //法条维护
    private static final String work_manage_image_path = "work_manage_image_path"; //工作管理
    private static final String work_release_image_path = "work_release_image_path"; //工作发布
    private static final String activity_image_path = "activity_image_path";// 活动管理
    private static final String innovation_image_path = "innovation_image_path"; //优秀创新
    /** 信息列表自定义配图路径 **/
    private static final String custom_image_path = "custom_image_path";
    
    /**信息内容自定义图片路径**/
    private static final String innovation_custom = "innovation_custom";
    private static final String assistance_custom = "assistance_custom";
    private static final String literary_form_custom = "literary_form_custom";
    private static final String logistics_center_custom = "logistics_center";
    private static final String dept_innovation_custom = "dept_innovation";
    private static final String dept_literary_form_custom = "dept_literary_form";
    private static final String mobile_image_path = "mobile_image_path";
    
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
	
	public static String getfilePrefixPath(){
		return getPropertyValue(file_prefix_path);
	}
	public static String getHelpDeclareImagePath(){
		return getPropertyValue(help_declare_image_path);
	}
	public static String getLawHelpImagePath(){
		return getPropertyValue(law_help_image_path);
	}
	public static String getLegalProvisionsImagePath(){
		return getPropertyValue(Legal_provisions_image_path);
	}
	public static String getWorkManageImagePath(){
		return getPropertyValue(work_manage_image_path);
	}
	public static String getWorkReleaseImagePath(){
		return getPropertyValue(work_release_image_path);
	}
	public static String getActivityImagePath(){
		return getPropertyValue(activity_image_path);
	}
	public static String getInnovationImagePath(){
		return getPropertyValue(innovation_image_path);
	}
	public static String getInnovationCustomPath() {
		return getPropertyValue(innovation_custom);
	}
	public static String getAssistanceCustomPath() {
		return getPropertyValue(assistance_custom);
	}
	public static String getLiteraryFormCustomPath() {
		return getPropertyValue(literary_form_custom);
	}
	public static String getLogisticsCenterCustomPath() {
		return getPropertyValue(logistics_center_custom);
	}
	public static String getDeptInnovationCustomPath() {
		return getPropertyValue(dept_innovation_custom);
	}
	public static String getDeptLiteraryFormCustomPath() {
		return getPropertyValue(dept_literary_form_custom);
	}
	public static String getCustomImagePath() {
		return getPropertyValue(custom_image_path);
	}
	public static String getMobileImagePath(){
		return getPropertyValue(mobile_image_path);
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
