package priv.guochun.psmc.website.backstage.questionnaire.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import priv.guochun.psmc.authentication.login.model.User;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.excel.ExcelUtil;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.framework.upload.factory.MyCommonsMultipartResolverFactory;
import priv.guochun.psmc.system.util.ContantsUtil;
import priv.guochun.psmc.system.util.JsonUtil;
import priv.guochun.psmc.system.util.SystemPropertiesUtil;
import priv.guochun.psmc.website.backstage.excellentInnovation.model.TabExcellentInnovation;
import priv.guochun.psmc.website.backstage.module.model.TabModule;
import priv.guochun.psmc.website.backstage.questionnaire.model.TabEvaluateInfo;
import priv.guochun.psmc.website.backstage.questionnaire.service.TabEvaluateInfoService;

@Controller
@RequestMapping("/website/backstage/EvauateInfoController")
public class EvauateInfoController extends MyController{
	
	@Autowired
	private TabEvaluateInfoService tabEvaluateInfoService;

	/**
	 * 提交客户消费信息
	 * @param evaluateInfo
	 */
	@RequestMapping(params="method=submit")
	public void submit(TabEvaluateInfo evaluateInfo) throws IOException{
		User user = this.getUserBySeesion(this.request());
		tabEvaluateInfoService.insertEvaluateInfoBusinessMethod(evaluateInfo, user);
		super.responseJson(true, "操作成功!", this.response());
	}
	
	/**
	 * 查询客户消费信息列表
	 * @param myPage
	 * @throws IOException 
	 */
	@RequestMapping(params="method=evaluateInfoList")
	@ResponseBody
	public void queryEvaluateInfoList(MyPage myPage) throws IOException{
		myPage = tabEvaluateInfoService.queryEvaluateInfoList(myPage);
		super.responseJson(JsonUtil.convertToJSONObject(myPage), this.response());
	}
	
	/**
	 * 跳转到客户消费信息列表界面
	 * @return
	 */
	@RequestMapping(params="method=toEvaluateInfoList")
	public String toEvaluateInfoList(){
		return "backstage/questionnaire/evaluateInfoList";
	}
	
	/**
	 * 跳转到录入客户消费信息界面
	 * @return
	 */
	@RequestMapping(params="method=toAddEvaluateInfo")
	public String toAddEvaluateInfo(){
		return "backstage/questionnaire/addEvaluateInfo";
	}
	
	/**
	 * 导入客户消费信息
	 * @param file
	 * @param excelExamInfoUuid
	 * @throws IOException 
	 */
	@RequestMapping(params="method=loadExcelEvaluateInfo")
	public void loadExcelEvaluateInfo() throws IOException {
		String evaluateNoticeType = this.request().getParameter("noticeType");
		String questionnaireUuid = this.request().getParameter("questionUuid");	
		MultipartFile excelFile = null;
        CommonsMultipartResolver multipartResolver =MyCommonsMultipartResolverFactory.getInstance().createCommonsMultipartResolver(this.request());
        //判断 request 是否有文件上传
	    if(multipartResolver.isMultipart(this.request())){  
	        //转换成多部分request    
	        MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)this.request();  
	          
	        //取得request中的所有文件名  
	        Iterator<String> iter = multiRequest.getFileNames();  
	        while(iter.hasNext()){
		        //取得上传文件  
	        	excelFile = multiRequest.getFile(iter.next()); 
	        }
	    }
	    if(excelFile != null){
	    	String fileName = excelFile.getOriginalFilename(); 
	        if(!(fileName.endsWith("xls"))) {
	        	super.responseJson(false, "只支持xls后缀的Excel文件!", this.response());
	        }else {
	        	String realPath = this.request().getSession().getServletContext().getRealPath("/");
	            String resourcePath = "upload/";
	        	String tempFilePath = realPath + resourcePath + fileName;
	    	    File tempFile = new File(tempFilePath);
	    	    excelFile.transferTo(tempFile);
	    	  //使用工具类读取excel数据
	    		ExcelUtil excelUtil = new ExcelUtil(tempFile);
	    		List<String[]> excelList = excelUtil.readExcel();
	            
	            Map<String,String> resultMap=new HashMap<String, String>();
	            if(excelList!=null && excelList.size()>0){
	            	User user = this.getUserBySeesion(this.request());
	            	tabEvaluateInfoService.saveExcelEvaluateBusinessMethod(excelList, Integer.valueOf(evaluateNoticeType), questionnaireUuid, user);
	            }else{
	            	super.responseJson(false, "该文件没有需要导入的数据", this.response());
	            }
	            if(tempFile.exists()){
	            	tempFile.delete();
	            }
	            super.responseJson(true, "导入成功!", this.response());
	        }
	    }
    }
	
	/**
	 * 下载模板
	 * @param evaluateNoticeType
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping(params="method=downloadExcelTemplate")
	public void downloadExcelTemplate(Integer evaluateNoticeType) throws UnsupportedEncodingException{
		String filename = "";
		if(ContantsUtil.NOTICE_TYPE_1.equals(evaluateNoticeType)){
			filename = "金额消费信息模板.xls";
		}else if(ContantsUtil.NOTICE_TYPE_2.equals(evaluateNoticeType)){
			filename = "项目消费信息模板.xls";
		}else{
			filename = "充值信息模板.xls";
		}
		//获取目标文件的绝对路径 
	    String fullFileName = this.request().getServletContext().getRealPath("/template/" + filename); 
		filename = URLEncoder.encode(filename, "UTF-8");
		this.response().reset();
	    this.response().addHeader("Content-Disposition", "attachment; filename="+filename);
	    this.response().setContentType("application/octet-stream;charset=UTF-8");
	    //读取文件 
	    InputStream in = null;
	    OutputStream out = null;
		try {
			in = new FileInputStream(fullFileName);
			out = this.response().getOutputStream();
			 //写文件 
		    int b; 
		    while((b=in.read())!= -1) 
		    { 
		      out.write(b); 
		    } 
		    in.close();
			out.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
}
