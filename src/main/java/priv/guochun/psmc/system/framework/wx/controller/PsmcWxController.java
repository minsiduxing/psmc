package priv.guochun.psmc.system.framework.wx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import priv.guochun.psmc.inquest.utils.HttpConnectUtil;
import priv.guochun.psmc.system.framework.activiti.model.FlowCommonParam;
import priv.guochun.psmc.system.framework.controller.MyController;
import priv.guochun.psmc.system.framework.model.MsgModel;
import priv.guochun.psmc.system.framework.page.MyPage;
import priv.guochun.psmc.system.framework.wx.PsmcWxService;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

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
		MsgModel mm = psmcWxService.uploadPersistentMediaForImage(new File("D:/2.jpg"),false);
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

	@RequestMapping(params="method=queryPersistentMediaList")
	public void queryPersistentMediaList(String type,String offset,String count) throws IOException{
		StringBuffer sb1 = new StringBuffer();
		sb1.append("{");
		sb1.append("\"type\":").append("\"").append(type).append("\"").append(",");
		sb1.append("\"offset\":").append("\"").append(offset).append("\"").append(",");
		sb1.append("\"count\":").append("\"").append(count).append("\"");
		sb1.append("}");
		MsgModel mm = psmcWxService.getPersistentMediaList(sb1.toString());
		this.responseMsgModel(mm, this.response());
	}

	@RequestMapping(params="method=saveDrafts")
	public void saveDrafts() throws Exception {
		StringBuffer sb1 = new StringBuffer();
		sb1.append("{");
			sb1.append("\"articles\":[");
				for(int i=0;i<1;i++){
					sb1.append("{");
						sb1.append("\"title\":").append("\"").append("title").append(i).append("\"").append(",");
						sb1.append("\"author\":").append("\"").append("author").append(i).append("\"").append(",");
						sb1.append("\"digest\":").append("\"").append("digest").append(i).append("\"").append(",");
						sb1.append("\"content\":").append("\"").append("content").append(i).append("\"").append(",");
						sb1.append("\"content_source_url\":").append("\"").append("").append("\"").append(",");
						sb1.append("\"thumb_media_id\":").append("\"").append("kp3Drq-j05rhWyF1_VF2TNh0TSGCbwzreOnECnQTu38J9XXEGfhsv48o_haDmfvB").append("\"").append(",");
						sb1.append("\"need_open_comment\":").append("\"").append("0").append("\"").append(",");
						sb1.append("\"only_fans_can_comment\":").append("\"").append("0").append("\"");
					sb1.append("}");
				}
			sb1.append("]");
		sb1.append("}");
		this.responseJson(psmcWxService.saveDrafts(sb1.toString()),this.response());
	}

	@RequestMapping(params="method=delDrafts")
	public void delDrafts(String media_id) throws Exception {
		StringBuffer sb1 = new StringBuffer();
		sb1.append("{");
			sb1.append("\"media_id\":").append("\"").append(media_id).append("\"").append(",");
		sb1.append("}");
		this.responseJson(psmcWxService.delDrafts(sb1.toString()),this.response());
	}

	@RequestMapping(params="method=getDrafts")
	public void getDrafts(String media_id) throws Exception {
		StringBuffer sb1 = new StringBuffer();
		sb1.append("{");
		sb1.append("\"media_id\":").append("\"").append(media_id).append("\"").append(",");
		sb1.append("}");
		this.responseJson(psmcWxService.getDrafts(sb1.toString()),this.response());
	}


	@RequestMapping(params="method=updateDrafts")
	public void updateDrafts(String media_id,String index) throws Exception {
		StringBuffer sb1 = new StringBuffer();
		sb1.append("{");
			sb1.append("\"media_id\":").append("\"").append(media_id).append("\"").append(",");
			sb1.append("\"index\":").append("\"").append(0).append("\"").append(",");
			sb1.append("\"articles\":");
				for(int i=0;i<1;i++){
					sb1.append("{");
					sb1.append("\"title\":").append("\"").append("title").append(i).append("\"").append(",");
					sb1.append("\"author\":").append("\"").append("author").append(i).append("\"").append(",");
					sb1.append("\"digest\":").append("\"").append("digest").append(i).append("\"").append(",");
					sb1.append("\"content\":").append("\"").append("content").append(i).append("\"").append(",");
					sb1.append("\"content_source_url\":").append("\"").append("").append("\"").append(",");
					sb1.append("\"thumb_media_id\":").append("\"").append("kp3Drq-j05rhWyF1_VF2TNh0TSGCbwzreOnECnQTu38J9XXEGfhsv48o_haDmfvB").append("\"").append(",");
					sb1.append("\"need_open_comment\":").append("\"").append("0").append("\"").append(",");
					sb1.append("\"only_fans_can_comment\":").append("\"").append("0").append("\"");
					sb1.append("}");
				}
		sb1.append("}");
		this.responseJson(psmcWxService.updateDrafts(sb1.toString()),this.response());
	}
}
