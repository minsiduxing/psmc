package priv.guochun.psmc.inquest.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 勘验选项表
 * 
 * @author wangtao
 * @date 2022-05-24 23:01:16
 */
public class TabYcInquestOptionCfg implements Serializable {

	private static final long serialVersionUID = 6557534536978347973L;
	/**
	 * 选项主键
	 */
	private String optionUuid;
	/**
	 * 题目主键
	 */
	private String itemUuid;
	/**
	 * 选项内容
	 */
	private String optionContent;
	/**
	 * 选项值
	 */
	private String optionValue;
	/**
	 * 排序
	 */
	private Integer sort;
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

	public String getOptionUuid() {
		return optionUuid;
	}

	public void setOptionUuid(String optionUuid) {
		this.optionUuid = optionUuid;
	}

	public String getItemUuid() {
		return itemUuid;
	}

	public void setItemUuid(String itemUuid) {
		this.itemUuid = itemUuid;
	}

	public String getOptionContent() {
		return optionContent;
	}

	public void setOptionContent(String optionContent) {
		this.optionContent = optionContent;
	}

	public String getOptionValue() {
		return optionValue;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
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
}
