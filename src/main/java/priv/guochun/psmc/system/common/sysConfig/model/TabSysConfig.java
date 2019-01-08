package priv.guochun.psmc.system.common.sysConfig.model;

import java.io.Serializable;

/**
 * 系统配置信息表
 * @author Administrator
 *
 */
public class TabSysConfig implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 系统配置id
	 */
    private String sysUuid;
    /**
     * 系统配置编码
     */
    private String sysCode;
    /**
     * 类型
     */
    private String sysType;
    /**
     * 地址
     */
    private String sysUrl;
    /**
     * 方法
     */
    private String sysMethod;
    /**
     * 描述
     */
    private String sysRemark;
    /**
     * 排序编码
     */
    private Integer ordernum;
    /**
     * 第三方接口调用认证编码
     */
    private String appCode;
    /**
     * 备用字段1
     */
    private String column1;
    /**
     * 备用字段2
     */
    private String column2;

    public String getSysUuid() {
        return sysUuid;
    }

    public void setSysUuid(String sysUuid) {
        this.sysUuid = sysUuid == null ? null : sysUuid.trim();
    }

    public String getSysCode() {
        return sysCode;
    }

    public void setSysCode(String sysCode) {
        this.sysCode = sysCode == null ? null : sysCode.trim();
    }

    public String getSysType() {
        return sysType;
    }

    public void setSysType(String sysType) {
        this.sysType = sysType == null ? null : sysType.trim();
    }

    public String getSysUrl() {
        return sysUrl;
    }

    public void setSysUrl(String sysUrl) {
        this.sysUrl = sysUrl == null ? null : sysUrl.trim();
    }

    public String getSysMethod() {
        return sysMethod;
    }

    public void setSysMethod(String sysMethod) {
        this.sysMethod = sysMethod == null ? null : sysMethod.trim();
    }

    public String getSysRemark() {
        return sysRemark;
    }

    public void setSysRemark(String sysRemark) {
        this.sysRemark = sysRemark == null ? null : sysRemark.trim();
    }

    public Integer getOrdernum() {
        return ordernum;
    }

    public void setOrdernum(Integer ordernum) {
        this.ordernum = ordernum;
    }

	public String getAppCode() {
		return appCode;
	}

	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}

	public String getColumn1() {
		return column1;
	}

	public void setColumn1(String column1) {
		this.column1 = column1;
	}

	public String getColumn2() {
		return column2;
	}

	public void setColumn2(String column2) {
		this.column2 = column2;
	}
}