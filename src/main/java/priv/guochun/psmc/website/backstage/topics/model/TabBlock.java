package priv.guochun.psmc.website.backstage.topics.model;

import java.util.Date;

public class TabBlock {
    private String blockUuid;

    private String blockName;

    private String blockKey;

    private String blockInfo;

    private String lastTopicUuid;

    private String lastTopicPersonUuid;

    private Date lastTopicDate;

    private Integer blockStatus;

    private String createPersonUuid;

    private Date createDate;

    public String getBlockUuid() {
        return blockUuid;
    }

    public void setBlockUuid(String blockUuid) {
        this.blockUuid = blockUuid == null ? null : blockUuid.trim();
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName == null ? null : blockName.trim();
    }

    public String getBlockKey() {
        return blockKey;
    }

    public void setBlockKey(String blockKey) {
        this.blockKey = blockKey == null ? null : blockKey.trim();
    }

    public String getBlockInfo() {
        return blockInfo;
    }

    public void setBlockInfo(String blockInfo) {
        this.blockInfo = blockInfo == null ? null : blockInfo.trim();
    }

    public String getLastTopicUuid() {
        return lastTopicUuid;
    }

    public void setLastTopicUuid(String lastTopicUuid) {
        this.lastTopicUuid = lastTopicUuid == null ? null : lastTopicUuid.trim();
    }

    public String getLastTopicPersonUuid() {
        return lastTopicPersonUuid;
    }

    public void setLastTopicPersonUuid(String lastTopicPersonUuid) {
        this.lastTopicPersonUuid = lastTopicPersonUuid == null ? null : lastTopicPersonUuid.trim();
    }

    public Date getLastTopicDate() {
        return lastTopicDate;
    }

    public void setLastTopicDate(Date lastTopicDate) {
        this.lastTopicDate = lastTopicDate;
    }

    public Integer getBlockStatus() {
        return blockStatus;
    }

    public void setBlockStatus(Integer blockStatus) {
        this.blockStatus = blockStatus;
    }

    public String getCreatePersonUuid() {
        return createPersonUuid;
    }

    public void setCreatePersonUuid(String createPersonUuid) {
        this.createPersonUuid = createPersonUuid == null ? null : createPersonUuid.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}