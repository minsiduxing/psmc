package priv.guochun.psmc.system.enums;

public enum IfEnum {
	YES("是",1),
	NO("否",2);
	private String name;
	private Integer value;
	
	private IfEnum(String name,Integer value){
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
