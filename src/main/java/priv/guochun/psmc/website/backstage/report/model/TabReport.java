package priv.guochun.psmc.website.backstage.report.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

public class TabReport implements Serializable {
    private String reportUuid;

    private String reportTitle;

    private String reportContent;

    private String reportUserName;

    private String reportUserUuid;

    private Date reportTime;

    private String reportType;

    private Date lastModifyTime;
    
    private String reportUpdateUuid;
    private String reportStaus;
    private String reportStatusName;
    private String reportTel;
    private static final long serialVersionUID = 1L;
    
    private String imagePath;
    
    private Integer releaseStatus;
    private String releasePersonUuid;
    private Timestamp releaseDate;
    
    
    /**
     * 附件ID（非持久化字段,多个id之间以逗号隔开）
     */
    private String attachmentUuids;

    public String getReportStaus() {
        return reportStaus;
    }

    public String getReportTel() {
        return reportTel;
    }

    public void setReportTel(String reportTel) {
        this.reportTel = reportTel;
    }

    public void setReportStaus(String reportStaus) {
        this.reportStaus = reportStaus;
    }

    public String getReportUuid() {
        return reportUuid;
    }

    public void setReportUuid(String reportUuid) {
        this.reportUuid = reportUuid == null ? null : reportUuid.trim();
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle == null ? null : reportTitle.trim();
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent == null ? null : reportContent.trim();
    }

    public String getReportUserName() {
        return reportUserName;
    }

    public void setReportUserName(String reportUserName) {
        this.reportUserName = reportUserName == null ? null : reportUserName.trim();
    }

    public String getReportUserUuid() {
        return reportUserUuid;
    }

    public void setReportUserUuid(String reportUserUuid) {
        this.reportUserUuid = reportUserUuid == null ? null : reportUserUuid.trim();
    }

    public Date getReportTime() {
        return reportTime;
    }

    public void setReportTime(Date reportTime) {
        this.reportTime = reportTime;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType == null ? null : reportType.trim();
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getReportUpdateUuid() {
        return reportUpdateUuid;
    }

    public void setReportUpdateUuid(String reportUpdateUuid) {
        this.reportUpdateUuid = reportUpdateUuid == null ? null : reportUpdateUuid.trim();
    }

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

    public String getReportStatusName() {
        return reportStatusName;
    }

    public void setReportStatusName(String reportStatusName) {
        this.reportStatusName = reportStatusName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", reportUuid=").append(reportUuid);
        sb.append(", reportTitle=").append(reportTitle);
        sb.append(", reportContent=").append(reportContent);
        sb.append(", reportUserName=").append(reportUserName);
        sb.append(", reportUserUuid=").append(reportUserUuid);
        sb.append(", reportTime=").append(reportTime);
        sb.append(", reportType=").append(reportType);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append(", reportUpdateUuid=").append(reportUpdateUuid);
        sb.append(", imagePath=").append(imagePath);
        sb.append(", serialVersionUID=").append(serialVersionUID); 
        sb.append("]");
        return sb.toString();
    }

	public Integer getReleaseStatus() {
		return releaseStatus;
	}

	public void setReleaseStatus(Integer releaseStatus) {
		this.releaseStatus = releaseStatus;
	}

	public String getReleasePersonUuid() {
		return releasePersonUuid;
	}

	public void setReleasePersonUuid(String releasePersonUuid) {
		this.releasePersonUuid = releasePersonUuid;
	}

	public Timestamp getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Timestamp releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getAttachmentUuids() {
		return attachmentUuids;
	}

	public void setAttachmentUuids(String attachmentUuids) {
		this.attachmentUuids = attachmentUuids;
	}
}