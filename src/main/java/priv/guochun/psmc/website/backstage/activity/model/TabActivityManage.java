package priv.guochun.psmc.website.backstage.activity.model;

import java.sql.Timestamp;

/**
 * 活动管理类
 * @author Administrator
 *
 */
public class TabActivityManage {
	/**
	 * uuid
	 */
    private String activityUuid;

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 活动开始时间
     */
    private Timestamp startDate;

    /**
     * 活动结束时间
     */
    private Timestamp endDate;
    
    /**
     * 活动创建时间
     */
    private Timestamp createDate;

    /**
     * 创建人
     */
    private String createPerson;

    /**
     * 报名截止时间
     */
    private Timestamp signUpEndDate;

    /**
     * 活动内容
     */
    private String activityContent;
    
    /**
     * 活动配图（手机端展示用）
     */
    private String imagePath;

    public String getActivityUuid() {
        return activityUuid;
    }

    public void setActivityUuid(String activityUuid) {
        this.activityUuid = activityUuid == null ? null : activityUuid.trim();
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson == null ? null : createPerson.trim();
    }

    public Timestamp getSignUpEndDate() {
        return signUpEndDate;
    }

    public void setSignUpEndDate(Timestamp signUpEndDate) {
        this.signUpEndDate = signUpEndDate;
    }

    public String getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent == null ? null : activityContent.trim();
    }
    
	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TabActivityManage [activityUuid=" + activityUuid + ", activityName=" + activityName + ", startDate="
				+ startDate + ", endDate=" + endDate + ", createDate=" + createDate + ", createPerson=" + createPerson
				+ ", signUpEndDate=" + signUpEndDate + ", activityContent=" + activityContent + ", imagePath=" + imagePath +"]";
	}

	
    
    
}