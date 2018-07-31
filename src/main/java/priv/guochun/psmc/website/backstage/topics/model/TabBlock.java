package priv.guochun.psmc.website.backstage.topics.model;

import java.sql.Timestamp;

/**
 * 版块信息实体类
 * @author Administrator
 *
 */
public class TabBlock {
	
	/**
	 * 版块id
	 */
    private String blockUuid;
    /**
	 * 版块名称
	 */
    private String blockName;
    /**
	 * 版块类型key
	 */
    private String blockKey;
    /**
	 * 版块介绍
	 */
    private String blockInfo;
    /**
	 * 最后发表主题id
	 */
    private String lastTopicUuid;
    /**
	 * 最后发表人id
	 */
    private String lastTopicPersonUuid;
    /**
	 * 最后发表时间
	 */
    private Timestamp lastTopicDate;
    /**
	 * 版块状态（1正常，2暂停，3删除）
	 */
    private Integer blockStatus;
    /**
	 * 创建人id
	 */
    private String createPersonUuid;
    /**
	 * 创建时间
	 */
    private Timestamp createDate;
    
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

    public Timestamp getLastTopicDate() {
        return lastTopicDate;
    }

    public void setLastTopicDate(Timestamp lastTopicDate) {
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

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

	@Override
	public String toString() {
		return "TabBlock [blockUuid=" + blockUuid + ", blockName=" + blockName + ", blockKey=" + blockKey
				+ ", blockInfo=" + blockInfo + ", lastTopicUuid=" + lastTopicUuid + ", lastTopicPersonUuid="
				+ lastTopicPersonUuid + ", lastTopicDate=" + lastTopicDate + ", blockStatus=" + blockStatus
				+ ", createPersonUuid=" + createPersonUuid + ", createDate=" + createDate + "]";
	}
}