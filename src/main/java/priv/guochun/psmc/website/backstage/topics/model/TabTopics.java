package priv.guochun.psmc.website.backstage.topics.model;

import java.sql.Timestamp;
import java.util.List;

/**
 * 主题信息实体类
 * @author Administrator
 *
 */
public class TabTopics {
	/**
	 * 主题id
	 */
    private String topicUuid;
	/**
	 * 主题名称
	 */
    private String topicName;
	/**
	 * 主题状态（1正常，2暂停，3删除）
	 */
    private Integer topicStatus;
	/**
	 * 所属板块id
	 */
    private String blockUuid;
	/**
	 * 创建人id
	 */
    private String createPersonUuid;
	/**
	 * 创建人姓名
	 */
    private String createPersonName;
	/**
	 * 创建人联系电话
	 */
    private String telephone;
	/**
	 * 创建时间
	 */
    private Timestamp createDate;
	/**
	 * 最后评论人id
	 */
    private String lastCommentPersonUuid;
	/**
	 * 最后评论时间
	 */
    private Timestamp lastCommentDate;
	/**
	 * 最后评论信息id
	 */
    private String lastCommentUuid;
	/**
	 * 主题内容
	 */
    private String topicContent;
    /**
     * 信息列表配图
     */
    private String imagePath;
    /**
     * 发布状态
     */
    private Integer releaseStatus;
    /**
     * 发布时间
     */
    private Timestamp releaseTime;
    /**
     * 发布人id
     */
    private String releasePersonUuid;
    
    /**
     * 附件ID（非持久化字段,多个id之间以逗号隔开）
     */
    private String attachmentUuids;

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

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public String getLastCommentPersonUuid() {
        return lastCommentPersonUuid;
    }

    public void setLastCommentPersonUuid(String lastCommentPersonUuid) {
        this.lastCommentPersonUuid = lastCommentPersonUuid == null ? null : lastCommentPersonUuid.trim();
    }

    public Timestamp getLastCommentDate() {
        return lastCommentDate;
    }

    public void setLastCommentDate(Timestamp lastCommentDate) {
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
    
    public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	
	public Integer getReleaseStatus() {
		return releaseStatus;
	}

	public void setReleaseStatus(Integer releaseStatus) {
		this.releaseStatus = releaseStatus;
	}

	public Timestamp getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Timestamp releaseTime) {
		this.releaseTime = releaseTime;
	}

	public String getReleasePersonUuid() {
		return releasePersonUuid;
	}

	public void setReleasePersonUuid(String releasePersonUuid) {
		this.releasePersonUuid = releasePersonUuid;
	}

	@Override
	public String toString() {
		return "TabTopics [topicUuid=" + topicUuid + ", topicName=" + topicName + ", topicStatus=" + topicStatus
				+ ", blockUuid=" + blockUuid + ", createPersonUuid=" + createPersonUuid + ", createPersonName="
				+ createPersonName + ", telephone=" + telephone + ", createDate=" + createDate
				+ ", lastCommentPersonUuid=" + lastCommentPersonUuid + ", lastCommentDate=" + lastCommentDate
				+ ", lastCommentUuid=" + lastCommentUuid + ", topicContent=" + topicContent + ", imagePath=" + imagePath
				+ ", releaseStatus=" + releaseStatus + ", releaseTime=" + releaseTime + ", releasePersonUuid="
				+ releasePersonUuid + "]";
	}

	public String getAttachmentUuids() {
		return attachmentUuids;
	}

	public void setAttachmentUuids(String attachmentUuids) {
		this.attachmentUuids = attachmentUuids;
	}
	
}