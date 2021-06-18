package priv.guochun.psmc.system.framework.upload.controller;

import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;
import priv.guochun.psmc.system.framework.cache.CacheContants;
import priv.guochun.psmc.system.framework.cache.PsmcCacheFactory;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.upload.model.UploadFileModel;
import priv.guochun.psmc.system.framework.upload.service.UploadAssemblyInterface;
import priv.guochun.psmc.system.framework.upload.util.FtpUtil;
import priv.guochun.psmc.system.framework.upload.util.PSMCFileUtils;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;
import priv.guochun.psmc.system.util.ContantsUtil;
import priv.guochun.psmc.website.backstage.attachment.model.TabAttachment;
import priv.guochun.psmc.website.backstage.attachment.service.TabAttachmentService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 文件上传控制器
 */
@Scope("prototype")
@Controller
@RequestMapping("/system/freamwork/fileUploadController")
public class FileUploadController extends MyController {
	@Autowired
	private UploadAssemblyInterface uploadAssemblyInterface;
	@Autowired
	private TabAttachmentService tabAttachmentService;

	/**
	 * 文件上传控制器，主要提供给信息编辑模块使用
	 * @param request
	 * @param response
	 * @param oneLevelClassify
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(params="method=fileUpload")
	@ResponseBody
	public void fileUpload(HttpServletRequest request,HttpServletResponse response,String oneLevelClassify) throws IllegalStateException, IOException{
		request.setAttribute("imagePath", this.getImagePath(oneLevelClassify));
		UploadFileModel upf = uploadAssemblyInterface.getFile(request);
		FtpUtil ftu = FtpUtil.getFtputil();
		String filepath = ftu.uploadFile(upf);
		super.responseJson(true,filepath, response);
	}
	@RequestMapping(params="method=testFileDownload")
	public View testFileDownload(HttpServletRequest request,HttpServletResponse response,String filePath) throws IllegalStateException, IOException{
		FtpUtil ftu = FtpUtil.getFtputil();
		File resFiel = ftu.downloadFileByFtp(filePath);
		return this.responseFile(resFiel, PSMCFileUtils.getFileNameByPath(filePath), response);
	}
	@RequestMapping(params="method=getImage")
	public void getImage(HttpServletRequest request,HttpServletResponse response,String filePath) throws Exception{
		filePath = PSMCFileUtils.decodedFileName(filePath);
		FtpUtil ftu = FtpUtil.getFtputil();
		File resFiel = ftu.downloadFileByFtp(filePath);
		this.responseImage(response, resFiel);
	}
	@RequestMapping(params="method=fileDelete")
	@ResponseBody
	public void fileDelete(HttpServletRequest request,HttpServletResponse response,String filePath) throws IllegalStateException, IOException{
		FtpUtil ftu = FtpUtil.getFtputil();
	     ftu.deleteFile(filePath);
		super.responseJson(true,"文件："+filePath+"删除成功！", response);
	}
	@RequestMapping(params="method=listFiles")
	@ResponseBody
	public void listFiles(HttpServletRequest request,HttpServletResponse response,String filePath) throws IllegalStateException, IOException{
		FtpUtil ftu = FtpUtil.getFtputil();
	    Map<String,Object> resm = ftu.getFileList(filePath);
	    JSONObject jsob = new JSONObject(resm);
		super.responseJson(jsob, response);
	}
	
	/**
	 * 文件批量上传（目前是提供给移动端使用）这个方法不应该放在公共里面，应该放在陕测的里面，不要共用
	 * @param request
	 * @param response
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(params="method=fileBatchUpload")
	@ResponseBody
	public void fileBatchUpload(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
		PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
		Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
		Map<String, String> map = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
		String file_prefix_path =map.get("file_prefix_path").toString();
		String mobile_image_path =map.get("mobile_image_path").toString();

		request.setAttribute("imagePath", mobile_image_path);
		List<UploadFileModel> uploadFileModelList = uploadAssemblyInterface.getFiles(request);
		FtpUtil ftu = FtpUtil.getFtputil();
		String paths = "";
		if(uploadFileModelList != null && uploadFileModelList.size() > 0) {
			for (int i = 0; i < uploadFileModelList.size();  i++) {
				String filepath = ftu.uploadFile(uploadFileModelList.get(i));
				//添加附件信息
				TabAttachment attachment = new TabAttachment();
				attachment.setFileName(uploadFileModelList.get(i).getFileSystemName());
				attachment.setFilePath(uploadFileModelList.get(i).getCustom_file_path());
				attachment.setFilePrefix(file_prefix_path);
				attachment.setFileRealName(uploadFileModelList.get(i).getFileRealName());
				attachment.setFileSuffix(uploadFileModelList.get(i).getSuffix());
				attachment.setSort(i + 1);
				String attachmentUuid = tabAttachmentService.addAttachment(attachment);
				if(i > 0) {
					paths += ",";
				}
				paths += attachmentUuid;
			}
		}
		super.responseJson(true,paths, response);
	}
	
	/**
	 * 文件上传
	 * @param request
	 * @param response
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(params="method=fileUploadByPC")
	@ResponseBody
	public void fileUploadByPC(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
		PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
		Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
		Map<String, String> map = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
		String file_prefix_path =map.get("file_prefix_path").toString();
		String mobile_image_path =map.get("mobile_image_path").toString();

		request.setAttribute("imagePath", mobile_image_path);
		List<UploadFileModel> uploadFileModelList = uploadAssemblyInterface.getFiles(request);
		FtpUtil ftu = FtpUtil.getFtputil();
		String paths = "";
		TabAttachment attachment = null;
		if(uploadFileModelList != null && uploadFileModelList.size() > 0) {
			for (int i = 0; i < uploadFileModelList.size();  i++) {
				String filepath = ftu.uploadFile(uploadFileModelList.get(i));
				//添加附件信息
				attachment = new TabAttachment();
				attachment.setFileName(uploadFileModelList.get(i).getFileSystemName());
				attachment.setFilePath(uploadFileModelList.get(i).getCustom_file_path());
				attachment.setFilePrefix(file_prefix_path);
				attachment.setFileRealName(uploadFileModelList.get(i).getFileRealName());
				attachment.setFileSuffix(uploadFileModelList.get(i).getSuffix());
				attachment.setSort(i + 1);
				String attachmentUuid = tabAttachmentService.addAttachment(attachment);
			}
		}
		super.responseJson(attachment, response);
	}

	private String getImagePath(String oneLevelClassify){
		PsmcCacheFactory psmcCacheFactory = (PsmcCacheFactory) MySpringApplicationContext.getObject("psmcCacheFactory");
		Cache cache = psmcCacheFactory.getCacheSysKeyInfo();
		Map<String, String> map = cache.get(CacheContants.CACHE_SYSTEM_KEY_INFO_KEY, Map.class);
		String activity_custom =map.get("activity_custom").toString();
		String innovation_custom =map.get("innovation_custom").toString();
		String assistance_custom =map.get("assistance_custom").toString();
		String literary_form_custom =map.get("literary_form_custom").toString();
		String logistics_center_custom =map.get("logistics_center_custom").toString();
		String dept_innovation_custom =map.get("dept_innovation_custom").toString();
		String dept_literary_form_custom =map.get("dept_literary_form_custom").toString();

		String imagePath = "";
		if(StringUtils.isNotBlank(oneLevelClassify)){
			switch (oneLevelClassify) {
			case ContantsUtil.ONE_LEVEL_CLASSIFY_11:
				imagePath = innovation_custom;
				break;
			case ContantsUtil.ONE_LEVEL_CLASSIFY_12:
				imagePath = assistance_custom;
				break;
			case ContantsUtil.ONE_LEVEL_CLASSIFY_13:
				imagePath = literary_form_custom;
				break;
			case ContantsUtil.ONE_LEVEL_CLASSIFY_14:
				imagePath = logistics_center_custom;
				break;
			case ContantsUtil.DEPT_TYPE_1:
				imagePath = dept_innovation_custom;
				break;
			case ContantsUtil.DEPT_TYPE_2:
				imagePath = dept_literary_form_custom;
				break;
			case ContantsUtil.ACTIVITY:
				imagePath = activity_custom;
				break;
			default:
				break;
			}
		}
		return imagePath;
	}
}
