package priv.guochun.psmc.system.framework.sms.model;

import java.sql.Timestamp;



public class SmsModel {

	
	private Long uuid;	
	private String receiveNo;
	private String receiveCnName;
	private String receiveContext;
	private Timestamp createTime;
	
	public SmsModel(){
		 
	}

	public Long getUuid() {
		return uuid;
	}

	public void setUuid(Long uuid) {
		this.uuid = uuid;
	}

	public String getReceiveNo() {
		return receiveNo;
	}

	public void setReceiveNo(String receiveNo) {
		this.receiveNo = receiveNo;
	}

	public String getReceiveCnName() {
		return receiveCnName;
	}

	public void setReceiveCnName(String receiveCnName) {
		this.receiveCnName = receiveCnName;
	}

	public String getReceiveContext() {
		return receiveContext;
	}

	public void setReceiveContext(String receiveContext) {
		this.receiveContext = receiveContext;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	
	
	 
	 
}
