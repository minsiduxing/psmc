package priv.guochun.psmc.website.backstage.attachment.service;

import java.util.List;
import java.util.Map;

import priv.guochun.psmc.website.backstage.attachment.model.TabAttachment;

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
	 * @param attachment
	 */
	public String addAttachment(TabAttachment attachment);
	
	/**
	 * 更新业务信息ID到附件表中
	 * @param businessUuid
	 * @param attachmentUuids
	 */
	public void updateBusinessUuidToAttachment(String businessUuid, String attachmentUuids);
}
