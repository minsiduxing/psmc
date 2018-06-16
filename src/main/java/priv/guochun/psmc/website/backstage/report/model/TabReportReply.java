package priv.guochun.psmc.website.backstage.report.model;

import java.io.Serializable;
import java.util.Date;

public class TabReportReply implements Serializable {
    private String replyUuid;

    private String replyContent;

    private String replyUserUuid;

    private String replyUserName;

    private Date replyTime;

    private Date lastModifyTime;

    private String lastModifyUserUuid;

    private static final long serialVersionUID = 1L;

    public String getReplyUuid() {
        return replyUuid;
    }

    public void setReplyUuid(String replyUuid) {
        this.replyUuid = replyUuid == null ? null : replyUuid.trim();
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
    }

    public String getReplyUserUuid() {
        return replyUserUuid;
    }

    public void setReplyUserUuid(String replyUserUuid) {
        this.replyUserUuid = replyUserUuid == null ? null : replyUserUuid.trim();
    }

    public String getReplyUserName() {
        return replyUserName;
    }

    public void setReplyUserName(String replyUserName) {
        this.replyUserName = replyUserName == null ? null : replyUserName.trim();
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public String getLastModifyUserUuid() {
        return lastModifyUserUuid;
    }

    public void setLastModifyUserUuid(String lastModifyUserUuid) {
        this.lastModifyUserUuid = lastModifyUserUuid == null ? null : lastModifyUserUuid.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", replyUuid=").append(replyUuid);
        sb.append(", replyContent=").append(replyContent);
        sb.append(", replyUserUuid=").append(replyUserUuid);
        sb.append(", replyUserName=").append(replyUserName);
        sb.append(", replyTime=").append(replyTime);
        sb.append(", lastModifyTime=").append(lastModifyTime);
        sb.append(", lastModifyUserUuid=").append(lastModifyUserUuid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}