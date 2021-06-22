package priv.guochun.psmc.system.framework.filter.interceptor.model;

import java.util.Date;

import org.apache.cxf.message.Message;

public class VisitModel {

	
	private Message message;
	
	private Date visitDate;
	
	private String clientIp;
	
	private String visitTargetMethod;

	private String targetUri;

	private String basePath;

	//去除文根的基础路径
	private String basePathRaiseRoot;
	//业务路由（排除根路由）
	private String pathToMatchSlash;
	
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

	public String getPathToMatchSlash() {
		return pathToMatchSlash;
	}

	public void setPathToMatchSlash(String pathToMatchSlash) {
		this.pathToMatchSlash = pathToMatchSlash;
	}
	public String getBasePathRaiseRoot() {
		return basePathRaiseRoot;
	}

	public void setBasePathRaiseRoot(String basePathRaiseRoot) {
		this.basePathRaiseRoot = basePathRaiseRoot;
	}
	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
	
}
