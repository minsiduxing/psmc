package priv.guochun.psmc.system.framework.sms.model;




public class SjhcSmsModel extends SmsModel{

	private final static String  sjhcSign = "【四季花城】";
	
	
	public SjhcSmsModel(SmsModel smsModel){
	     this.setUuid(smsModel.getUuid());
	     this.setReceiveNo(smsModel.getReceiveNo());
	     this.setReceiveCnName(smsModel.getReceiveCnName());
		 this.setReceiveContext(sjhcSign+smsModel.getReceiveContext());
		 this.setCreateTime(smsModel.getCreateTime());
	}

	
	
	
	 
	 
}
