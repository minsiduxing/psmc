package priv.guochun.psmc.system.framework.sms.model;

import java.sql.Timestamp;



public class SmsModel {

	
	private Long uuid;	
	private String receiveNo;
	private String receiveCnName;
	private String receiveContext;
	private Timestamp createTime;
	//0短信、1彩信、2个性化短信
	private String sendType;
	private String sendModeSrategy; 
	private String mPath; //彩信资源路径
	private String smsId; //个性化短信模板ID
	
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

	public String getSendType() {
		return sendType;
	}

	public void setSendType(String sendType) {
		this.sendType = sendType;
	}

	public String getmPath() {
		return mPath;
	}

	public void setmPath(String mPath) {
		this.mPath = mPath;
	}

	public String getSendModeSrategy() {
		return sendModeSrategy;
	}

	public void setSendModeSrategy(String sendModeSrategy) {
		this.sendModeSrategy = sendModeSrategy;
	}

	public String getSmsId() {
		return smsId;
	}

	public void setSmsId(String smsId) {
		this.smsId = smsId;
	}
}
