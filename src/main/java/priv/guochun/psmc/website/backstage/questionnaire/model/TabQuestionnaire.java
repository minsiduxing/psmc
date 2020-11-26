package priv.guochun.psmc.website.backstage.questionnaire.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 问卷表
 * @author Administrator
 *
 */
public class TabQuestionnaire implements Serializable{
    /**
     * 问卷主键
     * @mbg.generated Sat Apr 20 17:18:36 CST 2019
     */
    private String questionnaireUuid;

    /**
     * 问卷名称
     * @mbg.generated Sat Apr 20 17:18:36 CST 2019
     */
    private String questionnaireName;

    /**
     * 问卷版本
     * @mbg.generated Sat Apr 20 17:18:36 CST 2019
     */
    private Short version;

    /**
     * 是否启用（1是，2否）
     * @mbg.generated Sat Apr 20 17:18:36 CST 2019
     */
    private Short isEnable;

    /**
     * 创建人
     * @mbg.generated Sat Apr 20 17:18:36 CST 2019
     */
    private String createPerson;

    /**
     * 创建时间
     * @mbg.generated Sat Apr 20 17:18:36 CST 2019
     */
    private Date createTime;

    public String getQuestionnaireUuid() {
        return questionnaireUuid;
    }

    public void setQuestionnaireUuid(String questionnaireUuid) {
        this.questionnaireUuid = questionnaireUuid == null ? null : questionnaireUuid.trim();
    }

    public String getQuestionnaireName() {
        return questionnaireName;
    }

    public void setQuestionnaireName(String questionnaireName) {
        this.questionnaireName = questionnaireName == null ? null : questionnaireName.trim();
    }

    public Short getVersion() {
        return version;
    }

    public void setVersion(Short version) {
        this.version = version;
    }

    public Short getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Short isEnable) {
        this.isEnable = isEnable;
    }

    public String getCreatePerson() {
        return createPerson;
    }

    public void setCreatePerson(String createPerson) {
        this.createPerson = createPerson == null ? null : createPerson.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}