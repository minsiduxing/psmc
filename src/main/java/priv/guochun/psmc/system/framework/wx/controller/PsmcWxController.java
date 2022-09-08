package priv.guochun.psmc.system.framework.wx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import priv.guochun.psmc.inquest.utils.HttpConnectUtil;
import priv.guochun.psmc.system.framework.activiti.model.FlowCommonParam;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.wx.PsmcWxService;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/system/framework/psmcWxController")
public class PsmcWxController extends MyController {

	@Autowired
	private PsmcWxService psmcWxService;

	@RequestMapping(params="method=getAccessToken")
	public void getAccessToken() throws IOException{
		MsgModel mm = MsgModel.buildDefaultSuccess(psmcWxService.getAccessToken());
		this.responseMsgModel(mm, this.response());
	}
	//上传临时素材（图片）
	@RequestMapping(params="method=uploadTemporaryMediaForImages")
	public void uploadTemporaryMediaForImages() throws IOException{
		MsgModel mm = psmcWxService.uploadTemporaryMediaForImage(new File("D:/2.jpg"));
		this.responseMsgModel(mm, this.response());
	}
	//获取临时素材
	@RequestMapping(params="method=getTemporaryMedia")
	public void getTemporaryMedia(String media_id) throws Exception {
		this.responseImage(psmcWxService.getTemporaryMedia(media_id), HttpConnectUtil.content_type_image_jpg,this.response());
	}

	//上传永久素材（图片）
	@RequestMapping(params="method=uploadPersistentMediaForImages")
	public void uploadPersistentMediaForImages() throws IOException{
		MsgModel mm = psmcWxService.uploadPersistentMediaForImage(new File("D:/2.jpg"),true);
		this.responseMsgModel(mm, this.response());
	}

	//删除永久素材（图片）
	@RequestMapping(params="method=delPersistentMedia")
	public void delPersistentMedia(String media_id) throws IOException{
		MsgModel mm = psmcWxService.delPersistentMedia(media_id);
		this.responseMsgModel(mm, this.response());
	}

	//获取永久素材
	@RequestMapping(params="method=getPersistentMedia")
	public void getPersistentMedia(String media_id) throws Exception {
		this.responseImage(psmcWxService.getPersistentMedia(media_id), HttpConnectUtil.content_type_image_jpg,this.response());
	}

}
