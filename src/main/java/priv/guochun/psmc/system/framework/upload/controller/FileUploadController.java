package priv.guochun.psmc.system.framework.upload.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
@Scope("prototype")
@Controller
@RequestMapping("/system/freamwork/fileUploadController")
public class FileUploadController extends MyController {
	@Autowired
	private UploadAssemblyInterface uploadAssemblyInterface;
	@RequestMapping(params="method=testFileUpload")
	@ResponseBody
	public void testFileUpload(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException{
		UploadFileModel upf = uploadAssemblyInterface.getFile(request);
		FtpUtil ftu = FtpUtil.getFtputil();
		ftu.uploadFile(upf);
		super.responseJson(true,upf.getFileRealName()+"上传成功！", response);
	}
	@RequestMapping(params="method=testFileDownload")
	public View testFileDownload(HttpServletRequest request,HttpServletResponse response,String filePath) throws IllegalStateException, IOException{
		FtpUtil ftu = FtpUtil.getFtputil();
		File resFiel = ftu.downloadFileByFtp(filePath);
		return this.responseFile(resFiel, filePath.substring(filePath.lastIndexOf("/")+1), response);
	}
	@RequestMapping(params="method=testFileDelete")
	@ResponseBody
	public void testFileDelete(HttpServletRequest request,HttpServletResponse response,String filePath) throws IllegalStateException, IOException{
		FtpUtil ftu = FtpUtil.getFtputil();
	     ftu.deleteFile(filePath);
		super.responseJson(true,filePath+"删除成功！", response);
	}
}
