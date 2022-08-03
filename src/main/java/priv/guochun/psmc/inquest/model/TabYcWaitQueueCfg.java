package priv.guochun.psmc.inquest.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @description 勘验配置表
 * @author wangt
 * @create 2022/7/30 17:15
 */
public class TabYcWaitQueueCfg implements Serializable {

    private static final long serialVersionUID = 6557534536978347973L;

    /**
     * 主键
     */
    private String cfgUuid;
    /**
     * 专卖局名称
     */
    private String orgName;
    /**
     * 专卖局编码
     */
    private String orgCode;
    /**
     * 缺省经度
     */
    private String defaultLongitude;
    /**
     * 缺省纬度
     */
    private String defaultLatitude;
    /**
     * 联系地址
     */
    private String contactAddress;
    /**
     * 联系电话
     */
    private String contactTel;
    /**
     * 联系地址经度
     */
    private String addressLongitude;
    /**
     * 联系地址纬度
     */
    private String addressLatitude;
    /**
     * 工作时间
     */
    private String workTime;
    /**
     * 是否启用虚拟网格
     */
    private Boolean isFictitiousGrid;
    /**
     * 轮候超期时限
     */
    private Integer overdueDays;
    /**
     * 是否启用歇业保留
     */
    private Boolean isClosedRetain;
    /**
     * 歇业保留天数
     */
    private Integer closedRetainDays;
    /**
     * 办证二维码地址
     */
    private String qrcodePath;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 是否有效
     */
    private Boolean isActive;
    /**
     * 创建人
     */
    private String creator;
    /**
     * 创建时间
     */
    private Date createTime;

    public String getCfgUuid() {
        return cfgUuid;
    }

    public void setCfgUuid(String cfgUuid) {
        this.cfgUuid = cfgUuid;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getOrgCode() {
        return orgCode;
    }

    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
    }

    public String getDefaultLongitude() {
        return defaultLongitude;
    }

    public void setDefaultLongitude(String defaultLongitude) {
        this.defaultLongitude = defaultLongitude;
    }

    public String getDefaultLatitude() {
        return defaultLatitude;
    }

    public void setDefaultLatitude(String defaultLatitude) {
        this.defaultLatitude = defaultLatitude;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getAddressLongitude() {
        return addressLongitude;
    }

    public void setAddressLongitude(String addressLongitude) {
        this.addressLongitude = addressLongitude;
    }

    public String getAddressLatitude() {
        return addressLatitude;
    }

    public void setAddressLatitude(String addressLatitude) {
        this.addressLatitude = addressLatitude;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    public Boolean getFictitiousGrid() {
        return isFictitiousGrid;
    }

    public void setFictitiousGrid(Boolean fictitiousGrid) {
        isFictitiousGrid = fictitiousGrid;
    }

    public Integer getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(Integer overdueDays) {
        this.overdueDays = overdueDays;
    }

    public Boolean getClosedRetain() {
        return isClosedRetain;
    }

    public void setClosedRetain(Boolean closedRetain) {
        isClosedRetain = closedRetain;
    }

    public Integer getClosedRetainDays() {
        return closedRetainDays;
    }

    public void setClosedRetainDays(Integer closedRetainDays) {
        this.closedRetainDays = closedRetainDays;
    }

    public String getQrcodePath() {
        return qrcodePath;
    }

    public void setQrcodePath(String qrcodePath) {
        this.qrcodePath = qrcodePath;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
