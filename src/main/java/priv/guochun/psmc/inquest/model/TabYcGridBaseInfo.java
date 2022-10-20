package priv.guochun.psmc.inquest.model;

import java.io.Serializable;
import java.util.Date;

public class TabYcGridBaseInfo implements Serializable {
    private String gridUuid;

    private String gridName;

    private String orgCode;

    private String gridModelType;

    private Integer gridPepoleCount;

    private Integer planningIssueCertTotal;

    private Integer actualIssueCertTotal;

    private String isMaintainCoordinate;

    private String gridCoordinate;

    private Date modifyTime;

    private String creator;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public String getGridUuid() {
        return gridUuid;
    }

    public void setGridUuid(String gridUuid) {
        this.gridUuid = gridUuid == null ? null : gridUuid.trim();
    }

    public String getGridName() {
        return gridName;
    }

    public void setGridName(String gridName) {
        this.gridName = gridName == null ? null : gridName.trim();
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode == null ? null : orgCode.trim();
    }

    public String getGridModelType() {
        return gridModelType;
    }

    public void setGridModelType(String gridModelType) {
        this.gridModelType = gridModelType == null ? null : gridModelType.trim();
    }

    public Integer getGridPepoleCount() {
        return gridPepoleCount;
    }

    public void setGridPepoleCount(Integer gridPepoleCount) {
        this.gridPepoleCount = gridPepoleCount;
    }

    public Integer getPlanningIssueCertTotal() {
        return planningIssueCertTotal;
    }

    public void setPlanningIssueCertTotal(Integer planningIssueCertTotal) {
        this.planningIssueCertTotal = planningIssueCertTotal;
    }

    public Integer getActualIssueCertTotal() {
        return actualIssueCertTotal;
    }

    public void setActualIssueCertTotal(Integer actualIssueCertTotal) {
        this.actualIssueCertTotal = actualIssueCertTotal;
    }

    public String getIsMaintainCoordinate() {
        return isMaintainCoordinate;
    }

    public void setIsMaintainCoordinate(String isMaintainCoordinate) {
        this.isMaintainCoordinate = isMaintainCoordinate == null ? null : isMaintainCoordinate.trim();
    }

    public String getGridCoordinate() {
        return gridCoordinate;
    }

    public void setGridCoordinate(String gridCoordinate) {
        this.gridCoordinate = gridCoordinate == null ? null : gridCoordinate.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", gridUuid=").append(gridUuid);
        sb.append(", gridName=").append(gridName);
        sb.append(", orgCode=").append(orgCode);
        sb.append(", gridModelType=").append(gridModelType);
        sb.append(", gridPepoleCount=").append(gridPepoleCount);
        sb.append(", planningIssueCertTotal=").append(planningIssueCertTotal);
        sb.append(", actualIssueCertTotal=").append(actualIssueCertTotal);
        sb.append(", isMaintainCoordinate=").append(isMaintainCoordinate);
        sb.append(", gridCoordinate=").append(gridCoordinate);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", creator=").append(creator);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}