package priv.guochun.psmc.website.backstage.questionnaire.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 客户消费信息表
 * @author Administrator
 *
 */
public class TabEvaluateInfo implements Serializable{
    /**
     *
     * 消费信息主键
     * @mbg.generated Sat Apr 20 17:20:54 CST 2019
     */
    private String evaluateInfoUuid;

    /**
     * 问卷ID
     * @mbg.generated Sat Apr 20 17:20:54 CST 2019
     */
    private String questionnaireUuid;

    /**
     * 客户姓名
     * @mbg.generated Sat Apr 20 17:20:54 CST 2019
     */
    private String evaluateName;

    /**
     * 客户电话
     * @mbg.generated Sat Apr 20 17:20:54 CST 2019
     */
    private String evaluatePhone;
    /**
     * 客户昵称
     * @mbg.generated Sat Apr 20 17:20:54 CST 2019
     */
    private String evaluateNickName;
    /**
     * 消费日期
     * @mbg.generated Sat Apr 20 17:20:54 CST 2019
     */
    private Date consumptionDate;
    /**
     * 消费金额
     * @mbg.generated Sat Apr 20 17:20:54 CST 2019
     */
    private BigDecimal consumptionAmount;
    /**
     * 剩余金额
     * @mbg.generated Sat Apr 20 17:20:54 CST 2019
     */
    private BigDecimal surplusAmount;
    /**
     * 剩余积分
     * @mbg.generated Sat Apr 20 17:20:54 CST 2019
     */
    private Integer surplusScore;
    /**
     * 剩余次数
     * @mbg.generated Sat Apr 20 17:20:54 CST 2019
     */
    private Integer surplusNumber;
    /**
     * 充值金额
     * @mbg.generated Sat Apr 20 17:20:54 CST 2019
     */
    private BigDecimal rechargeAmount;
    /**
     * 消费项目
     * @mbg.generated Sat Apr 20 17:20:54 CST 2019
     */
    private String consumptionItem;
    /**
     * 通知类型
     * @mbg.generated Sat Apr 20 17:20:54 CST 2019
     */
    private Integer evaluateNoticeType;

    /**
     * 信息录入人
     * @mbg.generated Sat Apr 20 17:20:54 CST 2019
     */
    private String inputAccUuid;

    /**
     * 信息录入时间
     * @mbg.generated Sat Apr 20 17:20:54 CST 2019
     */
    private Date inputTime;

    /**
     * 回访页面url
     * @mbg.generated Sat Apr 20 17:20:54 CST 2019
     */
    private String visitUrl;

    /**
     * 回访页面短链接url
     * @mbg.generated Sat Apr 20 17:20:54 CST 2019
     */
    private String visitShortUrl;

    /**
     * 通知内容
     * @mbg.generated Sat Apr 20 17:20:54 CST 2019
     */
    private String noticeNote;

    /**
     * 是否启动通知
     * @mbg.generated Sat Apr 20 17:20:54 CST 2019
     */
    private Short isEnableNotice;

    /**
     * 启动通知时间
     * @mbg.generated Sat Apr 20 17:20:54 CST 2019
     */
    private Date noticeTime;

    /**
     * 评价状态（1、草稿，2、待通知，3、待反馈，4、已完成）
     * @mbg.generated Sat Apr 20 17:20:54 CST 2019
     */
    private Short evaluateStatus;

    /**
     * 回访截止时间
     * @mbg.generated Sat Apr 20 17:20:54 CST 2019
     */
    private Date effectiveEndDate;

    public String getEvaluateInfoUuid() {
        return evaluateInfoUuid;
    }

    public void setEvaluateInfoUuid(String evaluateInfoUuid) {
        this.evaluateInfoUuid = evaluateInfoUuid == null ? null : evaluateInfoUuid.trim();
    }

    public String getQuestionnaireUuid() {
        return questionnaireUuid;
    }

