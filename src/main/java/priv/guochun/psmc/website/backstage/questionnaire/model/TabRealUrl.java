package priv.guochun.psmc.website.backstage.questionnaire.model;

import java.io.Serializable;

public class TabRealUrl implements Serializable{

	private String id;
	
	private String realUrl;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRealUrl() {
		return realUrl;
	}

	public void setRealUrl(String realUrl) {
		this.realUrl = realUrl;
	}
	
}
