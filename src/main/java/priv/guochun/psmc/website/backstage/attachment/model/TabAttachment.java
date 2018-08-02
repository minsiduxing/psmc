package priv.guochun.psmc.website.backstage.attachment.model;

import java.util.Date;

/**
 * 附件信息实体
 * @author Administrator
 *
 */
public class TabAttachment {
	
	/**
	 * 附件ID
	 */
    private String attachmentUuid;
    
    /**
     * 业务信息ID
     */
    private String businessUuid;

    /**
     * 文件路径前缀
     */
    private String filePrefix;

    /**
     * 文件路径
     */
    private String filePath;

    /**
     * 文件名
     */
    private String fileName;

    /**
     * 真实文件名
     */
    private String fileRealName;

    /**
     * 文件后缀
     */
    private String fileSuffix;

    /**
     * 上传人账号ID
     */
    private String uploadAccUuid;

    /**
     * 上传时间
     */
    private Date uploadDate;

    /**
     * 排序
     */
    private Integer sort;

    public String getAttachmentUuid() {
        return attachmentUuid;
    }

    public void setAttachmentUuid(String attachmentUuid) {
        this.attachmentUuid = attachmentUuid == null ? null : attachmentUuid.trim();
    }

    public String getBusinessUuid() {
        return businessUuid;
    }

    public void setBusinessUuid(String businessUuid) {
        this.businessUuid = businessUuid == null ? null : businessUuid.trim();
    }

    public String getFilePrefix() {
        return filePrefix;
    }

    public void setFilePrefix(String filePrefix) {
        this.filePrefix = filePrefix == null ? null : filePrefix.trim();
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName == null ? null : fileName.trim();
    }

    public String getFileRealName() {
        return fileRealName;
    }

    public void setFileRealName(String fileRealName) {
        this.fileRealName = fileRealName == null ? null : fileRealName.trim();
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix == null ? null : fileSuffix.trim();
    }

    public String getUploadAccUuid() {
        return uploadAccUuid;
    }

    public void setUploadAccUuid(String uploadAccUuid) {
        this.uploadAccUuid = uploadAccUuid == null ? null : uploadAccUuid.trim();
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}