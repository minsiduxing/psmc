package priv.guochun.psmc.website.backstage.module.model;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * <p>Title:模块 </p>
 * <p>Description: </p>
 * @author <a href="mailTo:bingxuewulei@outlook.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2017年9月1日
 */
public class TabModule implements Serializable {
	private static final long serialVersionUID = 6557534536978347973L;
	/**
	 * 模块id
	 */
	private String modelUuid;
	/**
	 * 创建人id
	 */
	private String createAccUuid;
	/**
	 * 创建时间
	 */
	private Timestamp createDate;
	/**
	 * 修改人id
	 */
	private String modifyAccUuid;
	/**
	 * 修改时间
	 */
	private Timestamp modifyDate;
	/**
	 * 是否审核 0：未审核; 1:审核通过 ;2:审核未通过
	 */
	private  Integer  audit;
	/**
	 * 审核人标示
	 */
	private String auditAccUuid;
	/**
	 * 审核日期
	 */
	private Timestamp auditDate;
	/**
	 * 发布人标示
	 */
	private String releaseAccUuid;
	/**
	 * 发布日期
	 */
	private Timestamp releaseDate;
	/**
	 * 一级分类：1、新闻。2、微课程、3、视频
	 */
	private String oneLevelClassify;
	/**
	 * 二级分类：参考字典表
	 */
	private String towLevelClassify;
	
	/**
	 * 发布状态
	 */
	private String releaseStatus;
	
	/**
	 * 模块过期时间-用于模块发布
	 */
	private Timestamp publishExpireDate;
	
	public String getCreateAccUuid() {
		return createAccUuid;
	}
	public void setCreateAccUuid(String createAccUuid) {
		this.createAccUuid = createAccUuid;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public String getModifyAccUuid() {
		return modifyAccUuid;
	}
	public void setModifyAccUuid(String modifyAccUuid) {
		this.modifyAccUuid = modifyAccUuid;
	}
	public Timestamp getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}
	public Integer getAudit() {
		return audit;
	}
	public void setAudit(Integer audit) {
		this.audit = audit;
	}
	public String getAuditAccUuid() {
		return auditAccUuid;
	}
	public void setAuditAccUuid(String auditAccUuid) {
		this.auditAccUuid = auditAccUuid;
	}
	public Timestamp getAuditDate() {
		return auditDate;
	}
	public void setAuditDate(Timestamp auditDate) {
		this.auditDate = auditDate;
	}
	public String getReleaseAccUuid() {
		return releaseAccUuid;
	}
	public void setReleaseAccUuid(String releaseAccUuid) {
		this.releaseAccUuid = releaseAccUuid;
	}
	public Timestamp getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Timestamp releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getOneLevelClassify() {
		return oneLevelClassify;
	}
	public void setOneLevelClassify(String oneLevelClassify) {
		this.oneLevelClassify = oneLevelClassify;
	}
	public String getTowLevelClassify() {
		return towLevelClassify;
	}
	public void setTowLevelClassify(String towLevelClassify) {
		this.towLevelClassify = towLevelClassify;
	}
	
	public String getModelUuid() {
		return modelUuid;
	}
	public void setModelUuid(String modelUuid) {
		this.modelUuid = modelUuid;
	}
	
	public String getReleaseStatus() {
		return releaseStatus;
	}
	public void setReleaseStatus(String releaseStatus) {
		this.releaseStatus = releaseStatus;
	}
	
	
	public Timestamp getPublishExpireDate() {
		return publishExpireDate;
	}
	public void setPublishExpireDate(Timestamp publishExpireDate) {
		this.publishExpireDate = publishExpireDate;
	}
	public TabModule(String modelUuid, String createAccUuid,
			Timestamp createDate, String modifyAccUuid, Timestamp modifyDate,
			Integer audit, String auditAccUuid, Timestamp auditDate,
			String releaseAccUuid, Timestamp releaseDate,
			String oneLevelClassify, String towLevelClassify,
			String releaseStatus) {
		super();
		this.modelUuid = modelUuid;
		this.createAccUuid = createAccUuid;
		this.createDate = createDate;
		this.modifyAccUuid = modifyAccUuid;
		this.modifyDate = modifyDate;
		this.audit = audit;
		this.auditAccUuid = auditAccUuid;
		this.auditDate = auditDate;
		this.releaseAccUuid = releaseAccUuid;
		this.releaseDate = releaseDate;
		this.oneLevelClassify = oneLevelClassify;
		this.towLevelClassify = towLevelClassify;
		this.releaseStatus = releaseStatus;
	}
	public TabModule() {
		super();
	}
	@Override
	public String toString() {
		return "TabModule [modelUuid=" + modelUuid + ", createAccUuid="
				+ createAccUuid + ", createDate=" + createDate
				+ ", modifyAccUuid=" + modifyAccUuid + ", modifyDate="
				+ modifyDate + ", audit=" + audit + ", auditAccUuid="
				+ auditAccUuid + ", auditDate=" + auditDate
				+ ", releaseAccUuid=" + releaseAccUuid + ", releaseDate="
				+ releaseDate + ", oneLevelClassify=" + oneLevelClassify
				+ ", towLevelClassify=" + towLevelClassify + ", releaseStatus="
				+ releaseStatus + "]";
	}
	
	
	
}
