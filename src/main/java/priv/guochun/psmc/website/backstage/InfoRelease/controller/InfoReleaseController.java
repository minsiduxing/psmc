package priv.guochun.psmc.website.backstage.InfoRelease.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.Thumbnails.Builder;
import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.framework.upload.model.UploadFileModel;
import priv.guochun.psmc.system.framework.upload.service.UploadAssemblyInterface;
import priv.guochun.psmc.system.framework.upload.util.FtpUtil;
import priv.guochun.psmc.system.framework.upload.util.PSMCFileUtils;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;
import priv.guochun.psmc.system.util.ContantsUtil;
import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.JsonUtil;
import priv.guochun.psmc.system.util.SystemPropertiesUtil;
import priv.guochun.psmc.website.backstage.InfoRelease.model.InfoImage;
import priv.guochun.psmc.website.backstage.InfoRelease.model.InfoRelease;
import priv.guochun.psmc.website.backstage.InfoRelease.service.InfoReleaseService;
import priv.guochun.psmc.website.backstage.module.model.TabModule;
import priv.guochun.psmc.website.backstage.module.service.TabModuleService;

@Controller
@RequestMapping("/website/backstage/InfoReleaseController")
public class InfoReleaseController extends MyController{

	@Autowired
	private InfoReleaseService infoReleaseService;
	
	@Autowired
	private UploadAssemblyInterface uploadAssemblyInterface;
	
	/**
	 * 查询信息列表
	 * @param myPage
	 * @throws IOException 
	 */
	@RequestMapping(params="method=getInfoReleaseList")
	@ResponseBody
	public void getInfoReleaseList(MyPage myPage, String oneLevelClassify) throws IOException{
		Map<String,Object> parameterMap = myPage.getQueryParams();
		if(parameterMap == null){
			parameterMap = new HashMap<String, Object>();
		}
		parameterMap.put("oneLevelClassify", oneLevelClassify);
		myPage.setQueryParams(parameterMap);
		myPage = infoReleaseService.getInfoReleaseListBusinessMethod(myPage);
		super.responseJson(JsonUtil.convertToJSONObject(myPage), this.response());
	}
	
