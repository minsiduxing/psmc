package priv.guochun.psmc.inquest.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 勘验记录表
 * 
 * @author wangtao
 * @date 2022-05-24 23:01:16
 */
public class TabYcInquestRecord implements Serializable {

	private static final long serialVersionUID = 6557534536978347973L;

	/**
	 * 勘验记录id
	 */
	private String recordUuid;
	/**
	 * 勘验人id
	 */
	private String userId;
	/**
	 * 勘验人手机号
	 */
	private String mobile;
	/**
	 * 当前勘验阶段
	 */
	private Integer currentStage;
	/**
	 * 勘验结果(0：不通过，1：通过)
	 */
	private Integer inquestResult;
	/**
	 * 所属专卖局code
	 */
	private String orgCode;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date modifyTime;

	public String getRecordUuid() {
		return recordUuid;
	}

	public void setRecordUuid(String recordUuid) {
		this.recordUuid = recordUuid;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getCurrentStage() {
		return currentStage;
	}

	public void setCurrentStage(Integer currentStage) {
		this.currentStage = currentStage;
	}

	public Integer getInquestResult() {
		return inquestResult;
	}

	public void setInquestResult(Integer inquestResult) {
		this.inquestResult = inquestResult;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
}
