package priv.guochun.psmc.website.backstage.attachment.service.impl;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.website.backstage.attachment.model.TabAttachment;
import priv.guochun.psmc.website.backstage.attachment.service.TabAttachmentService;
import priv.guochun.psmc.website.backstage.common.BaseDao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TabAttachmentServiceImpl implements TabAttachmentService {

	private final static String selectAttachmentList = "selectAttachmentList";
	private final static String deleteAttachment = "deleteAttachment";
	private final static String insertAttachment = "insertAttachment";
	private final static String updateAttachment = "updateAttachment";
	
	@Autowired
	private BaseDao baseDao;
	
	@Override
	public List<Map<String, Object>> queryAttachmentList(String businessUuid){
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("businessUuid", businessUuid);
		return baseDao.queryForList(selectAttachmentList, condition);
	}
	
	@Override
	public Map<String, Object> queryAttachmentById(String attachmentUuid){
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("attachmentUuid", attachmentUuid);
		return (Map<String, Object>) baseDao.queryForObject(selectAttachmentList, condition);
	}
	
	@Override
	public String addAttachment(TabAttachment attachment) {
		String uuid = UUIDGenerator.createUUID();
		attachment.setAttachmentUuid(uuid);
		attachment.setUploadDate(DateUtil.getCurrentTimstamp());
		baseDao.insert(insertAttachment, attachment);
		return uuid;
	}
	
	@Override
	public void updateBusinessUuidToAttachment(String businessUuid, String attachmentUuids) {
		if(StringUtils.isNotBlank(attachmentUuids)) {
			String[] attachUuidArray = attachmentUuids.split(",");
			TabAttachment attachment = new TabAttachment();
			attachment.setBusinessUuid(businessUuid);
			for(String uuid : attachUuidArray) {
				attachment.setAttachmentUuid(uuid);
				//将业务信息ID更新到附件表中
				baseDao.update(updateAttachment, attachment);
			}
			
		}
	}
	
	@Override
	public void deleteAttachmentById(String uuid){
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("attachmentUuid", uuid);
		baseDao.delete(deleteAttachment, condition);
	}
}
