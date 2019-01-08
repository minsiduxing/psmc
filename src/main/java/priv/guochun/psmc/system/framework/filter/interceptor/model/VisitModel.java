package priv.guochun.psmc.system.framework.filter.interceptor.model;

import java.util.Date;

import org.apache.cxf.message.Message;

public class VisitModel {

	
	private Message message;
	
	private Date visitDate;
	
	private String clientIp;
	
	private String visitTargetMethod;

	private String targetUri;
	
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public String getVisitTargetMethod() {
		return visitTargetMethod;
	}

	public void setVisitTargetMethod(String visitTargetMethod) {
		this.visitTargetMethod = visitTargetMethod;
	}

	public String getTargetUri() {
		return targetUri;
	}

	public void setTargetUri(String targetUri) {
		this.targetUri = targetUri;
	}
	
	
	
	
}
