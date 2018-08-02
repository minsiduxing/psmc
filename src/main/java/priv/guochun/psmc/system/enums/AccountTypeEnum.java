package priv.guochun.psmc.system.enums;

public enum AccountTypeEnum {
	
	PC_USER("后台系统账户",1),
	WECHAT_USER("微信订阅号账户",2),
	OTHER_USER("前端网站账户",99);
	
	private String name;
	private Integer value;
	
	private AccountTypeEnum(String name,Integer value){
		this.name=name;
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
}
