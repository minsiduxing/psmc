package priv.guochun.psmc.website.backstage.activity.model;

import java.sql.Timestamp;

/**
 * 报名信息
 * @author Administrator
 *
 */
public class TabSignUpInfo {
	/**
	 * UUID
	 */
    private String signUpUuid;

    /**
     * 活动信息ID
     */
    private String activityUuid;

    /**
     * 报名人账号ID
     */
    private String personAccount;

    /**
     * 报名人姓名
     */
    private String personName;

    /**
     * 报名人电话
     */
    private String personMobile;

    /**
     * 报名时间
     */
    private Timestamp signUpDate;

    public String getSignUpUuid() {
        return signUpUuid;
    }

    public void setSignUpUuid(String signUpUuid) {
        this.signUpUuid = signUpUuid == null ? null : signUpUuid.trim();
    }

    public String getActivityUuid() {
        return activityUuid;
    }

    public void setActivityUuid(String activityUuid) {
        this.activityUuid = activityUuid == null ? null : activityUuid.trim();
    }

    public String getPersonAccount() {
        return personAccount;
    }

    public void setPersonAccount(String personAccount) {
        this.personAccount = personAccount == null ? null : personAccount.trim();
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName == null ? null : personName.trim();
    }

    public String getPersonMobile() {
        return personMobile;
    }

    public void setPersonMobile(String personMobile) {
        this.personMobile = personMobile == null ? null : personMobile.trim();
    }

    public Timestamp getSignUpDate() {
        return signUpDate;
    }

    public void setSignUpDate(Timestamp signUpDate) {
        this.signUpDate = signUpDate;
    }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TabSignUpInfo [signUpUuid=" + signUpUuid + ", activityUuid=" + activityUuid + ", personAccount="
				+ personAccount + ", personName=" + personName + ", personMobile=" + personMobile + ", signUpDate="
				+ signUpDate + "]";
	}
    
}