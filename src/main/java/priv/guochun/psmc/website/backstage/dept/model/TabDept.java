package priv.guochun.psmc.website.backstage.dept.model;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 部门信息
 * @author Administrator
 *
 */
public class TabDept {
	/**
	 * 部门ID
	 */
    private String deptUuid;
    /**
	 * 部门名称
	 */
    private String deptName;
    /**
	 * 部门简介
	 */
    private String deptIntroduction;
    /**
	 * 规范管理办法
	 */
    private String deptRegulation;
    /**
	 * 风采展示
	 */
    private String elegantDemeanour;
    /**
	 * 部门类型（1创新工作室，2问题协会）
	 */
    private Integer deptType;
    /**
	 * 创建人
	 */
    private String createPerson;
	/**
	 * 创建时间
	 */
    private Timestamp createDate;
    /**
     * 最后修改人
     */
    private String lastModifyPerson;
    /**
     * 最后修改时间
     */
    private Timestamp lastModifyTime;
    /**
     * 部门信息配图
     */
    private String imagePath;

    /**
     * 分组编码
     */
    private String groupid;

    /**
     * 是否自定义配图
     */
    private Integer isCustom;
    
    /**
     * 合作意向
     */
    private String cooperation;


    public String getDeptUuid() {
        return deptUuid;
    }

    public void setDeptUuid(String deptUuid) {
        this.deptUuid = deptUuid == null ? null : deptUuid.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getDeptIntroduction() {
        return deptIntroduction;
    }

    public void setDeptIntroduction(String deptIntroduction) {
        this.deptIntroduction = deptIntroduction == null ? null : deptIntroduction.trim();
    }

    public String getDeptRegulation() {
        return deptRegulation;
    }

    public void setDeptRegulation(String deptRegulation) {
        this.deptRegulation = deptRegulation == null ? null : deptRegulation.trim();
    }

    public String getElegantDemeanour() {
        return elegantDemeanour;
    }

    public void setElegantDemeanour(String elegantDemeanour) {
        this.elegantDemeanour = elegantDemeanour == null ? null : elegantDemeanour.trim();
    }

    public Integer getDeptType() {
        return deptType;
    }

    public void setDeptType(Integer deptType) {
        this.deptType = deptType;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson == null ? null : createPerson.trim();
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

	public String getLastModifyPerson() {
		return lastModifyPerson;
	}

	public void setLastModifyPerson(String lastModifyPerson) {
		this.lastModifyPerson = lastModifyPerson;
	}

	public Timestamp getLastModifyTime() {
		return lastModifyTime;
	}

	public void setLastModifyTime(Timestamp lastModifyTime) {
		this.lastModifyTime = lastModifyTime;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	
	public Integer getIsCustom() {
		return isCustom;
	}

	public void setIsCustom(Integer isCustom) {
		this.isCustom = isCustom;
	}

	public String getCooperation() {
		return cooperation;
	}

	public void setCooperation(String cooperation) {
		this.cooperation = cooperation;
	}

	@Override
	public String toString() {
		return "TabDept [deptUuid=" + deptUuid + ", deptName=" + deptName + ", deptIntroduction=" + deptIntroduction
				+ ", deptRegulation=" + deptRegulation + ", elegantDemeanour=" + elegantDemeanour + ", deptType="
				+ deptType + ", createPerson=" + createPerson + ", createDate=" + createDate + ", lastModifyPerson="
				+ lastModifyPerson + ", lastModifyTime=" + lastModifyTime + ", imagePath=" + imagePath + ", groupid="
				+ groupid + ", isCustom=" + isCustom + ", cooperation=" + cooperation + "]";
	}

}