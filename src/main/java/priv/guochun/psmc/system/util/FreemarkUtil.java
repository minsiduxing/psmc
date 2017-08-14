package priv.guochun.psmc.system.util;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import org.apache.commons.io.output.FileWriterWithEncoding;
import org.apache.log4j.Logger;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;
import freemarker.template.Version;

/**
 * <p>Title: freemarker 工具类</p>
 * <p>Description: 获取工具类对象、获取模板、输出到输出流、输出到文件</p>
 * <p>Copyright: Copyright ICSS(c) 2017</p>
 * @author <a href="mailTo:Wanglei001@chinasofti.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2017-8-14
 */
public class FreemarkUtil {
	static Logger logger = Logger.getLogger(FreemarkUtil.class);
	 //静态工具类
	 private static FreemarkUtil freemarkUtil;
	 //配置对象
	 private static Configuration cfg;

	 private FreemarkUtil() {
	 }
	/**
	 * <p>Description:获取工具类的对象<p>
	 * @param freemarkerVersionNo freemarker版本
	 * @param ftlPath ftl模板路径
	 * @return
	 * @author wanglei 2017-8-14
	 */
	public static FreemarkUtil getInstance(String freemarkerVersionNo, String ftlPath) {
		  if (null == freemarkUtil) {
		   cfg = new Configuration(new Version(freemarkerVersionNo));
		   cfg.setClassForTemplateLoading(FreemarkUtil.class, ftlPath);
		   logger.info("----------正在读取ftl模板目录"+ftlPath+"下的文件");
		   freemarkUtil=new FreemarkUtil();
		   logger.info("----------正在构建模板工具类");
		  }
		  return freemarkUtil;
	}
	/**
	 * <p>Description:加载模板<p>
	 * @param templateName 模板名称
	 * @return
	 * @author wanglei 2017-8-14
	 */
	private Template getTemplate(String templateName){
		  try {
			  logger.info("----------读取模板----"+templateName);
		   return cfg.getTemplate(templateName);
		  } catch (TemplateNotFoundException e) {
			  logger.error("----------读取模板--失败-"+e.getMessage());
		   e.printStackTrace();
		  } catch (MalformedTemplateNameException e) {
			  logger.error("----------读取模板--失败-"+e.getMessage());
		   e.printStackTrace();
		  } catch (ParseException e) {
			  logger.error("----------读取模板--失败-"+e.getMessage());
		   e.printStackTrace();
		  } catch (IOException e) {
			  logger.error("----------读取模板--失败-"+e.getMessage());
		   e.printStackTrace();
		  }
		  return null;
		 }
	
	/**
	 * <p>Description:模板整合数据输出到二进制流<p>
	 * @param dataModel 数据模型
	 * @param templateName 模板名称
	 * @author wanglei 2017-8-14
	 */
	public  void sprintTemplate(Map<String,Object > dataModel,String templateName){
		try {
			 logger.info("----------为模板----"+templateName+"---整合数据");
	        this.getTemplate(templateName).process(dataModel, new PrintWriter(System.out));
        } catch (TemplateException e) {
        	 logger.error("----------整合数据--失败-"+e.getMessage());
	        e.printStackTrace();
        } catch (IOException e) {
        	 logger.error("----------整合数据--失败-"+e.getMessage());
	        e.printStackTrace();
        }
	}
	/**
	 * <p>Description:整合数据输出到文件<p>
	 * @param dataModel 数据模型
	 * @param templateName 模板名称
	 * @param filePath 输出文件路径
	 * @param fileName 输出文件名称
	 * @author wanglei 2017-8-14
	 */
	public void fprintTemplate(Map<String,Object> dataModel,String templateName,String filePath,String fileName){
		if(null == fileName || "".equals(fileName)){
			System.out.println("文件名为空无法输出！");
			return;
		}
		try {
			 logger.info("----------输出模板----"+templateName+"到文件"+filePath+File.separator+fileName);
	        this.getTemplate(templateName).process(dataModel,new FileWriterWithEncoding(filePath+File.separator+fileName, "utf-8"));
        } catch (TemplateException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        } catch (IOException e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
        }
	}
}

