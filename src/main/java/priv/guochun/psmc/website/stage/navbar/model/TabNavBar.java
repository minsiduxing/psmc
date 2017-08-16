package priv.guochun.psmc.website.stage.navbar.model;


import java.io.Serializable;


/**
 * <p>Title: 网站首页导航栏</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright ICSS(c) 2017</p>
 * @author <a href="mailTo:18829012118@126.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2017年8月16日
 */
public class TabNavBar implements Serializable{
	private static final long serialVersionUID = 9143229568782247028L;
	/**
	 * 导航栏uuid
	 */
	private String menuUuid;
	/**
	 * 导航栏的名称
	 */
	private String menuName;
	/**
	 * 导航栏的连接地址
	 */
	private String menuUrl;
	/**
	 * 父级导航栏uuid
	 */
	private String parentMenuUuid;
	/**
	 * 打开方式：弹窗：页面调转
	 */
	private String openType;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 排序
	 */
	private Integer orderNum;
	/**
	 * 是否锁定
	 */
	private Integer isLocked;
	public String getMenuUuid() {
		return menuUuid;
	}
	public void setMenuUuid(String menuUuid) {
		this.menuUuid = menuUuid;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuUrl() {
		return menuUrl;
	}
	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}
	public String getParentMenuUuid() {
		return parentMenuUuid;
	}
	public void setParentMenuUuid(String parentMenuUuid) {
		this.parentMenuUuid = parentMenuUuid;
	}
	public String getOpenType() {
		return openType;
	}
	public void setOpenType(String openType) {
		this.openType = openType;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getOrderNum() {
		return orderNum;
	}
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}
	public Integer getIsLocked() {
		return isLocked;
	}
	public void setIsLocked(Integer isLocked) {
		this.isLocked = isLocked;
	}
	@Override
	public String toString() {
		return "TabNavBar [menuUuid=" + menuUuid + ", menuName=" + menuName + ", menuUrl=" + menuUrl
				+ ", parentMenuUuid=" + parentMenuUuid + ", openType=" + openType + ", remark=" + remark + ", orderNum="
				+ orderNum + ", isLocked=" + isLocked + "]";
	}
	public TabNavBar() {
		super();
	}
	
	
}
	
