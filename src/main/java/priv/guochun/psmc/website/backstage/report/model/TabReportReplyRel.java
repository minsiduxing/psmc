package priv.guochun.psmc.website.backstage.report.model;

import java.io.Serializable;

public class TabReportReplyRel implements Serializable {
    private String relUuid;

    private String reportUuid;

    private String replyUuid;

    private static final long serialVersionUID = 1L;

    public String getRelUuid() {
        return relUuid;
    }

    public void setRelUuid(String relUuid) {
        this.relUuid = relUuid == null ? null : relUuid.trim();
    }

    public String getReportUuid() {
        return reportUuid;
    }

    public void setReportUuid(String reportUuid) {
        this.reportUuid = reportUuid == null ? null : reportUuid.trim();
    }

    public String getReplyUuid() {
        return replyUuid;
    }

    public void setReplyUuid(String replyUuid) {
        this.replyUuid = replyUuid == null ? null : replyUuid.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", relUuid=").append(relUuid);
        sb.append(", reportUuid=").append(reportUuid);
        sb.append(", replyUuid=").append(replyUuid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}