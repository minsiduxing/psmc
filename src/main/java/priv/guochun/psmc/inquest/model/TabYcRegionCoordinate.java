package priv.guochun.psmc.inquest.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description 区域坐标维护表
 * @author wangt
 * @create 2023/1/6 10:38
 */
public class TabYcRegionCoordinate implements Serializable {
    /**
     * 主键标识
     */
    private String coordUuid;
    /**
     * 区域类型
     */
    private String regionType;
    /**
     * 区域名称
     */
    private String regionName;
    /**
     * 区域地址
     */
    private String regionAddr;
    /**
     * 经纬度坐标
     */
    private String coordinate;

    /**
     * 所属组织编号
     */
    private String orgCode;

    /**
     * 所属组织名称
     */
    private String orgName;
    /**
     * 是否有效
     */
    private Byte isActive;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifyTime;
    /**
     * 创建人
     */
    private String creator;

    /************* 非持久化字段 ************/

    /**
     * 区域类型名称
     */
    private String regionTypeName;


    private static final long serialVersionUID = 1L;

    public String getCoordUuid() {
        return coordUuid;
    }

    public void setCoordUuid(String coordUuid) {
        this.coordUuid = coordUuid == null ? null : coordUuid.trim();
    }

    public String getRegionType() {
        return regionType;
    }

    public void setRegionType(String regionType) {
        this.regionType = regionType == null ? null : regionType.trim();
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName == null ? null : regionName.trim();
    }

    public String getRegionAddr() {
        return regionAddr;
    }

    public void setRegionAddr(String regionAddr) {
        this.regionAddr = regionAddr == null ? null : regionAddr.trim();
    }

    public Byte getIsActive() {
        return isActive;
    }

    public void setIsActive(Byte isActive) {
        this.isActive = isActive;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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

    public String getRegionTypeName() {
        return regionTypeName;
    }

    public void setRegionTypeName(String regionTypeName) {
        this.regionTypeName = regionTypeName;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", coordUuid=").append(coordUuid);
        sb.append(", regionType=").append(regionType);
        sb.append(", regionName=").append(regionName);
        sb.append(", regionAddr=").append(regionAddr);
        sb.append(", isActive=").append(isActive);
        sb.append(", createTime=").append(createTime);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", creator=").append(creator);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}