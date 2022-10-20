package priv.guochun.psmc.inquest.model;

import java.io.Serializable;
import java.util.Date;

public class TabYcGridModelType implements Serializable {
    private String gridMtypeUuid;

    private String gridMtypeName;

    private String legalProvisionDesc;

    private String orgCode;

    private Integer sort;

    private Date modifyTime;

    private String creator;

    private Date createTime;

    private String isActive;

    private String version;

    private static final long serialVersionUID = 1L;

    public String getGridMtypeUuid() {
        return gridMtypeUuid;
    }

    public void setGridMtypeUuid(String gridMtypeUuid) {
        this.gridMtypeUuid = gridMtypeUuid == null ? null : gridMtypeUuid.trim();
    }

    public String getGridMtypeName() {
        return gridMtypeName;
    }

    public void setGridMtypeName(String gridMtypeName) {
        this.gridMtypeName = gridMtypeName == null ? null : gridMtypeName.trim();
    }

    public String getLegalProvisionDesc() {
        return legalProvisionDesc;
    }

    public void setLegalProvisionDesc(String legalProvisionDesc) {
        this.legalProvisionDesc = legalProvisionDesc == null ? null : legalProvisionDesc.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive == null ? null : isActive.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", gridMtypeUuid=").append(gridMtypeUuid);
        sb.append(", gridMtypeName=").append(gridMtypeName);
        sb.append(", legalProvisionDesc=").append(legalProvisionDesc);
        sb.append(", orgCode=").append(orgCode);
        sb.append(", sort=").append(sort);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", creator=").append(creator);
        sb.append(", createTime=").append(createTime);
        sb.append(", isActive=").append(isActive);
        sb.append(", version=").append(version);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}