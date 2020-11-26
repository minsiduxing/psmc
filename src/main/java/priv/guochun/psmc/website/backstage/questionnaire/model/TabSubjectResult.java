package priv.guochun.psmc.website.backstage.questionnaire.model;

import java.io.Serializable;

/**
 * 提交结果记录表
 * @author Administrator
 *
 */
public class TabSubjectResult implements Serializable{
    /**
     * 主键id
     * @mbg.generated Sat Apr 20 17:22:08 CST 2019
     */
    private String resultUuid;

    /**
     * 题目ID
     * @mbg.generated Sat Apr 20 17:22:08 CST 2019
     */
    private String subjectUuid;

    /**
     * 评价信息id
     * @mbg.generated Sat Apr 20 17:22:08 CST 2019
     */
    private String evaluateInfoUuid;

    /**
     * 提交结果（答案）
     * @mbg.generated Sat Apr 20 17:22:08 CST 2019
     */
    private String resultValue;

    public String getResultUuid() {
        return resultUuid;
    }

    public void setResultUuid(String resultUuid) {
        this.resultUuid = resultUuid == null ? null : resultUuid.trim();
    }

    public String getSubjectUuid() {
        return subjectUuid;
    }

    public void setSubjectUuid(String subjectUuid) {
        this.subjectUuid = subjectUuid == null ? null : subjectUuid.trim();
    }

    public String getEvaluateInfoUuid() {
        return evaluateInfoUuid;
    }

    public void setEvaluateInfoUuid(String evaluateInfoUuid) {
        this.evaluateInfoUuid = evaluateInfoUuid == null ? null : evaluateInfoUuid.trim();
    }

    public String getResultValue() {
        return resultValue;
    }

    public void setResultValue(String resultValue) {
        this.resultValue = resultValue == null ? null : resultValue.trim();
    }
}