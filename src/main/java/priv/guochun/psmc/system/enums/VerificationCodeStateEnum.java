package priv.guochun.psmc.system.enums;

public enum VerificationCodeStateEnum {
	
	NOT_USE("未使用",(long)1),
	BE_USED("已使用",(long)2),
	BE_OVERDUE("已过期",(long)3);

	private String name;
	private Long value;
	
	private VerificationCodeStateEnum(String name,Long value){
		this.name=name;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	
}
