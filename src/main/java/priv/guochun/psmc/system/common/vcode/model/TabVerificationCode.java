package priv.guochun.psmc.system.common.vcode.model;

import java.util.Date;

public class TabVerificationCode {

	private String uuid;
	private Long type;
	private Long state;
	private String code;
	private Date createTime;
	private Long effectiveTime;
	private String phone;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid == null ? null : uuid.trim();
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public Long getState() {
		return state;
	}

	public void setState(Long state) {
		this.state = state;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code == null ? null : code.trim();
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getEffectiveTime() {
		return effectiveTime;
	}

	public void setEffectiveTime(Long effectiveTime) {
		this.effectiveTime = effectiveTime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone == null ? null : phone.trim();
	}
}