    public void setQuestionnaireUuid(String questionnaireUuid) {
        this.questionnaireUuid = questionnaireUuid == null ? null : questionnaireUuid.trim();
    }

    public String getEvaluateName() {
        return evaluateName;
    }

    public void setEvaluateName(String evaluateName) {
        this.evaluateName = evaluateName == null ? null : evaluateName.trim();
    }

    public String getEvaluatePhone() {
        return evaluatePhone;
    }

    public void setEvaluatePhone(String evaluatePhone) {
        this.evaluatePhone = evaluatePhone == null ? null : evaluatePhone.trim();
    }

    public Integer getEvaluateNoticeType() {
        return evaluateNoticeType;
    }

    public void setEvaluateNoticeType(Integer evaluateNoticeType) {
        this.evaluateNoticeType = evaluateNoticeType;
    }

    public String getInputAccUuid() {
        return inputAccUuid;
    }

    public void setInputAccUuid(String inputAccUuid) {
        this.inputAccUuid = inputAccUuid == null ? null : inputAccUuid.trim();
    }

    public Date getInputTime() {
        return inputTime;
    }

    public void setInputTime(Date inputTime) {
        this.inputTime = inputTime;
    }

    public String getVisitUrl() {
        return visitUrl;
    }

    public void setVisitUrl(String visitUrl) {
        this.visitUrl = visitUrl == null ? null : visitUrl.trim();
    }

    public String getVisitShortUrl() {
        return visitShortUrl;
    }

    public void setVisitShortUrl(String visitShortUrl) {
        this.visitShortUrl = visitShortUrl == null ? null : visitShortUrl.trim();
    }

    public String getNoticeNote() {
        return noticeNote;
    }

    public void setNoticeNote(String noticeNote) {
        this.noticeNote = noticeNote == null ? null : noticeNote.trim();
    }

    public Short getIsEnableNotice() {
        return isEnableNotice;
    }

    public void setIsEnableNotice(Short isEnableNotice) {
        this.isEnableNotice = isEnableNotice;
    }

    public Date getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
    }

    public Short getEvaluateStatus() {
        return evaluateStatus;
    }

    public void setEvaluateStatus(Short evaluateStatus) {
        this.evaluateStatus = evaluateStatus;
    }

    public Date getEffectiveEndDate() {
        return effectiveEndDate;
    }

    public void setEffectiveEndDate(Date effectiveEndDate) {
        this.effectiveEndDate = effectiveEndDate;
    }

	public String getEvaluateNickName() {
		return evaluateNickName;
	}

	public void setEvaluateNickName(String evaluateNickName) {
		this.evaluateNickName = evaluateNickName;
	}

	public Date getConsumptionDate() {
		return consumptionDate;
	}

	public void setConsumptionDate(Date consumptionDate) {
		this.consumptionDate = consumptionDate;
	}

	public BigDecimal getConsumptionAmount() {
		return consumptionAmount;
	}

	public void setConsumptionAmount(BigDecimal consumptionAmount) {
		this.consumptionAmount = consumptionAmount;
	}

	public BigDecimal getSurplusAmount() {
		return surplusAmount;
	}

	public void setSurplusAmount(BigDecimal surplusAmount) {
		this.surplusAmount = surplusAmount;
	}

	public Integer getSurplusScore() {
		return surplusScore;
	}

	public void setSurplusScore(Integer surplusScore) {
		this.surplusScore = surplusScore;
	}

	public Integer getSurplusNumber() {
		return surplusNumber;
	}

	public void setSurplusNumber(Integer surplusNumber) {
		this.surplusNumber = surplusNumber;
	}

	public BigDecimal getRechargeAmount() {
		return rechargeAmount;
	}

	public void setRechargeAmount(BigDecimal rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}

	public String getConsumptionItem() {
		return consumptionItem;
	}

	public void setConsumptionItem(String consumptionItem) {
		this.consumptionItem = consumptionItem;
	}
    
}