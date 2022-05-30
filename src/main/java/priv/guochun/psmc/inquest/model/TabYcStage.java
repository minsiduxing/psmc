package priv.guochun.psmc.inquest.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * 
 * @author wangtao
 * @date 2022-05-24 23:01:16
 */
public class TabYcStage implements Serializable {

	private static final long serialVersionUID = 6557534536978347973L;
	/**
	 * 阶段id
	 */
	private String stageUuid;
	/**
	 * 阶段编码
	 */
	private String stageCode;
	/**
	 * 阶段名称
	 */
	private String stageName;
	/**
	 * 上级阶段id
	 */
	private String parentId;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 所属专卖局code
	 */
	private String orgCode;
	/**
	 * 阶段层级
	 */
	private Integer stageLevel;
	/**
	 * 下辖题目展示方式 1、平铺。2、单条引导。
	 */
	private Integer itemDisplayType;
	/**
	 * 结果判定
	 */
	private String resultJudge;
	/**
	 * 下阶段UUID
	 */
	private String nextStageUuid;
	/**
	 * 是否有效
	 */
	private Boolean isActive;
	/**
	 * 创建人
	 */
	private String creator;
	/**
	 * 创建时间
	 */
	private Date createTime;

	public String getStageUuid() {
		return stageUuid;
	}

	public void setStageUuid(String stageUuid) {
		this.stageUuid = stageUuid;
	}

	public String getStageCode() {
		return stageCode;
	}

	public void setStageCode(String stageCode) {
		this.stageCode = stageCode;
	}

	public String getStageName() {
		return stageName;
	}

	public void setStageName(String stageName) {
		this.stageName = stageName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getOrgCode() {
		return orgCode;
	}

	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}

	public Integer getStageLevel() {
		return stageLevel;
	}

	public void setStageLevel(Integer stageLevel) {
		this.stageLevel = stageLevel;
	}

	public Integer getItemDisplayType() {
		return itemDisplayType;
	}

	public void setItemDisplayType(Integer itemDisplayType) {
		this.itemDisplayType = itemDisplayType;
	}

	public Boolean getActive() {
		return isActive;
	}

	public void setActive(Boolean active) {
		isActive = active;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getResultJudge() {
		return resultJudge;
	}

	public void setResultJudge(String resultJudge) {
		this.resultJudge = resultJudge;
	}

	public String getNextStageUuid() {
		return nextStageUuid;
	}

	public void setNextStageUuid(String nextStageUuid) {
		this.nextStageUuid = nextStageUuid;
	}
}
