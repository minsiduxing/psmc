package priv.guochun.psmc.system.framework.upload.model;

import java.io.Serializable;

/**
 * <p>Title: ftp工具类所需信息封装</p>
 * <p>Description: 包含文件上传的 ip、端口、用户名、密码、路径、操作系统
 * 是否远程上传、</p>
 * <p>Copyright: Copyright ICSS(c) 2017</p>
 * @author <a href="mailTo:18829012118@126.com">wanglei</a>
 * @version 1.0
 * @history:
 * Created by wanglei 2017年8月21日
 */
public class FtpModel implements Serializable {
	private static final long serialVersionUID = 2139339287017878359L;
	/**
	 * 远程IP
	 */
	private String remoteIp;
	/**
	 * 远程端口
	 */
	private String remotePort;
	/**
	 * 远程用户名
	 */
	private String remoteUser;
	/**
	 * 远程密码
	 */
	private String remotePassword;
	/**
	 * 远程路径
	 */
	private String remotePath;
	/**
	 * 远程操作系统
	 */
	private String remoteOs;
	/**
	 * 是否远程上传
	 */
	private String isRemote;
	/**
	 * 上传临时文件夹
	 */
	private String uploadTempDir;
	/**
	 * 下载临时文件夹
	 */
	private String doownLoadTempdir;
	public String getRemoteIp() {
		return remoteIp;
	}
	public void setRemoteIp(String remoteIp) {
		this.remoteIp = remoteIp;
	}
	public String getRemotePort() {
		return remotePort;
	}
	public void setRemotePort(String remotePort) {
		this.remotePort = remotePort;
	}
	public String getRemoteUser() {
		return remoteUser;
	}
	public void setRemoteUser(String remoteUser) {
		this.remoteUser = remoteUser;
	}
	public String getRemotePassword() {
		return remotePassword;
	}
	public void setRemotePassword(String remotePassword) {
		this.remotePassword = remotePassword;
	}
	public String getRemotePath() {
		return remotePath;
	}
	public void setRemotePath(String remotePath) {
		this.remotePath = remotePath;
	}
	public String getRemoteOs() {
		return remoteOs;
	}
	public void setRemoteOs(String remoteOs) {
		this.remoteOs = remoteOs;
	}
	public String getIsRemote() {
		return isRemote;
	}
	
	public FtpModel(String remoteIp, String remotePort, String remoteUser, String remotePassword, String remotePath,
			String remoteOs, String isRemote, String uploadTempDir, String doownLoadTempdir) {
		super();
		this.remoteIp = remoteIp;
		this.remotePort = remotePort;
		this.remoteUser = remoteUser;
		this.remotePassword = remotePassword;
		this.remotePath = remotePath;
		this.remoteOs = remoteOs;
		this.isRemote = isRemote;
		this.uploadTempDir = uploadTempDir;
		this.doownLoadTempdir = doownLoadTempdir;
	}
	public void setIsRemote(String isRemote) {
		this.isRemote = isRemote;
	}
	
	
	public String getUploadTempDir() {
		return uploadTempDir;
	}
	public void setUploadTempDir(String uploadTempDir) {
		this.uploadTempDir = uploadTempDir;
	}
	public String getDoownLoadTempdir() {
		return doownLoadTempdir;
	}
	public void setDoownLoadTempdir(String doownLoadTempdir) {
		this.doownLoadTempdir = doownLoadTempdir;
	}
	public FtpModel() {
		super();
	}
	
}
