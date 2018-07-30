package priv.guochun.psmc.website.backstage.topics.model;

import java.util.Date;

public class TabTopics {
    private String topicUuid;

    private String topicName;

    private Integer topicStatus;

    private String blockUuid;

    private String createPersonUuid;

    private String createPersonName;

    private String telephone;

    private Date createDate;

    private String lastCommentPersonUuid;

    private Date lastCommentDate;

    private String lastCommentUuid;

    private String topicContent;

    public String getTopicUuid() {
        return topicUuid;
    }

    public void setTopicUuid(String topicUuid) {
        this.topicUuid = topicUuid == null ? null : topicUuid.trim();
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName == null ? null : topicName.trim();
    }

    public Integer getTopicStatus() {
        return topicStatus;
    }

    public void setTopicStatus(Integer topicStatus) {
        this.topicStatus = topicStatus;
    }

    public String getBlockUuid() {
        return blockUuid;
    }

    public void setBlockUuid(String blockUuid) {
        this.blockUuid = blockUuid == null ? null : blockUuid.trim();
    }

    public String getCreatePersonUuid() {
        return createPersonUuid;
    }

    public void setCreatePersonUuid(String createPersonUuid) {
        this.createPersonUuid = createPersonUuid == null ? null : createPersonUuid.trim();
    }

    public String getCreatePersonName() {
        return createPersonName;
    }

    public void setCreatePersonName(String createPersonName) {
        this.createPersonName = createPersonName == null ? null : createPersonName.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getLastCommentPersonUuid() {
        return lastCommentPersonUuid;
    }

    public void setLastCommentPersonUuid(String lastCommentPersonUuid) {
        this.lastCommentPersonUuid = lastCommentPersonUuid == null ? null : lastCommentPersonUuid.trim();
    }

    public Date getLastCommentDate() {
        return lastCommentDate;
    }

    public void setLastCommentDate(Date lastCommentDate) {
        this.lastCommentDate = lastCommentDate;
    }

    public String getLastCommentUuid() {
        return lastCommentUuid;
    }

    public void setLastCommentUuid(String lastCommentUuid) {
        this.lastCommentUuid = lastCommentUuid == null ? null : lastCommentUuid.trim();
    }

    public String getTopicContent() {
        return topicContent;
    }

    public void setTopicContent(String topicContent) {
        this.topicContent = topicContent == null ? null : topicContent.trim();
    }
}