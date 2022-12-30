package priv.guochun.psmc.inquest.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 排队管理表
 * 
 * @author wangtao
 * @date 2022-12-27 17:17:45
 */
public class TabYcQueueManage implements Serializable {

	private static final long serialVersionUID = 6557534536978347973L;
	/**
	 * 主键
	 */
	private String queueUuid;
	/**
	 * 归属网格名称
	 */
	private String gridName;
	/**
	 * 负责人姓名
	 */
	private String managerName;
	/**
	 * 企业名称
	 */
	private String companyName;
	/**
	 * 统一社会信用代码
	 */
	private String creditNo;
	/**
	 * 经营地址
	 */
	private String businessAddr;
	/**
	 * 联系电话
	 */
	private String lineTel;
	/**
	 * 是否优先
	 */
	private int isPriority;
	/**
	 * 优先条件
	 */
	private String priorityCondition;
	/**
	 * 申请状态
	 */
	private String applyStatus;
	/**
	 * 通知日期
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@JSONField(format = "yyyy-MM-dd")
	private Date noticeDate;
	/**
	 * 完成情形
	 */
	private String finishType;
	/**
	 * 完成时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@JSONField(format = "yyyy-MM-dd hh:mm:ss")
	private Date finishTime;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 是否有效
	 */
	private int isActive;
	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
	@JSONField(format = "yyyy-MM-dd hh:mm:ss")
	private Date createTime;
	/**
	 * 创建人
	 */
	private String creator;
	/**
	 * 修改时间
	 */
	private Date modifyTime;

	/**
	 * 申请状态名称
	 */
	private String applyStatusName;
	/**
	 * 完成情形名称
	 */
	private String finishTypeName;

	public String getQueueUuid() {
		return queueUuid;
	}

	public void setQueueUuid(String queueUuid) {
		this.queueUuid = queueUuid;
	}

	public String getGridName() {
		return gridName;
	}

	public void setGridName(String gridName) {
		this.gridName = gridName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCreditNo() {
		return creditNo;
	}

	public void setCreditNo(String creditNo) {
		this.creditNo = creditNo;
	}

	public String getBusinessAddr() {
		return businessAddr;
	}

	public void setBusinessAddr(String businessAddr) {
		this.businessAddr = businessAddr;
	}

	public String getLineTel() {
		return lineTel;
	}

	public void setLineTel(String lineTel) {
		this.lineTel = lineTel;
	}

	public int getIsPriority() {
		return isPriority;
	}

	public void setIsPriority(int isPriority) {
		this.isPriority = isPriority;
	}

	public String getPriorityCondition() {
		return priorityCondition;
	}

	public void setPriorityCondition(String priorityCondition) {
		this.priorityCondition = priorityCondition;
	}

	public String getApplyStatus() {
		return applyStatus;
	}

	public void setApplyStatus(String applyStatus) {
		this.applyStatus = applyStatus;
	}

	public Date getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getFinishType() {
		return finishType;
	}

	public void setFinishType(String finishType) {
		this.finishType = finishType;
	}

	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getApplyStatusName() {
		return applyStatusName;
	}

	public void setApplyStatusName(String applyStatusName) {
		this.applyStatusName = applyStatusName;
	}

	public String getFinishTypeName() {
		return finishTypeName;
	}

	public void setFinishTypeName(String finishTypeName) {
		this.finishTypeName = finishTypeName;
	}
}
