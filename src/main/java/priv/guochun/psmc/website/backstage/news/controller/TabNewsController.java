package priv.guochun.psmc.website.backstage.news.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.Thumbnails.Builder;

import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.framework.upload.model.UploadFileModel;
import priv.guochun.psmc.system.framework.upload.service.UploadAssemblyInterface;
import priv.guochun.psmc.system.framework.upload.util.FtpUtil;
import priv.guochun.psmc.system.framework.upload.util.PSMCFileUtils;
import priv.guochun.psmc.system.util.JsonUtil;
import priv.guochun.psmc.system.util.SystemPropertiesUtil;
import priv.guochun.psmc.website.backstage.module.model.TabModule;
import priv.guochun.psmc.website.backstage.news.model.NewsImage;
import priv.guochun.psmc.website.backstage.news.model.TabNews;
import priv.guochun.psmc.website.backstage.news.service.TabNewsService;
import priv.guochun.psmc.website.enums.ModuleEnum;
import priv.guochun.psmc.website.stage.bhkn.service.GenerateStageHtmlService;
@Scope("prototype")
@Controller
@RequestMapping("/website/backstage/tabNewsController")
public class TabNewsController extends MyController {
	protected static final Logger logger = LoggerFactory.getLogger(TabNewsController.class);
	@Autowired
	private TabNewsService tabNewsService;
	@Autowired
	private UploadAssemblyInterface uploadAssemblyInterface;
	@Autowired
	private GenerateStageHtmlService generateStageHtmlService;
	
