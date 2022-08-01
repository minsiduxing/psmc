package priv.guochun.psmc.system.framework.upload.controller;

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
import priv.guochun.psmc.system.framework.upload.base.PsmcBaseFileProcessService;
import priv.guochun.psmc.system.framework.upload.model.UploadFileModel;
import priv.guochun.psmc.system.framework.upload.util.FtpUtil;
import priv.guochun.psmc.system.framework.upload.util.PSMCFileUtils;
import priv.guochun.psmc.system.framework.util.MySpringApplicationContext;
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
	private PsmcBaseFileProcessService psmcBaseFileProcessService;
	@Autowired
	private TabAttachmentService tabAttachmentService;

	/**
	 * 文件上传控制器，主要提供给信息编辑模块使用
	 * @param request
	 * @param response
	 * @throws IllegalStateException
	 * @throws IOException
	 */
	@RequestMapping(params="method=fileUpload")
	@ResponseBody
	public void fileUpload(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
		UploadFileModel upf = psmcBaseFileProcessService.uploadFile(request);
		super.responseJson(true,upf.getFileCompleteUrl(), response);
	}

	@RequestMapping(params="method=fileUploadVideo")
	@ResponseBody
	public void fileUploadVideo(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
		UploadFileModel upf = psmcBaseFileProcessService.uploadFile(request);
		super.responseJson(true,upf.getFileCompleteUrl(), response);
	}



	@RequestMapping(params="method=fileDelete")
	@ResponseBody
	public void fileDelete(HttpServletRequest request,HttpServletResponse response,String filePath) throws IllegalStateException, IOException{
		psmcBaseFileProcessService.deleteFile(filePath);
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

		List<UploadFileModel> uploadFileModelList = psmcBaseFileProcessService.uploadFiles(request);
		String paths = "";
		if(uploadFileModelList != null && uploadFileModelList.size() > 0) {
			for (int i = 0; i < uploadFileModelList.size();  i++) {
				//添加附件信息
				TabAttachment attachment = new TabAttachment();
				attachment.setFileName(uploadFileModelList.get(i).getFileSystemName());
				attachment.setFilePath(uploadFileModelList.get(i).getFile_upload_real_path());
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

		List<UploadFileModel> uploadFileModelList = psmcBaseFileProcessService.uploadFiles(request);
		String paths = "";
		TabAttachment attachment = null;
		if(uploadFileModelList != null && uploadFileModelList.size() > 0) {
			for (int i = 0; i < uploadFileModelList.size();  i++) {
				//添加附件信息
				attachment = new TabAttachment();
				attachment.setFileName(uploadFileModelList.get(i).getFileSystemName());
				attachment.setFilePath(uploadFileModelList.get(i).getFile_upload_real_path());
				attachment.setFilePrefix(file_prefix_path);
				attachment.setFileRealName(uploadFileModelList.get(i).getFileRealName());
				attachment.setFileSuffix(uploadFileModelList.get(i).getSuffix());
				attachment.setSort(i + 1);
				tabAttachmentService.addAttachment(attachment);
			}
		}
		super.responseJson(attachment, response);
	}


}
