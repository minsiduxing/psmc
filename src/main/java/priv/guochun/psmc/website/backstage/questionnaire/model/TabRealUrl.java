package priv.guochun.psmc.website.backstage.questionnaire.model;

import java.io.Serializable;

public class TabRealUrl implements Serializable{

	private Integer id;
	
	private String realUrl;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRealUrl() {
		return realUrl;
	}

	public void setRealUrl(String realUrl) {
		this.realUrl = realUrl;
	}
	
}
