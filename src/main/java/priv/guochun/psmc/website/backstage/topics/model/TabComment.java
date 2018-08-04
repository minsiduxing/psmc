package priv.guochun.psmc.website.backstage.topics.model;

import java.sql.Timestamp;

/**
 * 评论信息实体类
 * @author Administrator
 *
 */
public class TabComment {
	/**
	 * 评论id
	 */
    private String commentUuid;
    /**
	 * 主题id
	 */
    private String topicUuid;
    /**
	 * 评论内容
	 */
    private String commentContent;
    /**
	 * 评论人id
	 */
    private String commentPersonUuid;
    /**
	 * 评论人姓名
	 */
    private String commentPersonName;
    /**
	 * 评论时间
	 */
    private Timestamp commentDate;
    /**
	 * 评论状态（1正常，2屏蔽，3删除）
	 */
    private Integer commentStatus;
    /**
	 * 评论目标人id
	 */
    private String toPersonUuid;
    /**
	 * 评论目标人姓名
	 */
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

    public Timestamp getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Timestamp commentDate) {
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

	@Override
	public String toString() {
		return "TabComment [commentUuid=" + commentUuid + ", topicUuid=" + topicUuid + ", commentContent="
				+ commentContent + ", commentPersonUuid=" + commentPersonUuid + ", commentPersonName="
				+ commentPersonName + ", commentDate=" + commentDate + ", commentStatus=" + commentStatus
				+ ", toPersonUuid=" + toPersonUuid + ", toPersonName=" + toPersonName + "]";
	}
}