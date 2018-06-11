package priv.guochun.psmc.system.framework.upload.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.View;

import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.upload.model.UploadFileModel;
import priv.guochun.psmc.system.framework.upload.service.UploadAssemblyInterface;
import priv.guochun.psmc.system.framework.upload.util.FtpUtil;
import priv.guochun.psmc.system.framework.upload.util.PSMCFileUtils;
import priv.guochun.psmc.system.util.ContantsUtil;
@Scope("prototype")
@Controller
@RequestMapping("/system/freamwork/fileUploadController")
public class FileUploadController extends MyController {
	@Autowired
	private UploadAssemblyInterface uploadAssemblyInterface;
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
	
	private String getImagePath(String oneLevelClassify){
		String imagePath = "";
		switch (oneLevelClassify) {
			case ContantsUtil.ONE_LEVEL_CLASSIFY_11:
				imagePath = ContantsUtil.INNOVATION;
				break;
			case ContantsUtil.ONE_LEVEL_CLASSIFY_12:
				imagePath = ContantsUtil.ASSISTANCE;
				break;
			case ContantsUtil.ONE_LEVEL_CLASSIFY_13:
				imagePath = ContantsUtil.LITERARY_FORM;
				break;
			case ContantsUtil.ONE_LEVEL_CLASSIFY_14:
				imagePath = ContantsUtil.LOGISTICS_CENTER;
				break;
		default:
			break;
		}
		return imagePath;
	}
}
