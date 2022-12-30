package priv.guochun.psmc.inquest.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @description 许可证数据
 * @author wangt
 * @create 2022/12/28 10:05
 */
public class TabYcLicInfo implements Serializable {

    /**
     * 主键
     */
    private String licUuid;

    /**
     * 许可证号
     */
    private String licNo;

    /**
     * 负责人姓名
     */
    private String managerName;

    /**
     * 企业名称
     */
    private String companyName;

    /**
     * 经营地址
     */
    private String businessAddr;

    /**
     * 统一社会信用代码
     */
    private String creditNo;

    /**
     * 证件号码
     */
    private String idcardNo;

    /**
     * 许可证有效期起
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date licStartDate;

    /**
     * 许可证有效期至
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date licEndDate;

    /**
     * 许可证状态
     */
    private String licStatus;

    /**
     * 联系电话
     */
    private String lineTel;

    /**
     * 歇业决定时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JSONField(format = "yyyy-MM-dd hh:mm:ss")
    private Date closeDecideTime;

    /**
     * 所属网格名称
     */
    private String gridName;

    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 纬度
     */
    private BigDecimal latitude;

    /**
     * 是否不作为参考物
     */
    private Byte isNotConsult;

    /**
     * 不作为参考物类型
     */
    private String notConsultType;

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
     * 创建人
     */
    private String creator;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 许可证状态名称
     */
    private String licStatusName;
    /**
     * 不作为参考物类型名称
     */
    private String notConsultTypeName;

    private static final long serialVersionUID = 1L;

    public String getLicUuid() {
        return licUuid;
    }

    public void setLicUuid(String licUuid) {
        this.licUuid = licUuid == null ? null : licUuid.trim();
    }

    public String getLicNo() {
        return licNo;
    }

    public void setLicNo(String licNo) {
        this.licNo = licNo == null ? null : licNo.trim();
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName == null ? null : managerName.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getBusinessAddr() {
        return businessAddr;
    }

    public void setBusinessAddr(String businessAddr) {
        this.businessAddr = businessAddr == null ? null : businessAddr.trim();
    }

    public String getCreditNo() {
        return creditNo;
    }

    public void setCreditNo(String creditNo) {
        this.creditNo = creditNo == null ? null : creditNo.trim();
    }

    public String getIdcardNo() {
        return idcardNo;
    }

    public void setIdcardNo(String idcardNo) {
        this.idcardNo = idcardNo == null ? null : idcardNo.trim();
    }

    public Date getLicStartDate() {
        return licStartDate;
    }

    public void setLicStartDate(Date licStartDate) {
        this.licStartDate = licStartDate;
    }

    public Date getLicEndDate() {
        return licEndDate;
    }

    public void setLicEndDate(Date licEndDate) {
        this.licEndDate = licEndDate;
    }

    public String getLicStatus() {
        return licStatus;
    }

    public void setLicStatus(String licStatus) {
        this.licStatus = licStatus == null ? null : licStatus.trim();
    }

    public String getLineTel() {
        return lineTel;
    }

    public void setLineTel(String lineTel) {
        this.lineTel = lineTel == null ? null : lineTel.trim();
    }

    public Date getCloseDecideTime() {
        return closeDecideTime;
    }

    public void setCloseDecideTime(Date closeDecideTime) {
        this.closeDecideTime = closeDecideTime;
    }

    public String getGridName() {
        return gridName;
    }

    public void setGridName(String gridName) {
        this.gridName = gridName == null ? null : gridName.trim();
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public Byte getIsNotConsult() {
        return isNotConsult;
    }

    public void setIsNotConsult(Byte isNotConsult) {
        this.isNotConsult = isNotConsult;
    }

    public String getNotConsultType() {
        return notConsultType;
    }

    public void setNotConsultType(String notConsultType) {
        this.notConsultType = notConsultType == null ? null : notConsultType.trim();
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getLicStatusName() {
        return licStatusName;
    }

    public void setLicStatusName(String licStatusName) {
        this.licStatusName = licStatusName;
    }

    public String getNotConsultTypeName() {
        return notConsultTypeName;
    }

    public void setNotConsultTypeName(String notConsultTypeName) {
        this.notConsultTypeName = notConsultTypeName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", licUuid=").append(licUuid);
        sb.append(", licNo=").append(licNo);
        sb.append(", managerName=").append(managerName);
        sb.append(", companyName=").append(companyName);
        sb.append(", businessAddr=").append(businessAddr);
        sb.append(", creditNo=").append(creditNo);
        sb.append(", idcardNo=").append(idcardNo);
        sb.append(", licStartDate=").append(licStartDate);
        sb.append(", licEndDate=").append(licEndDate);
        sb.append(", licStatus=").append(licStatus);
        sb.append(", lineTel=").append(lineTel);
        sb.append(", closeDecideTime=").append(closeDecideTime);
        sb.append(", gridName=").append(gridName);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", isNotConsult=").append(isNotConsult);
        sb.append(", notConsultType=").append(notConsultType);
        sb.append(", isActive=").append(isActive);
        sb.append(", createTime=").append(createTime);
        sb.append(", creator=").append(creator);
        sb.append(", modifyTime=").append(modifyTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}