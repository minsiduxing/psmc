package priv.guochun.psmc.inquest.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


/**
 * 资格勘验题目配置表
 * 
 * @author wangtao
 * @date 2022-05-24 23:01:16
 */

public class TabYcInquestItemCfg implements Serializable {

	private static final long serialVersionUID = 6557534536978347973L;
	/**
	 * 主键
	 */
	private String itemUuid;
	/**
	 * 勘验阶段
	 */
	private String stageUuid;
	/**
	 * 题目类型(1：单选，2多选)
	 */
	private Integer questionType;
	/**
	 * 标题
	 */
	private String questionName;
	/**
	 * 标准答案
	 */
	private String standardAnswer;
	/**
	 * 提示信息
	 */
	private String tipsInfo;
	/**
	 * 是否受特殊群体影响
	 */
	@JsonProperty("isAffectedBsg")
	private Boolean isAffectedBsg;
	/**
	 * 是否进行距离测算
	 */
	@JsonProperty("isAffectedJlcl")
	private Boolean isAffectedJlcl;
	/**
	 * 是否进行饱和度测算
	 */
	@JsonProperty("isAffectedBhdcs")
	private Boolean isAffectedBhdcs;
	/**
	 * 展示图集地址 英文;分割
	 */
	private String displayAtlas;
	/**
	 * 展示视频地址
	 */
	private String displayVidio;
	/**
	 * 排序
	 */
	private Integer sort;
	/**
	 * 所属专卖局code
	 */
	private String orgCode;
	/**
	 * 关联题目id
	 */
	private String releationItemUuid;
	/**
	 * 是否负面清单
	 */
	private Integer isNegative;
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



	/**
	 * 附件id，逗号分隔
	 */
	private String attachmentUuids;
	/**
	 * 阶段编码
	 */
	private String stageCode;

	/**
	 * 选项列表
	 */
	List<TabYcInquestOptionCfg> optionCfgList;

	public String getItemUuid() {
		return itemUuid;
	}

	public void setItemUuid(String itemUuid) {
		this.itemUuid = itemUuid;
	}

	public String getStageUuid() {
		return stageUuid;
	}

	public void setStageUuid(String stageUuid) {
		this.stageUuid = stageUuid;
	}

	public Integer getQuestionType() {
		return questionType;
	}

	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public String getStandardAnswer() {
		return standardAnswer;
	}

	public void setStandardAnswer(String standardAnswer) {
		this.standardAnswer = standardAnswer;
	}

	public String getTipsInfo() {
		return tipsInfo;
	}

	public void setTipsInfo(String tipsInfo) {
		this.tipsInfo = tipsInfo;
	}

	public Boolean getIsAffectedBsg() {
		return isAffectedBsg;
	}

	public void setIsAffectedBsg(Boolean isAffectedBsg) {
		this.isAffectedBsg = isAffectedBsg;
	}

	public Boolean getIsAffectedJlcl() {
		return isAffectedJlcl;
	}

	public void setIsAffectedJlcl(Boolean isAffectedJlcl) {
		this.isAffectedJlcl = isAffectedJlcl;
	}

	public Boolean getIsAffectedBhdcs() {
		return isAffectedBhdcs;
	}

	public void setIsAffectedBhdcs(Boolean isAffectedBhdcs) {
		this.isAffectedBhdcs = isAffectedBhdcs;
	}

	public String getDisplayAtlas() {
		return displayAtlas;
	}

	public void setDisplayAtlas(String displayAtlas) {
		this.displayAtlas = displayAtlas;
	}

	public String getDisplayVidio() {
		return displayVidio;
	}

	public void setDisplayVidio(String displayVidio) {
		this.displayVidio = displayVidio;
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

	public String getReleationItemUuid() {
		return releationItemUuid;
	}

	public void setReleationItemUuid(String releationItemUuid) {
		this.releationItemUuid = releationItemUuid;
	}

	public Integer getIsNegative() {
		return isNegative;
	}

	public void setIsNegative(Integer isNegative) {
		this.isNegative = isNegative;
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

	public List<TabYcInquestOptionCfg> getOptionCfgList() {
		return optionCfgList;
	}

	public void setOptionCfgList(List<TabYcInquestOptionCfg> optionCfgList) {
		this.optionCfgList = optionCfgList;
	}

	public String getAttachmentUuids() {
		return attachmentUuids;
	}

	public void setAttachmentUuids(String attachmentUuids) {
		this.attachmentUuids = attachmentUuids;
	}

	public String getStageCode() {
		return stageCode;
	}

	public void setStageCode(String stageCode) {
		this.stageCode = stageCode;
	}
}
