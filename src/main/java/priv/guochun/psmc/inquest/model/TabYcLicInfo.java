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
     * 坐标
     */
    private String coordinate;

    /**
     * 是否不作为参考物
     */
    private Byte isNotConsult;

    /**
     * 不作为参考物类型
     */
    private String notConsultType;

    /**
     * 经济类型（个体、企业）
     */
    private String ecoType;

    /**
     * 所属组织编号
     */
    private String orgCode;

    /**
     * 所属组织名称
     */
    private String orgName;

    /**
     * 发证日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    private Date issueDate;

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

    /************* 非持久化字段 ************/
    /**
     * 许可证状态名称
     */
    private String licStatusName;
    /**
     * 不作为参考物类型名称
     */
    private String notConsultTypeName;
    /**
     * 经济类型名称
     */
    private String ecoTypeName;

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

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
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

    public String getEcoType() {
        return ecoType;
    }

    public void setEcoType(String ecoType) {
        this.ecoType = ecoType;
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

    public String getEcoTypeName() {
        return ecoTypeName;
    }

    public void setEcoTypeName(String ecoTypeName) {
        this.ecoTypeName = ecoTypeName;
    }



}