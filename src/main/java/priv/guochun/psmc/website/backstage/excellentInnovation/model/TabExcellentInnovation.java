package priv.guochun.psmc.website.backstage.excellentInnovation.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class TabExcellentInnovation implements Serializable {

	private static final long serialVersionUID = 8275476533223527027L;
	/**
     *uuid
     */
    private String innovationUuid;

    /**
     *所属单位名称
     */
    private String orgName;

    /**
     *申报负责人姓名
     */
    private String declarePerson;

    /**
     *申报负责人电话
     */
    private String declarePhone;

    /**
     *申报负责人邮箱
     */
    private String declareEmail;

    /**
     *第一完成人姓名
     */
    private String firstCompletePerson;

    /**
     *性别
     */
    private Integer sex;

    /**
     *学历
     */
    private String education;

    /**
     *职务
     */
    private String job;

    /**
     *部门名称
     */
    private String deptName;

    /**
     *专业特长
     */
    private String major;

    /**
     *职业身份
     */
    private Integer occupation;

    /**
     *其他完成人姓名
     */
    private String otherCompletePerson;

    /**
     *成果名称
     */
    private String achievementName;

    /**
     *体现形式
     */
    private Integer achievementForm;

    /**
     *实现价值
     */
    private String realizedValue;

    /**
     *应用推广
     */
    private String applicationGeneralize;

    /**
     *创新时间
     */
    private Timestamp innovationDate;

    /**
     *推荐单位意见
     */
    private String recommendRemark;

    /**
     *推荐时间
     */
    private Timestamp recommendDate;

    /**
     *工会审核意见
     */
    private String auditRemark;

    /**
     *工会审核日期
     */
    private Timestamp auditDate;

    /**
     *成果内容
     */
    private String achievementContent;

   
    public String getInnovationUuid() {
        return innovationUuid;
    }

    public void setInnovationUuid(String innovationUuid) {
        this.innovationUuid = innovationUuid == null ? null : innovationUuid.trim();
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName == null ? null : orgName.trim();
    }

    public String getDeclarePerson() {
        return declarePerson;
    }

    public void setDeclarePerson(String declarePerson) {
        this.declarePerson = declarePerson == null ? null : declarePerson.trim();
    }

    public String getDeclarePhone() {
        return declarePhone;
    }

    public void setDeclarePhone(String declarePhone) {
        this.declarePhone = declarePhone == null ? null : declarePhone.trim();
    }

    public String getDeclareEmail() {
        return declareEmail;
    }

    public void setDeclareEmail(String declareEmail) {
        this.declareEmail = declareEmail == null ? null : declareEmail.trim();
    }

    public String getFirstCompletePerson() {
        return firstCompletePerson;
    }

    public void setFirstCompletePerson(String firstCompletePerson) {
        this.firstCompletePerson = firstCompletePerson == null ? null : firstCompletePerson.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major == null ? null : major.trim();
    }

    public Integer getOccupation() {
        return occupation;
    }

    public void setOccupation(Integer occupation) {
        this.occupation = occupation;
    }

    public String getOtherCompletePerson() {
        return otherCompletePerson;
    }

    public void setOtherCompletePerson(String otherCompletePerson) {
        this.otherCompletePerson = otherCompletePerson == null ? null : otherCompletePerson.trim();
    }

    public String getAchievementName() {
        return achievementName;
    }

    public void setAchievementName(String achievementName) {
        this.achievementName = achievementName == null ? null : achievementName.trim();
    }

    public Integer getAchievementForm() {
        return achievementForm;
    }

    public void setAchievementForm(Integer achievementForm) {
        this.achievementForm = achievementForm;
    }

    public String getRealizedValue() {
        return realizedValue;
    }

    public void setRealizedValue(String realizedValue) {
        this.realizedValue = realizedValue == null ? null : realizedValue.trim();
    }

    public String getApplicationGeneralize() {
        return applicationGeneralize;
    }

    public void setApplicationGeneralize(String applicationGeneralize) {
        this.applicationGeneralize = applicationGeneralize == null ? null : applicationGeneralize.trim();
    }

    public Timestamp getInnovationDate() {
        return innovationDate;
    }

    public void setInnovationDate(Timestamp innovationDate) {
        this.innovationDate = innovationDate;
    }

    public String getRecommendRemark() {
        return recommendRemark;
    }

    public void setRecommendRemark(String recommendRemark) {
        this.recommendRemark = recommendRemark == null ? null : recommendRemark.trim();
    }

    public Timestamp getRecommendDate() {
        return recommendDate;
    }

    public void setRecommendDate(Timestamp recommendDate) {
        this.recommendDate = recommendDate;
    }

    public String getAuditRemark() {
        return auditRemark;
    }

    public void setAuditRemark(String auditRemark) {
        this.auditRemark = auditRemark == null ? null : auditRemark.trim();
    }

    public Timestamp getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Timestamp auditDate) {
        this.auditDate = auditDate;
    }

    public String getAchievementContent() {
        return achievementContent;
    }

    public void setAchievementContent(String achievementContent) {
        this.achievementContent = achievementContent == null ? null : achievementContent.trim();
    }
    public TabExcellentInnovation() {
		super();
	}
    
    
    public TabExcellentInnovation(String innovationUuid, String orgName, String declarePerson, String declarePhone,
			String declareEmail, String firstCompletePerson, Integer sex, String education, String job, String deptName,
			String major, Integer occupation, String otherCompletePerson, String achievementName,
			Integer achievementForm, String realizedValue, String applicationGeneralize, Timestamp innovationDate,
			String recommendRemark, Timestamp recommendDate, String auditRemark, Timestamp auditDate, String achievementContent) {
		super();
		this.innovationUuid = innovationUuid;
		this.orgName = orgName;
		this.declarePerson = declarePerson;
		this.declarePhone = declarePhone;
		this.declareEmail = declareEmail;
		this.firstCompletePerson = firstCompletePerson;
		this.sex = sex;
		this.education = education;
		this.job = job;
		this.deptName = deptName;
		this.major = major;
		this.occupation = occupation;
		this.otherCompletePerson = otherCompletePerson;
		this.achievementName = achievementName;
		this.achievementForm = achievementForm;
		this.realizedValue = realizedValue;
		this.applicationGeneralize = applicationGeneralize;
		this.innovationDate = innovationDate;
		this.recommendRemark = recommendRemark;
		this.recommendDate = recommendDate;
		this.auditRemark = auditRemark;
		this.auditDate = auditDate;
		this.achievementContent = achievementContent;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TabExcellentInnovation [innovationUuid=" + innovationUuid + ", orgName=" + orgName + ", declarePerson="
				+ declarePerson + ", declarePhone=" + declarePhone + ", declareEmail=" + declareEmail
				+ ", firstCompletePerson=" + firstCompletePerson + ", sex=" + sex + ", education=" + education
				+ ", job=" + job + ", deptName=" + deptName + ", major=" + major + ", occupation=" + occupation
				+ ", otherCompletePerson=" + otherCompletePerson + ", achievementName=" + achievementName
				+ ", achievementForm=" + achievementForm + ", realizedValue=" + realizedValue
				+ ", applicationGeneralize=" + applicationGeneralize + ", innovationDate=" + innovationDate
				+ ", recommendRemark=" + recommendRemark + ", recommendDate=" + recommendDate + ", auditRemark="
				+ auditRemark + ", auditDate=" + auditDate + ", achievementContent=" + achievementContent + "]";
	}
	
}
