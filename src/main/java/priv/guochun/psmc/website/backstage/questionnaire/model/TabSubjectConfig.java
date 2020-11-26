package priv.guochun.psmc.website.backstage.questionnaire.model;

import java.io.Serializable;
import java.util.List;

/**
 * 题目配置表
 * @author Administrator
 *
 */
public class TabSubjectConfig implements Serializable{
    /**
     * 主键id
     * @mbg.generated Sat Apr 20 17:20:16 CST 2019
     */
    private String subjectUuid;

    /**
     * 问卷id
     * @mbg.generated Sat Apr 20 17:20:16 CST 2019
     */
    private String questionnaireUuid;

    /**
     * 题目名称
     * @mbg.generated Sat Apr 20 17:20:16 CST 2019
     */
    private String subjectName;

    /**
     * 题目排序
     * @mbg.generated Sat Apr 20 17:20:16 CST 2019
     */
    private Short subjectOrder;

    /**
     * 题目类型（ 1、输入框，2、单选框，3、多选框，4、下拉框，5、文本框，6、星级）
     * @mbg.generated Sat Apr 20 17:20:16 CST 2019
     */
    private Short subjectType;
    
    /**
     * 选项列表
     */
    private List<TabSubjectOptions> optionList;

    public String getSubjectUuid() {
        return subjectUuid;
    }

    public void setSubjectUuid(String subjectUuid) {
        this.subjectUuid = subjectUuid == null ? null : subjectUuid.trim();
    }

    public String getQuestionnaireUuid() {
        return questionnaireUuid;
    }

    public void setQuestionnaireUuid(String questionnaireUuid) {
        this.questionnaireUuid = questionnaireUuid == null ? null : questionnaireUuid.trim();
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName == null ? null : subjectName.trim();
    }

    public Short getSubjectOrder() {
        return subjectOrder;
    }

    public void setSubjectOrder(Short subjectOrder) {
        this.subjectOrder = subjectOrder;
    }

    public Short getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(Short subjectType) {
        this.subjectType = subjectType;
    }

	public List<TabSubjectOptions> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<TabSubjectOptions> optionList) {
		this.optionList = optionList;
	}
}