	public final static int T_W = 120;
	@RequestMapping(params="method=index")
	public String index(){
		return "backstage/news/newslist";
	}
	@RequestMapping(params="method=getNesPage")
	@ResponseBody
	public void getNesPage(HttpServletRequest request,
		 	HttpServletResponse response,MyPage mypage) throws IOException{
		String userRole = this.getUserBySeesion(request).getRoleNo();
		if("sys_news_add".equals(userRole)){
			mypage = tabNewsService.getNewsByConditionBusinessMethod(mypage,this.getUserBySeesion(request).getUserUuid());
		}else{
			mypage = tabNewsService.getNewsByConditionBusinessMethod(mypage);
		}
		super.responseJson(JsonUtil.convertToJSONObject(mypage), response);
	}
	@RequestMapping(params="method=newsSaveOrUpdate")
	public void newsSaveOrUpdate(HttpServletRequest request,TabNews  tn ,TabModule tm,String isEdit,HttpServletResponse response) throws IOException{
		//新增
		if(StringUtils.isBlank(isEdit)){
			tm.setCreateAccUuid(this.getUserBySeesion(request).getUserUuid());
		}else{
			tm.setModelUuid(tn.getNewsUuid());
			tm.setModifyAccUuid(this.getUserBySeesion(request).getUserUuid());
		}	
		tabNewsService.saveOrUpdateTabNewsBusinessMethod(tn, tm);
		super.responseJson(true, "操作成功!", response);
	}
	@RequestMapping(params="method=newsEdit")
	public String newsEdit(String uuid,Model model){
		Map<String,Object> tabNews = tabNewsService.getNewsByNewsUuid(uuid);
		model.addAttribute("news", tabNews);
		model.addAttribute("isEdit", "isEdit");
		return "backstage/news/newsaddoredit";
	}
	@RequestMapping(params="method=newsDelete")
	public void newsDelete(HttpServletResponse response,String newsIds) throws IOException{
		tabNewsService.deleteTabNewsByUuidsBusinessMethod(newsIds);
		super.responseJson(true, "删除新闻成功!", response);
	}
	@RequestMapping(params="method=newsAudit")
	@ResponseBody
	public void newsAudit(HttpServletResponse response,HttpServletRequest request,TabModule tam) throws IOException{
		tam.setAudit(Integer.parseInt(ModuleEnum.AUDITED_PASS.getValue()));
		tam.setAuditAccUuid(this.getUserBySeesion(request).getUserUuid());
		tabNewsService.executeAuditNewsBusinessMethod(tam);
		super.responseJson(true, "审核新闻成功!", response);
	}
	@RequestMapping(params="method=newsRelease")
	@ResponseBody
	public void newsRelease(HttpServletResponse response,HttpServletRequest request,TabModule tam) throws IOException{
		tam.setReleaseStatus(ModuleEnum.IS_RELEASEED.getValue());
		tam.setReleaseAccUuid(this.getUserBySeesion(request).getUserUuid());
		//发布新闻
		tabNewsService.executeReleaseNewsBusinessMethod(tam);	
		//生成列表页面
		generateStageHtmlService.generateInofHtml();
		//生成会员信息列表
		generateStageHtmlService.generateMemberInofHtml();
		super.responseJson(true, "发布新闻成功!", response);
	}
	@RequestMapping(params="method=uploadPic")
	@ResponseBody
	public void uploadPic(HttpServletRequest request,
		 	HttpServletResponse response) throws IOException{
		Map<String,Object> returnmap = new HashMap<String,Object>();
	    	UploadFileModel upf = uploadAssemblyInterface.getFile(request);
	    	//判断图片的大小是否符合系统要求
	    	String tempFilePath = upf.getTemp_file_path();
	    	File tempPic = upf.getFile();
	    	String newPath = PSMCFileUtils.getFileDirectroyPath(tempFilePath);
	    	String newName = PSMCFileUtils.getFileNameByPath(tempFilePath);
	    	double newsw = new Double(SystemPropertiesUtil.getNewsPicWidth());
			double newsh = new Double(SystemPropertiesUtil.getNewsPicHeight());
			BufferedImage bi = ImageIO.read( new FileInputStream(tempPic));
			double tempPicw = bi.getWidth();
		//	double tempPich = bi.getHeight();
			if(tempPicw>newsw) {
				//图片的大小是否符合要求
				Builder<BufferedImage> b = Thumbnails.of(bi);
				//判断文件是否需要缩放
				if(tempPicw-newsw>150) {
					b.scale((newsw+150)/tempPicw);
				} else {
					b.scale(1.0);
				}
				BufferedImage bi2 = b.asBufferedImage();
				b.toFile(newPath+"/"+newName);
				//传递前台需要的参数
				NewsImage nm = new NewsImage();
				nm.setImgHeight(bi2.getHeight());
				nm.setImgWidth(bi2.getWidth());
				nm.setNewsPicWidth(new Double(newsw).intValue() );
				nm.setNewsPicHeight(new Double(newsh).intValue());
				returnmap.put("result", 1);
				JSONObject json = (JSONObject) JSONObject.wrap(nm);
				returnmap.put("newsPic", json);
				returnmap.put("picSrc",upf.getTemp_file_path());
			}else{
				//不符合要求删除临时文件
				tempPic.delete();
				returnmap.put("result", 0);
				returnmap.put("msg","图片的尺寸不在有效范围中");
			}
	    super.responseJson(JsonUtil.convertToJSONObject(returnmap), response);
	}
	@RequestMapping(params="method=confirmPic")
	@ResponseBody
	public  void confirmPic(int x,int y,int w,int h,String pirSrc,HttpServletResponse response) throws IOException {
		Map<String,Object> returnmap = new HashMap<String,Object>();
		try {
			int newsw = new Integer(SystemPropertiesUtil.getNewsPicWidth());
			int newsh = new Integer(SystemPropertiesUtil.getNewsPicHeight());
			File tf = new File(pirSrc);
			BufferedImage bi = ImageIO.read(tf);
			Builder<BufferedImage> b = Thumbnails.of(bi);
			BufferedImage bi2 = b.sourceRegion(x, y, w, h).size(newsw, newsh).asBufferedImage();
			//写缩略图
			Thumbnails.of(bi2).scale(1).toFile(pirSrc);
			//从临时文件上传文件到正式服务器
			UploadFileModel upm = new UploadFileModel();
			upm.setFile(tf);
			upm.setFile_upload_real_path(SystemPropertiesUtil.getUploadPathPropertyValue());
			upm.setFileSize(String.valueOf(tf.length()));
			upm.setTemp_file_path(pirSrc);
			FtpUtil ftu = FtpUtil.getFtputil();
			String resFiel = ftu.uploadFile(upm);
			tf.delete();
			returnmap.put("result", 1);
			returnmap.put("newsrc", resFiel+PSMCFileUtils.getFileNameByPath(pirSrc));
		} catch (IOException e) {
			e.printStackTrace();
			returnmap.put("result", 0);
		}
		  super.responseJson(JsonUtil.convertToJSONObject(returnmap), response);
	}
	@RequestMapping(params="method=getNewsContent")
	@ResponseBody
	public void getNewsContent(String uuid,Model model,HttpServletResponse response) throws IOException{
		Map<String,Object> tabNews = tabNewsService.getNewsByNewsUuid(uuid);
		super.responseJson(JsonUtil.convertToJSONObject(tabNews), response);
	}
	@RequestMapping(params="method=getNewsTitlePager")
	@ResponseBody
	public void getNewsTitlePager(HttpServletRequest request,
		 	HttpServletResponse response,MyPage mypage,String towLevelClassify) throws IOException{
		mypage = tabNewsService.getShowNewsTitlesPagerByTowLevelClassify(mypage, towLevelClassify);
		super.responseJson(JsonUtil.convertToJSONObject(mypage), response);
	}
}
