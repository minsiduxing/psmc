package priv.guochun.psmc.website.backstage.laud.model;

import java.util.Date;

/**
 * 点赞实体
 * @author Administrator
 *
 */
public class TabLaud {
	/**
	 * 主键
	 */
    private String laudUuid;
    /**
     * 点赞信息模型id
     */
    private String moduleUuid;
    /**
     * 点赞时间
     */
    private Date laudDate;
    /**
     * 点赞人id
     */
    private String laudPersonUuid;
    /**
     * 点赞人姓名
     */
    private String laudPersonName;

    public String getLaudUuid() {
        return laudUuid;
    }

    public void setLaudUuid(String laudUuid) {
        this.laudUuid = laudUuid == null ? null : laudUuid.trim();
    }

    public String getModuleUuid() {
        return moduleUuid;
    }

    public void setModuleUuid(String moduleUuid) {
        this.moduleUuid = moduleUuid == null ? null : moduleUuid.trim();
    }

    public Date getLaudDate() {
        return laudDate;
    }

    public void setLaudDate(Date laudDate) {
        this.laudDate = laudDate;
    }

    public String getLaudPersonUuid() {
        return laudPersonUuid;
    }

    public void setLaudPersonUuid(String laudPersonUuid) {
        this.laudPersonUuid = laudPersonUuid == null ? null : laudPersonUuid.trim();
    }

    public String getLaudPersonName() {
        return laudPersonName;
    }

    public void setLaudPersonName(String laudPersonName) {
        this.laudPersonName = laudPersonName == null ? null : laudPersonName.trim();
    }
}