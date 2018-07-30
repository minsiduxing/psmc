package priv.guochun.psmc.website.backstage.topics.model;

import java.util.Date;

public class TabComment {
    private String commentUuid;

    private String topicUuid;

    private String commentContent;

    private String commentPersonUuid;

    private String commentPersonName;

    private Date commentDate;

    private Integer commentStatus;

    private String toPersonUuid;

    private String toPersonName;

    public String getCommentUuid() {
        return commentUuid;
    }

    public void setCommentUuid(String commentUuid) {
        this.commentUuid = commentUuid == null ? null : commentUuid.trim();
    }

    public String getTopicUuid() {
        return topicUuid;
    }

    public void setTopicUuid(String topicUuid) {
        this.topicUuid = topicUuid == null ? null : topicUuid.trim();
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public String getCommentPersonUuid() {
        return commentPersonUuid;
    }

    public void setCommentPersonUuid(String commentPersonUuid) {
        this.commentPersonUuid = commentPersonUuid == null ? null : commentPersonUuid.trim();
    }

    public String getCommentPersonName() {
        return commentPersonName;
    }

    public void setCommentPersonName(String commentPersonName) {
        this.commentPersonName = commentPersonName == null ? null : commentPersonName.trim();
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public Integer getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
    }

    public String getToPersonUuid() {
        return toPersonUuid;
    }

    public void setToPersonUuid(String toPersonUuid) {
        this.toPersonUuid = toPersonUuid == null ? null : toPersonUuid.trim();
    }

    public String getToPersonName() {
        return toPersonName;
    }

    public void setToPersonName(String toPersonName) {
        this.toPersonName = toPersonName == null ? null : toPersonName.trim();
    }
}