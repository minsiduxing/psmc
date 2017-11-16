package priv.guochun.psmc.website.backstage.webuser.model;

/**
 * 网站用户信息
 * @author wenxiaoming
 *
 */
public class TabWebUser {

	/**
	 * 用户标识
	 */
	private String uuid;
	
	/**
	 * 用户账号
	 */
	private String userId;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 姓名
	 */
	private String userName;
	
	/**
	 * 身份证
	 */
	private String idCard;
	
	/**
	 * 电话
	 */
	private String phone;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
}
