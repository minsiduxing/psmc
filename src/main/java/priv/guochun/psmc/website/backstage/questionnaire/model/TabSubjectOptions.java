package priv.guochun.psmc.website.backstage.questionnaire.model;

import java.io.Serializable;

/**
 * 题目选项表
 * @author Administrator
 *
 */
public class TabSubjectOptions implements Serializable{
    /**
     * 主键uuid
     * @mbg.generated Sat Apr 20 17:21:30 CST 2019
     */
    private String optionsUuid;

    /**
     * 题目uuid
     * @mbg.generated Sat Apr 20 17:21:30 CST 2019
     */
    private String subjectUuid;

    /**
     * 选项值
     * @mbg.generated Sat Apr 20 17:21:30 CST 2019
     */
    private String optionsValue;

    /**
     * 选项名称
     * @mbg.generated Sat Apr 20 17:21:30 CST 2019
     */
    private String optionsName;
    
    private TabSubjectConfig tabSubjectConfig;

    public String getOptionsUuid() {
        return optionsUuid;
    }

    public void setOptionsUuid(String optionsUuid) {
        this.optionsUuid = optionsUuid == null ? null : optionsUuid.trim();
    }

    public String getSubjectUuid() {
        return subjectUuid;
    }

    public void setSubjectUuid(String subjectUuid) {
        this.subjectUuid = subjectUuid == null ? null : subjectUuid.trim();
    }

    public String getOptionsValue() {
        return optionsValue;
    }

    public void setOptionsValue(String optionsValue) {
        this.optionsValue = optionsValue == null ? null : optionsValue.trim();
    }

    public String getOptionsName() {
        return optionsName;
    }

    public void setOptionsName(String optionsName) {
        this.optionsName = optionsName == null ? null : optionsName.trim();
    }

	public TabSubjectConfig getTabSubjectConfig() {
		return tabSubjectConfig;
	}

	public void setTabSubjectConfig(TabSubjectConfig tabSubjectConfig) {
		this.tabSubjectConfig = tabSubjectConfig;
	}
}