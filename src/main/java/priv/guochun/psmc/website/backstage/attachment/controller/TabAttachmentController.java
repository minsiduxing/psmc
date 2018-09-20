package priv.guochun.psmc.website.backstage.attachment.controller;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.website.backstage.attachment.service.TabAttachmentService;

@Controller
@RequestMapping("/website/backstage/tabAttachmentController")
public class TabAttachmentController extends MyController {

	@Autowired
	private TabAttachmentService tabAttachmentService;
	
	/**
	 * 删除附件
	 * @param uuid
	 * @throws IOException
	 */
	@RequestMapping(params="method=deleteAttachment")
	public void deleteAttachment(String uuid) throws IOException{
		if(StringUtils.isBlank(uuid)){
			super.responseJson(false, "删除失败", this.response());
		}
		tabAttachmentService.deleteAttachmentById(uuid);
		super.responseJson(true, "删除成功", this.response());
	}
}
