package priv.guochun.psmc.website.backstage.modulepublish.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class TabModulePublish implements Serializable {

	private static final long serialVersionUID = 7922346435663561067L;
	/**
	 * 发布标示
	 */
	private String pblishUuid;
	/**
	 * 模块id
	 */
	private String moduleUuuid;
	/**
	 * 发布日期
	 */
	private Timestamp publishDate;
	/**
	 * 到期日期
	 */
	private Timestamp publishExpireDate;
	/**
	 * 发布人标示
	 */
	private String publishAccountUuid;
	public String getPblishUuid() {
		return pblishUuid;
	}
	public void setPblishUuid(String pblishUuid) {
		this.pblishUuid = pblishUuid;
	}
	public String getModuleUuuid() {
		return moduleUuuid;
	}
	public void setModuleUuuid(String moduleUuuid) {
		this.moduleUuuid = moduleUuuid;
	}
	public Timestamp getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Timestamp publishDate) {
		this.publishDate = publishDate;
	}
	public Timestamp getPublishExpireDate() {
		return publishExpireDate;
	}
	public void setPublishExpireDate(Timestamp publishExpireDate) {
		this.publishExpireDate = publishExpireDate;
	}
	public String getPublishAccountUuid() {
		return publishAccountUuid;
	}
	public void setPublishAccountUuid(String publishAccountUuid) {
		this.publishAccountUuid = publishAccountUuid;
	}
	public TabModulePublish(String pblishUuid, String moduleUuuid,
			Timestamp publishDate, Timestamp publishExpireDate,
			String publishAccountUuid) {
		super();
		this.pblishUuid = pblishUuid;
		this.moduleUuuid = moduleUuuid;
		this.publishDate = publishDate;
		this.publishExpireDate = publishExpireDate;
		this.publishAccountUuid = publishAccountUuid;
	}
	public TabModulePublish() {
		super();
	}
	@Override
	public String toString() {
		return "TabModulePublish [pblishUuid=" + pblishUuid + ", moduleUuuid="
				+ moduleUuuid + ", publishDate=" + publishDate
				+ ", publishExpireDate=" + publishExpireDate
				+ ", publishAccountUuid=" + publishAccountUuid + "]";
	}
	
}
