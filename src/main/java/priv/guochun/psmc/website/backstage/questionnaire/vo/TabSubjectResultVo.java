package priv.guochun.psmc.website.backstage.questionnaire.vo;

import java.io.Serializable;
import java.util.List;

import priv.guochun.psmc.website.backstage.questionnaire.model.TabSubjectResult;

public class TabSubjectResultVo implements Serializable{

	private List<TabSubjectResult> resultList;

	public List<TabSubjectResult> getResultList() {
		return resultList;
	}

	public void setResultList(List<TabSubjectResult> resultList) {
		this.resultList = resultList;
	}
}