	/**
	 * 保存或修改发布信息
	 * @param request
	 * @param infoRelease
	 * @param module
	 * @param isEdit
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params="method=saveOrUpdateInfoRelease")
	public void saveOrUpdateInfoRelease(HttpServletRequest request,InfoRelease infoRelease,TabModule module,String isEdit,HttpServletResponse response) throws IOException{
		if(isEdit.equals("add")){
			infoRelease.setNewsDate(DateUtil.getCurrentTimstamp());
			module.setCreateAccUuid(this.getUserBySeesion(request).getUserUuid());
		}else{
			module.setModelUuid(infoRelease.getNewsUuid());
			module.setModifyAccUuid(this.getUserBySeesion(request).getUserUuid());
		}

		PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
		Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
		Map<String, String> map = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
		//这里只改了file_prefix_path从缓存取，因为12、14分类是老的版本，其他地方基本不会用，所以暂时不改了，后续新开发的一律从缓存取
		String file_prefix_path =map.get("file_prefix_path").toString();
		infoRelease.setImagePath(file_prefix_path);


		String recipes_image_path =map.get("recipes_image_path").toString();
		String notice_image_path =map.get("notice_image_path").toString();
		String news_image_path =map.get("file_prefix_path").toString();
		String Legal_provisions_image_path =map.get("Legal_provisions_image_path").toString();

		/**
		 * 以下代码是设置新闻略缩图的默认图片存储地址的
		 */
		if(ContantsUtil.IS_CUSTOM_0.equals(infoRelease.getIsCustom()) && StringUtils.isBlank(infoRelease.getImagePath())){
				if(ContantsUtil.ONE_LEVEL_CLASSIFY_12.equals(module.getOneLevelClassify())){
					infoRelease.setImagePath(file_prefix_path + Legal_provisions_image_path);
				}
			//早知道信息分类
				if(ContantsUtil.ONE_LEVEL_CLASSIFY_14.equals(module.getOneLevelClassify())){
					if(ContantsUtil.TOW_LEVEL_CLASSIFY_1401.equals(module.getTowLevelClassify())){
						infoRelease.setImagePath(file_prefix_path + recipes_image_path);
					}
					if(ContantsUtil.TOW_LEVEL_CLASSIFY_1402.equals(module.getTowLevelClassify())){
						infoRelease.setImagePath(file_prefix_path + notice_image_path);
					}
				if(ContantsUtil.TOW_LEVEL_CLASSIFY_1403.equals(module.getTowLevelClassify())){
					infoRelease.setImagePath(file_prefix_path + news_image_path);
				}
				if(ContantsUtil.TOW_LEVEL_CLASSIFY_1405.equals(module.getTowLevelClassify())){
					infoRelease.setImagePath(file_prefix_path + Legal_provisions_image_path);
				}
				if(ContantsUtil.TOW_LEVEL_CLASSIFY_1406.equals(module.getTowLevelClassify())){
                    infoRelease.setImagePath(file_prefix_path + notice_image_path);
                }
			}
			if(ContantsUtil.ONE_LEVEL_CLASSIFY_15.equals(module.getOneLevelClassify())){
				infoRelease.setImagePath(file_prefix_path + news_image_path);
			}
		}
		infoReleaseService.saveOrUpdateInfoReleaseBusinessMethod(infoRelease, module);
		super.responseJson(true, "操作成功!", response);
	}
	
	/**
	 * 删除信息
	 * @param uuids
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(params="method=infoDelete")
	public void deleteInfoReleaseByUuids(String uuids, HttpServletResponse response) throws IOException{
		infoReleaseService.deleteInfoReleaseByUuidsBusinessMethod(uuids);
		super.responseJson(true, "信息删除成功!", response);
	}
	
	/**
	 * 审核信息
	 * @param response
	 * @param request
	 * @param newsIds
	 * @throws IOException 
	 */
	@RequestMapping(params="method=executeAuditInfo")
	public void executeAuditInfo(HttpServletResponse response,HttpServletRequest request,String uuids) throws IOException{
		String userId = this.getUserBySeesion(request).getUserUuid();
		infoReleaseService.executeAuditModuleBusinessMethod(uuids, userId);
		super.responseJson(true, "信息审核成功!", response);
	}
	
	/**
	 * 发布信息
	 * @param response
	 * @param request
	 * @param newsIds
	 * @throws IOException 
	 */
	@RequestMapping(params="method=executeReleaseInfo")
	public void executeReleaseInfo(HttpServletResponse response,HttpServletRequest request,String uuids,Timestamp publishExpireDate) throws IOException{
		String userId = this.getUserBySeesion(request).getUserUuid();
		infoReleaseService.executeReleaseModuleBusinessMethod(uuids, userId, publishExpireDate);
		super.responseJson(true, "信息发布成功!", response);
	}
	/**
	 * 信息预览
	 * @param response
	 * @param request
	 * @param newsId
	 * @throws IOException
	 */
	@RequestMapping(params="method=getInfoReleaseByUuid")
	public void getInfoReleaseByUuid(HttpServletResponse response,HttpServletRequest request,String uuid) throws IOException{
		Map<String, Object> map = infoReleaseService.getInfoReleaseByUuidBusinessMethod(uuid);
		super.responseJson(JsonUtil.convertToJSONObject(map), response);
	}
	
	/**
	 * 撤销
	 * @param uuids
	 * @throws IOException
	 */
	@RequestMapping(params="method=executeUndo")
	public void executeUndo(String uuids) throws IOException {
		TabModule module = new TabModule();
		module.setModifyAccUuid(this.getUserBySeesion(this.request()).getUserUuid());
		infoReleaseService.executeUndoBusinessMethod(uuids, module);
		super.responseJson(true, "操作成功!", this.response());
	}
	
	/**
	 * 跳转到信息发布列表界面
	 * @return
	 */
	@RequestMapping(params="method=infoReleaseList")
	public String infoReleaseList(){
		return "backstage/infoRelease/infoReleaseList";
	}
	
	/**
	 * 跳转到信息添加或编辑页面
	 * @param uuid
	 * @param isEdit
	 * @param oneLevelClassify
	 * @param model
	 * @return
	 */
	@RequestMapping(params="method=infoEdit")
	public String infoEdit(String uuid, String isEdit, String oneLevelClassify,Model model){
		if(StringUtils.isNotBlank(uuid)){
			Map<String,Object> InfoRelease = infoReleaseService.getInfoReleaseByUuidBusinessMethod(uuid);
//			//获取当前用户角色
//			String userRole = this.getUserBySeesion(this.request()).getRoleNo();
//			//获取信息分类
//			String oneLevelClassify = getOneLevelClassify(userRole);
			model.addAttribute("info", InfoRelease);
		}
		model.addAttribute("isEdit", isEdit);
		model.addAttribute("oneLevelClassify", oneLevelClassify);
		return "backstage/infoRelease/infoAddOrEdit";
	}
	
	
	@RequestMapping(params="method=uploadPicture")
	@ResponseBody
	public void uploadPicture(HttpServletRequest request,
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
				InfoImage nm = new InfoImage();
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
	@RequestMapping(params="method=confirmPicture")
	@ResponseBody
	public  void confirmPicture(int x,int y,int w,int h,String pirSrc,HttpServletResponse response) throws IOException {
		Map<String,Object> returnmap = new HashMap<String,Object>();
		PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
		Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
		Map<String, String> map = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
		String system_upload_dir =map.get("system_upload_dir").toString();

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
			upm.setFile_upload_real_path(system_upload_dir);
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
	
}
