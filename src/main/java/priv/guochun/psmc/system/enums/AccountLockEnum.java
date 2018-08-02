package priv.guochun.psmc.system.enums;

public enum AccountLockEnum {
	
	LOCKED("锁定",1),
	NO_LOCKED("未锁定",2);
	
	private String name;
	private Integer value;
	
	private AccountLockEnum(String name,Integer value){
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
