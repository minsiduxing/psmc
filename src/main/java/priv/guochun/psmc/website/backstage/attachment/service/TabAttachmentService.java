package priv.guochun.psmc.website.backstage.attachment.service;

import java.util.List;
import java.util.Map;

/**
 * 附件信息服务类
 * @author Administrator
 *
 */
public interface TabAttachmentService {

	/**
	 * 根据业务信息ID查询附件列表
	 * @param businessUuid
	 * @return
	 */
	public List<Map<String, Object>> queryAttachmentList(String businessUuid);
	
	/**
	 * 根据主键查询附件
	 * @param attachmentUuid
	 * @return
	 */
	public Map<String, Object> queryAttachmentById(String attachmentUuid);
	
	/**
	 * 添加附件信息
	 * @param businessUuid
	 * @param filePaths
	 */
	public void addAttachment(String businessUuid, String filePaths);
}
