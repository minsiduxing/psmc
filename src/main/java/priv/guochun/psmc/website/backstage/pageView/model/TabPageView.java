package priv.guochun.psmc.website.backstage.pageView.model;

import java.io.Serializable;

/**
 * 浏览量记录表
 * @author Administrator
 *
 */
public class TabPageView implements Serializable{

	private static final long serialVersionUID = 8275476533223527027L;
	
	private String uuid;
	
	/**
	 * 浏览量
	 */
	private Integer nums;

	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the nums
	 */
	public Integer getNums() {
		return nums;
	}

	/**
	 * @param nums the nums to set
	 */
	public void setNums(Integer nums) {
		this.nums = nums;
	}
	
}
