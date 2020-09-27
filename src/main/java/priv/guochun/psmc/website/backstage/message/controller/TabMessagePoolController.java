package priv.guochun.psmc.website.backstage.message.controller;

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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.excel.ExcelUtil;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.framework.upload.factory.MyCommonsMultipartResolverFactory;
import priv.guochun.psmc.system.util.JsonUtil;
import priv.guochun.psmc.website.backstage.message.model.ContentDataDto;
import priv.guochun.psmc.website.backstage.message.model.TabMessagePool;
import priv.guochun.psmc.website.backstage.message.model.TabMessageTemp;
import priv.guochun.psmc.website.backstage.message.service.TabMessagePoolService;
import priv.guochun.psmc.website.backstage.message.service.TabMessageTempService;

@Controller
@RequestMapping("/website/backstage/TabMessagePoolController")
public class TabMessagePoolController extends MyController{

	@Autowired
	private TabMessagePoolService tabMessagePoolService;
	@Autowired
	private TabMessageTempService tabMessageTempService;

	
	/**
	 * 跳转到消息池界面
	 * @return
	 */
	@RequestMapping(params="method=toMessagePoolList")
	public String toEvaluateInfoList(){
		
		return "backstage/message/messagePoolList";
	}
	/**
	 * 查询消息池列表
	 * @param myPage
	 * @throws IOException 
	 */
	@RequestMapping(params="method=messagePoolList")
	@ResponseBody
	public void queryMessagePoolList(MyPage myPage) throws IOException{
		myPage = tabMessagePoolService.queryTabMessagePoolList(myPage);
		super.responseJson(JsonUtil.convertToJSONObject(myPage), this.response());
	}
	/**
	 * 查询当前使用的短信模板
	 * @throws IOException 
	 */
	@RequestMapping(params="method=queryTempCode")
	@ResponseBody
	public void queryTempCode() throws IOException {
		 List<TabMessageTemp> list = tabMessageTempService.queryByTempCodeList();
		super.responseJson(list,this.response());
	}
	
	@RequestMapping(params="method=deleteByMsgUuid")
	@ResponseBody
	public void deleteByPhone(String msgUuid) throws IOException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int num=0;
		try {
			num = tabMessagePoolService.deleteMessagegPoolByPrimaryKey(msgUuid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(num>0) {
			resultMap.put("success", true);
			resultMap.put("msg", "保存成功");
		}else {
			resultMap.put("success", true);
			resultMap.put("msg", "保存失败");
		}
		super.responseJson(Boolean.valueOf(resultMap.get("success").toString()), resultMap.get("msg").toString(), this.response());
	}
	@RequestMapping(params="method=updateByPrimaryKey")
	@ResponseBody
	public void updateByPrimaryKey(TabMessagePool tabMessagePool) throws IOException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int num=0;
		try {
			num = tabMessagePoolService.updateByPrimaryKey(tabMessagePool);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(num>0) {
			resultMap.put("success", true);
			resultMap.put("msg", "保存成功");
		}else {
			resultMap.put("success", true);
			resultMap.put("msg", "保存失败");
		}
		super.responseJson(Boolean.valueOf(resultMap.get("success").toString()), resultMap.get("msg").toString(), this.response());
	}
	
	@RequestMapping(params="method=submit")
	public void submit(TabMessagePool tabMessagePool,ContentDataDto contentDataDto) throws IOException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		int num=0;
		try {
			String contents="";
			if(contentDataDto!=null) {
				contents=contentDataDto.getContent1()+"|"+contentDataDto.getContent2()+"|"+contentDataDto.getContent3()+"|"+contentDataDto.getContent4()+"|"+contentDataDto.getContent5();
			}
			tabMessagePool.setCustomVal(contents);
			if(tabMessagePool.getMsgUuid() ==null || tabMessagePool.getMsgUuid().equals("")) {
				num = tabMessagePoolService.insert(tabMessagePool);
			}else {
				num = tabMessagePoolService.updateByPrimaryKey(tabMessagePool);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(num>0) {
			resultMap.put("success", true);
			resultMap.put("msg", "保存成功");
		}else {
			resultMap.put("success", true);
			resultMap.put("msg", "保存失败");
		}
		super.responseJson(Boolean.valueOf(resultMap.get("success").toString()), resultMap.get("msg").toString(), this.response());
	}
	
	/**
	 * 跳转到新增页面
	 * @return
	 */
	@RequestMapping(params="method=toAddMessagePool")
	public String toAddMessagePool(HttpServletRequest request,HttpServletResponse response) {
		String msgUuid=request.getParameter("msgUuid");
		TabMessagePool tabMessagePool = new TabMessagePool();
		Map<String, Object> contentParamMap =null;
		if(msgUuid!=null) {
			tabMessagePool = tabMessagePoolService.queryPoolByUuid(msgUuid);
			if(StringUtils.isNotBlank(tabMessagePool.getCustomVal())) {
				String [] customVals = tabMessagePool.getCustomVal().split("\\|");
				contentParamMap = new HashMap<String, Object>();
				for (int i = 0; i < customVals.length; i++) {
					contentParamMap.put("content"+(i+1), customVals[i]);
				}
			}
		}
		request.setAttribute("tabMessagePool",tabMessagePool);
		request.setAttribute("contentParamMap",contentParamMap);
		return "backstage/message/addMessagePool";
	}
	
	/**
	 * 导入号码池信息
	 * @param file
	 * @param excelMessagePool
	 * @throws IOException 
	 */
	@RequestMapping(params="method=loadExcelMessagePool")
	public void loadExcelMessagePool() throws IOException {
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
	            
	            if(excelList!=null && excelList.size()>0){
	            	tabMessagePoolService.saveExcelMessageBusinessMethod(excelList);
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
	public void downloadExcelTemplate() throws UnsupportedEncodingException{
		String filename = "短信模板.xls";
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
	/**
	 * 手动调用批量发送短信
	 * @throws IOException 
	 */
	@RequestMapping(params="method=handSendSms")
	@ResponseBody
	public void handSendSms() throws IOException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			tabMessagePoolService.sendMsg();
			resultMap.put("success", true);
			resultMap.put("msg", "发送成功");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			resultMap.put("success", true);
			resultMap.put("msg", "发送失败："+e.getMessage());
		}
		super.responseJson(Boolean.valueOf(resultMap.get("success").toString()), resultMap.get("msg").toString(), this.response());
	}
	
	/**
	 * 跳转到消息池界面
	 * @return
	 */
	@RequestMapping(params="method=getBalance")
	public String getBalance(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("tabMessagePool",tabMessagePoolService.getBalance());
		return "backstage/message/smsBalance";
	}
}
