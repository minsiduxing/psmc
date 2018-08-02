package priv.guochun.psmc.website.backstage.attachment.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import priv.guochun.psmc.system.util.DateUtil;
import priv.guochun.psmc.system.util.SystemPropertiesUtil;
import priv.guochun.psmc.system.util.UUIDGenerator;
import priv.guochun.psmc.website.backstage.attachment.model.TabAttachment;
import priv.guochun.psmc.website.backstage.attachment.service.TabAttachmentService;
import priv.guochun.psmc.website.backstage.common.BaseDao;

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
	public void addAttachment(String businessUuid, String filePaths) {
		if(StringUtils.isNotBlank(filePaths)) {
			String[] filePathArayy = filePaths.split(",");
			//文件路径前缀
			String filePrefix = SystemPropertiesUtil.getCustomImageUploadPath();
			for (String filePath : filePathArayy) {
				String fileName = filePath.substring(filePath.lastIndexOf("/")+1, filePath.lastIndexOf("."));
				String fileSuffix = filePath.substring(filePath.lastIndexOf(".")+1, filePath.length());
				TabAttachment attachment = new TabAttachment();
				attachment.setAttachmentUuid(UUIDGenerator.createUUID());
				attachment.setBusinessUuid(businessUuid);
				attachment.setFileName(fileName);
				attachment.setFilePath(filePath);
				attachment.setFilePrefix(filePrefix);
				attachment.setFileSuffix(fileSuffix);
				//attachment.setUploadAccUuid(uploadAccUuid);
				attachment.setUploadDate(DateUtil.getCurrentTimstamp());
				baseDao.insert(insertAttachment, attachment);
			}
		}
		
	}
	
}
