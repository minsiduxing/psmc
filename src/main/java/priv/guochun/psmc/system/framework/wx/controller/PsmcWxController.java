package priv.guochun.psmc.system.framework.wx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import priv.guochun.psmc.system.framework.activiti.model.FlowCommonParam;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.wx.PsmcWxService;

import java.io.File;
import java.io.IOException;

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

	@RequestMapping(params="method=uploadTemporaryMediaForImages")
	public void uploadTemporaryMediaForImages() throws IOException{
		MsgModel mm = psmcWxService.uploadTemporaryMediaForImage(new File("D:/2.jpg"));
		this.responseMsgModel(mm, this.response());
	}

	@RequestMapping(params="method=getTemporaryMedia")
	public void getTemporaryMedia(String media_id) throws IOException{
		MsgModel mm = psmcWxService.getTemporaryMedia(media_id);
		this.responseMsgModel(mm, this.response());
	}

}
