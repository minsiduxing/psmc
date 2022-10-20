package priv.guochun.psmc.inquest.model;

import java.io.Serializable;
import java.util.Date;

public class TabYcGridCalculationModel implements Serializable {
    private String gridCmodelUuid;

    private String gridCmodelName;

    private String modelTypeUuid;

    private String ruleType;

    private String ruleFormula;

    private String ruleFormulaDesc;

    private String orgCode;

    private Integer sort;

    private Date modifyTime;

    private String creator;

    private Date createTime;

    private String isActive;

    private String version;

    private static final long serialVersionUID = 1L;

    public String getGridCmodelUuid() {
        return gridCmodelUuid;
    }

    public void setGridCmodelUuid(String gridCmodelUuid) {
        this.gridCmodelUuid = gridCmodelUuid == null ? null : gridCmodelUuid.trim();
    }

    public String getGridCmodelName() {
        return gridCmodelName;
    }

    public void setGridCmodelName(String gridCmodelName) {
        this.gridCmodelName = gridCmodelName == null ? null : gridCmodelName.trim();
    }

    public String getModelTypeUuid() {
        return modelTypeUuid;
    }

    public void setModelTypeUuid(String modelTypeUuid) {
        this.modelTypeUuid = modelTypeUuid == null ? null : modelTypeUuid.trim();
    }

    public String getRuleType() {
        return ruleType;
    }

    public void setRuleType(String ruleType) {
        this.ruleType = ruleType == null ? null : ruleType.trim();
    }

    public String getRuleFormula() {
        return ruleFormula;
    }

    public void setRuleFormula(String ruleFormula) {
        this.ruleFormula = ruleFormula == null ? null : ruleFormula.trim();
    }

    public String getRuleFormulaDesc() {
        return ruleFormulaDesc;
    }

    public void setRuleFormulaDesc(String ruleFormulaDesc) {
        this.ruleFormulaDesc = ruleFormulaDesc == null ? null : ruleFormulaDesc.trim();
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
        sb.append(", gridCmodelUuid=").append(gridCmodelUuid);
        sb.append(", gridCmodelName=").append(gridCmodelName);
        sb.append(", modelTypeUuid=").append(modelTypeUuid);
        sb.append(", ruleType=").append(ruleType);
        sb.append(", ruleFormula=").append(ruleFormula);
        sb.append(", ruleFormulaDesc=").append(ruleFormulaDesc);
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